
public abstract class ProcesadorPago {

    public abstract PasarelaPago crearPasarela();

    public void procesar(Pedido pedido) {

        PasarelaPago pasarela = crearPasarela();
        double total = pedido.calcularTotal();

        System.out.println("Procesando " + pedido.getId()+ " con " + pasarela.nombre()+ " por $" + total);

        if (pasarela.cobrar(total)) {
            System.out.println("  -> Pago APROBADO");
        } else {
            System.out.println("  -> Pago RECHAZADO");
        }
    }
}
