import java.awt.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            String url = "jdbc:mysql://localhost:3306/tafarou";
            String user = "root";
            String passwd = "";
            Connection conn = null;
            // L'essaie de connexion à votre base de données
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(url, user, passwd);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Erreur");
                System.exit(0);
            }

            ModelWindow modelWindow;
            try {
                modelWindow = new ModelWindow(conn);
                MainWindow window = new MainWindow(modelWindow);
                modelWindow.setWindow(window);
                modelWindow.refreshAll();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
