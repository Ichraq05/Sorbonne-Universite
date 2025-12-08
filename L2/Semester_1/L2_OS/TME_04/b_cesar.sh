#! /bin/bash
x=""
for i in {0..27}; do
    res=$(./cesar $i < fenetre_sur_coquillage/part1)
    x="$x$res\n"
done

echo -e "$x"