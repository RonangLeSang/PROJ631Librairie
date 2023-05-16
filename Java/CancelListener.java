import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CancelListener implements ActionListener {
    //Classe écouteurs permettant de fermer les popups

    private final PopUp popUp;

    CancelListener(PopUp popUp){
        this.popUp = popUp;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        popUp.dispose();
    }
}
