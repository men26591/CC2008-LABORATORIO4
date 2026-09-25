public class Maquina {

    private String codigoInventario;
    private String marca;
    private String modelo;
    private double tarifaDiaria;
    private boolean disponible;

    public Maquina(String codigoInventario, String marca, String modelo, double tarifaDiaria) {
        if (codigoInventario == null || codigoInventario.isEmpty()) {
            throw new IllegalArgumentException("El codigo de inventario no puede estar vacio");
        }

        if (tarifaDiaria <= 0) {
            throw new IllegalArgumentException("La tarifa diaria debe ser mayor que cero");
        }

        this.codigoInventario = codigoInventario;
        this.marca = marca;
        this.modelo = modelo;
        this.tarifaDiaria = tarifaDiaria;
        this.disponible = true;
    }

    public String getCodigoInventario() {
        return codigoInventario;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public double getTarifaDiaria() {
        return tarifaDiaria;
    }

    public boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public double calcularCosto(int dias) {
        if (dias <= 0) {
            throw new IllegalArgumentException("Los dias deben ser mayores que cero");
        }

        return tarifaDiaria * dias;
    }

    @Override
    public String toString() {
        return "Codigo: " + codigoInventario
                + "\nMarca: " + marca
                + "\nModelo: " + modelo
                + "\nTarifa diaria: Q" + String.format("%.2f", tarifaDiaria)
                + "\nDisponible: " + disponible;
    }
}