package EjercicioDeClase;

import java.util.Scanner;
import java.util.Stack;

public class Metodos {
    Scanner sc = new Scanner(System.in);
    public void cargarInventarioInicial(Stack<ObjRepuestos> inventario) {

        inventario.push(new ObjRepuestos("Llanta", "1", 100, 10));
        inventario.push(new ObjRepuestos("Bateria", "2", 50, 5));
        inventario.push(new ObjRepuestos("Aceite", "3", 30, 15));
        inventario.push(new ObjRepuestos("Filtro de aire", "4", 20, 8));
        inventario.push(new ObjRepuestos("Filtro de aceite", "5", 25, 12));
    }

    public Stack<ObjRepuestos> ingresarRepuesto(Stack<ObjRepuestos> inventario) {
        System.out.println("Ingrece la referencia del repuesto: ");     
        String referencia = sc.nextLine();
        boolean econtrado = false;
        for (ObjRepuestos repuesto : inventario) {
            if (repuesto.getReferencia().equals(referencia)) {
                econtrado = true;
                if (repuesto.getCantidad() > 0) {
                    repuesto.setCantidad(repuesto.getCantidad() + 1);
                    System.out.println("Repuesto ingresado correctamente");
                } else {
                    System.out.println("No hay mas repuestos disponibles");
                }
                break;
            }
        }
        if (!econtrado) {
            System.out.println("El repuesto con la referencia " + referencia + " no existe en el inventario.");
            return inventario;
        }
        return inventario;
    }

    public void mostrarInventario(Stack<ObjRepuestos> inventario) {
        System.out.println("Inventario de repuestos: ");
        for (ObjRepuestos repuesto : inventario) {
            repuesto.mostrarRepuesto();
        }
    }

    public void validarRepuesto(Stack<ObjRepuestos> inventario) {
        System.out.println("Ingrece la referencia del repuesto que desea encontrar: ");
        String referencia = sc.nextLine();
        boolean econtrado = false;
        for (ObjRepuestos repuesto: inventario){
            if(repuesto.getReferencia().equals(referencia)){
                econtrado = true;
                System.out.println("El repuesto con la referencia " + referencia + " si existe en el inventario.");
                break;
            }
        }
        if(!econtrado){
            System.out.println("El repuesto con la referencia " + referencia + " no existe en el inventario.");
        }

    }

    public Stack<ObjRepuestos> venderRepuesto(Stack<ObjRepuestos> inventario, String referencia) {
        boolean econtrado = false;
        for (ObjRepuestos repuesto: inventario) {
            if(repuesto.getReferencia().equals(referencia)){
                econtrado = true;
                if(repuesto.getCantidad() > 0){
                    repuesto.setCantidad(repuesto.getCantidad() - 1);
                    System.out.println("Repuesto vendido correctamente");
                }else{
                    System.out.println("No hay mas repuestos disponibles");
                }
                break;
            }
        }
        if (!econtrado) {
            System.out.println("El repuesto con la referencia " + referencia + " no existe en el inventario.");
            return inventario;
        }
        return inventario;
    }

    public Stack<ObjRepuestos> pilaDeVentas(Stack<ObjRepuestos> registroVentas, Stack<ObjRepuestos> inventario,String referencia) {
        boolean econtrado = false;
        for (ObjRepuestos repuesto: inventario){
            if(repuesto.getReferencia().equals(referencia)){
                econtrado = true;
                registroVentas.push(repuesto);
                System.out.println("La venta se registro correctamente");
                break;
            }
        }

        if (!econtrado) {
            System.out.println("La venta no se pudo registrar");
            return registroVentas;
        }
        
        return registroVentas;

    }

    public Stack<ObjRepuestos> eliminarRepuesto(Stack<ObjRepuestos> inventario) {
        if(inventario.isEmpty()){
            System.out.println("El inventario esta vacio");
            return inventario;
        }
        System.out.println("Ingrece la referencia del repuesto que desea eliminar: ");
        String referencia = sc.nextLine();
        boolean econtrado = false;
        Stack<ObjRepuestos> auxInventario = new Stack<>();
        while (!inventario.isEmpty()){
            ObjRepuestos repuestos = inventario.pop();
            if(repuestos.getReferencia().equals(referencia)){
                econtrado = true;
                System.out.println("Repuesto eliminado correctamente");
                break;
            }
            auxInventario.push(repuestos);
        }
        while(!auxInventario.isEmpty()){
            inventario.push(auxInventario.pop());
        }
        if (!econtrado) {
            System.out.println("El repuesto con la referencia " + referencia + " no existe en el inventario.");
            return inventario;
        }
        return inventario;
    }

    public void verRegistroDeVentas(Stack<ObjRepuestos> registroVentas) {
        System.out.println("Registro de ventas: ");
        for (ObjRepuestos venta : registroVentas) {
            venta.mostrarRepuesto();;
        }
    }
}
