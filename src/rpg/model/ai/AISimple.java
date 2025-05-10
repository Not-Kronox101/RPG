package rpg.model.ai;

import java.util.List;
import java.util.Random;
import rpg.model.characters.GCharacter;
import rpg.model.moves.Move;

public class AISimple implements AIController {
    private Random random = new Random();

    @Override
    public Move chooseMove(GCharacter self, GCharacter opponent) {
        List<Move> moves = self.getMoves();
        return moves.get(random.nextInt(moves.size())); // pick random move
    }
}
