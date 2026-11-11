package interpolacion;

public class Main {
    public static void main(String[] args) {
        // Nodos propios (modificar a libre eleccion)
        double[] x = {1.0, 2.0, 4.0, 5.0, 7.0};
        double[] y = {2.0, 3.5, 1.8, 4.2, 6.1};
        double xEval = 3.0;

        System.out.println("=== Nodos ===");
        for (int i = 0; i < x.length; i++) {
            System.out.printf("x%d = %.4f   y%d = %.4f%n", i, x[i], i, y[i]);
        }
        System.out.println("Punto de evaluacion: x = " + xEval);

        System.out.println("\n=== Matriz de diferencias divididas de Newton ===");
        double[][] d = InterpolacionNewton.tablaDiferenciasDivididas(x, y);
        InterpolacionNewton.imprimirTabla(x, d);

        double rNewton = InterpolacionNewton.interpolacionNewton(x, y, xEval);
        double rLagrange = InterpolacionLagrange.interpolacionLagrange(x, y, xEval);

        System.out.println("\n=== Resultados ===");
        System.out.printf("Newton   P(%.2f) = %.10f%n", xEval, rNewton);
        System.out.printf("Lagrange P(%.2f) = %.10f%n", xEval, rLagrange);
        System.out.printf("Diferencia absoluta = %.3e%n", Math.abs(rNewton - rLagrange));
    }
}
