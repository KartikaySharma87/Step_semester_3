import java.util.Scanner;

interface SaverMode {
    boolean supportsSaver();
}

abstract class Appliance {
    protected double hours;

    public Appliance(double hours) {
        this.hours = hours;
    }

    public abstract double getPowerRating();
    public abstract String getAppName();

    public double calculateUnits(boolean saverRequested) {
        double units = (getPowerRating() * hours) / 1000.0;
        if (saverRequested) {
            units *= 0.75;
        }
        return units;
    }

    public double calculateCost(boolean saverRequested) {
        return calculateUnits(saverRequested) * 8.0;
    }
}

class FridgeAppliance extends Appliance {
    public FridgeAppliance(double hours) {
        super(hours);
    }

    @Override
    public double getPowerRating() {
        return 150.0;
    }

    @Override
    public String getAppName() {
        return "FRIDGE";
    }
}

class ACAppliance extends Appliance implements SaverMode {
    public ACAppliance(double hours) {
        super(hours);
    }

    @Override
    public double getPowerRating() {
        return 1500.0;
    }

    @Override
    public String getAppName() {
        return "AC";
    }

    @Override
    public boolean supportsSaver() {
        return true;
    }
}

class TVAppliance extends Appliance {
    public TVAppliance(double hours) {
        super(hours);
    }

    @Override
    public double getPowerRating() {
        return 100.0;
    }

    @Override
    public String getAppName() {
        return "TV";
    }
}

class WasherAppliance extends Appliance implements SaverMode {
    public WasherAppliance(double hours) {
        super(hours);
    }

    @Override
    public double getPowerRating() {
        return 500.0;
    }

    @Override
    public String getAppName() {
        return "WASHER";
    }

    @Override
    public boolean supportsSaver() {
        return true;
    }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        scanner.nextLine();

        Appliance[] apps = new Appliance[n];
        boolean[] saverRequested = new boolean[n];

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            String type = parts[0];
            double hours = Double.parseDouble(parts[1]);
            boolean saver = parts.length > 2 && parts[2].equals("SAVER");

            saverRequested[i] = saver;
            if (type.equals("FRIDGE")) {
                apps[i] = new FridgeAppliance(hours);
            } else if (type.equals("AC")) {
                apps[i] = new ACAppliance(hours);
            } else if (type.equals("TV")) {
                apps[i] = new TVAppliance(hours);
            } else if (type.equals("WASHER")) {
                apps[i] = new WasherAppliance(hours);
            }
        }

        double totalCost = 0;
        for (int i = 0; i < n; i++) {
            Appliance app = apps[i];
            boolean saver = saverRequested[i];

            if (saver && !(app instanceof SaverMode)) {
                System.out.println(app.getAppName() + ": saver mode not supported");
            } else {
                double units = app.calculateUnits(saver);
                double cost = app.calculateCost(saver);
                totalCost += cost;
                System.out.printf("%s: Units=%.2f Cost=%.2f%n", app.getAppName(), units, cost);
            }
        }
        System.out.printf("Total Cost: %.2f%n", totalCost);
    }
}
