#ifndef LISTE_ENTIERS_H
#define LISTE_ENTIERS_H

#include <stdlib.h> // Nécessaire pour NULL

// Définition de la structure de base pour TME 8
typedef struct _cellule_t_s8 cellule_t;
struct _cellule_t_s8 {
    int donnee;
    cellule_t *suivant;
};

// Prototype de fonction générique de création de liste 
// (doit être implémenté dans liste_entiers.c)
cellule_t* creerListe(int taille);

// Exercice 40 : Affichage
void AfficherListeInt(cellule_t *liste);

// Exercice 41 : Fonctions de parcours
int nb_occurences(int val, cellule_t *liste);
int tous_plus_grand(int val, cellule_t *liste);
cellule_t* Maximum(cellule_t *liste);
int Renvoyer_val_element_pos(int pos, cellule_t *liste);


#endif // LISTE_ENTIERS_H