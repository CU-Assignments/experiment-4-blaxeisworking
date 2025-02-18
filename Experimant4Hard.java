import java.util.*;

class TicketBookingSystem {
    private final int totalSeats;
    private final boolean[] seats;

    public TicketBookingSystem(int totalSeats) {
        this.totalSeats = totalSeats;
        this.seats = new boolean[totalSeats];
    }

    public synchronized boolean bookSeat(int seatNumber, String customer) {
        if (seatNumber < 0 || seatNumber >= totalSeats) {
            System.out.println(customer + " attempted to book an invalid seat: " + seatNumber);
            return false;
        }
        if (!seats[seatNumber]) {
            seats[seatNumber] = true;
            System.out.println(customer + " successfully booked seat " + seatNumber);
            return true;
        } else {
            System.out.println(customer + " attempted to book an already booked seat: " + seatNumber);
            return false;
        }
    }
}

class Customer extends Thread {
    private final TicketBookingSystem bookingSystem;
    private final int seatNumber;
    private final String name;

    public Customer(TicketBookingSystem bookingSystem, int seatNumber, String name, int priority) {
        this.bookingSystem = bookingSystem;
        this.seatNumber = seatNumber;
        this.name = name;
        setPriority(priority);
    }

    @Override
    public void run() {
        bookingSystem.bookSeat(seatNumber, name);
    }
}

public class TicketBookingApp {
    public static void main(String[] args) {
        TicketBookingSystem system = new TicketBookingSystem(10);
        List<Customer> customers = new ArrayList<>();

        customers.add(new Customer(system, 3, "VIP-1", Thread.MAX_PRIORITY));
        customers.add(new Customer(system, 3, "Regular-1", Thread.NORM_PRIORITY));
        customers.add(new Customer(system, 5, "VIP-2", Thread.MAX_PRIORITY));
        customers.add(new Customer(system, 5, "Regular-2", Thread.NORM_PRIORITY));

        Collections.shuffle(customers);

        for (Customer customer : customers) {
            customer.start();
        }
    }
}
