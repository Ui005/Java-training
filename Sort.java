//Метод, который проверяет, является ли массив отсортированным.
import java.util.Scanner;
import java.util.Arrays;
public class Sort {
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        int n = scann.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scann.nextInt();
        }
        int[] b = a.clone();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (b[i] > b[j]) {
                    int c = b[i];
                    b[i] = b[j];
                    b[j] = c;
                }
            }
        }
        if(Arrays.equals(b, a)){
            System.out.println("Заданный массив отсортирован");
        }
        else {
            System.out.println("Заданный массив не отсортирован");
        }

    }
}


