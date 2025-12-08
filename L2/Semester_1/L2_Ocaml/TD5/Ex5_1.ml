(*_____________________________QUESTION 1_________________________________*)

let pref_complete (l : ('a list) list) : bool = 
  List.for_all (fun x -> all_prefix_in x l ) l


(*_____________________________QUESTION 2_________________________________*)

let is_max_pref2 (l1 : 'b list) (l2 : ('a * ('b list)) list) : bool = List.for_all (fun (x,c) -> if (is_prefix l1 c) then (l1=c) else true) l2
    
let x = (is_max_pref2 [0;1]
           [('a',[]);('b',[0]);('c',[0;1]);('d',[1]);('e',[1; 0]);
            ('f',[1;0;0]);('g',[1;1]);('h',[1;1;0]);('i',[1;1;1])]);;
let x =(is_max_pref2 [1;0]
          [('a',[]);('b',[0]);('c',[0;1]);('d',[1]);('e',[1; 0]);
           ('f',[1;0;0]);('g',[1;1]);('h',[1;1;0]);('i',[1;1;1])]);;


(*_____________________________QUESTION 3_________________________________*)

let max_pref_list2 (l : ('a * ('b list)) list) : ('a * ('b list)) list = List.filter (fun (x,c) -> is_max_pref2 c l) l
    
let x = (max_pref_list2
           [('a',[]);('b',[0]);('c',[0;1]);('d',[1]);('e',[1; 0]);
            ('f',[1;0;0]);('g',[1;1]);('h',[1;1;0]);('i',[1;1;1])]);;

