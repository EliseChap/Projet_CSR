package org.inria.restlet.mta.backend; 

/**
 * Cette classe s'occupe du bac � l�gumes du buffet
 * 
 * @author Elise CHAPON
 * @author Ma�lla GHERAIA
 *
 */
public class BuffetLegumes {
	
	private static int BacLegumes = 1000;
	
	/**
	 * Cette m�thode permet d'acc�der au bac � l�gumes
	 * 
	 * @param qte
	 * @throws InterruptedException
	 */
	public synchronized static void  accederBac(int qte) throws InterruptedException {
			BacLegumes-=qte; 
	}
	
	
	/**
	 * Cette m�thode r�approvisionne le bac � l�gumes
	 */
	public synchronized void reapprovisionner() {
		
		if(BacLegumes<100) {
			BacLegumes=1000; 
			notifyAll(); 	
		}
	}
	
	
	/**
	 * @return BacLegumes   la taille du bac � l�gumes
	 */
	public int getsize() {
		return BacLegumes; 
	}
		
		
}