#include <stdlib.h>
#include <stdio.h>
#include <sys/time.h>
#include <sys/times.h>
#include <unistd.h>

void lance_commande(char *commande){
    if (system((const char *)commande) == -1){
        fprintf(stderr, "Erreur: la commande '%s' n'a pas pu être exécutée correctement\n", commande);
    }
}

int main(int argc, char **argv){
    if (argc < 1){
        fprintf(stderr, "Erreur: au moins un argument\n");
        return EXIT_FAILURE;
    }

    for (int i=1; i<argc; i++){
        lance_commande(argv[i]);
    }

    return 0;
}