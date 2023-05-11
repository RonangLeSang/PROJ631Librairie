import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class User extends Item{
  private String login;
  private String password;
  private Date creationDate;

  public User(ResultSet result) throws SQLException {
    this.login = result.getString("login");
    this.password = result.getString("MDP");
    this.creationDate = result.getDate("date_creation");
  }

  public User(String login, String password, Date date) {
    super();
    this.login = login;
    this.password = password;
    this.creationDate = date;
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

  @Override
  public String toString() {
    return
             login +

             " , "+creationDate
            ;
  }

  @Override
  public String toSQL() {
    return "INSERT INTO utilisateur (login, MDP, date_creation) VALUES ('"+login+"', '"+password+"', '"+creationDate+"')";
  }

  @Override
  public String suppressSelf() {
    return "DELETE FROM utilisateur WHERE login LIKE '"+login+"'";
  }
}
