package rpg.model;

import rpg.model.*;

public class HealingPotion extends Item {
    private int healAmount;

    public HealingPotion(String name, String description, int healAmount) {
        super(name, description);
        this.healAmount = healAmount;
    }

    @Override
    public void use(Character user, Character target) {
        target.heal(healAmount);
        System.out.println(user.getName() + " uses " + name + " on " + target.getName() + "!");
    }
}
