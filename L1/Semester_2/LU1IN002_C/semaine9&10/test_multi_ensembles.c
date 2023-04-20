#include <stdio.h>
#include <stdlib.h>
#include "multi_ensembles.h"

int main() {
    element_t *e_non_trie = NULL;
    element_t *e_trie1 = NULL;
    element_t *e_trie2 = NULL;
    element_t *intersection = NULL;
    
    printf("================================\n");
    printf("TME 9/10: Multi-Ensembles\n");
    printf("================================\n");

    // Ex 43 Q2
    e_non_trie = Ajout_tete_ensemble(e_non_trie, 5, 2);
    e_non_trie = Ajout_tete_ensemble(e_non_trie, 1, 3);
    e_non_trie = Ajout_tete_ensemble(e_non_trie, 5, 1); // Freq de 5 devient 3
    printf("E non trié (Attendu: 1 (3), 5 (3)): ");
    AfficherMultiEnsemble(e_non_trie);

    // Ex 44 Q1
    e_non_trie = Supprime_total_element_ensemble(e_non_trie, 1);
    printf("Apres suppression de 1: ");
    AfficherMultiEnsemble(e_non_trie);

    // Ex 45 Q1: Ajout trié
    e_trie1 = Ajout_ensemble_trie(e_trie1, 10, 1);
    e_trie1 = Ajout_ensemble_trie(e_trie1, 5, 3);
    e_trie1 = Ajout_ensemble_trie(e_trie1, 15, 2);
    printf("E trié 1 (Attendu: 5, 10, 15): ");
    AfficherMultiEnsemble(e_trie1);

    // Ex 46 Q1
    e_trie2 = Ajout_ensemble_trie(e_trie2, 5, 3);
    e_trie2 = Ajout_ensemble_trie(e_trie2, 12, 1);
    printf("E trié 2: ");
    AfficherMultiEnsemble(e_trie2);
    printf("E2 inclus dans E1? %d (Attendu 0)\n", Inclus(e_trie2, e_trie1));

    // Ex 47 Q1
    printf("Taille de E1: %d\n", taille(e_trie1));

    // Ex 48 Q6
    intersection = Intersection_triee(e_trie1, e_trie2);
    printf("Intersection (Attendu: 5 (3)): ");
    AfficherMultiEnsemble(intersection);
    
    return 0;
}