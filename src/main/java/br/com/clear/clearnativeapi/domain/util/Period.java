package br.com.clear.clearnativeapi.domain.util;

import java.text.DateFormatSymbols;
import java.util.Locale;

public abstract class Period {
    private static final Locale LOCALE = new Locale.Builder().setLanguage("pt").setRegion("BR").build();

    public static String getMonthName(String month) {
        return new DateFormatSymbols(LOCALE).getMonths()[getMothByName(month) - 1];
    }

    public static String getMonthName(int month) {
        return new DateFormatSymbols(LOCALE).getMonths()[month - 1];
    }

    public static String getShortMonthName(int month) {
        return new DateFormatSymbols(LOCALE).getShortMonths()[month - 1];
    }

    public static Integer getMothByName(String month) {
        return switch (month.toUpperCase()) {
            case "JANEIRO" -> 1;
            case "FEVEREIRO" -> 2;
            case "MARÇO", "MARCO" -> 3;
            case "ABRIL" -> 4;
            case "MAIO" -> 5;
            case "JUNHO" -> 6;
            case "JULHO" -> 7;
            case "AGOSTO" -> 8;
            case "SETEMBRO" -> 9;
            case "OUTUBRO" -> 10;
            case "NOVEMBRO" -> 11;
            case "DEZEMBRO" -> 12;
            default -> throw new IllegalStateException("Unexpected value: " + month);
        };
    }
}
