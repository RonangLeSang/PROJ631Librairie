import javax.swing.*;

import java.awt.*;
import java.util.Calendar;
import java.util.Date;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class UserPopUp extends PopUp{
    private ModelWindow modelWindow;
    private JTextField login =new JTextField();
    private JTextField passeword = new JTextField();
    private String sql;
    private JPanel panBouton=new JPanel();
    private JPanel panelGlobal=new JPanel();

    public UserPopUp(ModelWindow modelWindow) {
        super(modelWindow);
        setSize(1000, 600);

        JButton valider=new JButton("valider");
        JButton annuler=new JButton("annuler");
        JTextField login = new JTextField(10);
        JTextField passeword = new JTextField(10);
        panelGlobal.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.add(new JLabel("login :"));
        panel.add(login);
        panel.add(new JLabel("MDP :"));
        panel.add(passeword);

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
