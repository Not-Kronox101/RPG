package rpg.model.characters;

import java.util.List;
import java.util.Scanner;

public class Player extends Character {

    public Player(String name, int maxHP, int attack, int defense, List<Move> moves) {
        super(name, maxHP, attack, defense, moves); // Call the constructor of the Character class
    }

    @Override
    public Move chooseMove(Character opponent) {
        System.out.println(name + "'s turn. Choose a move:");
        for (int i = 0; i < moves.size(); i++) {
            System.out.println((i + 1) + ". " + moves.get(i).getName());
        }

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return moves.get(choice - 1); // Get the selected move from the list
    }
}
