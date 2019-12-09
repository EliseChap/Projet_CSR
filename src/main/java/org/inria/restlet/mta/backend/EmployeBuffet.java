package org.inria.restlet.mta.backend;

public class EmployeBuffet extends Thread{
	
	private static BuffetLegumes l = new BuffetLegumes(); 
	private static BuffetViande v = new BuffetViande(); 
	private static BuffetPoisson p = new BuffetPoisson(); 
	private static BuffetNouilles n = new BuffetNouilles(); 

	
	public void run() {
		
		while(true) {
			
		l.reapprovisioner();
		v.reapprovisioner();
		p.reapprovisioner();
		n.reapprovisioner();
				
				
			}
			
			
		}
	


	
	public static BuffetLegumes getBuffetLegumes() {
		
		return l; 
		
		
	}
	
	
	public static BuffetViande getBuffetViande() {
		
		return v; 
		
		
	}
	
	public static BuffetPoisson getBuffetPoisson() {
	
	return p; 
	
	
	}


	public static BuffetNouilles getBuffetNouilles() {
	
	return n; 
	
	
		}
	
	


}
	




