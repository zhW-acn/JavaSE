import java.util.LinkedHashMap;
import java.util.Map;

public class Try_LRU<K, V> extends LinkedHashMap<K, V> {

    public Try_LRU() {
        super(16, 0.75F, true);
    }

    public Try_LRU(int initialCapacity, float loadFactor) {
        super(initialCapacity, 0.75F, true);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > 3;//只能存三个，如果大于三个，最久被访问的会被删掉
    }

    public static void main(String[] args) {
        Map<String, String> map = new Try_LRU<>();
        map.put("a","aa");
        map.put("b","aa");
        map.put("c","aa");
        map.put("d","aa");
        map.get("a");
        map.get("c");
        map.get("d");
        map.get("b");
    }
}
