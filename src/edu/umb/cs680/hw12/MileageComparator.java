package edu.umb.cs680.hw12;

import java.util.Comparator;

public class MileageComparator implements Comparator<Car>{
	
	public int compare(Car carOne, Car carTwo) {
		return carOne.getMileage() - carTwo.getMileage();
	}

}