<?php   
        /*Connexion à la base de données sur le serveur tp-epua*/
    $conn = @mysqli_connect("tp-epua:3308", "tafarou", "rt45y8at");    
    
    

    if (mysqli_connect_errno()) {
            $msg = "erreur ". mysqli_connect_error();
        } else {  
            $msg = "connecté au serveur " . mysqli_get_host_info($conn);
            mysqli_select_db($conn, "tafarou"); 
        
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

        <?php include 'navbar.php'?>
        <?php if(isset($_GET["search"])){
            header("Location: tous_les_livres.php");
        }?>
        <div class="books">
            <div class="last-release">
                <h2>Derniers livres sortis</h2>
            <?php
                $conn = mysqli_connect("tp-epua:3308", "tafarou", "rt45y8at");
                mysqli_select_db($conn, "tafarou");
                $sql = "select id_livre, titre, image from livre where date >=DATE_SUB(NOW(),INTERVAL 30 DAY)";
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
