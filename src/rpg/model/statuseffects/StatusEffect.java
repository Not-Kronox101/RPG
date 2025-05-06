package rpg.model.statuseffects;

public interface StatusEffect {
    void applyEffect(Character target);
    String getName();
    boolean isExpired();
}
