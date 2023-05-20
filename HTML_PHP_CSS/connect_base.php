<?php   
    $conn = @mysqli_connect("tp-epua:3308", "tafarou", "rt45y8at");    
    if (mysqli_connect_errno()) {
            $msg = "erreur ". mysqli_connect_error();
        } else {  
            $msg = "connecté au serveur " . mysqli_get_host_info($conn);
            mysqli_select_db($conn, "tafarou"); 
            mysqli_query($conn, "SET NAMES UTF8");
        }
?>