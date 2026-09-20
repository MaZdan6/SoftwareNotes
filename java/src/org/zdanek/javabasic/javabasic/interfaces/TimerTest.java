package org.zdanek.javabasic.javabasic.interfaces;

/**
   @version 1.01 2015-05-12
   @author Cay Horstmann
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
// import maj�cy zapobiec konfliktowi z java.util.Timer

public class TimerTest
{  
   public static void main(String[] args)
   {  
      ActionListener listener = new TimePrinter();

      // Konstrukcja zegara wywo�uj�cego obiekt nas�uchuj�cy
      // co dziesi�� sekund.
      Timer t = new Timer(10000, listener);
      t.start();

      JOptionPane.showMessageDialog(null, "Zamknij program?");
      System.exit(0);
   }
}

class TimePrinter implements ActionListener
{  
   public void actionPerformed(ActionEvent event)
   {  
      System.out.println("Kiedy usłyszysz dźwięk, będzie godzina " + new Date());
      Toolkit.getDefaultToolkit().beep();
   }
}
