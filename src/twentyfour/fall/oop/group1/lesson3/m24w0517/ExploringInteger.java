package twentyfour.fall.oop.group1.lesson3.m24w0517;

//Dilan Nawarathna
//M24W0517

import java.util.Random;

public class ExploringInteger {

    // Declaring constants for special ASCII characters
    public static final String PLUS_MINUS_SYMBOL = "±";
    public static final String HALF_SYMBOL = "½";
    public static final String ONE_QUARTER_SYMBOL = "¼";

    public static void main(String[] args) {

        //  Calculate integer range using increment/decrement operators
        int maxValue = 0;
        int minValue = 0;

        // Incrementing maxValue
        while (maxValue >= 0) {
            maxValue++;
        }

        // Decrementing minValue
        while (minValue <= 0) {
            minValue--;
        }



        // Calculate ¼ and ½ of the range
        long range = (long) maxValue - minValue;
        long quarterRange = range / 4;
        long halfRange = range / 2;

        // Generating a random number within the range
        Random random = new Random();
        int randomValue = random.nextInt(maxValue - minValue) + minValue;  // Random value within the range

        //  results
        System.out.println("The range of the integer data type is approximately " + PLUS_MINUS_SYMBOL + range + ".");
        System.out.println("The " + ONE_QUARTER_SYMBOL + " of this range is: " + PLUS_MINUS_SYMBOL + quarterRange + ".");
        System.out.println("The " + HALF_SYMBOL + " of this range is: " + PLUS_MINUS_SYMBOL + halfRange + ".");
        System.out.println("A random value within this range: " + PLUS_MINUS_SYMBOL + randomValue + ".");
    }
}