package publicTest;

import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

public class PublictTimeTest {

    @Test
    public void test()
    {
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
    }
}
