#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

#define TAILLE 255

int main(int argc, char **argv) {

    char cmde[TAILLE];
    char tmp[TAILLE+2];
    int i;

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

        for (i=0; i<strlen(cmde); i++) {
            if (cmde[i] == ' ' || i >= strlen(cmde)) {
                break;
            }
            tmp[i] = cmde[i];
        }
        
        tmp[i] = 0;

        if (fork() == 0) {
            execl(tmp, tmp, NULL);
            fprintf(stderr, "Erreur lors du execl");
        }

        if (strchr(cmde, '&') == NULL) {
            wait(NULL);
        }
    }

    return EXIT_SUCCESS;
}