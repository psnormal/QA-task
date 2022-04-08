import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.Objects;

public class JavaToDB {
    private static final String url = "jdbc:mysql://localhost:3306/qa-task?serverTimezone=UTC";
    private static final String user = "root";
    private static final String password = "anna2003";

    public static void ResToDB(String operator, String firstStr) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        String ans = "";
        if (Objects.equals(operator, "diag1Sym"))
        {
            ans = Solution.oper(Solution::diag1Sym, firstStr);
        }
        else if (Objects.equals(operator, "rot90Clock"))
        {
            ans = Solution.oper(Solution::rot90Clock, firstStr);
        }
        else if (Objects.equals(operator, "selfieAndDiag1"))
        {
            ans = Solution.oper(Solution::selfieAndDiag1, firstStr);
        }
        String query = "INSERT answers(string_1, func, answer) VALUES (?, ?, ?);";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, firstStr);
            stmt.setString(2, operator);
            stmt.setString(3, ans);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
