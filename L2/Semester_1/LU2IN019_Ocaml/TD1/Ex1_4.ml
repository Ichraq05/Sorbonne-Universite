(*_____________________________QUESTION 1_________________________________*)

let rec u_n(n : int) : int = 
  if n = 0 then
    2
  else 
    3*(u_n(n-1)) + 4

let x = u_n 0;;
let x = u_n 3;;


(*_____________________________QUESTION 2_________________________________*)

let rec sum_un(n : int) : int = 
  if n = 0 then
    0
  else 
    u_n (n-1) + sum_un(n-1)

let x = sum_un 1;;
let x = sum_un 3;;
let x = sum_un 4;;