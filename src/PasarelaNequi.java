public class PasarelaNequi implements PasarelaPago {      // punto 4
    public String nombre() { 
        return "Nequi"; 
    }
    public boolean cobrar(double monto) {
        if (monto <= 300000) {
            return true;
        } else {
            return false;
        }
    }
}
