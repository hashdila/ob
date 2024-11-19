package twentyfour.fall.oop.group1.lesson1.m24w0517;
// M24W0517 Dilan Nawarathna

import java.util.Scanner;

public class TriangularPrismSurfaceArea {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter the base of the triangular face: ");
        double base = scanner.nextDouble();

        System.out.print("Enter the height of the triangular face: ");
        double height = scanner.nextDouble();

        System.out.print("Enter the length of the prism: ");
        double length = scanner.nextDouble();

        // Triangular prism surface area = [2*(base * height)/2 + 3 (base* length)]

        double surfaceArea = 2*(base * height)/2 + 3 * (base * length);

        System.out.println("Triangular prism surface area is: " + surfaceArea);

        scanner.close();
    }
}

