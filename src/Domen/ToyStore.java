package Domen;


import java.io.*;
import java.util.*;

public class ToyStore {
    private List<Toy> toys = new ArrayList<>();
    private File logFile = new File("log.txt");

    /**
     * 
     */
    public ToyStore() {
    }

    /**перед началом работы необходимо загрузить ф программу из файла список игрушек по форме
     * образец будет указан в read.me
     * 
     */
    public void loadToys() {
        String fileName = "toys.txt";
        try (Scanner scanner = new Scanner(new File(fileName))) {//парсим строки из файла для работы метода
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
        System.out.println("Toys loaded from file");
    }
    public void addToy(String name, int probability, int quantity) {//добавлять новые игрушки можно 
        //в консоли во время работы, а не только через файл
        int id = getNextId();
        Toy toy = new Toy(name, id, probability, quantity);
        toys.add(toy);
        log("New toy added: " + toy.getName() + ", ID: " + toy.getId());
        System.out.println("Toy "+ toy.getName()+" addiction");
    }

    public void removeToy(int id) {
        Iterator<Toy> iterator = toys.iterator();
        while (iterator.hasNext()) {
            Toy toy = iterator.next();
            if (toy.getId() == id) {
                iterator.remove();
                log("Toy removed: " + toy.getName() + ", ID: " + toy.getId());
                System.out.println("Toy "+toy.getName()+" removed");
                break;
            }
        }
    }

    public void removeAllToys() {
        toys.clear();
        log("All toys removed");
        System.out.println("All toys removed");
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
            System.out.println("No winner((");
        } else {
            int winningId = winningIds.get(new Random().nextInt(winningIds.size()));
            for (Toy toy : toys) {
                if (toy.getId() == winningId) {
                    int quantity = toy.getQuantity();
                    if (quantity > 0) {
                        toy.setQuantity(quantity - 1);
                        log("Toy won: " + toy.getName() + ", ID: " + toy.getId());
                        System.out.println("Toy "+toy.getName()+" won! Congratulation!");
                    } else {
                        log("Toy won but out of stock: " + toy.getName() + ", ID: " + toy.getId());
                    }
                    break;
                }
            }
        }
    }
    public void show(){
        for(Toy toy:toys){
            System.out.println(toy.toString());
            log("Show contain: " + toy.toString());
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
