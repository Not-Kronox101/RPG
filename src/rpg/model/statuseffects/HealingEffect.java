package rpg.model.statuseffects;

import rpg.model.characters.GCharacter;

public class HealingEffect implements StatusEffect {
    private int duration;
    private int HealingPerTurn;

    public HealingEffect(int duration, int HealingPerTurn) {
        this.duration = duration;
        this.HealingPerTurn = HealingPerTurn;
    }

    @Override
    public void applyEffect(GCharacter target) {
        if (duration > 0) {
            target.heal(HealingPerTurn);
            duration--;
            System.out.println(target.getName() + " heals " + HealingPerTurn + "!");
        }
    }

    @Override
    public String getName() {
        return "Medicine";
    }

    @Override
    public boolean isExpired() {
        return duration <= 0;
    }
}
