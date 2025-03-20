#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <assert.h>

#define TAILLE 255

int main(int argc, char **argv) {

    char cmde[TAILLE];
    char cmde_cpt[TAILLE];
    int bloquant;
    char **arguments;
    char *ss_chaine;
    int i, cpt;

    while (1) {

        printf("\n\nTapez une commande : ('quit' pour quitter, taille max autorisée : %d)\n\n", TAILLE - 2);
        if (fgets(cmde, TAILLE - 1, stdin) == NULL) {
            fprintf(stderr, "Erreur lors de la lecture de la commande\n");
            return EXIT_FAILURE;
        }

        cmde[strlen(cmde) - 1] = 0;
        printf("Commande tapée : %s\n\n", cmde);

        if ((strcmp(cmde, "quit") == 0)) {
            break;
        }
            
        strcpy(cmde_cpt, cmde);
        ss_chaine = strtok(cmde_cpt, " ");
        cpt = 0;

        while (ss_chaine != NULL) {

            if (strcmp(ss_chaine, "&") == 0) {
                break;
            }

            ss_chaine = strtok(NULL, " ");
            cpt++;
        }

        arguments = malloc(sizeof(char *) * cpt);
        assert(arguments);

        ss_chaine = strtok(cmde, " ");
        i = 0;
        bloquant = 1;

        while (ss_chaine != NULL) {

            if (strcmp(ss_chaine, "&") == 0) {
                bloquant = 0;
                break;
            }

            assert(i < cpt);
            arguments[i] = strdup(ss_chaine);
            assert(arguments[i]);

            ss_chaine = strtok(NULL, " ");
            i++;
        }

        if (fork() == 0) {
            execv(arguments[0], arguments);
            fprintf(stderr, "Erreur lors du execl");
        }

        for (i=0; i<cpt; i++) {
            free(arguments[i]);
        }

        free(arguments);

        if (bloquant) {
            wait(NULL);
        }
    }

    return EXIT_SUCCESS;
}