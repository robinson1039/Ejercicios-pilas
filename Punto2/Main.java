package Punto2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> pila = crearPila();
        System.out.println("Pila creada");
        System.out.println(pila);  
        invertirPila(pila);
        System.out.println("Cantidad de elementos en la pila: " + contarPila(pila));
        
    }

    public static Stack<Integer> crearPila(){
        Stack<Integer> pila = new Stack<>();
        for (int i = 0; i < 10; i++){
            pila.push(i);
        }

        return pila;
    }

    public static void invertirPila(Stack<Integer> pila){
        List<Integer> lista = new ArrayList<>(pila);
        lista.sort(Collections.reverseOrder());
        System.out.println("Pila invertida:");
        System.out.println(lista);
    }

    public static int contarPila(Stack<Integer> pila){
        return pila.size();
    }
}
