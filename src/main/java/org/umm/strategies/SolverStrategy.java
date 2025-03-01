package org.umm.strategies;

import java.util.List;

public interface SolverStrategy {
    String getNextGuess(List<String> words, String feedback);
    void play(List<String> words);
}
