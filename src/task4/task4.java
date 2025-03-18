package task4;

import java.io.*;
import java.util.*;

public class task4 {
    public static void main(String[] args) {
        String filePath = "src/task4/input.txt";
        try {
            List<Integer> nums = new ArrayList<>();
            Scanner scanner = new Scanner(new File(filePath));
            while (scanner.hasNextInt()) {
                nums.add(scanner.nextInt());
            }
            scanner.close();
            if (nums.isEmpty()) {
                System.out.println(0);
                return;
            }
            Collections.sort(nums);
            int median;
            int n = nums.size();
            if (n % 2 == 0) {
                median = (nums.get(n / 2 - 1) + nums.get(n / 2)) / 2;
            } else {
                median = nums.get(n / 2);
            }
            int moves = 0;
            for (int num : nums) {
                moves += Math.abs(num - median);
            }
            System.out.println(moves);
        } catch (Exception e) {
            System.out.println( e.getMessage());
        }
    }
}