package Punto4;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> pila = crearPila();
        System.out.println("Pila creada");
        System.out.println(pila);
        bucarNumeroEnPila(pila);
    }

    public static Stack<Integer> crearPila() {
        Stack<Integer> pila = new Stack<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de elementos que desea agregar a la pila: ");
        int cantidad = sc.nextInt();
        for (int i = 0; i < cantidad; i++) {
            System.out.println("Ingrese el elemento " + (i + 1) + ": ");
            pila.push(sc.nextInt());
        }
        return pila;

    }

    public static void bucarNumeroEnPila(Stack<Integer> pila) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese el numero que desea buscar en la pila: ");
            int numero = sc.nextInt();
            if (pila.isEmpty()) {
                System.out.println("La pila esta vacia");
                crearPila();
            } else if (pila.contains(numero)) {
                System.out.println("El numero " + numero + " se encuentra en la pila");
                break;
            } else {
                System.out.println("El numero " + numero + " no se encuentra en la pila");
            }
        }

    }
}
