#include <stdlib.h>
#include <stdio.h>

int main(int argc, char *argv[])
{
    int res = 0;
    if(argc < 3)
    {
        printf("Erreur : il n'y a pas (ou asseez) de valeur.\n");
        printf("Usage : %s <entier>\n", argv[0]);
        exit(-1);
    }

    for (int i = 1; i < argc; i++)
    {
        res += atoi(argv[i]);
    }

    printf("La somme vaut: %d\n", res);

    return 0;
}