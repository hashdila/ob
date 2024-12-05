package twentyfour.fall.oop.group1.lesson9.m24w0517;

public class School {


    private String schoolName;


    public School(String schoolName) {
        this.schoolName = schoolName;
    }


    public Student createStudent(String name, String grade) {
        return new Student(name, grade);
    }

    //  Student inner class
    private class Student {
        private String name;
        private String grade;


        private Student(String name, String grade) {
            this.name = name;
            this.grade = grade;
        }

        // Method to display student information
        public void displayStudentInfo() {
            System.out.println("School Name: " + schoolName);
            System.out.println("Student Name: " + name);
            System.out.println("Grade: " + grade);
        }
    }


    public static void main(String[] args) {

        School school = new School("KCGI");
        School.Student student = school.createStudent("Alice", "A");
        student.displayStudentInfo();
    }
}

