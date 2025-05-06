package rpg.model;

import rpg.model.*;

public class HealMove extends Move {
    private int healAmount;

    public HealMove(String name, String description, int healAmount) {
        super(name, description);
        this.healAmount = healAmount;
    }

    @Override
    public void execute(Character user, Character target) {
        user.heal(healAmount);
    }
}
