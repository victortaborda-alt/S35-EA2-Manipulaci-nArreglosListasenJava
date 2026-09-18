import java.util.Scanner;

public class GestionPedidos {
    private final Pila principal = new Pila();
    private final Pila secundaria = new Pila();
    private final Scanner scanner = new Scanner(System.in);

    public void registrarPedido() {
        System.out.print("Nombre de la pizza: ");
        String nombre = scanner.nextLine();

        String[] ingredientes = new String[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("Ingrediente " + (i + 1) + ": ");
            ingredientes[i] = scanner.nextLine();
        }

        Pizza pizza = new Pizza(nombre, ingredientes);
        principal.push(pizza);
        System.out.println("Pedido registrado: " + pizza);
    }

    public void deshacer() {
        if (principal.isEmpty()) {
            System.out.println("No hay pedidos para deshacer.");
            return;
        }

        Pizza pizza = principal.pop();
        secundaria.push(pizza);
        System.out.println("Deshecho: " + pizza);
    }

    public void rehacer() {
        if (secundaria.isEmpty()) {
            System.out.println("No hay pedidos para rehacer.");
            return;
        }

        Pizza pizza = secundaria.pop();
        principal.push(pizza);
        System.out.println("Rehecho: " + pizza);
    }

    public void mostrarPedidoActual() {
        if (principal.isEmpty()) {
            System.out.println("No hay pedido actual.");
            return;
        }

        System.out.println("Pedido actual: " + principal.peek());
    }

    public void menu() {
        int opcion;

        do {
            System.out.println("\n--- Pizza-Track ---");
            System.out.println("1. Registrar Pizza");
            System.out.println("2. Deshacer");
            System.out.println("3. Rehacer");
            System.out.println("4. Mostrar Pedido Actual");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            String entrada = scanner.nextLine();
            try {
                opcion = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1:
                    registrarPedido();
                    break;
                case 2:
                    deshacer();
                    break;
                case 3:
                    rehacer();
                    break;
                case 4:
                    mostrarPedidoActual();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        } while (opcion != 0);
    }
}
