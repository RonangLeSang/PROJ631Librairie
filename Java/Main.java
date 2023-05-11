import java.awt.*;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {

        ModelWindow modelWindow = new ModelWindow(null);
        MainWindow window = new MainWindow(modelWindow);

//        EventQueue.invokeLater(new Runnable() {
//        public void run() {
//            String url = "jdbc:mysql://localhost:3306/terrasr";
//            String user = "terrasr";
//            String passwd = "x4cxcx9h";
////            Connection conn = null;
//            // L'essaie de connexion à votre base de données
//            try {
//                Class.forName("com.mysql.cj.jdbc.Driver");
//                System.out.println("oui");
//                Connection conn = DriverManager.getConnection(url, user, passwd);
//                System.out.println("Connecter");
//            } catch (Exception e) {
//                e.printStackTrace();
//                System.out.println("Erreur");
//                System.exit(0);
//            }
                // Le code à exécuter est à insérer ici.

//                ModelWindow modelWindow = new ModelWindow(conn);
//                MainWindow window = new MainWindow(modelWindow);
//            }
//    });
    }
}
