package game.objects.environments;

import game.utilities.Inspectable;

public class Door implements Inspectable {
    private final String name, description;
    private boolean locked;
    private Room room1, room2;

    public Door(String name, String description, boolean locked) {
        this.name = name;
        this.description = description;
        this.locked = locked;
    }

    @Override
    public String inspectString() {
        String lockString;

        if (locked) {
            lockString = "Locked";
        } else {
            lockString = "Unlocked";
        }

        return "\n<" + name + "> (" + lockString + ")\n" + description + "\n";
    }

    // Setters & Getters //
    public void setRoom(Room room) {
        if (room1 == null) {
            room1 = room;
        } else {
            room2 = room;
        }
    }
}
