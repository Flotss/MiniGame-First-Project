/** *-----------------*
 *   CLASS DE GUERRIER
 *  *_________________*
 */

public class Guerrier {

    /**
     * Atribut de la classe guerrier
    * Chaine de caractere nom | nom du guerrier
    * Entier pv | Point de vie
    *
    * @see Arc | Arc du guerrier
    *  */
    private String nom;
    private int pv;

    private Arc arc;



    /** Constructeur d'un guerrier par defaut avec un parametre une chaine de caractere pNom pour le nom et pv (points de vie) = 10
    * @param pNom Nom du guerrier choisi
    * */
    public Guerrier(String pNom){
        if (pNom != null && pNom != ""){
            this.nom = pNom;
            this.pv = 10;
            this.arc = null;
        }else{
            this.nom = null;
            this.pv = 10;
            this.arc = null;
        }
    }



    /** Constructeur d'un guerrier qui a deux parametre : une chaine de caractere pNom pour le nom et un entier p pour les points de vie
    * @param pNom Nom du guerrier choisi
    * @param p Nombre de point de vie du guerrier
    * */
    public Guerrier(String pNom, int p){
        if (pNom != null && pNom != "" ){
            this.nom = pNom;
            this.arc = null;
            this.pv = p;
        }else {
            this.nom = null;
            this.arc = null;
            this.pv = p;
        }
        if (p < 1){
            this.pv = 1;
        }
    }






    /** Getter des points de vie du guerrier
    * @return pv le nombre de point de vie du guerrier
    * */
    public int getPv(){
        return this.pv;
    }

    /** Getter de l'arc du guerrier
    * @return arc L'arc du guerrier
    * */
    public Arc getArc(){
        return this.arc;
    }

    /** Getter du nom du guerrier
    * @return nom Le nom du guerrier
    * */
    public String getNom(){
        return this.nom;
    }





    /** Methode pour savoir si le guerrier est blesse
    * @return Booleen qui dit si le guerrier est blesse
    * */
    public boolean etreBlesse(){
        return this.pv == 0;
    }

    /** Methode pour que le guerrier subisse des degats avec un parametre entier degats
    * @param degat Le nombre de degats que l'on met au guerrier
    * */
    public void subirDegat(int degat){
        if (degat >= 0){
            this.pv -= degat;
        }

        if(this.pv <= 0){
            this.pv = 0;
        }
    }






    /** Methode pour que le guerrier prend un arc qui a ete creer
    * @see Arc L'arc que le guerrier veux prendre
     * @param arc L'arc du guerrier
    * @return haveArc Booleen qui dit si l'arc a ete prit
    * */
    public boolean prendreArc(Arc arc){
        boolean haveArc = false;
        if (!this.etreBlesse()){
            if(this.arc == null){
                this.arc = arc;
                haveArc = true;
            }
        }
        return haveArc;
    }







    /** Methode pour poser l'arc du guerrier
     * @see Arc L'arc que l'on renvoie
    * @return Arc Renvoie de l'arc qui a ete pose au sol
    * */
    public Arc poserArc(){
        Arc arcposer = null;
        if (!this.etreBlesse()){
            if (this.arc != null){
                arcposer = this.arc;
                this.arc = null;
            }
        }
        return arcposer;
    }






    /** Methode d'un guerrier qui attaque un autre guerrier
    * @see Guerrier victime qui est le guerrier que l'on veut attaquer
     * @param victime Guerrier que l'on attaque
    * @return attaquelancee Booleen qui dit si le guerrier a bien attaquer la victime
    * */
    public boolean attaquer(Guerrier victime){
        boolean attaquelancee = false;
        if( !this.etreBlesse() && this.arc != null ){
            victime.subirDegat(this.arc.utiliser());
            attaquelancee = true;
        }
        
        if(victime.pv < 1){
            victime.pv = 0;
        }
        return attaquelancee;
    }






    /** Methode qui donne les informations sur le guerrier et son arc s'il en a un arc
    * @return infogerrier Donne les informations sur le guerrier
    * */
    public String toString(){
        String infoarc = null;
        if(this.arc != null){
            infoarc = this.arc.toString();
        }
        
        String infoguerrier = this.nom+"("+this.pv+")";
        if (infoarc != null){
            infoguerrier = infoguerrier.concat(infoarc);
        }
        return infoguerrier;
    }
}
