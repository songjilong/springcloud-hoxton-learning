import org.junit.Test;

import java.time.ZonedDateTime;

/**
 * @author songjilong
 * @date 2020/4/25 16:28
 */
public class TimeTest {
    @Test
    public void test(){
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
    }
}
