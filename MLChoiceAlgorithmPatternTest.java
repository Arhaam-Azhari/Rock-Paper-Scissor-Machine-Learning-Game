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
 * Tests whether MLChoiceAlgorithm learns from repeated 5-choice sequences.
 */
public class MLChoiceAlgorithmPatternTest {

    public static void main(String[] args) {
        MLChoiceAlgorithm mlAlgo = new MLChoiceAlgorithm();

        // Build this sequence occurrence:
        // Round 1: Human R, Computer S   -> choices: R S
        // Round 2: Human P, Computer S   -> choices: R S P S
        // Round 3: Human S, Computer R   -> sequence RSPSS should be counted
        mlAlgo.recordRound(Move.ROCK, Move.SCISSORS);
        mlAlgo.recordRound(Move.PAPER, Move.SCISSORS);
        mlAlgo.recordRound(Move.SCISSORS, Move.ROCK);

        // Build another path so that the recent last 4 choices become RSPS again
        mlAlgo.recordRound(Move.ROCK, Move.SCISSORS);
        mlAlgo.recordRound(Move.PAPER, Move.SCISSORS);

        // Now the last 4 choices should be RSPS.
        // Since RSPSS occurred before, the ML algorithm should predict SCISSORS
        // and therefore choose ROCK as the counter move.
        Move predictedCounter = mlAlgo.makeChoice();

        boolean passed = (predictedCounter == Move.ROCK);

        System.out.println("MLChoiceAlgorithmPatternTest: " + (passed ? "PASSED" : "FAILED"));
        System.out.println("Expected counter move: ROCK");
        System.out.println("Actual move: " + predictedCounter);
    }
}