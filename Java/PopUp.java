import javax.swing.JOptionPane;

public abstract class PopUp extends JOptionPane {

    private ModelWindow modelWindow;

    public void PopUp(ModelWindow modelWindow){
        this.modelWindow = modelWindow;
    }

}
