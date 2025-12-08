#include <assert.h>
#include <signal.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <unistd.h>
#include <strings.h> // Inclusion pour usleep
#include "ecosys.h"



#define NB_PROIES 20
#define NB_PREDATEURS 20 // On peut s'amsuer à modifier les coordonnée pour voir le comportement de l'écosysteme
#define MAX_ITERATIONS 200
#define T_WAIT 40000 // Temps de pause en microsecondes (40 ms)

int main(void) {
    srand(time(NULL));
    //srand(1);

    // Créer une liste pour les proies
    Animal *liste_proie = NULL;
    Animal *liste_predateur = NULL;


    // Créer 20 proies à des positions aléatoires
    for (int i = 0; i < NB_PROIES; i++) {
        int x_proie = rand() % SIZE_X;
        int y_proie = rand() % SIZE_Y;
        int energie_proie = 10; // Énergie initiale des proies
        liste_proie = ajouter_en_tete_animal(liste_proie, creer_animal(x_proie, y_proie, energie_proie));
    }

    for (int i = 0; i < NB_PREDATEURS; i++) {
        int x_pred = rand() % SIZE_X;
        int y_pred = rand() % SIZE_Y;
        int energie_pred = 10; // Énergie initiale des proies
        liste_predateur = ajouter_en_tete_animal(liste_predateur, creer_animal(x_pred, y_pred, energie_pred));
    }


    // Boucle qui va stopper quand il n'y a plus de proies ou que le nombre maximal d'itérations est atteint
    int iteration = 0;
    int monde[SIZE_X][SIZE_Y] = {0};  // Initialise le tableau monde avec des zéros

    while ((liste_proie != NULL || liste_predateur != NULL) && iteration < MAX_ITERATIONS) {
        
        // Mettre à jour le monde (repousse de l'herbe)
        rafraichir_monde(monde); // Pour avoir 0 proie et predateur, mettre rafraichir_monde en commentaire

        // Mettre à jour les proies
        rafraichir_proies(&liste_proie, monde);

        // Mettre à jour les prédateurs avec la liste des proies
        rafraichir_predateurs(&liste_predateur, &liste_proie);

        // Affiche l'état de l'écosystème
        printf("=== Écosystème après l'itération %d ===\n", iteration);

        afficher_ecosys(liste_proie, liste_predateur);

        // Pause pour voir l'état de l'écosystème
        usleep(T_WAIT);

        iteration++;
    }

    // Libére la mémoire des proies restantes
    liberer_liste_animaux(liste_proie);
    liberer_liste_animaux(liste_predateur);

    return 0;
}


/* A completer. Part 2:
   * exercice 4, questions 2 et 4 
   * exercice 6, question 2
   * exercice 7, question 3
   * exercice 8, question 1
   */