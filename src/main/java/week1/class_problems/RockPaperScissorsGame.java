package week1.class_problems;

import java.util.Random;

public class RockPaperScissorsGame {

    private static final String[] MOVES = {"Rock", "Paper", "Scissors"};
    private static final Random RANDOM = new Random();

    static String getComputerMove() {
        return MOVES[RANDOM.nextInt(3)];
    }

    static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }
        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
                (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
                (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        }
        return "Computer Wins";
    }

    public static void main(String[] args) {
        String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        int wins = 0;
        int losses = 0;
        int draws = 0;

        System.out.printf("%-10s | %-12s | %-14s | %-15s%n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("---------------------------------------------------------");

        for (int i = 0; i < playerMoves.length; i++) {
            String player = playerMoves[i];
            String computer = getComputerMove();
            String result = playRound(player, computer);

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }

            System.out.printf("%-10s | %-12s | %-14s | %-15s%n", "Round " + (i + 1), player, computer, result);
        }

        double winPercentage = ((double) wins / playerMoves.length) * 100;
        System.out.println("---------------------------------------------------------");
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n", wins, losses, draws, winPercentage);
    }
}