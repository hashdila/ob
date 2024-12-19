package twentyfour.fall.oop.group1.finalassigment.m24w0517.Service;


import twentyfour.fall.oop.group1.finalassigment.m24w0517.model.Bakery;
import twentyfour.fall.oop.group1.finalassigment.m24w0517.model.Inventory;
import twentyfour.fall.oop.group1.finalassigment.m24w0517.model.Order;

public class BakeryService {
    private FileHandler fileHandler = new FileHandler();

    public void addItem(Bakery bakery, String name, int quantity, double price) {
        Inventory newItem = new Inventory(name, quantity, price);
        bakery.addInventoryItem(newItem);
        fileHandler.saveInventoryToFile(bakery.getInventoryList());
        System.out.println("Item added to inventory and saved to file.");
    }

    public void loadInventory(Bakery bakery) {
        bakery.getInventoryList().clear();
        bakery.getInventoryList().addAll(fileHandler.loadInventoryFromFile());
    }



    public void placeOrder(Bakery bakery, String customerName, String itemName, int quantity) {
        for (Inventory item : bakery.getInventoryList()) {
            if (item.getItemName().equals(itemName) && item.getQuantity() >= quantity) {
                item.setQuantity(item.getQuantity() - quantity);
                bakery.addOrder(new Order(customerName, itemName, quantity));
                System.out.println("Order placed successfully!");
                return;
            }
        }
        System.out.println("Item not available or insufficient quantity.");
    }

    public void displayInventory(Bakery bakery) {
        System.out.println("Inventory for Bakery: " + bakery.getName());
        for (Inventory item : bakery.getInventoryList()) {
            System.out.println(item.getItemName() + " - " + item.getQuantity() + " available $ " + item.getPrice());
        }
    }
    public void addOrder(Bakery bakery, String customerName, String itemName, int quantity) {
        // Find the item in inventory
        Inventory item = bakery.getInventoryList().stream()
                .filter(inventoryItem -> inventoryItem.getItemName().equalsIgnoreCase(itemName))
                .findFirst()
                .orElse(null);

        if (item != null && item.getQuantity() >= quantity) {
            double totalPrice = item.getPrice() * quantity;

            // Display total price to the customer
            System.out.printf("Total Price for %d x %s: %.2f\n", quantity, itemName, totalPrice);

            // Confirm the order
            System.out.println("Do you want to confirm this order? (yes/no): ");
            String confirmation = new java.util.Scanner(System.in).nextLine();

            if (confirmation.equalsIgnoreCase("yes")) {
                Order order = new Order(customerName, itemName, quantity);

                // Deduct quantity from inventory
                item.setQuantity(item.getQuantity() - quantity);

                // Save updated inventory and invoice
                fileHandler.saveInventoryToFile(bakery.getInventoryList());
                fileHandler.saveOrderToFile(order,totalPrice);


                System.out.println("Order confirmed! Invoice has been saved.");
            } else {
                System.out.println("Order cancelled.");
            }
        } else {
            System.out.println("Insufficient inventory for item: " + itemName);
        }
    }
}
