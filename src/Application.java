import java.awt.*;
import java.lang.reflect.InvocationTargetException;

public class Application {
    public static void main(String[] args) {
        GUI form = new GUI();
        form.pack();
        form.setSize(new Dimension(500, 300));
        form.setVisible(true);
    }
}
