package org.inria.restlet.mta.backend; 

/**
 * Cette classe s'occupe du bacs de nouilles du buffet
 * 
 * @author Elise CHAPON
 * @author Ma�lla GHERAIA
 *
 */
public class BuffetNouilles {
	
	private int BacNouilles=1000; 
	
	
	/**
	 * Cette m�thode permet d'acc�der au bac � nouilles
	 * 
	 * @param qte
	 * @throws InterruptedException
	 */
	public synchronized void accederBac(int qte) throws InterruptedException {					
		BacNouilles-=qte; 
	}

	
	/**
	 * Cette m�thode r�approvisionne le bac � nouilles
	 */
	public synchronized void reapprovisionner() {		
		if(BacNouilles<100) {
			BacNouilles=1000; 
			notifyAll(); 
		}
	}
	
	
	/**
	 * @return BacLegumes   la taille du bac � nouilles
	 */
	public int getsize() {
		return BacNouilles; 	
	}

}

