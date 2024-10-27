import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Almacenar las Armas 
        List<Arma> armas = new ArrayList<>();

        // Bucle principal
        while (true) {
            System.out.println("================================");
            System.out.println("Menu del Sistema de Armas");
            System.out.println("1. Agregar Arma");
            System.out.println("2. Ver información de las Armas");
            System.out.println("3. Probar Funcionalidades");
            System.out.println("4. Salir");
            System.out.println("================================");
            System.out.print("Ingrese una Opcion: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Salto de línea

            switch (opcion) {
                case 1:
                    // Agregar un arma
                    System.out.println("¿Qué tipo de arma desea agregar?");
                    System.out.println("1. Arma Corta");
                    System.out.println("2. Arma Larga");
                    int tipoArma = scanner.nextInt();
                    scanner.nextLine(); // Salto de línea

                    // Obtener datos del policía
                    System.out.print("Ingrese el nombre del policía: ");
                    String nombrePolicia = scanner.nextLine();

                    System.out.print("Ingrese el apellido del policía: ");
                    String apellidoPolicia = scanner.nextLine();

                    System.out.print("Ingrese el legajo del policía: ");
                    int legajoPolicia = scanner.nextInt();
                    scanner.nextLine(); // Salto de línea

                    // Crear el objeto Policia
                    Policia policia = new Policia(nombrePolicia, apellidoPolicia, legajoPolicia);

                    if (tipoArma == 1) {
                        // Datos del arma corta
                        System.out.print("Ingrese la cantidad de municiones: ");
                        int cantMuniciones = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Ingrese el alcance: ");
                        double alcance = scanner.nextDouble();
                        scanner.nextLine();

                        System.out.print("Ingrese la marca: ");
                        String marca = scanner.nextLine();

                        System.out.print("Ingrese el calibre: ");
                        int calibre = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Ingrese el estado (EN USO, EN MANTENIMIENTO, NUEVA): ");
                        String estado = scanner.nextLine();

                        System.out.print("¿Es automática? (Si/No): ");
                        String respuestaAutomatica = scanner.nextLine().toUpperCase(); // Convertir a mayúsculas
                        boolean esAutomatica = respuestaAutomatica.equals("SI"); // Comparar con "SI"

                        // Crear el objeto ArmaCorta
                        ArmaCorta armaCorta = new ArmaCorta(cantMuniciones, alcance, marca, calibre, estado, policia, esAutomatica);
                        armas.add(armaCorta);
                        System.out.println("Arma Corta agregada.");
                    } else if (tipoArma == 2) {
                        // Obtener datos del arma larga
                        System.out.print("Ingrese la cantidad de municiones: ");
                        int cantMuniciones = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Ingrese el alcance: ");
                        double alcance = scanner.nextDouble();
                        scanner.nextLine();

                        System.out.print("Ingrese la marca: ");
                        String marca = scanner.nextLine();

                        System.out.print("Ingrese el calibre: ");
                        int calibre = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Ingrese el estado (EN USO, EN MANTENIMIENTO, NUEVA): ");
                        String estado = scanner.nextLine();

                        System.out.print("Ingrese la justificación de uso: ");
                        String justifUso = scanner.nextLine(); // Leer como String

                        System.out.print("Ingrese el nivel del arma: ");
                        int nivelArma = scanner.nextInt(); // Leer como entero
                        scanner.nextLine(); // Salto de línea

                        System.out.print("¿Tiene sello del RENAR? (Si/No): ");
                        String respuestaSello = scanner.nextLine().toUpperCase(); // Convertir a mayúsculas
                        boolean tieneSello = respuestaSello.equals("SI"); // Comparar con "SI"

                        // Crear el objeto ArmaLarga
                        ArmaLarga armaLarga = new ArmaLarga(cantMuniciones, alcance, marca, calibre, estado, policia, justifUso, nivelArma, tieneSello);
                        armas.add(armaLarga);
                        System.out.println("Arma Larga Agregada Correctamente.");
                    } else {
                        System.out.println("Opción invalida.");
                    }
                    break;

                case 2:
                    // Ver información de las armas
                    if (armas.isEmpty()) {
                        System.out.println("No hay armas registradas.");
                    } else {
                        for (Arma arma : armas) {
                            System.out.println(arma);
                        }
                    }
                    break;

                case 3:
                    // Probar funcionalidades
                    if (armas.isEmpty()) {
                        System.out.println("No hay armas registradas.");
                    } else {
                        // Probar enCondiciones()
                        for (Arma arma : armas) {
                            System.out.println(arma.getClass().getSimpleName() + " en condiciones: " + arma.enCondiciones());
                        }

                        // Probar puedeDispararALargaDistancia() (solo para armas cortas)
                        for (Arma arma : armas) {
                            if (arma instanceof ArmaCorta) {
                                System.out.println(((ArmaCorta) arma).getClass().getSimpleName() + " puede disparar a larga distancia: " + ((ArmaCorta) arma).puedeDispararALargaDistancia());
                            }
                        }

                        // Probar compareTo() (solo para armas largas)
                        if (armas.size() >= 2) {
                            Arma arma1 = armas.get(0);
                            Arma arma2 = armas.get(1);
                            if (arma1 instanceof ArmaLarga && arma2 instanceof ArmaLarga) {
                                ArmaLarga armaLarga1 = (ArmaLarga) arma1;
                                ArmaLarga armaLarga2 = (ArmaLarga) arma2;
                                System.out.println(armaLarga1.getClass().getSimpleName() + " es mayor que " + armaLarga2.getClass().getSimpleName() + ": " + (armaLarga1.compareTo(armaLarga2) > 0));
                            }
                        }
                    }
                    break;
                case 4:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    return; // Salir del bucle
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}
