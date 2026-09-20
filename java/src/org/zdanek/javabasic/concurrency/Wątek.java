package org.zdanek.javabasic.concurrency;

import javax.swing.*;
import java.util.Date;

public class Wątek {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Timer t = new Timer(1000, event ->
        System.out.println("Jest godzina " + new Date()));
     t.start();   
        
     // utrzymuje program w działaniu, aż użytkownik kliknie przycisk Ok
     JOptionPane.showMessageDialog(null, "Quit program?");
     System.exit(0);
	}

}
