package rpg.model.characters;
import java.util.List;

public abstract class Character {
    protected String name;
    protected int maxHP;
    protected int currentHP;
    protected int attack;
    protected int defense;
    protected List<Move> moves;

    public Character(String name, int maxHP, int attack, int defense, List<Move> moves) {
        this.name = name;
        this.maxHP = maxHP;
        this.currentHP = maxHP;
        this.attack = attack;
        this.defense = defense;
        this.moves = moves;
    }

    public String getName() {
        return name;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public boolean isAlive() {
        return currentHP > 0;
    }

    public void takeDamage(int damage) {
        int actualDamage = Math.max(damage - defense, 0);
        currentHP -= actualDamage;
        if (currentHP < 0) currentHP = 0;
        System.out.println(name + " takes " + actualDamage + " damage!");
    }

    public void heal(int amount) {
        currentHP += amount;
        if (currentHP > maxHP) currentHP = maxHP;
        System.out.println(name + " heals " + amount + " HP!");
    }

    public List<Move> getMoves() {
        return moves;
    }

    public abstract Move chooseMove(Character opponent);  // This is overridden differently for Player and Enemy
}
