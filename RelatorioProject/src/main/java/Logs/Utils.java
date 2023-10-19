package Logs;
import java.time.LocalDate;

public abstract class Utils {
    public static LocalDate dtFromString(String s){
        String[] ymd = s.split("-");

        for (String string : ymd)
            string.replace("-", "");

        return LocalDate.of( Integer.parseInt(ymd[0]), Integer.parseInt(ymd[1]), Integer.parseInt(ymd[2]) ) ;
    }
}
