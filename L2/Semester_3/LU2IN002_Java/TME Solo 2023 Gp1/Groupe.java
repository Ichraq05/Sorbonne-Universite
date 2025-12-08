public class Groupe {
    private EtreVivant []tab;
    private int nb;
    
    public Groupe(int t_max){
        this.tab = new EtreVivant(t_max);
    }

    void ajouter(EtreVivant e){
        if (nb < tab.length){
            tab[nb] = e;
            nb++;
        }
    }

    public int estPasKO(){
        int res = 0;
        for (EtreVivant x : tab){
            if (x.estPasKO()){
                res ++;
            }
        }
        return res;
    }

    public void subirDegatsGroupe(int degats){
        for (EtreVivant x : tab){
            x.getDegats(degats);
        }
    }

    public void attaqueGroupe(Groupe g){
        int somme = 0;
        for (EtreVivant x : tab){
            if (x.estPasKO){
                somme += x.getDegats();
            }
        } 
        for (Groupe y : g){
            if (g.estPasKO){
                g.subirDegatsGroupe(somme/tab.length);;
            }
        }
    }
}
