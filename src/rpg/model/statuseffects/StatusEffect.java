package rpg.model.statuseffects;

import rpg.model.characters.GCharacter;

public interface StatusEffect {
    void applyEffect(GCharacter target);
    String getName();
    boolean isExpired();
}
