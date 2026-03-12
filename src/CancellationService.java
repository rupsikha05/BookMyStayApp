public class CancellationService {

    private RoomInventory inventory;

    public CancellationService(RoomInventory inventory) {
        this.inventory = inventory;
    }

    public void cancelReservation(Reservation reservation) {

        String roomType = reservation.getRoomType();

        int available = inventory.getAvailability(roomType);

        inventory.updateAvailability(roomType, available + 1);

        System.out.println("Reservation cancelled for "
                + reservation.getGuestName());
    }
}