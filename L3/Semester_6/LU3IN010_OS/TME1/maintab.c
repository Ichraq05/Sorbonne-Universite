#include "tab.h"
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <sys/resource.h>

#define NMAX 1000000

void PrintMem()
{
    struct rusage usage;
    getrusage(0, &usage);
    printf("%ld \n",usage.ru_maxrss);
}

int main(int argc, char **argv)
{
    //time_t t;
    srand(time(NULL));
    printf("Memoire residente avant malloc  : ");
    PrintMem();
    int *tab = malloc(sizeof(int) * NMAX);
    printf("Memoire residente avant init tab : ");
    PrintMem();
    InitTab(tab, NMAX);
    //PrintTab(tab, NMAX);

    int sum = SumTab(tab, NMAX);
    printf("Valeur de SumTab : %d \n", sum);

    int min = 10;
    printf("Valeur min avant l'appel de MinSumTab : %d \n", min);
    MinSumTab(&min , tab, NMAX);
    printf("Valeur min apres l'appel de MinSumTab : %d \n", min);
    printf("Memoire residente apres init tab : ");
    PrintMem();
    free(tab);
    printf("Memoire residente apres free : ");
    PrintMem();

    tab = malloc(sizeof(int) * NMAX);
    printf("Memoire residente avant 2eme init tab avec free : ");
    PrintMem();
    InitTab(tab, NMAX);
    printf("Memoire residente apres 2eme init tab avec free : ");
    PrintMem();
    return 0;
}

