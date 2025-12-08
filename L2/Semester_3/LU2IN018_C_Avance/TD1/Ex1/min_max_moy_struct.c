#include <stdlib.h>
#include <stdio.h>

typedef struct Min_Max_Moy Min_Max_Moy;
struct Min_Max_Moy
{
    int max;
    int min;
    float moy;
};

Min_Max_Moy min_max_moy(int tab[], int taille){
    Min_Max_Moy res;

    if (taille <= 0){
        res.max = 0;
        res.min = 0;
        res.moy = 0.0;
        return res;
    }

    res.min = tab[0];
    res.max = tab[0];
    float somme = 0.0;

    for(int i = 0; i < taille; i++){
        if (tab[i] < res.min){
            res.min = tab[i];
        }
        if (tab[i] > res.max){
            res.max = tab[i];
        }
        somme += tab[i];
    }

    res.moy = somme / taille;

    return res;
}

Min_Max_Moy min_max_moy_rec(int tab[], int taille){
    Min_Max_Moy res_rec;

    res_rec.min = tab[0];
    res_rec.max = tab[0];
    float somme = 0.0;
    
    if (taille <= 0){
        res_rec.max = 0;
        res_rec.min = 0;
        res_rec.moy = 0.0;
        return res_rec;
    }

    //Flemme de finir la fonction, 2e version disponible dans le repertoire...
}
   

int main(int argc, char const *argv[])
{
    int tableau[] = {5, 10, 3, 8, 15, 2};
    int taille = sizeof(tableau)/sizeof(tableau[0]);

    printf ("tableau = {");
    for (int i = 0; i < taille; i++)
    {
        if (i == taille-1){
            printf("%d}\n", tableau[i]);
        }
        else{
            printf ("%d, ", tableau[i]);
        }
    }

    Min_Max_Moy result = min_max_moy(tableau, taille);

    printf ("\nLa valeur minimum est : %d\nLa valeur maximum est : %d\nLa moyenne du tableau est : %.2f",result.min, result.max, result.moy);

    return 0;
}

