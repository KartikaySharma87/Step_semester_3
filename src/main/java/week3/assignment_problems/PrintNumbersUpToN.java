package week3.assignment_problems;

public class PrintNumbersUpToN {
    public static void printNumbersUpToN(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        printNumbersUpToN(5);
    }
}