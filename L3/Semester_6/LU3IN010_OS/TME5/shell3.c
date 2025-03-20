#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/types.h>
#include <time.h>
#include <sys/resource.h>
#include <sys/wait.h>
#include <assert.h>

#define TAILLE 255

// Cette version propose une implémentation de la commande 'times'

int main(int argc, char **argv) {

    char cmde[TAILLE];
    char cmde_cpt[TAILLE];
    int bloquant;
    char **arguments;
    char *ss_chaine;
    int i, cpt, first_arg;
    struct rusage r;

    while (1) {

        printf("\n\nTapez une commande : ('quit' pour quitter, taille max autorisée : %d)\n\n", TAILLE - 2);
        if (fgets(cmde, TAILLE-1, stdin) == NULL) {
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

        first_arg = 0;
        if (strcmp(arguments[0], "times") == 0) {

            first_arg = 1;
            free(arguments[0]);

            for (i=0; i<cpt-1; i++) {
                arguments[i] = arguments[i+1];
            }
            arguments[i] = NULL;

            for (i=0; i<cpt-1; i++) {
                printf("arguments[%d] = %s ", i, arguments[i]);
            }
            printf("\n");
        }

        if (fork() == 0) {
            execv(arguments[0], arguments);
            fprintf(stderr, "Erreur lors du execl");
        }

        for (i=0; i<cpt-first_arg; i++) {
                free(arguments[i]);
            }

        free(arguments);

        if (bloquant) {
            wait3(NULL, 0, &r);

            if (first_arg) {
                printf("Time user : %f\n", r.ru_utime.tv_sec + 1E-6*r.ru_utime.tv_usec);
                printf("Time systeme : %f\n", r.ru_stime.tv_sec + 1E-6*r.ru_stime.tv_usec);
            }
        }
    }

    return EXIT_SUCCESS;
}