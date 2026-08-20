import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        int opcion = 0;

        while (opcion != 10) {

            try {
                System.out.println("\n- BIBLIOTECA -");
                System.out.println("1. Registrar prestamo");
                System.out.println("2. Consultar prestamos");
                System.out.println("3. Buscar prestamo");
                System.out.println("4. Modificar prestamo");
                System.out.println("5. Registrar devolucion");
                System.out.println("6. Consultar prestamos por estudiante");
                System.out.println("7. Reporte de dias autorizados");
                System.out.println("8. Prestamo con mayor duracion");
                System.out.println("9. Cantidad de prestamos");
                System.out.println("10. Salir");
                System.out.println("Ingrese una opcion: ");

                opcion = teclado.nextInt();
                teclado.nextLine();

                switch (opcion) {

                    case 1: {
                        System.out.println("Ingrese el codigo del prestamo:");
                        String codigo = teclado.nextLine();

                        Prestamo existente = biblioteca.buscarPrestamo(codigo);

                        if (existente == null) {

                            System.out.println("Ingresa el carne del estudiante:");
                            String carne = teclado.nextLine();

                            System.out.println("Ingresa el nombre del estudiante:");
                            String nombre = teclado.nextLine();

                            System.out.println("Ingresa el titulo del libro:");
                            String titulo = teclado.nextLine();

                            System.out.println("Ingresa los dias autorizados:");
                            int dias = teclado.nextInt();
                            teclado.nextLine();

                            if (dias > 0) {
                                Prestamo prestamo = new Prestamo(codigo, carne, nombre, titulo, dias);
                                biblioteca.agregarPrestamo(prestamo);

                                System.out.println("Se registró el prestamo.");
                            } else {
                                System.out.println("Los dias deben ser mayores a 0.");
                            }

                        } else {
                            System.out.println("Ya existe un prestamo con ese codigo.");
                        }

                        break;
                    }

                    case 2: {
                        if (biblioteca.cantidadPrestamos() > 0) {
                            biblioteca.mostrarPrestamos();
                        } else {
                            System.out.println("No hay prestamos registrados.");
                        }

                        break;
                    }

                    case 3: {
                        System.out.println("Ingrese el codigo del prestamo:");
                        String codigo = teclado.nextLine();

                        Prestamo prestamo = biblioteca.buscarPrestamo(codigo);

                        if (prestamo != null) {
                            System.out.println("Codigo: " + prestamo.getCodigoPrestamo());
                            System.out.println("Carne: " + prestamo.getCarne());
                            System.out.println("Nombre: " + prestamo.getNombreEstudiante());
                            System.out.println("Titulo: " + prestamo.getTituloLibro());
                            System.out.println("Dias autorizados: " + prestamo.getDiasAutorizados());
                        } else {
                            System.out.println("No se encontro el prestamo.");
                        }

                        break;
                    }

                    case 4: {
                        System.out.println("Ingresa el codigo del prestamo que desea modificar:");
                        String codigo = teclado.nextLine();

                        Prestamo prestamo = biblioteca.buscarPrestamo(codigo);

                        if (prestamo != null) {

                            System.out.println("Ingresa el nuevo titulo del libro:");
                            String titulo = teclado.nextLine();

                            System.out.println("Ingresa la nueva cantidad de dias autorizados:");
                            int dias = teclado.nextInt();
                            teclado.nextLine();

                            if (dias > 0) {
                                biblioteca.modificarPrestamo(codigo, titulo, dias);
                                System.out.println("Prestamo modificado correctamente.");
                            } else {
                                System.out.println("Los dias deben ser mayores a 0.");
                            }

                        } else {
                            System.out.println("No se encontro el prestamo.");
                        }

                        break;
                    }

                    case 5: {
                        System.out.println("Ingresa el codigo del prestamo que desea devolver:");
                        String codigo = teclado.nextLine();

                        boolean eliminado = biblioteca.eliminarPrestamo(codigo);

                        if (eliminado == true) {
                            System.out.println("Devolucion registrada correctamente.");
                        } else {
                            System.out.println("No se encontro el prestamo.");
                        }

                        break;
                    }

                    case 6: {
                        System.out.println("Ingresa el carne del estudiante:");
                        String carne = teclado.nextLine();

                        biblioteca.buscarPorCarne(carne);

                        break;
                    }

                    case 7: {
                        int totalDias = biblioteca.calcularTotalDias();

                        System.out.println("Total de dias autorizados: " + totalDias);

                        break;
                    }

                    case 8: {
                        Prestamo mayor = biblioteca.prestamoMayorDias();

                        if (mayor != null) {
                            System.out.println("Prestamo con mayor duracion:");
                            System.out.println("Codigo: " + mayor.getCodigoPrestamo());
                            System.out.println("Carne: " + mayor.getCarne());
                            System.out.println("Nombre: " + mayor.getNombreEstudiante());
                            System.out.println("Titulo: " + mayor.getTituloLibro());
                            System.out.println("Dias autorizados: " + mayor.getDiasAutorizados());
                        } else {
                            System.out.println("No hay prestamos registrados.");
                        }

                        break;
                    }

                    case 9: {
                        System.out.println("Cantidad de prestamos: " + biblioteca.cantidadPrestamos());

                        break;
                    }

                    case 10: {
                        System.out.println("Saldrás del programa");
                        break;
                    }

                    default: {
                        System.out.println("Opcion no válida.");
                        break;
                    }
                }

            } catch (Exception e) {
                System.out.println("Error. Ingresa un dato valido.");
                teclado.nextLine();

            } finally {
                if (opcion != 10) {
                    System.out.println("Operación finalizada, regrresarás al menu principal.");
                }
            }
        }

        teclado.close();
    }
}