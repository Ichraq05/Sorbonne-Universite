#include <stdlib.h>
#include <stdio.h>

int compte_mots(char **tab){
    int nb_mots = 0;

    while(tab != NULL && *tab != NULL){ //On peut simplement ecrire : while(*tab){} qui est l'équivalent de "tant que le contenu pointé par le pointeur tableau n'est pas NULL"
        nb_mots ++;
        tab ++;
    }

    return nb_mots;
}

void detruit_tab_mots(char **ptab_mots){

    while (*ptab_mots){
        //printf("Libération de la mémoire pour : %s\n", *ptab_mots);
        free(*ptab_mots);
        ptab_mots ++;
    }
}   

int main(int argc, char const *argv[])
{
    int nb_mots = 10; // Remplacez 10 par le nombre de mots que vous souhaitez allouer

    char **tableau = (char **)malloc((nb_mots + 1) * sizeof(char *));

    // Vérifier que l'allocation a réussi
    if (tableau == NULL) {
        printf("Échec de l'allocation mémoire pour le tableau de pointeurs.\n");
        return 1; // Sortie avec code d'erreur
    }

    tableau[0] = "mot1";
    tableau[1] = "et";
    tableau[2] = "mot2";
    tableau[3] = "et";
    tableau[4] = "mot3";
    tableau[5] = NULL;

    printf("Le nombre de mots dans le tableau est : %d\n", compte_mots(tableau));

    //detruit_tab_mots(tableau);

    return 0;
}
