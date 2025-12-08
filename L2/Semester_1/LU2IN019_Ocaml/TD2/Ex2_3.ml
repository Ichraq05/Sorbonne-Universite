(*_____________________________QUESTION 1_________________________________*)

let rec is_prefix(l1 : 'a list) (l2 : 'a list) : bool = 
  match (l1,l2) with
  | ([],_) -> true  (* Si l1 est une liste vide, c'est un préfixe de n'importe quelle liste. *)
  | (_,[]) -> false  (* Si l2 est une liste vide, l1 ne peut pas être un préfixe. *)
  | (h :: t, i :: u) -> if h=i then is_prefix t u else false

let x = is_prefix [] [1;2;3];;
let x = is_prefix [1;2] [1;2;3;4;5];;
let x = is_prefix [1;2] [1;2];;
let x = is_prefix [2;3] [1;2;3];;
let x = is_prefix [1;2;3] [1;2];;


(*_____________________________QUESTION 2_________________________________*)

let rec prefixes (l : 'a list): 'a list list = 
  match l with
  | [] -> [[]]
  | h :: t -> [] :: map_cons h (prefixes (t));;


let x = prefixes [] ;;
let x = prefixes ['x'] ;;
let x = prefixes ['h'; 'o'; 'u'; 'x'] ;;
let x = prefixes ['c'; 'h'; 'o'; 'u'; 'x'] ;;


(*_____________________________QUESTION 3_________________________________*)

let all_prefix_in (l1 : 'a list) (l2 : 'a list list) : bool =
  all_in_list (prefixes l1) l2

let x = all_prefix_in [1;0;0] [[];[0];[0;1];[1];[1;0];[1;0;0];[1;1];[1;1;0];[1;1;1]] ;;
let x = all_prefix_in [1;0;0] [[];[0];[0;1];[1];[1;0;0];[1;1];[1;1;0];[1;1;1]] ;;