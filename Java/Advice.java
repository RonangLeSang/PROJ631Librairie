import org.w3c.dom.Text;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Advice extends Item{
    private int idBook;
    private int idUser;
    private Date date;
    private int star;
    private String comment;

    private String nameBook;
    private String nameUser;

    public Advice(ResultSet result) throws SQLException {
        this.idBook=result.getInt("id_livre");
        this.idUser=result.getInt("login");
        this.date=result.getDate("date");
        this.star=result.getInt("etoiles");
        this.comment=result.getString("commentaire");
        this.nameUser=result.getString("");
        this.nameBook=result.getString("");
    }

    public Advice(int idBook, int idUser, Date date, int star, String comment, String nameBook, String nameUser) {
        this.idBook = idBook;
        this.idUser = idUser;
        this.date = date;
        this.star = star;
        this.comment = comment;
        this.nameBook = nameBook;
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
        return "INSERT INTO `Avis` (`id_livre`, `login`, `commentaire`, `etoiles`, `date`) VALUES ("+idBook+", "+idUser+", "+comment+", "+star+", "+date+")";
    }

    @Override
    public String suppressSelf() {
        return "DELETE FROM Avis WHERE id_livre = "+idBook+" and login = "+idUser;
    }
}
