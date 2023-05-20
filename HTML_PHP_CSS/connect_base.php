<?php   
    $conn = mysqli_connect("localhost", "root", "", "tafarou");
    if (mysqli_connect_errno()) {
            $msg = "erreur ". mysqli_connect_error();
        } else {  
            $msg = "connecté au serveur " . mysqli_get_host_info($conn);
            mysqli_select_db($conn, "tafarou"); 
            mysqli_query($conn, "SET NAMES UTF8");
        }
?>