package week2.assigment_problems;

public class IsbnNormalizerValidator {

    public static String normalizeCode(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed;
        }
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    public static String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: wrong length";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: body must contain non-digit values";
            }
        }

        String pubCode = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(pubCode).append("] YEAR: ").append(year).append(" | CATALOG: ").append(catalog);

        return sb.toString();
    }

    public static void main(String[] args) {
        String raw1 = "pen2026004251";
        String normalized1 = normalizeCode(raw1);
        System.out.println(validateAndFormat(normalized1));

        String raw2 = "12N2026004251";
        String normalized2 = normalizeCode(raw2);
        System.out.println(validateAndFormat(normalized2));
    }
}
