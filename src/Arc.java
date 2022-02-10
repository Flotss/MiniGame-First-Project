/** ***************
*   CLASS DE L'ARC
*  ****************
*/


public class Arc{
    /**
     * Atribut de la classe Arc
     * Entier degats | degats de l'arc
     * Entier fleches | Nombre de fleches dans le carquois
     *  */

    private int degats, fleches;

    /**
     * Constructeur d'un arc par defaut avec degats = 5 et fleches = 3
     * */

    public Arc(){
        this.degats = 5;
        this.fleches = 3;
    }



    /** Constructeur d'un arc avec deux parametre entier dg pour degats et fl pour fleches
    * @param dg Degat de l'arc
    * @param fl Nombre de fleches de l'arc
    * */

    public Arc(int dg, int fl){
        if (dg > 0 || fl > 0){
            this.degats = dg;
            this.fleches = fl;
        }

        if (dg < 0){
            this.degats = 0;
        }
        if (fl < 0){
            this.fleches = 0;
        }

    }







    /** Getter de degats
    * @return degats Nombre de degats de l'arc
    * */
    public int getDegats(){
        return this.degats;
    }

    /** Getter de fleches
    * @return fleches Nombre de fleche de l'arc
    * */
    public int getFleches(){
        return this.fleches;
    }






    /** Methode pour recharger des fleches dans le carquois avec un parametre entier nFleches qui sera le nombre de fleches que l'on recharge
     * @param nFleches Le nombre de fleches que l'on veut recharger
     * */
    public void recharger(int nFleches){
        if (nFleches > 0){
            this.fleches += nFleches;
        }
    }






    /** Methode pour utiliser l'arc qui renvoi le nombre de degats en reduisant les fleches de un
     * @return degats Le nombre de degats
     * */
    public int utiliser(){
        int degats = this.degats;
        if (this.fleches > 0){
            this.fleches -= 1;
        }else{
            this.fleches = 0;
            degats = 0;
        }
        return degats;
        
    }






    /** Methode pour revoyer les informations d'un arc
     * @return Les informations d'un arc
     * */
    public String toString(){
        return "-arc(d:"+this.degats+",f:"+this.fleches+")";
    }
}