#include <stdlib.h>
#include <stdio.h>
#include "min_max_moy.h"

void min_max_moy(int *min, int *max, float *moy, int tab[], int taille){
    
    if (taille <= 1){
        *max = tab[0];
        *min = tab[0];
        *moy = 0.0;
    }
    int somme = 0;
    for (int i = 0; i < taille; i++){
        if (tab[i] < *min){
            *min = tab[i];
        }
        else if (tab[i] > *max){
            *max = tab[i];
        }
        somme += tab[i];
    }
    *moy = (float)somme/(float)taille;
    
}

void min_max_rec(int *min, int *max, int tab[], int taille){  

    if (taille <= 1){
        *max = tab[0];
        *min = tab[0];
    }
    else{
        min_max_rec(min, max, tab+1, taille-1);

        *min = (tab[0] < *min) ? *min = tab[0] : *min;
        *max = (tab[0] > *max) ? *max = tab[0] : *max;
    }
}

void moy_rec(float *moy, int tab[], int taille){

    if (taille == 0){
        *moy = 0.0; 
    }
    else if (taille == 1){
        *moy = (float)tab[0];
    }
    else {
        float somme = 0.0;
        moy_rec(&somme, tab+1, taille-1);

        *moy = (somme * (taille - 1) + tab[0])/taille;
    }    
}

int main(int argc, char const *argv[])
{
    int tab[] = {4, 6, 15, 5, 11, 9, 25};
    int taille = sizeof(tab)/sizeof(tab[0]);

    int min = tab[0];
    int max = tab[0];
    float moy = 0.0;

    printf ("tableau = {");
    for (int i = 0; i < taille; i++)
    {
        if (i == taille-1){
            printf("%d}\n", tab[i]);
        }
        else{
            printf ("%d, ", tab[i]);
        }
    }

    min_max_moy(&min, &max,&moy, tab, taille);

    printf("\nSANS récursivité : \n");

    printf("La valeur minimum est : %d\n", min);
    printf("La valeur max est : %d\n", max);
    printf("La moyenne du tableau est : %.2f\n\n", moy);

    min_max_rec(&min, &max, tab, taille);
    moy_rec(&moy, tab, taille);

    printf("\nAVEC récursivité : \n");

    printf("La valeur minimum est : %d\n", min);
    printf("La valeur max est : %d\n", max);
    printf("La moyenne du tableau est : %.2f\n", moy);

    
    return 0;
}
