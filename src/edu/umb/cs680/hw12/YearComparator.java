package edu.umb.cs680.hw12;

import java.util.Comparator;

public class YearComparator implements Comparator<Car>{
    public int compare(Car carOne, Car carTwo) {
		return carOne.getYear() - carTwo.getYear();
	}  
}
