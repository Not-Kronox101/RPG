package rpg.logic;

import rpg.model.characters.Player;
import rpg.model.characters.Enemy;
import rpg.model.moves.AttackMove;
import rpg.model.moves.HealMove;
import rpg.model.moves.Move;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private Player player;
    private Enemy enemy;
    private final Scanner scanner = new Scanner(System.in);

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

    public void startGame() {
        boolean gameOver = false;
        System.out.println("=== BATTLE START ===");

        while (!gameOver) {
            playerTurn();
            if (enemy.getCurrentHP() <= 0) {
                System.out.println("You defeated the enemy!");
                gameOver = true;
                continue;
            }

            enemyTurn();
            if (player.getCurrentHP() <= 0) {
                System.out.println("You were defeated...");
                gameOver = true;
            }
        }

        System.out.println("=== GAME OVER ===");
    }

    private void playerTurn() {
        System.out.println("\nYour Turn:");
        System.out.println(player.getName() + " HP: " + player.getCurrentHP() + " | " + enemy.getName() + " HP: " + enemy.getCurrentHP());

        List<Move> moves = player.getMoves();
        for (int i = 0; i < moves.size(); i++) {
            System.out.println((i + 1) + ". " + moves.get(i).getName() + " - " + moves.get(i).getDescription());
        }

        int choice = -1;
        while (choice < 1 || choice > moves.size()) {
            System.out.print("Choose your move (1-" + moves.size() + "): ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                scanner.next(); // consume invalid input
                System.out.println("Invalid input. Enter a number.");
            }
        }

        Move selectedMove = moves.get(choice - 1);
        selectedMove.execute(player, enemy);
    }

    private void enemyTurn() {
        System.out.println("\nEnemy Turn:");
        Move move = enemy.getMoves().get(0); // Always attack
        move.execute(enemy, player);
        System.out.println(player.getName() + " HP: " + player.getCurrentHP());
    }
}
