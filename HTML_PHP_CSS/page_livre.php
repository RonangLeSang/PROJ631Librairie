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
                    $resu = $livre['resu'];
                    
                    echo "<img src='$im' alt='image du livre' height='150'><br>";
                    echo "<div class='info-books'>";
                        echo "<h1>" . $livre['titre'] . "</h1><br>";
                        echo"<h3>Auteur : $auteur</h3>";
                        echo "<h2>Résumé</h2><br>";
                        echo "<p>$resu</p>";

                    
                }
                echo "</div>";
                ?>
                   
            </div>
            
             <?php
                echo "<form action='actionPublier.php?id_livre=$getidlivre' method='post'>" ?>
                    <div class="rating">
                        <input type="radio" id="star5" name="rating" value="5" />
                        <label for="star1" title="5 étoile"></label>
                        <input type="radio" id="star4" name="rating" value="4" />
                        <label for="star2" title="4 étoiles"></label>
                        <input type="radio" id="star3" name="rating" value="3" />
                        <label for="star3" title="3 étoiles"></label>
                        <input type="radio" id="star2" name="rating" value="2" />
                        <label for="star4" title="2 étoiles"></label>
                        <input type="radio" id="star1" name="rating" value="1" />
                        <label for="star5" title="1 étoiles"></label>
                        
                    </div>
                        
                    
                    <input type='text' id='comment' name='comment' placeholder='Laisser un commentaire'>
                    <input type='submit' id='publier' name='publier' value='Publier'>
                    <?php
                        if(isset($_GET["message"])){ 
                            $msg = $_GET["message"];
                            echo "<p class='succes_message'>$msg</p>";
                        }
                        if(isset($_GET["erreur"])){
                            $error =  $_GET["erreur"];
                            echo "<p class='message_error'>$error</p>";
                        }
                            
                        
                       
                    ?>
                </form>
            
            
            <div class="avis">
                        <?php

                $sql1 = "select login,commentaire,DATE_FORMAT(date, '%d-%m-%Y %H:%i') as date from avis ";
                $result1 = mysqli_query($conn, $sql1);
                echo "<h2>Avis</h2>";
                while($livre1 = mysqli_fetch_assoc($result1)){
                    echo'<div class="comment">';
                        echo "<h3>" . $livre1['login'] . "</h3>"; echo "<span>". $livre1['date']."</span>";
                        echo "<p>" . $livre1['commentaire'] . "</p>";
                    echo '</div>';
                    
                }
            ?>
            </div>
       
           
    </section>


       

        
        
    </body>
</html>
