package twentyfour.fall.oop.group1.lesson5.m24w0517;

/**
 * Id: M24W0517
 * Name: Dilan Nawarthna
 * Assignment: KCGI/OOP
 * Note for professor: -
 */



/**Lecture feedback
 *
 No method overloading implemented.
 */

import java.util.Scanner;

public class SimpleCalculator {

    //  addition Part
    public static int add(int a, int b) {
        return a + b;
    }

    //  subtraction Part
    public static int subtract(int a, int b) {
        return a - b;
    }

    //  multiplication part
    public static int multiply(int a, int b) {
        return a * b;
    }

    // Method for division with error handling for division by zero
    public static int divide(int a, int b) {
        if (b == 0) {
            System.out.println("Error: Division by zero is not allowed.");
            return 0;
        }
        return a / b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueCalculating = true;


        while (continueCalculating) {

            System.out.println("Choose an operation:");
            System.out.println("1: Add");
            System.out.println("2: Subtract");
            System.out.println("3: Multiply");
            System.out.println("4: Divide");
            System.out.println("0: Exit");

            int choice = scanner.nextInt();

            // Exit option
            if (choice == 0) {
                System.out.println("Exiting calculator.");
                continueCalculating = false;
                continue;
            }

            // Input numbers
            System.out.print("Enter first number: ");
            int num1 = scanner.nextInt();
            System.out.print("Enter second number: ");
            int num2 = scanner.nextInt();

            int result = 0;

            // Perform chosen operation
            switch (choice) {
                case 1:
                    result = add(num1, num2);
                    break;
                case 2:
                    result = subtract(num1, num2);
                    break;
                case 3:
                    result = multiply(num1, num2);
                    break;
                case 4:
                    result = divide(num1, num2);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    continue;
            }

            //print result

            System.out.println("Result: " + result);
        }

        scanner.close();
    }
}