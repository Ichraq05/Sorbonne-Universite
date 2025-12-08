/*Un processus "zombie" est un processus qui n'a plus de père. Plus precisement un processus dont le père s'est terminé avant celui-ci et qui ne l'a pas attendu avec un wait*/

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>


int main(int argc, char **argv) {

    printf("Je suis le processus père : %d\n", getpid());
    for (int i = 0; i<2; i++) {
        if (fork() == 0) {
            printf("Nouveau processus %d fils de %d\n", getpid(), getppid());
            sleep(10);
            break;
        }
    }
    sleep(2); // Le temps d'affichage des fils
    printf("Je suis le processus %d et mon père est %d\n", getpid(), getppid());
}