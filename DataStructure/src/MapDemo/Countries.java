package MapDemo;

import java.util.*;

public class Countries {
    public static final String[][] DATA = {
            // Africa
            {"ALGERIA", "Algiers"}, {"ANGOLA", "Luanda"},

            // Asia
            {"CHINA", "Beijing"}
    };
    // Use AbstractMap by implementing entrySet()
    private static class FlyweightMap extends AbstractMap<String,String> {
        private static class Entry implements Map.Entry<String,String> {
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
        // Use AbstractSet by implementing size() & itertor()
        static class EntrySet extends AbstractSet<Map.Entry<String,String>> {
            private int size;
            EntrySet(int size) {
                if(size<0)
                    this.size = 0;
                // Can't be any bigger than the array;
                else if (size > DATA.length)
                    this.size = DATA.length;
                else
                    this.size = size;
            }
            public int size() {
                return size;
            }
            private class Iter implements Iterator<Map.Entry<String,String>> {
                // Only one Entry object per Iterator;
                private Entry entry = new Entry(-1);
                public boolean hasNext() {
                    return entry.index < size - 1;
                }
                public Map.Entry<String,String> next() {
                    entry.index++;
                    return entry;
                }
                public void remove() {
                    throw new UnsupportedOperationException();
                }
            }
            public Iterator<Map.Entry<String,String>> iterator() {
                return new Iter();
            }
        }
        private static Set<Map.Entry<String,String>> entries = new EntrySet(DATA.length);
        public Set<Map.Entry<String,String>> entrySet() {
            return entries;
        }
    }
    // Create a partial map of 'size' countries:
    static Map<String,String> select(final int size) {
        return new FlyweightMap() {
            public Set<Map.Entry<String,String>> entrySet() {
                return new EntrySet(size);
            }
        };
    }
    static Map<String,String> map = new FlyweightMap();
    public static Map<String,String> capitals() {
        return map; // The entire map
    }
    public static Map<String,String> capitals(int size) {
        return select(size);    // A partial map
    }
    static List<String> names = new ArrayList<>(map.keySet());
    // All the name:
    public static List<String> name() {
        return names;
    }
    // A partial list:
    public static List<String> names(int size) {
        return new ArrayList<>(select(size).keySet());
    }
    public static void main(String[] args) {

    }
}
