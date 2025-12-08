(*_____________________________QUESTION 1_________________________________*)

let rec at_prof (n:int) (x:'a) (t:'a btree) : bool =
  match n,t with
  |_,Empty -> false
  |0,Node(e,_,_) -> e=x
  |_,Node(_,g,d) -> (at_prof (n-1) x g) || (at_prof (n-1) x d)

let x = at_prof 0 5 t_ex;;
let x = at_prof 2 5 t_ex;;
let x = at_prof 1 5 t_ex;;

(*_____________________________QUESTION 2_________________________________*)

let rec at_prof_list (n:int) (t:'a btree) : 'a list = 
  match n,t with
  |_,Empty -> []
  |0,Node(e,_,_) -> [e]
  |_,Node(_,g,d) -> (at_prof_list (n-1) g) @ (at_prof_list (n-1) d)

let x = at_prof_list 2 t_ex;; 


(*_____________________________QUESTION 3_________________________________*)

let rec etiq_prof_list (x:'a) (t:'a btree) : int list =
  match t with
  |Empty -> []
  |Node(e,g,d) -> let li = List.map (fun x -> x + 1) ((etiq_prof_list x g) @ (etiq_prof_list x d)) in 
                  if e = x then 0 :: li
                  else li

let x = etiq_prof_list 3 t_ex;;


(*_____________________________QUESTION 4_________________________________*)

let rec prof_max (t:'a btree) : int = 
  List.length(max_length_branch t) - 1
 
let x = prof_max t_ex;;


(*_____________________________QUESTION 5_________________________________*)

let max_prof_etiq (x:'a) (t:'a btree) : int = 
  List.fold_left max (-1) (etiq_prof_list x t)
                                               
let x = max_prof_etiq 5 t_ex;;
let x = max_prof_etiq 7 t_ex;;
let x = max_prof_etiq 9 t_ex;;