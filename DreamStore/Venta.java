import java.util.ArrayList;

public class Venta {
    //private Producto producto;
    private Cliente cliente;
    private ArrayList<ItemVenta> items;//productos y su cantidad
    private double total;

    public Venta(Cliente cliente) {
        //inicializo todo en cero o vacío.
        this.cliente = cliente;
        this.items = new ArrayList<>();
        total = 0;
    }

    public void agregarItem(Producto producto, int cantidad) {
        try {
            if (producto.getStock() > 0) {
                ItemVenta item = new ItemVenta(producto, cantidad);
                items.add(item);
            } else {
                throw new SinStockExcepcion(
                    "El producto " + producto.getNombre() + " no tiene stock disponible."
                );
            }
        } catch (SinStockExcepcion e) {
            System.out.println(e.getMessage());
        }
    }


    public void calcularTotal() {
        //Este método se puede o no usar en el programa, pero se deja por si se ocupa.
        total = 0;
        for (ItemVenta item : items) {
            total += item.calcularSubtotal();
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void generarTicket(){
        //imprime en pantalla los datos de la venta
        System.out.println(); //línea en blanco por estética
        System.out.println("Ticket de venta para: " + cliente.getNombre()); //cliente
        System.out.println("------------------------------------");
        for (ItemVenta item : items) {
            System.out.println(item.getProducto().getNombre()+" x " + item.getCantidad() + " = $" + String.format("%.2f", item.calcularSubtotal()) );
            
            //aprovecho el foreach para sacar el total.
            total = total + item.calcularSubtotal();
        }
        System.out.println("------------------------------------");
        System.out.println("Total a pagar: $" + String.format("%.2f", total));
    }

    public double getTotal(){
        //de momento no se usa, pero se deja por si se ocupa.
        return total;
    }
    
    @Override
    public String toString() {
        return "Venta [Listaitems=" + items + "]";
    }
}
