package org.inria.restlet.mta.backend; 
public class BuffetLegumes {

	private static int BacLegumes = 1000;

public synchronized static void  accederBac(int qte) throws InterruptedException {
					
		BacLegumes-=qte; 
			
}

public synchronized void reapprovisioner() {
	
	if(BacLegumes<100) {
		
		BacLegumes=1000; 
		notifyAll(); 	

	}
	

	
}

	public int getsize() {
		
		return BacLegumes; 
		
		
	}
	
	
}


