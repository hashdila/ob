package twentyfour.fall.oop.group1.finalassigment.m24w0517;

import twentyfour.fall.oop.group1.finalassigment.m24w0517.Service.BakeryService;
import twentyfour.fall.oop.group1.finalassigment.m24w0517.model.Bakery;




import java.util.Scanner;

public class Main {
    private static final String ADMIN_PASSWORD = "admin";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BakeryService bakeryService = new BakeryService();
        Bakery bakery = new Bakery("Central Bakery");

        // Load inventory data from file at the start
        bakeryService.loadInventory(bakery);

        while (true) {
            System.out.println("\n=== Welcome to Bakery Management System ===");
            System.out.println("1. Admin Login");
            System.out.println("2. Customer");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int userTypeChoice = scanner.nextInt();

            if (userTypeChoice == 1) {
                if (adminLogin(scanner)) {
                    adminMenu(scanner, bakeryService, bakery);
                } else {
                    System.out.println("Invalid password! Returning to main menu.");
                }
            } else if (userTypeChoice == 2) {
                customerMenu(scanner, bakeryService, bakery);
            } else if (userTypeChoice == 3) {
                System.out.println("Exiting the system. Goodbye!");
                scanner.close();
                return;
            } else {
                System.out.println("Invalid option! Please try again.");
            }
        }
    }

    private static boolean adminLogin(Scanner scanner) {
        System.out.print("Enter Admin Password: ");
        String inputPassword = scanner.next();
        return ADMIN_PASSWORD.equals(inputPassword);
    }

    private static void adminMenu(Scanner scanner, BakeryService bakeryService, Bakery bakery) {
        while (true) {
            System.out.println("\n=== Admin Menu ===");
            System.out.println("1. Add Item to Inventory");
            System.out.println("2. Display Inventory");
            System.out.println("3. Return to Main Menu");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String name = scanner.next();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    bakeryService.addItem(bakery, name, quantity, price);
                    break;
                case 2:
                    bakeryService.displayInventory(bakery);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }

    private static void customerMenu(Scanner scanner, BakeryService bakeryService, Bakery bakery) {
        while (true) {
            System.out.println("\n=== Customer Menu ===");
            System.out.println("1. Place an Order");
            System.out.println("2. Display Available Inventory");
            System.out.println("3. Return to Main Menu");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    bakeryService.displayInventory(bakery);
                    System.out.print("Enter your name: ");
                    String customerName = scanner.next();
                    System.out.print("Enter item name: ");
                    String itemName = scanner.next();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    bakeryService.addOrder(bakery, customerName, itemName, quantity);
                    break;
                case 2:
                    bakeryService.displayInventory(bakery);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }
}
