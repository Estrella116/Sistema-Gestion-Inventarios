
import java.util.ArrayList;

// Interfaz para mostrar informacion
interface Informacion {
    void mostrarInformacion();
}

// Clase abstracta Producto
abstract class Producto implements Informacion {
    protected String nombre;
    protected double precio;
    protected int cantidad;

    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public abstract String obtenerTipo();

    public double calcularTotal() {
        return precio * cantidad;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Producto: " + nombre);
        System.out.println("Tipo: " + obtenerTipo());
        System.out.println("Precio: $" + precio);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Valor total: $" + calcularTotal());
        System.out.println("-------------------------");
    }
}

// Clase derivada Electronico
class Electronico extends Producto {
    public Electronico(String nombre, double precio, int cantidad) {
        super(nombre, precio, cantidad);
    }

    @Override
    public String obtenerTipo() {
        return "Electronico";
    }
}

// Clase derivada Alimento
class Alimento extends Producto {
    public Alimento(String nombre, double precio, int cantidad) {
        super(nombre, precio, cantidad);
    }

    @Override
    public String obtenerTipo() {
        return "Alimento";
    }
}

// Clase derivada Ropa
class Ropa extends Producto {
    public Ropa(String nombre, double precio, int cantidad) {
        super(nombre, precio, cantidad);
    }

    @Override
    public String obtenerTipo() {
        return "Ropa";
    }
}

// Programa principal
public class Main {
    public static void main(String[] args) {

        ArrayList<Producto> inventario = new ArrayList<>();

        // Crear productos
        inventario.add(new Electronico("Laptop", 12000, 2));
        inventario.add(new Alimento("Leche", 25, 10));
        inventario.add(new Ropa("Camisa", 300, 5));

        System.out.println("SISTEMA DE GESTION DE INVENTARIOS");
        System.out.println("================================");

        double totalInventario = 0;

        // Aplicar polimorfismo
        for (Producto producto : inventario) {
            producto.mostrarInformacion();
            totalInventario += producto.calcularTotal();
        }

        System.out.println("Valor total del inventario: $" + totalInventario);
    }
}
