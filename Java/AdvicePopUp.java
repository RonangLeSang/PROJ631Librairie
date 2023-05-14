import javax.swing.*;

import java.awt.*;

public class AdvicePopUp extends PopUp{
    public AdvicePopUp(ModelWindow modelWindow) {
        super();
        GridLayout tableauAdvise=new GridLayout(4, 2);
        setSize(1000, 600);

        JButton valider=new JButton("valider");
        JButton annuler=new JButton("annuler");

        JPanel panelGlobal = new JPanel();
        panelGlobal.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(tableauAdvise);
        panel.add(new JLabel("login :"));
        JTextField login = new JTextField();
        panel.add(login);
        panel.add(new JLabel("ID livre :"));
        JTextField idBook = new JTextField();
        panel.add(idBook);
        panel.add(new JLabel("commentaire :"));
        JTextField comment = new JTextField();
        panel.add(comment);
        panel.add(new JLabel("star:"));
        JTextField star = new JTextField();
        panel.add(star);
        JPanel panBouton = new JPanel();
        panBouton.add(annuler);
        panBouton.add(valider);

        annuler.addActionListener(new CancelListener(this));
        valider.addActionListener(new ValidateAddListener(login, idBook, star, comment, modelWindow, 2, this));

        panelGlobal.add(panel,BorderLayout.CENTER);
        panelGlobal.add(panBouton,BorderLayout.SOUTH);
        this.setContentPane(panelGlobal);
        this.setVisible(true);

    }


}
