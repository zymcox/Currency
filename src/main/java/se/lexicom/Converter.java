package se.lexicom;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Converter {
    private static final double SEK_TO_USD = 0.11;
    private static final double SEK_TO_EUR = 0.094;
    private static final double USD_TO_SEK = 9.1;
    private static final double USD_TO_EUR = 0.85;
    private static final double EUR_TO_SEK = 10.6;
    private static final double EUR_TO_USD = 1.18;

    public static String convert(String from, String to, double amount) {
        double rate = getExchangeRate(from, to);
        if (rate < 0) {
            return "Invalid currency selection.";
        }
        double result = amount * rate;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestamp = LocalDateTime.now().format(formatter);
        return String.format("Converted %.2f %s to %.2f %s on %s", amount, from, result, to, timestamp);
    }

    private static double getExchangeRate(String from, String to) {
        return switch (from + "_" + to) {
            case "SEK_USD" -> SEK_TO_USD;
            case "SEK_EUR" -> SEK_TO_EUR;
            case "USD_SEK" -> USD_TO_SEK;
            case "USD_EUR" -> USD_TO_EUR;
            case "EUR_SEK" -> EUR_TO_SEK;
            case "EUR_USD" -> EUR_TO_USD;
            default -> -1;
        };
    }
}
