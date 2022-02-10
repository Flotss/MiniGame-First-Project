/**
 * Programme pour le combat final
 * */
public class ProgCombat {

    /**
     * @param args Argument de l'Executable du programme
     * */
    public static void main(String[] args) {
        Guerrier legolas = new Guerrier("Legolas", 4);
        Guerrier orc = new Guerrier("Ugluk", 3);
        
        System.out.println("1 : Initialisation des heros"+"\n"+legolas.toString()+"\n"+orc.toString()+"\n");

        legolas.attaquer(orc);
        System.out.println("2 : Legolas attaque Ugluk sans arc"+"\n"+legolas.toString()+"\n"+orc.toString()+"\n");

        Arc arcElfique = new Arc(2,1);
        legolas.prendreArc(arcElfique);
        legolas.attaquer(orc);
        System.out.println("3 : Legolas prend l'arc Elfique et attaque Ugluk"+"\n"+legolas.toString()+"\n"+orc.toString()+"\n");

        legolas.attaquer(orc);
        System.out.println("4 : Legolas n'a plus de fleche mais essaye quand meme d'attaquer Ugluk"+"\n"+legolas.toString()+"\n"+orc.toString()+"\n");

        Arc orcArc = new Arc(5,3);
        orc.prendreArc(orcArc);
        orc.attaquer(legolas);
        System.out.println("5 : Ugluk prend son arc et attaque Legolas"+"\n"+legolas.toString()+"\n"+orc.toString()+"\n");

        Guerrier arwen = new Guerrier("Arwen", 10);
        arwen.prendreArc(arcElfique);
        System.out.println("6 : Arwen apparait et prend l'arc de Legolas"+"\n"+legolas.toString()+"\n"+orc.toString()+"\n"+arwen.toString()+"\n");

        arwen.getArc().recharger(1);
        System.out.println("7 : Arwen recharge son arc avec une fleche"+"\n"+legolas.toString()+"\n"+orc.toString()+"\n"+arwen.toString()+"\n");

        arwen.attaquer(orc);
        System.out.println("8 : Arwen attaque Ugluk"+"\n"+legolas.toString()+"\n"+orc.toString()+"\n"+arwen.toString()+"\n");

        orc.attaquer(arwen);
        System.out.println("9 : Ugluk (est blesse) attaque Arwen"+"\n"+legolas.toString()+"\n"+orc.toString()+"\n"+arwen.toString()+"\n");
        

    }
}
