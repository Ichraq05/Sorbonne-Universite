#include <ctype.h>
#include <string.h>

// Q2 (Renvoie nouvelle chaine)
char* filtre(char *src) {
    char *dest = malloc(strlen(src) + 1);
    int j = 0;
    for (int i = 0; src[i] != '\0'; i++) {
        if (isalpha(src[i])) {
            dest[j++] = src[i];
        }
    }
    dest[j] = '\0';
    return dest;
}

// Q3 (Sur place)
void filtre_place(char *src) {
    int j = 0;
    for (int i = 0; src[i] != '\0'; i++) {
        if (isalpha(src[i])) {
            src[j++] = src[i];
        }
    }
    src[j] = '\0';
}