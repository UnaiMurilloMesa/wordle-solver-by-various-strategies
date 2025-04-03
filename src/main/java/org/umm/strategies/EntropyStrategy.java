package org.umm.strategies;

import java.util.*;

public class EntropyStrategy implements SolverStrategy {
    private Random random = new Random();
    private final Character CORRECT = 'v';
    private final Character INCORRECT = 'g';
    private final Character CONTAINS = 'a';
    private static final int WORD_LENGTH = 5;

    @Override
    public String getNextGuess(List<String> validWords, String feedback) {
        validWords = filterValidWords(validWords);
        if (validWords.isEmpty()) {
            throw new IllegalStateException("No hay palabras que acepten todas las condiciones");
        }
        return findBestWord(validWords);
    }

    private String findBestWord(List<String> validWords) {
        if (validWords.isEmpty()) {
            throw new IllegalStateException("No hay palabras disponibles");
        }

        double maxEntropy = -1;
        String bestWord = validWords.get(0);

        for (String word : validWords) {
            double entropy = calculateEntropy(word, validWords);
            if (entropy > maxEntropy) {
                maxEntropy = entropy;
                bestWord = word;
            }
        }
        return bestWord;
    }

    private double calculateEntropy(String word, List<String> validWords) {
        Map<String, Integer> patternCounts = new HashMap<>();

        for (String possibleWord : validWords) {
            String pattern = getFeedbackPattern(word, possibleWord);
            patternCounts.put(pattern, patternCounts.getOrDefault(pattern, 0) + 1);
        }

        double entropy = 0.0;
        int total = validWords.size();
        for (int count : patternCounts.values()) {
            double probability = (double) count / total;
            entropy -= probability * Math.log(probability) / Math.log(2);
        }
        return entropy;
    }

    private String getFeedbackPattern(String guess, String target) {
        if (guess.length() != target.length()) {
            throw new IllegalArgumentException("Las palabras deben tener la misma longitud");
        }

        StringBuilder pattern = new StringBuilder();
        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == target.charAt(i)) {
                pattern.append(CORRECT);
            } else if (target.contains(String.valueOf(guess.charAt(i)))) {
                pattern.append(CONTAINS);
            } else {
                pattern.append(INCORRECT);
            }
        }
        return pattern.toString();
    }

    @Override
    public void play(List<String> words) {
        Scanner sc = new Scanner(System.in);
        List<String> validWords = filterValidWords(words);
        boolean correct = false;
        int attempts = 0;

        if (validWords.isEmpty()) {
            System.out.println("No hay palabras válidas para jugar.");
            return;
        }

        String guess = getNextGuess(validWords, "");

        do {
            System.out.println("Guess: " + guess);
            System.out.print("Feedback: ");
            String feedback = sc.nextLine();

            if (feedback.length() != WORD_LENGTH) {
                System.out.println("El feedback debe tener exactamente " + WORD_LENGTH + " caracteres, prueba otra vez");
                continue;
            }

            if (feedback.equals("vvvvv")) {
                correct = true;
            } else {
                validWords = getValidWords(validWords, feedback, guess);
                if (validWords.isEmpty()) {
                    System.out.println("No quedan más palabras.");
                    return;
                }
                guess = getNextGuess(validWords, feedback);
                attempts++;
            }
        } while (!correct && attempts < 6);

        if (correct) {
            System.out.println("¡Has acertado!");
        } else {
            System.out.println("Otra vez será...");
        }
    }

    private List<String> getValidWords(List<String> words, String feedback, String lastGuess) {
        List<String> validWords = new ArrayList<>(words);

        for (int i = 0; i < feedback.length(); i++) {
            char feedbackChar = feedback.charAt(i);
            char guessChar = lastGuess.charAt(i);
            int I = i;

            if (feedbackChar == CORRECT) {
                validWords.removeIf(word -> word.charAt(I) != guessChar);
            } else if (feedbackChar == INCORRECT) {
                validWords.removeIf(word -> word.contains(String.valueOf(guessChar)));
            } else if (feedbackChar == CONTAINS) {
                validWords.removeIf(word -> word.charAt(I) == guessChar || !word.contains(String.valueOf(guessChar)));
            }
        }
        return validWords;
    }

    private List<String> filterValidWords(List<String> words) {
        List<String> filteredWords = new ArrayList<>();
        for (String word : words) {
            if (word.length() == WORD_LENGTH) {
                filteredWords.add(word);
            }
        }
        return filteredWords;
    }
}
