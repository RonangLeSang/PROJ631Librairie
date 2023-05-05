import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class MainWindow extends JFrame {

    private ModelWindow modelWindow;

    public MainWindow(ModelWindow modelWindow) {
        super("bibliothèque administrateur");

        this.modelWindow = modelWindow;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(new BorderLayout());
        JPanel tabsPanel = new JPanel();
        JPanel headPanel = new JPanel();
        JPanel addPanel = new JPanel();
        tabsPanel.setLayout(new FlowLayout());
        headPanel.setLayout(new BorderLayout());

        JButton userButton = new JButton("utilisateurs");
        JButton bookButton = new JButton("livres");
        JButton adviceButton = new JButton("avis");
        JButton addButton = new JButton("ajouter");

        tabsPanel.add(userButton);
        tabsPanel.add(bookButton);
        tabsPanel.add(adviceButton);
        addPanel.add(addButton);
        headPanel.add(tabsPanel, BorderLayout.WEST);
        headPanel.add(addPanel, BorderLayout.EAST);
        add(headPanel, BorderLayout.NORTH);

        setSize(720, 480);


//        JPanel items = new JPanel();
//        items.setLayout(new BoxLayout(items, BoxLayout.Y_AXIS));
//        items.add(new BoxItem(new User("oui", "non", new Date())));
//        items.add(new BoxItem(new User("oui", "non", new Date())));
//        items.add(new BoxItem(new User("oui", "non", new Date())));
//        items.add(new BoxItem(new User("oui", "non", new Date())));
//        items.add(new BoxItem(new User("oui", "non", new Date())));
//        items.add(new BoxItem(new User("oui", "non", new Date())));
//        items.add(new BoxItem(new User("oui", "non", new Date())));
//        items.add(new BoxItem(new User("oui", "non", new Date())));
//        items.add(new BoxItem(new User("oui", "non", new Date())));
//        items.add(new BoxItem(new User("oui", "non", new Date())));
//        items.add(new BoxItem(new User("oui", "non", new Date())));
//        items.add(new BoxItem(new User("oui", "non", new Date())));
//        items.add(new BoxItem(new User("oui", "non", new Date())));
//        items.add(new BoxItem(new User("oui", "non", new Date())));
//        items.add(new BoxItem(new User("oui", "non", new Date())));
//        items.add(new BoxItem(new User("oui", "non", new Date())));
//        items.add(new BoxItem(new User("oui", "non", new Date())));

        JScrollPane scrollingArea = new JScrollPane(modelWindow.getDisplayedPanel());
        add(scrollingArea, BorderLayout.CENTER);

        setVisible(true);
    }

}
