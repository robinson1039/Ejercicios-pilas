package Punto9;
import java.util.Stack;
import java.util.Collections;
import java.util.Random;

public class PilaFactorial {

    // Función para calcular el factorial de un número
    public static long calcularFactorial(int n) {
        if (n == 0) return 1; // El factorial de 0 es 1
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }

    // Función para eliminar un número de la pila
    public static boolean eliminarNumero(Stack<Long> pila, long numero) {
        return pila.remove(Long.valueOf(numero));  // Elimina el número específico de la pila
    }

    public static void main(String[] args) {
        // Crear una pila para almacenar los factoriales
        Stack<Long> pila = new Stack<>();
        Random random = new Random();

        // Generar números aleatorios entre 1 y 10 y calcular su factorial
        for (int i = 0; i < 10; i++) {
            int numeroAleatorio = random.nextInt(10) + 1;  // Números entre 1 y 10
            long factorial = calcularFactorial(numeroAleatorio);
            pila.push(factorial);
            System.out.println("Número aleatorio: " + numeroAleatorio + " - Factorial: " + factorial);
        }

        // Mostrar la pila antes de ordenar
        System.out.println("\nPila antes de ordenar (ascendente):");
        System.out.println(pila);

        // Ordenar la pila de manera ascendente
        Collections.sort(pila);
        System.out.println("\nPila ordenada de manera ascendente:");
        System.out.println(pila);

        // Ordenar la pila de manera descendente
        Collections.sort(pila, Collections.reverseOrder());
        System.out.println("\nPila ordenada de manera descendente:");
        System.out.println(pila);

        // Buscar un número aleatorio de la pila y eliminarlo
        long numeroAEliminar = pila.get(random.nextInt(pila.size()));  // Selecciona un número aleatorio de la pila
        System.out.println("\nNúmero a eliminar: " + numeroAEliminar);

        boolean eliminado = eliminarNumero(pila, numeroAEliminar);
        if (eliminado) {
            System.out.println("Número " + numeroAEliminar + " eliminado.");
        } else {
            System.out.println("Número no encontrado.");
        }

        // Mostrar la pila después de eliminar
        System.out.println("\nPila después de eliminar el número:");
        System.out.println(pila);
    }
}
