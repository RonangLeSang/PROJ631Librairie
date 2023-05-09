<!DOCTYPE html>

<html>
    <head>
        <title>Selection de Livre</title>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="css/tous_les_livres.css">
        <link href="https://fonts.googleapis.com/css2?family=EB+Garamond&display=swap" rel="stylesheet">
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

    <h1>Notre Sélection de livre</h1>
        
        <div class="books">
            <?php
                $sql = "select titre, image from Livre";
                $result = mysqli_query($conn, $sql);

                while($ligne = mysqli_fetch_assoc($result)){
                    $nom_livre = $ligne['titre'];
                    $url_image = $ligne['image'];
                    echo "<a href=#>";
                        echo "<div class='all-books'>";
                            echo "<img src='$url_image' alt='image du livre' height='150'><br>";
                            echo "<span>$nom_livre</span>";

                        echo "</div>";
                    echo "</a>";
                }

            ?>

        </div>
        
    </body>
</html>