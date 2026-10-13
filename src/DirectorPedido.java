public class DirectorPedido {

    private PedidoBuilder builder;

    public DirectorPedido(PedidoBuilder builder) {
        this.builder = builder;
    }

    public void cambiarBuilder(PedidoBuilder builder) {
        this.builder = builder;
    }

    // Receta: pedido a domicilio (cliente, direccion e items).
    public Pedido construirDomicilio(String cliente, String direccion, ItemPedido... items) {
        builder.reset()
                .conCliente(cliente)
                .conTipoEntrega(TipoEntrega.DOMICILIO)
                .conDireccion(direccion);
        for (ItemPedido item : items) {
            builder.agregarItem(item);
        }
        return builder.construir();
    }

    // Receta: pedido para recoger en el local (cliente e items).
    public Pedido construirParaRecoger(String cliente, ItemPedido... items) {
        builder.reset()
                .conCliente(cliente)
                .conTipoEntrega(TipoEntrega.RECOGER);
        for (ItemPedido item : items) {
            builder.agregarItem(item);
        }
        return builder.construir();
    }
}