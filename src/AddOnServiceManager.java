import java.util.*;

public class AddOnServiceManager {

    private Map<String, List<Service>> reservationServices;

    public AddOnServiceManager() {

        reservationServices = new HashMap<>();
    }

    public void addService(String reservationId, Service service) {

        reservationServices
                .computeIfAbsent(reservationId, k -> new ArrayList<>())
                .add(service);

        System.out.println(service.getName() + " added to reservation " + reservationId);
    }

    public double calculateTotalCost(String reservationId) {

        double total = 0;

        List<Service> services = reservationServices.getOrDefault(reservationId, new ArrayList<>());

        for (Service s : services) {
            total += s.getCost();
        }

        return total;
    }
}