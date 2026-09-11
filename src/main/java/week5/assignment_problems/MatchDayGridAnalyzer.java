package week5.assignment_problems;

public class MatchDayGridAnalyzer {

    private static double rowAverage(int[] row) {
        if (row.length == 0) return 0.0;

        double sum = 0;
        for (int runs : row) {
            sum += runs;
        }
        return sum / row.length;
    }

    static String classifyMatches(int[][] runsPerOver, int threshold) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < runsPerOver.length; i++) {
            double avg = rowAverage(runsPerOver[i]);
            String status = (avg >= threshold) ? "Power Surge" : "Normal";

            result.append("Match ").append(i).append(": ").append(status);
            if (i < runsPerOver.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int[][] grid = {
                {4, 6, 8},
                {10, 12, 14},
                {2, 3, 1}
        };
        int threshold = 8;
        System.out.println(classifyMatches(grid, threshold));
    }
}