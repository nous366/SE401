import java.util.HashMap;
import java.util.Map;

interface DataLookup {
    String getData(String key);
}

class DatabaseDataLookup implements DataLookup {
    public String getData(String key) {
        // Imagine accessing a database here
        return "Data for " + key;
    }
}

class CachingDataLookupProxy implements DataLookup {
    private DataLookup dataLookup;
    private Map<String, String> cache;

    public CachingDataLookupProxy(DataLookup dataLookup) {
        this.dataLookup = dataLookup;
        this.cache = new HashMap<>();
    }

    public String getData(String key) {
        if (!cache.containsKey(key)) {
            cache.put(key, dataLookup.getData(key));
        }
        return cache.get(key);
    }
}
public class Main {
    public static void main(String[] args) {
        DataLookup lookup = new CachingDataLookupProxy(new DatabaseDataLookup());
        System.out.println(lookup.getData("123"));  // Tải và lưu vào cache
        System.out.println(lookup.getData("123"));  // Truy xuất từ cache
    }
}
