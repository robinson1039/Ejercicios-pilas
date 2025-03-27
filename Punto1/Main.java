import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrece la dimesion de la matriz:");

        int n = sc.nextInt();

        int[][] matriz = new int[n][n];

        System.out.println("Ingrese los valores de la matriz:");

        for(int i = 0; i< n; i++){
            for(int j = 0; j < n; j++){
                System.out.print("Elemento [" + i + "][" + j + "]: ");
                matriz[i][j] = sc.nextInt();
            }
        }
        
        
        while (true) {
            System.out.println("Ingrese la opcion que desea realizar:");
            System.out.println("1. Método pila con la suma de las filas de la matriz");
            System.out.println("2. Método cola con la suma de las columnas de la matriz");
            System.out.println("3. Método donde muestre la factorial de la dimensión de la matriz");
            System.out.println("4.  Método cola donde muestre los números ordenados de mayor a menor de la cola");
            System.out.println("5. Salir");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    mostrarMatriz(matriz);
                    sumaPilaFila(matriz);
                    break;
            case 2:
                mostrarMatriz(matriz);
                sumaColaColumna(matriz);
                break;
            case 3:
                mostrarMatriz(matriz);
                System.out.println("Factorial de la dimensión de la matriz: " + factorial(n));
                break;
            case 4:
                mostrarMatriz(matriz);
                ordenarCola(matriz);
                break;
            case 5:
                System.out.println("Saliendo...");
                return;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
    }

    public static void mostrarMatriz(int[][] matriz){
        for(int i = 0; i< matriz.length; i++){
            for(int j = 0; j < matriz.length; j++){
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void sumaPilaFila(int[][] matriz){
        Stack<Integer> pila = new Stack<>();
        for(int i = 0; i< matriz.length; i++){
            int suma = 0;
            for(int j = 0; j< matriz[i].length; j++){
                suma += matriz[i][j];
            }
            pila.push(suma);
        }
        System.out.println("Suma de las filas de la matriz:");
        while(!pila.isEmpty()){
            System.out.println(pila.pop());
        }
    }

    public static void sumaColaColumna(int[][] matriz){
        Queue<Integer> cola = new LinkedList<>();
        for(int j = 0; j < matriz[0].length; j++){
            int suma = 0;
            for(int i = 0; i <matriz.length; i++){
                suma += matriz[i][j];
            }
            cola.add(suma);
        }
        System.out.println("Suma de las columnas de la matriz:");
        while(!cola.isEmpty()){
            System.out.println(cola.poll());
        }

    }

    public static int factorial(int n){
        int factorial = 1;
        for(int i = 1; i < n; i++){
            factorial *= i;
        }
        return factorial;
    }

    public static void ordenarCola(int[][] matriz){
        Queue<Integer> cola = new LinkedList<>();
        for(int i = 0; i< matriz.length; i++){
            for(int j = 0; j< matriz[i].length; j++){
                cola.add(matriz[i][j]);
            }
        }
        List<Integer> lista = new ArrayList<>(cola);
        lista.sort(Collections.reverseOrder());
        System.out.println("Números ordenados de mayor a menor:");
        for(int num:lista){
            System.out.println(num);
        }
    }
}