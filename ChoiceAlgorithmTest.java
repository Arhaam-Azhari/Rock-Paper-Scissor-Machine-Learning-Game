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
 * Basic test class for ChoiceAlgorithm implementations.
 * Verifies that both Random and ML algorithms return valid moves.
 */
public class ChoiceAlgorithmTest {

    public static void main(String[] args) {
        testRandomAlgorithm();
        testMLAlgorithm();
    }

    private static void testRandomAlgorithm() {
        ChoiceAlgorithm randomAlgo = new RandomChoiceAlgorithm();

        boolean valid = true;

        for (int i = 0; i < 20; i++) {
            Move move = randomAlgo.makeChoice();

            if (move != Move.ROCK && move != Move.PAPER && move != Move.SCISSORS) {
                valid = false;
                break;
            }
        }

        System.out.println("RandomChoiceAlgorithm test: " + (valid ? "PASSED" : "FAILED"));
    }

    private static void testMLAlgorithm() {
        ChoiceAlgorithm mlAlgo = new MLChoiceAlgorithm();

        boolean valid = true;

        // Simulate some previous rounds
        mlAlgo.recordRound(Move.ROCK, Move.SCISSORS);
        mlAlgo.recordRound(Move.PAPER, Move.ROCK);
        mlAlgo.recordRound(Move.SCISSORS, Move.PAPER);

        for (int i = 0; i < 20; i++) {
            Move move = mlAlgo.makeChoice();

            if (move != Move.ROCK && move != Move.PAPER && move != Move.SCISSORS) {
                valid = false;
                break;
            }
        }

        System.out.println("MLChoiceAlgorithm test: " + (valid ? "PASSED" : "FAILED"));
    }
}