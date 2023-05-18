<meta charset="utf-8">
<?php
session_start();
$conn = mysqli_connect("tp-epua:3308", "tafarou", "rt45y8at");
mysqli_select_db($conn, "tafarou");
if($_SESSION["auth"]){
    $getidlivre = $_GET['id_livre'];
    if(!empty($_POST["comment"]) and !empty($_POST["rating"])){
        $comment = htmlspecialchars($_POST["comment"]);
        $login = $_SESSION['login'];
        
        $num_etoites = $_POST['rating'];
        
        $sql = "select * from avis where id_livre='$getidlivre' and login='$login'";
        $verifyComment = mysqli_query($conn,$sql);
        if(mysqli_num_rows($verifyComment)>0){
            $msg = "Vous avez déjà ajouté un commentaire";
            header("Location: page_livre.php?id_livre=$getidlivre&erreur=$msg");

        }else{
            $sql = "insert into avis(id_livre, login, commentaire,etoiles, date) values ($getidlivre,'$login', '$comment','$num_etoile', NOW())";

            $insertComment = mysqli_query($conn,$sql); 
            $msg = "Votre commentaire a été ajouté !";
            header("Location: page_livre.php?id_livre=$getidlivre&message=$msg");
        }
        
        
    }else{
        $error =  "Veuillez renseigner un commentaire !";
        header("Location: page_livre.php?id_livre=$getidlivre&erreur=$error");
        
    }
}
else{
    header("Location: connection_page.php");
}

?>