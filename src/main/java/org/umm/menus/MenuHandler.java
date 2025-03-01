package org.umm.menus;

import org.umm.strategies.SolverStrategy;

public interface MenuHandler {
    void displayMenu();
    int getChoice();
    SolverStrategy chooseChoice(int option);
    boolean shouldExit(int option);
}
