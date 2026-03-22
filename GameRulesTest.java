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
 * Simple test class for verifying GameRules behavior.
 * These tests can be run directly from main().
 */
public class GameRulesTest {

    public static void main(String[] args) {
        GameRules rules = new GameRules();

        int passed = 0;
        int total = 9;

        // Test all draw cases
        if (rules.determineResult(Move.ROCK, Move.ROCK) == RoundResult.DRAW) {
            passed++;
        }
        if (rules.determineResult(Move.PAPER, Move.PAPER) == RoundResult.DRAW) {
            passed++;
        }
        if (rules.determineResult(Move.SCISSORS, Move.SCISSORS) == RoundResult.DRAW) {
            passed++;
        }

        // Test human win cases
        if (rules.determineResult(Move.ROCK, Move.SCISSORS) == RoundResult.HUMAN_WIN) {
            passed++;
        }
        if (rules.determineResult(Move.PAPER, Move.ROCK) == RoundResult.HUMAN_WIN) {
            passed++;
        }
        if (rules.determineResult(Move.SCISSORS, Move.PAPER) == RoundResult.HUMAN_WIN) {
            passed++;
        }

        // Test computer win cases
        if (rules.determineResult(Move.ROCK, Move.PAPER) == RoundResult.COMPUTER_WIN) {
            passed++;
        }
        if (rules.determineResult(Move.PAPER, Move.SCISSORS) == RoundResult.COMPUTER_WIN) {
            passed++;
        }
        if (rules.determineResult(Move.SCISSORS, Move.ROCK) == RoundResult.COMPUTER_WIN) {
            passed++;
        }

        System.out.println("GameRulesTest: Passed " + passed + " out of " + total + " tests.");

        if (passed == total) {
            System.out.println("All GameRules tests passed.");
        } else {
            System.out.println("Some GameRules tests failed.");
        }
    }
}