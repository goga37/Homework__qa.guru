package lesson9;

import com.google.gson.Gson;
import lesson9.model.Earthshaker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStreamReader;
import java.io.Reader;

public class JsonParsingTest {
    private final ClassLoader cl = JsonParsingTest.class.getClassLoader();
    private static final Gson gson = new Gson();
        @Test
        void jsonFileParsingImprovedTest() throws Exception {
            try (Reader reader = new InputStreamReader(
                    cl.getResourceAsStream("earthshaker.json"))) {
                Earthshaker actual = gson.fromJson(reader, Earthshaker.class);
                Assertions.assertEquals("Earthshaker", actual.getName());
                Assertions.assertEquals("close combat", actual.getTypeOfAttack());
                Assertions.assertEquals("attribute", actual.getAttribute());
                Assertions.assertEquals(22, actual.getStartingAttributes().getStrength());
                Assertions.assertEquals(12, actual.getStartingAttributes().getDexterity());
                Assertions.assertEquals(18, actual.getStartingAttributes().getIntelligence());
            }
        }
    }