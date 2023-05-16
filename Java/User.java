import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class User extends Item{
  //Classe représentant un utilisateur

  private String login;
  private final String password;
  private final Date creationDate;

  //création d'un nouvel utilisateur à partir d'une requête sql
  public User(ResultSet result) throws SQLException {
    this.login = result.getString("login");
    this.password = result.getString("MDP");
    this.creationDate = result.getDate("date_creation");
  }

  //création d'un nouvel utilisateur à partir de champs spécifique
  public User(String login, String password, Date date) {
    super();
    this.login = login;
    this.password = password;
    this.creationDate = date;
  }

  // Getters et Setters
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

  //renvoit la commande sql pour insérer l'utilisateur dans la bdd
  @Override
  public String[] toSQL() {
    String[] tabIns = {"INSERT INTO utilisateur (login, MDP, date_creation) VALUES ('"+login+"', '"+password+"', '"+creationDate+"')"};
    return tabIns;
  }

  //renvoit la commande sql pour supprimer l'utilisateur
  @Override
  public String[] suppressSelf() {
    String[] tabSup = {"DELETE FROM avis WHERE login LIKE '"+login+"'","DELETE FROM utilisateur WHERE login LIKE '"+login+"'"};
    return tabSup;
  }
}
