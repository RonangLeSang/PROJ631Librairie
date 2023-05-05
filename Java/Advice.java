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

    public Advice(ResultSet result) throws SQLException {
        this.idBook=result.getInt("id_livre");
        this.idUser=result.getInt("login");
        this.date=result.getDate("date");
        this.star=result.getInt("etoiles");
        this.comment=result.getString("commentaire");
    }


}
