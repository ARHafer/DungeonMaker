public class Main {
    public static void main(String[] args) {
        Guard guard1 = new Guard("Guard 1", "Description");
        Guard guard2 = new Guard("Guard 2", "Description");
        Room room1 = new Room("Room 1", "Description");
        Room room2 = new Room("Room 2", "Description");

        room1.addGuard(guard1);
        room1.addGuard(guard2);

        System.out.println(room1.inspectString());
        System.out.println(room2.inspectString());
        System.out.println(guard1.inspectString());
    }
}
