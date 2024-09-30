# Suivi des Scripts des Développeurs

## Description
Ce projet vise à suivre l'évolution des scripts élaborés par les membres d'une équipe de développement. Chaque semaine, le chef de projet rédige un rapport qui résume le nombre de scripts réalisés quotidiennement par chaque développeur. Les informations pertinentes sont stockées dans une base de données MySQL, et l'application utilise JDBC pour gérer toutes les interactions avec cette base.

## Structure de la Base de Données

### Table : ScriptsRéalisés
- **Développeur** (VARCHAR) : Le nom du développeur.
- **Jour** (VARCHAR) : Le jour de la semaine durant lequel les scripts ont été réalisés.
- **NBScripts** (INT) : Le nombre total de scripts développés.

### Exemple de Données :
| Développeur | Jour    | NBScripts |
|-------------|---------|-----------|
| ALAMI       | Lundi   | 1         |
| WAFI        | Lundi   | 2         |
| SALAMI      | Mardi   | 9         |

## Technologies Utilisées
- **Langage :** Java
- **Base de Données :** MySQL
- **JDBC :** Utilisé pour établir la connexion et gérer les opérations sur la base de données.

## Prérequis
- **MySQL :** Assurez-vous que MySQL est correctement installé et configuré sur votre système.
- **Driver JDBC MySQL :** Téléchargez et ajoutez le driver JDBC MySQL à votre classpath.

## Étapes pour Lancer l’Application
1. Clonez le dépôt depuis GitHub.
2. Créez la base de données et la table selon la structure fournie dans le fichier SQL.
3. Mettez à jour les informations de connexion dans le fichier Java (URL, nom d'utilisateur, mot de passe).
4. Compilez et exécutez le programme Java pour interagir avec la base de données et suivre l'avancement des scripts des développeurs.

## Video


https://github.com/user-attachments/assets/6d23ecf9-f945-4203-81e0-3e58918ef282


# TP JDBC 

## Description
Ce TP consiste à développer une application Java pour gérer des informations relatives aux villes en utilisant JDBC et MySQL. Les principales fonctionnalités incluent l'ajout, la mise à jour, la suppression et l'affichage des données des villes. Chaque ville est enregistrée dans une base de données MySQL avec un identifiant unique et un nom associé.

## Structure de la Base de Données

### Table : Villes
- **id** (INT, clé primaire) : Identifiant unique de chaque ville.
- **nom** (VARCHAR) : Nom de la ville.

### Exemples de Données :
| id  | nom        |
|-----|------------|
| 1   | SAFI       |
| 2   | MARRAKECH  |
| 3   | EL JADIDA  |

## Technologies Utilisées
- **Langage :** Java
- **Base de Données :** MySQL
- **JDBC :** Utilisé pour gérer les interactions avec la base de données.

## Prérequis
- **MySQL :** Vérifiez que MySQL est installé et configuré sur votre machine.
- **Driver JDBC MySQL :** Téléchargez et intégrez le driver JDBC MySQL à votre classpath.
## Video
https://github.com/user-attachments/assets/f90987e0-14c0-42dd-ba4e-a78e732c5d2e


