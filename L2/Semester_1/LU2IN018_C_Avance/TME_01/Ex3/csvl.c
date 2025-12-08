#include <stdlib.h>
#include <stdio.h>
#include <string.h>

int compte_mots_chaine(char *chaine){

    /*Fonction déjà ecrite dans TD1, Ex2, Q.2*/

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

int compte_mots(char *tableau[]) {

    /*Une autre verion de cette fonction est ecrite dans TD1, Ex2, Q.2*/

    int mots = 0; // le compteur de mots à zéro

    for (int i = 0; tableau[i] != NULL; i++) { 
        mots++; 
    }

    return mots; 
}

void affiche_tab_mots(char **chaine){

    for (int i = 0; chaine[i] != NULL; i++)
    {
        if (chaine[i+1] == NULL){
            printf("%s",chaine[i]);
        }
        else{
            printf("%s, ", chaine[i]);
        }
    }
}

char *compose_chaine(char **ptab_mots) {
    // Déterminer la longueur totale requise pour la chaîne recomposée
    int longueur_totale = 0;
    int nb_mots = 0;
    
    for (int i = 0; ptab_mots[i] != NULL; i++) {
        longueur_totale += strlen(ptab_mots[i]); // Ajouter la longueur du mot
        nb_mots++;
    }
    
    // Ajouter de l'espace pour les espaces entre les mots et le caractère nul final
    longueur_totale += nb_mots - 1; // Un espace entre chaque mot

    // Allouer de la mémoire pour la chaîne recomposée
    char *chaine_recomposee = (char *)malloc(longueur_totale + 1); // +1 pour le caractère nul

    if (chaine_recomposee == NULL) {
        // Gestion de l'erreur d'allocation mémoire
        return NULL;
    }

    int position = 0; // Position actuelle dans la chaîne recomposée

    for (int i = 0; ptab_mots[i] != NULL; i++) {
        // Copier le mot dans la chaîne recomposée
        strcpy(chaine_recomposee + position, ptab_mots[i]);
        position += strlen(ptab_mots[i]);

        // Si ce n'est pas le dernier mot, ajouter un espace
        if (ptab_mots[i + 1] != NULL) {
            chaine_recomposee[position] = ' ';
            position++;
        }
    }

    // Ajouter le caractère nul final
    chaine_recomposee[longueur_totale] = '\0';

    return chaine_recomposee;
}

int main(int argc, char const *argv[])
{
    char *ch = "La chose la plus triste, est lorsque la personne qui a donné les meilleurs souvenirs devient elle même un souvenir.";
    printf("Dans la chaine suivante : %s\nIl y a %d mot(s).\n\n", ch, compte_mots_chaine(ch));

    char *tableauMots[] = {"mot1", "et", "mot2", "et", "mot3", NULL};

    printf("Les mots dans le tableau sont : ");
    printf("{");
    affiche_tab_mots(tableauMots);
    printf("}");

    printf("\nNombre de mot(s) dans le tableau : %d\n", compte_mots(tableauMots));

    char *tabMots_2[] = {"Ce", "ne", "sont", "pas", "les", "gens", "qui", "changent,", "ce", "sont", "juste", "les", "masques", "qui", "tombent.", NULL};

    printf("\nLe tableau contients les mots : ");
    printf("{");
    affiche_tab_mots(tabMots_2);
    printf("}\n");

    char *chaine_recomposee = compose_chaine(tabMots_2);

    if (chaine_recomposee != NULL) {
        printf("Chaîne recomposée : %s\n", chaine_recomposee);
        free(chaine_recomposee); // N'oubliez pas de libérer la mémoire allouée
    } else {
        printf("Erreur d'allocation mémoire.\n");
    }

    return 0;
}
