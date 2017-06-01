package me.devduck.deadline;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class DeadlineCalculator {

    public static  List<LocalDate> daysUntilDeadline(LocalDate currentDate, LocalDate deadlineDate, boolean ignoreWeekends, boolean ignoreHolidays) {
        ArrayList<LocalDate> daysUntil = new ArrayList();

        while (currentDate.isBefore(deadlineDate)) {
            if (ignoreHolidays && isHoliday(currentDate) || ignoreWeekends && isWeekend(currentDate)) {
                currentDate = currentDate.plusDays(1);
            } else {
                daysUntil.add(currentDate);
                currentDate = currentDate.plusDays(1);
            }
        }
        return daysUntil;
    }

    /*
      hardcoded: Stortingsvalg 11. september 2018
     */
    private static boolean isHoliday(LocalDate date) {
        // very temporary implementation
        if (date.isEqual(LocalDate.of(2018, Month.SEPTEMBER, 11))) {
            return true;
        }
        else {
            return false;
        }
    }

    private static boolean isWeekend(LocalDate date) {
        return date.getDayOfWeek() == DayOfWeek.SATURDAY ||
                date.getDayOfWeek() == DayOfWeek.SUNDAY;
    }

    /*** Kunne brukt denne for å ***/
    public static ArrayList<LocalDate> getDatesBetween(LocalDate startDate, LocalDate endDate) {

        ArrayList<LocalDate> dates = new ArrayList<>(); // does not have the size, use dynamic list

        LocalDate currentDate = startDate;

        while (currentDate.isBefore(endDate)) {
            dates.add(currentDate);
            currentDate = currentDate.plusDays(1);
        }

        return dates;
    }

    /*
    public static LocalDate[] getDatesBetween(LocalDate startDate, LocalDate endDate) {

        //LocalDate[] dates = new LocalDate[]; // missing size

        LocalDate currentDate = startDate.plusDays(1);

        // if we pass invalid dates the loop does not exit, even if comparator would have worked

        // comparator is not valid for our purpose
        while (currentDate != endDate) { // assumes LocalDate implements comparable, LocalDate
            //dates.add(currentDate); // array has no add <-- use list or index
            currentDate = currentDate.plusDays(1);
        }

        return dates;
    }
    */

}
