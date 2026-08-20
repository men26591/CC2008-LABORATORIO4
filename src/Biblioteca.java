import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List<Prestamo> prestamos;

    public Biblioteca() {
        prestamos = new ArrayList<Prestamo>();
    }

    public void agregarPrestamo(Prestamo prestamo) {
        prestamos.add(prestamo);
    }

    public Prestamo buscarPrestamo(String codigo) {
        Prestamo encontrado = null;

        for (int i = 0; i < prestamos.size(); i++) {
            if (prestamos.get(i).getCodigoPrestamo().equals(codigo)) {
                encontrado = prestamos.get(i);
                i = prestamos.size();
            }
        }

        return encontrado;
    }

    public void mostrarPrestamos() {
        for (int i = 0; i < prestamos.size(); i++) {
            Prestamo prestamo = prestamos.get(i);

            System.out.println("Codigo de prestamo: " + prestamo.getCodigoPrestamo());
            System.out.println("Carne: " + prestamo.getCarne());
            System.out.println("Nombre del estudiante: " + prestamo.getNombreEstudiante());
            System.out.println("Titulo del libro: " + prestamo.getTituloLibro());
            System.out.println("Dias autorizados: " + prestamo.getDiasAutorizados());
        }
    }

    public boolean modificarPrestamo(String codigo, String titulo, int dias) {
        Prestamo prestamo = buscarPrestamo(codigo);

        if (prestamo != null) {
            prestamo.setTituloLibro(titulo);
            prestamo.setDiasAutorizados(dias);
            return true;
        } else {
            return false;
        }
    }

    public boolean eliminarPrestamo(String codigo) {
        Prestamo prestamo = buscarPrestamo(codigo);

        if (prestamo != null) {
            prestamos.remove(prestamo);
            return true;
        } else {
            return false;
        }
    }

    public void buscarPorCarne(String carne) {
        for (int i = 0; i < prestamos.size(); i++) {
            Prestamo prestamo = prestamos.get(i);

            if (prestamo.getCarne().equals(carne)) {
                System.out.println("Codigo de prestamo: " + prestamo.getCodigoPrestamo());
                System.out.println("Nombre del estudiante: " + prestamo.getNombreEstudiante());
                System.out.println("Titulo del libro: " + prestamo.getTituloLibro());
                System.out.println("Dias autorizados: " + prestamo.getDiasAutorizados());
            }
        }
    }

    public int calcularTotalDias() {
        int total = 0;

        for (int i = 0; i < prestamos.size(); i++) {
            total = total + prestamos.get(i).getDiasAutorizados();
        }

        return total;
    }

    public Prestamo prestamoMayorDias() {
        Prestamo mayor = null;

        if (prestamos.size() > 0) {
            mayor = prestamos.get(0);

            for (int i = 1; i < prestamos.size(); i++) {
                if (prestamos.get(i).getDiasAutorizados() > mayor.getDiasAutorizados()) {
                    mayor = prestamos.get(i);
                }
            }
        }

        return mayor;
    }

    public int cantidadPrestamos() {
        return prestamos.size();
    }
}