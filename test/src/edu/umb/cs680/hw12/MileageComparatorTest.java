package edu.umb.cs680.hw12;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.Test;

public class MileageComparatorTest {
    @Test
	public void mileageAscendingSortTest() {
		ArrayList<Car> usedCars = new ArrayList<>();
		Car car1 = new Car("Audi", "Q5", 50000, 2015, 5000.0f);
		Car car2 = new Car("BMW", "3", 40000, 2010, 10000.0f);
		Car car3 = new Car("Mercedes", "A", 90000, 2005, 6000.0f);
		usedCars.add(car1);
		usedCars.add(car2);
		usedCars.add(car3);
		ArrayList<Car> expected = new ArrayList<>();
		expected.add(car2);
		expected.add(car1);
		expected.add(car3);
		Collections.sort(usedCars, new MileageComparator());
		assertArrayEquals(expected.toArray(), usedCars.toArray());
	}
}
