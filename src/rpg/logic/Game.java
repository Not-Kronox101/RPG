package rpg.logic;

import rpg.model.characters.Player;
import rpg.model.characters.Enemy;
import rpg.model.moves.AttackMove;
import rpg.model.moves.HealMove;
import rpg.model.moves.Move;

import javax.swing.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Game {

    private Player player;
    private Enemy enemy;

    public Game() {
        initializeGame();
    }

    private void initializeGame() {
        List<Move> playerMoves = new ArrayList<>();
        playerMoves.add(new AttackMove("Punch", "A simple punch", 20));
        playerMoves.add(new HealMove("Heal", "Heals some HP", 15));

        List<Move> enemyMoves = new ArrayList<>();
        enemyMoves.add(new AttackMove("Bite", "Enemy's bite attack", 15));

        player = new Player("Hero", 100, 20, 10, playerMoves);
        enemy = new Enemy("Goblin", 50, 15, 5, enemyMoves);
    }

    private void logResult(boolean playerWon) {
        String result = playerWon ? "Victory" : "Defeat";
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String logEntry = String.format("[%s]| Result: %s | Player HP: %d | Enemy HP: %d\n", date, result, player.getCurrentHP(), enemy.getCurrentHP());

        try (FileWriter writer = new FileWriter("game_log.txt", true)) {
            writer.write(logEntry);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error writing to log file: " + e.getMessage());
        }
    }

    public void startGame() {
        boolean gameOver = false;
        JOptionPane.showMessageDialog(null, "=== BATTLE START ===");

        while (!gameOver) {
            playerTurn();
            if (enemy.getCurrentHP() <= 0) {
                JOptionPane.showMessageDialog(null, "You defeated the enemy!");
                logResult(true);
                gameOver = true;
               continue;
            }

            enemyTurn();
            if (player.getCurrentHP() <= 0) {
                JOptionPane.showMessageDialog(null, "You were defeated...");
                logResult(false);
                gameOver = true;
            }
        }
    JOptionPane.showMessageDialog(null, "=== GAME OVER ===");
}



    private void playerTurn() {
        String status = player.getName() + " HP: " + player.getCurrentHP() + "\n" +
                        enemy.getName() + " HP: " + enemy.getCurrentHP();

        List<Move> moves = player.getMoves();
        String[] moveNames = new String[moves.size()];
        for (int i = 0; i < moves.size(); i++) {
            moveNames[i] = moves.get(i).getName() + " - " + moves.get(i).getDescription();
        }

        String selectedMoveStr = (String) JOptionPane.showInputDialog(
                null,
                status + "\nChoose your move:",
                "Your Turn",
                JOptionPane.PLAIN_MESSAGE,
                null,
                moveNames,
                moveNames[0]
        );

        int selectedIndex = -1;
        for (int i = 0; i < moveNames.length; i++) {
            if (moveNames[i].equals(selectedMoveStr)) {
                selectedIndex = i;
                break;
            }
        }

        if (selectedIndex != -1) {
            Move selectedMove = moves.get(selectedIndex);
            selectedMove.execute(player, enemy);
        } else {
            JOptionPane.showMessageDialog(null, "No move selected! Turn skipped.");
        }
    }

    private void enemyTurn() {
        Move move = enemy.getMoves().get(0); // Always attack
        move.execute(enemy, player);

        String status = player.getName() + " HP: " + player.getCurrentHP() + "\n" +
                        enemy.getName() + " used " + move.getName() + "!";
        JOptionPane.showMessageDialog(null, status, "Enemy Turn", JOptionPane.INFORMATION_MESSAGE);
    }

    private void showGameHistory() {
    try {
        String content = new String(Files.readAllBytes(Paths.get("game_log.txt")));
        JOptionPane.showMessageDialog(null, content, "Game History", JOptionPane.INFORMATION_MESSAGE);
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "No game history found.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    public void showMainMenu() {
    while (true) {
        String[] options = {"New Game", "View History", "Exit"};
        int choice = JOptionPane.showOptionDialog(
                null,
                "Welcome to Java RPG!",
                "Main Menu",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]
        );

        switch (choice) {
            case 0 -> {
                initializeGame();
                startGame();
            }
            case 1 -> showGameHistory();
            case 2, JOptionPane.CLOSED_OPTION -> {
                JOptionPane.showMessageDialog(null, "Thanks for playing!");
                return;
            }
        }
    }
}

}
