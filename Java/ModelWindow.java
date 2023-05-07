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

    public ModelWindow(Connection connection){

        this.connection = connection;
        displayedPanel.setLayout(new BoxLayout(displayedPanel, BoxLayout.Y_AXIS));

        //TODO supprimer les exemples \/ \/

        userList.add(new User("oui", "non", new Date()));
        userList.add(new User("oui", "non", new Date()));
        userList.add(new User("oui", "non", new Date()));
        userList.add(new User("oui", "non", new Date()));
        userList.add(new User("oui", "non", new Date()));
        userList.add(new User("oui", "non", new Date()));
        userList.add(new User("oui", "non", new Date()));
        userList.add(new User("oui", "non", new Date()));
        userList.add(new User("oui", "non", new Date()));
        userList.add(new User("oui", "non", new Date()));
        userList.add(new User("oui", "non", new Date()));
        userList.add(new User("oui", "non", new Date()));
        userList.add(new User("oui", "non", new Date()));

        adviceList.add(new Advice(3, 4, new java.sql.Date(2002, 2, 17), 4, "String comment", "String nameBook", "String nameUser"));
        adviceList.add(new Advice(3, 4, new java.sql.Date(2002, 2, 17), 4, "String comment", "String nameBook", "String nameUser"));
        adviceList.add(new Advice(3, 4, new java.sql.Date(2002, 2, 17), 4, "String comment", "String nameBook", "String nameUser"));
        adviceList.add(new Advice(3, 4, new java.sql.Date(2002, 2, 17), 4, "String comment", "String nameBook", "String nameUser"));
        adviceList.add(new Advice(3, 4, new java.sql.Date(2002, 2, 17), 4, "String comment", "String nameBook", "String nameUser"));
        adviceList.add(new Advice(3, 4, new java.sql.Date(2002, 2, 17), 4, "String comment", "String nameBook", "String nameUser"));
        adviceList.add(new Advice(3, 4, new java.sql.Date(2002, 2, 17), 4, "String comment", "String nameBook", "String nameUser"));
        adviceList.add(new Advice(3, 4, new java.sql.Date(2002, 2, 17), 4, "String comment", "String nameBook", "String nameUser"));
        adviceList.add(new Advice(3, 4, new java.sql.Date(2002, 2, 17), 4, "String comment", "String nameBook", "String nameUser"));
        adviceList.add(new Advice(3, 4, new java.sql.Date(2002, 2, 17), 4, "String comment", "String nameBook", "String nameUser"));
        adviceList.add(new Advice(3, 4, new java.sql.Date(2002, 2, 17), 4, "String comment", "String nameBook", "String nameUser"));
        adviceList.add(new Advice(3, 4, new java.sql.Date(2002, 2, 17), 4, "String comment", "String nameBook", "String nameUser"));
        adviceList.add(new Advice(3, 4, new java.sql.Date(2002, 2, 17), 4, "String comment", "String nameBook", "String nameUser"));
        adviceList.add(new Advice(3, 4, new java.sql.Date(2002, 2, 17), 4, "String comment", "String nameBook", "String nameUser"));
        adviceList.add(new Advice(3, 4, new java.sql.Date(2002, 2, 17), 4, "String comment", "String nameBook", "String nameUser"));
        adviceList.add(new Advice(3, 4, new java.sql.Date(2002, 2, 17), 4, "String comment", "String nameBook", "String nameUser"));
        adviceList.add(new Advice(3, 4, new java.sql.Date(2002, 2, 17), 4, "String comment", "String nameBook", "String nameUser"));
        adviceList.add(new Advice(3, 4, new java.sql.Date(2002, 2, 17), 4, "String comment", "String nameBook", "String nameUser"));

        bookList.add(new Book(1, "un livre", "author", "genre", "publisher", "image", new java.sql.Date(2002, 2, 17), 230, "summary", "language"));
        bookList.add(new Book(1, "un livre", "author", "genre", "publisher", "image", new java.sql.Date(2002, 2, 17), 230, "summary", "language"));
        bookList.add(new Book(1, "un livre", "author", "genre", "publisher", "image", new java.sql.Date(2002, 2, 17), 230, "summary", "language"));
        bookList.add(new Book(1, "un livre", "author", "genre", "publisher", "image", new java.sql.Date(2002, 2, 17), 230, "summary", "language"));
        bookList.add(new Book(1, "un livre", "author", "genre", "publisher", "image", new java.sql.Date(2002, 2, 17), 230, "summary", "language"));
        bookList.add(new Book(1, "un livre", "author", "genre", "publisher", "image", new java.sql.Date(2002, 2, 17), 230, "summary", "language"));
        bookList.add(new Book(1, "un livre", "author", "genre", "publisher", "image", new java.sql.Date(2002, 2, 17), 230, "summary", "language"));
        bookList.add(new Book(1, "un livre", "author", "genre", "publisher", "image", new java.sql.Date(2002, 2, 17), 230, "summary", "language"));
        bookList.add(new Book(1, "un livre", "author", "genre", "publisher", "image", new java.sql.Date(2002, 2, 17), 230, "summary", "language"));
        bookList.add(new Book(1, "un livre", "author", "genre", "publisher", "image", new java.sql.Date(2002, 2, 17), 230, "summary", "language"));
        bookList.add(new Book(1, "un livre", "author", "genre", "publisher", "image", new java.sql.Date(2002, 2, 17), 230, "summary", "language"));
        bookList.add(new Book(1, "un livre", "author", "genre", "publisher", "image", new java.sql.Date(2002, 2, 17), 230, "summary", "language"));
        bookList.add(new Book(1, "un livre", "author", "genre", "publisher", "image", new java.sql.Date(2002, 2, 17), 230, "summary", "language"));
        bookList.add(new Book(1, "un livre", "author", "genre", "publisher", "image", new java.sql.Date(2002, 2, 17), 230, "summary", "language"));
        bookList.add(new Book(1, "un livre", "author", "genre", "publisher", "image", new java.sql.Date(2002, 2, 17), 230, "summary", "language"));
        bookList.add(new Book(1, "un livre", "author", "genre", "publisher", "image", new java.sql.Date(2002, 2, 17), 230, "summary", "language"));
        bookList.add(new Book(1, "un livre", "author", "genre", "publisher", "image", new java.sql.Date(2002, 2, 17), 230, "summary", "language"));
        bookList.add(new Book(1, "un livre", "author", "genre", "publisher", "image", new java.sql.Date(2002, 2, 17), 230, "summary", "language"));
        bookList.add(new Book(1, "un livre", "author", "genre", "publisher", "image", new java.sql.Date(2002, 2, 17), 230, "summary", "language"));
        bookList.add(new Book(1, "un livre", "author", "genre", "publisher", "image", new java.sql.Date(2002, 2, 17), 230, "summary", "language"));
        bookList.add(new Book(1, "un livre", "author", "genre", "publisher", "image", new java.sql.Date(2002, 2, 17), 230, "summary", "language"));

        //TODO supprimer les exemples /\ /\

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
                    displayedPanel.add(new BoxItem(user));
                }
                break;
            case 2:
                for(Book book: bookList){
                    displayedPanel.add(new BoxItem(book));
                }
                break;
            case 3:
                for(Advice advice: adviceList){
                    displayedPanel.add(new BoxItem(advice));
                }
                break;
        }
        displayedPanel.setLayout(new BoxLayout(displayedPanel, BoxLayout.Y_AXIS));
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
        Statement stmt = connection.createStatement();
        stmt.executeQuery(request);
    }

}
