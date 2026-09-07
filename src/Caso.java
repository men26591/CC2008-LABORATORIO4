import java.util.ArrayList;

public class Caso {

    private String nombreCaso;
    private String codigoIdentificacion;
    private String detectiveResponsable;
    private Ubicacion[] ubicaciones;
    private ArrayList<Pista> pistas;

    public Caso(String nombreCaso, String codigoIdentificacion, String detectiveResponsable) {
        this.nombreCaso = nombreCaso;
        this.codigoIdentificacion = codigoIdentificacion;
        this.detectiveResponsable = detectiveResponsable;

        ubicaciones = new Ubicacion[5];
        pistas = new ArrayList<Pista>();
    }

    public String getNombreCaso() {
        return nombreCaso;
    }

    public String getCodigoIdentificacion() {
        return codigoIdentificacion;
    }

    public String getDetectiveResponsable() {
        return detectiveResponsable;
    }


    // UBICACIONES

    public void registrarUbicacion(int posicion, Ubicacion ubicacion) {

        if (posicion < 0 || posicion >= ubicaciones.length) {
            throw new IllegalArgumentException("La posicion no es valida.");
        }

        if (ubicaciones[posicion] != null) {
            throw new IllegalArgumentException("La posicion ya esta ocupada.");
        }

        if (ubicacion == null) {
            throw new IllegalArgumentException("La ubicacion no es valida.");
        }

        ubicaciones[posicion] = ubicacion;
    }

    public String consultarUbicaciones() {

        String informacion = "";

        for (int i = 0; i < ubicaciones.length; i++) {

            if (ubicaciones[i] != null) {
                informacion = informacion + "Posicion " + i + ": "
                        + ubicaciones[i].toString() + "\n";
            }
        }

        if (informacion.equals("")) {
            informacion = "No hay ubicaciones registradas.";
        }

        return informacion;
    }

    public Ubicacion consultarUbicacion(int posicion) {

        Ubicacion encontrada = null;

        if (posicion < 0 || posicion >= ubicaciones.length) {
            throw new IllegalArgumentException("La posicion no es valida.");
        }

        if (ubicaciones[posicion] != null) {
            encontrada = ubicaciones[posicion];
        }

        return encontrada;
    }

    public void modificarUbicacion(int posicion, int nivelRiesgo, String estado) {

        if (posicion < 0 || posicion >= ubicaciones.length) {
            throw new IllegalArgumentException("La posicion no es valida.");
        }

        if (ubicaciones[posicion] == null) {
            throw new IllegalArgumentException(
                "No hay una ubicacion en esa posicion."
            );
        }

        if (nivelRiesgo < 1 || nivelRiesgo > 10) {
            throw new IllegalArgumentException(
                "El nivel de riesgo debe estar entre 1 y 10."
            );
        }

        ubicaciones[posicion].setNivelRiesgo(nivelRiesgo);
        ubicaciones[posicion].setEstado(estado);
    }

    public void descartarUbicacion(int posicion) {

        if (posicion < 0 || posicion >= ubicaciones.length) {
            throw new IllegalArgumentException("La posicion no es valida.");
        }

        if (ubicaciones[posicion] == null) {
            throw new IllegalArgumentException(
                "No hay una ubicacion en esa posicion."
            );
        }

        ubicaciones[posicion] = null;
    }

    public int contarUbicaciones() {

        int cantidad = 0;

        for (int i = 0; i < ubicaciones.length; i++) {

            if (ubicaciones[i] != null) {
                cantidad++;
            }
        }

        return cantidad;
    }

    public int contarEspaciosDisponibles() {

        int cantidad = 0;

        for (int i = 0; i < ubicaciones.length; i++) {

            if (ubicaciones[i] == null) {
                cantidad++;
            }
        }

        return cantidad;
    }

    public Ubicacion ubicacionMayorRiesgo() {

        Ubicacion mayor = null;

        for (int i = 0; i < ubicaciones.length; i++) {

            if (ubicaciones[i] != null) {

                if (mayor == null) {
                    mayor = ubicaciones[i];

                } else if (ubicaciones[i].getNivelRiesgo()
                        > mayor.getNivelRiesgo()) {

                    mayor = ubicaciones[i];
                }
            }
        }

        return mayor;
    }


    // PISTAS

    public void registrarPista(Pista pista) {

        if (pista == null) {
            throw new IllegalArgumentException("La pista no es valida.");
        }

        Pista existente = buscarPista(pista.getCodigo());

        if (existente == null) {
            pistas.add(pista);

        } else {
            throw new IllegalArgumentException(
                "Ya existe una pista con ese codigo."
            );
        }
    }

    public String consultarPistas() {

        String informacion = "";

        for (int i = 0; i < pistas.size(); i++) {

            Pista pista = pistas.get(i);

            informacion = informacion + pista.toString() + "\n";
        }

        if (informacion.equals("")) {
            informacion = "No hay pistas registradas.";
        }

        return informacion;
    }

    public Pista buscarPista(String codigo) {

        Pista encontrada = null;

        for (int i = 0; i < pistas.size(); i++) {

            if (pistas.get(i).getCodigo().equals(codigo)) {

                encontrada = pistas.get(i);
                i = pistas.size();
            }
        }

        return encontrada;
    }

    public boolean modificarPista(String codigo, String descripcion,
                                  String tipoEvidencia,
                                  int nivelImportancia,
                                  int nivelConfiabilidad) {

        Pista pista = buscarPista(codigo);

        if (pista != null) {

            if (nivelImportancia < 1 || nivelImportancia > 10) {
                throw new IllegalArgumentException(
                    "El nivel de importancia debe estar entre 1 y 10."
                );
            }

            if (nivelConfiabilidad < 0 || nivelConfiabilidad > 100) {
                throw new IllegalArgumentException(
                    "El nivel de confiabilidad debe estar entre 0 y 100."
                );
            }

            pista.setDescripcion(descripcion);
            pista.setTipoEvidencia(tipoEvidencia);
            pista.setNivelImportancia(nivelImportancia);
            pista.setNivelConfiabilidad(nivelConfiabilidad);

            return true;

        } else {
            return false;
        }
    }

    public boolean eliminarPista(String codigo) {

        Pista pista = buscarPista(codigo);

        if (pista != null) {

            pistas.remove(pista);
            return true;

        } else {
            return false;
        }
    }

    public int contarPistas() {
        return pistas.size();
    }

    public Pista pistaMayorImportancia() {

        Pista mayor = null;

        if (pistas.size() > 0) {

            mayor = pistas.get(0);

            for (int i = 1; i < pistas.size(); i++) {

                if (pistas.get(i).getNivelImportancia()
                        > mayor.getNivelImportancia()) {

                    mayor = pistas.get(i);
                }
            }
        }

        return mayor;
    }

    public Pista pistaMayorConfiabilidad() {

        Pista mayor = null;

        if (pistas.size() > 0) {

            mayor = pistas.get(0);

            for (int i = 1; i < pistas.size(); i++) {

                if (pistas.get(i).getNivelConfiabilidad()
                        > mayor.getNivelConfiabilidad()) {

                    mayor = pistas.get(i);
                }
            }
        }

        return mayor;
    }

    public double promedioImportancia() {

        int suma = 0;
        double promedio = 0;

        if (pistas.size() > 0) {

            for (int i = 0; i < pistas.size(); i++) {
                suma = suma + pistas.get(i).getNivelImportancia();
            }

            promedio = (double) suma / pistas.size();
        }

        return promedio;
    }
}