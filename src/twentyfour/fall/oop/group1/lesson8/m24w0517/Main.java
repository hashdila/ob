package twentyfour.fall.oop.group1.lesson8.m24w0517;


public class Main {
    public static void main(String[] args) {
        // Create instances of Koi and Crane
        Koi koi = new Koi("Kinta", 5, false, "Red");
        Crane crane = new Crane("Yuki", 7, true, 220);

        // Create a Zoo object
        Zoo zoo = new Zoo();

        // Add animals to the zoo
        zoo.addAnimal(koi);
        zoo.addAnimal(crane);

        // Display all animals' info
        System.out.println("Displaying all animals in the zoo:");
        zoo.displayAllAnimals();

        // Make all animals make sound
        System.out.println("\nMaking all animals make sounds:");
        zoo.makeAllAnimalsMakeSound();

        // Demonstrate specific behaviors
        System.out.println("\nDemonstrating specific behaviors:");
        koi.swim();
        crane.dance();
    }
}
