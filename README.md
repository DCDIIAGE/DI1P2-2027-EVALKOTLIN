# Weather App

## Description

EvalutationKotlin est une app qui permet aux utilisateurs de voir la météo un jour J données. L'application récupère les données météorologiques via une API REST (enfin quand ça marche, parce que les ajouts de dépendance rétrofit et gson sont là) et affiche les informations. Il suffit d'appuyer avec l'un de ses doigts (je ne sais pas si d'autre partie du corp ça marche) sur une InfoBox pour afficher les détails.

## Fonctionnalités

- Affichage des prévisions météorologiques pour plusieurs jours (Dans limite disponible d'informations stocké dans l'API).
- Récupération des données météorologiques via une API (Bon c'est Mocké, vu comment le call API fonctionne...).
- Mode sombre et s'adapte à la langue de l'utilisateur.
- Le téléphone explose et vibre quand on appuis sur la flèche pour voir les détails.

## Technologies Utilisées

- **Kotlin** : Langage de programmation principal.
- **Jetpack Compose** : Bibliothèque pour construire des interfaces utilisateur modernes.
- **Retrofit** : Bibliothèque pour effectuer des appels réseau et gérer les réponses JSON.
- **Gson** : Bibliothèque pour la sérialisation et la désérialisation des objets JSON.

## Prérequis

- Installer Android Studio version ladyBug (La dernière version...)
- Un émulateur Android ou son téléphone portable avec le SDK 35 pour tester l'application.

## Ce qui a été fait:

Modification du Manifest pour ajouter les permissions requise au téléphone pour utiliser la vibration ainsi que les sons.
Permissions internet ajouté pour utiliser des call API.
Suppressions de dépendance qui ne servent à rien dans le Manifest, qui faisait généré des Warning.
Utilisation des ressource Raw (pour les sons), Color.xml (Pour les couleurs et notamment le darkmode), String.xml (Pour les données textuelles et adapter la langue de son interlocuteur).
Réalisation de deux screen un pour le menu principale et l'autre pour l'affichage des détails.
Navigation à l'aide du NavHost et des LaunchedEffect et du ViewModel.
Utilisation des repositories pour récupérer les données de source externes (fichier, API, bdd, ...).

Utilisation des ViewModels pour conserver les états de chaque écrans.
C'est par défaut, mais c'est bien une seule application qui est utilisé.
