import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AddButtonListener implements ActionListener{

    private ModelWindow modelWindow;

    public AddButtonListener(ModelWindow modelWindow) {
        this.modelWindow = modelWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (modelWindow.getTab()){
            case 1:
                UserPopUp userPopUp = new UserPopUp();
                String[] userFields = userPopUp.getFields();
                User user = new User(userFields[0], userFields[3], java.sql.Date.valueOf(userFields[2]));
                try {
                    modelWindow.addItem(user.toSQL());
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                break;

            case 2:
                BookPopUp bookPopUp = new BookPopUp();
                String[] bookFields = bookPopUp.getFields();
                Book book = new Book(Integer.parseInt(bookFields[0]), bookFields[1], bookFields[2], bookFields[3],
                        bookFields[4], bookFields[5], java.sql.Date.valueOf(bookFields[6]),
                        Integer.parseInt(bookFields[7]), bookFields[8], bookFields[9]);
                try {
                    modelWindow.addItem(book.toSQL());
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                break;

            case 3:
                AdvicePopUp advicePopUp = new AdvicePopUp();
                String[] adviceFields = advicePopUp.getFields();
                Advice advice = new Advice(Integer.parseInt(adviceFields[0]), Integer.parseInt(adviceFields[2]),
                        java.sql.Date.valueOf(adviceFields[3]), Integer.parseInt(adviceFields[4]), adviceFields[5],
                        adviceFields[6], adviceFields[7]);
                try {
                    modelWindow.addItem(advice.toSQL());
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                break;
        }
    }
}
