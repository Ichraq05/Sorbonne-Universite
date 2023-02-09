#include "cini.h"

// Q2
void diagonale(int x) {
    for (int i = 0; i <= x; i++) {
        CINI_draw_pixel(i, i, "white");
    }
}

// Q3
int main() {
    CINI_open_window(400, 400, "Diagonale");
    diagonale(300);
    CINI_loop();
    return 0;
}