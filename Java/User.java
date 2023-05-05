import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class User extends Item{
  private String Login;
  private String Password;
  private Date CreationDate;

  public User(ResultSet result) throws SQLException {
    this.Login = result.getString("login");
    this.Password = result.getString("MDP");
    this.CreationDate = result.getDate("date_creation");
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

  @Override
  public String toString() {
    return
             Login + '\'' +

             " , "+CreationDate
            ;
  }
}
