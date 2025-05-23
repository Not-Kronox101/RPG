package rpg.model.statuseffects;

import rpg.model.characters.GCharacter;

public class PoisonEffect implements StatusEffect {
    private int duration;
    private int damagePerTurn;

    public PoisonEffect(int duration, int damagePerTurn) {
        this.duration = duration;
        this.damagePerTurn = damagePerTurn;
    }

    @Override
    public void applyEffect(GCharacter target) {
        if (duration > 0) {
            target.takeDamage(damagePerTurn);
            duration--;
            System.out.println(target.getName() + " suffers " + damagePerTurn + " poison damage!");
        }
    }

    @Override
    public String getName() {
        return "Poison";
    }

    @Override
    public boolean isExpired() {
        return duration <= 0;
    }
}

