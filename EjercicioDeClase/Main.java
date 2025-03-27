package EjercicioDeClase;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Metodos metodos = new Metodos();
        Scanner sc = new Scanner(System.in);
        Stack<ObjRepuestos> registroVentas = new Stack<>();
        Stack<ObjRepuestos> inventario = new Stack<>();
        metodos.cargarInventarioInicial(inventario);
        while (true) {
            System.out.println("Ingrece la opcion que desea realizar: \n"+
                    "1. Ingresar repuesto\n"+
                    "2. Mostrar inventario\n"+
                    "3. Validar que el repuesto exista\n"+
                    "4. Vender repuesto\n"+
                    "5. eliminar repuesto\n"+
                    "6. ver registro de ventas\n"+
                    "7. Salir\n");
            System.out.print("Ingrece la opcion: ");
            int opcion = sc.nextInt();
            if (opcion == 1) {
                metodos.ingresarRepuesto(inventario);
            } else if (opcion == 2) {
                metodos.mostrarInventario(inventario);
            } else if (opcion == 3) {
                metodos.validarRepuesto(inventario);
            } else if (opcion == 4) {
                System.out.println("Ingrece la referencia del repuesto que desea vender: ");
                String referencia = sc.next();
                metodos.venderRepuesto(inventario, referencia);
                registroVentas = metodos.pilaDeVentas(registroVentas, inventario, referencia);
            }else if(opcion == 5){
               metodos.eliminarRepuesto(inventario);
            } else if (opcion == 6) {
                metodos.verRegistroDeVentas(registroVentas);
            }else if (opcion == 7){
                System.out.println("Saliendo...");
                break;
            } else {
                System.out.println("Opcion no valida");
            }
        }
        sc.close();
    }
    
}
