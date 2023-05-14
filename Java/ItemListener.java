import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ItemListener implements ActionListener {
    private final MainWindow mainWindow;
    private final int index;
    private final JButton button;
    private final ModelWindow modelWindow;

    public ItemListener(MainWindow mainWindow, int index, JButton button, ModelWindow modelWindow) {
        this.mainWindow = mainWindow;
        this.index = index;
        this.button = button;
        this.modelWindow = modelWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mainWindow.resetButtonsDisplay();
        button.setBackground(Color.GRAY);
        mainWindow.setViewDisplay(index);
        modelWindow.setTab(index);
    }
}
