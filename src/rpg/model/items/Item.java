package rpg.model.items;

import rpg.model.characters.GCharacter;

public abstract class Item {
    protected String name;
    protected String description;

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public abstract void use(GCharacter user, GCharacter target);
}
