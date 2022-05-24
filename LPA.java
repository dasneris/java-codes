import java.util.Scanner;

public class LPA {
    public static void main(String[] args) {
         int n;
        Scanner scan = new Scanner(System.in);
        System.out.println("Insira um número");
        n = scan.nextInt();
        boolean b = ePerfeito(n);
        if(ePerfeito(n))
           System.out.println("True");
        else
            System.out.println("False");
    }
    public static boolean ePerfeito(int n) {
    int sum = 0;
        if (n > 0) {
            for (int i = 1; i < n; i++) {
                if (n % i == 0) {
                    sum = sum + i;
                }
            }
            if (sum == n) {
                return true;
            } else {
                return false;
            }

            }
        return false;

        }

    }
