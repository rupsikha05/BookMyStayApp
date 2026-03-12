import java.util.LinkedList;
import java.util.Queue;

public class BookingRequestQueue {

    private Queue<Reservation> requestQueue;

    public BookingRequestQueue() {
        requestQueue = new LinkedList<>();
    }

    public void addRequest(Reservation reservation) {

        requestQueue.add(reservation);

        System.out.println("Booking request added for "
                + reservation.getGuestName()
                + " (" + reservation.getRoomType() + ")");
    }

    public Reservation getNextRequest() {
        return requestQueue.poll();
    }
}