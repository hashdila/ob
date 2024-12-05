package twentyfour.fall.oop.group1.lesson8.m24w0517;

/**
 * Id: M24W0517
 * Name: Dilan Nawarthna
 * Assignment: KCGI/OOP
 * Note for professor: -
 */

public class Koi extends Animal {
    private String color;
    private String name;

    public Koi(String name, int age, boolean isWild, String color) {
        super(name, age, isWild);
        this.color = color;
    }

    @Override
    public void makeSound() {
        System.out.println(  "The Koi swims gracefully.");
    }

    public void swim() {
        System.out.println("The Koi swims in the pond.");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Color: " + color);
    }
}
