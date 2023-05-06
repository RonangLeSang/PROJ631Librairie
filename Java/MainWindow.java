import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class MainWindow extends JFrame {

    private ModelWindow modelWindow;
    private JScrollPane scrollingArea;
    private JButton userButton = new JButton("utilisateurs");
    private JButton bookButton = new JButton("livres");
    private JButton adviceButton = new JButton("avis");
    private JButton addButton = new JButton("ajouter");

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

        bookButton.addActionListener(new ItemListener(this, 1, bookButton));
        userButton.addActionListener(new ItemListener(this, 2, userButton));
        adviceButton.addActionListener(new ItemListener(this, 3, adviceButton));

        userButton.setBackground(Color.GRAY);

        tabsPanel.add(userButton);
        tabsPanel.add(bookButton);
        tabsPanel.add(adviceButton);
        addPanel.add(addButton);
        headPanel.add(tabsPanel, BorderLayout.WEST);
        headPanel.add(addPanel, BorderLayout.EAST);
        add(headPanel, BorderLayout.NORTH);

        setSize(720, 480);

        scrollingArea = new JScrollPane(modelWindow.getDisplayedPanel());
        add(scrollingArea, BorderLayout.CENTER);

        setVisible(true);
    }

    public void setViewDisplay(int index){
        remove(scrollingArea);
        modelWindow.setDisplay(index);
        scrollingArea = new JScrollPane(modelWindow.getDisplayedPanel());
        add(scrollingArea, BorderLayout.CENTER);
        revalidate();
    }

    public void resetButtonsDisplay(){
        bookButton.setBackground(null);
        userButton.setBackground(null);
        adviceButton.setBackground(null);
    }

}
