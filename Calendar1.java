/**
 * Prints the calendars of all the years in the 20th century.
 */
public class Calendar1 {
    // Starting the calendar on 1/1/1900
    static int dayOfMonth = 1;
    static int month = 1;
    static int year = 1900;
    static int dayOfWeek = 2; // 1.1.1900 was a Monday
    static int nDaysInMonth = 31; // Number of days in January
    static int sundaysOn1st = 0;

    /**
     * Prints the calendars of all the years in the 20th century. Also prints the
     * number of Sundays that occured on the first day of the month during this
     * period.
     */
    public static void main(String args[]) {
        // Advances the date and the day-of-the-week from 1/1/1900 till 31/12/1999,
        // inclusive.
        // Prints each date dd/mm/yyyy in a separate line. If the day is a Sunday,
        // prints "Sunday".
        // The following variable, used for debugging purposes, counts how many days
        // were advanced so far.
        int debugDaysCounter = 0;
        //// Write the necessary initialization code, and replace the condition
        //// of the while loop with the necessary condition
        while (true) {
            //// Write the body of the while
            log();
            advance();
            debugDaysCounter++;
            //// If you want to stop the loop after n days, replace the condition of the
            //// if statement with the condition (debugDaysCounter == n)
            if (debugDaysCounter == 36525) {
                System.out.println();
                System.out.println(
                        "During the 20th century, " + sundaysOn1st + " Sundays fell on the first day of the month");
                break;
            }
        }
        //// Write the necessary ending code here
    }

    public static void log() {
        System.out.println(dayOfMonth + "/" + month + "/" + year + (dayOfWeek == 1 ? " Sunday" : ""));
    }

    // Advances the date (day, month, year) and the day-of-the-week.
    // If the month changes, sets the number of days in this month.
    // Side effects: changes the static variables dayOfMonth, month, year,
    // dayOfWeek, nDaysInMonth.
    private static void advance() {
        if (dayOfWeek == 1 && dayOfMonth == 1)
            sundaysOn1st++;
        dayOfWeek++;
        dayOfWeek = dayOfWeek == 8 ? 1 : dayOfWeek;
        dayOfMonth++;
        if (dayOfMonth > nDaysInMonth) {
            dayOfMonth = 1;
            month++;
            if (month == 13) {
                month = 1;
                year++;
            }
            nDaysInMonth = nDaysInMonth(month, year);
        }
    }

    // Returns true if the given year is a leap year, false otherwise.
    public static boolean isLeapYear(int year) {
        // Checks if the year is divisible by 400
        boolean isLeapYear = year % 400 == 0;
        // Then checks if the year is divisible by 4 but not by 100
        isLeapYear = isLeapYear || (year % 4 == 0 && year % 100 != 0);
        return isLeapYear;
    }

    // Returns the number of days in the given month and year.
    // April, June, September, and November have 30 days each.
    // February has 28 days in a common year, and 29 days in a leap year.
    // All the other months have 31 days.
    public static int nDaysInMonth(int month, int year) {
        int days = 0;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                days = 31;
                break;
            case 2:
                days = isLeapYear(year) ? 29 : 28;
                break;
            default:
                days = 30;
        }
        return days;
    }
}
