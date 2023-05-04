import java.util.Date;

public class User {
  private String login;
  private String password;
  private Date creationDate;

  public User(String login, String password, Date creationDate) {
    this.login = login;
    this.password = password;
    this.creationDate = creationDate;
  }

  // Getters and Setters
  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Date getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }
}