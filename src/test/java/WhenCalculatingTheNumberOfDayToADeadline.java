import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import me.devduck.deadline.DeadlineCalculator;

/**
 * Created by catoda on 01.06.17.
 */
public class WhenCalculatingTheNumberOfDayToADeadline {

    private List<LocalDate> ignoringWeekendAndHoliday, ignoringWeekend, ignoringHoliday, ignoringNothing;
    private LocalDate startDate, stopDate;

    @Before
    public void Setup() {

        /*
        Stortingsvalg 11. september
         */

        startDate = LocalDate.of(2018, Month.SEPTEMBER, 6);
        stopDate = LocalDate.of(2018, Month.SEPTEMBER, 13);
        ignoringWeekendAndHoliday = DeadlineCalculator.daysUntilDeadline(startDate, stopDate, true, true);
        ignoringWeekend = DeadlineCalculator.daysUntilDeadline(startDate, stopDate, true, false);
        ignoringHoliday = DeadlineCalculator.daysUntilDeadline(startDate, stopDate, false, true);
        ignoringNothing = DeadlineCalculator.daysUntilDeadline(startDate, stopDate, false, false);
    }

    @Test
    public void ItShouldTakeWeekendAndHolidaysInToAccount() {
        Assert.assertTrue(ignoringWeekendAndHoliday.size() == 4);
    }

    @Test
    public void ItShouldTakeWeekendsInToAccount() {
        Assert.assertTrue(ignoringWeekend.size() == 5);
    }

    @Test
    public void ItShouldTakeHolidaysInToAccount() {
        Assert.assertTrue(ignoringHoliday.size() == 6);
    }

    @Test
    public void ItShouldCountAllDaysUntilDeadline() {
        Assert.assertTrue(ignoringNothing.size() == 7);

    }
}
