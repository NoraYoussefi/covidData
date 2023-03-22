# covidData

# DOR :  

Le besoin doit être explicitement exprimer 

L’US dispose d’une complexité.  

L'US doit être écrite commencé par : 

“En tant qu’utilisateur, … ” 

“En tant qu’équipe technique, …" 

“En tant que développeur, …" 

“En tant que chef de projet, …" 

Les critères d'acceptation doivent être compris par l'équipe. [Out of Démo] 

Les critères de performance doivent être compris par l'équipe : 

Couverture des tests 

# DOD : 

Il faut que la démo soit expliquée à la fin de chaque user Story. 

Une user Story est dite achevée si tous ces tests techniques sont validés. 

La solution doit être intégrée et testée. 

Le code source doit être logué et commenté. 

# Épopées : 

Mise en place du socle technique d’une API Spring boot 

Gestion d’accès aux données du fichier CSV covid data 

Consultation des données de Covid. 

 

## User story de l’épopée 1 : Mise en place du socle technique d’une API Spring boot 

 

Téléchargement d’une API squelette sur Spring Initialiser 

Télécharger l’IDE Intelij IDEA 

Description : En tant qu’équipe technique, je vais accéder au lien suivant https://www.jetbrains.com/idea/download/ télécharger le version ultimate version 2022.3 en utilisant la licence donnée par le mail éducatif. 

Créer un projet sur Spring Initializr 

Description : En tant qu’équipe technique, je vais accéder au lien suivant https://start.spring.io/ afin de créer un projet Spring boot avec : 

Maven 

Version 3.0.0  

Groupe : fr.ubo 

Artifact: CovidData 

Name : CovidData 

Package name: fr.ubo.CovidData 

Packaging : Jar 

Java : 11 

 

## Ajouter les dépendances nécessaires : 

Lambok 

spring-boot-starter-test* 

spring-boot-devtools 

spring-boot-starter-web 

 

Description : En tant qu’équipe technique, et sur le même site https://start.spring.io/   on doit intégrer la suite des dépendances suivantes : 

 

## Partage de l’api sur gitLab 

Description : En tant que chef de projet, je vais créer un repository sur : https://gitlab.com/ sous le nom de ProjetCovidData avec un nombre de branche pour chaque user story et intégrer l’ensemble de l’équipe technique dans le but d’avoir un projet partagé. 

Cloner le projet de gitLab vers local. 

Description : En tant que développeur, je vais cloner l’application en local en suivant les étapes :        

Exécuter la commande suivante : git clone à partir du terminal.  

Vérifier l’existence du projet sur votre Workspace. 

 

# User story de l’épopée 2 :  Gestion d’accès aux données du fichier CSV covid data 

 

Gestion de l’accès aux données 

Importation du fichier CSV 

Description : En tant que développeur, je souhaite disposer d’un fichier CSV contenant les données mondiales liées à la pandémie du covid en automatisant son téléchargement au moment du lancement de l’application depuis le site coronavirus.politologue.com à partir du lien suivant : https://coronavirus.politologue.com/data/coronavirus/coronacsv.aspx?format=csv&t=pays 

Récupérer les données importées à partir du csv 

Description : En tant que développeur, je souhaite développer une fonction qui permet de récupérer les données de covid à partir du fichier csv téléchargé automatiquement. 

Conversion du fichier CSV en Array. 

Description : En tant que développeur, je souhaite convertir les données du fichier csv sous forme de liste pour pouvoir les manipuler correctement. 

Chaque ligne de csv est une instance d’un bean qui contient les champs suivants : 

Date : String 

Pays : String 

Infections : int 

Deces : int 

Guerisons : Int 

TauxDeces : float 

TauxInfection : float 

 

# User story de l’épopée 3 : Consultation des données de Covid 

 

## Affichage des données selon un pays donné : 

En tant qu’utilisateur vous pouvez savoir selon un pays bien déterminé les données en relation avec le covid tel que le nombre de décès, le taux de contamination, le nombre d’affectation, ... 

Filtrer les données en fonction d’un nom de pays de type String. 

S’assurer d’avoir un paramètre d’entrée nom d’un pays. 

S’assurer que le paramètre d’entrée existe et il est correct. 

S’assurer d’avoir en sortie une liste des données du covid du pays passé en paramètre. 

Visualiser la sortie sur Postman. 

Commenter et loguer le code. 

## Etudier les exceptions : 

Caractère erroné retourne le message “vérifier la saisie, les caractères alphabétiques uniquement sont acceptés. 

Pays inexistant ou vide retourne le message d’erreur “Vérifier le pays que vous avez saisi”.  

