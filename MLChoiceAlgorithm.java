/**
 * Assignment 4 - Rock Paper Scissors (ML Version)
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
 * This class implements a simple machine learning algorithm for predicting
 * the human player's next move based on the last N individual choices.
 *
 * Approach:
 * - Uses a sliding window of the last 5 choices between the human and computer.
 * - Stores frequencies of 5-choice sequences that end with a human move.
 * - Uses the last 4 choices to predict the next human move.
 * - Chooses the counter move to beat the predicted human move.
 * - Falls back to random if no matching sequence exists.
 * - Saves and loads learned sequence frequencies from a file.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class MLChoiceAlgorithm implements ChoiceAlgorithm {

    // Number of individual choices to track
    private static final int WINDOW_SIZE = 5;

    // Stores the most recent choices as a sliding window
    private ArrayList<Move> recentChoices;

    // Stores exact 5-choice sequences and how many times they occurred
    private HashMap<String, Integer> sequenceCounts;

    // Fallback random algorithm if no prediction is possible
    private RandomChoiceAlgorithm fallback;

    // Tracks whether the last move used prediction or random fallback
    private boolean usedPrediction;

    // File used to save learned data
    private static final String DATA_FILE = "ml_data.txt";

    /**
     * Constructor initializes structures and loads saved sequence data.
     */
    public MLChoiceAlgorithm() {
        recentChoices = new ArrayList<>();
        sequenceCounts = new HashMap<>();
        fallback = new RandomChoiceAlgorithm();
        usedPrediction = false;
        loadData();
    }

    /**
     * Chooses the computer's move based on the last 4 choices.
     * If there is not enough history or no matching sequence exists,
     * the algorithm falls back to random choice.
     */
    @Override
    public Move makeChoice() {
        if (recentChoices.size() < WINDOW_SIZE - 1) {
            usedPrediction = false;
            return fallback.makeChoice();
        }

        String prefix = choicesToString(recentChoices);

        int rockCount = sequenceCounts.getOrDefault(prefix + "R", 0);
        int paperCount = sequenceCounts.getOrDefault(prefix + "P", 0);
        int scissorsCount = sequenceCounts.getOrDefault(prefix + "S", 0);

        if (rockCount == 0 && paperCount == 0 && scissorsCount == 0) {
            usedPrediction = false;
            return fallback.makeChoice();
        }

        Move predictedHumanMove = Move.ROCK;
        int maxCount = rockCount;

        if (paperCount > maxCount) {
            predictedHumanMove = Move.PAPER;
            maxCount = paperCount;
        }

        if (scissorsCount > maxCount) {
            predictedHumanMove = Move.SCISSORS;
        }

        usedPrediction = true;
        return counterMove(predictedHumanMove);
    }

    /**
     * Records one completed round.
     * The human move is processed first, because the assignment wants
     * frequencies for sequences that end with the human's choice.
     */
    @Override
    public void recordRound(Move humanMove, Move computerMove) {
        recordHumanChoice(humanMove);
        addChoice(computerMove);
    }

    /**
     * Records the human choice and updates sequence frequencies if enough
     * previous history exists.
     */
    private void recordHumanChoice(Move humanMove) {
        if (recentChoices.size() == WINDOW_SIZE - 1) {
            String sequence = choicesToString(recentChoices) + moveToChar(humanMove);
            sequenceCounts.put(sequence, sequenceCounts.getOrDefault(sequence, 0) + 1);
        }

        addChoice(humanMove);
    }

    /**
     * Adds one choice to the sliding window and removes the oldest choice
     * if the window becomes too large.
     */
    private void addChoice(Move move) {
        recentChoices.add(move);

        if (recentChoices.size() > WINDOW_SIZE - 1) {
            recentChoices.remove(0);
        }
    }

    /**
     * Converts the current list of moves into a compact string like RSPS.
     */
    private String choicesToString(ArrayList<Move> choices) {
        StringBuilder builder = new StringBuilder();

        for (Move move : choices) {
            builder.append(moveToChar(move));
        }

        return builder.toString();
    }

    /**
     * Converts a Move to a single-letter representation.
     */
    private String moveToChar(Move move) {
        if (move == Move.ROCK) {
            return "R";
        } else if (move == Move.PAPER) {
            return "P";
        } else {
            return "S";
        }
    }

    /**
     * Returns whether the last move used prediction or random fallback.
     */
    public boolean usedPrediction() {
        return usedPrediction;
    }

    /**
     * Saves learned sequence frequencies to a text file.
     */
    public void saveData() {
        try {
            PrintWriter writer = new PrintWriter(DATA_FILE);

            for (String sequence : sequenceCounts.keySet()) {
                writer.println(sequence + ":" + sequenceCounts.get(sequence));
            }

            writer.close();
        } catch (Exception e) {
            System.out.println("Error saving ML data: " + e.getMessage());
        }
    }

    /**
     * Loads learned sequence frequencies from a text file if it exists.
     */
    private void loadData() {
        try {
            File file = new File(DATA_FILE);

            if (!file.exists()) {
                return;
            }

            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();

                if (line.isEmpty()) {
                    continue;
                }

                String[] parts = line.split(":");

                if (parts.length != 2) {
                    continue;
                }

                String sequence = parts[0];
                int count = Integer.parseInt(parts[1]);

                sequenceCounts.put(sequence, count);
            }

            scanner.close();
        } catch (Exception e) {
            System.out.println("Error loading ML data: " + e.getMessage());
        }
    }

    /**
     * Returns the move that beats the predicted human move.
     */
    private Move counterMove(Move predictedMove) {
        if (predictedMove == Move.ROCK) {
            return Move.PAPER;
        } else if (predictedMove == Move.PAPER) {
            return Move.SCISSORS;
        } else {
            return Move.ROCK;
        }
    }
}