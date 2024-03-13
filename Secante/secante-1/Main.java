import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Ingrese el primer punto inicial: ");
        double x0 = input.nextDouble();

        System.out.print("Ingrese el segundo punto inicial: ");
        double x1 = input.nextDouble();

        System.out.print("Ingrese el máximo de iteraciones: ");
        int maxIterations = input.nextInt();

        System.out.print("Ingrese el error permitido: ");
        double error = input.nextDouble();

        double root = secant(x0, x1, maxIterations, error);
        System.out.println("La raíz de la función es: " + root);
    }

    public static double secant(double x0, double x1, int maxIterations, double error) {
        for (int i = 0; i < maxIterations; i++) {
            double fx0 = f(x0);
            double fx1 = f(x1);

            if (Math.abs(fx1 - fx0) < error) {
                return x1;
            }

            double x2 = x1 - (fx1 * (x1 - x0)) / (fx1 - fx0);

            x0 = x1;
            x1 = x2;
        }

        return x1;
    }

    public static double f(double x) {
        
        return x*x - 4; 
    }
}