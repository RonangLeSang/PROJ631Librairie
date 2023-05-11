import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AddButtonListener implements ActionListener{

    private ModelWindow modelWindow;

    public AddButtonListener(ModelWindow modelWindow) {
        this.modelWindow = modelWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (modelWindow.getTab()){
            case 1:
                UserPopUp userPopUp = new UserPopUp(modelWindow);
                break;

            case 2:
                BookPopUp bookPopUp = new BookPopUp(modelWindow);
                break;

            case 3:
                AdvicePopUp advicePopUp = new AdvicePopUp(modelWindow);
                break;
        }
    }
}
