#include <stdlib.h>
#include <stdio.h>
#include "min_max_moy.h"


void min_max_moy(int *min, int *max, float *moy, int tab[], int taille){}

int main(int argc, char const *argv[])
{
    for (int n = 1; n <= 100; n++){
        int tab[n];
        int min, max;
        float moy, moy_attendu;

        for (int i = 0; i < n; i++){
            tab[i] = i + 1;
        }

        min_max_moy (&min, &max, &moy, tab, n);

        moy_attendu = (float)(n+1)/2;

        if (min == 1 && max == n && moy == moy_attendu) {
            printf("Test pour taille %d : Réussi\n", n);
        } else {
            printf("Test pour taille %d : Échoué\n", n);
        }
    }
    return 0;
}

