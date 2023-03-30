#include <stdio.h>
#include <stdlib.h> // Pour malloc/free si on complète creerListe
#include "liste_entiers.h"

int main() {
    cellule_t *ma_liste = creerListe(3); 
    
    printf("================================\n");
    printf("TME 8: Test de la librairie\n");
    printf("================================\n");
    
    // Ex 40
    AfficherListeInt(ma_liste);

    // Ex 41 Q1
    printf("Occurrences de 5: %d\n", nb_occurences(5, ma_liste));

    // Ex 41 Q2
    printf("Tous >= 0? %d (Attendu 1)\n", tous_plus_grand(0, ma_liste));

    // Ex 41 Q3
    cellule_t *max_ptr = Maximum(ma_liste);
    if (max_ptr) printf("Maximum trouvé: %d\n", max_ptr->donnee);

    // Ex 41 Q4
    printf("Valeur à la position 1: %d\n", Renvoyer_val_element_pos(1, ma_liste));
    
    return 0;
}

//gcc -Wall -o test_liste test_liste.c liste_entiers.c