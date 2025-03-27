package Punto8;
import java.util.Stack;
import java.util.Collections;
import java.util.Random;

public class PilaFibonacci {

    // Función para calcular la serie Fibonacci hasta un número máximo
    public static Stack<Integer> generarFibonacci(int limite) {
        Stack<Integer> fibonacci = new Stack<>();
        int a = 0, b = 1;
        fibonacci.push(a);
        fibonacci.push(b);

        while (true) {
            int siguiente = a + b;
            if (siguiente > limite) break;
            fibonacci.push(siguiente);
            a = b;
            b = siguiente;
        }
        return fibonacci;
    }

    // Función para eliminar un número de la pila
    public static boolean eliminarNumero(Stack<Integer> pila, int numero) {
        return pila.remove(Integer.valueOf(numero));  // Elimina el número específico de la pila
    }

    public static void main(String[] args) {
        // Crear una pila y generar números aleatorios
        Random random = new Random();
        int limite = random.nextInt(100) + 50;  // Limite aleatorio entre 50 y 150
        System.out.println("Límite de la serie Fibonacci: " + limite);

        Stack<Integer> pila = generarFibonacci(limite);

        // Mostrar la pila antes de ordenar
        System.out.println("Pila antes de ordenar:");
        System.out.println(pila);

        // Ordenar la pila de manera ascendente
        Collections.sort(pila);
        System.out.println("\nPila ordenada de manera ascendente:");
        System.out.println(pila);

        // Buscar un número aleatorio de la pila y eliminarlo
        int numeroAEliminar = pila.get(random.nextInt(pila.size()));  // Selecciona un número aleatorio
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
