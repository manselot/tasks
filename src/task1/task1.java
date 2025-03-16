package task1;

import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();


        // Проверяем корректность входных данных
        if (n <= 0 || m <= 0) {
            System.out.println("Ошибка: значения n и m должны быть положительными числами.");
            return;
        }

        // Массив для хранения пути
        StringBuilder path = new StringBuilder();

        // Начинаем с первого элемента (индекс 0)
        int current = 0;

        // Флаг для отслеживания первого элемента в пути
        boolean isFirst = true;

        while (true) {
            // Добавляем текущий элемент в путь (прибавляем 1, так как индексация с 0)
            path.append(current + 1);

            // Вычисляем следующий элемент через m шагов
            current = (current + m - 1) % n;

            // Если вернулись к первому элементу, завершаем цикл
            if (current == 0 && !isFirst) {
                break;
            }

            // После первой итерации устанавливаем флаг в false
            isFirst = false;
        }

        // Выводим результат
        System.out.println(path.toString());
    }
}