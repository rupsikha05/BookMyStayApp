public class RoomSearchService {

    private RoomInventory inventory;

    public RoomSearchService(RoomInventory inventory) {
        this.inventory = inventory;
    }

    public void searchAvailableRooms() {

        System.out.println("\nAvailable Rooms:\n");

        if (inventory.getAvailability("Single") > 0) {
            Room single = new SingleRoom();
            single.displayDetails();
            System.out.println("Available: " + inventory.getAvailability("Single") + "\n");
        }

        if (inventory.getAvailability("Double") > 0) {
            Room doubleRoom = new DoubleRoom();
            doubleRoom.displayDetails();
            System.out.println("Available: " + inventory.getAvailability("Double") + "\n");
        }

        if (inventory.getAvailability("Suite") > 0) {
            Room suite = new SuiteRoom();
            suite.displayDetails();
            System.out.println("Available: " + inventory.getAvailability("Suite"));
        }
    }
}