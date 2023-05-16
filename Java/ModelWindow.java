import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class ModelWindow {
    //Classe modèle pour la vue

    private final Connection connection;
    private ArrayList<Book> bookList = new ArrayList<>();
    private ArrayList<User> userList = new ArrayList<>();
    private ArrayList<Advice> adviceList = new ArrayList<>();
    private JPanel displayedPanel = new JPanel();
    private int tab = 1;
    private MainWindow window = null;

    public ModelWindow(Connection connection) throws SQLException {

        this.connection = connection;
        displayedPanel.setLayout(new BoxLayout(displayedPanel, BoxLayout.Y_AXIS));
        setDisplay(1);

    }

    //getters et setters
    public void setTab(int tab){
        this.tab = tab;
    }

    public int getTab() {
        return tab;
    }

    public JPanel getDisplayedPanel() {
        return displayedPanel;
    }

    public void setWindow(MainWindow window) {
        this.window = window;
    }

    //méthode permettant d'afficher une liste d'items suivant l'onglets sélectionné
    public void setDisplay(int index){
        displayedPanel = new JPanel();
        switch (index) {
            case 1 -> {
                for (User user : userList) {
                    displayedPanel.add(new BoxItem(user, this));
                }
            }
            case 2 -> {
                for (Book book : bookList) {
                    displayedPanel.add(new BoxItem(book, this));
                }
            }
            case 3 -> {
                for (Advice advice : adviceList) {
                    displayedPanel.add(new BoxItem(advice, this));
                }
            }
        }
        displayedPanel.setLayout(new BoxLayout(displayedPanel, BoxLayout.Y_AXIS));
    }

    //permet de rafraichir toutes les rubriques
    public void refreshAll() throws SQLException {
        refreshUser();
        refreshAdvice();
        refreshBook();
        window.setViewDisplay(tab);
    }

    //permet de rafraichir la rubrique utilisateur
    public void refreshUser() throws SQLException {
        ArrayList<User> userList = new ArrayList<>();
        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery("SELECT * FROM utilisateur");

        while(res.next()){
            userList.add(new User(res));
        }
        this.userList = userList;
    }

    //permet de rafraichir la rubrique livre
    public void refreshBook() throws SQLException {
        ArrayList<Book> bookList = new ArrayList<>();
        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery("SELECT * FROM Livre");

        while(res.next()){
            bookList.add(new Book(res));
        }
        this.bookList = bookList;
    }

    //permet de rafraichir la rubrique avis
    public void refreshAdvice() throws SQLException {
        ArrayList<Advice> adviceList = new ArrayList<>();
        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery("SELECT avis.id_livre, avis.login, avis.commentaire, avis.etoiles, " +
                "avis.date, livre.titre FROM avis JOIN livre ON livre.id_livre = avis.id_livre");

        while(res.next()){
            adviceList.add(new Advice(res));
        }
        this.adviceList = adviceList;
    }

    //execute la requête sql passée en paramètre
    public void executeRequest(String[] requests) throws SQLException {
        Statement stmt = connection.createStatement();
        for(String request : requests){
            stmt.executeUpdate(request);
        }
        refreshAll();
    }

}
