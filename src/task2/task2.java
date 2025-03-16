package task2;

import java.io.*;
import java.util.*;

public class task2 {
    public static void main(String[] args) {



        String circleFilePath = "src/task2/circle.txt";
        String pointsFilePath = "src/task2/points.txt";
        try {
            // Считываем данные из первого файла (центр окружности и радиус)
            Scanner circleScanner = new Scanner(new File(circleFilePath));
            double centerX = circleScanner.nextDouble();
            double centerY = circleScanner.nextDouble();
            double radius = circleScanner.nextDouble();
            circleScanner.close();

            // Считываем данные из второго файла (координаты точек)
            Scanner pointsScanner = new Scanner(new File(pointsFilePath));
            List<double[]> points = new ArrayList<>();

            while (pointsScanner.hasNextDouble()) {
                double x = pointsScanner.nextDouble();
                double y = pointsScanner.nextDouble();
                points.add(new double[]{x, y});
            }
            pointsScanner.close();

            // Вычисляем положение каждой точки относительно окружности
            for (double[] point : points) {
                double x = point[0];
                double y = point[1];

                // Вычисляем расстояние от точки до центра окружности
                double distance = Math.sqrt(Math.pow(x - centerX, 2) + Math.pow(y - centerY, 2));

                // Определяем положение точки
                if (Math.abs(distance - radius) < 1e-9) { // Точка на окружности
                    System.out.println(0);
                } else if (distance < radius) { // Точка внутри
                    System.out.println(1);
                } else { // Точка снаружи
                    System.out.println(2);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: файл не найден.");
        } catch (InputMismatchException e) {
            System.out.println("Ошибка: неверный формат данных в файле.");
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }
}