public class PasarelaTarjeta implements PasarelaPago {
    @Override
    public String nombre() {
        return "tarjeta";
    }

    @Override
    public boolean cobrar(double monto) {
        if (monto <= 500000) {
            return true;
        } else {
            return false;
        }
    }
}