Tester l’ensemble des validations de saisie et des fonctions. 

Partager le code sur gitLab. 

Pour pusher sur votre propre branche faite ce qui suit :    

Exécuter la commande suivante :  git checkout <branch name : votre nom> pour accéder à la branche qui vous a été attribuée au début du projet par le chef de projet puis exécuter la commande git push -u <branch name : votre nom>. 

 

How To Demo: se rendre sur Postman, puis saisir l’url suivant en méthode GET :  http://localhost:8080/coviddata/pays 

GET /api/oneContryData : 

Donnée en entrée : countryName 

Données en sortie : liste des données du pays passé en paramètresnprésentes dans le fichier CSV de coronavirus.politologue.com 

Exemple : les données de la France 

Complexité : 5 

 

## Affichage des données selon un pays et une date donnée 

En tant qu’utilisateur vous pouvez savoir selon un pays et une date bien déterminés les données en relation avec le covid tel que le nombre de décès, le taux de contamination, le nombre d’affectation, ... 

Filtrer les données en fonction du nom de pays de type String et date de type String (yyyy-mm-dd). 

S’assurer d’avoir deux paramètres d’entrée nom d’un pays et date. 

S’assurer que les paramètres d’entrée existent et sont corrects. 

Implémenter une fonction de calcule des résultats de la date donnée (soustraction entre les données du jour n-1 et le jour n où n est le jour actuel). 

S’assurer d’avoir en sortie les données du covid du pays précisé sur une date présente. 

Visualiser la sortie sur Postman 

Etudier les exceptions : Caractère erroné retourne le message “vérifier la saisie, les caractères alphabétiques uniquement sont acceptés. 

Pays inexistant ou vide retourne le message d’erreur “Vérifier le pays que vous avez saisi”.  

Date fausse ou non renseigné retourne le message d’erreur “vérifier la date renseignée” 

Commenter et loguer le code. 

Tester l’ensemble des validations de saisie et des fonctions. 

Partager le code sur gitLab. 

Pour pusher sur votre propre branche faite ce qui suit :    

Exécuter la commande suivante :  git checkout <branch name : votre nom> pour accéder à la branche qui vous a été attribuée au début du projet par le chef de projet puis exécuter la commande git push -u <branch name : votre nom>. 

How To Demo : se rendre sur Postman, puis saisir l’url suivant en méthode GET : http://localhost:8080/coviddata/oneCountryDataWithDate 

Donnée en entrée : countryName, date 

Données en sortie : données d’un pays sur une date présentes dans le fichier CSV de coronavirus.politologue.com 

Exemple : les données du Maroc pour la date du 28/01/2022 

 

Complexité : 3  

 

Traitement des données suivant un pays et la date du jour 

En tant qu’utilisateur vous pouvez savoir selon un pays et la date d’aujourd’hui les données en relation avec le covid tel que le nombre de décès, le taux de contamination, le nombre d’affectation, ... 

Filtrer les données en fonction d’un nom de pays de type String. 

S’assurer d’avoir un paramètre d’entrée nom d’un pays. 

S’assurer que le paramètre d’entrée existe et il est correcte. 

Implémenter une fonction de calcule des résultats d’aujourd’hui (soustraction entre les données du jour n-1 et le jour n où n est le jour actuel). 

S’assurer d’avoir en sortie une liste des données du covid du pays passée en paramètres dans la date du jour. 

Visualiser la sortie sur Postman.  

Commenter et loguer le code. 

Etudier les exceptions : Caractère erroné retourne le message “vérifier la saisie, les caractères alphabétiques uniquement sont acceptés. 

Pays inexistant ou vide retourne le message d’erreur “Vérifier le pays que vous avez saisi”.  

Donnée du jour non existant retourne le message d’erreur “Données du jour non encore renseignées” 

Tester l’ensemble des validations de saisie et des fonctions. 

Partager le code sur gitLab. 

Pour pusher sur votre propre branche faite ce qui suit :    

Exécuter la commande suivante :  git checkout <branch name : votre nom> pour accéder à la branche qui vous a été attribuée au début du projet par le chef de projet puis exécuter la commande git push -u <branch name : votre nom>. 

 

How To Demo: se rendre sur Postman, puis saisir l’url suivant en méthode GET : http://localhost:8080/coviddata/ todayCountryData 

GET /api/todayCountryData 

Donnée en entrée : countryName 

Données en sortie : données d’un pays de la date du jour présentes dans le fichier CSV de coronavirus.politologue.com 

Exemple : requête exécuté le 29/01/2022 

Complexité : 3 

 

# Structure du projet : 

Beans 

Service 

DAO  

Controller 

 

 
