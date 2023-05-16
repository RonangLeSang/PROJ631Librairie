import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;

public class ValidateAddListener implements ActionListener {
    /*
    * Classe écouteur permettant d'écouter le bouton de confirmation de création d'item
    * */

    private JTextField login;
    private JTextField passeword;
    private final ModelWindow modelWindow;
    private final int type;
    private JTextField star;
    private JTextField idBook;
    private  JTextField comment;
    private JTextField loginA;
    private final PopUp popUp;
    private JTextField title;
    private JTextField author;
    private JTextField genre;
    private JTextField publisher;
    private JTextField image;
    private JTextField dateYear;
    private JTextField dateMonth;
    private JTextField dateDays;
    private JTextField pageCount;
    private JTextField summary;
    private JTextField language;


    //Constructeur pour écouter la création d'un nouvel utilisateur
    public ValidateAddListener(JTextField login, JTextField passeword, ModelWindow modelWindow, int type,PopUp popUp) {
        this.login = login;
        this.passeword = passeword;
        this.modelWindow = modelWindow;
        this.type = type;
        this.popUp=popUp;
    }
    //Constructeur pour écouter la création d'un nouvel avis
    public ValidateAddListener(JTextField login, JTextField idBook,JTextField star,JTextField comment, ModelWindow modelWindow, int type,PopUp popUp) {
        this.loginA = login;
        this.star = star;
        this.comment=comment;
        this.idBook=idBook;
        this.modelWindow = modelWindow;
        this.type = type;
        this.popUp=popUp;
    }
    //Constructeur pour écouter la création d'un nouveau livre
    public ValidateAddListener(JTextField title, JTextField author, JTextField genre ,JTextField publisher, JTextField image,JTextField dateDays,JTextField dateMonth,JTextField dateYear, JTextField pageCount,JTextField summary, JTextField language,ModelWindow modelWindow,int type, PopUp popUp){
        this.title=title;
        this.author=author;
        this.genre=genre;
        this.publisher=publisher;
        this.image=image;
        this.dateYear=dateYear;
        this.dateMonth=dateMonth;
        this.dateDays=dateDays;
        this.pageCount=pageCount;
        this.summary=summary;
        this.language=language;
        this.type=type;
        this.popUp=popUp;
        this.modelWindow=modelWindow;
    }
    //ajoute à la bdd un nouvel item
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (type) {
            case 1 -> {
                String loginText = login.getText();
                String passewordText = passeword.getText();
                java.util.Date utilDate = new java.util.Date();
                Date sqlDate = new Date(utilDate.getTime());
                User user = new User(loginText, passewordText, sqlDate);
                try {
                    modelWindow.executeRequest(user.toSQL());
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                popUp.dispose();
            }
            case 2 -> {
                String loginTextA = loginA.getText();
                String starText = star.getText();
                int nbrStar = Integer.parseInt(starText);
                String commentText = comment.getText();
                String idBookText = idBook.getText();
                int idBookInt = Integer.parseInt(idBookText);
                java.util.Date utilDateA = new java.util.Date();
                Date sqlDateA = new Date(utilDateA.getTime());
                Advice advice = new Advice(idBookInt, sqlDateA, nbrStar, commentText, loginTextA);
                try {
                    modelWindow.executeRequest(advice.toSQL());
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                popUp.dispose();
            }
            case 3 -> {
                String titleText = title.getText();
                String authorText = author.getText();
                String genreText = genre.getText();
                String publisherText = publisher.getText();
                String imageText = image.getText();
                String dateYT = dateYear.getText();
                String dateDT = dateDays.getText();
                String dateMT = dateMonth.getText();
                int dateYI = Integer.parseInt(dateYT) - 1900;
                int dateMI = Integer.parseInt(dateMT);
                int dateDI = Integer.parseInt(dateDT);
                Date date = new Date(dateYI, dateMI, dateDI);
                String pageText = pageCount.getText();
                int pageInt = Integer.parseInt(pageText);
                String summaryText = summary.getText();
                String languageText = language.getText();
                Book book = new Book(titleText, authorText, genreText, publisherText, imageText, date, pageInt, summaryText, languageText);
                try {
                    modelWindow.executeRequest(book.toSQL());
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                popUp.dispose();
            }
        }
    }
}
