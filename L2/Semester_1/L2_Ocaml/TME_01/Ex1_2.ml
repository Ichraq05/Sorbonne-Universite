(*_____________________________QUESTION 1_________________________________*)

let rec less_divider(i : int) (n : int) : int = 
  if i = n then
    0
  else if (n mod i) = 0 && i <> n then
    i
  else 
    less_divider(i+1)n

let x = less_divider 2 19;;
let x = less_divider 5 21;;
let x = less_divider 7 21;;
let x = less_divider 9 21;;


(*_____________________________QUESTION 2_________________________________ 
less_divider : int -> int -> int
Cela signifie que less_divider est une fonction qui prend deux entiers en entrée et renvoie un entier en sortie.
*)


(*_____________________________QUESTION 3_________________________________*)

let prime(n : int) : bool =
  if n <= 1 then
    false
  else if less_divider 2 n = 0 then
    true
  else 
    false

let x = prime(1);;
let x = prime(21);;
let x = prime(19);;
let x = prime(100);;
let x = prime(7);;


(*_____________________________QUESTION 4_________________________________*)

let rec next_prime(n : int) : int =
  if prime n then 
    n
  else
    next_prime(n+1)

let x = next_prime(0);;
let x = next_prime(15);;
let x = next_prime(5);;

(*
Cette fonction terminera-t-elle toujours ?
let rec next_prime_from n =
  if prime n then
    n
  else
    next_prime_from (n + 1)

let next_prime n =
  next_prime_from (n + 1)
Dans cette version, la fonction next_prime appelle la fonction next_prime_from avec n + 1 comme point de départ.
Cette structure permet de terminer la recherche lorsqu'un nombre premier est trouvé, et évite la récursion infinie.

Mais il est important de savoir que même avec ces modifications, 
la fonction PEUT NE PAS être très efficace pour les nombres très élevés, 
car la recherche de nombres premiers peut être une tâche coûteuse en termes de temps pour les grands nombres.
*)

let rec nth_prime(n : int) : int = 
  if n = 0 then 
    2
  else 
    next_prime (nth_prime(n-1)+1)

let x = nth_prime(0);;
let x = nth_prime(1);;
let x = nth_prime(2);;
let x = nth_prime(3);;
let x = nth_prime(12);; 

