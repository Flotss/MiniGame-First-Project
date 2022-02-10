import static libtest.Lanceur.lancer;
import static libtest.OutilTest.assertEquals;
import libtest.*;

/**
 * classe de test qui permet de verifier que la classe Arc
 * fonctionne correctement
 */
public class TestGuerrier {

	/**
	 * methode de lancement des tests
	 * @param args Argument de pour le main
	 */
	public static void main(String[] args) {
		lancer(new TestGuerrier(), args);
	}

	/**
	 *
	 *  Test des methodes de guerrier
	 */
	@Test
	public void test_guerrier_methodes() {
		Guerrier guerrier = new Guerrier("Toto",10);
		int pv = guerrier.getPv();
		Arc arc = guerrier.getArc();
		String nom = guerrier.getNom();

		assertEquals("Les pv devrait etre 10", 10, guerrier.getPv());
		assertEquals("L'arc doit etre null",null, guerrier.getArc());
		assertEquals("Le nom du guerrier doit etre Toto", "Toto", guerrier.getNom());

		boolean b = guerrier.etreBlesse();
		guerrier.subirDegat(1);


		assertEquals("Le guerrier ne doit pas etre blesser", false, guerrier.etreBlesse());
		assertEquals("Le guerrier doit avoir perdu un point de vie", 9, guerrier.getPv());

		Arc arcN =new Arc();
		boolean resPrendre = guerrier.prendreArc(arcN);

		assertEquals("Les dégats de l'arc doit etre 5", 5, guerrier.getArc().getDegats());
		assertEquals("Les dégats de l'arc doit etre 3", 3, guerrier.getArc().getFleches());
		assertEquals("Le guerrier ne doit pas avoir d'arc", true, resPrendre);


		Arc resPoser = guerrier.poserArc();

		assertEquals("Le guerrier ne doit pas avoir d'arc", null, guerrier.getArc());


		Guerrier victime = new Guerrier("vict");
		boolean resAttaque = guerrier.attaquer(victime);

		assertEquals("La victime doit avoir ete attaquer", false, resAttaque);


		String guerrierS = guerrier.toString();

	}


	//test pour la méthode guerrier
	/**
	 * Lorsque guerrier est bien parametre
	 *
	 * */
	public void test_guerrier_OK(){
		Guerrier guerrier = new Guerrier("Toto",10);
		Arc arc = new Arc(5,5);
		guerrier.prendreArc(arc);
		assertEquals("Il doit avoir un arc",arc,guerrier.getArc());
		assertEquals("Il doit avoir un nom","Toto",guerrier.getNom());
		assertEquals("Il doit avoir 10 points de vie",10,guerrier.getPv());
	}

	/**
	 * Lorsque guerrier est parametrer avec des points de vie negatifs
	 * */
	public void test_guerrier_pvnegatifs(){
		Guerrier guerrier = new Guerrier("Toto",-1);
		assertEquals("Il doit avoir 10 points de vie",1,guerrier.getPv());
	}

	/**
	 * Lorsque guerrier a un nom null
	 * */
	public void test_guerrier_nom_null(){
		Guerrier guerrier = new Guerrier(null,10);
		assertEquals("Il doit ne pas avoir de nom",null,guerrier.getNom());
	}

	/**
	 * Lorsque guerrier n'a pas de nom
	 * */
	public void test_guerrier_sans_nom(){
		Guerrier guerrier = new Guerrier("",10);
		assertEquals("Il doit ne pas avoir de nom",null,guerrier.getNom());
	}


	/**
	 * Lorsque guerrier a un nom null et a des pont de vie negatif
	 * */
	public void test_guerrier_null_et_negatif(){
		Guerrier guerrier = new Guerrier(null,-1);
		assertEquals("Il doit avoir 10 points de vie",1,guerrier.getPv());
		assertEquals("Il doit ne pas avoir de nom",null,guerrier.getNom());
	}







	//test pour la méthode etreBlesse
	/**
	 * Lorsque le guerrier n'est pas blesse
	 * */
	public void test_etre_blesse_non(){
		Guerrier guerrier = new Guerrier("Toto",10);
		assertEquals("Il doit ne pas etre blesser",false,guerrier.etreBlesse());
	}

	/**
	 * Lorsque guerrier est blesse
	 * */
	public void test_etre_blesse_oui(){
		Guerrier guerrier = new Guerrier("Toto",10);
		guerrier.subirDegat(10);
		assertEquals("Il doit ne pas etre blesser",true,guerrier.etreBlesse());

		Guerrier guerrier1 = new Guerrier("Titi",10);
		guerrier1.subirDegat(12);
		assertEquals("Il doit ne pas etre blesser",true,guerrier1.etreBlesse());
	}

	/**
	 * Lorsque que le guerrier subit des degats correctement
	 * */
	public void test_subirdegat_OK(){
		Guerrier guerrier = new Guerrier("Toto",10);
		guerrier.subirDegat(5);
		assertEquals("Il doit ne pas etre blesser",5,guerrier.getPv());
	}

