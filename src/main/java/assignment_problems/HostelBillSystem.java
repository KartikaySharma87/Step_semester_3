import java.util.Scanner;

abstract class Room {
    protected int units;

    public Room(int units) {
        this.units = units;
    }

    public abstract double calculateBill();
    public abstract String getTypeName();
}

class SingleRoom extends Room {
    public SingleRoom(int units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return 8.0 * units;
    }

    @Override
    public String getTypeName() {
        return "SINGLE";
    }
}

class SharedRoom extends Room {
    private int occupants;

    public SharedRoom(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    @Override
    public double calculateBill() {
        return (6.0 * units) / occupants;
    }

    @Override
    public String getTypeName() {
        return "SHARED";
    }
}

class ACRoom extends Room {
    public ACRoom(int units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return (10.0 * units) + 200.0;
    }

    @Override
    public String getTypeName() {
        return "AC";
    }
}

public class HostelBillSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        Room[] rooms = new Room[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int units = scanner.nextInt();
            if (type.equals("SINGLE")) {
                rooms[i] = new SingleRoom(units);
            } else if (type.equals("SHARED")) {
                int occupants = scanner.nextInt();
                rooms[i] = new SharedRoom(units, occupants);
            } else if (type.equals("AC")) {
                rooms[i] = new ACRoom(units);
            }
        }

        double grandTotal = 0;
        for (Room r : rooms) {
            double bill = r.calculateBill();
            grandTotal += bill;
            System.out.printf("%s: %.2f%n", r.getTypeName(), bill);
        }
        System.out.printf("Total: %.2f%n", grandTotal);
    }
}