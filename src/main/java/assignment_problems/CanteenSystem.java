import java.util.Scanner;

abstract class Customer {
    protected double amount;

    public Customer(double amount) {
        this.amount = amount;
    }

    public abstract double calculateFinalAmount();
    public abstract String getTypeName();
}

class StudentCustomer extends Customer {
    public StudentCustomer(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 0.90;
    }

    @Override
    public String getTypeName() {
        return "STUDENT";
    }
}

class StaffCustomer extends Customer {
    public StaffCustomer(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 0.95;
    }

    @Override
    public String getTypeName() {
        return "STAFF";
    }
}

class GuestCustomer extends Customer {
    public GuestCustomer(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount + 10.0;
    }

    @Override
    public String getTypeName() {
        return "GUEST";
    }
}

public class CanteenSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        Customer[] customers = new Customer[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double amount = scanner.nextDouble();
            if (type.equals("STUDENT")) {
                customers[i] = new StudentCustomer(amount);
            } else if (type.equals("STAFF")) {
                customers[i] = new StaffCustomer(amount);
            } else if (type.equals("GUEST")) {
                customers[i] = new GuestCustomer(amount);
            }
        }

        double grandTotal = 0;
        for (Customer c : customers) {
            double finalAmt = c.calculateFinalAmount();
            grandTotal += finalAmt;
            System.out.printf("%s: %.2f%n", c.getTypeName(), finalAmt);
        }
        System.out.printf("Total: %.2f%n", grandTotal);
    }
}
