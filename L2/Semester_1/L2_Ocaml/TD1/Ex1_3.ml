(*_____________________________QUESTION 1_________________________________*)

let rec sum_impairs(n : int) : int =
  if n = 0 then
    0
  else 
    (2*n - 1) + sum_impairs(n-1)

let x = sum_impairs 2;;
let x = sum_impairs 4;;

(*_____________________________QUESTION 2_________________________________*)

let rec sum_impairs_inf(n : int) : int =
  if n = 0 then
    0
  else if n mod 2 = 0 then
    sum_impairs_inf(n-1)
  else
    n + sum_impairs_inf(n-1)

let x = sum_impairs_inf 1;;
let x = sum_impairs_inf 8;;
let x = sum_impairs_inf 9;;
let x = sum_impairs_inf 20;;


(*_____________________________QUESTION 3_________________________________*)

let sum_impairs_inf (n : int) : int =
  if n <= 1 then
    0
  else if n mod 2 = 0 then
    sum_impairs (n / 2)
  else
    sum_impairs ((n - 1) / 2)

(*Cette nouvelle version de la fonction sum_impairs_inf évite les tests de parité en divisant n par 2,
  pour obtenir le nombre d'entiers impairs inférieurs à n. Si n est pair, il utilise n / 2, sinon, il utilise (n - 1) / 2.
  La division par 2 est un moyen efficace de compter le nombre d'entiers impairs.*)