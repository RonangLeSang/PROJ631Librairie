import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Book extends Item{
  private int Id;
  private String Title;
  private String Author;
  private String Genre;
  private String Publisher;
  private String Image;
  private Date Date;
  private int PageCount;
  private String Summary;
  private String Language;

  public Book(ResultSet result) throws SQLException {
    this.Id = result.getInt("id_livre");
    this.Title = result.getString("titre");
    this.Author= result.getString("auteur");
    this.Genre = result.getString("genre");
    this.Publisher = result.getString("editeur");
    this.Image = result.getString("image");
    this.Date = result.getDate("date");
    this.PageCount = result.getInt("nb_page");
    this.Summary = result.getString("resu");
    this.Language = result.getString("langue");
  }

  // Getters and Setters
  public int getId() {
    return Id;
  }

  public void setId(int id) {
    this.Id = id;
  }

  public String getTitle() {
    return Title;
  }

  public void setTitle(String title) {
    this.Title = title;
  }

  public String getAuthor() {
    return Author;
  }

  public void setAuthor(String author) {
    this.Author = author;
  }

  public String getGenre() {
    return Genre;
  }

  public void setGenre(String genre) {
    this.Genre = genre;
  }

  public String getPublisher() {
    return Publisher;
  }

  public void setPublisher(String publisher) {
    this.Publisher = publisher;
  }

  public String getImage() {
    return Image;
  }

  public void setImage(String image) {
    this.Image = image;
  }

  public Date getDate() {
    return Date;
  }

  public void setDate(Date date) {
    this.Date = date;
  }

  public int getPageCount() {
    return PageCount;
  }

  public void setPageCount(int pageCount) {
    this.PageCount = pageCount;
  }

  public String getSummary() {
    return Summary;
  }

  public void setSummary(String summary) {
    this.Summary = summary;
  }

  public String getLanguage() {
    return Language;
  }

  public void setLanguage(String language) {
    this.Language = language;
  }
}
