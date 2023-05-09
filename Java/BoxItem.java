import javax.swing.*;
import java.awt.*;

public class BoxItem extends JPanel{

    private Item element;
    private JButton suppressButton = new JButton("supprimer");
    private JLabel title;
    private ModelWindow modelWindow;

    public BoxItem(Item element, ModelWindow modelWindow) {
        this.element = element;
        title = new JLabel(element.toString());
        add(title);
        add(suppressButton);
        suppressButton.addActionListener(new SuppressListener(modelWindow, element));
        setBorder(BorderFactory.createLineBorder(Color.black));
    }
}
