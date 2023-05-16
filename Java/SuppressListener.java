import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class SuppressListener implements ActionListener {
    //Classe écouteurs pour supprimer des items

    private final ModelWindow modelWindow;
    private final Item item;

    public SuppressListener(ModelWindow modelWindow, Item item) {
        this.modelWindow = modelWindow;
        this.item = item;
    }

    //supprime un item et rafraichit sa rubrique
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            modelWindow.executeRequest(item.suppressSelf());
            if(item instanceof User){
                modelWindow.refreshUser();
            }else{
                if(item instanceof Book){
                    modelWindow.refreshBook();
                }else{
                    modelWindow.refreshAdvice();
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
