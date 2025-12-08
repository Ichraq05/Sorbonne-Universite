#include <stdlib.h>
#include <stdio.h>

int compte_mots_chaine(char *chaine){
    int nb_mots = 0;
    int est_dans_mot = 0;

    for (int i = 0; chaine[i] != '\0'; i++)
    {
        if (chaine[i] == ' ' || chaine[i] == '\n'){
            est_dans_mot = 0;
        }
        else{
            if (est_dans_mot == 0){
                nb_mots ++;
                est_dans_mot = 1;
            }
        }
    }
    return nb_mots;
}

int main(int argc, char const *argv[])
{
    int taille_tab = 50;
    char *nb_char = (char *)malloc((taille_tab + 1) * sizeof(char)); // +1 pour le caractère nul

     if (nb_char == NULL) {
        printf("Échec de l'allocation de mémoire.\n");
        return 1; // Quitter le programme en cas d'échec de l'allocation.
    }

    char *source = "Je suis en L2 à la Sorbonne Université";
    int i;

    for (i = 0; i < taille_tab && source[i] != '\0'; i++) {
        nb_char[i] = source[i];
    }
    
    nb_char[i] = '\0'; // Assurez-vous de terminer correctement la chaîne.

    printf("%s\n", nb_char);

    printf("La phrase contient %d mots",compte_mots_chaine(nb_char));

    free(nb_char);

    return 0;
}
