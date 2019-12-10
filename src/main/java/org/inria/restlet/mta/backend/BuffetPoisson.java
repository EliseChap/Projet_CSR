package org.inria.restlet.mta.backend;

/**
 * Cette classe s'occupe du bac de poisson du buffet
 * 
 * @author Elise CHAPON
 * @author Maëlla GHERAIA
 */
public class BuffetPoisson {
	
	private int BacPoisson = 1000; 

	
	/**
	 * Cette méthode permet d'accéder au bac à poisson
	 * 
	 * @param qte
	 * @throws InterruptedException
	 */
	public synchronized void accederBac(int qte) throws InterruptedException {	
		BacPoisson-=qte; 
	}

	
	/**
	 * Cette méthode réapprovisionne le bac à poisson
	 */
	public synchronized void reapprovisionner() {
		
		if(BacPoisson<100) {
			BacPoisson=1000; 
			notifyAll(); 
		}
	}


	/**
	 * @return BacLegumes   la taille du bac à poisson
	 */
	public int getsize() {
		return BacPoisson; 
	}
}