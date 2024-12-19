package twentyfour.fall.oop.group1.lesson10.m24w0517;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileWritingExample {
    public static void main(String[] args) {

        String fileName = "class_notes.txt";

        String message = "Hello, this is a class activity.  ";


        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String timestamp = dtf.format(now);


        String contentToWrite = message + "\nWritten at: " + timestamp;


        try (FileWriter fileWriter = new FileWriter(fileName, true)) { // 'true' for append mode
            fileWriter.write(contentToWrite + "\n");
            System.out.println("Content written successfully to " + fileName);
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }
}
