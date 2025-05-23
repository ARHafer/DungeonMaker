package game.objects.environments;

import game.objects.characters.Guard;
import game.objects.characters.Maid;
import game.objects.characters.NPC;
import game.objects.items.Item;
import game.utilities.Inspectable;

import java.util.ArrayList;

public class Room implements Inspectable {
    private final String name, description;
    private final ArrayList<NPC> NPCs;
    private final ArrayList<Item> items;
    private Door north, south, east, west;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        NPCs = new ArrayList<>();
        items = new ArrayList<>();
    }

    public void addNPC(NPC npc) {
        NPCs.add(npc);
        npc.setRoom(this);
    }

    public void addItem(Item item) {
        items.add(item);
        item.setRoom(this);
    }

    @Override
    public String inspectString() {
        return "\n<" + name + ">\n" + description + "\n\nYou look around the room and see...\n" + listGuards() + listMaids()
                + listItems() + listDoors();
    }

    // FOR INSPECTSTRING //
    private StringBuilder listGuards() {
        StringBuilder listGuards = new StringBuilder();

        // A whole lot of code to ensure grammatical correctness...
        if (getGuards().isEmpty()) {
            listGuards.append("No guards.\n");
            return listGuards;
        } else if (getGuards().size() == 1) {
            listGuards.append(getGuards().size()).append(" Guard: ");
        } else {
            listGuards.append(getGuards().size()).append(" Guards: ");
        }

        if (getGuards().size() > 2) {
            int counter = getGuards().size();

            for (Guard guard : getGuards()) {
                if (counter > 2) {
                    listGuards.append(guard.getName()).append(", ");
                    counter--;
                } else if (counter == 2) {
                    listGuards.append(guard.getName()).append(", & ");
                    counter--;
                } else {
                    listGuards.append(guard.getName()).append("\n");
                }
            }
        } else if (getGuards().size() == 2) {
            listGuards.append(getGuards().getFirst().getName()).append(" & ").append(getGuards().get(1).getName()).append("\n");
        } else {
            listGuards.append(getGuards().getFirst().getName()).append("\n");
        }

        return listGuards;
    }

    private StringBuilder listMaids() {
        StringBuilder listMaids = new StringBuilder();

        // A whole lot of code to ensure grammatical correctness...
        if (getMaids().isEmpty()) {
            listMaids.append("No maids.\n");
            return listMaids;
        } else if (getMaids().size() == 1) {
            listMaids.append(getMaids().size()).append(" Maid: ");
        } else {
            listMaids.append(getMaids().size()).append(" Maids: ");
        }

        if (getMaids().size() > 2) {
            int counter = getMaids().size();

            for (Maid maid : getMaids()) {
                if (counter > 2) {
                    listMaids.append(maid.getName()).append(", ");
                    counter--;
                } else if (counter == 2) {
                    listMaids.append(maid.getName()).append(", & ");
                    counter--;
                } else {
                    listMaids.append(maid.getName()).append("\n");
                }
            }
        } else if (getMaids().size() == 2) {
            listMaids.append(getMaids().getFirst().getName()).append(" & ").append(getMaids().get(1).getName()).append("\n");
        } else {
            listMaids.append(getMaids().getFirst().getName()).append("\n");
        }

        return listMaids;
    }

    private StringBuilder listItems() {
        StringBuilder listItems = new StringBuilder();

        // A whole lot of code to ensure grammatical correctness...
        if (items.isEmpty()) {
            listItems.append("No items.\n");
            return listItems;
        } else if (items.size() == 1) {
            listItems.append(items.size()).append(" Item: ");
        } else {
            listItems.append(items.size()).append(" Items: ");
        }

        if (items.size() > 2) {
            int counter = items.size();

            for (Item item : items) {
                if (counter > 2) {
                   listItems.append(item.getName()).append(", ");
                   counter--;
                } else if (counter == 2) {
                    listItems.append(item.getName()).append(", & ");
                    counter--;
                } else {
                    listItems.append(item.getName()).append("\n");
                }
            }
        } else if (items.size() == 2) {
            listItems.append(items.getFirst().getName()).append(" & ").append(items.get(1).getName()).append("\n");
        } else {
            listItems.append(items.getFirst().getName()).append("\n");
        }

        return listItems;
    }

    /*
     * TO DO: Add a flag for whenever the player has explored the room.
     * Before exploration: Direction - Unexplored Room
     * After exploration: Direction - Room Name
     */
    private StringBuilder listDoors() {
        StringBuilder listDoors = new StringBuilder();
        listDoors.append("\n<Navigation>\n");

        if (north != null) {
            listDoors.append("North\n");
        } if (south != null) {
            listDoors.append("South\n");
        } if (east != null) {
            listDoors.append("East\n");
        } if (west != null) {
            listDoors.append("West\n");
        }

        return listDoors;
    }

    // Setters & Getters //
    public void setDoor(Door door, String direction) {
        switch (direction.toLowerCase()) {
            case "north":
                north = door;
                north.setRoom(this);
                break;

            case "south":
                south = door;
                south.setRoom(this);
                break;

            case "east":
                east = door;
                east.setRoom(this);
                break;

            case "west":
                west = door;
                west.setRoom(this);
                break;
        }
    }

    private ArrayList<Guard> getGuards() {
        ArrayList<Guard> guards = new ArrayList<>();
        for (NPC npc : NPCs) {
            if (npc instanceof Guard) {
                guards.add((Guard) npc);
            }
        }

        return guards;
    }

    private ArrayList<Maid> getMaids() {
        ArrayList<Maid> maids = new ArrayList<>();
        for (NPC npc : NPCs) {
            if (npc instanceof Maid) {
                maids.add((Maid) npc);
            }
        }

        return maids;
    }
}
