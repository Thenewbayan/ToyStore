package Domen;


import java.io.*;
import java.util.*;

public class ToyStore {
    private List<Toy> toys = new ArrayList<>();
    private File logFile = new File("log.txt");

    public ToyStore() {
    }

    public void loadToys(String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(",");
                String name = parts[0];
                int id = Integer.parseInt(parts[1]);
                int probability = Integer.parseInt(parts[2]);
                int quantity = Integer.parseInt(parts[3]);
                Toy toy = new Toy(name, id, probability, quantity);
                toys.add(toy);
            }
            log("Toys loaded from file: " + fileName);
        } catch (FileNotFoundException e) {
            log("Error loading toys: " + e.getMessage());
        }
    }

    public void addToy(String name, int probability, int quantity) {
        int id = getNextId();
        Toy toy = new Toy(name, id, probability, quantity);
        toys.add(toy);
        log("New toy added: " + toy.getName() + ", ID: " + toy.getId());
    }

    public void removeToy(int id) {
        Iterator<Toy> iterator = toys.iterator();
        while (iterator.hasNext()) {
            Toy toy = iterator.next();
            if (toy.getId() == id) {
                iterator.remove();
                log("Toy removed: " + toy.getName() + ", ID: " + toy.getId());
                break;
            }
        }
    }

    public void removeAllToys() {
        toys.clear();
        log("All toys removed");
    }

    public void play() {
        List<Integer> winningIds = new ArrayList<>();
        for (Toy toy : toys) {
            int random = new Random().nextInt(100) + 1;
            if (random <= toy.getProbability()) {
                winningIds.add(toy.getId());
            }
        }
        if (winningIds.isEmpty()) {
            log("No toys won");
        } else {
            int winningId = winningIds.get(new Random().nextInt(winningIds.size()));
            for (Toy toy : toys) {
                if (toy.getId() == winningId) {
                    int quantity = toy.getQuantity();
                    if (quantity > 0) {
                        toy.setQuantity(quantity - 1);
                        log("Toy won: " + toy.getName() + ", ID: " + toy.getId());
                    } else {
                        log("Toy won but out of stock: " + toy.getName() + ", ID: " + toy.getId());
                    }
                    break;
                }
            }
        }
    }

    private int getNextId() {
        int maxId = 0;
        for (Toy toy : toys) {
            if (toy.getId() > maxId) {
                maxId = toy.getId();
            }
        }
        return maxId + 1;
    }

    private void log(String message) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(logFile, true))) {
            writer.println(new Date() + ": " + message);
        } catch (IOException e) {
            System.out.println("Error logging message: " + e.getMessage());
        }
    }
}
