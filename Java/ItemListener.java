import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ItemListener implements ActionListener {
    private MainWindow mainWindow;
    private int index;

    public ItemListener(MainWindow mainWindow, int index) {
        this.mainWindow = mainWindow;
        this.index = index;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mainWindow.setViewDisplay(index);
    }
}
