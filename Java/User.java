import java.util.Date;

public class User extends Item{
  private String Login;
  private String Password;
  private Date CreationDate;

  public User(String login, String password, Date creationDate) {
    this.Login = login;
    this.Password = password;
    this.CreationDate = creationDate;
  }

  // Getters and Setters
  public String getLogin() {
    return Login;
  }

  public void setLogin(String login) {
    this.Login = login;
  }

  public String getPassword() {
    return Password;
  }

  public void setPassword(String password) {
    this.Password = password;
  }

  public Date getCreationDate() {
    return CreationDate;
  }

  public void setCreationDate(Date creationDate) {
    this.CreationDate = creationDate;
  }
}
