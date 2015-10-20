/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luciolecompta;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

/**
 * Helper functions for handling dates.
 *
 * @author Marco Jakob
 */
public class DateUtil {

    public static DateFormat OUT_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    /** The date pattern that is used for conversion. Change as you wish. */
    private static final String DATE_PATTERN = "yyyy-MM-dd";

    /** The date formatter. */
    private static final DateTimeFormatter DATE_FORMATTER =
            DateTimeFormatter.ofPattern(DATE_PATTERN);

    /**
     * Returns the given date as a well formatted String. The above defined
     * {@link DateUtil#DATE_PATTERN} is used.
     *
     * @param date the date to be returned as a string
     * @return formatted string
     */
    public static String format(LocalDate date) {
        if (date == null) {
            return null;
        }
        return DATE_FORMATTER.format(date);
    }

    /**
     * Converts a String in the format of the defined {@link DateUtil#DATE_PATTERN}
     * to a {@link LocalDate} object.
     *
     * Returns null if the String could not be converted.
     *
     * @param dateString the date as String
     * @return the date object or null if it could not be converted
     */
    public static LocalDate parse(String dateString) {
        try {
            return DATE_FORMATTER.parse(dateString, LocalDate::from);
        } catch (DateTimeParseException e) {
            return null;
        }
    }
    
     /**
     * Converts a String in the format of the defined {@link DateUtil#DATE_PATTERN}
     * to a {@link LocalDate} object.
     *
     * Returns null if the String could not be converted.
     *
     * @param dateString the date as String
     * @return the date object or null if it could not be converted
     * @author : Karakayn
     */
    public static Date parseDate(String dateString) {
        try {
            return new Date(dateString);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    /**
     * Checks the String whether it is a valid date.
     *
     * @param dateString
     * @return true if the String is a valid date
     */
    public static boolean validDate(String dateString) {
        // Try to parse the String.
        return DateUtil.parse(dateString) != null;
    }
    
    /**
     * Convert an object to a Date, without an Exception (i hope?)
     * @param value
     * @return 
     * @author Robin Sharp
     */
    public static java.sql.Date getDate(Object value){
        try{
            return toDate(value);
        }catch(ParseException parceE){
            parceE.printStackTrace();
            System.out.println("Exception dans getDate");
            return null;
        }
    }
    /**
     * Convert an object to a Date
     * @param value
     * @return a valid date
     * @throws ParseException 
     * @author Robin Sharp
     */
    public static java.sql.Date toDate(Object value) throws ParseException{
        if(value == null)
            return null;
        if(value instanceof java.sql.Date)
            return (java.sql.Date)value;
        if(value instanceof String){
            if("".equals((String)value))
                return null;
            return new java.sql.Date(OUT_DATE_FORMAT.parse((String)value).getTime());
        }
        return new java.sql.Date(OUT_DATE_FORMAT.parse((String)value).getTime());
    }
}
