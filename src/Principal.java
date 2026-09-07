import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("- AGENCIA DE DETECTIVES -");

        System.out.println("Ingrese el nombre del caso:");
        String nombreCaso = teclado.nextLine();

        System.out.println("Ingrese el codigo de identificacion:");
        String codigoIdentificacion = teclado.nextLine();

        System.out.println("Ingrese el nombre del detective responsable:");
        String detectiveResponsable = teclado.nextLine();

        Caso caso = new Caso(nombreCaso, codigoIdentificacion, detectiveResponsable);

        int opcion = 0;

        while (opcion != 12) {

            try {

                System.out.println("\n- MENU PRINCIPAL -");
                System.out.println("1. Registrar ubicacion");
                System.out.println("2. Consultar ubicaciones");
                System.out.println("3. Consultar una ubicacion");
                System.out.println("4. Modificar ubicacion");
                System.out.println("5. Descartar ubicacion");
                System.out.println("6. Registrar pista");
                System.out.println("7. Consultar pistas");
                System.out.println("8. Buscar pista");
                System.out.println("9. Modificar pista");
                System.out.println("10. Eliminar pista");
                System.out.println("11. Mostrar estadisticas");
                System.out.println("12. Salir");
                System.out.println("Ingrese una opcion:");

                opcion = teclado.nextInt();
                teclado.nextLine();

                switch (opcion) {

                    case 1: {

                        System.out.println("Ingrese la posicion de la ubicacion (0-4):");
                        int posicion = teclado.nextInt();
                        teclado.nextLine();

                        System.out.println("Ingrese el codigo de la ubicacion:");
                        String codigo = teclado.nextLine();

                        System.out.println("Ingrese el nombre de la ubicacion:");
                        String nombre = teclado.nextLine();

                        System.out.println("Ingrese la direccion:");
                        String direccion = teclado.nextLine();

                        System.out.println("Ingrese el nivel de riesgo (1-10):");
                        int nivelRiesgo = teclado.nextInt();
                        teclado.nextLine();

                        System.out.println("Ingrese el estado:");
                        String estado = teclado.nextLine();

                        Ubicacion ubicacion = new Ubicacion(
                            codigo,
                            nombre,
                            direccion,
                            nivelRiesgo,
                            estado
                        );

                        caso.registrarUbicacion(posicion, ubicacion);

                        System.out.println("Ubicacion registrada correctamente.");

                        break;
                    }

                    case 2: {

                        System.out.println(caso.consultarUbicaciones());

                        break;
                    }

                    case 3: {

                        System.out.println("Ingrese la posicion de la ubicacion:");
                        int posicion = teclado.nextInt();
                        teclado.nextLine();

                        Ubicacion ubicacion = caso.consultarUbicacion(posicion);

                        if (ubicacion != null) {
                            System.out.println(ubicacion);
                        } else {
                            System.out.println("No hay una ubicacion en esa posicion.");
                        }

                        break;
                    }

                    case 4: {

                        System.out.println("Ingrese la posicion de la ubicacion:");
                        int posicion = teclado.nextInt();
                        teclado.nextLine();

                        Ubicacion ubicacion = caso.consultarUbicacion(posicion);

                        if (ubicacion != null) {

                            System.out.println("Ingrese el nuevo nivel de riesgo (1-10):");
                            int nivelRiesgo = teclado.nextInt();
                            teclado.nextLine();

                            System.out.println("Ingrese el nuevo estado:");
                            String estado = teclado.nextLine();

                            caso.modificarUbicacion(posicion, nivelRiesgo, estado);

                            System.out.println("Ubicacion modificada correctamente.");

                        } else {
                            System.out.println("No hay una ubicacion en esa posicion.");
                        }

                        break;
                    }

                    case 5: {

                        System.out.println("Ingrese la posicion de la ubicacion:");
                        int posicion = teclado.nextInt();
                        teclado.nextLine();

                        Ubicacion ubicacion = caso.consultarUbicacion(posicion);

                        if (ubicacion != null) {
                            caso.descartarUbicacion(posicion);
                            System.out.println("Ubicacion descartada correctamente.");
                        } else {
                            System.out.println("No hay una ubicacion en esa posicion.");
                        }

                        break;
                    }

                    case 6: {

                        System.out.println("Ingrese el codigo de la pista:");
                        String codigo = teclado.nextLine();

                        Pista existente = caso.buscarPista(codigo);

                        if (existente == null) {

                            System.out.println("Ingrese la descripcion:");
                            String descripcion = teclado.nextLine();

                            System.out.println("Ingrese el tipo de evidencia:");
                            String tipoEvidencia = teclado.nextLine();

                            System.out.println("Ingrese el nivel de importancia (1-10):");
                            int nivelImportancia = teclado.nextInt();

                            System.out.println("Ingrese el nivel de confiabilidad (0-100):");
                            int nivelConfiabilidad = teclado.nextInt();
                            teclado.nextLine();

                            Pista pista = new Pista(
                                codigo,
                                descripcion,
                                tipoEvidencia,
                                nivelImportancia,
                                nivelConfiabilidad
                            );

                            caso.registrarPista(pista);

                            System.out.println("Pista registrada correctamente.");

                        } else {
                            System.out.println("Ya existe una pista con ese codigo.");
                        }

                        break;
                    }

                    case 7: {

                        if (caso.contarPistas() > 0) {
                            System.out.println(caso.consultarPistas());
                        } else {
                            System.out.println("No hay pistas registradas.");
                        }

                        break;
                    }

                    case 8: {

                        System.out.println("Ingrese el codigo de la pista:");
                        String codigo = teclado.nextLine();

                        Pista pista = caso.buscarPista(codigo);

                        if (pista != null) {
                            System.out.println(pista);
                        } else {
                            System.out.println("No se encontro la pista.");
                        }

                        break;
                    }

                    case 9: {

                        System.out.println("Ingrese el codigo de la pista que desea modificar:");
                        String codigo = teclado.nextLine();

                        Pista pista = caso.buscarPista(codigo);

                        if (pista != null) {

                            System.out.println("Ingrese la nueva descripcion:");
                            String descripcion = teclado.nextLine();

                            System.out.println("Ingrese el nuevo tipo de evidencia:");
                            String tipoEvidencia = teclado.nextLine();

                            System.out.println("Ingrese el nuevo nivel de importancia (1-10):");
                            int nivelImportancia = teclado.nextInt();

                            System.out.println("Ingrese el nuevo nivel de confiabilidad (0-100):");
                            int nivelConfiabilidad = teclado.nextInt();
                            teclado.nextLine();

                            caso.modificarPista(
                                codigo,
                                descripcion,
                                tipoEvidencia,
                                nivelImportancia,
                                nivelConfiabilidad
                            );

                            System.out.println("Pista modificada correctamente.");

                        } else {
                            System.out.println("No se encontro la pista.");
                        }

                        break;
                    }

                    case 10: {

                        System.out.println("Ingrese el codigo de la pista que desea eliminar:");
                        String codigo = teclado.nextLine();

                        Pista pista = caso.buscarPista(codigo);

                        if (pista != null) {
                            caso.eliminarPista(codigo);
                            System.out.println("Pista eliminada correctamente.");
                        } else {
                            System.out.println("No se encontro la pista.");
                        }

                        break;
                    }

                    case 11: {

                        System.out.println("- ESTADISTICAS -");

                        System.out.println(
                            "Cantidad de ubicaciones registradas: "
                            + caso.contarUbicaciones()
                        );

                        System.out.println(
                            "Espacios disponibles: "
                            + caso.contarEspaciosDisponibles()
                        );

                        Ubicacion mayorRiesgo = caso.ubicacionMayorRiesgo();

                        if (mayorRiesgo != null) {
                            System.out.println(
                                "Ubicacion con mayor riesgo: " + mayorRiesgo
                            );
                        } else {
                            System.out.println("No hay ubicaciones registradas.");
                        }

                        System.out.println(
                            "Cantidad de pistas registradas: "
                            + caso.contarPistas()
                        );

                        if (caso.contarPistas() > 0) {

                            System.out.println(
                                "Pista con mayor importancia: "
                                + caso.pistaMayorImportancia()
                            );

                            System.out.println(
                                "Pista con mayor confiabilidad: "
                                + caso.pistaMayorConfiabilidad()
                            );

                            System.out.println(
                                "Promedio del nivel de importancia: "
                                + caso.promedioImportancia()
                            );

                        } else {
                            System.out.println(
                                "No hay pistas registradas para realizar los calculos."
                            );
                        }

                        break;
                    }

                    case 12: {

                        System.out.println("Saldras del programa.");

                        break;
                    }

                    default: {

                        System.out.println("Opcion no valida.");

                        break;
                    }
                }

            } catch (InputMismatchException e) {

                System.out.println("Error. Ingresa un numero valido.");
                teclado.nextLine();

            } catch (IllegalArgumentException e) {

                System.out.println("Error: " + e.getMessage());

            } finally {

                if (opcion != 12) {
                    System.out.println(
                        "Operacion finalizada, regresaras al menu principal."
                    );
                }
            }
        }

        teclado.close();
    }
}