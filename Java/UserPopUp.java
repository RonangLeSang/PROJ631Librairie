import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.util.Calendar;
import java.util.Date;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserPopUp extends PopUp {

    public void displayFields() {

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

        int result = JOptionPane.showConfirmDialog(null, panel, "Ajouter un utilisateur", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String loginText = login.getText();
            String passewordText = passeword.getText();
            Date selectedDate = (Date) dateModel.getValue();

            String url = "jdbc:mysql://localhost:3306/mydatabase";
            String user = "tafarou";
            String password = "rt45y8at";
            try {
                String sql = "INSERT INTO table (login, MDP, date_creation) VALUES (?, ?, ?)";
                Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, loginText);
                stmt.setString(2, passewordText);
                stmt.setDate(3, new java.sql.Date(selectedDate.getTime()));
                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected == 1) {
                    System.out.println("Données ajoutées avec succès !");
                } else {
                    System.out.println("Erreur lors de l'ajout des données.");
                }
                conn.close();
            } catch (SQLException e) {
                System.out.println("Erre ur lors de la  connexion à la base de données.");
                e.printStackTrace();
             }

        }
    }

    @Override
    public String[] getFields() {
        return new String[0];
    }
}
