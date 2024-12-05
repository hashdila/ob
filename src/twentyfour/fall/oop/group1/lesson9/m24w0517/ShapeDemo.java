package twentyfour.fall.oop.group1.lesson9.m24w0517;


abstract class Shape {
    public abstract double calculateArea();
    public abstract double calculatePerimeter();
}


class Rectangle extends Shape {
    private double length;
    private double width;


    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }


    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }
}


class Circle extends Shape {
    private double radius;


    public Circle(double radius) {
        this.radius = radius;
    }


    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}


public class ShapeDemo {
    public static void main(String[] args) {

        Shape rectangle = new Rectangle(5.0, 3.0);
        Shape circle = new Circle(4.0);


        System.out.println("Rectangle Area: " + rectangle.calculateArea());
        System.out.println("Rectangle Perimeter: " + rectangle.calculatePerimeter());
        System.out.println("Circle Area: " + circle.calculateArea());
        System.out.println("Circle Perimeter: " + circle.calculatePerimeter());

        Shape[] shapes = {rectangle, circle};
        for (Shape shape : shapes) {
            System.out.println("Shape Area: " + shape.calculateArea());
            System.out.println("Shape Perimeter: " + shape.calculatePerimeter());
        }
    }
}
