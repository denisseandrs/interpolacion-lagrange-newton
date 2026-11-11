package interpolacion;

public class InterpolacionNewton {

    /** Construye la tabla de diferencias divididas. La columna 0 es y; la fila 0 contiene los coeficientes. */
    public static double[][] tablaDiferenciasDivididas(double[] x, double[] y) {
        int n = x.length;
        double[][] d = new double[n][n];
        for (int i = 0; i < n; i++) {
            d[i][0] = y[i];
        }
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < n - j; i++) {
                d[i][j] = (d[i + 1][j - 1] - d[i][j - 1]) / (x[i + j] - x[i]);
            }
        }
        return d;
    }

    public static void imprimirTabla(double[] x, double[][] d) {
        int n = x.length;
        System.out.printf("%-10s", "x");
        for (int j = 0; j < n; j++) {
            System.out.printf("%-14s", "DD" + j);
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.printf("%-10.4f", x[i]);
            for (int j = 0; j < n - i; j++) {
                System.out.printf("%-14.6f", d[i][j]);
            }
            System.out.println();
        }
    }

    public static double interpolacionNewton(double[] x, double[] y, double xEval) {
        double[][] d = tablaDiferenciasDivididas(x, y);
        int n = x.length;
        // Evaluacion tipo Horner (anidada)
        double resultado = d[0][n - 1];
        for (int k = n - 2; k >= 0; k--) {
            resultado = resultado * (xEval - x[k]) + d[0][k];
        }
        return resultado;
    }
}
