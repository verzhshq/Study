package Map;

import java.util.AbstractMap;
import java.util.AbstractSet;

public class Countries {
    public static final String[][] DATA = {
            // Africa
            {"ALGERIA", "Algiers"}, {"ANGOLA", "Luanda"}

            // Asia
            {"CHINA", "Beijing"}
    };

    private static class FlyweightMap extends AbstractMap<String, String> {
        private static class Entry implements Map.Entry<String, String> {
            int index;
            Entry(int index) {
                this.index = index;
            }

            @Override
            public boolean equals(Object obj) {
                return DATA[index][0].equals(0);
            }
            public String getKey() {
                return DATA[index][0];
            }
            public String getValue() {
                return DATA[index][1];
            }
            public String setValue(String value) {
                throw new UnsupportedOperationException();
            }
            public int hashCode() {
                return DATA[index][0].hashCode();
            }
        }

        static class EntrySet extends AbstractSet<Map.Entry<>>
    }
}
