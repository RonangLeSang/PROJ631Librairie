<meta charset="utf-8">
<?php
session_start();
include 'connect_base.php';
if($_SESSION["auth"]){
    $getidlivre = $_GET['id_livre'];
    if(!empty($_POST["comment"]) and !empty($_POST["rating"])){
        $comment = htmlspecialchars($_POST["comment"]);
        $login = $_SESSION['login'];
        
        $num_etoiles = $_POST['rating'];
        
        $sql = "select * from avis where id_livre='$getidlivre' and login='$login'";
        $verifyComment = mysqli_query($conn,$sql);
        if(mysqli_num_rows($verifyComment)>0){
            $msg = "Vous avez déjà ajouté un commentaire";
            header("Location: page_livre.php?id_livre=$getidlivre&erreur=$msg");

        }else{
            $sql = "insert into avis(id_livre, login, commentaire,etoiles, date) values ($getidlivre,'$login', '$comment','$num_etoiles', NOW())";

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