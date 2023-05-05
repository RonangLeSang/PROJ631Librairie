import javax.swing.*;
import java.awt.*;

public class BoxItem extends JPanel{

    private Item element;
    private JButton suppressButton = new JButton("supprimer");
    private JLabel title;

    public BoxItem(Item element) {
        this.element = element;
        title = new JLabel(element.toString());
        add(title);
        add(suppressButton);
        setBorder(BorderFactory.createLineBorder(Color.black));
    }
}
