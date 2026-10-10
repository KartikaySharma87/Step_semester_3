import java.time.LocalDate;
import java.util.Scanner;

abstract class Subscription {
    protected String name;
    protected LocalDate startDate;

    public Subscription(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public abstract int getValidityDays();
    public String getName() {
        return name;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
}

class BasicSubscription extends Subscription {
    public BasicSubscription(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public int getValidityDays() {
        return 30;
    }
}

class StandardSubscription extends Subscription {
    public StandardSubscription(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public int getValidityDays() {
        return 90;
    }
}

class PremiumSubscription extends Subscription {
    public PremiumSubscription(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public int getValidityDays() {
        return 365;
    }
}

public class StreamingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        Subscription[] subs = new Subscription[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            LocalDate startDate = LocalDate.parse(scanner.next());
            if (type.equals("BASIC")) {
                subs[i] = new BasicSubscription(name, startDate);
            } else if (type.equals("STANDARD")) {
                subs[i] = new StandardSubscription(name, startDate);
            } else if (type.equals("PREMIUM")) {
                subs[i] = new PremiumSubscription(name, startDate);
            }
        }

        for (Subscription s : subs) {
            LocalDate renewalDate = s.getStartDate().plusDays(s.getValidityDays());
            System.out.println(s.getName() + ": " + renewalDate);
        }
    }
}