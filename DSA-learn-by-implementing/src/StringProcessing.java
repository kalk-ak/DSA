import java.util.HashMap;
import java.util.Map;

public class StringProcessing {
    public static int findBrute(char[] text, char[] pattern) {
        int n = text.length;
        int m = pattern.length;

        for (int i=0; i < n; i++) {
            int k = 0;
            while (text[i + k] == pattern[k] && (k < m))
                k++;
            if (k == m)
                return i;
        }
        return -1;
    }

}
