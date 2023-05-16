import javax.swing.*;

import java.awt.*;


public class UserPopUp extends PopUp{
//popup permettant la création d'un nouvel utilisateur

    public UserPopUp(ModelWindow modelWindow) {
        super();
        setSize(1000, 600);

        JButton valider=new JButton("valider");
        JButton annuler=new JButton("annuler");
        JTextField login = new JTextField(10);
        JTextField passeword = new JTextField(10);
        JPanel panelGlobal = new JPanel();
        panelGlobal.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.add(new JLabel("login :"));
        panel.add(login);
        panel.add(new JLabel("MDP :"));
        panel.add(passeword);

        JPanel panBouton = new JPanel();
        panBouton.add(annuler);
        panBouton.add(valider);

        annuler.addActionListener(new CancelListener(this));
        valider.addActionListener(new ValidateAddListener(login, passeword, modelWindow, 1, this));

        panelGlobal.add(panel,BorderLayout.CENTER);
        panelGlobal.add(panBouton,BorderLayout.SOUTH);
        this.setContentPane(panelGlobal);
        this.setVisible(true);

    }



}
