
import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private final String id;
    private final String cliente;
    private final TipoEntrega tipoEntrega;
    private final String direccion;
    private final List<ItemPedido> items;
    private final String notas;
    private final int cupon;
    private final double propina;

    // Constructor privado: solo el Builder crea pedidos.
    private Pedido(Builder builder, String id) {
        this.id = id;
        this.cliente = builder.cliente;
        this.tipoEntrega = builder.tipoEntrega;
        this.direccion = builder.direccion;
        this.items = new ArrayList<>(builder.items);
        this.notas = builder.notas;
        this.cupon = builder.cupon;
        this.propina = builder.propina;
    }

    // Constructor de copia para Prototype.
    private Pedido(Pedido original) {
        this.id = GeneradorConsecutivo
                .obtenerInstancia().siguiente();

        this.cliente = original.cliente;
        this.tipoEntrega = original.tipoEntrega;
        this.direccion = original.direccion;
        this.items = new ArrayList<>(original.items);
        this.notas = original.notas;
        this.cupon = 0;
        this.propina = original.propina;
    }

    public Pedido clonar() {
    return new Pedido(this);
    }


    public void agregarItem(ItemPedido item) {
        items.add(item);
    }

    public String getId() {
        return id;
    }

    public double calcularTotal() {
        double subtotal = 0;

        for (ItemPedido item : items) {
            subtotal += item.getSubtotal();
        }

        return subtotal * (100 - cupon) / 100.0
                + propina;
    }

    public void mostrarResumen() {
        System.out.print("Pedido " + id
                + " | Cliente: " + cliente
                + " | Entrega: " + tipoEntrega);

        if (tipoEntrega == TipoEntrega.DOMICILIO) {
            System.out.print(" (" + direccion + ")");
        }

        System.out.println();

        for (ItemPedido item : items) {
            System.out.printf("  - %d x %s ($%.0f)%n",
                    item.getCantidad(),
                    item.getNombre(),
                    item.getPrecioUnitario());
        }

        if (!notas.isEmpty()) {
            System.out.println("  Notas: " + notas);
        }

        System.out.printf(
                "  Cupon: %d%% | Propina: $%.0f | Total: $%.0f%n",
                cupon, propina, calcularTotal());
    }

    public static class Builder {

        private String cliente;
        private TipoEntrega tipoEntrega = TipoEntrega.RECOGER;
        private String direccion = "";
        private final List<ItemPedido> items = new ArrayList<>();
        private String notas = "";
        private int cupon = 0;
        private double propina = 0;

        public Builder conCliente(String cliente) {
            this.cliente = cliente;
            return this;
        }

        public Builder conTipoEntrega(TipoEntrega tipoEntrega) {
            this.tipoEntrega = tipoEntrega;
            return this;
        }

        public Builder conDireccion(String direccion) {
            this.direccion = direccion;
            return this;
        }

        public Builder agregarItem(ItemPedido item) {
            items.add(item);
            return this;
        }

        public Builder conNotas(String notas) {
            this.notas = notas;
            return this;
        }

        public Builder conCupon(int cupon) {
            this.cupon = cupon;
            return this;
        }

        public Builder conPropina(double propina) {
            this.propina = propina;
            return this;
        }

        public Pedido construir() {
            // Validaciones en el orden exigido por el taller.
            if (cliente == null || cliente.trim().isEmpty()) {
                throw new IllegalStateException(
                        "El cliente es obligatorio");
            }

            if (items.isEmpty()) {
                throw new IllegalStateException(
                        "El pedido debe tener al menos un item");
            }

            if (tipoEntrega == TipoEntrega.DOMICILIO
                    && (direccion == null
                            || direccion.trim().isEmpty())) {
                throw new IllegalStateException(
                        "El domicilio requiere direccion");
            }

            if (cupon < 0 || cupon > 100) {
                throw new IllegalArgumentException(
                        "El cupon debe estar entre 0 y 100");
            }

            // El número se asigna únicamente después de validar.
            String id = GeneradorConsecutivo
                    .obtenerInstancia().siguiente();

            return new Pedido(this, id);
        }
    }
}
