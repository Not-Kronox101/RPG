package rpg.model;

import rpg.model.*;

public class AttackMove extends Move {
    private int power;

    public AttackMove(String name, String description, int power) {
        super(name, description);
        this.power = power;
    }

    @Override
    public void execute(Character user, Character target) {
        int damage = user.attack + power;
        target.takeDamage(damage);
    }
}
