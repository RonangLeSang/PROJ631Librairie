import javax.swing.*;
import java.awt.*;

public class BoxItem extends JPanel{

    public BoxItem(Item element, ModelWindow modelWindow) {
        JLabel title = new JLabel(element.toString());
        add(title);
        JButton suppressButton = new JButton("supprimer");
        add(suppressButton);
        suppressButton.addActionListener(new SuppressListener(modelWindow, element));
        setBorder(BorderFactory.createLineBorder(Color.black));
    }
}
