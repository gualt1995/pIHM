README - freshfood

	Organisation du code :

Nous avons décidé de coder le prototype sous Android, le code est donc organisé de façon standard par android Studio, 
les classes java principales se trouvent donc dans le le dossier “freshfoods\app\src\main\java\com\tndnc\freshfood”.  
Pour des soucis d’organisations nous avons séparé une partie du code en différentes catégories : activities , 
models (back end de l’application), views, utils. Vous trouverez également les ressources du projet dans : 
“freshfoods\app\src\main\res comprenant” notamment les layouts de l’application et les images utilisées. 
Finalement vous trouverez dans le dossier assets le fichier XML menu qui peut être édité pour modifier le contenu du menu.

	l’interface :

Lorsque l’application est ouverte l'utilisateur arrive sur une page de garde, il a ensuite trois choix, 
il peut ouvrir le menu, appeler un serveur, ou bien obtenir plus d’informations sur le restaurant grâce au bouton about.
Quand l’utilisateur ouvre l’interface du menu il a la possibilité d’ajouter des plat/boissons à son panier, 
tout en faisant des requêtes spéciales, ou obtenir des informations sur le plat sélectionné.
Après avoir choisi ses plats l’utilisateur peut passer en revue tous les articles de sons panier, 
en enlever certains s'il ne désire plus les commander puis lorsqu’il est prêt il peut choisir de passer sa commande, 
ce qui ouvrira le menu de sélection du moyen de paiement. Après avoir sélectionné ce dernier 
il n’a plus qu'à attendre sa commande. 

	Fonctionnalités : 

-> La présence d’un bouton pour appeler un serveur
-> Présence d’un bouton avec interrogation pour afficher les détails d’un plat
-> Affichage d’une commande en cours avec possibilité de la modifier 
-> La possibilité de choisir le moyen de paiement à la fin d’une commande
-> La possibilité de personnaliser nos plats
-> Mode portrait/paysage de notre application

Than Luong Binth
Gualtiero Mottola
Hans Thirunavukarasu
Tristan de Blauwe





