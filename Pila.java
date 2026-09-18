public class Pila {
    private Nodo cima;

    private class Nodo {
        Pizza pizza;
        Nodo siguiente;
    }

    public void push(Pizza pizza) {
        Nodo nuevo = new Nodo();
        nuevo.pizza = pizza;

        // El nuevo nodo apunta al nodo que estaba arriba antes.
        nuevo.siguiente = cima;

        // El puntero cima ahora apunta al nuevo nodo.
        cima = nuevo;
    }

    public Pizza pop() {
        if (isEmpty()) {
            return null;
        }

        // Guardamos el valor del nodo superior.
        Pizza pizza = cima.pizza;

        // Movemos la cima al siguiente nodo.
        cima = cima.siguiente;

        return pizza;
    }

    public Pizza peek() {
        if (isEmpty()) {
            return null;
        }
        return cima.pizza;
    }

    public boolean isEmpty() {
        return cima == null;
    }

    public void mostrarTodos() {
        Nodo actual = cima;
        int numero = 1;

        while (actual != null) {
            System.out.println(numero + ". " + actual.pizza);
            actual = actual.siguiente;
            numero++;
        }
    }
}
