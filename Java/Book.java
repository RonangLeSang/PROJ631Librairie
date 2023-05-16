import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Book extends Item{
  //Classe représentant un livre
  private int id;
  private final String title;
  private final String author;
  private final String genre;
  private final String publisher;
  private final String image;
  private final Date date;
  private final int pageCount;
  private final String summary;
  private final String language;

  //création d'un nouveau livre à partir d'une requête sql
  public Book(ResultSet result) throws SQLException {
    this.id = result.getInt("id_livre");
    this.title = result.getString("titre");
    this.author= result.getString("auteur");
    this.genre = result.getString("genre");
    this.publisher = result.getString("editeur");
    this.image = result.getString("image");
    this.date = result.getDate("date");
    this.pageCount = result.getInt("nb_page");
    this.summary = result.getString("resu");
    this.language = result.getString("langue");
  }

  //création d'un nouveau livre à partir de champs spécifique
  public Book(String title, String author, String genre, String publisher, String image, java.util.Date date, int pageCount, String summary, String language) {
    this.title = title;
    this.author = author;
    this.genre = genre;
    this.publisher = publisher;
    this.image = image;
    this.date = date;
    this.pageCount = pageCount;
    this.summary = summary;
    this.language = language;
  }

  @Override
  public String toString() {
    return "id : " + id + ", " +
             title +
            ", par " + author +
            ", " + genre +


            ", " + date +


            ", " + language;
  }

  //renvoit la commande sql pour insérer le livre dans la bdd
  @Override
  public String[] toSQL() {
    String[] tabIns = {"INSERT INTO `Livre` (`titre`, `auteur`, `genre`, `editeur`, `image`, `date`, `nb_page`, `resu`, `langue`) VALUES ('"+title+"', '"+author+"', '"+genre+"', '"+publisher+"', '"+image+"', '"+date+"', '"+pageCount+"', '"+summary+"', '"+language+"')"};
    return tabIns;
  }

  //renvoit la commande sql pour supprimer le livre
  @Override
  public String[] suppressSelf() {
    String[] tabSup = {"DELETE FROM Livre WHERE id_livre LIKE '"+id+"'"};
    return tabSup;
  }
}
