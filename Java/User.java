import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class User extends Item{
  private String login;
  private final String password;
  private final Date creationDate;

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

  @Override
  public String toString() {
    return
             login +

             " , "+creationDate
            ;
  }

  @Override
  public String[] toSQL() {
    String[] tab = {"INSERT INTO utilisateur (login, MDP, date_creation) VALUES ('"+login+"', '"+password+"', '"+creationDate+"')"};
    return tab;
  }

  @Override
  public String[] suppressSelf() {
    String[] tab = {"DELETE FROM avis WHERE login LIKE '"+login+"'","DELETE FROM utilisateur WHERE login LIKE '"+login+"'"};
    return tab;
  }
}
