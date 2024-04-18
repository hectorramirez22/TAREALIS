package org.example;


import java.util.Scanner;

// Clase principal que contiene el método main para probar la playlist
public class Main {
    public static void main(String[] args) {
        // Crear una nueva playlist
        Playlist miPlaylist = new Playlist();

        // Scanner para entrada de usuario
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            // Mostrar el menú de opciones
            System.out.println("\n*** Menú de Playlist ***");
            System.out.println("1. Mostrar Playlist");
            System.out.println("2. Agregar Canción");
            System.out.println("3. Eliminar Canción");
            System.out.println("4. Buscar Canción");
            System.out.println("5. Calcular Duración Total");
            System.out.println("6. Ordenar Playlist");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\nMi Playlist:");
                    miPlaylist.mostrarPlaylist();
                    break;
                case 2:
                    System.out.print("Ingrese el nombre de la canción: ");
                    scanner.nextLine(); // Consumir la nueva línea
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el nombre del artista: ");
                    String artista = scanner.nextLine();
                    System.out.print("Ingrese el género de la canción: ");
                    String genero = scanner.nextLine();
                    System.out.print("Ingrese la duración de la canción en segundos: ");
                    int duracion = scanner.nextInt();
                    miPlaylist.agregarCancion(nombre, artista, genero, duracion);
                    System.out.println("Canción agregada con éxito a la playlist.");
                    break;
                case 3:
                    System.out.print("Ingrese el nombre de la canción a eliminar: ");
                    scanner.nextLine(); // Consumir la nueva línea
                    String nombreEliminar = scanner.nextLine();
                    miPlaylist.eliminarCancion(nombreEliminar);
                    System.out.println("Canción eliminada de la playlist.");
                    break;
                case 4:
                    System.out.print("Ingrese el nombre de la canción a buscar: ");
                    scanner.nextLine(); // Consumir la nueva línea
                    String nombreBuscar = scanner.nextLine();
                    miPlaylist.buscarCancion(nombreBuscar);
                    break;
                case 5:
                    miPlaylist.calcularDuracionTotal();
                    break;
                case 6:
                    System.out.println("Ordenar por:");
                    System.out.println("1. Nombre de la Canción");
                    System.out.println("2. Artista");
                    System.out.println("3. Género");
                    System.out.print("Seleccione una opción: ");
                    int opcionOrden = scanner.nextInt();
                    switch (opcionOrden) {
                        case 1:
                            miPlaylist.ordenarPorNombre();
                            System.out.println("Playlist ordenada por nombre de canción.");
                            break;
                        case 2:
                            miPlaylist.ordenarPorArtista();
                            System.out.println("Playlist ordenada por artista.");
                            break;
                        case 3:
                            miPlaylist.ordenarPorGenero();
                            System.out.println("Playlist ordenada por género.");
                            break;
                        default:
                            System.out.println("Opción inválida.");
                            break;
                    }
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Inténtalo de nuevo.");
                    break;
            }
        } while (opcion != 7);

        // Cerrar el scanner
        scanner.close();
    }
}
