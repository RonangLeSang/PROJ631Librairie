import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddButtonListener implements ActionListener{
    //Classe écouteurs faisant apparaitre les popups

    private final ModelWindow modelWindow;

    public AddButtonListener(ModelWindow modelWindow) {
        this.modelWindow = modelWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (modelWindow.getTab()) {
            case 1 -> new UserPopUp(modelWindow);
            case 2 -> new BookPopUp(modelWindow);
            case 3 -> new AdvicePopUp(modelWindow);
        }
    }
}
