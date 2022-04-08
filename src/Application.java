import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Scanner in = new Scanner(System.in);
        String operator = in.next();
        String firstStr = in.next();

        JavaToDB.ResToDB(operator, firstStr);
    }
}
