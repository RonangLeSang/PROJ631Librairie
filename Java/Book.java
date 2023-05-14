import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Book extends Item{
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
    return

             title + '\'' +
            ", By" + author + '\'' +
            ", " + genre + '\'' +


            ", " + date +


            ", '" + language + '\''
            ;
  }

  @Override
  public String toSQL() {
    return "INSERT INTO `Livre` (`titre`, `auteur`, `genre`, `editeur`, `image`, `date`, `nb_page`, `resu`, `langue`) VALUES ('"+title+"', '"+author+"', '"+genre+"', '"+publisher+"', '"+image+"', '"+date+"', '"+pageCount+"', '"+summary+"', '"+language+"')";
  }

  @Override
  public String suppressSelf() {
    return "DELETE FROM Livre WHERE id_livre LIKE '"+id+"'";
  }
}
