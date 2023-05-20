<!DOCTYPE html>
<html>
    <head>
    <title>Selection de Livre</title>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="css/styles.css"/>
        <link rel="stylesheet" type="text/css" href="css/tous_les_livres.css">
        <link href="https://fonts.googleapis.com/css2?family=EB+Garamond&display=swap" rel="stylesheet">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Playfair+Display:ital@1&display=swap" rel="stylesheet">
    </head>
    <body>
        <?php include 'navbar.php'?>
        <?php include 'connect_base.php'?>
        <h1>
            Vos favoris
        </h1>
        <div class="books">
        <?php
            $sql = "select id_livre from favoris";
            $result = mysqli_query($conn, $sql);
            while($ligne = mysqli_fetch_assoc($result)){
                $id_livre = $ligne["id_livre"];
                $sql1 = "select id_livre,titre, image from livre where id_livre=$id_livre";
                $result1 = mysqli_query($conn, $sql1);
                while($ligne = mysqli_fetch_assoc($result1)){
                    $id_livre = $ligne["id_livre"];
                    $nom_livre = $ligne['titre'];
                    $url_image = $ligne['image'];
                    echo "<a href=\"page_livre.php?id_livre=$id_livre\">";
                        echo "<div class='all-books'>";
                            echo "<img src='$url_image' alt='image du livre' height='150'><br>";
                            echo "<span>$nom_livre</span>";
                        echo "</div>";
                    echo "</a>";

            }
        }
            
        ?>
        </div>
       
    </body>
</html>
   