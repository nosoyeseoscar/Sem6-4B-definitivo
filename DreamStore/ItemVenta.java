public class ItemVenta {
    private Producto producto;
    private int cantidad;

    public ItemVenta(Producto producto, int cantidad){
        this.producto = producto;
        this.cantidad = cantidad;
        System.out.println("\nSe ha agregado " + cantidad + " unidad(es) de " + producto.getNombre() + " a la venta.");
        //Se reduce la cantidad en stock del producto al generarse el objeto ItemCuenta.
        producto.reducirStock(cantidad);
    }

    public int getCantidad(){
        return cantidad;
    }

    public Producto getProducto(){
        return producto;
    }

    public double calcularSubtotal(){
        //Se calcula subtotal por producto.
        return producto.getPrecio() * cantidad;
    }

    @Override
    public String toString() {
        return "ItemVenta{" + "producto=" + producto + ", cantidad=" + cantidad + '}';
    }
}
