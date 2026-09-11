package week1.class_problems;

public class PalindromeChecker {

    static boolean isPalindromeIterative(String text) {
        int left = 0;
        int right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    static boolean isPalindromeRecursive(String text) {
        if (text.length() <= 1) {
            return true;
        }
        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    static boolean isPalindromeArrayReversal(String text) {
        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];
        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }
        return text.equals(new String(reversed));
    }

    public static void main(String[] args) {
        String[] testInputs = {"madam", "hello"};

        for (String input : testInputs) {
            String iterRes = isPalindromeIterative(input) ? "Palindrome" : "Not Palindrome";
            String recRes = isPalindromeRecursive(input) ? "Palindrome" : "Not Palindrome";
            String revRes = isPalindromeArrayReversal(input) ? "Palindrome" : "Not Palindrome";

            System.out.println("Input: " + input);
            System.out.println("Iterative: " + iterRes + " | Recursive: " + recRes + " | Array Reversal: " + revRes);
            System.out.println();
        }
    }
}
