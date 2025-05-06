package rpg.model.moves;

import rpg.model.characters.GCharacter; 

public abstract class Move {
    protected String name;
    protected String description;

    public Move(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    // This is the key method each move must implement
    public abstract void execute(GCharacter user, GCharacter target);
}
