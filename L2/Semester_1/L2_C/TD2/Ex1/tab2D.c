#include <stdlib.h>
#include <stdio.h>
#define DIM1 5
#define DIM2 6

void InitTab(char **tab, int dim1, int dim2);

int main(void)
{
    char **tab2D = (char **)malloc(DIM1 * sizeof(char *));
    for (int i = 0; i < DIM1; i++){
        tab2D[i] = (char **)malloc(DIM2 * sizeof(char *));
    }

    InitTab(tab2D, DIM1, DIM2);

    for (int i = 0; i < DIM1; i++){
        free(tab2D[i]);
    }

    free(tab2D);

    return 0;
}

void InitTab(char **tab, int dim1, int dim2){
    for (int i = 0; i < DIM1; i++){
        for (int j = 0; j < DIM2; j++){
            tab[i][j] = 0; // Remplit chaque élément du tableau avec 0
        }
    }
}

