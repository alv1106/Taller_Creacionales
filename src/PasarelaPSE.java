public class PasarelaPSE implements PasarelaPago{
    @Override
    public String nombre() {
        return "Nequi";
    }

    @Override
    public boolean cobrar(double monto) {
        return true;
    }
}
