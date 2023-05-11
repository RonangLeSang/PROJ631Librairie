import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.awt.EventQueue;

public class ModelWindow {

    private Connection connection;
    private ArrayList<Book> bookList = new ArrayList<Book>();
    private ArrayList<User> userList = new ArrayList<User>();
    private ArrayList<Advice> adviceList = new ArrayList<Advice>();
    private JPanel displayedPanel = new JPanel();
    private int tab = 1;
    private MainWindow window = null;

    public ModelWindow(Connection connection) throws SQLException {

        this.connection = connection;
        displayedPanel.setLayout(new BoxLayout(displayedPanel, BoxLayout.Y_AXIS));
        setDisplay(1);

    }

    public void setTab(int tab){
        this.tab = tab;
    }

    public int getTab() {
        return tab;
    }

    public JPanel getDisplayedPanel() {
        return displayedPanel;
    }

    public void setDisplay(int index){
        displayedPanel = new JPanel();
        switch(index){
            case 1:
                for(User user: userList){
                    displayedPanel.add(new BoxItem(user, this));
                }
                break;
            case 2:
                for(Book book: bookList){
                    displayedPanel.add(new BoxItem(book, this));
                }
                break;
            case 3:
                for(Advice advice: adviceList){
                    displayedPanel.add(new BoxItem(advice, this));
                }
                break;
        }
        displayedPanel.setLayout(new BoxLayout(displayedPanel, BoxLayout.Y_AXIS));
    }

    public void refreshAll() throws SQLException {
        refreshUser();
        refreshAdvice();
        refreshBook();
        window.setViewDisplay(tab);
    }

    public void refreshUser() throws SQLException {
        ArrayList<User> userList = new ArrayList<User>();
        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery("SELECT * FROM utilisateur");

        while(res.next()){
            userList.add(new User(res));
        }
        this.userList = userList;
    }

    public void refreshBook() throws SQLException {
        ArrayList<Book> bookList = new ArrayList<Book>();
        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery("SELECT * FROM Livre");

        while(res.next()){
            bookList.add(new Book(res));
        }
        this.bookList = bookList;
    }

    public void refreshAdvice() throws SQLException {
        ArrayList<Advice> adviceList = new ArrayList<Advice>();
        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery("SELECT * FROM Avis");

        while(res.next()){
            adviceList.add(new Advice(res));
        }
        this.adviceList = adviceList;
    }

    public void executeRequest(String request) throws SQLException {
        System.out.println(request);
        Statement stmt = connection.createStatement();
        stmt.executeUpdate(request);
        refreshAll();
    }

    public void setWindow(MainWindow window) {
        this.window = window;
    }

    public MainWindow getWindow(){
        return window;
    }
}
