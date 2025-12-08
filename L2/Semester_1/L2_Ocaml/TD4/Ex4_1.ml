(*_____________________________QUESTION 1_________________________________*)

type 'a btree = Empty | Node of 'a * 'a btree * 'a btree
let t_ex = Node(5,Node(3,
                       Node(4,Empty,Empty),
                       Node(5,Empty,Empty)),
                Node(2,
                     Node(3,
                          Empty,
                          Node(7,Empty,Empty)),
                     Empty));;                      

let rec size (t:'a btree) : int =
  match t with
  |Empty -> 0
  |Node (_,g,d) -> 1 + (size g) + (size d)
                             
let x = size Empty;;
let x = size t_ex;;