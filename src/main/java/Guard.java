public class Guard {
    private final String name, description;
    private Room room;

    public Guard(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String inspectString() {
        return "\n<" + name + ">\n" + description;
    }

    // Setters & Getters //
    public void setRoom(Room room) {
        this.room = room;
    }

    public String getName() {
        return name;
    }
}
