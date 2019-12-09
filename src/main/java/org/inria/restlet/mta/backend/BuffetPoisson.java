package org.inria.restlet.mta.backend; 
public class BuffetPoisson {
	
	private static int BacPoisson = 1000; 

	
public synchronized static void accederBac(int qte) throws InterruptedException {
		
				
		BacPoisson-=qte; 
			
		}

public synchronized void reapprovisioner() {
	
	if(BacPoisson<100) {
		
		BacPoisson=1000; 
		notifyAll(); 
		
	}
	
	
}


public int getsize() {
	
	return BacPoisson; 
	
	
}
}