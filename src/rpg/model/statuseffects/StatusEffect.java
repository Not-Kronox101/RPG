package rpg.model;

public interface StatusEffect {
    void applyEffect(Character target);
    String getName();
    boolean isExpired();
}
