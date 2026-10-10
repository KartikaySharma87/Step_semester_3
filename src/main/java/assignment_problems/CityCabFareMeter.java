import java.util.Scanner;

interface NightServiceable {
    boolean supportsNightService();
}

abstract class Cab {
    protected double km;
    protected String time;
    protected static final double MIN_FARE = 100.0;

    public Cab(double km, String time) {
        this.km = km;
        this.time = time;
    }

    public abstract double calculateRatePerKm();
    public abstract String getCabName();

    public double calculateFare() {
        double fare = km * calculateRatePerKm();
        if (fare < MIN_FARE) {
            fare = MIN_FARE;
        }
        if (time.equals("NIGHT")) {
            fare *= 1.20;
        }
        return fare;
    }
}

class MiniCab extends Cab {
    public MiniCab(double km, String time) {
        super(km, time);
    }

    @Override
    public double calculateRatePerKm() {
        return 10.0;
    }

    @Override
    public String getCabName() {
        return "MINI";
    }
}

class SedanCab extends Cab implements NightServiceable {
    public SedanCab(double km, String time) {
        super(km, time);
    }

    @Override
    public double calculateRatePerKm() {
        return 14.0;
    }

    @Override
    public String getCabName() {
        return "SEDAN";
    }

    @Override
    public boolean supportsNightService() {
        return true;
    }
}

class SUVCab extends Cab implements NightServiceable {
    public SUVCab(double km, String time) {
        super(km, time);
    }

    @Override
    public double calculateRatePerKm() {
        return 18.0;
    }

    @Override
    public String getCabName() {
        return "SUV";
    }

    @Override
    public boolean supportsNightService() {
        return true;
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        Cab[] cabs = new Cab[n];
        String[] types = new String[n];

        for (int i = 0; i < n; i++) {
            types[i] = scanner.next();
            double km = scanner.nextDouble();
            String time = scanner.next();
            if (types[i].equals("MINI")) {
                cabs[i] = new MiniCab(km, time);
            } else if (types[i].equals("SEDAN")) {
                cabs[i] = new SedanCab(km, time);
            } else if (types[i].equals("SUV")) {
                cabs[i] = new SUVCab(km, time);
            }
        }

        double total = 0;
        for (int i = 0; i < n; i++) {
            Cab c = cabs[i];
            if (c.time.equals("NIGHT") && !(c instanceof NightServiceable)) {
                System.out.println(c.getCabName() + ": night service not available");
            } else {
                double fare = c.calculateFare();
                total += fare;
                System.out.printf("%s: %.2f%n", c.getCabName(), fare);
            }
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
