import java.text.DecimalFormat;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        DecimalFormat formato = new DecimalFormat("0.00");

        System.out.println("Ingresa tu nombre: ");
        String nombre = teclado.nextLine();

        System.out.println("Ingresa el nombre de usuario: ");
        String nombreUsuario = teclado.nextLine();

        System.out.println("Ingresa tu edad: ");
        int edad = teclado.nextInt();
        teclado.nextLine();

        Usuario usuario = new Usuario(nombre, nombreUsuario, edad);

        int opcion = 0;

        while (opcion != 9) {

            System.out.println("\n--- Calificación a películas :) ---");
            System.out.println("\n1. Nuevo usuario");
            System.out.println("2. Registrar nueva calificacion");
            System.out.println("3. Consultar calificaciones");
            System.out.println("4. Consultar una pelicula");
            System.out.println("5. Modificar calificacion");
            System.out.println("6. Mostrar promedio");
            System.out.println("7. Mostrar mejor y peor calificacion");
            System.out.println("8. Consultar espacios disponibles");
            System.out.println("9. Salir");
            System.out.println("Ingresa una opcion: ");

            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {

                case 1:

                    System.out.println("Ingresa el nuevo nombre: ");
                    nombre = teclado.nextLine();

                    System.out.println("Ingresa el nuevo nombre de usuario: ");
                    nombreUsuario = teclado.nextLine();

                    System.out.println("Ingresa la nueva edad: ");
                    edad = teclado.nextInt();
                    teclado.nextLine();

                    usuario = new Usuario(nombre, nombreUsuario, edad);

                    System.out.println("Nuevo usuario creado.");
                    break;

                case 2:

                    System.out.println("Ingrese una calificacion entre 1 y 10: ");
                    int calificacion = teclado.nextInt();
                    teclado.nextLine();

                    boolean registrado = usuario.registrarCalificacion(calificacion);

                    if (registrado == true) {
                        System.out.println("Calificacion registrada.");
                    }
                    else {
                        System.out.println("No se pudo registrar la calificacion.");
                        System.out.println("1. Verifica que la calificación sea entre 1 y 10.");
                        System.out.println("2. Verifica que exista un espacio.");
                    }

                    break;

                case 3:

                    if (usuario.getCantidadCalificaciones() == 0) {
                        System.out.println("No hay peliculas calificadas.");
                    }
                    else {
                        System.out.println("Calificaciones registradas:");
                        System.out.println(usuario.consultarCalificaciones());
                    }

                    break;

                case 4:

                    System.out.println("Ingresa el numero de pelicula: ");
                    int numeroPelicula = teclado.nextInt();
                    teclado.nextLine();

                    int nota = usuario.consultarPelicula(numeroPelicula);

                    if (nota == -1) {
                        System.out.println("La pelicula indicada no ha sido registrada.");
                    }
                    else {
                        System.out.println("La pelicula " + numeroPelicula
                                + " tiene una calificacion de " + nota);
                    }

                    break;

                case 5:

                    System.out.println("Ingresa el numero de pelicula que desea modificar: ");
                    numeroPelicula = teclado.nextInt();

                    System.out.println("Ingresa la nueva calificacion entre 1 y 10: ");
                    int nuevaCalificacion = teclado.nextInt();
                    teclado.nextLine();

                    boolean modificado = usuario.modificarCalificacion(
                            numeroPelicula, nuevaCalificacion);

                    if (modificado == true) {
                        System.out.println("Calificacion modificada.");
                    }
                    else {
                        System.out.println("No se pudo modificar la calificacion.");
                        System.out.println("Verifica el numero de pelicula y la calificacion.");
                    }

                    break;

                case 6:

                    if (usuario.getCantidadCalificaciones() == 0) {
                        System.out.println("No hay calificaciones para calcular el promedio.");
                    }
                    else {
                        float promedio = usuario.calcularPromedio();

                        System.out.println("El promedio de las calificaciones es: "
                                + formato.format(promedio));
                    }

                    break;

                case 7:

                    if (usuario.getCantidadCalificaciones() == 0) {
                        System.out.println("No hay ninguna calificación registrada.");
                    }
                    else {
                        int mayor = usuario.obtenerMayorCalificacion();
                        int menor = usuario.obtenerMenorCalificacion();

                        System.out.println("La mejor calificacion es: " + mayor);
                        System.out.println("La peor calificacion es: " + menor);
                    }

                    break;

                case 8:

                    System.out.println("Peliculas calificadas: "
                            + usuario.getCantidadCalificaciones());

                    System.out.println("Espacios disponibles: "
                            + usuario.espaciosDisponibles());

                    break;

                case 9:

                    System.out.println("Saliste del programa.");
                    break;

                default:

                    System.out.println("Opcion invalida.");
                    break;
            }
        }

        teclado.close();
    }
}