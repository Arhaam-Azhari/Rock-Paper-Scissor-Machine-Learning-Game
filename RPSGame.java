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
 */
import java.util.Scanner;

/**
 * Controls the overall game flow for Rock-Paper-Scissors.
 */
public class RPSGame {
    private static final int TOTAL_ROUNDS = 20;

    private HumanPlayer humanPlayer;
    private ComputerPlayer computerPlayer;
    private GameRules rules;
    private ConsoleView view;
    private String mode;

    private int humanScore;
    private int computerScore;
    private int drawCount;

    public RPSGame(String mode) {
        this.mode = mode;
        Scanner scanner = new Scanner(System.in);
        humanPlayer = new HumanPlayer("Human", scanner);
        computerPlayer = new ComputerPlayer("Computer", ChoiceAlgorithmFactory.createChoiceAlgorithm(mode));
        rules = new GameRules();
        view = new ConsoleView();

        humanScore = 0;
        computerScore = 0;
        drawCount = 0;
    }

    /**
     * Runs the full 20-round game.
     */
    public void playGame() {
        view.showWelcomeMessage();
        view.showAlgorithmMode(mode);

        for (int round = 1; round <= TOTAL_ROUNDS; round++) {
            playRound(round);
        }

        printFinalResults();
    }

    /**
     * Plays one round and updates the running score.
     */
    private void playRound(int roundNumber) {
        view.showRoundPrompt(roundNumber);

        Move humanMove = humanPlayer.chooseMove();
        Move computerMove = computerPlayer.chooseMove();
        RoundResult result = rules.determineResult(humanMove, computerMove);

        // Record the completed round after both moves are known
        computerPlayer.recordRound(humanMove, computerMove);

        view.showRoundResult(humanMove, computerMove, result);

        if (result == RoundResult.HUMAN_WIN) {
            humanScore++;
        } else if (result == RoundResult.COMPUTER_WIN) {
            computerScore++;
        } else {
            drawCount++;
        }

        view.showScore(humanScore, computerScore, drawCount);
    }

    /**
     * Prints the final score after all rounds are complete.
     */
    private void printFinalResults() {
        view.showFinalResults(humanScore, computerScore, drawCount);
        computerPlayer.saveLearningData();
    }
}