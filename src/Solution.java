import java.util.function.Function;

public class Solution {
    public static String diag1Sym(String strng) {
        char[][] let = returnArray(strng);
        int n = let.length;
        String result = "";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result += let[j][i];
            }
            if (i < n - 1)
            {
                result += "\n";
            }
        }
        return result;
    }

    public static String rot90Clock(String strng) {
        char[][] let = returnArray(strng);
        int n = let.length;
        String result = "";
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                result += let[j][i];
            }
            if (i < n - 1)
            {
                result += "\n";
            }
        }
        return result;
    }

    public static String selfieAndDiag1(String strng) {
        String[] strs = strng.split(" ");
        char[][] let = returnArray(strng);
        int n = let.length;
        String result = "";
        for (int i = 0; i < n; i++) {
            result += strs[i] + "|";
            for (int j = 0; j < n; j++) {
                result += let[j][i];
            }
            if (i < n - 1)
            {
                result += "\n";
            }
        }
        return result;
    }

    public static String oper(Function<String, String> operator, String s) {
        return operator.apply(s);
    }

    public static char[][] returnArray(String s) {
        String[] strs = s.split(" ");
        int n = strs.length;
        char[][] letters = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                letters[i][j] = strs[i].charAt(j);
            }
        }
        return letters;
    }
}
