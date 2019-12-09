package org.inria.restlet.mta.backend; 

public class BuffetNouilles {
	
	private static int BacNouilles=1000; 
	
public synchronized static void accederBac(int qte) throws InterruptedException {
		
					
		BacNouilles-=qte; 

}

public synchronized void reapprovisioner() {
	
	if(BacNouilles<100) {
		
		BacNouilles=1000; 
		notifyAll(); 
		
	}
	
	
}

public int getsize() {
	
	return BacNouilles; 
	
	
}

}

