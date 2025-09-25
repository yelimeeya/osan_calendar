package com.osan.calendar.util;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.time.LocalDate;

public class DateParserUtil {
    public static LocalDate parseJsDateString(String jsDateString) {
        int idx = jsDateString.indexOf('(');
        if (idx != -1) {
            jsDateString = jsDateString.substring(0, idx).trim().replace("GMT ", "+");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd yyyy HH:mm:ss Z", Locale.ENGLISH);

        OffsetDateTime odt = OffsetDateTime.parse(jsDateString, formatter);
        return odt.toLocalDate();
    }
}