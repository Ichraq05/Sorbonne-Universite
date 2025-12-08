#include <assert.h>
#include <signal.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <unistd.h>
#include <strings.h> // Inclusion pour usleep
#include "ecosys.h"

#define NB_PROIES 20
#define NB_PREDATEURS 20
#define ENERGIE 10

int main(void) {
    srand(time(NULL));

    // Créer une liste pour les proies et les prédateurs
    Animal *liste_proie = NULL;
    Animal *liste_predateur = NULL;
    float energie = ENERGIE;

    // Créer 20 proies et 20 prédateurs à des positions aléatoires
    for (int i = 0; i < NB_PROIES; i++) {
        int x_proie = rand() % SIZE_X;
        int y_proie = rand() % SIZE_Y;
        liste_proie = ajouter_en_tete_animal(liste_proie, creer_animal(x_proie, y_proie, energie));
    }

    for(int i = 0; i < NB_PREDATEURS; i++){
        int x_predateur = rand() % SIZE_X;
        int y_predateur = rand() % SIZE_Y;
        liste_predateur = ajouter_en_tete_animal(liste_predateur, creer_animal(x_predateur, y_predateur, energie));
    }
    printf("\n=== Test d'ajout d'animal ===\n");
    // Ajoute en plus un predateur
    ajouter_animal(2,6,energie,&liste_predateur); 

    afficher_ecosys(liste_proie, liste_predateur);

    // Supprime les 1ers proies et prédateurs de la liste
    if (liste_proie) {
        enlever_animal(&liste_proie, liste_proie); // Supprime la 1er proie
        enlever_animal(&liste_proie, liste_proie); // Supprimer la 2e proie
    }

    if (liste_predateur) {
        enlever_animal(&liste_predateur, liste_predateur); // Supprime le 1er prédateur
        enlever_animal(&liste_predateur, liste_predateur); // Supprime le 2e prédateur
    }

    // Si on veut enlever au milieu de la liste 
    /*int n= 5; // Numéro de l'animal à supprimer (dans ce cas, le 5e)

    Animal *animal_a_supp = liste_proie; // Commencez par le premier animal de la liste

    // Parcourez la liste pour atteindre le 5e animal
    for (int i = 1; i < n && animal_a_supp; i++) {
        animal_a_supp = animal_a_supp->suivant;
    }
    // Si animal_a_supprimer n'est pas NULL, cela signifie que le 5e animal a été trouvé
    if (animal_a_supp) {
        enlever_animal(&liste_proie, animal_a_supp);
    }*/


    // Vérifie le nombre de proies et de prédateurs
    unsigned int nb_proies = compte_animal_it(liste_proie);
    unsigned int nb_predateurs = compte_animal_it(liste_predateur);

    printf("Nombre de proies : %d\n", nb_proies);
    printf("Nombre de prédateurs : %d\n", nb_predateurs);

    printf("\n=== Test enlèvement animal ===\n");
    // Affiche l'état de l'écosystème
    afficher_ecosys(liste_proie, liste_predateur);

        // Écrivez l'écosystème dans un fichier
    ecrire_ecosys("ecosystem.txt", liste_predateur, liste_proie);

    // Libérez la mémoire actuelle des listes
    liste_proie = liberer_liste_animaux(liste_proie);
    liste_predateur = liberer_liste_animaux(liste_predateur);

    // Lisez l'écosystème depuis le fichier et mettez-le dans de nouvelles listes
    lire_ecosys("ecosystem.txt", &liste_predateur, &liste_proie);
    
    printf("\n=== Test après lecture===\n");
    afficher_ecosys(liste_proie, liste_predateur);

    printf("\n=== Test de reproduction ===\n");
    float p_reproduce = 1.0;
    // Test reproduce
    reproduce(&liste_predateur,p_reproduce);
    reproduce(&liste_proie,p_reproduce);
    afficher_ecosys(liste_proie,liste_predateur);

    printf("\n=== Test de déplacement ===\n");
    // Test bouger
    bouger_animaux(liste_predateur);
    bouger_animaux(liste_proie);   
    // Affiche pour vérifier
    afficher_ecosys(liste_proie,liste_predateur);

    // Libére la mémoire des listes d'animaux
    liste_proie = liberer_liste_animaux(liste_proie);
    liste_predateur = liberer_liste_animaux(liste_predateur);

    return 0;
}
