import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddButtonListener implements ActionListener{

    private ModelWindow modelWindow;

    public AddButtonListener(ModelWindow modelWindow) {
        this.modelWindow = modelWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (modelWindow.getTab()){
            case 1:
                break;

            case 2:
                break;

            case 3:
                break;
        }
    }
}
