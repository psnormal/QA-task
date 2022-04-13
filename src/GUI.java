import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

public class GUI extends JFrame{
    private JPanel panel;
    public JTextField textField1;
    public JComboBox comboBox1;
    public JButton button1;

    public GUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container content = getContentPane();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        String[] str = {"diag1Sym", "rot90Clock", "selfieAndDiag1"};
        comboBox1 = new JComboBox(str);
        content.add(textField1);
        content.add(comboBox1);

        this.button1.addActionListener(new TestActionListener());
        content.add(button1);
    }

     class TestActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String ans = "";
            String a = textField1.getText();
            if (Objects.equals((String)comboBox1.getSelectedItem(), "diag1Sym"))
            {
                ans = Solution.oper(Solution::diag1Sym, a);
            }
            else if (Objects.equals((String)comboBox1.getSelectedItem(), "rot90Clock"))
            {
                ans = Solution.oper(Solution::rot90Clock, a);
            }
            else if (Objects.equals((String)comboBox1.getSelectedItem(), "selfieAndDiag1"))
            {
                ans = Solution.oper(Solution::selfieAndDiag1, a);
            }
            textField1.setText(ans);
            try {
                JavaToDB.ResToDB((String)comboBox1.getSelectedItem(), a);
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (NoSuchMethodException ex) {
                ex.printStackTrace();
            } catch (InvocationTargetException ex) {
                ex.printStackTrace();
            } catch (InstantiationException ex) {
                ex.printStackTrace();
            } catch (IllegalAccessException ex) {
                ex.printStackTrace();
            }
        }
    }
}
