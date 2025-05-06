package rpg.model.moves;

import rpg.model.characters.GCharacter;

public class HealMove extends Move {
    private int healAmount;

    public HealMove(String name, String description, int healAmount) {
        super(name, description);
        this.healAmount = healAmount;
    }

    @Override
    public void execute(GCharacter user, GCharacter target) {
        user.heal(healAmount);
    }
}
