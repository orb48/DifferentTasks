package AdditionTable;

import java.util.HashMap;
import java.util.Map;

public class HashMapNumbers {
    public static HashMap<Integer, String> getHashMap() {
        HashMap<Integer, String> hashMapNumbers = new HashMap<>();
        hashMapNumbers.put(0, "0");
        hashMapNumbers.put(1, "1");
        hashMapNumbers.put(2, "2");
        hashMapNumbers.put(3, "3");
        hashMapNumbers.put(4, "4");
        hashMapNumbers.put(5, "5");
        hashMapNumbers.put(6, "6");
        hashMapNumbers.put(7, "7");
        hashMapNumbers.put(8, "8");
        hashMapNumbers.put(9, "9");
        hashMapNumbers.put(10, "10");
        return hashMapNumbers;
    }

    public static Integer getKeyByValue(HashMap<Integer, String> hashMap, String value) {
        Integer key = null;
        for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
            if (value.equals(entry.getValue())) {
                key = entry.getKey();
            }
        }
        return key;
    }
}
