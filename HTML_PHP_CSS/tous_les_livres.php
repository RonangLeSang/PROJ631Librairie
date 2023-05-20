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
    <?php
        include 'connect_base.php';
    ?>
    <body>
    <?php include 'navbar.php'?>
    <h1>Notre Sélection de livre</h1>
        <div class="books">
            <?php
               if (isset($_GET["genre"])){
                    $genre = $_GET["genre"];
                    $sql = "select id_livre,titre, image from livre where genre='$genre' ";
                    $result = mysqli_query($conn, $sql);
                    echo "<h3>Genre : $genre</h3>";
                    while($ligne = mysqli_fetch_assoc($result)){
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
               }else if(isset($_GET["search"]) && !empty($_GET["search"])){
                $search = $_GET["search"];
                $sql = "select id_livre from livre where titre LIKE '%$search%'";
                $result = mysqli_query($conn, $sql);
                while($ligne = mysqli_fetch_assoc($result)){
                    $id_livre = $ligne["id_livre"];
                    echo "<a href=\"page_livre.php?id_livre=$id_livre\">";
                        echo "<div class='all-books'>";
                            echo "<img src='$url_image' alt='image du livre' height='150'><br>";
                            echo "<span>$nom_livre</span>";
                        echo "</div>";
                    echo "</a>";
                }
               }
               else{
                    $sql = "select id_livre,titre, image from livre";
                    $result = mysqli_query($conn, $sql);
                    while($ligne = mysqli_fetch_assoc($result)){
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