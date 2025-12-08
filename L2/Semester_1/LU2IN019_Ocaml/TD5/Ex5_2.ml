type 'a btree = Empty | Node of 'a * 'a btree * 'a btree

let tree1 = Node('a', Node('b',
                           Empty,
                           Node('c',Empty,Empty)),
                 Node('d',
                      Node('e',Node('f',
                                    Empty,Empty),
                           Empty),
                      Node('g',Node('h',
                                    Empty,Empty),
                           Node('i',Empty,Empty))))

(*_____________________________QUESTION 1_________________________________*)

let rec at_path (t:'a btree) (c:int list) : 'a =
  match t,c with
  |Empty,_ -> raise (Invalid_argument "at_path")
  |Node(e,_,_),[] -> e
  |Node(e,g,d),h :: t -> if h = 0 then at_path g t
                        else if h = 1 then at_path d t
                        else raise (Invalid_argument "at_path")

let x = at_path tree1 [];;
let x = at_path tree1 [1;0];;
let x = at_path tree1 [0;0];;
let x = at_path tree1 [2;0];;

(*_____________________________QUESTION 2_________________________________*)

let paths_tree (t : 'a btree) : ('a * (int list)) list =
  let rec f (t : 'a btree) : int list list =
    match t with
    |Empty -> []
    |Node (e,g,d) -> [[]] @ (map_cons 0 (f g)) @ (map_cons 1 (f d))
  in List.map (fun l -> ((at_path t l),l)) (f t)
    
let x = paths_tree tree1;;


(*_____________________________QUESTION 3_________________________________*)

let is_tree (l : (int list) list) : bool = pref_complete l
    
let x = is_tree (List.map snd (paths_tree tree1));;
let x  = is_tree [[]; [1]; [1; 0]; [1; 0; 1; 1]];;


(*_____________________________QUESTION 4_________________________________*)

(*let leaves_list (l : ('a * (int list)) list) : 'a list = List.map (fun (c,ch) -> if (is_max_pref2 ch l) then c else [] ) l*) 

let leaves_list (l : ('a * (int list)) list) : 'a list = List.map (fun (a,b) -> a) (max_pref_list2 l)


let x = leaves_list (paths_tree tree1);;

