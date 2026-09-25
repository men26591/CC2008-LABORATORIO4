import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        DulceEstacion dulceEstacion = new DulceEstacion();

        dulceEstacion.registrarMaquina(
            new MaquinaPalomitas("P001", "PopStar", "P100",
                    100, 80, true)
        );

        dulceEstacion.registrarMaquina(
            new MaquinaPalomitas("P002", "PopStar", "P200",
                    90, 60, false)
        );

        dulceEstacion.registrarMaquina(
            new MaquinaAlgodon("A001", "DulceMax", "A100",
                    120, 1200)
        );

        dulceEstacion.registrarMaquina(
            new MaquinaAlgodon("A002", "DulceMax", "A200",
                    110, 900)
        );

        dulceEstacion.registrarMaquina(
            new FuenteChocolate("C001", "ChocoMax", "C100",
                    150, 2.5)
        );

        dulceEstacion.registrarMaquina(
            new FuenteChocolate("C002", "ChocoMax", "C200",
                    180, 4.0)
        );

        int opcion = 0;

        while (opcion != 7) {

            try {

                System.out.println("\n - DULCE ESTACIÓN - ");
                System.out.println("1. Registrar maquina");
                System.out.println("2. Consultar inventario");
                System.out.println("3. Cotizar alquiler");
                System.out.println("4. Alquilar maquina");
                System.out.println("5. Registrar devolucion");
                System.out.println("6. Reporte general");
                System.out.println("7. Salir");
                System.out.print("Seleccione una opcion: ");

                opcion = teclado.nextInt();
                teclado.nextLine();

                switch (opcion) {

                    case 1:

                        System.out.println("\n = REGISTRAR MAQUINA =");
                        System.out.println("1. Maquina de palomitas");
                        System.out.println("2. Maquina de algodon");
                        System.out.println("3. Fuente de chocolate");
                        System.out.print("Seleccione el tipo: ");

                        int tipo = teclado.nextInt();
                        teclado.nextLine();

                        System.out.print("Codigo de inventario: ");
                        String codigo = teclado.nextLine();

                        if (codigo.isEmpty()) {
                            System.out.println(
                                "El codigo no puede estar vacio"
                            );
                            break;
                        }

                        if (dulceEstacion.buscarMaquina(codigo) != null) {
                            System.out.println(
                                "Ya existe una maquina con ese codigo"
                            );
                            break;
                        }

                        System.out.print("Marca: ");
                        String marca = teclado.nextLine();

                        System.out.print("Modelo: ");
                        String modelo = teclado.nextLine();

                        System.out.print("Tarifa diaria: Q");
                        double tarifa = teclado.nextDouble();

                        if (tarifa <= 0) {
                            System.out.println(
                                "La tarifa debe ser mayor que cero"
                            );
                            break;
                        }

                        if (tipo == 1) {

                            System.out.print("Porciones por hora: ");
                            int porciones = teclado.nextInt();

                            if (porciones <= 0) {
                                System.out.println(
                                    "Las porciones deben ser mayores que cero"
                                );
                                break;
                            }

                            System.out.println("¿Tiene carrito integrado?");
                            System.out.println("1. Si");
                            System.out.println("2. No");
                            int carrito = teclado.nextInt();

                            boolean tieneCarrito;

                            if (carrito == 1) {
                                tieneCarrito = true;
                            } else if (carrito == 2) {
                                tieneCarrito = false;
                            } else {
                                System.out.println(
                                    "Opcion de carrito no valida"
                                );
                                break;
                            }

                            MaquinaPalomitas nueva =
                                new MaquinaPalomitas(
                                    codigo,
                                    marca,
                                    modelo,
                                    tarifa,
                                    porciones,
                                    tieneCarrito
                                );

                            dulceEstacion.registrarMaquina(nueva);

                            System.out.println(
                                "Maquina registrada correctamente"
                            );

                        } else if (tipo == 2) {

                            System.out.print("Potencia en vatios: ");
                            int potencia = teclado.nextInt();

                            if (potencia <= 0) {
                                System.out.println(
                                    "La potencia debe ser mayor que cero"
                                );
                                break;
                            }

                            MaquinaAlgodon nueva =
                                new MaquinaAlgodon(
                                    codigo,
                                    marca,
                                    modelo,
                                    tarifa,
                                    potencia
                                );

                            dulceEstacion.registrarMaquina(nueva);

                            System.out.println(
                                "Maquina registrada correctamente"
                            );

                        } else if (tipo == 3) {

                            System.out.print(
                                "Capacidad maxima en kilogramos: "
                            );
                            double capacidad = teclado.nextDouble();

                            if (capacidad <= 0) {
                                System.out.println(
                                    "La capacidad debe ser mayor que cero"
                                );
                                break;
                            }

                            FuenteChocolate nueva =
                                new FuenteChocolate(
                                    codigo,
                                    marca,
                                    modelo,
                                    tarifa,
                                    capacidad
                                );

                            dulceEstacion.registrarMaquina(nueva);

                            System.out.println(
                                "Fuente registrada correctamente"
                            );

                        } else {
                            System.out.println(
                                "Tipo de maquina no valido"
                            );
                        }

                        break;

                    case 2:

                        System.out.println("\n- INVENTARIO -");
                        System.out.println(
                            dulceEstacion.consultarInventario()
                        );

                        break;

                    case 3:

                        System.out.println("\n- COTIZACION -");

                        System.out.print(
                            "Ingrese el codigo de la maquina: "
                        );
                        String codigoCotizar = teclado.nextLine();

                        Maquina maquinaCotizar =
                            dulceEstacion.buscarMaquina(codigoCotizar);

                        if (maquinaCotizar == null) {
                            System.out.println(
                                "No existe una maquina con ese codigo"
                            );
                            break;
                        }

                        System.out.print(
                            "Ingrese la cantidad de dias: "
                        );
                        int diasCotizar = teclado.nextInt();
                        teclado.nextLine();

                        if (diasCotizar <= 0) {
                            System.out.println(
                                "Los dias deben ser mayores que cero"
                            );
                            break;
                        }

                        double cotizacion =
                            dulceEstacion.cotizar(
                                codigoCotizar,
                                diasCotizar
                            );

                        System.out.println("\nDatos de la maquina:");
                        System.out.println(maquinaCotizar);

                        System.out.printf(
                            "Costo total: Q%.2f%n",
                            cotizacion
                        );

                        System.out.println(
                            "Esta cotizacion no modifica los ingresos."
                        );

                        break;

                    case 4:

                        System.out.println("\n- ALQUILAR MAQUINA -");

                        System.out.print(
                            "Ingrese el codigo de la maquina: "
                        );
                        String codigoAlquiler = teclado.nextLine();

                        Maquina maquinaAlquiler =
                            dulceEstacion.buscarMaquina(codigoAlquiler);

                        if (maquinaAlquiler == null) {
                            System.out.println(
                                "No existe una maquina con ese codigo"
                            );
                            break;
                        }

                        if (!maquinaAlquiler.getDisponible()) {
                            System.out.println(
                                "La maquina ya se encuentra alquilada"
                            );
                            break;
                        }

                        System.out.print(
                            "Ingrese la cantidad de dias: "
                        );
                        int diasAlquiler = teclado.nextInt();
                        teclado.nextLine();

                        if (diasAlquiler <= 0) {
                            System.out.println(
                                "Los dias deben ser mayores que cero"
                            );
                            break;
                        }

                        double total =
                            dulceEstacion.cotizar(
                                codigoAlquiler,
                                diasAlquiler
                            );

                        System.out.printf(
                            "Total del alquiler: Q%.2f%n",
                            total
                        );

                        System.out.println("¿Desea confirmar?");
                        System.out.println("1. Si");
                        System.out.println("2. No");

                        int confirmar = teclado.nextInt();
                        teclado.nextLine();

                        if (confirmar == 1) {

                            dulceEstacion.alquilar(
                                codigoAlquiler,
                                diasAlquiler
                            );

                            System.out.println(
                                "Alquiler confirmado correctamente"
                            );

                        } else if (confirmar == 2) {

                            System.out.println(
                                "Alquiler cancelado. No se realizaron cambios."
                            );

                        } else {

                            System.out.println(
                                "Opcion no valida. No se realizaron cambios."
                            );
                        }

                        break;

                    case 5:

                        System.out.println("\n- DEVOLUCION -");

                        System.out.print(
                            "Ingrese el codigo de la maquina: "
                        );
                        String codigoDevolucion = teclado.nextLine();

                        Maquina maquinaDevolucion =
                            dulceEstacion.buscarMaquina(codigoDevolucion);

                        if (maquinaDevolucion == null) {

                            System.out.println(
                                "No existe una maquina con ese codigo"
                            );

                        } else if (maquinaDevolucion.getDisponible()) {

                            System.out.println(
                                "La maquina ya se encuentra disponible"
                            );

                        } else {

                            dulceEstacion.devolver(codigoDevolucion);

                            System.out.println(
                                "Devolucion registrada correctamente"
                            );
                        }

                        break;

                    case 6:

                        System.out.println("\n--- REPORTE GENERAL ---");

                        System.out.println(
                            "Total de maquinas: "
                            + dulceEstacion.getCantidadMaquinas()
                        );

                        System.out.println("\nPalomitas:");
                        System.out.println(
                            "Disponibles: "
                            + dulceEstacion.contarDisponiblesPorCategoria(
                                "Palomitas"
                            )
                        );
                        System.out.println(
                            "Alquiladas: "
                            + dulceEstacion.contarAlquiladasPorCategoria(
                                "Palomitas"
                            )
                        );

                        System.out.println("\nAlgodon:");
                        System.out.println(
                            "Disponibles: "
                            + dulceEstacion.contarDisponiblesPorCategoria(
                                "Algodon"
                            )
                        );
                        System.out.println(
                            "Alquiladas: "
                            + dulceEstacion.contarAlquiladasPorCategoria(
                                "Algodon"
                            )
                        );

                        System.out.println("\nChocolate:");
                        System.out.println(
                            "Disponibles: "
                            + dulceEstacion.contarDisponiblesPorCategoria(
                                "Chocolate"
                            )
                        );
                        System.out.println(
                            "Alquiladas: "
                            + dulceEstacion.contarAlquiladasPorCategoria(
                                "Chocolate"
                            )
                        );

                        System.out.printf(
                            "%nDinero acumulado: Q%.2f%n",
                            dulceEstacion.getDineroAcumulado()
                        );

                        break;

                    case 7:

                        System.out.println("Programa finalizado.");
                        break;

                    default:

                        System.out.println(
                            "Seleccione una opcion valida"
                        );
                }

            } catch (Exception e) {

                System.out.println(
                    "Entrada no valida. Intente nuevamente."
                );

                teclado.nextLine();
            }
        }

        teclado.close();
    }
}