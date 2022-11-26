import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static java.time.temporal.ChronoUnit.DAYS;

public class NewThread extends Thread {
    @Override
    public void run() {
            LocalDate fromDate = LocalDate.now();
            LocalDate toDate = LocalDate.of(2022, 12, 31);

// Duration.between
            System.out.println("D - " + Duration.between(fromDate.atStartOfDay(), toDate.atStartOfDay()).toDays());


        
    }

    
}
