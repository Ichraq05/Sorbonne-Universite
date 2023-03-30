#include <stdio.h>
#include "liste_entiers.h"

// Implémentation simplifiée de creerListe pour les tests (Non demandé par l'énoncé)
cellule_t* creerListe(int taille) {
    // Crée une liste simple 1 -> 5 -> 3 -> NULL
    if (taille <= 0) return NULL;
    cellule_t *n1 = malloc(sizeof(cellule_t));
    cellule_t *n2 = malloc(sizeof(cellule_t));
    cellule_t *n3 = malloc(sizeof(cellule_t));
    n1->donnee = 1; n2->donnee = 5; n3->donnee = 3;
    n1->suivant = n2;
    n2->suivant = n3;
    n3->suivant = NULL;
    return n1;
}

// Exercice 40
void AfficherListeInt(cellule_t *liste) { 
    printf("Liste: ");
    while (liste != NULL) {
        printf("%d -> ", liste->donnee);
        liste = liste->suivant;
    }
    printf("NULL\n");
}

// Exercice 41

// Q1: Nombre d'occurrences
int nb_occurences(int val, cellule_t *liste) {
    int cpt = 0;
    while(liste) {
        if (liste->donnee == val) cpt++;
        liste = liste->suivant;
    }
    return cpt;
}

// Q2: Tous plus grand
int tous_plus_grand(int val, cellule_t *liste) {
    while(liste) {
        if (liste->donnee < val) return 0; // Faux dès qu'on trouve un plus petit
        liste = liste->suivant;
    }
    return 1; // Tous les éléments vérifiés sont >= val
}

// Q3: Maximum (retourne le pointeur vers l'élément)
cellule_t* Maximum(cellule_t *liste) {
    if (!liste) return NULL;
    cellule_t *max_el = liste;
    while(liste) {
        if (liste->donnee > max_el->donnee) {
            max_el = liste;
        }
        liste = liste->suivant;
    }
    return max_el;
}

// Q4: Valeur à une position donnée
int Renvoyer_val_element_pos(int pos, cellule_t *liste) {
    int current_pos = 0;
    while(liste) {
        if (current_pos == pos) return liste->donnee;
        liste = liste->suivant;
        current_pos++;
    }
    return -1; 
}