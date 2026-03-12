import java.util.*;

public class BookingService {

    private RoomInventory inventory;

    private Set<String> allocatedRoomIds;

    private Map<String, Set<String>> roomAssignments;

    public BookingService(RoomInventory inventory) {

        this.inventory = inventory;

        allocatedRoomIds = new HashSet<>();

        roomAssignments = new HashMap<>();
    }

    public void processReservation(Reservation reservation) {

        String roomType = reservation.getRoomType();

        int available = inventory.getAvailability(roomType);

        if (available <= 0) {

            System.out.println("No rooms available for " + roomType);
            return;
        }

        String roomId = roomType + "-" + UUID.randomUUID().toString().substring(0, 5);

        allocatedRoomIds.add(roomId);

        roomAssignments
                .computeIfAbsent(roomType, k -> new HashSet<>())
                .add(roomId);

        inventory.updateAvailability(roomType, available - 1);

        System.out.println("Reservation confirmed for "
                + reservation.getGuestName()
                + " | Room ID: " + roomId);
    }
}