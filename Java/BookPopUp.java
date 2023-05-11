mport javax.swing.*;

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
public class BookPopUp extends PopUp{
    private ModelWindow modelWindow;
    private JTextField idBook =new JTextField();
    private JTextField title = new JTextField();
    private JTextField author = new JTextField();
    private JTextField genre = new JTextField();
    private JTextField publisher = new JTextField();
    private JTextField image = new JTextField();
    private JTextField date = new JTextField();
    private JTextField pageCount = new JTextField();
    private JTextField summary = new JTextField();
    private JTextField language = new JTextField();

    private String sql;
    private JPanel panBouton=new JPanel();
    private JPanel panelGlobal=new JPanel();
    public BookPopUp(ModelWindow modelWindow) {
        super(modelWindow);
        GridLayout tableauBook=new GridLayout(10, 2);
        setSize(1000, 600);

        JButton valider=new JButton("valider");
        JButton annuler=new JButton("annuler");

        panelGlobal.setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setLayout(tableauBook);
        panel.add(new JLabel("identifiant :"));
        panel.add(idBook);
        panel.add(new JLabel("titre :"));
        panel.add(title);
        panel.add(new JLabel("author :"));
        panel.add(author);
        panel.add(new JLabel("genre:"));
        panel.add(genre);
        panel.add(new JLabel("genre:"));
        panel.add(genre);

        panel.add(new JLabel("publisher:"));
        panel.add(publisher);

        panel.add(new JLabel("image:"));
        panel.add(image);

        panel.add(new JLabel("date:"));
        panel.add(date);

        panel.add(new JLabel("nombre page:"));
        panel.add(pageCount);
        panel.add(new JLabel("summary:"));
        panel.add(summary);
        panel.add(new JLabel("language:"));
        panel.add(language);

        panBouton.add(annuler);
        panBouton.add(valider);

        valider.addActionListener(new ValidateAddListener(idBook, title,author,genre,publisher,image,date,pageCount,summary,language, modelWindow, 3, this));

        panelGlobal.add(panel,BorderLayout.CENTER);
        panelGlobal.add(panBouton,BorderLayout.SOUTH);
        this.setContentPane(panelGlobal);
        this.setVisible(true);

    }


}
