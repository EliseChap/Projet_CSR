package org.inria.restlet.mta.backend; 

/**
 * Cette classe s'occupe du bac de viande du buffet
 * 
 * @author Elise CHAPON
 * @author Maëlla GHERAIA
 */
public class BuffetViande {

	private int BacViande = 1000; 


	/**
	 * Cette méthode permet d'accéder au bac à viande
	 * 
	 * @param qte
	 * @throws InterruptedException
	 */
	public synchronized  void accederBac(int qte) throws InterruptedException {
		BacViande-=qte; 
	}	


	/**
	 * Cette méthode réapprovisionne le bac à viande
	 */
	public synchronized void reapprovisionner() {
		if(BacViande<100) {
			BacViande=1000; 
			notifyAll(); 
		}
	}

	
	/**
	 * @return BacLegumes   la taille du bac à viande
	 */
	public int getsize() {
		return BacViande; 
	}

}