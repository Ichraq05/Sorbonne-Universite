type 'a btree = Empty | Node of 'a * 'a btree * 'a btree

(*_____________________________QUESTION 1_________________________________*)

let rec lt_btree (t:'a btree) (x:'a) : bool = 
  match t with
  |Empty -> true
  |Node(e,g,d) -> if e > x then false 
                  else (lt_btree g x) && (lt_btree d x)

let x = lt_btree (Node (2, Node (4, Empty, Empty), Empty)) 5;;
let x = lt_btree (Node (4, Node (6, Empty, Empty), Empty)) 5;;
let x = lt_btree Empty 5;;


(*_____________________________QUESTION 2_________________________________*)

let rec ge_btree (t:'a btree) (x:'a) : bool =
  match t with
  |Empty -> true 
  |Node(e,g,d) -> if e < x then false
                  else (ge_btree g x) && (ge_btree d x)


let x = ge_btree (Node (4, Node (5, Empty, Empty), Empty)) 4;;
let x = ge_btree (Node (4, Node (3, Empty, Empty), Empty)) 4;;
let x = ge_btree Empty 5;;


(*_____________________________QUESTION 3_________________________________*)

let rec is_abr (bt:'a btree) : bool =
  match bt with
  |Empty -> true
  |Node(e,g,d) -> ( (lt_btree g e) && (ge_btree d e) ) && ( (is_abr g) && (is_abr d) )


let x = is_abr Empty;;
let x = is_abr (Node (5, Node (2, Node (1, Empty, Empty),
                               Node (4, Empty, Empty)),
                      Node (6, Empty, Node (7, Empty, Empty))));;
let x = is_abr (Node (5, Node (2, Node (1, Empty, Empty),
                               Node (4, Empty, Empty)),
                      Node (3, Empty, Node (7, Empty, Empty))));;
let x = is_abr (Node (5, Node (2, Node (1, Empty, Empty),
                               Node (4, Empty, Empty)),
                      Node (7, Empty, Node (6, Empty, Empty))));;



