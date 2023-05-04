<!DOCTYPE html>

<html>
    <head>
        <title>Selection de Livre</title>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="css/tous_les_livres.css">
    </head>
    <body>
    <div class="connection">
        <input type="submit" value="Se connecter">
    </div>
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