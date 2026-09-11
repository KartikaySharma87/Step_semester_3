package week5.class_problems;

public class HackathonSeatingGridOptimizer {

    private static double rowAverage(int[] row) {
        if (row.length == 0) return 0.0;

        double sum = 0;
        for (int score : row) {
            sum += score;
        }
        return sum / row.length;
    }

    static String classifyRows(int[][] seatingScores, int threshold) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < seatingScores.length; i++) {
            double avg = rowAverage(seatingScores[i]);
            String status = (avg >= threshold) ? "Buzzing Zone" : "Quiet Zone";

            result.append("Row ").append(i).append(": ").append(status);
            if (i < seatingScores.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int[][] seating = {
                {40, 50, 45},
                {85, 90, 95},
                {30, 20, 25}
        };
        int threshold = 60;
        System.out.println(classifyRows(seating, threshold));
    }
}