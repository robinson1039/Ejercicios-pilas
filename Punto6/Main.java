package Punto6;
import java.util.Stack;

public class Main {

    // Función para imprimir la matriz
    public static void imprimirMatriz(double[][] matriz) {
        for (double[] fila : matriz) {
            for (double elem : fila) {
                System.out.print(elem + "\t");
            }
            System.out.println();
        }
    }

    // Función para sumar las filas y calcular el promedio
    public static Stack<Double> sumaPromedioFilas(double[][] matriz) {
        Stack<Double> pila = new Stack<>();
        for (int i = 0; i < matriz.length; i++) {
            double sumaFila = 0;
            for (int j = 0; j < matriz[i].length; j++) {
                sumaFila += matriz[i][j];
            }
            pila.push(sumaFila / matriz[i].length); // Promedio de la fila
        }
        return pila;
    }

    // Función para sumar las columnas y calcular la raíz cuadrada
    public static Stack<Double> sumaRaizColumnas(double[][] matriz) {
        Stack<Double> pila = new Stack<>();
        int columnas = matriz[0].length;

        for (int j = 0; j < columnas; j++) {
            double sumaColumna = 0;
            for (int i = 0; i < matriz.length; i++) {
                sumaColumna += matriz[i][j];
            }
            pila.push(Math.sqrt(sumaColumna)); // Raíz cuadrada de la suma de la columna
        }
        return pila;
    }

    // Función para multiplicar dos matrices
    public static double[][] multiplicarMatrices(double[][] matrizA, double[][] matrizB) {
        int filasA = matrizA.length;
        int columnasA = matrizA[0].length;
        int filasB = matrizB.length;
        int columnasB = matrizB[0].length;

        if (columnasA != filasB) {
            throw new IllegalArgumentException("Las matrices no se pueden multiplicar.");
        }

        double[][] resultado = new double[filasA][columnasB];

        for (int i = 0; i < filasA; i++) {
            for (int j = 0; j < columnasB; j++) {
                for (int k = 0; k < columnasA; k++) {
                    resultado[i][j] += matrizA[i][k] * matrizB[k][j];
                }
            }
        }
        return resultado;
    }

    public static void main(String[] args) {
        // Ejemplo de matrices
        double[][] matrizA = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        double[][] matrizB = {
            {9, 8, 7},
            {6, 5, 4},
            {3, 2, 1}
        };

        // 1. Sumar las filas y calcular los promedios
        Stack<Double> resultadoFilas = sumaPromedioFilas(matrizA);
        System.out.println("Promedio de las filas:");
        while (!resultadoFilas.isEmpty()) {
            System.out.println(resultadoFilas.pop());
        }

        // 2. Sumar las columnas y calcular la raíz cuadrada de cada suma
        Stack<Double> resultadoColumnas = sumaRaizColumnas(matrizA);
        System.out.println("\nRaíz cuadrada de la suma de las columnas:");
        while (!resultadoColumnas.isEmpty()) {
            System.out.println(resultadoColumnas.pop());
        }

        // 3. Multiplicar las matrices A y B
        System.out.println("\nMultiplicación de las matrices A y B:");
        double[][] matrizResultado = multiplicarMatrices(matrizA, matrizB);
        imprimirMatriz(matrizResultado);
    }
}
