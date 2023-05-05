<!DOCTYPE html>

<html>
    <head>
        <title>Selection de Livre</title>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="css/tous_les_livres.css">
    </head>
    <body>
        <header>
        <nav class="top-bar">
                <ul>
                    <li><a href="accueil.php">Accueil</a></li>
                    <li><a href="#">Genre</a></li>
                </ul>
                
                <input type="text" name="search" placeholder="Rechercher un livre">
        </nav>
        <div class="connection">
            <!-- Mettre un form pour la suite -->
            <input type="submit" value="Se connecter">
            <input type="submit" value="S'inscrire">
        </div>

            
            
        </header>
    <h1>Notre Sélection de livre</h1>
        
        <div class="books">
            <?php
                $conn = mysqli_connect("tp-epua:3308", "tafarou", "rt45y8at");
                mysqli_select_db($conn, "tafarou");
                $sql = "select titre, image from Livre";
                $result = mysqli_query($conn, $sql);

                while($ligne = mysqli_fetch_assoc($result)){
                    $nom_livre = $ligne['titre'];
                    $url_image = $ligne['image'];
                    echo "<div class='all-books'>";
                    echo "<img src='$url_image' alt='image du livre' height='150'><br>";
                    echo "<span>$nom_livre</span>";

                    echo "</div>";
                }

            ?>

        </div>
        
    </body>
</html>