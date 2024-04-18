package org.example;

import java.util.*;

import java.util.*;

import java.util.Scanner;

// Clase que representa una canción en la playlist
class Nodo {
    String nombreCancion;
    String artista;
    String genero;
    int duracion; // en segundos
    Nodo siguiente; // Apuntador al siguiente nodo en la lista

    public Nodo(String nombreCancion, String artista, String genero, int duracion) {
        this.nombreCancion = nombreCancion;
        this.artista = artista;
        this.genero = genero;
        this.duracion = duracion;
        this.siguiente = null; // Inicialmente el siguiente nodo es null
    }
}

// Clase que representa la lista simple de canciones
class Playlist {
    // Nodo que actúa como la cabeza de la lista
    Nodo cabeza;

    // Método para agregar una canción a la playlist
    public void agregarCancion(String nombreCancion, String artista, String genero, int duracion) {
        Nodo nuevaCancion = new Nodo(nombreCancion, artista, genero, duracion);
        if (cabeza == null) {
            cabeza = nuevaCancion;
        } else {
            Nodo temp = cabeza;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevaCancion;
        }
    }

    // Método para mostrar todas las canciones en la playlist en orden de inserción
    public void mostrarPlaylist() {
        Nodo temp = cabeza;
        while (temp != null) {
            System.out.println("Canción: " + temp.nombreCancion);
            System.out.println("Artista: " + temp.artista);
            System.out.println("Género: " + temp.genero);
            System.out.println("Duración: " + temp.duracion + " segundos");
            System.out.println("------------------------");
            temp = temp.siguiente;
        }
    }

    // Método para calcular la duración total de la playlist en minutos y segundos
    public void calcularDuracionTotal() {
        int duracionTotal = 0;
        Nodo temp = cabeza;
        while (temp != null) {
            duracionTotal += temp.duracion;
            temp = temp.siguiente;
        }
        int minutos = duracionTotal / 60;
        int segundos = duracionTotal % 60;
        System.out.println("Duración total de la playlist: " + minutos + " minutos y " + segundos + " segundos.");
    }

    // Método para eliminar una canción de la playlist por su nombre
    public void eliminarCancion(String nombreCancion) {
        if (cabeza == null) {
            return;
        }
        if (cabeza.nombreCancion.equals(nombreCancion)) {
            cabeza = cabeza.siguiente;
            return;
        }
        Nodo temp = cabeza;
        while (temp.siguiente != null && !temp.siguiente.nombreCancion.equals(nombreCancion)) {
            temp = temp.siguiente;
        }
        if (temp.siguiente != null) {
            temp.siguiente = temp.siguiente.siguiente;
        }
    }

    // Método para insertar una nueva canción en una posición específica de la playlist
    public void insertarCancion(String nombreCancion, String artista, String genero, int duracion, int posicion) {
        Nodo nuevaCancion = new Nodo(nombreCancion, artista, genero, duracion);
        if (posicion == 0) {
            nuevaCancion.siguiente = cabeza;
            cabeza = nuevaCancion;
            return;
        }
        Nodo temp = cabeza;
        for (int i = 0; i < posicion - 1 && temp != null; i++) {
            temp = temp.siguiente;
        }
        if (temp == null) {
            return;
        }
        nuevaCancion.siguiente = temp.siguiente;
        temp.siguiente = nuevaCancion;
    }

    // Método para buscar una canción por su nombre y mostrar su información
    public void buscarCancion(String nombreCancion) {
        Nodo temp = cabeza;
        while (temp != null) {
            if (temp.nombreCancion.equals(nombreCancion)) {
                System.out.println("Canción: " + temp.nombreCancion);
                System.out.println("Artista: " + temp.artista);
                System.out.println("Género: " + temp.genero);
                System.out.println("Duración: " + temp.duracion + " segundos");
                return;
            }
            temp = temp.siguiente;
        }
        System.out.println("La canción \"" + nombreCancion + "\" no se encontró en la playlist.");
    }

    // Método para ordenar la playlist por nombre de canción
    public void ordenarPorNombre() {
        cabeza = mergeSort(cabeza, "nombreCancion");
    }

    // Método para ordenar la playlist por artista
    public void ordenarPorArtista() {
        cabeza = mergeSort(cabeza, "artista");
    }

    // Método para ordenar la playlist por género
    public void ordenarPorGenero() {
        cabeza = mergeSort(cabeza, "genero");
    }

    // Implementación del algoritmo de ordenamiento Merge Sort para listas enlazadas
    private Nodo mergeSort(Nodo inicio, String campo) {
        if (inicio == null || inicio.siguiente == null) {
            return inicio;
        }

        Nodo mitad = obtenerMitad(inicio);
        Nodo mitadSiguiente = mitad.siguiente;
        mitad.siguiente = null;

        Nodo izquierda = mergeSort(inicio, campo);
        Nodo derecha = mergeSort(mitadSiguiente, campo);

        return fusionar(izquierda, derecha, campo);
    }

    private Nodo obtenerMitad(Nodo inicio) {
        if (inicio == null) {
            return inicio;
        }
        Nodo rapido = inicio.siguiente;
        Nodo lento = inicio;
        while (rapido != null) {
            rapido = rapido.siguiente;
            if (rapido != null) {
                lento = lento.siguiente;
                rapido = rapido.siguiente;
            }
        }
        return lento;
    }

    private Nodo fusionar(Nodo izquierda, Nodo derecha, String campo) {
        if (izquierda == null) {
            return derecha;
        }
        if (derecha == null) {
            return izquierda;
        }

        if (campo.equals("nombreCancion")) {
            if (izquierda.nombreCancion.compareToIgnoreCase(derecha.nombreCancion) < 0) {
                izquierda.siguiente = fusionar(izquierda.siguiente, derecha, campo);
                return izquierda;
            } else {
                derecha.siguiente = fusionar(izquierda, derecha.siguiente, campo);
                return derecha;
            }
        } else if (campo.equals("artista")) {
            if (izquierda.artista.compareToIgnoreCase(derecha.artista) < 0) {
                izquierda.siguiente = fusionar(izquierda.siguiente, derecha, campo);
                return izquierda;
            } else {
                derecha.siguiente = fusionar(izquierda, derecha.siguiente, campo);
                return derecha;
            }
        } else if (campo.equals("genero")) {
            if (izquierda.genero.compareToIgnoreCase(derecha.genero) < 0) {
                izquierda.siguiente = fusionar(izquierda.siguiente, derecha, campo);
                return izquierda;
            } else {
                derecha.siguiente = fusionar(izquierda, derecha.siguiente, campo);
                return derecha;
            }
        } else {
            return null;
        }
    }
}



