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

  public Book(int id, String title, String author, String genre, String publisher, String image, Date date, int pageCount, String summary, String language) {
    this.Id = id;
    this.Title = title;
    this.Author = author;
    this.Genre = genre;
    this.Publisher = publisher;
    this.Image = image;
    this.Date = date;
    this.PageCount = pageCount;
    this.Summary = summary;
    this.Language = language;
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
