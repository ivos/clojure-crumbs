package ccjava.mapliteral;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MapLiteralAsMap {
    public void sample() {
        Map<String, Object> person = new HashMap<>();
        person.put("firstName", "Joe");
        person.put("lastName", "Doe");
        person.put("age", 42);

        // maybe?
        person = Collections.unmodifiableMap(person);
    }
}
