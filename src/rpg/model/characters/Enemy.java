package rpg.model.characters;

import java.util.List;
import java.util.Random;

public class Enemy extends Character {

    public Enemy(String name, int maxHP, int attack, int defense, List<Move> moves) {
        super(name, maxHP, attack, defense, moves);
    }

    @Override
    public Move chooseMove(Character opponent) {
        Random rand = new Random();
        return moves.get(rand.nextInt(moves.size()));
    }
}
