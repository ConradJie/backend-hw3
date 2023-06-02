import java.util.HashMap;

public class Translator {
    private HashMap<Integer, String> numericAlpha = new HashMap<>();

    Translator(Integer[] numeric, String[] alphabetic) {
        for (int i = 0; i < numeric.length; i++) {
            numericAlpha.put(numeric[i], alphabetic[i]);
        }
    }

    public String translate(Integer number) {
        return numericAlpha.get(number);
    }
}
