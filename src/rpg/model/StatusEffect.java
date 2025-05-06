package rpg.model.status;

public interface StatusEffect {
    void applyEffect(Character target);
    String getName();
    boolean isExpired();
}
