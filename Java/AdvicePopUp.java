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
public class AdvicePopUp extends PopUp{
    private ModelWindow modelWindow;
    private JTextField login =new JTextField();
    private JTextField comment = new JTextField();
    private JTextField star = new JTextField();
    private JTextField idBook = new JTextField();
    private String sql;
    private JPanel panBouton=new JPanel();
    private JPanel panelGlobal=new JPanel();
    public AdvicePopUp(ModelWindow modelWindow) {
        super(modelWindow);

        setSize(1000, 600);

        JButton valider=new JButton("valider");
        JButton annuler=new JButton("annuler");

        panelGlobal.setLayout(new BorderLayout());
        login.setMinimumSize(new Dimension(100, 20));
        idBook.setMinimumSize(new Dimension(100, 20));
        comment.setMinimumSize(new Dimension(100, 20));
        star.setMinimumSize(new Dimension(100, 20));
        JPanel panel = new JPanel();
        panel.add(new JLabel("login :"));
        panel.add(login);
        panel.add(new JLabel("livre :"));
        panel.add(idBook);
        panel.add(new JLabel("commentaire :"));
        panel.add(comment);
        panel.add(new JLabel("star:"));
        panel.add(star);
        panBouton.add(annuler);
        panBouton.add(valider);

        valider.addActionListener(new ValidateAddListener(login, idBook,comment,star, modelWindow, 2, this));

        panelGlobal.add(panel,BorderLayout.CENTER);
        panelGlobal.add(panBouton,BorderLayout.SOUTH);
        this.setContentPane(panelGlobal);
        this.setVisible(true);

    }


}
