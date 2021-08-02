-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Lun 02 Août 2021 à 04:40
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `library`
--

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `identifiant` varchar(6) NOT NULL,
  `nom` varchar(40) NOT NULL,
  `prenom` varchar(40) NOT NULL,
  `sexe` tinyint(1) NOT NULL,
  `motdepasse` varchar(40) NOT NULL,
  PRIMARY KEY (`identifiant`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `admin`
--

INSERT INTO `admin` (`identifiant`, `nom`, `prenom`, `sexe`, `motdepasse`) VALUES
('ad001', 'admin', 'adminprenom', 1, 'adminmdp');

-- --------------------------------------------------------

--
-- Structure de la table `administrateur`
--

CREATE TABLE IF NOT EXISTS `administrateur` (
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `sexe` text NOT NULL,
  `identifiant` varchar(8) NOT NULL,
  `date` date NOT NULL,
  `motdepasse` varchar(13) NOT NULL,
  `numtel` text NOT NULL,
  `email` text NOT NULL,
  PRIMARY KEY (`identifiant`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `administrateur`
--

INSERT INTO `administrateur` (`nom`, `prenom`, `sexe`, `identifiant`, `date`, `motdepasse`, `numtel`, `email`) VALUES
('Victor ', 'king', 'M', 'ad002', '2021-06-28', 'king', '673737272', 'victorking@gmail.com'),
('kibiti', 'wen', 'M', 'ad003', '2021-06-24', 'wenlife', '065596489', 'lifr@gmail.com'),
('mpassi', 'veronique', 'feminin', 'ad0054', '2021-07-02', 'loveyou', '653779559', 'veronique@gmail.com');

-- --------------------------------------------------------

--
-- Structure de la table `cd`
--

CREATE TABLE IF NOT EXISTS `cd` (
  `Titre` varchar(50) NOT NULL,
  `Auteur` text NOT NULL,
  `DatePublication` date NOT NULL,
  `NombreDexemplaires` int(11) NOT NULL,
  `Positionement` text NOT NULL,
  `MaisonEdition` text NOT NULL,
  `duree` time NOT NULL,
  `Taille` int(11) NOT NULL,
  `nomImage` text NOT NULL,
  `identifiant` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`identifiant`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `cd`
--

INSERT INTO `cd` (`Titre`, `Auteur`, `DatePublication`, `NombreDexemplaires`, `Positionement`, `MaisonEdition`, `duree`, `Taille`, `nomImage`, `identifiant`) VALUES
('CD cours d''anglais', 'BritishMan', '2017-06-06', 20, 'R2C4', 'BritishHouse', '00:02:00', 500, 'cdEnglishLessons.jpg', 2),
('Cent Conseils de Padampa', 'Padamakara', '2013-06-01', 20, 'R2C5', 'LifeHouse', '00:05:00', 800, 'centConseils.jpg', 3);

-- --------------------------------------------------------

--
-- Structure de la table `empruntetudiantcd`
--

CREATE TABLE IF NOT EXISTS `empruntetudiantcd` (
  `matricule` varchar(10) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dateEmprunt` date DEFAULT NULL,
  `identifiant` int(11) NOT NULL,
  `dateRetour` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `matricule` (`matricule`),
  KEY `identifiant` (`identifiant`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `empruntetudiantcd`
--

INSERT INTO `empruntetudiantcd` (`matricule`, `id`, `dateEmprunt`, `identifiant`, `dateRetour`) VALUES
('uiecc20', 1, '2021-06-28', 2, '2021-06-29'),
('uiecc20', 2, '2021-06-28', 3, '2021-06-29'),
('uiecc20', 3, '2021-06-29', 3, NULL),
('life23', 4, '2021-07-02', 2, '2021-07-02');

-- --------------------------------------------------------

--
-- Structure de la table `empruntetudiantmdr`
--

CREATE TABLE IF NOT EXISTS `empruntetudiantmdr` (
  `matricule` varchar(10) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dateEmprunt` date DEFAULT NULL,
  `identifiant` int(11) NOT NULL,
  `dateRetour` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `matricule` (`matricule`),
  KEY `identifiant` (`identifiant`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Contenu de la table `empruntetudiantmdr`
--

INSERT INTO `empruntetudiantmdr` (`matricule`, `id`, `dateEmprunt`, `identifiant`, `dateRetour`) VALUES
('uiecc20', 3, '2021-06-28', 5, NULL),
('uiecc20', 4, '2021-06-29', 5, '2021-06-29'),
('life23', 5, '2021-07-02', 4, '2021-07-02'),
('uiecc18', 6, '2021-07-03', 4, '2021-07-03'),
('uiecc18', 7, '2021-07-03', 5, '2021-07-18');

-- --------------------------------------------------------

--
-- Structure de la table `empruntslivresetudiants`
--

CREATE TABLE IF NOT EXISTS `empruntslivresetudiants` (
  `matricule` varchar(10) NOT NULL,
  `id` int(11) NOT NULL,
  `dateEmprunt` date NOT NULL,
  `identifiant` int(11) NOT NULL AUTO_INCREMENT,
  `dateRetour` date DEFAULT NULL,
  PRIMARY KEY (`identifiant`),
  KEY `matricule` (`matricule`),
  KEY `id` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=15 ;

--
-- Contenu de la table `empruntslivresetudiants`
--

INSERT INTO `empruntslivresetudiants` (`matricule`, `id`, `dateEmprunt`, `identifiant`, `dateRetour`) VALUES
('uiecc20', 10, '2021-06-28', 9, '2021-06-29'),
('uiecc20', 10, '2021-06-28', 10, '2021-06-29'),
('uiecc20', 9, '2021-06-29', 11, '2021-07-14'),
('uiecc20', 10, '2021-06-29', 12, '2021-07-14'),
('life23', 10, '2021-07-02', 13, '2021-07-02'),
('life23', 9, '2021-07-02', 14, '2021-07-02');

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

CREATE TABLE IF NOT EXISTS `etudiant` (
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `sexe` text NOT NULL,
  `Filiere` varchar(16) NOT NULL,
  `dateInscription` date NOT NULL,
  `matricule` varchar(10) NOT NULL,
  `telephone` text NOT NULL,
  `email` text NOT NULL,
  PRIMARY KEY (`matricule`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `etudiant`
--

INSERT INTO `etudiant` (`nom`, `prenom`, `sexe`, `Filiere`, `dateInscription`, `matricule`, `telephone`, `email`) VALUES
('kibiti', 'wen', 'F', 'ISN', '2021-06-30', 'life23', '065596489', 'life@gmail.com'),
('Mabiala', 'wenlife', 'M', 'INS', '2021-06-21', 'uiecc11', '678543223', 'wenlife@gmail.com'),
('kibiti', 'reine', 'feminin', 'INS', '2021-07-02', 'uiecc123', '065534789', 'reineginelda@gmail.com'),
('Onana', 'michel', 'M', 'CDN', '2021-06-21', 'uiecc15', '678543223', 'onanamichel@gmail.com'),
('Ousmane', 'meriga', 'M', 'ISN', '2021-06-21', 'uiecc18', '678543223', 'ousmanemeriga@gmail.com'),
('Ombi', 'pardon', 'M', 'INS', '2021-06-21', 'uiecc19', '678543223', 'ombipardon@gmail.com'),
('Boukeyi', 'exauce', 'M', 'CDN', '2021-06-21', 'uiecc20', '678543223', 'boukeyiexauce@gmail.com'),
('Abeng', 'aristide', 'M', 'ISN', '2021-06-11', 'uiecc23', '676767676', 'biloa@gmail.com');

-- --------------------------------------------------------

--
-- Structure de la table `lecturer`
--

CREATE TABLE IF NOT EXISTS `lecturer` (
  `Identifiant` varchar(8) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `sexe` text NOT NULL,
  `departement` varchar(18) NOT NULL,
  `date` date NOT NULL,
  `numtel` text NOT NULL,
  `email` text NOT NULL,
  PRIMARY KEY (`Identifiant`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `lecturer`
--

INSERT INTO `lecturer` (`Identifiant`, `nom`, `prenom`, `sexe`, `departement`, `date`, `numtel`, `email`) VALUES
('ad0034', 'MABIALA KIBITI', 'wen bonheur', 'M', 'ISN', '2021-06-24', '065596489', 'wenlife@gmail.com'),
('id003', 'Henry', 'Thierry', 'M', 'CDN', '2021-07-13', '694891137', 'thierryhenry@gmail.com'),
('lc001', 'Durand', 'Therese', 'F', 'CDN', '2021-06-28', '678686960', 'theresedurand@gmail.com'),
('LC34', 'kibiti', 'Nestor', 'mascuin', 'physique chimie', '2021-07-02', '055772245', 'nestor@gmail.com');

-- --------------------------------------------------------

--
-- Structure de la table `livre`
--

CREATE TABLE IF NOT EXISTS `livre` (
  `Titre` text NOT NULL,
  `Auteur` text NOT NULL,
  `DatePublication` date NOT NULL,
  `NombreDexemplaires` int(11) NOT NULL,
  `Positionement` text NOT NULL,
  `MaisonEdition` varchar(30) NOT NULL,
  `Stylecategorie` varchar(20) NOT NULL,
  `nbPage` int(11) NOT NULL,
  `edition` varchar(30) NOT NULL,
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `nomImage` text NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Contenu de la table `livre`
--

INSERT INTO `livre` (`Titre`, `Auteur`, `DatePublication`, `NombreDexemplaires`, `Positionement`, `MaisonEdition`, `Stylecategorie`, `nbPage`, `edition`, `Id`, `nomImage`) VALUES
('Le pouvoir de L''ethnie', 'Paul Abouna', '2011-01-03', 10, 'R3C4', 'Harmattan', 'Anthropologie', 134, '1ere Edition', 9, 'pouvoirDeLethnie.jpg'),
('Mathematiques pour L''informatique', 'Jacques Velu, Genevieve Averous, Isabelle Gil, Francoise Santi', '2011-01-03', 10, 'R3C4', 'DUNOD', 'Sciences sup', 240, '1ere Edition', 10, 'mathPourInformatique.jpg');

-- --------------------------------------------------------

--
-- Structure de la table `rsd`
--

CREATE TABLE IF NOT EXISTS `rsd` (
  `Titre` varchar(50) NOT NULL,
  `Auteur` text NOT NULL,
  `DatePublication` date NOT NULL,
  `NombreDexemplaires` int(11) NOT NULL,
  `Positionement` varchar(20) NOT NULL,
  `MaisonEdition` text NOT NULL,
  `identifiant` int(11) NOT NULL AUTO_INCREMENT,
  `nomImage` text NOT NULL,
  PRIMARY KEY (`identifiant`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Contenu de la table `rsd`
--

INSERT INTO `rsd` (`Titre`, `Auteur`, `DatePublication`, `NombreDexemplaires`, `Positionement`, `MaisonEdition`, `identifiant`, `nomImage`) VALUES
('Nous Avons Plusieurs Memoires', 'Science Magazine', '2013-06-15', 35, 'R10C2', 'Science Magazine', 4, 'magazineScientifique.jpg'),
('Jumeaux', 'National Geographic Sciences', '2020-06-21', 5, 'R2C2', ' National Geographic', 5, 'magazineNatGeo.jpg');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `empruntetudiantcd`
--
ALTER TABLE `empruntetudiantcd`
  ADD CONSTRAINT `empruntetudiantcd_ibfk_1` FOREIGN KEY (`matricule`) REFERENCES `etudiant` (`matricule`),
  ADD CONSTRAINT `empruntetudiantcd_ibfk_2` FOREIGN KEY (`identifiant`) REFERENCES `cd` (`identifiant`);

--
-- Contraintes pour la table `empruntetudiantmdr`
--
ALTER TABLE `empruntetudiantmdr`
  ADD CONSTRAINT `empruntetudiantmdr_ibfk_1` FOREIGN KEY (`matricule`) REFERENCES `etudiant` (`matricule`),
  ADD CONSTRAINT `empruntetudiantmdr_ibfk_2` FOREIGN KEY (`identifiant`) REFERENCES `rsd` (`identifiant`);

--
-- Contraintes pour la table `empruntslivresetudiants`
--
ALTER TABLE `empruntslivresetudiants`
  ADD CONSTRAINT `empruntslivresetudiants_ibfk_1` FOREIGN KEY (`matricule`) REFERENCES `etudiant` (`matricule`),
  ADD CONSTRAINT `empruntslivresetudiants_ibfk_2` FOREIGN KEY (`id`) REFERENCES `livre` (`Id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
