package edu.umb.cs680.hw04;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarTest {
    @Test
    void verifyCarEqualityWithMakeModelYear() {
        Car expected = new Car();
        expected.setMake("Toyota");
        expected.setModel("RAV4");
        expected.setYear(2022);

        Car actual = new Car();
        actual.setMake("Toyota");
        actual.setModel("RAV4");
        actual.setYear(2022);

        assertArrayEquals(carToStringArray(expected), carToStringArray(actual) );

    }

    private String[] carToStringArray(Car c) {
        return new String[]{c.getMake(), c.getModel(), String.valueOf(c.getYear())};
    }

}
