#include <stdio.h>

void ma_fonction(int *a, int *b, int v2) {
    // 'a' et 'b' sont ici des adresses
    // *a accède à la valeur pointée
    int val_a = *a; 
    *b = val_a + v2; // Si val_a=10, v2=20 -> *b = 30
    *a = 2 * (*b);   // *a = 60
    // Si on veut b=60 aussi, il faut changer la logique, 
    // mais la question porte sur "modifier le même emplacement mémoire".
}

int main() {
    int a = 10;
    int b; // non initialisé
    // Appel avec adresses
    ma_fonction(&a, &b, 20); 
    // ...
}