import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear una lista para almacenar las armas
        List<Arma> armas = new ArrayList<>();

        // Bucle principal para interactuar con el usuario
        while (true) {
            System.out.println("================================");
            System.out.println("Menú del Sistema de Armas");
            System.out.println("1. Agregar Arma");
            System.out.println("2. Ver información de las armas");
            System.out.println("3. Probar funcionalidades");
            System.out.println("4. Salir");
            System.out.println("================================");
            System.out.print("Ingrese una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    // Agregar un arma
                    System.out.println("¿Qué tipo de arma desea agregar?");
                    System.out.println("1. Arma Corta");
                    System.out.println("2. Arma Larga");
                    int tipoArma = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    // Obtener datos del policía
                    System.out.print("Ingrese el nombre del policía: ");
                    String nombrePolicia = scanner.nextLine();

                    System.out.print("Ingrese el apellido del policía: ");
                    String apellidoPolicia = scanner.nextLine();

                    System.out.print("Ingrese el legajo del policía: ");
                    int legajoPolicia = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    // Crear el objeto Policia
                    Policia policia = new Policia(nombrePolicia, apellidoPolicia, legajoPolicia);

                    if (tipoArma == 1) {
                        // Obtener datos del arma corta
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

                        System.out.print("¿Es automática? (true/false): ");
                        boolean esAutomatica = scanner.nextBoolean();
                        scanner.nextLine();

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
                        String justifUso = scanner.nextLine(); // Corregido: leer como String

                        System.out.print("Ingrese el nivel del arma: ");
                        int nivelArma = scanner.nextInt(); // Corregido: leer como entero
                        scanner.nextLine(); // Consumir el salto de línea

                        System.out.print("¿Tiene sello del RENAR? (true/false): ");
                        boolean tieneSello = scanner.nextBoolean();
                        scanner.nextLine();

                        // Crear el objeto ArmaLarga
                        ArmaLarga armaLarga = new ArmaLarga(cantMuniciones, alcance, marca, calibre, estado, policia, justifUso, nivelArma, tieneSello);
                        armas.add(armaLarga);
                        System.out.println("Arma Larga agregada.");
                    } else {
                        System.out.println("Opción inválida.");
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

// Clases Arma, ArmaCorta, ArmaLarga y Policia (las mismas que antes)