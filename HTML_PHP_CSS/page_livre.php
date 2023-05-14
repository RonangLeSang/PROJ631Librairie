<!DOCTYPE html>
<?php
    session_start();
    if(isset($_SESSION["auth"])){
        $isLoggedIn = true;
    }else{
        $isLoggedIn = false;
    }
?>
<html>
    <head>
        <title>notre livre </title>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="css/styles.css"/>
        <link rel="stylesheet" href="css/page_livre.css" />
        <link href="https://fonts.googleapis.com/css2?family=EB+Garamond&display=swap" rel="stylesheet">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Playfair+Display:ital@1&display=swap" rel="stylesheet">
            
    </head>
    <?php
        $conn = mysqli_connect("tp-epua:3308", "tafarou", "rt45y8at");
        mysqli_select_db($conn, "tafarou");
    ?>
    <body>
    <nav>
        <div class="main-navlinks">
            <span class="logo">BookTech</span>
            <a href="accueil.php" class="">Accueil</a> 
            <div class="dropdown-container">
                <a href="#">Genres</a>
                <ul class="genres-dropdown">
                    <?php
                        $sql = "select distinct genre from livre";
                        $result = mysqli_query($conn,$sql);
                        while($ligne = mysqli_fetch_assoc($result)){
                            $genre = $ligne['genre'];
                            echo "<li><a href='#'>$genre</a></li>";
                        }

                    ?>
                    
                </ul>
            </div>
            <a href="#">Mes favoris</a>
        </div>
        <div class="search-bar">
                <input type="text" placeholder="Rechercher">
                <i class="fa-solid fa-magnifying-glass"></i>
        </div>
        <script src="https://kit.fontawesome.com/f19527decd.js" crossorigin="anonymous"></script>
        <div class="nav-auth">
            <div class="sign-btns">
                <?php if ($isLoggedIn): ?>
                    <form action="deconnexion_page.php">
                        <button type="submit">Se Déconnecter</button>
                    </form>
                <?php else: ?>
                    <form action="connection_page.php">
                        <button type="submit">Se connecter</button>
                    </form>
                    <form action="inscription_page.php">
                        <button type="submit">S'inscrire</button>
                    </form>

                <?php endif; ?>
                    
            </div>
        </div>
        
        

     </nav>

    
    
        
        <section id="page-container">

            <div class="book">
            <?php
            
                $getidlivre= $_GET['id_livre'];
                $sql = "select titre,auteur, image,resu from livre where id_livre=$getidlivre";
                $result = mysqli_query($conn, $sql);
                
                while($livre = mysqli_fetch_assoc($result)){
                    
                    $im = $livre['image'];
                    $auteur = $livre["auteur"];
                    
                    echo "<img src='$im' alt='image du livre' height='150'><br>";
                    echo "<div class='info-books'>";
                        echo "<h1>" . $livre['titre'] . "</h1><br>";
                        echo"<h3>$auteur</h3>";
                        echo "<p>" . $livre['resu'] . "</p>";

                    
                }
                echo "</div>";
                ?>
                   
            </div>
            <div class="rating">
                        <input type="radio" name="x" value="1">
                        <input type="radio" name="x" value="2">
                        <input type="radio" name="x" value="3">
                        <input type="radio" name="x" value="4">
                        <input type="radio" name="x" value=5>
                        <span>&#9734; &#9734; &#9734; &#9734; &#9734;</span>
                        <span class="active">&#9733; &#9733; &#9733; &#9733; &#9733;</span>
            </div>
            <?php 
                echo "<form action='' method='post'>
                    <input type='text' id='comment' name='comment' placeholder='Laisser un commentaire'>
                    <input type='submit' id='publier' name='publier' value='Publier'>";
                   
                    if($isLoggedIn){
                        if(!empty($_POST["comment"])){
                            $comment = htmlspecialchars($_POST["comment"]);
                            $login = $_SESSION['login'];
                            $sql = "insert into avis(id_livre, login, commentaire, date) values ($getidlivre,'$login', '$comment', NOW())";
                            $insertComment = mysqli_query($conn,$sql); 
                            echo "<p class='succes_message'>Votre commentaire a été ajouté !</p>";
                            
                            
                        }else{
                            echo "<p class='message_error'>Veuillez renseigner un commentaire ! </p>";
                            
                        }
                    
                    
                    }
                    else{
                        header("Location: connection_page.php");
                    }
                    
                       
                
                echo"</form>";
            ?>
            
            <div class="avis">
                        <?php

                $sql1 = "select etoiles,commentaire from avis ";
                $result1 = mysqli_query($conn, $sql1);
                echo "<h2>Avis</h2>";
                while($livre1 = mysqli_fetch_assoc($result1)){
                    
                    echo "<h3>" . $livre1['etoiles'] . "</h3>";
                    echo "<p>" . $livre1['commentaire'] . "</p>";
                }
            ?>
            </div>
       
           
    </section>


       

        
        
    </body>
</html>
