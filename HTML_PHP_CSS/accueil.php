<?php   
        /*Connexion à la base de données sur le serveur tp-epua*/
    $conn = @mysqli_connect("tp-epua:3308", "tafarou", "rt45y8at");    
    
    /*connexion à la base de donnée depuis la machine virtuelle INFO642*/
    /*$conn = @mysqli_connect("localhost", "etu", "bdtw2021");*/  

    if (mysqli_connect_errno()) {
            $msg = "erreur ". mysqli_connect_error();
        } else {  
            $msg = "connecté au serveur " . mysqli_get_host_info($conn);
            /*Sélection de la base de données*/
            mysqli_select_db($conn, "tafarou"); 
            /*mysqli_select_db($conn, "etu"); */ /*sélection de la base sous la VM info642*/
    
            /*Encodage UTF8 pour les échanges avecla BD*/
            mysqli_query($conn, "SET NAMES UTF8");
        }
    
  ?>

<?php
    session_start();
    if(isset($_SESSION["auth"])){
        $isLoggedIn = true;
    }else{
        $isLoggedIn = false;
    }
?>
<!DOCTYPE html>
<html>
<head>
	<title>Ma Librairie</title>
    <link rel="stylesheet" type="text/css" href="css/accueil.css">
    <link rel="stylesheet" type="text/css" href="css/styles.css"/>
    <link href="https://fonts.googleapis.com/css2?family=EB+Garamond&display=swap" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Playfair+Display:ital@1&display=swap" rel="stylesheet">
</head>
<body>
    <nav>
        <div class="main-navlinks">
            <span class="logo">BookTech</span>
            <a href="accueil.php" class="">Accueil</a> 
            <a href="tous_les_livres.php" class="">Notre collection</a> 
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
            
            <script src="https://kit.fontawesome.com/f19527decd.js" crossorigin="anonymous"></script>
        </div>
        <div class="search-bar">
                <input type="text" placeholder="Rechercher">
                <i class="fa-solid fa-magnifying-glass"></i>
        </div>
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
        
        

     <!--</nav>
	<header>
		<h1>Ma Librairie</h1>
		<nav>
			<ul>
				<li><a href="tous_les_livres.php">Livres</a></li>
				<li><a href="#">Contact</a></li>
			</ul>
			<ul>
				<li><a href="#" id="login-link">Connexion</a></li>
			</ul>
		</nav>
	</header>-->
    

   
        <div class="books">
            <div class="last-release">
                <h2>Derniers livres sortis</h2>
            <?php
                $conn = mysqli_connect("tp-epua:3308", "tafarou", "rt45y8at");
                mysqli_select_db($conn, "tafarou");
                $sql = "select id_livre, titre, image from livre where date >=DATE_SUB(NOW(),INTERVAL 10 DAY)";
                $result = mysqli_query($conn, $sql);

                while($ligne = mysqli_fetch_assoc($result)){
                    $id_livre = $ligne['id_livre'];
                    $nom_livre = $ligne['titre'];
                    $url_image = $ligne['image'];
                    
                    echo "<a href=\"page_livre.php?id_livre=$id_livre\">";   
                        echo "<div class='derniers-livres'>";
                        echo "<img src='$url_image' alt='image du livre' height='150'><br>";
                        echo "<span class='info-livre'>$nom_livre</span>";

                        echo "</div>";
                    echo "</a>";
                }


            ?>
            </div>
        <div class="love">
            <h2>Les coups de coeur</h2>
        <?php
            $conn = mysqli_connect("tp-epua:3308", "tafarou", "rt45y8at");
            mysqli_select_db($conn, "tafarou");
            $sql1 = "SELECT livre.id_livre,titre,image ,coeur.commentaire from livre join coeur on livre.id_livre=coeur.id_livre ";
            $result1 = mysqli_query($conn, $sql1);

            while($ligne = mysqli_fetch_assoc($result1)){
                $id_livre = $ligne['id_livre'];
                $nom_livre = $ligne['titre'];
                $url_image = $ligne['image'];
                echo "<a href=\"page_livre.php?id_livre=$id_livre\">";   
                    echo "<div class='aimeParNous'>";
                    echo "<img src='$url_image' alt='image du livre' height='150'><br>";
                    echo "<span class='info-livre'>$nom_livre</span>";
                    echo "</div>";
                echo "</a>";
            }


        ?>

        </div>
    </div>
</main>
</body>
</html>
