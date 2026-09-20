package org.zdanek.javabasic.concurrency;

import java.util.Random;

public class Wątki {

	public static void main(String[] args) {
		
		
		//tworzy 100 wątków
		for (int i = 0; i < 1000; i++) {

			Thread t = new Thread(new Runnable() {

				@Override
				public void run() {
					Random random = new Random();
					int number = random.nextInt(6) + 1;
					System.out.println(number);
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			});
			
			t.start();
			
		}

	};

}
