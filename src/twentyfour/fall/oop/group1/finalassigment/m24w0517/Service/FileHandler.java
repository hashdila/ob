package twentyfour.fall.oop.group1.finalassigment.m24w0517.Service;

import twentyfour.fall.oop.group1.finalassigment.m24w0517.model.Inventory;
import twentyfour.fall.oop.group1.finalassigment.m24w0517.model.Order;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FileHandler {
    private static final String INVENTORY_FOLDER = "inventory/";
    private static final String INVENTORY_FILE = INVENTORY_FOLDER + "inventory.txt";
    private static final String INVOICE_FOLDER = "invoices/";

    public FileHandler() {
        File inventoryFolder = new File(INVENTORY_FOLDER);
        if (!inventoryFolder.exists()) {
            inventoryFolder.mkdir(); // Create the inventory folder if it doesn't exist
        }

        File invoiceFolder = new File(INVOICE_FOLDER);
        if (!invoiceFolder.exists()) {
            invoiceFolder.mkdir(); // Create the invoices folder if it doesn't exist
        }
    }

    // Save inventory list to file
    public void saveInventoryToFile(List<Inventory> inventoryList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(INVENTORY_FILE))) {
            for (Inventory item : inventoryList) {
                writer.write(item.getItemName() + "," + item.getQuantity() + "," + item.getPrice());
                writer.newLine();
            }
            System.out.println("Inventory saved to file successfully!");
        } catch (IOException e) {
            System.out.println("Error saving inventory to file: " + e.getMessage());
        }
    }

    // Load inventory list from file
    public List<Inventory> loadInventoryFromFile() {
        List<Inventory> inventoryList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(INVENTORY_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String itemName = parts[0];
                    int quantity = Integer.parseInt(parts[1]);
                    double price = Double.parseDouble(parts[2]);
                    inventoryList.add(new Inventory(itemName, quantity, price));
                }
            }
            System.out.println("Inventory loaded from file successfully!");
        } catch (FileNotFoundException e) {
            System.out.println("No inventory file found. Starting fresh.");
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading inventory from file: " + e.getMessage());
        }
        return inventoryList;
    }

    // Save order invoice to a separate file
    public void saveOrderToFile(Order order, double totalPrice) {
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String fileName = INVOICE_FOLDER + "Invoice_" + order.getCustomerName() + "_" + timestamp + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Invoice for " + order.getCustomerName() + "\n");
            writer.write("Item: " + order.getItemName() + "\n");
            writer.write("Quantity: " + order.getQuantity() + "\n");
            writer.write(String.format("Total Price: %.2f\n", totalPrice));
            writer.write("Date: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\n");
            System.out.println("Order invoice saved to file: " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving order invoice: " + e.getMessage());
        }
    }
}
