package EjercicioDeClase;

import java.util.Stack;
import java.util.Scanner;

class Repuesto {
    String marca;
    String referencia;
    double precio;
    int cantidad;

    // Constructor
    public Repuesto(String marca, String referencia, double precio, int cantidad) {
        this.marca = marca;
        this.referencia = referencia;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    // Método para mostrar detalles del repuesto
    public void mostrarRepuesto() {
        System.out.println("Marca: " + marca + ", Referencia: " + referencia + ", Precio: " + precio + ", Cantidad: " + cantidad);
    }
}

public class InventarioRepuestos {
    static Stack<Repuesto> pilaRepuestos = new Stack<>();
    static Stack<Repuesto> inventario = new Stack<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Cargamos el inventario con algunos repuestos predeterminados
        cargarInventarioInicial();

        int opcion;
        do {
            System.out.println("\n----- MENU -----");
            System.out.println("1. Ingresar Repuestos (desde inventario)");
            System.out.println("2. Mostrar Inventario");
            System.out.println("3. Validar Repuesto");
            System.out.println("4. Eliminar Repuesto");
            System.out.println("5. Vender Repuesto");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    ingresarRepuesto();
                    break;
                case 2:
                    mostrarInventario();
                    break;
                case 3:
                    validarRepuesto();
                    break;
                case 4:
                    eliminarRepuesto();
                    break;
                case 5:
                    venderRepuesto();
                    break;
                case 6:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6);
    }

    // Método para cargar repuestos iniciales al inventario
    public static void cargarInventarioInicial() {
        inventario.push(new Repuesto("Marca1", "REF123", 100.0, 10));
        inventario.push(new Repuesto("Marca2", "REF124", 150.0, 5));
        inventario.push(new Repuesto("Marca3", "REF125", 200.0, 8));
    }

    // Método para ingresar un repuesto desde el inventario a la pila
    public static void ingresarRepuesto() {
        System.out.print("Ingrese la referencia del repuesto a ingresar: ");
        String referencia = scanner.nextLine();

        boolean encontrado = false;
        for (Repuesto repuesto : inventario) {
            if (repuesto.referencia.equals(referencia)) {
                encontrado = true;
                if (repuesto.cantidad > 0) {
                    pilaRepuestos.push(repuesto);  // Agregar repuesto a la pila
                    repuesto.cantidad--;  // Disminuir la cantidad en el inventario
                    System.out.println("Repuesto ingresado correctamente a la pila.");
                } else {
                    System.out.println("No hay stock disponible de este repuesto en el inventario.");
                }
                break;
            }
        }

        if (!encontrado) {
            System.out.println("El repuesto con la referencia " + referencia + " no existe en el inventario.");
        }

        mostrarPila();
    }

    // Método para mostrar el inventario
    public static void mostrarInventario() {
        if (inventario.isEmpty()) {
            System.out.println("El inventario está vacío.");
        } else {
            System.out.println("\nInventario:");
            for (Repuesto repuesto : inventario) {
                repuesto.mostrarRepuesto();
            }
        }
    }

    // Método para validar si un repuesto existe en el inventario
    public static void validarRepuesto() {
        System.out.print("Ingrese la referencia del repuesto a validar: ");
        String referencia = scanner.nextLine();
        boolean encontrado = false;

        for (Repuesto repuesto : inventario) {
            if (repuesto.referencia.equals(referencia)) {
                encontrado = true;
                System.out.println("Repuesto encontrado en el inventario:");
                repuesto.mostrarRepuesto();
                break;
            }
        }

        if (!encontrado) {
            System.out.println("El repuesto con la referencia " + referencia + " no existe en el inventario.");
        }
    }

    // Método para eliminar un repuesto de la pila
    public static void eliminarRepuesto() {
        if (pilaRepuestos.isEmpty()) {
            System.out.println("La pila de repuestos está vacía.");
            return;
        }

        System.out.print("Ingrese la referencia del repuesto a eliminar: ");
        String referencia = scanner.nextLine();
        boolean encontrado = false;

        Stack<Repuesto> auxPila = new Stack<>();
        while (!pilaRepuestos.isEmpty()) {
            Repuesto repuesto = pilaRepuestos.pop();
            if (repuesto.referencia.equals(referencia)) {
                encontrado = true;
                System.out.println("Repuesto eliminado de la pila.");
                break;
            }
            auxPila.push(repuesto);  // Guardar repuestos en la pila auxiliar
        }

        // Devolver los repuestos a la pila original
        while (!auxPila.isEmpty()) {
            pilaRepuestos.push(auxPila.pop());
        }

        if (!encontrado) {
            System.out.println("El repuesto con la referencia " + referencia + " no existe en la pila.");
        }

        mostrarPila();
    }

    // Método para vender un repuesto
    public static void venderRepuesto() {
        if (pilaRepuestos.isEmpty()) {
            System.out.println("La pila de repuestos está vacía.");
            return;
        }

        System.out.print("Ingrese la referencia del repuesto a vender: ");
        String referencia = scanner.nextLine();
        boolean encontrado = false;

        Stack<Repuesto> auxPila = new Stack<>();
        while (!pilaRepuestos.isEmpty()) {
            Repuesto repuesto = pilaRepuestos.pop();
            if (repuesto.referencia.equals(referencia)) {
                encontrado = true;
                if (repuesto.cantidad > 0) {
                    repuesto.cantidad--;
                    System.out.println("Repuesto vendido correctamente. Quedan " + repuesto.cantidad + " unidades.");
                } else {
                    System.out.println("No hay stock disponible para este repuesto.");
                }
                break;
            }
            auxPila.push(repuesto);  // Guardar repuestos en la pila auxiliar
        }

        // Devolver los repuestos a la pila original
        while (!auxPila.isEmpty()) {
            pilaRepuestos.push(auxPila.pop());
        }

        if (!encontrado) {
            System.out.println("El repuesto con la referencia " + referencia + " no existe en la pila.");
        }

        mostrarPila();
    }

    // Método para mostrar los repuestos en la pila
    public static void mostrarPila() {
        if (pilaRepuestos.isEmpty()) {
            System.out.println("La pila de repuestos está vacía.");
        } else {
            System.out.println("\nPila de Repuestos:");
            for (Repuesto repuesto : pilaRepuestos) {
                repuesto.mostrarRepuesto();
            }
        }
    }
}
