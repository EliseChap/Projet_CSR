package org.inria.restlet.mta.backend;

/**
 * Cette classe s'occupe du bac de poisson du buffet
 * 
 * @author Elise CHAPON
 * @author Ma�lla GHERAIA
 */
public class BuffetPoisson {
	
	private int BacPoisson = 1000; 

	
	/**
	 * Cette m�thode permet d'acc�der au bac � poisson
	 * 
	 * @param qte
	 * @throws InterruptedException
	 */
	public synchronized void accederBac(int qte) throws InterruptedException {	
		BacPoisson-=qte; 
	}

	
	/**
	 * Cette m�thode r�approvisionne le bac � poisson
	 */
	public synchronized void reapprovisionner() {
		
		if(BacPoisson<100) {
			BacPoisson=1000; 
			notifyAll(); 
		}
	}


	/**
	 * @return BacLegumes   la taille du bac � poisson
	 */
	public int getsize() {
		return BacPoisson; 
	}
}