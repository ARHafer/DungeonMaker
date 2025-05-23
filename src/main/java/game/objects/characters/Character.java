package game.objects.characters;

import game.objects.environments.Room;
import game.utilities.Inspectable;

/*
 * Contains variables and methods used by every character.
 */

public abstract class Character implements Inspectable {
    protected final String name;
    protected Room room;

    public Character(String name) {
        this.name = name;
    }

    // Setters & Getters //
    public void setRoom(Room room) {
        this.room = room;
    }

    public String getName() {
        return name;
    }
}
