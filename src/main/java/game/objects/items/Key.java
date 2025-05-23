package game.objects.items;

public class Key extends Item {
    private final String door; // String representation of the door the key unlocks.

    public Key(String name, String description, String door) {
        super(name, description, 0, true, true);
        this.door = door;
    }

    @Override
    public String inspectString() {
        return "\n<" + name + "> (Unlocks " + door + ")\n" + description + "\n";
    }
}
