(*_____________________________QUESTION 1_________________________________*)

let rec max_length_branch (t:'a btree): 'a list =
  match t with
  |Empty -> []
  |Node (e,g,d) -> if (List.length (e::max_length_branch g)) >= (List.length (e::max_length_branch d)) then
        e::max_length_branch g else e::max_length_branch d
                                     
let x = max_length_branch t_ex;;



(*_____________________________QUESTION 2_________________________________*)

let rec max_length_branch2 (t:'a btree): 'a list =
  let rec f (t:'a btree) : 'a list * int =
    match t with
    |Empty -> ([],0)
    |Node (e,g,d) -> let (l1,n1) = (f g) and (l2,n2) = (f d) in
        if n1 >= n2 then (e::l1,n1+1) else (e::l2,n2+1) in
  let (li,len) = f t in li
                                     
let x = max_length_branch2 t_ex;;