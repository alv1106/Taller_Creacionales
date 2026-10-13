public interface PedidoBuilder {
    PedidoBuilder reset();

    PedidoBuilder conCliente(String cliente);

    PedidoBuilder conTipoEntrega(TipoEntrega tipoEntrega);

    PedidoBuilder conDireccion(String direccion);

    PedidoBuilder agregarItem(ItemPedido item);

    PedidoBuilder conNotas(String notas);

    PedidoBuilder conCupon(int cupon);

    PedidoBuilder conPropina(double propina);

    Pedido construir();
}