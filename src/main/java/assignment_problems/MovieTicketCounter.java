import java.util.Scanner;

abstract class Ticket {
    protected int count;
    protected static final double CONVENIENCE_FEE = 20.0;

    public Ticket(int count) {
        this.count = count;
    }

    public abstract double calculateBasePrice();
    public abstract String getSeatName();

    public double calculateTotalAmount() {
        return calculateBasePrice() + (count * CONVENIENCE_FEE);
    }
}

class RegularTicket extends Ticket {
    public RegularTicket(int count) {
        super(count);
    }

    @Override
    public double calculateBasePrice() {
        return count * 150.0;
    }

    @Override
    public String getSeatName() {
        return "REGULAR";
    }
}

class PremiumTicket extends Ticket {
    public PremiumTicket(int count) {
        super(count);
    }

    @Override
    public double calculateBasePrice() {
        return count * 250.0;
    }

    @Override
    public String getSeatName() {
        return "PREMIUM";
    }
}

class ReclinerTicket extends Ticket {
    public ReclinerTicket(int count) {
        super(count);
    }

    @Override
    public double calculateBasePrice() {
        return count * 400.0;
    }

    @Override
    public String getSeatName() {
        return "RECLINER";
    }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        Ticket[] tickets = new Ticket[n];

        for (int i = 0; i < n; i++) {
            String seat = scanner.next();
            int count = scanner.nextInt();
            if (seat.equals("REGULAR")) {
                tickets[i] = new RegularTicket(count);
            } else if (seat.equals("PREMIUM")) {
                tickets[i] = new PremiumTicket(count);
            } else if (seat.equals("RECLINER")) {
                tickets[i] = new ReclinerTicket(count);
            }
        }

        double grandTotal = 0;
        for (Ticket t : tickets) {
            double total = t.calculateTotalAmount();
            grandTotal += total;
            System.out.printf("%s: %.2f%n", t.getSeatName(), total);
        }
        System.out.printf("Total: %.2f%n", grandTotal);
    }
}