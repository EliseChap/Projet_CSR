package org.inria.restlet.mta.backend; 

/**
 * Cette classe s'occupe du bac à légumes du buffet
 * 
 * @author Elise CHAPON
 * @author Maëlla GHERAIA
 *
 */
public class BuffetLegumes {
	
	private int BacLegumes = 1000;
	
	/**
	 * Cette méthode permet d'accéder au bac à légumes
	 * 
	 * @param qte
	 * @throws InterruptedException
	 */
	public synchronized void  accederBac(int qte) throws InterruptedException {	
		BacLegumes-=qte;		
	}
	
	
	/**
	 * Cette méthode réapprovisionne le bac à légumes
	 */
	public synchronized void reapprovisionner() {
		
		if(BacLegumes<100) {
			BacLegumes=1000; 
			notifyAll(); 	
		}
	}
	
	
	/**
	 * @return BacLegumes   la taille du bac à légumes
	 */
	public int  getsize() {
		return BacLegumes; 
	}
		
		
}