import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

class JavaToDBTest {
    private static final String url = "jdbc:mysql://localhost:3306/qa-task?serverTimezone=UTC";
    private static final String user = "root";
    private static final String password = "anna2003";

    private static void test(String expected, String actual) {
        assertEquals(expected, actual);
    }

    @Test
    void ResToDBTest_1() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        //тут мы вызываем функцию, в которой ответ высчитывается и отправляется в базу данных
        JavaToDB.ResToDB("diag1Sym", "AAA aaa AAA");
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        String query = "select answer from answers order by num desc limit 1";
        String actualAnswer = "";
        //а тут мы проверяем корректно ли записался ответ в базу данных, получая значение столбца answer из последней строки
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            actualAnswer = rs.getString("answer");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        test("AaA\nAaA\nAaA", actualAnswer);
    }

    @Test
    void ResToDBTest_2() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        //тут мы вызываем функцию, в которой ответ высчитывается и отправляется в базу данных
        JavaToDB.ResToDB("rot90Clock", "1234 5678 1357 2468");
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        String query = "select answer from answers order by num desc limit 1";
        String actualAnswer = "";
        //а тут мы проверяем корректно ли записался ответ в базу данных, получая значение столбца answer из последней строки
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            actualAnswer = rs.getString("answer");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        test("2151\n4362\n6573\n8784", actualAnswer);
    }

    @Test
    void ResToDBTest_3() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        //тут мы вызываем функцию, в которой ответ высчитывается и отправляется в базу данных
        JavaToDB.ResToDB("selfieAndDiag1", "A8b 71c .1_");
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        String query = "select answer from answers order by num desc limit 1";
        String actualAnswer = "";
        //а тут мы проверяем корректно ли записался ответ в базу данных, получая значение столбца answer из последней строки
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            actualAnswer = rs.getString("answer");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        test("A8b|A7.\n71c|811\n.1_|bc_", actualAnswer);
    }
}