package Punto5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        List<Integer> lista = crearLista();
        System.out.println("Lista creada");
        System.out.println(lista);
        Stack<Integer> pila = crearPila(lista);
        System.out.println("Pila creada");
        System.out.println(pila);
    }

    public static List<Integer> crearLista() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de elementos que desea agregar a la lista: ");
        int cantidad = sc.nextInt();
        List<Integer> lista = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            System.out.println("Ingrese el elemento " + (i + 1) + ": ");
            lista.add(sc.nextInt());
        }
        return lista;
    }

    public static Stack<Integer> crearPila(List<Integer> lista) {
        {
            Stack<Integer> pila = new Stack<>();

            for (int num : lista) {
                int valorActual = 1;
                System.out.println("El factorial de :" + num + " es");
                for (int i = 1; i <= num; i++) {
                    valorActual *=  i;
                }
                System.out.println(valorActual);
                pila.push(valorActual);
            }
            return pila;

        }
    }
}
