package twentyfour.fall.oop.group1.lesson8.m24w0517;



public class Animal {
    private String name;
    private int age;
    private boolean isWild;

    public Animal(String name, int age, boolean isWild) {
        this.name = name;
        this.age = age;
        this.isWild = isWild;
    }

    public void makeSound() {
        // To be overridden by subclasses
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Wild: " + (isWild ? "Yes" : "No"));
    }

    // Getters and setters can be added here if needed
}
