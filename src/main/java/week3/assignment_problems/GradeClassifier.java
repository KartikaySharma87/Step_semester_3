package week3.assignment_problems;

public class GradeClassifier {
    public static void classifyWithAttendance(int marks, int attendance) {
        if (attendance >= 75 && marks >= 40) {
            if (marks >= 90) {
                System.out.println("Grade: A");
            } else if (marks >= 75) {
                System.out.println("Grade: B");
            } else if (marks >= 50) {
                System.out.println("Grade: C");
            } else {
                System.out.println("Grade: D");
            }
        } else {
            System.out.println("Detained");
        }
    }

    public static void main(String[] args) {
        classifyWithAttendance(82, 80);
        classifyWithAttendance(91, 60);
    }
}