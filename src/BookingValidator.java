public class BookingValidator {

    public void validateReservation(Reservation reservation) {

        if (reservation.getGuestName() == null ||
                reservation.getGuestName().isEmpty()) {

            throw new IllegalArgumentException("Guest name cannot be empty");
        }

        if (reservation.getRoomType() == null ||
                reservation.getRoomType().isEmpty()) {

            throw new IllegalArgumentException("Room type must be provided");
        }
    }
}