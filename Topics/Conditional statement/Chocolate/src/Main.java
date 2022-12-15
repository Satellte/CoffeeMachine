import java.awt.*;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    int M = scanner.nextInt();
    int K = scanner.nextInt();
        int i = 1;
        int j = 1;
        int A = 0;
        while (i <= N) {
            //System.out.print(i + " ");
            int O = M * i;
            if (O == K) {
                A = 1;
            }
            //System.out.print(O + " ");
            i++;
        }
        while (j <= M) {
            //System.out.print(i + " ");
            int Q = N * j;
            if (Q == K) {
                A = 1;
            }
            //System.out.print(Q + " ");
            j++;
        }
    if (A == 1) {
        System.out.println("YES");
    }
    if (A == 0) {
        System.out.println("NO");
    }
    }
}
