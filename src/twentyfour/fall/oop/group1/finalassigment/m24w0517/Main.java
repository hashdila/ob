package twentyfour.fall.oop.group1.finalassigment.m24w0517;



import twentyfour.fall.oop.group1.finalassigment.m24w0517.Service.BakeryService;
import twentyfour.fall.oop.group1.finalassigment.m24w0517.model.Bakery;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BakeryService bakeryService = new BakeryService();
        Bakery bakery = new Bakery("Central Bakery");

        while (true) {
            System.out.println("\n=== Bakery Management System ===");
            System.out.println("1. Add Item to Inventory");
            System.out.println("2. Place an Order");
            System.out.println("3. Display Inventory");
            System.out.println("4. Exit");
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
                    System.out.print("Enter customer name: ");
                    String customerName = scanner.next();
                    System.out.print("Enter item name: ");
                    String itemName = scanner.next();
                    System.out.print("Enter quantity: ");
                    int orderQuantity = scanner.nextInt();
                    bakeryService.placeOrder(bakery, customerName, itemName, orderQuantity);
                    break;
                case 3:
                    bakeryService.displayInventory(bakery);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }
}
