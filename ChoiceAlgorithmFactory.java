/**
 * Assignment 3 - Rock Paper Scissors
 * Course: CS151
 *
 * Team 20k6
 * Members:
 * Arhaam Azhari
 * Khushi Bakshi
 * Toby Chan
 * Marco Shifflette
 */
/**
 * Factory class for creating chooser objects.
 * For this assignment, it returns only a RandomChooser.
 */
public class ChoiceAlgorithmFactory {

    public static ChoiceAlgorithm createChoiceAlgorithm(String mode) {
        if (mode != null && mode.equalsIgnoreCase("-m")) {
            return new MLChoiceAlgorithm();
        }
        return new RandomChoiceAlgorithm();
    }
}