import java.util.Date;

public class Book {
  private int id;
  private String title;
  private String author;
  private String genre;
  private String publisher;
  private String image;
  private Date date;
  private int pageCount;
  private String summary;
  private String language;

  public Book(int id, String title, String author, String genre, String publisher, String image, Date date, int pageCount, String summary, String language) {
    this.id = id;
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

  // Getters and Setters
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public String getPublisher() {
    return publisher;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public int getPageCount() {
    return pageCount;
  }

  public void setPageCount(int pageCount) {
    this.pageCount = pageCount;
  }

  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }
}