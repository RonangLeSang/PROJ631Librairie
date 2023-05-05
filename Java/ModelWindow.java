import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;

public class ModelWindow {

    private ArrayList<Book> bookList = new ArrayList<Book>();
    private ArrayList<User> userList = new ArrayList<User>();
    private ArrayList<Advice> adviceList = new ArrayList<Advice>();
    private JPanel displayedPanel = new JPanel();;

    public ModelWindow(){

        displayedPanel.setLayout(new BoxLayout(displayedPanel, BoxLayout.Y_AXIS));

        //TODO supprimer les exemples

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

        setDisplay(2);

    }

    public JPanel getDisplayedPanel() {
        return displayedPanel;
    }

    public void setDisplay(int index){
        displayedPanel = new JPanel();
        switch(index){
            case 1:
                for(Book book: bookList){
                    displayedPanel.add(new BoxItem(book));
                }
                break;
            case 2:
                for(User user: userList){
                    displayedPanel.add(new BoxItem(user));
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

}
