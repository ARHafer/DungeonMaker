import java.util.ArrayList;

public class Room {
    private final String name, description;
    private final ArrayList<Guard> guards;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        guards = new ArrayList<>();
    }

    public void addGuard(Guard guard) {
        guards.add(guard);
        guard.setRoom(this);
    }

    public String inspectString() {
        if (!guards.isEmpty()) {
            if (guards.size() == 1) {
                return "\n<" + name + ">\n" + description + "\n\nYou look around the room and see...\n" + "1 Guard: " + listGuards() + "\n";
            } else {
                return "\n<" + name + ">\n" + description + "\n\nYou look around the room and see...\n" + guards.size() + " Guards: " + listGuards() + "\n";
            }
        } else {
            return "\n<" + name + ">\n" + description + "\n";
        }
    }

    private StringBuilder listGuards() {
        StringBuilder listGuards = new StringBuilder();

        // A whole lot of code to ensure grammatical correctness...
        if (guards.size() > 2) {
            for (Guard guard : guards) {

                while (guards.size() > 2) {
                    listGuards.append(guard.getName()).append(", ");
                }

                listGuards.append(guard.getName()).append(", & ").append(guards.getFirst().getName());
            }
        } else if (guards.size() == 2) {
            listGuards.append(guards.get(1).getName()).append(" & ").append(guards.getFirst().getName());
        } else {
            listGuards.append(guards.getFirst().getName());
        }

        return listGuards;
    }
}
