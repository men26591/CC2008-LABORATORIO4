public class Usuario {

    private String nombre;
    private String nombreUsuario;
    private int edad;
    private int[] calificaciones;
    private int cantidadCalificaciones;

    public Usuario(String nombre, String nombreUsuario, int edad) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.edad = edad;
        calificaciones = new int[10];  
        cantidadCalificaciones = 0;
    }

    public boolean registrarCalificacion(int calificacion){
        if (calificacion >= 1 && calificacion<= 10 && cantidadCalificaciones < 10) {
            calificaciones[cantidadCalificaciones] = calificacion;
            cantidadCalificaciones++;
            return true;
        }
        else {
            return false;
        }
    }

    public String consultarCalificaciones() {

        String cadena = "";

        for (int i = 0; i < cantidadCalificaciones; i++) {
            cadena = cadena + "Pelicula " + (i + 1) + ": " + calificaciones[i] + "\n";
        }

        return cadena;
    }

    public int consultarPelicula(int numeroPelicula) {

        if (numeroPelicula >= 1 && numeroPelicula <= cantidadCalificaciones) {
            return calificaciones[numeroPelicula - 1];
        }
        else {
            return -1;
        }
    }

    public boolean modificarCalificacion(int numeroPelicula, int nuevaCalificacion) {

        if (numeroPelicula >= 1 && numeroPelicula <= cantidadCalificaciones) {

            if (nuevaCalificacion >= 1 && nuevaCalificacion <= 10) {
                calificaciones[numeroPelicula - 1] = nuevaCalificacion;
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }

    public float calcularPromedio() {

        float suma = 0;

        if (cantidadCalificaciones == 0) {
            return 0;
        }

        for (int i = 0; i < cantidadCalificaciones; i++) {
            suma = suma + calificaciones[i];
        }

        return suma / cantidadCalificaciones;
    }

    public int obtenerMayorCalificacion() {

        if (cantidadCalificaciones == 0) {
            return 0;
        }

        int mayor = calificaciones[0];

        for (int i = 1; i < cantidadCalificaciones; i++) {

            if (calificaciones[i] > mayor) {
                mayor = calificaciones[i];
            }
        }

        return mayor;
    }

    public int obtenerMenorCalificacion() {

        if (cantidadCalificaciones == 0) {
            return 0;
        }

        int menor = calificaciones[0];

        for (int i = 1; i < cantidadCalificaciones; i++) {

            if (calificaciones[i] < menor) {
                menor = calificaciones[i];
            }
        }

        return menor;
    }

    public int getCantidadCalificaciones() {
        return cantidadCalificaciones;
    }

    public int espaciosDisponibles() {
        return 10 - cantidadCalificaciones;
    }
}
