(*_____________________________QUESTION 1_________________________________*)

let rec repeat(n : int) (e : 'a) : 'a list = 
  if n = 0 then
    []
  else 
    e :: repeat (n-1)e

let x = repeat 0 'p' ;;
let x = repeat 4 'p' ;;


(*_____________________________QUESTION 2_________________________________*)

let rec all_in_list (l1 : 'a list) (l2 : 'a list) : bool =
  match l1 with 
  | [] -> true
  | h :: t -> List.mem h l2 && all_in_list t l2

let x = all_in_list [] [2; -1] ;;
let x = all_in_list [-3; 8] [2; -3; -5; 8; -1] ;;
let x = all_in_list [4; 8] [] ;;
let x = all_in_list [-3; 4; 8] [2; -3; -5; 8; -1] ;;


(*_____________________________QUESTION 3_________________________________*)

let rec range_inter (a : int) (b : int) : int list =
  if a > b then 
    []
  else 
    a :: range_inter(a+1)b

let x = range_inter 7 2;;
let x = range_inter 2 7;;
let x = range_inter 2 2;;


(*_____________________________QUESTION 4_________________________________*)

let rec map_cons (e : 'a) (l : 'a list list) : 'a list list =
  match l with 
  | [] -> []
  | h :: t -> (e :: h) :: map_cons e t
  
let x = map_cons 3 [];;
let x = map_cons 'x' [ [] ];;
let x = map_cons true [ [true; false; false]; [false; true]; [] ];;