import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CancelListener implements ActionListener {

    private PopUp popUp;

    CancelListener(PopUp popUp){
        this.popUp = popUp;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        popUp.dispose();
    }
}
