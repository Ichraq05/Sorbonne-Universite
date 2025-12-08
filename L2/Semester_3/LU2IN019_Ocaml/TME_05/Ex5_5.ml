type 'a htree =
  | Leaf of int * 'a
  | Branch of int * 'a htree * 'a htree

                
let t_msg = Branch(17,
                   Leaf(8,'A'),
                   Branch(9,
                          Branch(4,
                                 Branch(2,
                                        Leaf(1,'C'),
                                        Leaf(1,'G')),
                                 Branch(2,
                                        Leaf(1,'H'),
                                        Leaf(1,'F'))),
                          Branch(5,
                                 Branch(2,
                                        Leaf(1,'E'),
                                        Leaf(1,'D')),
                                 Leaf(3,'B'))))

(*_____________________________QUESTION 1_________________________________*)

let rec huff_tab (t:'a htree) : ('a * (int list)) list = 
  match t with
  |Leaf(_,c) -> [(c,[])]
  |Branch(e,g,d) -> ( List.map(fun (c,l)-> (c,0::l)) (huff_tab g) ) @ ( List.map(fun (c,l)-> (c,1::l)) (huff_tab d) )

let x = huff_tab t_msg;;

(*_____________________________QUESTION 2_________________________________*)

let rec code (m : 'a list) (c : ('a * (int list)) list) : int list = 
  match m with
  |[] -> []
  |h::t -> (List.assoc h c) @ (code t c)


let lc_msg = huff_tab t_msg in let msg = ['A';'A';'B';'A';'C';'B';'A';'G';'H';'A';'A';'F';'E';'A';'D';'B';'A'] in 
code msg lc_msg;;


(*_____________________________QUESTION 3_________________________________*)




(*_____________________________QUESTION 4_________________________________*)




(*_____________________________QUESTION 5_________________________________*)




(*_____________________________QUESTION 6_________________________________*)



