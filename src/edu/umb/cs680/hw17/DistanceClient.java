package edu.umb.cs680.hw17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DistanceClient {
    public static void main(String[] args) {
        List<Double> p1;
        List<Double> p2;
        List<Double> p3;
        List<Double> p4;
        List<Double> p5;


        p1 = Arrays.asList(2.0,3.0);
        p2 = Arrays.asList(5.0,7.0);
        p3 = Arrays.asList(7.0,9.0);
        p4 = Arrays.asList(9.0,11.0);
        p5 = Arrays.asList(11.0,13.0);

        List<List<Double>> points = new ArrayList<>();
        points.add(p1);
        points.add(p2);
        points.add(p3);
        points.add(p4);
        points.add(p5);


        // get euclidian distance
        double d1 = Distance.get(p1, p2, new Euclidean()); // returns 5
        System.out.println(d1);

        System.out.println();
        System.out.println();


        // Get Distance Matrix for Euclidian
        printDistanceMatrix(Distance.matrix(points, new Euclidean()));

        System.out.println();
        System.out.println();


        // get manhattan distance
        double d2 = Distance.get(p1, p2, (a, b) -> {
            double sum = 0;
		    int i = 0;
		    for (;i < p1.size(); i++) {
			    sum += Math.abs(a.get(i) - b.get(i));
		    }
		    return sum;
        }); // returns 7

        System.out.println(d2);

        System.out.println();
        System.out.println();


        // Get Distance Matrix for Manhattan
        printDistanceMatrix(Distance.matrix(points, (a, b) -> {
            double sum = 0;
		    int i = 0;
		    for (;i < p1.size(); i++) {
			    sum += Math.abs(a.get(i) - b.get(i));
		    }
		    return sum;
        }));

    }

    private static void printDistanceMatrix(List<List<Double>> m) {
        for (List<Double> dl : m) {
            for (Double d : dl) {
                System.out.print(d + "      ");
            }
            System.out.println();
        }
    }
}
