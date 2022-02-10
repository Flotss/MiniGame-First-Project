import static libtest.Lanceur.lancer;
import static libtest.OutilTest.assertEquals;
import libtest.*;

// ****************
// test classe Arc
// ****************

/**
 * La class TestArc
 * */
public class TestArc {

	/**
	 * @param args Argument de l'executable
	 * */
	public static void main(String[] args) {
		lancer(new TestArc(), args);
	}
	/**
	 * Quand l'arc est recharge correctement
	 */
	public void test_recharger_OK(){
		// preparation des donnees
		Arc arc = new Arc(3,5);

		// methode testee
		arc.recharger(2);

		// verifications
		assertEquals("arc doit toujours faire 3 degats", 3, arc.getDegats());
		assertEquals("arc doit avoir 7 fleches", 7, arc.getFleches());
	}

	/**
	 * Quand l'arc est recharge avec un nombre de fleches negatif
	 */
	public void test_recharger_negatif() {
		// preparation des donnees
		Arc arc = new Arc(3,5);

		// methode testee
		arc.recharger(-2);

		// verifications
		assertEquals("arc doit toujours faire 3 degats", 3, arc.getDegats());
		assertEquals("arc doit toujours avoir 5 fleches", 5, arc.getFleches());
	}


	//... autres tests de la classe Arc

	/**
	 * Lorsque le constructeur a bien été parametre
	 * */
	public void test_arc_OK() {
		Arc arc = new Arc(5,5);
		assertEquals("ordre parametres est mauvais",5,arc.getDegats());
		assertEquals("ordre parametres est mauvais",5,arc.getFleches());
	}

	/**
	 * Quand l'arc a des degats negatif
	 * */
	public void test_arc_negatifdegats() {
		Arc arc = new Arc(-1,5);
		assertEquals("ordre parametres est mauvais",0,arc.getDegats());
		assertEquals("ordre parametres est mauvais",5,arc.getFleches());
	}

	/**
	 * Quand l'arc a des fleches negatif
	 * */
	public void test_arc_negatiffleches() {
		Arc arc = new Arc(3,-1);
		assertEquals("ordre parametres est mauvais",3,arc.getDegats());
		assertEquals("ordre parametres est mauvais",0,arc.getFleches());
	}

	/**
	 * Quand l'arc a des fleches negatif et des degats negatif
	 * */
	public void test_arc_negatifdegatsetfleches(){
		Arc arc = new Arc(-1,-1);
		assertEquals("ordre parametres est mauvais",0,arc.getDegats());
		assertEquals("ordre parametres est mauvais",0,arc.getFleches());
	}


	//test pour la méthode utiliser

	/**
	 * Lorsque l'on utilise l'arc correctement
	 * */
	public void test_utiliser_OK(){
		Arc arc = new Arc(3,5);
		arc.utiliser();

		assertEquals("ordre parametres est mauvais",3,arc.getDegats());
		assertEquals("ordre parametres est mauvais",4,arc.getFleches());
	}

	/**
	 * Lorsque l'on utilise l'arc sans fleche ou avec des fleches negatif
	 * */
	public void test_utiliser_fleche0_ou_negatifs(){
		Arc arc = new Arc(3,-1);
		arc.utiliser();
		assertEquals("ordre parametres est mauvais",0,arc.utiliser());
		assertEquals("ordre parametres est mauvais",0,arc.getFleches());
	}







	/**
	 * Lorsque l'arc a des informatations normaux
	 * */
	public void test_toString_OK(){
		Arc arc = new Arc (3,4);

		assertEquals("Doit être afficher -arc(d:3,f:4)", "-arc(d:3,f:4)", arc.toString());
	}

	/**
	 * Lorsque l'arc a des informatations avec les degats negatif
	 * */
	public void test_toString_degat_negatif(){
		Arc arc = new Arc (-1,5);

		assertEquals("Doit être afficher -arc(d:0,f:0)", "-arc(d:0,f:5)", arc.toString());
	}

	/**
	 * Lorsque l'arc a des informatations avec les fleches negatif
	 * */
	public void test_toString_fleche_negatif(){
		Arc arc = new Arc (5,-1);

		assertEquals("Doit être afficher -arc(d:0,f:0)", "-arc(d:5,f:0)", arc.toString());
	}

	/**
	 * Lorsque l'arc a des informatations avec les degats et les fleche negatif
	 * */
	public void test_toString_degatfleche_negatif(){
		Arc arc = new Arc (-1,-1);

		assertEquals("Doit être afficher -arc(d:3,f:0)", "-arc(d:0,f:0)", arc.toString());
	}
}