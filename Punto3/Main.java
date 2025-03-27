package Punto3;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        Stack<Integer> pila = crearPila();
        System.out.println("Pila creada");
        System.out.println(pila);
        Stack<Integer> pilaNueva = organizarDatosPila(pila);
        System.out.println("Pila organizada"); 
        System.out.println(pilaNueva); 
        calclularraizCuadradaElementos(pilaNueva);



    }

    public static Stack<Integer> crearPila(){
        Stack<Integer> pila = new Stack<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de elementos que desea agregar a la pila: ");
        int cantidad = sc.nextInt();
        for (int i = 0; i < cantidad; i++){
            System.out.println("Ingrese el elemento " + (i + 1) + ": ");
            pila.push(sc.nextInt());
        }
        return pila;

    }

    public static Stack<Integer> organizarDatosPila(Stack<Integer> pila){
        Stack<Integer> pilaNueva = new Stack<>();
        for(int num:pila){
            if(num < 0){
                pilaNueva.push(0);
            } else if(num > 8 && num < 20){
                pilaNueva.push(50);
            } else if (num > 60 && num < 62){
                pilaNueva.push(100);
            }else{
                pilaNueva.push(num);
            }
        }
        return pilaNueva;
    }

    public static void calclularraizCuadradaElementos(Stack<Integer> pila){
        for(int num:pila){
            System.out.println("La raiz cuadrada de " + num + " es: " + Math.sqrt(num));
        }
    }

}
