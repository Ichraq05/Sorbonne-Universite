(*_____________________________QUESTION 1_________________________________*)

let rec nb_un (n : int) : int =
  if n = 0 then
    0
  else
    (n mod 2) + nb_un (n / 2)

let x = nb_un 19;;
let x = nb_un 9;;

(*_____________________________QUESTION 2_________________________________*)

let rec nb_bits (n : int) : int =
  if n = 0 then
    0
  else 
    1 + nb_bits(n/2)

let x = nb_bits 19;;
let x = nb_bits 9;;


(*_____________________________QUESTION 3_________________________________*)

let rec nb_max(n : int) : int =
    (1 lsl n) - 1

let x = nb_max 3;;
let x = nb_max 5;;

(*
(1 lsl n) : Cela effectue une opération de décalage à gauche (left shift) sur l'entier 1 de n positions. 
En d'autres termes, cela revient à élever 2 à la puissance n, car le décalage à gauche de 1 position équivaut à une mult par 2. 
Donc, (1 lsl n) équivaut à 2ⁿ.
(1 lsl n) - 1 : En soustrayant 1 de 2ⁿ, la fonction retourne le résultat 2ⁿ - 1.

La première ligne let x = nb_max 3;; calcule nb_max 3, ce qui équivaut à 2³ - 1, c'est-à-dire 8 - 1,
donc x est initialisée à la valeur 7.
*)