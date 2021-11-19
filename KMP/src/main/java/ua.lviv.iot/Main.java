package ua.lviv.iot;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(find("yb", "rybybyb aboba yb"));
    }

    public static List<Integer> find(String pattern, String text) {
        List<Integer> piFunc = piFunc(pattern);
        List<Integer> indexes = new ArrayList<>();
        int k = 0;
        for (int i = 0; i < text.length(); ++i) {
            while (pattern.charAt(k) != text.charAt(i) && k > 0)
                k = piFunc.get(k - 1);

            if (pattern.charAt(k) == text.charAt(i)) {
                k++;
                if (k == pattern.length()) {
                    indexes.add(i + 1 - k);
                    k = piFunc.get(k - 1);
                }
            } else {
                k = 0;
            }
        }
        return indexes;
    }

    public static List<Integer> piFunc(String text) {
        List<Integer> piFunc = new ArrayList<>();
        piFunc.add(0);

        for (int i = 1; i < text.length(); i++) {
            int k = piFunc.get(i-1);
            while (text.charAt(k) != text.charAt(i) && k > 0)
                k = piFunc.get(k - 1);

            if (text.charAt(k) == text.charAt(i))
                piFunc.add(k + 1);
            else
                piFunc.add(0);
        }

        return piFunc;
    }
}
