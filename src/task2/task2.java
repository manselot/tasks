package task2;

import java.io.*;
import java.util.*;

public class task2 {
    public static void main(String[] args) {
        String circleFilePath = "src/task2/circle.txt";
        String pointsFilePath = "src/task2/points.txt";
        try {
            Scanner Sc = new Scanner(new File(circleFilePath));
            double centerX = Sc.nextDouble();
            double centerY = Sc.nextDouble();
            double radius = Sc.nextDouble();
            Sc.close();
            Scanner pointsScanner = new Scanner(new File(pointsFilePath));
            List<double[]> points = new ArrayList<>();
            while (pointsScanner.hasNextDouble()) {
                double x = pointsScanner.nextDouble();
                double y = pointsScanner.nextDouble();
                points.add(new double[]{x, y});
            }
            pointsScanner.close();
            for (double[] point : points) {
                double x = point[0];
                double y = point[1];
                double distance = Math.sqrt(Math.pow(x - centerX, 2) + Math.pow(y - centerY, 2));
                if (Math.abs(distance - radius) < 1e-9) {
                    System.out.println(0);
                } else if (distance < radius) {
                    System.out.println(1);
                } else {
                    System.out.println(2);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }



}