import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    //fenêtre principale

    private final ModelWindow modelWindow;
    private JScrollPane scrollingArea;
    private final JButton userButton = new JButton("utilisateurs");
    private final JButton bookButton = new JButton("livres");
    private final JButton adviceButton = new JButton("avis");

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

        JButton addButton = new JButton("ajouter");
        addButton.addActionListener(new AddButtonListener(modelWindow));
        userButton.addActionListener(new ItemListener(this, 1, userButton, modelWindow));
        bookButton.addActionListener(new ItemListener(this, 2, bookButton, modelWindow));
        adviceButton.addActionListener(new ItemListener(this, 3, adviceButton, modelWindow));

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

    //change la liste d'items à afficher
    public void setViewDisplay(int index){
        remove(scrollingArea);
        modelWindow.setDisplay(index);
        scrollingArea = new JScrollPane(modelWindow.getDisplayedPanel());
        add(scrollingArea, BorderLayout.CENTER);
        revalidate();
    }

    //enlève l'arrière plan des bouttons d'onglets
    public void resetButtonsDisplay(){
        bookButton.setBackground(null);
        userButton.setBackground(null);
        adviceButton.setBackground(null);
    }

}
