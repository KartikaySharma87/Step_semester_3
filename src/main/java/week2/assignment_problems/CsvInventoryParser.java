package week2.assigment_problems;

public class CsvInventoryParser {

    public static void parseInventoryRecord(String csvLine) {
        String[] fields = csvLine.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String productName = fields[0].trim();
        String sku = fields[1].trim();
        String qty = fields[2].trim();

        System.out.println("Product: " + productName + " | SKU: " + sku + " | Qty: " + qty);
    }

    public static void main(String[] args) {
        parseInventoryRecord("Wireless Mouse, WM-2201,150");
        parseInventoryRecord("Wireless Mouse, 150");
    }
}