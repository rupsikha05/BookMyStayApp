public class ConcurrentBookingProcessor implements Runnable {

    private BookingService bookingService;
    private Reservation reservation;

    public ConcurrentBookingProcessor(BookingService bookingService,
                                      Reservation reservation) {
        this.bookingService = bookingService;
        this.reservation = reservation;
    }

    @Override
    public void run() {

        synchronized (bookingService) {

            bookingService.processReservation(reservation);
        }
    }
}