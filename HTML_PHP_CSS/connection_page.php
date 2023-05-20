<!DOCTYPE html>


<head>
    <title>Se connecter</title>
    <meta charset="utf-8"/>
    <link rel="stylesheet" href="css/page_connexion.css" />
    
</head>

<body>
  <form action="" method="post">
      
      <h1>Se connecter</h1>
      <div class="inputs">
        <input type="text" name="pseudo" placeholder="Pseudo"/>
        <input type="password" name="mdp" placeholder="Mot de passe">
      </div>
      
      <p class="inscription">Je n'ai pas de <span>compte</span>. Je m'en <a href="inscription_page.php"><span>crée</span></a> un.</p>
      <div align="center">
        <button type="submit" name="envoi">Se connecter</button>
      </div>
     <?php
        session_start();
        include 'connect_base.php';
        
        if (isset($_POST['envoi'])){
          if(!empty($_POST["pseudo"]) AND !empty($_POST["mdp"])){
              $pseudo = htmlspecialchars($_POST["pseudo"]);
              $mdp = sha1($_POST["mdp"]);
              $sql = "select * from utilisateur where login='$pseudo' AND MDP='$mdp'";
              $recupUser = mysqli_query($conn, $sql);
              if(mysqli_num_rows($recupUser)>0){
                $_SESSION["auth"] = true;
                $_SESSION["login"] = $pseudo;
                $_SESSION["MDP"] = $mdp;
                header("Location: accueil.php");
                
              }else{
                echo "<p class='error_message'>Votre pseudo ou mot de passe est incorrect</p>";
              }
          }else{
            echo "<p class='error_message'>Veuillez compléter tous les champs</p>";
          }
        }
      ?>
    </form>
</body>


