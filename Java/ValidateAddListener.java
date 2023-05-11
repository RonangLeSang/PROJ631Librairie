import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ValidateAddListener implements ActionListener {

    private JTextField login;
    private JTextField passeword;
    private ModelWindow modelWindow;
    private int type;

    public ValidateAddListener(JTextField login, JTextField passeword, ModelWindow modelWindow, int type) {
        this.login = login;
        this.passeword = passeword;
        this.modelWindow = modelWindow;
        this.type = type;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(type) {
            case 1:
                String loginText = login.getText();
                String passewordText = passeword.getText();

                java.util.Date utilDate = new java.util.Date();
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

                User user = new User(loginText, passewordText, sqlDate);
                try {
                    modelWindow.executeRequest(user.toSQL());
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                break;

            case 2:

                break;

            case 3:

                break;
        }
    }
}
