import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    public ValidateAddListener(JTextField idBook,JTextField title, JTextField author, JTextField genre JTextField)
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

                break;
        }
    }
}
