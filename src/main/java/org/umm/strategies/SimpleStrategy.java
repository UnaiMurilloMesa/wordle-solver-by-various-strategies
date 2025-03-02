package org.umm.strategies;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SimpleStrategy implements SolverStrategy {
    private Random random = new Random();
    Scanner sc = new Scanner(System.in);
    private final Character CORRECT = 'v';
    private final Character INCORRECT = 'g';
    private final Character CONTAINS = 'a';

    @Override
    public String getNextGuess(List<String> validWords, String feedback) {
        validWords.removeIf(String::isBlank);
        if (validWords.isEmpty()) {
            throw new IllegalStateException("No hay palabras que acepten todas las condiciones");
        }
        System.out.println(validWords.size() + " palabras");
        return validWords.get(random.nextInt(validWords.size()));
    }

    @Override
    public void play(List<String> words) {
        System.out.println("\n___________Has escogido la estrategia simple___________");
        System.out.println("Escribe en el feedback:\n - " + CORRECT + " si en esa posición hay color verde" +
                "\n - " + INCORRECT + " si en esa posición hay color gris" +
                "\n - " + CONTAINS + " si en esa posición hay color amarillo");
        boolean correct = false;
        int count = 0;

        List<String> validWords = new ArrayList<>(words);
        String feedback = "";
        String guess = getNextGuess(validWords, feedback);


        do {
            System.out.println("Guess: " + guess);
            System.out.print("Feedback: ");
            feedback = sc.nextLine();

            if (feedback.length() != 5) {
                System.out.println("El feedback debe tener exactamente 5 caracteres, prueba otra vez");
                continue;
            }


            if (feedback.equals("vvvvv")) {
                correct = true;
            } else {
                validWords = getValidWords(validWords, feedback, guess);
                if (validWords.isEmpty()) {
                    System.out.println("No quedan más palabras");
                    return;
                }
                guess = getNextGuess(validWords, feedback);
                count++;
            }
        } while (!correct && count < 6);

        if (correct) {
            System.out.println("Oleee!!!");
        } else {
            System.out.println("Otra vez será...");
        }

    }

    private List<String> getValidWords(List<String> words, String feedback, String lastGuess) {
        List<String> validWords = new ArrayList<>(words);
        List<Character> validCharacters = new ArrayList<>();

        if (lastGuess.length() < feedback.length()) {
            throw new IllegalArgumentException("Error en la longitud de la palabra");
        }

        for (int i = 0; i < feedback.length(); i++) { // Arreglo de bug para no eliminar palabras que contengan la misma letra en 2 posiciones pero en una aparece en gris y otra en verde
            if (feedback.charAt(i) == CORRECT) {
                validCharacters.add(lastGuess.charAt(i));
            }
        }

        for (int i = 0; i < feedback.length(); i++) {
            char feedbackChar = feedback.charAt(i);
            char guessChar = lastGuess.charAt(i);
            int I = i; // Con esto evito 'ConcurrentModificationException'

            if (feedbackChar == CORRECT) {
                validWords.removeIf(word -> word.length() > I && word.charAt(I) != guessChar);
            } else if (feedbackChar == INCORRECT) {
                if (!validCharacters.contains(guessChar)) {
                    validWords.removeIf(word -> word.contains(String.valueOf(guessChar)));
                }
            } else if (feedbackChar == CONTAINS) {
                validWords.removeIf(word -> {
                    if (word.charAt(I) == guessChar) {
                        return true;
                    }
                    return !word.contains(String.valueOf(guessChar));
                });
            }
        }

        validWords.stream().forEach(System.out::println);

        return validWords;
    }
}
