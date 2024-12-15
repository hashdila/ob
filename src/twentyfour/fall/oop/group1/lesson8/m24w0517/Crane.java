package twentyfour.fall.oop.group1.lesson8.m24w0517;

/**
 * Id: M24W0517
 * Name: Dilan Nawarthna
 * Assignment: KCGI/OOP
 * Note for professor: -
 */

public class Crane extends Animal {
    private int wingspan;

    public Crane(String name, int age, boolean isWild, int wingspan) {
        super(name, age, isWild);
        this.wingspan = wingspan;
    }

    @Override
    public void makeSound() {
        System.out.println("Karu! Karu!");
    }

    public void dance() {
        System.out.println("The crane dances in the wind.");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Wingspan: " + wingspan + " cm");
    }
}
