<!DOCTYPE HTML>

<html>

  <head>
    <title></title>
    <meta content="info">
    <meta charset="UTF-8">
    
  </head>
<body>
  



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
                echo "<div>";
                   echo "<img src='$url_image' alt='image du livre' height='150'><br>";
                   echo "<span>$nom_livre</span>";

                echo "</div>";
            }

        ?>

        </div>

</body>
        