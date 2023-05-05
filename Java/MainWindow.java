import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

//    private ModelWindow modelWindow;

    public MainWindow() {
        super("bibliothèque administrateur");
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

        DefaultListModel<String> model = new DefaultListModel<>();



//        JList items = new JList<>(model);
        JList list = new JList(model);
        JScrollPane scrollingArea = new JScrollPane(list);
        add(scrollingArea, BorderLayout.CENTER);

        setVisible(true);
    }
}
