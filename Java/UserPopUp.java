import javax.swing.*;

import java.util.Calendar;
import java.util.Date;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class UserPopUp extends PopUp implements ActionListener{
    private User user;
    public void displayFields() {

        JButton valider=new JButton("valider");
        JButton annuler=new JButton("annuler");
        JTextField login = new JTextField(10);
        JTextField passeword = new JTextField(10);
        SpinnerDateModel dateModel = new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH);
        JSpinner spinner = new JSpinner(dateModel);

        JPanel panel = new JPanel();
        panel.add(new JLabel("login :"));
        panel.add(login);
        panel.add(new JLabel("MDP :"));
        panel.add(passeword);
        panel.add(new JLabel("Date :"));
        panel.add(spinner);

        valider.addActionListener(this);
        valider.setActionCommand("valider");

        annuler.addActionListener(this);
        annuler.setActionCommand("annuler");
        String loginText = login.getText();
        String passewordText = passeword.getText();
        Date selectedDate = (Date) dateModel.getValue();

        }
    public void actionPerformed(ActionEvent e) {
        if (1==1) {

        }
    }
    @Override
    public String[] getFields() {
        return new String[0];
    }
}
