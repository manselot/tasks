package task4;

import java.io.*;
import java.util.*;

public class task4 {
    public static void main(String[] args) {


        String filePath = "src/task4/input.txt";

        try {
            // Считываем данные из файла
            List<Integer> nums = new ArrayList<>();
            Scanner scanner = new Scanner(new File(filePath));

            while (scanner.hasNextInt()) {
                nums.add(scanner.nextInt());
            }
            scanner.close();

            // Если массив пустой, выводим 0
            if (nums.isEmpty()) {
                System.out.println(0);
                return;
            }

            // Находим медиану
            Collections.sort(nums);
            int median;
            int n = nums.size();
            if (n % 2 == 0) {
                // Если количество элементов чётное, медиана — среднее двух центральных элементов
                median = (nums.get(n / 2 - 1) + nums.get(n / 2)) / 2;
            } else {
                // Если количество элементов нечётное, медиана — центральный элемент
                median = nums.get(n / 2);
            }

            // Вычисляем сумму абсолютных отклонений от медианы
            int moves = 0;
            for (int num : nums) {
                moves += Math.abs(num - median);
            }

            // Выводим результат
            System.out.println(moves);
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: файл не найден.");
        } catch (InputMismatchException e) {
            System.out.println("Ошибка: неверный формат данных в файле.");
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }
}