#include <stdlib.h>
#include <stdio.h>

int main(int argc, char *argv[])
{
    if(argc < 2)
    {
        printf("Erreur : il n'y a personne a saluer.\n");
        printf("Usage : %s <noms>\n", argv[0]);
        exit (-1);
    }

    for (int i = 1; i < argc; i++)
    {
        printf("%s : Bonjour !\n", argv[i]);
    }

    return 0;
}