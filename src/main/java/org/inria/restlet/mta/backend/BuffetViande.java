package org.inria.restlet.mta.backend; 
public class BuffetViande {

	private static int BacViande = 1000; 
	
	public synchronized static void accederBac(int qte) throws InterruptedException {

		
		BacViande-=qte; 
	

}
	
	public synchronized void reapprovisioner() {
		
		if(BacViande<100) {
			
			BacViande=1000; 
			notifyAll(); 
			
		}
		
		
	}
	
	public int getsize() {
		
		return BacViande; 
		
		
	}

	}

