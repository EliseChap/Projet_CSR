package org.inria.restlet.mta.backend; 

/**
 * Cette classe s'occupe du bac de viande du buffet
 * 
 * @author Elise CHAPON
 * @author Ma�lla GHERAIA
 */
public class BuffetViande {

	private int BacViande = 1000; 


	/**
	 * Cette m�thode permet d'acc�der au bac � viande
	 * 
	 * @param qte
	 * @throws InterruptedException
	 */
	public synchronized  void accederBac(int qte) throws InterruptedException {
		BacViande-=qte; 
	}	


	/**
	 * Cette m�thode r�approvisionne le bac � viande
	 */
	public synchronized void reapprovisionner() {
		if(BacViande<100) {
			BacViande=1000; 
			notifyAll(); 
		}
	}

	
	/**
	 * @return BacLegumes   la taille du bac � viande
	 */
	public int getsize() {
		return BacViande; 
	}

}