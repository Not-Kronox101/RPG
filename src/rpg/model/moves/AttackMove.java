package rpg.model.moves;

import rpg.model.characters.GCharacter;

public class AttackMove extends Move {
    private int power;

    public AttackMove(String name, String description, int power) {
        super(name, description);
        this.power = power;
    }

    @Override
    public void execute(GCharacter user, GCharacter target) {
        int damage = user.getAttack() + power;
        target.takeDamage(damage);
    }
}
