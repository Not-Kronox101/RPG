package rpg;

import rpg.logic.Game;  // Import Game class from the rpg.logic package

public class Main {

    public static void main(String[] args) {
        // Create an instance of the Game class and start it
        Game game = new Game();
        game.showMainMenu();
    }
}
