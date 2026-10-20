import java.util.*;

class Nodo {
    int valor;
    Nodo izq, der;
    Nodo(int valor) { this.valor = valor; }
}

public class MainNodo{
    static Nodo insertar(Nodo n, int v){
        if (n == null) return new Nodo(v);
        if (v < n.valor) n.izq = insertar(n.izq, v);
        else n.der = insertar(n.der, v);
        return n;
    }

    static void inorden(Nodo n) {
        if (n == null) return;
        inorden(n.izq);
        System.out.println(n.valor + " ");
        inorden(n.der);
    }

    public static void main (String[] args){
        Nodo raiz = null;
        for (int v : new int[]{50, 30, 70, 20, 40}) raiz = insertar(raiz, v);
        System.out.println("Árbol: ");
        inorden(raiz);


        Map<String, List<String>> grafo = new HashMap<>();
        grafo.put("A", List.of("B", "C"));
        grafo.put("B", List.of("A"));
        grafo.put("C", List.of("A"));

        System.out.println("\nGrafo.");
        for (String n : grafo.keySet())
            System.out.println(n + " -> " + grafo.get(n));
    }


}
