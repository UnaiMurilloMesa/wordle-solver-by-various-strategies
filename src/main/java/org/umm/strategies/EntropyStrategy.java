package org.umm.strategies;

import java.util.List;

public class EntropyStrategy implements SolverStrategy {
    @Override
    public String getNextGuess(List<String> words, String feedback) {
        return "";
    }

    @Override
    public void play(List<String> words) {
        System.out.println("___________Has escogido la estrategia óptima___________");
    }
}
