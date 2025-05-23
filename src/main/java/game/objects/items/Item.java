package game.objects.items;

import game.objects.environments.Room;
import game.utilities.Inspectable;

public class Item implements Inspectable {
    protected final String name, description;
    protected final int weight;
    protected boolean carriable, hidden;
    protected Room room;

    public Item(String name, String description, int weight, boolean carriable, boolean hidden) {
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.carriable = carriable;
        this.hidden = hidden;
    }

    @Override
    public String inspectString() {
        String lbOrlbs;

        if (weight == 1) {
            lbOrlbs = " lb.";
        } else {
            lbOrlbs = " lbs.";
        }

        return "\n<" + name + "> (" + weight + lbOrlbs + ")\n" + description + "\n";
    }

    // Setters & Getters //
    public void setRoom(Room room) {
        this.room = room;
    }

    public String getName() {
        return name;
    }
}
