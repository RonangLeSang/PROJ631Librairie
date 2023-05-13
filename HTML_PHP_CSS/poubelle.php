<?php

// Récupération des données saisies dans le formulaire
$username = $_POST['username'];
$password = $_POST['password'];

// Connexion à la base de données
$conn = mysqli_connect("tp-epua:3308", "tafarou", "rt45y8at");
mysqli_select_db($conn, "tafarou");

// Recherche des livres correspondants dans la base de données
$sql = "SELECT * FROM utilisateur WHERE login = '$username'";
$result = mysqli_query($conn, $sql);

// Affichage des résultats de la recherche
if (mysqli_num_rows($result) > 0) {
    // Des livres correspondants ont été trouvés
    while ($username = mysqli_fetch_assoc($result)) {
      echo "Inscription réussie. Vous allez être redirigé vers la page d'accueil.";
      echo "<meta http-equiv='refresh' content='5;URL=accueil.php'>";

    
    }
        
} else {
    // Aucun livre correspondant n'a été trouvé
    echo "Aucun compte trouvé pour le username \"$username\"";
}

// Fermeture de la connexion à la base de données
mysqli_close($conn);
?>

    
    