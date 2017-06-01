import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import me.devduck.deadline.DeadlineCalculator;

/**
 * Created by taco on 01.06.2017.
 */
public class WhenGettingDatesBetweenTwoGivenDates {


    @Before
    public void Setup() {
    }

    @Test
    public void ItShouldGetAllDatesIncludingStartDate() {
        ArrayList<LocalDate> fest = DeadlineCalculator.getDatesBetween(LocalDate.of(1982, Month.JANUARY, 1),
                LocalDate.of(1982, Month.DECEMBER, 31));

    }
}
