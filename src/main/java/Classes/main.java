package Classes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class main {
    public static void main(String[] args) {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = new GregorianCalendar(2015, 00,20).getTime();
        Date date1 = new GregorianCalendar(2016,01,20).getTime();
        System.out.println(simpleDateFormat.format(date1));
    }
}
