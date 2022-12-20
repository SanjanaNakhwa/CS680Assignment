package edu.umb.cs680.hw11;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ManhattanTest {
    private static List<Double> p1, p2, p3, p4, p5;
    private static List<List<Double>> points;

    @BeforeAll
    public static void setUp() {
        p1 = Arrays.asList(2.0,3.0);
        p2 = Arrays.asList(5.0,7.0);
        p3 = Arrays.asList(7.0,9.0);
        p4 = Arrays.asList(9.0,11.0);
        p5 = Arrays.asList(11.0,13.0);
        points = new ArrayList<>();

        points.add(p1);
        points.add(p2);
        points.add(p3);
        points.add(p4);
        points.add(p5);
    }

    // get manhattan distance
    @Test
    public void getManhattanDistanceTest() {
        assertEquals(7.0, Distance.get(p1, p2, new Manhattan()));
    }

    @Test
    public void getManhattanDistanceMatrixTest() {
        List<List<Double>> expected = List.of(
            List.of(0.0, 7.0, 11.0, 15.0, 19.0),
            List.of(7.0, 0.0, 4.0, 8.0, 12.0),
            List.of(11.0, 4.0, 0.0, 4.0, 8.0),
            List.of(15.0, 8.0, 4.0, 0.0, 4.0), 
            List.of(19.0, 12.0, 8.0,4.0, 0.0));

        List<List<Double>> actual = Distance.matrix(points, new Manhattan());
        assertEquals(actual, expected);
    }
}
