package org.inria.restlet.mta.backend;

/**
 * Cette classe s'occupe du processus employeBuffet
 * 
 * @author Elise CHAPON
 * @author Maëlla GHERAIA
 */
public class EmployeBuffet extends Thread{

	private static BuffetLegumes l = new BuffetLegumes(); 
	private static BuffetViande v = new BuffetViande(); 
	private static BuffetPoisson p = new BuffetPoisson(); 
	private static BuffetNouilles n = new BuffetNouilles(); 

	/**
	 * Cette méthode réapprovisionne les bacs du buffet
	 */
	public void run() {
		while(true) {
			l.reapprovisionner();
			v.reapprovisionner();
			p.reapprovisionner();
			n.reapprovisionner();
		}
	}

	
	/**
	 * @return l  le buffet de légumes
	 */
	public static BuffetLegumes getBuffetLegumes() {
		return l; 
	}

	
	/**
	 * @return v  le buffet de viandes
	 */
	public static BuffetViande getBuffetViande() {
		return v; 
	}

	
	/**
	 * @return p  le buffet de poissons
	 */
	public static BuffetPoisson getBuffetPoisson() {
		return p; 
	}


	/**
	 * @return n  le buffet de nouilles
	 */
	public static BuffetNouilles getBuffetNouilles() {
		return n; 
	}
}