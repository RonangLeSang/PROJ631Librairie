import org.w3c.dom.Text;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Advice extends Item{


    private Date date;
    private int star;
    private String comment;
    private String nameBook;
    private int idBook;
    private String nameUser;

    public Advice(ResultSet result) throws SQLException {

        this.date=result.getDate("date");
        this.star=result.getInt("etoiles");
        this.comment=result.getString("commentaire");
        this.nameUser=result.getString("login");
        this.idBook=result.getInt("id_livre");
        this.nameBook="commane sql a faire ";
    }

    public Advice(int idBook, Date date, int star, String comment, String nameUser) {
        this.idBook = idBook;

        this.date = date;
        this.star = star;
        this.comment = comment;

        this.nameUser = nameUser;
    }

    @Override
    public String toString() {
        return
                nameBook+
                ", " + nameUser +
                 ", "+       date +
                 ", "+ star + "étoiles"

                ;
    }

    @Override
    public String toSQL() {
        return "INSERT INTO `Avis` (`id_livre`, `login`, `commentaire`, `etoiles`, `date`) VALUES ("+idBook+", "+nameUser+", "+comment+", "+star+", "+date+")";
    }

    @Override
    public String suppressSelf() {
        return "DELETE FROM Avis WHERE id_livre = "+idBook+" and login = "+nameUser;
    }
}
