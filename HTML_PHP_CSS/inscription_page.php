<!DOCTYPE html>

<html>
<head>
    <title>S'inscire</title>
    <meta charset="utf-8"/>
    <link rel="stylesheet" href="css/page_inscription.css" />
    
</head>

<body>
  <form action="" method="post">
      
      <h1>S'inscrire</h1>
      <div class="inputs">
        <input type="text" placeholder="Pseudo" name="pseudo" autocomplete="off" />
        <input type="password" placeholder="Mot de passe" name='mdp' autocomplete="off">
        <input type="password" placeholder="Confirmer le mot de passe" name='cmdp'>
      </div>
      
      
      <div align="center">
        <button type="submit" name="envoi">S'inscrire</button>
      </div>
      <?php
session_start();
include 'connect_base.php';
if(isset($_POST['envoi'])){
    if(!empty($_POST["pseudo"]) AND !empty($_POST['mdp']) AND !empty($_POST['cmdp'])){
        if($_POST["mdp"]===$_POST["cmdp"]){
            $pseudo = htmlspecialchars($_POST['pseudo']); 
            $mdp = sha1($_POST["mdp"]);
            
            $sql = "select login from utilisateur where login='$pseudo'";
            $already_exists = mysqli_query($conn, $sql);

            if(mysqli_num_rows($already_exists)==0){
                $sql = "insert into utilisateur(login,MDP, date_creation) values('$pseudo','$mdp', NOW())";
                $insertUser = mysqli_query($conn,$sql);
            }else{
                echo "<p class='error_message'>Cette utilisateur existe déjà sur le site</p>";
            }
            
            

            $_SESSION["auth"] = true;
            $_SESSION["login"] = $pseudo;
            $_SESSION["MDP"] =$mdp;

            header("Location: accueil.php");
        }
        else{
            echo "<p class='error_message'>Les deux mots de  passe sont différents</p>";
        }
        
    }else{
        echo "<p class='error_message'>Veuillez compléter tous les champs</p>";
    }
}
?>
    </form>
</body>
</html>


