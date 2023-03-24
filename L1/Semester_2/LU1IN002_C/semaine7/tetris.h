#ifndef TETRIS_H
#define TETRIS_H

#include <stdlib.h>

#define HAUTEUR 22
#define LARGEUR 10
#define VIDE -1
#define NB_PIECES 7

// Ex 37: Structures
struct une_case {
    int colonne;
    int ligne;
};

struct piece {
    int pos_ligne, pos_colonne; 
    struct une_case la_piece[4];
    int type; 
};

// Prototypes clés
void init_plateau(int plateau[HAUTEUR][LARGEUR]);
int descendre(int plateau[HAUTEUR][LARGEUR], struct piece *p);
void decaler_gauche(int plateau[HAUTEUR][LARGEUR], struct piece *p);
void rotation_droite(int plateau[HAUTEUR][LARGEUR], struct piece *p);

#endif // TETRIS_H