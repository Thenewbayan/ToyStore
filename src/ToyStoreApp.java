import java.util.Scanner;

import Domen.ToyStore;

public class ToyStoreApp {
    private static Scanner scanner = new Scanner(System.in);
    private static ToyStore toyStore = new ToyStore();

    public static void main(String[] args) {
        System.out.println("Toy Store");
        System.out.println("---------");
        while (true) {
            System.out.println();
            System.out.println("1. Load toys from file");
            System.out.println("2. Add new toy");
            System.out.println("3. Remove toy");
            System.out.println("4. Remove all toys");
            System.out.println("5. Play");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // System.out.print("Enter file name: ");
                    // String fileName = scanner.nextLine();
                    toyStore.loadToys("toys.txt");
                    break;
                case 2:
                    System.out.print("Enter toy name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter probability of winning (0-100): ");
                    int probability = scanner.nextInt();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();
                    toyStore.addToy(name, probability, quantity);
                    break;
                case 3:
                    System.out.print("Enter ID of toy to remove: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    toyStore.removeToy(id);
                    break;
                case 4:
                    toyStore.removeAllToys();
                    break;
                case 5:
                    toyStore.play();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
    
