package task1;

import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        StringBuilder path = new StringBuilder();
        int current = 0;
        boolean isFirst = true;
        while (true) {
            path.append(current + 1);
            current = (current + m - 1) % n;
            if (current == 0 && !isFirst) {
                break;
            }
            isFirst = false;
        }
        System.out.println(path.toString());
    }
}