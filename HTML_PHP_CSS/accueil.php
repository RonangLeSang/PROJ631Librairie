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
<!DOCTYPE html>
<html>
<head>
	<title>Ma Librairie</title>
    <link rel="stylesheet" type="text/css" href="css/accueil.css">
</head>
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
    

    <h2>Derniers livres sortis</h2>
        <div class="books">
        <?php
            $conn = mysqli_connect("tp-epua:3308", "tafarou", "rt45y8at");
            mysqli_select_db($conn, "tafarou");
            $sql = "select titre, image from Livre where date >=DATE_SUB(NOW(),INTERVAL 10 DAY)";
            $result = mysqli_query($conn, $sql);

            while($ligne = mysqli_fetch_assoc($result)){
                $nom_livre = $ligne['titre'];
                $url_image = $ligne['image'];
                echo "<a href=#>";   
                    echo "<div class='derniers-livres'>";
                    echo "<img src='$url_image' alt='image du livre' height='150'><br>";
                    echo "<span>$nom_livre</span>";

                    echo "</div>";
                echo "</a>";
            }


        ?>
        <h2>Les coups de coeur</h2>
        <div class="love">
        <?php
            $conn = mysqli_connect("tp-epua:3308", "tafarou", "rt45y8at");
            mysqli_select_db($conn, "tafarou");
            $sql = "SELECT titre,image ,Coeur.commentaire from Livre join Coeur on Livre.id_livre=Coeur.id_livre ";
            $result = mysqli_query($conn, $sql);

            while($ligne = mysqli_fetch_assoc($result)){
                $nom_livre = $ligne['titre'];
                $url_image = $ligne['image'];
                $url_commentaire = $ligne['commentaire'];
                echo "<a href=#>";   
                    echo "<div class='aimeParNous'>";
                    echo "<img src='$url_image' alt='image du livre' height='150'><br>";
                    echo "<span>$nom_livre</span>";
                    echo "<div> $url_commentaire</div>";
                    echo "</div>";
                echo "</a>";
            }


        ?>

        </div>
		<section>
			<h2>Connexion</h2>
			<!--<form method="post" action="connexion.php">
				<label for="email">Email :</label>
				<input type="email-->
        </section>
    </main>
</body>

