#include <stdio.h>
int alternative(int n1, int n2, int n3) {
    int res ;
    if (n1 > 8) {
        res = 3;
    } else {
        if (n3 == 20) {
        res = 2;
        } else {
        if ((n2 >= 10) && (n3 >= 10)) {
            res = 1;
            } else {
                res = 0;
            }   
        }
    }
    return res;
    }


int main() {
    // Cas res = 3 (n1 > 8)
    printf("Test 1 (attendu 3): %d\n", alternative(9, 0, 0));
    // Cas res = 2 (n1 <= 8 et n3 == 20)
    printf("Test 2 (attendu 2): %d\n", alternative(5, 0, 20));
    // Cas res = 1 (n1 <= 8, n3 != 20, n2 >= 10, n3 >= 10)
    printf("Test 3 (attendu 1): %d\n", alternative(5, 10, 10));
    // Cas res = 0 (autres cas)
    printf("Test 4 (attendu 0): %d\n", alternative(5, 9, 5));
    return 0;
}