	/**
	 * Lorsque le guerrier subit des degats negatifs
	 * */
	public void test_subirdegat_negatif(){
		Guerrier guerrier = new Guerrier("Toto",10);
		guerrier.subirDegat(-3);
		assertEquals("Il doit ne pas etre blesser",10,guerrier.getPv());
	}

	/**
	 * Lorsque le guerrier subit des degats et devient blesse
	 * */
	public void test_subirdegat_blesse(){
		Guerrier guerrier = new Guerrier("Toto",10);
		guerrier.subirDegat(11);
		assertEquals("Il doit ne pas etre blesser",0,guerrier.getPv());
		assertEquals("Il doit ne pas etre blesser",true,guerrier.etreBlesse());
	}







	//test pour la méthode prendreArc
	/**
	 * Lorsque le guerrier prend un arc correctement
	 * */
	public void test_prendre_arc_OK(){
		Guerrier guerrier = new Guerrier("Toto",10);
		Arc arc = new Arc(5,5);
		guerrier.prendreArc(arc);
		assertEquals("Il doit avoir un arc",arc,guerrier.getArc());
		assertEquals("Il doit avoir 5 de degats",5,guerrier.getArc().getDegats());
		assertEquals("Il doit avoir 5 fleches",5,guerrier.getArc().getFleches());
	}

	/**
	 * Lorsque le guerrier prend un arc mais qu'il a deja un arc
	 * */
	public void test_prendre_arc_dejaarc(){
		Guerrier guerrier = new Guerrier("Toto",10);
		Arc arc = new Arc(5,5);
		Arc arc2 = new Arc(3,5);
		guerrier.prendreArc(arc);
		guerrier.prendreArc(arc2);
		assertEquals("Il doit avoir un arc",arc,guerrier.getArc());
		assertEquals("Il doit avoir 5 de degats",arc.getDegats(),guerrier.getArc().getDegats());
		assertEquals("Il doit avoir 5 fleches",arc.getFleches(),guerrier.getArc().getFleches());
	}


	
	
	
	
	
	
	
	//test de la méthode poserArc
	/**
	 * Lorsque le guerrier pose son arc
	 * */
	public void test_poser_arc_OK(){
		Guerrier guerrier = new Guerrier("Toto",10);
		Arc arc = new Arc(5,5);
		guerrier.prendreArc(arc);
		assertEquals("Il doit avoir un arc",arc,guerrier.getArc());

		guerrier.poserArc();
		assertEquals("Il ne doit plus avoir un arc",null,guerrier.getArc());
	}

	/**
	 * Lorsque le guerrier pose son arc mais qu'il n'a pas d'arc
	 * */
	public void test_poser_arc_sans_arc(){
		Guerrier guerrier = new Guerrier("Toto",10);
		guerrier.poserArc();
		assertEquals("Il doit avoir un arc",null,guerrier.getArc());
		
	}



	


	
	//test de la méthode attaquer
	/**
	 * Lorsque le guerrier attaque correctement
	 * */
	public void test_attaquer_OK(){
		Guerrier guerrier = new Guerrier("Toto",10);
		Guerrier victime = new Guerrier("Jean", 10);
		Arc arc = new Arc(5,5);
		guerrier.prendreArc(arc);
		guerrier.attaquer(victime);
		assertEquals("Il doit avoir un arc",(5),victime.getPv());
		assertEquals("Il doit avoir 5 de degats",arc.getDegats(),guerrier.getArc().getDegats());
		assertEquals("Il doit avoir 4 fleches",4,guerrier.getArc().getFleches());
	}

	/**
	 * Lorsque le guerrier attaque sans avoir d'arc
	 * */
	public void test_attaquer_sans_arc(){
		Guerrier guerrier = new Guerrier("Toto",10);
		Guerrier victime = new Guerrier("Jean", 10);
		guerrier.attaquer(victime);
		assertEquals("Il doit avoir un arc",10,victime.getPv());
	}

	/**
	 * Lorsque le guerrier attaque avec un arc qui n'a pas de degats
	 * */
	public void test_attaquer_arc_0degat(){
		Guerrier guerrier = new Guerrier("Toto",10);
		Guerrier victime = new Guerrier("Jean", 10);
		Arc arc = new Arc(0,5);
		guerrier.prendreArc(arc);
		assertEquals("Il doit avoir un arc",10,victime.getPv());
		assertEquals("Il doit avoir 5 de degats",0,guerrier.getArc().getDegats());
		assertEquals("Il doit avoir 5 fleches",5,guerrier.getArc().getFleches());
	}


	/**
	 * Lorsque le guerrier est bien initialiser
	 * */
	public void test_ToString_OK(){
		Guerrier guerrier = new Guerrier("Toto",10);
		Arc arc = new Arc();
		guerrier.prendreArc(arc);
		assertEquals("Il doit avoir 5 de degats","Toto(10)-arc(d:5,f:3)",guerrier.toString());
	}

	/**
	 * Lorsque le guerrier n'a pas d'arc
	 */

	public void test_ToString_sansarc(){
		Guerrier guerrier = new Guerrier("Toto",10);
		assertEquals("Il doit avoir 5 de degats","Toto(10)",guerrier.toString());
	}

}
