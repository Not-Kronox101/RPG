package rpg.model.items;

import rpg.model.characters.GCharacter;

public class HealingPotion extends Item {
    private int healAmount;

    public HealingPotion(String name, String description, int healAmount) {
        super(name, description);
        this.healAmount = healAmount;
    }

    @Override
    public void use(GCharacter user, GCharacter target) {
        target.heal(healAmount);  // Assuming GCharacter has heal() method
        System.out.println(user.getName() + " uses " + name + " on " + target.getName() + "!");
    }
}
