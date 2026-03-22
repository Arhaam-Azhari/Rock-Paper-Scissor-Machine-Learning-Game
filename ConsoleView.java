/**
 * Assignment 4 - Rock Paper Scissors
 * Course: CS151
 *
 * Team 20k6
 * Members:
 * Arhaam Azhari
 * Khushi Bakshi
 * Toby Chan
 * Marco Shifflette
 *
 * Description:
 * Handles all console output for the Rock-Paper-Scissors game.
 */
public class ConsoleView {

    public void showWelcomeMessage() {
        System.out.println("Welcome to Rock-Paper-Scissors!");
    }

    public void showAlgorithmMode(String mode) {
        if (mode.equalsIgnoreCase("-m")) {
            System.out.println("Computer algorithm: Machine Learning");
        } else {
            System.out.println("Computer algorithm: Random");
        }
    }

    public void showRoundPrompt(int roundNumber) {
        System.out.print("Round " + roundNumber + " - Choose (1=rock, 2=paper, 3=scissors): ");
    }

    public void showRoundResult(Move humanMove, Move computerMove, RoundResult result) {
        System.out.print("You chose " + humanMove + ". ");
        System.out.print("The computer chose " + computerMove + ". ");

        if (result == RoundResult.HUMAN_WIN) {
            System.out.println("Human Wins!");
        } else if (result == RoundResult.COMPUTER_WIN) {
            System.out.println("Computer Wins!");
        } else {
            System.out.println("Draw!");
        }
    }

    public void showScore(int humanScore, int computerScore, int drawCount) {
        System.out.println("Score: Human:" + humanScore
                + " Computer:" + computerScore
                + " Draws=" + drawCount);
    }

    public void showFinalResults(int humanScore, int computerScore, int drawCount) {
        System.out.println("\nGame Over!");
        System.out.println("Final Score: Human:" + humanScore
                + " Computer:" + computerScore
                + " Draws=" + drawCount);

        if (humanScore > computerScore) {
            System.out.println("Overall Winner: Human");
        } else if (computerScore > humanScore) {
            System.out.println("Overall Winner: Computer");
        } else {
            System.out.println("Overall Result: Tie");
        }
    }
}