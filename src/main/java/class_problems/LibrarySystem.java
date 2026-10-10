import java.time.LocalDate;
import java.util.Scanner;

abstract class LibraryItem {
    protected String title;

    public LibraryItem(String title) {
        this.title = title;
    }

    public abstract int getBorrowingDays();
    public String getTitle() {
        return title;
    }
}

class Book extends LibraryItem {
    public Book(String title) {
        super(title);
    }

    @Override
    public int getBorrowingDays() {
        return 14;
    }
}

class DVD extends LibraryItem {
    public DVD(String title) {
        super(title);
    }

    @Override
    public int getBorrowingDays() {
        return 7;
    }
}

class Magazine extends LibraryItem {
    public Magazine(String title) {
        super(title);
    }

    @Override
    public int getBorrowingDays() {
        return 3;
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        scanner.nextLine();

        LocalDate currentDate = LocalDate.parse("2023-10-26");
        LibraryItem[] items = new LibraryItem[n];

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            int spaceIdx = line.indexOf(' ');
            String type = line.substring(0, spaceIdx);
            String title = line.substring(spaceIdx + 1).replace("\"", "");

            if (type.equals("BOOK")) {
                items[i] = new Book(title);
            } else if (type.equals("DVD")) {
                items[i] = new DVD(title);
            } else if (type.equals("MAGAZINE")) {
                items[i] = new Magazine(title);
            }
        }

        for (LibraryItem item : items) {
            LocalDate dueDate = currentDate.plusDays(item.getBorrowingDays());
            System.out.println(item.getTitle() + ": " + dueDate);
        }
    }
}