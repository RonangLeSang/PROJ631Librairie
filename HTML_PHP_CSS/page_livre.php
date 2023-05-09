<!DOCTYPE html>

<html>
    <head>
        <title>notre livre </title>
        <meta charset="utf-8">
        <link rel="stylesheet" href="page_livre.css" />
    </head>
    <?php
        $conn = mysqli_connect("tp-epua:3308", "tafarou", "rt45y8at");
        mysqli_select_db($conn, "tafarou");
    ?>
    <body>
    <nav>
        <div class="main-navlinks">
            <a href="accueil.php" class="">Accueil</a> 
            <div class="dropdown-container">
                <a href="#">Genres</a>
                <ul class="genres-dropdown">
                    <?php
                        $sql = "select distinct genre from Livre";
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
        <div class="nav-auth">
            <div class="sign-btns">
                <button type="button">Se connecter</button>
                <button type="button">S'inscrire</button>
            </div>
        </div>
        
        

     </nav>

    
    
        
        <div class="book">
        <?php
            $conn = mysqli_connect("tp-epua:3308", "tafarou", "rt45y8at");
            mysqli_select_db($conn, "tafarou");
            $sql = "select titre,auteur, image,resu from Livre where auteur = 'yassir'";
            $result = mysqli_query($conn, $sql);

            while($livre = mysqli_fetch_assoc($result)){
                echo "<h1>" . $livre['titre'] . "</h1>";
                echo "<h2>Par " . $livre['auteur'] . "</h2>";
                $im = $livre['image'];
                echo "<img src='$im' alt='image du livre' height='150'><br>";
                echo "<p>" . $livre['resu'] . "</p>";
            }
            ?>


<?php

            $conn = mysqli_connect("tp-epua:3308", "tafarou", "rt45y8at");
            mysqli_select_db($conn, "tafarou");
            $sql1 = "select etoiles,commentaire from Avis ";
            $result1 = mysqli_query($conn, $sql1);

            while($livre1 = mysqli_fetch_assoc($result1)){
                echo "<h3>" . $livre1['etoiles'] . "</h3>";
                echo "<p>" . $livre1['commentaire'] . "</p>";
            }
        ?>

        </div>
        
    </body>
</html>
