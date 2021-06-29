package ca.mainPackage.beans;

import lombok.*;

@NoArgsConstructor
@Data

public class Car {
	
	private int id;
	private String make;
	private String carModel;
	private String colour;
	private double price;
	private int vin;
	private String dealership;
	
	private String[] dealerships = {"dealership1","dealership2","dealership3"};

	public Car(int id, String make, String carModel, String colour, double price, int vin, String dealership) {
		super();
		this.id = id;
		this.make = make;
		this.carModel = carModel;
		this.colour = colour;
		this.price = price;
		this.vin = vin;
		this.dealership = dealership;
	}
	
	

}
