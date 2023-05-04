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
        this.add(headPanel, BorderLayout.NORTH);

        setSize(720,480);
        setVisible(true);

        DefaultListModel<String> model = new DefaultListModel<>();
        model.addElement("1");
        model.addElement("1");
        model.addElement("1");
        model.addElement("1");
        model.addElement("1");
        model.addElement("1");
        model.addElement("1");
        model.addElement("1");
        model.addElement("1");
        model.addElement("1");
        model.addElement("1");
        model.addElement("1");
        model.addElement("1");
        model.addElement("1");
        model.addElement("1");
        model.addElement("1");
        model.addElement("1");
        model.addElement("1");
        model.addElement("1");
        model.addElement("1");
        model.addElement("1");
        model.addElement("1");
        model.addElement("1");
//        model.addElement("1");
//        model.addElement("1");
//        model.addElement("1");
//        model.addElement("1");
//        model.addElement("1");
//        model.addElement("1");
//        model.addElement("1");
//        model.addElement("1");
//        model.addElement("1");

        JList items = new JList<>(model);

//        add(items);

        JScrollPane scrollingArea = new JScrollPane();
        scrollingArea.setViewportView(items);
        items.setLayoutOrientation(JList.VERTICAL);

        this.add(scrollingArea, BorderLayout.SOUTH);
    }
}
