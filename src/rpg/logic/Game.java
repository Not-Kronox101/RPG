package rpg.logic;

import rpg.model.characters.Player;
import rpg.model.characters.Enemy;
import rpg.model.moves.AttackMove;
import rpg.model.moves.HealMove;
import rpg.model.moves.Move;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private Player player;
    private Enemy enemy;

    public Game() {
        // Initialize the game (create characters, moves, etc.)
        initializeGame();
    }

    private void initializeGame() {
        // Create moves (for simplicity, we're adding two moves: attack and heal)
        List<Move> playerMoves = new ArrayList<>();
        playerMoves.add(new AttackMove("Punch", "A simple punch", 20)); // Attack move
        playerMoves.add(new HealMove("Heal", "Heals some HP", 15));   // Heal move

        List<Move> enemyMoves = new ArrayList<>();
        enemyMoves.add(new AttackMove("Bite", "Enemy's bite attack", 15));

        // Create the player and enemy
        player = new Player("Hero", 100, 20, 10, playerMoves);
        enemy = new Enemy("Goblin", 50, 15, 5, enemyMoves);

    }

    public void startGame() {
        // Game loop: alternate turns between player and enemy
        boolean gameOver = false;
        while (!gameOver) {
            playerTurn();
            if (enemy.getCurrentHP() <= 0) {
                System.out.println("You win!");
                gameOver = true;
            }

            enemyTurn();
            if (player.getCurrentHP() <= 0) {
                System.out.println("You lose!");
                gameOver = true;
            }
        }
    }

    private void playerTurn() {
        // Let the player choose a move interactively
        System.out.println(player.getName() + "'s turn!");
        Move move = player.chooseMove(enemy); // Allow the player to choose a move
        move.execute(player, enemy);
    }

    private void enemyTurn() {
        // Simple AI for the enemy: just attack the player
        System.out.println(enemy.getName() + "'s turn!");
        Move move = enemy.getMoves().get(0); // Attack move (index 0)
        move.execute(enemy, player);
    }
}