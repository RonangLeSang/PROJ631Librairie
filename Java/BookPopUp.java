import javax.swing.*;

import java.awt.*;
public class BookPopUp extends PopUp{

    public BookPopUp(ModelWindow modelWindow) {
        super();
        GridLayout tableauBook=new GridLayout(10, 4);
        GridLayout yearMonthDay=new GridLayout(1, 3);
        setSize(1000, 600);

        JButton valider=new JButton("valider");
        JButton annuler=new JButton("annuler");

        JPanel panelGlobal = new JPanel();
        panelGlobal.setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setLayout(tableauBook);
        panel.add(new JLabel("titre :"));
        JTextField title = new JTextField();
        panel.add(title);
        panel.add(new JLabel("author :"));
        JTextField author = new JTextField();
        panel.add(author);
        panel.add(new JLabel("genre:"));
        JTextField genre = new JTextField();
        panel.add(genre);

        panel.add(new JLabel("publisher:"));
        JTextField publisher = new JTextField();
        panel.add(publisher);

        panel.add(new JLabel("image:"));
        JTextField image = new JTextField();
        panel.add(image);

        panel.add(new JLabel("date:"));
        JPanel panDate = new JPanel();
        panDate.setLayout(yearMonthDay);
        JTextField dateYear = new JTextField("year");
        panDate.add(dateYear);
        JTextField dateMonth = new JTextField("month");
        panDate.add(dateMonth);
        JTextField dateDays = new JTextField("day");
        panDate.add(dateDays);
        panel.add(panDate);

        panel.add(new JLabel("nombre page:"));
        JTextField pageCount = new JTextField();
        panel.add(pageCount);
        panel.add(new JLabel("summary:"));
        JTextField summary = new JTextField();
        panel.add(summary);
        panel.add(new JLabel("language:"));
        JTextField language = new JTextField();
        panel.add(language);

        JPanel panBouton = new JPanel();
        panBouton.add(annuler);
        panBouton.add(valider);

        annuler.addActionListener(new CancelListener(this));
        valider.addActionListener(new ValidateAddListener(title, author, genre, publisher, image, dateDays, dateMonth, dateYear, pageCount, summary, language, modelWindow, 3, this));

        panelGlobal.add(panel,BorderLayout.CENTER);
        panelGlobal.add(panBouton,BorderLayout.SOUTH);
        this.setContentPane(panelGlobal);
        this.setVisible(true);

    }


}
