(*_____________________________QUESTION 1_________________________________*)

let double (x : int) : int =
  2*x

let x = double 4;;
let x = double 10;;


(*_____________________________QUESTION 2_________________________________*)

let somme_2double(x : int) : int =
  double x + (double(double x))

let x = somme_2double 4;;
let x = somme_2double 10;;

let somme_2double(x : int) : int =
   2*(x+(double x))

let x = somme_2double 4;;
let x = somme_2double 10;;


(*_____________________________QUESTION 3_________________________________*)

let make_event(x : int) : int =
  if x mod 2 = 0 then
    x
  else
    2*x

let x = make_event 6;;
let x = make_event 5;;