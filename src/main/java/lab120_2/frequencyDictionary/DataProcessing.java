package lab120_2.frequencyDictionary;
import java.util.TreeMap;
public class DataProcessing {
    public TreeMap<String, Integer> dictionary (StringBuilder sb) {
        String[] f = sb.toString()
                .toLowerCase()
                .replaceAll("[,.!?:;(){}«*»…—\\[\\]]", "")
                .replaceAll("[\\s-]{2,}", " ")
                .split("[\\s]");
        TreeMap<String, Integer> dictionary = new TreeMap<>();
        int str = 0;
        while (str < f.length) {
            if(dictionary.containsKey(f[str])) {
                dictionary.put(f[str], dictionary.get(f[str]) +1);
            } else {dictionary.put(f[str], 1);}
            str++;
        }
        return dictionary;
    }
}
