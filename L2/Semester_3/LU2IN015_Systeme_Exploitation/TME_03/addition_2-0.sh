#!/bin/bash
somme=0

while true; do
    read -p "Saisissez un nombre ou 'q' pour quitter : " valeur

    if [ "$valeur" = "q" ]; then
        break  
    fi

    if [[ "$valeur" =~ ^[0-9]+$ ]]; then
        somme=$((somme + valeur))
        echo "Vous avez ajouté $valeur à la somme"
    else
        echo "Ce n'est pas un nombre valide."
    fi
done

echo "La somme totale est : $somme"
