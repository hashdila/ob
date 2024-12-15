package twentyfour.fall.oop.group1.finalassigment.m24w0517.model;



import java.util.ArrayList;
import java.util.List;

public class Bakery {
    private String name;
    private List<Inventory> inventoryList;
    private List<Order> orderList;

    public Bakery(String name) {
        this.name = name;
        this.inventoryList = new ArrayList<>();
        this.orderList = new ArrayList<>();
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public List<Inventory> getInventoryList() {
        return inventoryList;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void addInventoryItem(Inventory item) {
        inventoryList.add(item);
    }

    public void addOrder(Order order) {
        orderList.add(order);
    }
}

