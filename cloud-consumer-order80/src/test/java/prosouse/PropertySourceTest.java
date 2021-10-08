package prosouse;

import org.junit.jupiter.api.Test;
import org.springframework.core.env.MapPropertySource;

import java.util.Arrays;
import java.util.HashMap;

public class PropertySourceTest {

    @Test
    public void test()
    {
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("name","瑟莉亚");
        stringObjectHashMap.put("order","小老师");
        MapPropertySource source = new MapPropertySource("source", stringObjectHashMap);
        boolean name1 = source.containsProperty("name");
        System.out.println(name1);
        boolean oder = source.containsProperty("oder");
        System.out.println(oder);
        String[] propertyNames = source.getPropertyNames();
        Arrays.stream(propertyNames).forEach(System.out::println);
        String name = source.getName();
        System.out.println(name);
    }
}
