package edu.umb.cs680.hw12;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ParetoComparatorTest {
    private static Car car1;
	private static Car car2;
	private static Car car3;
	private static LinkedList<Car> usedCars;
	
	@BeforeAll
	static void setUp() {
		usedCars = new LinkedList<>();
		car1 = new Car("Audi", "Q5", 90000, 2005, 10000.0f);
		car2 = new Car("BMW", "3", 60000, 2010, 7000.0f);
		car3 = new Car("Mercedes", "A", 50000, 2015, 6000.0f);
		usedCars.add(car1);
		usedCars.add(car2);
		usedCars.add(car3);
	}

    @Test
	public void dominationCountTestWithCar1Test() {
		int expected = 2;
		car1.setDominationCount(usedCars);
		int actual = car1.getDominationCount();
		assertEquals(expected, actual);
	}
	
	@Test
	public void dominationCountTestWithCar2Test() {
		int expected = 1;
		car2.setDominationCount(usedCars);
		int actual = car2.getDominationCount();
		assertEquals(expected, actual);
	}
	
	@Test
	public void dominationCountTestWithCar3Test() {
		int expected = 0;
		car3.setDominationCount(usedCars);
		int actual = car3.getDominationCount();
		assertEquals(expected, actual);
	}

	@Test
	public void dominationCountAscendingSortTest() {
		LinkedList<Car> expected = new LinkedList<>();
		expected.add(car3);
		expected.add(car2);
		expected.add(car1);
		car1.setDominationCount(usedCars);
		car2.setDominationCount(usedCars);
		car3.setDominationCount(usedCars);
		Collections.sort(usedCars, new ParetoComparator());
		assertArrayEquals(expected.toArray(), usedCars.toArray());
	} 
}
