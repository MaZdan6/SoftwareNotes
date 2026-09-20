package org.zdanek.javabasic.comparator;



import java.util.ArrayList;
import java.util.List;


public class ComparatorTest {
	

	
	
	public static void main(String[] args) {
		IO.println("compareListTest()");
		
		List<Vehicle> vehiclesMap= new ArrayList<Vehicle>();
		vehiclesMap.add(new Vehicle(1,"suzuki","freewind","650"));
		vehiclesMap.add(new Vehicle(1,"bmw","cs","650"));
		vehiclesMap.add(new Vehicle(1,"aprilia","pegaso","650"));
		vehiclesMap.add(new Vehicle(2,"honda","cbf","125"));
		vehiclesMap.add(new Vehicle(2,"yamaha","ybr","125"));
		vehiclesMap.add(new Vehicle(2,"junak","123","125"));
		IO.println("===========");
		IO.println("vehiclesMap:");
		vehiclesMap.forEach(vehicle->IO.println(vehicle.toString()));
		
		
		IO.println("===========");
		IO.println("MAP:");
		
		List<Vehicle> inputList= new ArrayList<Vehicle>();
		inputList.add(new Vehicle(2,"honda","cbf","125"));
		inputList.add(new Vehicle(2,"yamaha","ybr","125"));
		inputList.add(new Vehicle(2,"junak","123","125"));
		
		IO.println("===========");
		IO.println("inputList:");
		inputList.forEach(vehicle->IO.println(vehicle.toString()));
		
		
		
		IO.println("Comparation output:");
	}

}
