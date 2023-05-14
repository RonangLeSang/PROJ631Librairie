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
        $conn = mysqli_connect("tp-epua:3308", "tafarou", "rt45y8at");
        mysqli_select_db($conn, "tafarou");
    ?>
    <body>
     <nav>
        <div class="main-navlinks">
            <i class="fa-solid fa-book" style="color: #ffffff;"></i>
            <script src="https://kit.fontawesome.com/f19527decd.js" crossorigin="anonymous"></script>
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

    <h1>Notre Sélection de livre</h1>
        
        <div class="books">

            <?php
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

            ?>

        </div>
        
    </body>
</html>