-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:3308
-- Généré le : sam. 20 mai 2023 à 17:11
-- Version du serveur :  5.7.33
-- Version de PHP : 7.4.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `tafarou`
--

-- --------------------------------------------------------

--
-- Structure de la table `avis`
--

CREATE TABLE `avis` (
  `id_livre` int(11) NOT NULL,
  `login` varchar(25) NOT NULL,
  `commentaire` text,
  `etoiles` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `avis`
--

INSERT INTO `avis` (`id_livre`, `login`, `commentaire`, `etoiles`, `date`) VALUES
(1, 'george', 'pas mal', 4, '2023-05-20'),
(2, 'polytech', 'bien', 3, '2023-05-20'),
(2, 'woofy', 'cool', 3, '2023-05-18'),
(4, 'george', 'super !!', 3, '2023-05-20'),
(6, 'george', 'bien ', 4, '2023-05-20'),
(6, 'polytech', 'classique', 3, '2023-05-20'),
(12, 'george', 'super ', 3, '2023-05-20');

-- --------------------------------------------------------

--
-- Structure de la table `coeur`
--

CREATE TABLE `coeur` (
  `id` int(11) NOT NULL,
  `commentaire` text,
  `id_livre` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `coeur`
--

INSERT INTO `coeur` (`id`, `commentaire`, `id_livre`) VALUES
(1, NULL, 2);

-- --------------------------------------------------------

--
-- Structure de la table `favoris`
--

CREATE TABLE `favoris` (
  `id` int(11) NOT NULL,
  `id_livre` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `livre`
--

CREATE TABLE `livre` (
  `id_livre` int(11) NOT NULL,
  `titre` varchar(100) DEFAULT NULL,
  `auteur` varchar(50) DEFAULT NULL,
  `genre` varchar(50) DEFAULT NULL,
  `editeur` varchar(50) DEFAULT NULL,
  `image` varchar(500) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `nb_page` int(11) DEFAULT NULL,
  `resu` text,
  `langue` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `livre`
--

INSERT INTO `livre` (`id_livre`, `titre`, `auteur`, `genre`, `editeur`, `image`, `date`, `nb_page`, `resu`, `langue`) VALUES
(1, 'Harry Potter', 'J.K Rowling', 'Magique', 'Golio', 'https://cdn.cultura.com/cdn-cgi/image/width=1280/media/pim/TITELIVE/8_9782070585229_1_75.jpg', '1997-06-26', 230, 'Les aventures d\'un apprenti sorcier à Poudlard', 'français'),
(2, 'Seigneur des anneaux', 'J.R.R Tolkien', 'Fantastique', 'Pocket', 'https://m.media-amazon.com/images/I/514+aP+SZ+L._SY344_BO1,204,203,200_.jpg', '1954-01-01', 490, 'Un jeune hobbit en quête de l\'anneau du pouvoir mais Sauron fera tout pour lui mettre des battons dans les roues', 'français'),
(4, 'jack et le haricot magique', 'frederic bernard', 'fantastique', 'pere castor', 'https://m.media-amazon.com/images/I/41F+i3LyCkL._SX258_BO1,204,203,200_.jpg', '2023-05-20', 500, 'c est l histoire de jack qui chasse des harcicots magique pour etre riche', 'francais'),
(5, 'shrek', 'patrick suziland', 'fantastique', 'moon', 'https://m.media-amazon.com/images/I/41PEsu4z5BL._AC_SY445_.jpg', '2023-05-20', 150, 'c est l histoire de shrek un ogre vert super sympa mais qui fait peur et il veut avoir des amis et ne plus faire peur', 'francais'),
(6, 'comme toi', 'lisa jeweel', 'thriller', 'hachette', 'https://m.media-amazon.com/images/I/91PMbG8qzmL.jpg', '2023-05-20', 210, 'Ellie a disparu à lâge de quinze ans. Sa mère n a jamais réussi à faire son deuil, d autant plus que la police n a retrouvé ni le coupable ni le corps. Dix ans plus tard, cette femme brisée doit pourtant se résoudre à tourner la page. C est alors qu elle fait la connaissance de Floyd, un homme charmant, père célibataire, auquel elle se lie peu à peu. Mais lorsqu elle rencontre la fille de celui-ci, Poppy, âgée de neuf ans, le passé la rattrape brutalement : cette fillette est le portrait craché de sa fille disparue... \r\n ', 'francais'),
(7, 'tout le bleu du ciel', 'mélissa da costa', 'amour', 'hachette', 'https://m.media-amazon.com/images/I/71axJGiGD4L.jpg', '2023-05-20', 840, 'Petitesannonces.fr : Jeune homme de 26 ans, condamné à une espérance de vie de deux ans par un Alzheimer précoce, souhaite prendre le large pour un ultime voyage. Recherche compagnon(ne) pour partager avec moi ce dernier périple.\r\nÉmile a décidé de fuir l’hôpital, la compassion de sa famille et de ses amis. À son propre étonnement, il reçoit une réponse à cette annonce. Trois jours plus tard, devant le camping-car acheté secrètement, il retrouve Joanne, une jeune femme coiffée d’un grand chapeau noir qui a pour seul bagage un sac à dos, et qui ne donne aucune explication sur sa présence.\r\nAinsi commence un voyage stupéfiant de beauté. À chaque détour de ce périple naissent, à travers la rencontre avec les autres et la découverte de soi, la joie, la peur, l’amitié, l’amour qui peu à peu percent la carapace de douleurs d’Émile.', 'anglais'),
(8, 'le premier jour du reste de ma vie', 'virginie grimaldi', 'aventure', 'hachette', 'https://m.media-amazon.com/images/I/710uUrN409L.jpg', '2022-02-25', 336, '', 'francais'),
(9, 'on se reverra', 'lisa jewell', 'thriller', 'hachette', 'https://m.media-amazon.com/images/I/41RyYTW-HXL.jpg', '2023-05-16', 492, 'Les souvenirs, c’est comme les cadavres : tôt ou tard, ils refont surface.\r\n\r\nQui est cet homme assis sur la plage en pleine tempête, sur le lieu d’un crime commis vingt ans plus tôt ? Il n’a pas de nom, pas de manteau, et a perdu la mémoire. Alice prend l’inconnu sous son aile et décide de l’héberger, sans savoir qu’il va bouleverser sa vie à jamais.\r\n\r\nAu même moment, dans la banlieue de Londres, Lily attend en vain le retour de l’homme qu’elle vient d’épouser et dont la police tarde à signaler la disparition. Parviendra-t-elle à retrouver celui pour qui elle a tout abandonné ?', 'anglais'),
(10, 'haute saison', 'adele breau', 'comique', 'hachette', 'https://m.media-amazon.com/images/I/51-SlnUH5ML.jpg', '2023-05-20', 103, 'Un club de vacances sur la côte basque.\r\nQuatre solitudes qui n’auraient jamais dû se rencontrer.\r\nUne histoire d’amitié et de rédemption.\r\nAnglet, fin juillet. À la réception du Club Océan, Germain accueille comme chaque semaine les nouveaux arrivants, avec un mélange de plaisir et d’appréhension…\r\nAu milieu des habitués, certains clients goûtent pour la première fois aux « joies du club ». Chantal, qui débarque sans grand enthousiasme avec ses petits-enfants, Matthias, papa solo ayant cédé à l’appel de l’option « mini-club », et Fanny, venue en famille pour tenter de resserrer les liens, vont plonger dans ce huis clos aussi enjoué qu’inquiétant, dont la feuille de route est claire : faites connaissance et a-mu-sez-vous !\r\nMais qu’a-t-on à partager avec des êtres si différents ? Entre tournois de tir à l’arc, plaisirs du self et jeux apéro, ces vacanciers contraints de cohabiter parviendront-ils à rompre la glace malgré les secrets qu’ils ont emportés dans leurs bagages ? Peut-on réparer ce qui a été brisé ? Faut-il se lever à l’aube pour avoir un transat à la piscine ? Autant de questions à la fois profondes et légères qui portent ce roman solaire, plein d’humour, d’émotion et d’humanité.', 'anglais'),
(11, 'forgez vous un mental de guerrier', 'pierre patrick', 'encyclopédie ', 'hachette', 'https://m.media-amazon.com/images/I/41p012FvvWL._AC_SX60_CR,0,0,60,60_.jpg', '2023-05-20', 259, '\r\nEXERCICES DE RENFORCEMENT MENTAL ET ASTUCES DE RÉUSSITE\r\nLe Mental est sans aucun doute la chose la plus importante et universelle dans la vie !\r\n\r\nQuel est le point commun entre Elon Musk (créateur de SpaceX), Mike Tyson (légende de la boxe), Jeff Bezos (Créateur d’Amazon), ou encore Nelson Mandela (leader du combat des noirs contre la ségrégation) ?\r\n\r\nPourquoi Kobe Bryant, F. Mayweather, ou encore C. McGregor sont-ils devenus les champions qu’ils ont toujours souhaité être ?Pourquoi ont-ils atteint des sommets jusqu’à là encore inégalés ?\r\n\r\nLa réponse est simple, tous ces êtres possèdent un Mental or norme ! Ils se sont forgé une force psychologique titanesque qui leur a permis de réaliser des prouesses surhumaines, et d\'obtenir des résultats légendaires.\r\n\r\nLe Mental permet de réaliser n\'importe quel projet ! Que ce soit dans le sport, le travail, les études, ou justes dans la vie, Le Mental est le moteur de tout succès !\r\n\r\nMais qu\'est-ce que ce fameux \"Mental\" et comment l\'obtenir ?\r\n\r\nLa réponse se trouve dans ce guide ! Ces 228 pages vous apprendront ce qu\'est réellement \"Le Mental » et vous révèleront tous les secrets pour se forger un Mental de Guerrier !\r\n\r\nVous y retrouverez de nombreux exercices pour améliorer ce dernier. En passant de la résistance à la douleur jusqu\'à la gestion du stress, vous apprendrez à faire face à de rudes épreuves, ainsi qu\'à vous lancer de grandes entreprises.\r\nLe livre vous transmettra les techniques pour endurer et combattre votre flemme, afin de lutter contre la procrastination ou \"la malédiction canapé\".\r\nEn abordant l\'aspect psychologique du Mental, et tout en vulgarisant le sujet afin de le rendre accessible à tous, ce livre vous offre les clés pour éradiquer vos peurs, vos problèmes, et votre côté défaitiste.\r\nÀ la fois tourné vers le développement personnel, mais également axé sur la réussite entrepreneuriale, cet ebook vous fournit un grand nombre d\'astuces concrètes et applicables pour atteindre vos ambitions les plus extraordinaires. En passant de la Morning Routine, par la visualisation, et par la reprogrammation de votre subconscient, toutes les étapes de la victoire vous sont servies sur un plateau !\r\n\r\nEnvie de vous affranchir du regard des autres ?\r\nOu bien d’arriver à être honnête avec vos proches ?\r\nPeut-être que vous préparez un marathon ou un combat de MMA ?\r\nNon, je sais, vous voulez détruire vos phobies et vos angoisses les plus profondes, pour être capable de vous canaliser face à ces dernières ?\r\nOu simplement, vous voulez arriver à gérer votre pression au quotidien entre votre famille, votre boulot, et vos amis ?\r\n\r\nPeu importe votre motif, nous avons tous besoin d’un Mental de Guerrier ! Cet ouvrage s’adresse donc à toute et à tous, au petit comme au grand, aux riches comme aux moins riches, aux heureux comme au triste !\r\n\r\nEn appliquant ses méthodes, vous foncerez vers l’impossible, et deviendrez la meilleure version de vous-même ! Celle que vous avez toujours voulu être, celle à laquelle vous pensiez en regardant le héros d’un film, ou encore celle que vous essayez d’atteindre depuis si longtemps, et qui, après avoir lu ce livre, vous sera devenue réelle !\r\nSuivez la préparation mentale et le coaching appliqué de ce guide, et atteignez une excellence ainsi qu\'un bonheur que vous n’aviez encore jamais connu ! Vivez votre vie comme vous l’avez toujours rêvé !\r\n\r\nÀ travers ses 8 grandes parties, ce guide vous donnera le goût de l\'effort, du travail, et de la récompense :\r\n•Partie I : Qu\'est-ce que Le Mental ?\r\n•Partie II : Les concepts du Mental\r\n•Partie III : Les Lois du Mental\r\n•Partie IV : Métaphore de synthèse\r\n•Partie V : Reprogrammer son subconscient\r\n•Partie VI : Exercices pour entrainer votre Mental\r\n•Partie VII : Astuces de réussite\r\n•Partie VIII : Les limites du Mental', 'francais'),
(12, 'tu ne peux pas acheter mon amour', 'Nora h', 'amour', 'hachette', 'https://m.media-amazon.com/images/I/51c5Qo+XS1L.jpg', '2023-05-20', 369, 'Amuse-toi comme tu veux et avec qui tu veux. Tant que je récupère mon blé, ce n’est pas mon problème »\r\n— C’est vrai ce que tu viens de me dire ?\r\n— De quoi ?\r\n— Que je te plais ?\r\n— Je ne suis pas connu pour raconter que des conneries.\r\n— Je te demande juste si c’est vrai.\r\nUn voile sombre apparait dans ses yeux l’espace d’un instant. Tyler prend une liasse de billets dans sa poche et me le tend.\r\n— Garde la monnaie.\r\n\r\n---\r\nQuand Morgane apprend que son père a emprunté de l’argent à un gang après avoir perdu son emploi, et que ses parents sont sur le point de perdre leur maison, elle décide de prendre les choses en main.\r\n\r\nElle pousse les portes de l’Angel Snake, un bar mal famé, repaire des Brotherhood, un club de motards, pour leur proposer un marché.\r\n\r\nUn jeu dangereux pour une jeune fille jolie et un peu trop naïve…\r\n\r\nSurtout que le vice-président du club, Tyler, semble vouloir s’occuper de son cas en personne…', 'francais'),
(13, 'le secret du faucon', 'A.D martel', 'science fiction', 'hachette', 'https://m.media-amazon.com/images/I/51w8XQTK0NS.jpg', '2023-05-02', 259, 'Fini de fuir ! L’heure est venue de riposter et de rassembler des alliés. Le combat contre le maître des ombres peut commencer.\r\n', 'francais'),
(14, 'Au premier regard', 'lisa gardner', 'thriller', 'hachette', 'https://m.media-amazon.com/images/I/51CKUBpuJIL.jpg', '2023-05-16', 492, 'Un thriller palpitant et diablement féministe. » Paris Match\r\n\r\nL’agent du FBI Kimberly Quincy, le commandant D.D. Warren et Flora Dane, les trois héroïnes de Lisa Gardner de nouveau réunies dans un thriller à couper le souffle.', NULL),
(15, 'Dante', 'lucy lennox', 'amour', 'hachette', 'https://m.media-amazon.com/images/I/41Ro1ZKlQ+L._SY346_.jpg', '2023-05-20', 840, 'AJ\r\n\r\nJe connais l’histoire de Dante mieux que quiconque. Après tout, c’est moi qui l’ai sorti des griffes de son père abusif et homophobe il y a huit ans. Depuis, j’ai gardé mes distances, mais lorsque je tombe sur lui au gala de la Maison Marian et qu’il ne me reconnaît pas, je ne peux résister à l’homme incroyable et sensible qu’il est devenu.\r\n\r\nJe ferai tout pour protéger Dante Marian, mais que faire si son passé m’empêche de faire partie de son futur ?', 'francais');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `login` varchar(25) NOT NULL,
  `MDP` varchar(255) DEFAULT NULL,
  `date_creation` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`login`, `MDP`, `date_creation`) VALUES
('bimou', 'ee3717503d44179dc77c7c9f6368d8774adc4de7', '2023-05-20'),
('dede', 'faccdb9f1b1b9c4263670ffcfdfc2e1832f0f8b8', '2023-05-20'),
('george', '355f9914a809b1f14257df3a6df07bf95bf67bbd', '2023-05-20'),
('georges', 'tes', '2023-05-11'),
('georgio', 'tes', '2023-05-11'),
('gou', 'tets', '2023-05-11'),
('lois', 'lois', '2023-05-11'),
('machin', '48c00c4dd91abfe0c1ed16f23983fd0f90978160', '2023-05-16'),
('noelFlantier', 'test', '2023-05-11'),
('oui', 'oui', '2023-05-11'),
('polytech', 'f5bfef141093e4d6e5f9aedbd1edd4068e3fb1ed', '2023-05-13'),
('test', 'test', '2023-05-11'),
('ugo', 'ro', '2023-05-13'),
('woofy', 'bb58b640edddade5e5f8dbedf828d8af6f411432', '2023-05-13'),
('yassir', '45d9fd660d7e594069a2c433e0226729f4b8c7fc', '2023-05-19');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `avis`
--
ALTER TABLE `avis`
  ADD PRIMARY KEY (`id_livre`,`login`),
  ADD KEY `login` (`login`);

--
-- Index pour la table `coeur`
--
ALTER TABLE `coeur`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_livre` (`id_livre`);

--
-- Index pour la table `favoris`
--
ALTER TABLE `favoris`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_fav` (`id_livre`);

--
-- Index pour la table `livre`
--
ALTER TABLE `livre`
  ADD PRIMARY KEY (`id_livre`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`login`),
  ADD UNIQUE KEY `login` (`login`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `coeur`
--
ALTER TABLE `coeur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `favoris`
--
ALTER TABLE `favoris`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `livre`
--
ALTER TABLE `livre`
  MODIFY `id_livre` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `avis`
--
ALTER TABLE `avis`
  ADD CONSTRAINT `avis_ibfk_1` FOREIGN KEY (`id_livre`) REFERENCES `livre` (`id_livre`),
  ADD CONSTRAINT `avis_ibfk_2` FOREIGN KEY (`login`) REFERENCES `utilisateur` (`login`);

--
-- Contraintes pour la table `coeur`
--
ALTER TABLE `coeur`
  ADD CONSTRAINT `coeur_ibfk_1` FOREIGN KEY (`id_livre`) REFERENCES `livre` (`id_livre`);

--
-- Contraintes pour la table `favoris`
--
ALTER TABLE `favoris`
  ADD CONSTRAINT `fk_fav` FOREIGN KEY (`id_livre`) REFERENCES `livre` (`id_livre`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
