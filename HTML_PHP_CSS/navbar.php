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
            <form action="" method="get">
                <input type="text" name="search" placeholder="Rechercher">
                <button type="submit" name="loupe"><i class="fa-solid fa-magnifying-glass"></i></button>
                        
            </form>
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
        