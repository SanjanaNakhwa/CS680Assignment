package edu.umb.cs680.hw14;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Collections;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

public class LambdaExpressionTest {
	
	@Test
	public void mileageAscendingSortLETest() {
		LinkedList<Car> usedCars = new LinkedList();
		Car car1 = new Car("Audi", "Q5", 50000, 2015, 5000.0f);
		Car car2 = new Car("BMW", "3", 40000, 2010, 10000.0f);
		Car car3 = new Car("Mercedes", "A", 90000, 2005, 6000.0f);
		usedCars.add(car1);
		usedCars.add(car2);
		usedCars.add(car3);
		LinkedList<Car> expected = new LinkedList<>();
		expected.add(car2);
		expected.add(car1);
		expected.add(car3);
		Collections.sort(usedCars, (o1, o2) -> Integer.compare(o1.getMileage(), o2.getMileage()));
		assertArrayEquals(expected.toArray(), usedCars.toArray());
	}

	@Test
	public void yearAscendingSortLETest() {
		LinkedList<Car> usedCars = new LinkedList<>();
		Car car1 = new Car("Audi", "Q5", 50000, 2015, 5000.0f);
		Car car2 = new Car("BMW", "3", 40000, 2010, 10000.0f);
		Car car3 = new Car("Mercedes", "A", 90000, 2005, 6000.0f);
		usedCars.add(car1);
		usedCars.add(car2);
		usedCars.add(car3);
		LinkedList<Car> expected = new LinkedList<>();
		expected.add(car3);
		expected.add(car2);
		expected.add(car1);
		Collections.sort(usedCars, (o1, o2) -> Integer.compare(o1.getYear(), o2.getYear()));
		assertArrayEquals(expected.toArray(), usedCars.toArray());
	}

	@Test
	public void priceAscendingSortLETest() {
		LinkedList<Car> usedCars = new LinkedList<>();
		Car car1 = new Car("Audi", "Q5", 50000, 2015, 5000.0f);
		Car car2 = new Car("BMW", "3", 40000, 2010, 10000.0f);
		Car car3 = new Car("Mercedes", "A", 90000, 2005, 6000.0f);
		usedCars.add(car1);
		usedCars.add(car2);
		usedCars.add(car3);
		LinkedList<Car> expected = new LinkedList<>();
		expected.add(car1);
		expected.add(car3);
		expected.add(car2);
		Collections.sort(usedCars, (o1, o2) -> Float.compare(o1.getPrice(), o2.getPrice()));
		assertArrayEquals(expected.toArray(), usedCars.toArray());
	}

	@Test
	public void denominationAscendingSortLETest() {
		LinkedList<Car> usedCars = new LinkedList<>();
		Car car1 = new Car("Audi", "Q5", 90000, 2005, 10000.0f);
		Car car2 = new Car("BMW", "3", 60000, 2010, 7000.0f);
		Car car3 = new Car("Mercedes", "A", 50000, 2015, 6000.0f);
		usedCars.add(car1);
		usedCars.add(car2);
		usedCars.add(car3);
		LinkedList<Car> expected = new LinkedList<>();
		expected.add(car3);
		expected.add(car2);
		expected.add(car1);
		car1.setDominationCount(usedCars);
		car2.setDominationCount(usedCars);
		car3.setDominationCount(usedCars);
		Collections.sort(usedCars, (o1, o2) -> Integer.compare(o1.getDominationCount(), o2.getDominationCount()));
		assertArrayEquals(expected.toArray(), usedCars.toArray());
	}

}