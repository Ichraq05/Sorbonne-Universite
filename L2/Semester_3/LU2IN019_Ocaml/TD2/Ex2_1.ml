(*_____________________________QUESTION 1_________________________________*)

let rec pgcd(n : int) (m : int) : int =
  if m = 0 then
    n
  else 
    pgcd m (n mod m)

let x = pgcd 96 36;;
let x = pgcd 36 96;;
let x = pgcd 7 19;;

(*2e Methode*)
let rec pgcd(n : int) (m : int) : int =
  let r = n mod m in 
  if r = 0 then 
    m 
  else
    pgcd m r


(*_____________________________QUESTION 2_________________________________*)

val pgcd : int -> int -> int
