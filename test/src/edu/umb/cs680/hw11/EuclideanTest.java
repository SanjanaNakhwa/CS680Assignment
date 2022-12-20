package edu.umb.cs680.hw11;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class EuclideanTest {
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
    public void getEuclideanDistanceTest() {
        assertEquals(5.0, Distance.get(p1, p2, new Euclidean()));
    }

    @Test
    public void getEuclideanDistanceMatrixTest() {
        List<List<Double>> expected = List.of(
            List.of(0.0, 5.0, 7.810249675906654, 10.63014581273465, 13.45362404707371),
            List.of(5.0, 0.0, 2.8284271247461903, 5.656854249492381, 8.48528137423857),
            List.of(7.810249675906654, 2.8284271247461903, 0.0, 2.8284271247461903, 5.656854249492381),
            List.of(10.63014581273465, 5.656854249492381, 2.8284271247461903, 0.0, 2.8284271247461903), 
            List.of(13.45362404707371, 8.48528137423857, 5.656854249492381,2.8284271247461903, 0.0));

        List<List<Double>> actual = Distance.matrix(points, new Euclidean());
        assertEquals(actual, expected);
    }   
}
