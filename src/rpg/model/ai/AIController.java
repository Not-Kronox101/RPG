package rpg.model.ai;

import rpg.model.characters.GCharacter;
import rpg.model.moves.Move;

public interface AIController {
    Move chooseMove(GCharacter self, GCharacter opponent);
}
