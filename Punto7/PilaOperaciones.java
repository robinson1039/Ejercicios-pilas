package Punto7;
import java.util.Stack;

public class PilaOperaciones {

    public static void main(String[] args) {
        // Crear una pila de números
        Stack<Integer> pila = new Stack<>();
        
        // Ejemplo de números en la pila
        pila.push(-3);
        pila.push(25);
        pila.push(150);
        pila.push(35);
        pila.push(-7);
        pila.push(90);
        pila.push(50);
        pila.push(200);
        pila.push(10);
        pila.push(100);
        
        // Variables para almacenar resultados
        int countBetween20And80 = 0;
        int countPositivos = 0;
        int sumBetween80And200 = 0;

        // Recorrer la pila
        while (!pila.isEmpty()) {
            int num = pila.pop();  // Sacar el número de la pila

            // 1. Si el número es negativo, calcular su cubo
            if (num < 0) {
                int cubo = (int) Math.pow(num, 3);
                System.out.println("Número negativo: " + num + " - Cubo: " + cubo);
            }

            // 2. Contar los números entre 20 y 80
            if (num >= 20 && num <= 80) {
                countBetween20And80++;
            }

            // 3. Contar los números positivos
            if (num > 0) {
                countPositivos++;
            }

            // 4. Sumar los números entre 80 y 200
            if (num > 80 && num <= 200) {
                sumBetween80And200 += num;
            }
        }

        // Resultados finales
        System.out.println("\nCantidad de números entre 20 y 80: " + countBetween20And80);
        System.out.println("Cantidad de números positivos: " + countPositivos);
        System.out.println("Suma de números entre 80 y 200: " + sumBetween80And200);
    }
}
