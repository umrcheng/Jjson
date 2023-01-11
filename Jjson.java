import java.util.ArrayList;
import java.util.HashMap;

public class Jjson {
    /**
     * @param s json格式单对象的字符串
     * @return HashMap
     */
    public static HashMap jsonAnalysis(String s) {
        HashMap<String, String> json = new HashMap<>();
        ArrayList<String> tmp = new ArrayList<>();
        StringBuilder key = new StringBuilder();

        char chr;

        for (int i = 0; i < s.length(); i++) {
            chr = s.charAt(i);
            if (chr == '{' || chr == '}' || chr == ':' || chr == ',') {
                continue;
            }
            if (chr == '"') {
                if (!key.toString().equals(new StringBuilder().toString())) {
                    tmp.add(key.toString());
                    key = new StringBuilder();
                }
                continue;
            }

            key.append(chr);
        }

        for (int i = 0; i < tmp.size() - 1; i += 2) {
            json.put(tmp.get(i), tmp.get(i + 1));
        }

        return json;
    }
}
