#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// Q1
int valeur_aleatoire(int min, int max) {
    return min + rand() % (max - min + 1);
}

// Q2
void pos_neg_zero(int val, int *pos, int *neg, int *zero) {
    if (val > 0) (*pos)++;
    else if (val < 0) (*neg)++;
    else (*zero)++;
}

// Q3 Main
// Appeler srand(time(NULL)) au début, puis boucle appelant valeur_aleatoire 
// et pos_neg_zero(&p, &n, &z).