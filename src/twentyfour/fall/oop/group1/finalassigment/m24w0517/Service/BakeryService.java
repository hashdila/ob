package twentyfour.fall.oop.group1.finalassigment.m24w0517.Service;


import twentyfour.fall.oop.group1.finalassigment.m24w0517.model.Bakery;
import twentyfour.fall.oop.group1.finalassigment.m24w0517.model.Inventory;
import twentyfour.fall.oop.group1.finalassigment.m24w0517.model.Order;

public class BakeryService {

    public void addItem(Bakery bakery, String name, int quantity, double price) {
        bakery.addInventoryItem(new Inventory(name, quantity, price));
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
            System.out.println(item.getItemName() + " - " + item.getQuantity() + " available @ " + item.getPrice());
        }
    }
}
