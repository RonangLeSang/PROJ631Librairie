import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;

public class ValidateAddListener implements ActionListener {

    private JTextField login;
    private JTextField passeword;
    private ModelWindow modelWindow;
    private int type;
    private JTextField star;
    private JTextField idBook;
    private  JTextField comment;
    private JTextField loginA;
    private PopUp popUp;
    private JTextField idBookB;
    private JTextField title;
    private JTextField author;
    private JTextField genre;
    private JTextField publisher;
    private JTextField image;
    private JTextField dateDays;
    private JTextField dateYear;
    private JTextField dateMonth;
    private JTextField pageCount;
    private JTextField summary;
    private JTextField language;



    public ValidateAddListener(JTextField login, JTextField passeword, ModelWindow modelWindow, int type,PopUp popUp) {
        this.login = login;
        this.passeword = passeword;
        this.modelWindow = modelWindow;
        this.type = type;
        this.popUp=popUp;
    }
    public ValidateAddListener(JTextField login, JTextField idBook,JTextField star,JTextField comment, ModelWindow modelWindow, int type,PopUp popUp) {
        this.loginA = login;
        this.star = star;
        this.comment=comment;
        this.idBook=idBook;
        this.modelWindow = modelWindow;
        this.type = type;
        this.popUp=popUp;
    }
    public ValidateAddListener(JTextField idBookB,JTextField title, JTextField author, JTextField genre ,JTextField publisher, JTextField image,JTextField dateDays,JTextField dateMonth,JTextField dateYear, JTextField pageCount,JTextField summary, JTextField language,ModelWindow modelWindow,int type, PopUp popUp){
        this.idBookB=idBookB;
        this.title=title;
        this.author=author;
        this.genre=genre;
        this.publisher=publisher;
        this.image=image;
        this.dateYear=dateYear;
        this.dateDays=dateDays;
        this.dateMonth=dateMonth;
        this.pageCount=pageCount;
        this.summary=summary;
        this.language=language;
        this.type=type;
        this.popUp=popUp;
        this.modelWindow=modelWindow;
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
                popUp.dispose();
                break;

            case 2:
                String loginTextA=loginA.getText();
                String starText=star.getText();
                int nbrStar=Integer.parseInt(starText);
                String commentText=comment.getText();
                String idBookText=idBook.getText();
                int idBookInt=Integer.parseInt(idBookText);
                java.util.Date utilDateA = new java.util.Date();
                java.sql.Date sqlDateA = new java.sql.Date(utilDateA.getTime());

                Advice advice=new Advice(idBookInt,sqlDateA,nbrStar,commentText,loginTextA);
                try {
                    modelWindow.executeRequest(advice.toSQL());
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                popUp.dispose();
                break;

            case 3:
                String idBookBText=idBookB.getText();
                int idBookBInt=Integer.parseInt(idBookBText);

                String titleText=title.getText();
                String authorText=author.getText();
                String genreText=genre.getText();
                String publisherText=publisher.getText();
                String imageText=image.getText();

                String dateYT=dateYear.getText();
                String dateDT=dateYear.getText();
                String dateMT=dateYear.getText();

                int dateYI=Integer.parseInt(dateYT);
                int dateMI=Integer.parseInt(dateMT);
                int dateDI=Integer.parseInt(dateDT);


                Date date=new Date(dateYI,dateMI,dateDI);



                String pageText=pageCount.getText();
                int pageInt=Integer.parseInt(pageText);
                String summaryText=summary.getText();
                String languageText=language.getText();
                Book book=new Book(idBookBInt,titleText,authorText,genreText,publisherText,imageText,date,pageInt,summaryText,languageText);

                try {
                    modelWindow.executeRequest(book.toSQL());
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                popUp.dispose();
                break;
        }
    }
}
