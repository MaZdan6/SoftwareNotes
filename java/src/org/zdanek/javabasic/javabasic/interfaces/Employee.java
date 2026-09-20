package org.zdanek.javabasic.javabasic.interfaces;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee implements Comparable<Employee>, Cloneable
{
   private String name;
   private double salary;
   private Date hireDay;

   public Employee(String n, double s)
   {
      name = n;
      salary = s;
      hireDay = new Date();
   }

   public String getName()
   {
      return name;
   }

   public double getSalary()
   {
      return salary;
   }

   public void raiseSalary(double byPercent)
   {
      double raise = salary * byPercent / 100;
      salary += raise;
   }

   /**
    * Por�wnuje pracownik�w wed�ug wysoko�ci pensji.
    * @param other inny obiekt klasy Employee
    * @return warto�� ujemna, je�li pracownik ma ni�sz� pensj� ni� inny (other) pracownik,
    * 0, je�li pensje s� r�wne, liczba dodatnia w przeciwnym razie
    */
   public int compareTo(Employee other)
   {
      return Double.compare(salary, other.salary);
   }
   
   /**
    * Ustawia datę zatrudnienia na podany dzień.
    * @param year rok zatrudnienia
    * @param month miesiąc zatrudnienia
    * @param day dzień zatrudnienia
    */
   public void setHireDay(int year, int month, int day)
   {
      Date newHireDay = new GregorianCalendar(year, month - 1, day).getTime();
      // Przykład zmiany pola obiektowego.
      hireDay.setTime(newHireDay.getTime());
   }
   public String toString()
   {
      return "Employee[name=" + name + ",salary=" + salary + ",hireDay=" + hireDay + "]";
   }
   
   public Employee clone() throws CloneNotSupportedException
   {
      // Wywołanie metody Object.clone().
      Employee cloned = (Employee) super.clone();

      // Klonowanie pól zmienialnych.
      cloned.hireDay = (Date) hireDay.clone();

      return cloned;
   }
}