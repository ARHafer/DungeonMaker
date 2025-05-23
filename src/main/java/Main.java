import game.objects.characters.Guard;
import game.objects.characters.Maid;
import game.objects.environments.Door;
import game.objects.environments.Room;
import game.objects.items.Item;
import game.objects.items.Key;

public class Main {
    public static void main(String[] args) {
        Guard guard1 = new Guard("Guard 1", "Description");
        Guard guard2 = new Guard("Guard 2", "Description");
        Maid maid = new Maid("Maid", "Description");
        Item item1 = new Item("Item 1", "Description", 10, true, false);
        Item item2 = new Item("Item 2", "Description", 20, true, false);
        Item item3 = new Item("Item 3", "Description", 30, true, false);
        Key key = new Key("Key", "Description", "Door 1");
        Room room = new Room("Room", "Description");
        Door door1 = new Door("Door 1", "Description", true);
        Door door2 = new Door("Door 2", "Description", false);

        room.addNPC(guard1);
        room.addNPC(guard2);
        room.addNPC(maid);
        room.addItem(item1);
        room.addItem(item2);
        room.addItem(item3);
        room.setDoor(door1, "north");
        room.setDoor(door2, "south");

        System.out.println(room.inspectString());
        System.out.println(item1.inspectString());
        System.out.println(door1.inspectString());
        System.out.println(key.inspectString());
    }
}
