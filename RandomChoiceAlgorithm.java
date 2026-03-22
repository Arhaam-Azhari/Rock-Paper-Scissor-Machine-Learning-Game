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

import java.util.Random;

/**
 * Random choice algorithm for the computer player.
 */
public class RandomChoiceAlgorithm implements ChoiceAlgorithm {
    private Random random;

    public RandomChoiceAlgorithm() {
        random = new Random();
    }

    /**
     * Returns a random move.
     */
    @Override
    public Move makeChoice() {
        int value = random.nextInt(3);

        switch (value) {
            case 0:
                return Move.ROCK;
            case 1:
                return Move.PAPER;
            default:
                return Move.SCISSORS;
        }
    }

    /**
     * Random algorithm does not learn from previous rounds.
     */
    @Override
    public void recordRound(Move humanMove, Move computerMove) {
        // No learning needed for random algorithm.
    }
}