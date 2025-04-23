package lesson12;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTest {
    @Test
    @Tag("property")
    void systemProperties() {
        String browser = System.getProperty("browser", "mozilla");
        System.out.println("Browser property: " + browser);
    }
}
