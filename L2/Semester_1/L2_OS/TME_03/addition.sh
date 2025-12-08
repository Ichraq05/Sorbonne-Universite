#!/bin/bash
read maVariable

while true; do
echo "Saisissez un nombre ou 'q' pour quitter : "

    if read $maVariable = "q"; then
        break
    fi

    old="$old $maVariable"

    echo "Vous avez ajouté $maVariable à la somme"
done

./additon $old

