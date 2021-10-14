package test;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SnowFlakeTest {
    @Test
    public void test()
    {
        long nub=2199023255551L;
        Date date = new Date(nub);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-hh-dd HH:dd:mm");
        System.out.println(simpleDateFormat.format(date));
    }


}
