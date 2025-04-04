//Метод, который сохраняет уже вычисленные значения Фибоначчи (в ArrayList<Long>)
//и использует их для дальнейших вычислений.

import java.util.Scanner;
import java.util.ArrayList;
public class Fibonacci {
    private static ArrayList<Long> array_fib = new ArrayList<>();

    public static Long fib(int n) {
        if (n < array_fib.size()) {
            return array_fib.get(n);
        }

        if (n == 0 || n == 1) {
            array_fib.add(1L);
            return 1L;
        } else {
            int fibonacciN = (int) (fib(n - 1) + fib(n - 2));
            array_fib.add((long) fibonacciN);
            return (long) fibonacciN;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("ВВедите кол-во чисел в ряду: ");
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Fibonachi(" + i + ")=" + fib(i));
        }
    }
}
