import java.util.ArrayList;

public class DulceEstacion {

    private ArrayList<Maquina> maquinas;
    private double dineroAcumulado;

    public DulceEstacion() {
        maquinas = new ArrayList<Maquina>();
        dineroAcumulado = 0;
    }

    public boolean registrarMaquina(Maquina maquina) {

        if (buscarMaquina(maquina.getCodigoInventario()) != null) {
            return false;
        }

        maquinas.add(maquina);
        return true;
    }

    public Maquina buscarMaquina(String codigo) {

        for (Maquina maquina : maquinas) {
            if (maquina.getCodigoInventario().equals(codigo)) {
                return maquina;
            }
        }

        return null;
    }

    public double cotizar(String codigo, int dias) {

        Maquina maquina = buscarMaquina(codigo);

        if (maquina == null) {
            throw new IllegalArgumentException(
                "No existe una maquina con ese codigo"
            );
        }

        if (dias <= 0) {
            throw new IllegalArgumentException(
                "Los dias deben ser mayores que cero"
            );
        }

        return maquina.calcularCosto(dias);
    }

    public boolean alquilar(String codigo, int dias) {

        Maquina maquina = buscarMaquina(codigo);

        if (maquina == null) {
            return false;
        }

        if (!maquina.getDisponible()) {
            return false;
        }

        if (dias <= 0) {
            throw new IllegalArgumentException(
                "Los dias deben ser mayores que cero"
            );
        }

        double costo = maquina.calcularCosto(dias);

        maquina.setDisponible(false);
        dineroAcumulado = dineroAcumulado + costo;

        return true;
    }

    public boolean devolver(String codigo) {

        Maquina maquina = buscarMaquina(codigo);

        if (maquina == null) {
            return false;
        }

        if (maquina.getDisponible()) {
            return false;
        }

        maquina.setDisponible(true);

        return true;
    }

    public int getCantidadMaquinas() {
        return maquinas.size();
    }

    public double getDineroAcumulado() {
        return dineroAcumulado;
    }

    public int contarDisponiblesPorCategoria(String categoria) {

        int contador = 0;

        for (Maquina maquina : maquinas) {

            if (maquina.getDisponible()) {

                if (categoria.equals("Palomitas")
                        && maquina instanceof MaquinaPalomitas) {
                    contador++;
                }

                if (categoria.equals("Algodon")
                        && maquina instanceof MaquinaAlgodon) {
                    contador++;
                }

                if (categoria.equals("Chocolate")
                        && maquina instanceof FuenteChocolate) {
                    contador++;
                }
            }
        }

        return contador;
    }

    public int contarAlquiladasPorCategoria(String categoria) {

        int contador = 0;

        for (Maquina maquina : maquinas) {

            if (!maquina.getDisponible()) {

                if (categoria.equals("Palomitas")
                        && maquina instanceof MaquinaPalomitas) {
                    contador++;
                }

                if (categoria.equals("Algodon")
                        && maquina instanceof MaquinaAlgodon) {
                    contador++;
                }

                if (categoria.equals("Chocolate")
                        && maquina instanceof FuenteChocolate) {
                    contador++;
                }
            }
        }

        return contador;
    }

    public String consultarInventario() {

        if (maquinas.isEmpty()) {
            return "No hay maquinas registradas";
        }

        String informacion = "";

        for (Maquina maquina : maquinas) {
            informacion = informacion + "\n--------------------\n";
            informacion = informacion + maquina.toString() + "\n";
        }

        return informacion;
    }
}