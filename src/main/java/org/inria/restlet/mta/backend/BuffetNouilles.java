package org.inria.restlet.mta.backend; 

/**
 * Cette classe s'occupe du bacs de nouilles du buffet
 * 
 * @author Elise CHAPON
 * @author Maëlla GHERAIA
 *
 */
public class BuffetNouilles {
	
	private int BacNouilles=1000; 
	
	
	/**
	 * Cette méthode permet d'accéder au bac à nouilles
	 * 
	 * @param qte
	 * @throws InterruptedException
	 */
	public synchronized void accederBac(int qte) throws InterruptedException {					
		BacNouilles-=qte; 
	}

	
	/**
	 * Cette méthode réapprovisionne le bac à nouilles
	 */
	public synchronized void reapprovisionner() {		
		if(BacNouilles<100) {
			BacNouilles=1000; 
			notifyAll(); 
		}
	}
	
	
	/**
	 * @return BacLegumes   la taille du bac à nouilles
	 */
	public int getsize() {
		return BacNouilles; 	
	}

}

