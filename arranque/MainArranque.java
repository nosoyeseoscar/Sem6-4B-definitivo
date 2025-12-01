public class MainArranque {
    public static void main(String[] args) {
        // Producto precargados, que sería el inventario en caso de implementarse
        Producto mouse = new Producto("Mouse", 300, "Accesorios", 10);
        Producto laptop = new Producto("Laptop", 15000, "Electrónica", 5);
        Producto teclado = new Producto("Teclado", 800, "Accesorios", 0); //sin stock para prueba

        // Cliente precargado.
        Cliente c1 = new Cliente("Oscar Fuentes", "ofuentes@ejemplo.com");

        // Se empieza la venta.
        Venta venta1 = new Venta(c1);


        //Se agregan los items a la venta o al carrito.
        //TODO: poner try catch para capturar la excepción de sin stock.
        venta1.agregarItem(laptop, 1);
        venta1.agregarItem(mouse, 2);
        venta1.agregarItem(teclado, 1); 

        //Se imprime ticket de la venta.
        venta1.generarTicket();

        //Solo para saber sí hace la función de reducir stock. Se podría hacer un código más corto usando algun for y un array.
        System.out.println("\nStock restante de"+ laptop.getNombre()+": " + laptop.getStock());
        System.out.println("Stock restante de"+ mouse.getNombre()+": " + mouse.getStock());
        System.err.println("Stock restante de"+ teclado.getNombre()+": " + teclado.getStock());

    }
}
