package org.zdanek.javabasic.concurrency;

public class SynchronizowanaMetoda {

	public static void main(String[] args) {	
		synchronizowanaMetoda();
	}
	
	public static synchronized void  synchronizowanaMetoda() {
		System.out.println("synchronizowana Metoda");
	}

}
