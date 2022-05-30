import java.util.ArrayList;
import java.util.List;

public class RailFenceCipher {
    public static void main(String[] args) {
        String s = "WEAREDISCOVEREDFLEEATONCE";
        int n = 3;

//      System.out.println(encode(s, n));
        System.out.println(decode(s, n));
    }

    public static StringBuilder encode(String s, int n) {
        int currentList = 0;
        int direction = 1;
        List<ArrayList<Character>> lists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lists.add(new ArrayList<>());
        }


        for (var symbol : s.toCharArray()) {
            if (currentList == 0) {
                direction = 1;
            }
            if (currentList == n - 1) {
                direction = -1;
            }
            lists.get(currentList).add(symbol);
            currentList += direction;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
            for (var symbol : lists.get(i))
                sb.append(symbol);
        return sb;
    }

    public static String decode(String s, int n) {
        int currentList = 1;
        int symbolNumber = 1;
        char[] sbChar = new char[s.length()];
        var chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (symbolNumber <= s.length()) {
                sbChar[symbolNumber - 1] = chars[i];
                if (n * 2 - 2 * currentList == 0)
                    symbolNumber += n * 2 - 2 * (n - currentList + 1);
                symbolNumber += n * 2 - 2 * currentList;
                i++;
            } else {
                currentList++;
                symbolNumber = currentList;
                i--;
                continue;
            }

            if (symbolNumber <= s.length()) {
                sbChar[symbolNumber - 1] = chars[i];
                if (n * 2 - 2 * (n - currentList + 1) == 0)
                    symbolNumber += n * 2 - 2 * currentList;
                symbolNumber += n * 2 - 2 * (n - currentList + 1);

            } else {
                currentList++;
                symbolNumber = currentList;
                i--;
            }

        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            sb.append(sbChar[i]);
        }

        return sb.toString();

    }
}
