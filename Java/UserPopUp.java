import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class UserPopUp extends PopUp{
    public static Object[] displayFields(){
        JTextField login = new JTextField(10);
        JTextField passeword = new JTextField(10);

        JPanel panel = new JPanel();
        panel.add(new JLabel("login :"));
        panel.add(login);
        panel.add(new JLabel("MDP   :"));
        panel.add(passeword);
        return null;

    }

    @Override
    public String[] getFields() {
        return new String[0];
    }
}
