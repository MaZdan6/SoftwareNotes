package org.zdanek.javabasic.comparator;


public class Vehicle {

	public Vehicle(int type, String manufacturer, String model, String engine) {
		this.type = type;
		this.manufacturer = manufacturer;
		this.model = model;
		this.engine = engine;
	}

	private int type;
	private String manufacturer;
	private String model;
	private String engine;

	@Override
	public String toString() {
		return "Vehicle{" +
				"type=" + type +
				", manufacturer='" + manufacturer + '\'' +
				", model='" + model + '\'' +
				", engine='" + engine + '\'' +
				'}';
	}
}