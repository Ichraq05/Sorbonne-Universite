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
#define MAX_ITERATIONS 200
#define T_WAIT 40000 // Temps de pause en microsecondes (40 ms)

/* A completer. Part 2:
* exercice 6, question 2
*/

int main(void) {
    srand(time(NULL));

    // Créer une liste pour les proies
    Animal *liste_proie = NULL;

    // Créer 20 proies à des positions aléatoires
    for (int i = 0; i < NB_PROIES; i++) {
        int x_proie = rand() % SIZE_X;
        int y_proie = rand() % SIZE_Y;
        int energie_proie = 10; // Énergie initiale des proies
        liste_proie = ajouter_en_tete_animal(liste_proie, creer_animal(x_proie, y_proie, energie_proie));
    }

    // Boucle qui stop quand il n'y a plus de proies ou que le nombre maximal d'itérations est atteint
    int iteration = 0;

    while (liste_proie != NULL && iteration < MAX_ITERATIONS) {
        // Met à jour les proies
        rafraichir_proies(&liste_proie, NULL);

        // Affiche l'état de l'écosystème
        printf("=== Écosystème après l'itération %d ===\n", iteration);
        afficher_ecosys(liste_proie, NULL);

        // Pause pour voir l'état de l'écosystème
        usleep(T_WAIT);

        iteration++;
    }

    // Libére la mémoire des proies restantes
    liberer_liste_animaux(liste_proie);

    return 0;
}


/* A completer. Part 2:
   * exercice 4, questions 2 et 4 
   * exercice 6, question 2
   * exercice 7, question 3
   * exercice 8, question 1
   */