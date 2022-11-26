import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        NewThread thread = new NewThread();

        while (true){
            thread.run();
        }



    }
}
