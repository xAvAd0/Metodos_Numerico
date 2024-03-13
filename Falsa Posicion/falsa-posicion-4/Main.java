import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Ingrese el límite inferior: ");
        double a = input.nextDouble();

        System.out.print("Ingrese el límite superior: ");
        double b = input.nextDouble();

        System.out.print("Ingrese el máximo de iteraciones: ");
        int maxIterations = input.nextInt();

        System.out.print("Ingrese el error permitido: ");
        double error = input.nextDouble();

        double root = falsePosition(a, b, maxIterations, error);
        System.out.println("La raíz de la función es: " + root);
    }

    public static double falsePosition(double a, double b, int maxIterations, double error) {
        double fa = f(a);
        double fb = f(b);

        if (fa * fb > 0) {
            System.out.println("No se puede garantizar la existencia de una raíz en el intervalo dado.");
            return Double.NaN;
        }

        for (int i = 0; i < maxIterations; i++) {
            double c = (a * fb - b * fa) / (fb - fa);
            double fc = f(c);

            if (Math.abs(fc) < error) {
                return c;
            }

            if (fa * fc < 0) {
                b = c;
                fb = fc;
            } else {
                a = c;
                fa = fc;
            }
        }

        return (a * fb - b * fa) / (fb - fa);
    }

    public static double f(double x) {
      
        return x*x + 5; 
    }
}