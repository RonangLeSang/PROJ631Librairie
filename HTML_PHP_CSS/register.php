<?php
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $username = $_POST['username'];
    $password = $_POST['password'];
    $confirmPassword = $_POST['confirm_password'];

    // Vérifiez si les mots de passe correspondent
    if ($password !== $confirmPassword) {
        echo "Les mots de passe ne correspondent pas. Veuillez réessayer.";
        exit();
    }

    // Connectez-vous à votre base de données
    $conn = mysqli_connect("tp-epua:3308", "tafarou", "rt45y8at");
    mysqli_select_db($conn, "tafarou");

    // Vérifiez si le nom d'utilisateur existe déjà dans la base de données
    $sql = "SELECT * FROM utilisateur WHERE login = '$username'";
    $result = mysqli_query($conn, $sql);

    if (mysqli_num_rows($result) > 0) {
        echo "Nom d'utilisateur déjà utilisé. Veuillez choisir un nom d'utilisateur différent.";
    } else {
        // Insérez les données de l'utilisateur dans la table "utilisateur"
        $sql = "INSERT INTO utilisateur (login, MDP) VALUES ('$username', '$password')";
        $result = mysqli_query($conn, $sql);

        if ($result) {
            // Inscription réussie, affichez le message et redirigez l'utilisateur après 5 secondes
            echo "Inscription réussie. Vous allez être redirigé vers la page d'accueil.";
            echo "<meta http-equiv='refresh' content='5;URL=accueil.php'>";
        } else {
            echo "Une erreur s'est produite lors de l'inscription. Veuillez réessayer.";
        }
    }
}
?>

