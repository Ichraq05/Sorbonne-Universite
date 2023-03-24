#include <stdio.h>
#include <stdlib.h>
#include <string.h>
// #include <cini.h> // Dépendance graphique
#include "tetris.h" 

// Tableau des couleurs et des coordonnées relatives (Ex 37 Q1)
char *colors[NB_PIECES] = {"light salmon", "fuchsia", "lime green",
                           "white", "yellow", "cyan", "grey"};

struct piece tab_pieces[NB_PIECES] = {
    {0, 0, {{0, 0}, {0, 1}, {1, 0}, {1, 1}}, 0}, // O
    {0, 0, {{0, 0}, {0, 1}, {0, 2}, {0, 3}}, 1}, // I
    {0, 0, {{0, 0}, {0, 1}, {0, 2}, {1, 2}}, 2}, // L
    {0, 0, {{0, 0}, {0, 1}, {0, 2}, {-1, 2}}, 3}, // J
    {0, 0, {{0, 0}, {1, 0}, {1, 1}, {2, 1}}, 4}, // Z
    {0, 0, {{1, 0}, {2, 0}, {0, 1}, {1, 1}}, 5}, // S
    {0, 0, {{0, 0}, {1, 0}, {2, 0}, {1, 1}}, 6}  // T
};

// Ex 38 Q1: Initialisation du plateau
void init_plateau(int plateau[HAUTEUR][LARGEUR]) {
    for(int i=0; i<HAUTEUR; i++)
        for(int j=0; j<LARGEUR; j++)
            plateau[i][j] = VIDE;
}

// Ex 38 Q5: Descendre d'un cran
int descendre(int plateau[HAUTEUR][LARGEUR], struct piece *p) {
    // Vérification de la possibilité de descente (omise)
    if (p->pos_ligne + 1 < HAUTEUR) {
        p->pos_ligne++;
        return 1;
    } 
    // Sinon: enregistrement de la pièce sur le plateau
    return 0; 
}

// Ex 38 Q6: Décaler à gauche
void decaler_gauche(int plateau[HAUTEUR][LARGEUR], struct piece *p) {
    // Vérification de la possibilité de mouvement (omise)
    p->pos_colonne--;
}

// Ex 38 Q7: Rotation droite (x' = -y, y' = x)
void rotation_droite(int plateau[HAUTEUR][LARGEUR], struct piece *p) {
    for(int i = 0; i < 4; i++) {
        int old_x = p->la_piece[i].colonne;
        int old_y = p->la_piece[i].ligne;
        p->la_piece[i].colonne = -old_y;
        p->la_piece[i].ligne = old_x;
    }
}