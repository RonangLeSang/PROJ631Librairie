import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ItemListener implements ActionListener {
    private MainWindow mainWindow;
    private int index;
    private JButton button;

    public ItemListener(MainWindow mainWindow, int index, JButton button) {
        this.mainWindow = mainWindow;
        this.index = index;
        this.button = button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mainWindow.resetButtonsDisplay();
        button.setBackground(Color.GRAY);
        mainWindow.setViewDisplay(index);
    }
}
