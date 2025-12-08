(*_____________________________QUESTION 1_________________________________*)

let rec sum_chiffres(n : int) : int =
  if n = 0 then
    0
  else 
    (n mod 10) + sum_chiffres(n/10) 

let x = sum_chiffres 125 ;;


(*_____________________________QUESTION 2_________________________________*)

let rec nb_chiffres(n : int) : int =
  if n = 0 then
    0
  else 
    1 + nb_chiffres(n/10) 

let x = nb_chiffres 125 ;;