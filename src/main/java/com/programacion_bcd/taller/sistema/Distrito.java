/**
 * Clase Distrito
 * Esta clase define el distrito de cada elector donde debe votar
 */
package com.programacion_bcd.taller.sistema;

import java.util.List;
import java.util.Objects;

public class Distrito implements Estadistica {
    private String nombre;
    private List<Seccion> listaSecciones;

    /**
     * @param nombre         nombre del distrito
     * @param listaSecciones secciones del distrito
     */
    public Distrito(String nombre,
                    List<Seccion> listaSecciones) {
        this.nombre = nombre;
        this.listaSecciones = listaSecciones;
    }

    /**
     * retorna nombre del Distrito
     *
     * @return String Nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Asigna nombre de Distrito
     *
     * @param nombre String
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * retorna lista de Seccion
     *
     * @return List listaSecciones
     */
    public List<Seccion> getListaSecciones() {
        return listaSecciones;
    }

    /**
     * Asigna Lista de Seccion
     *
     * @param listaSecciones
     */
    public void setListaSecciones(
            List<Seccion> listaSecciones) {
        this.listaSecciones = listaSecciones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Distrito distrito = (Distrito) o;
        return nombre.equals(distrito.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    /**
     * Concatena en una cadena de caracteres los atributos de Distrito
     *
     * @return String Distrito
     */
    @Override
    public String toString() {
        return "Distrito{" +
               "nombre='" + nombre + '\'' +
               ", listaSecciones=" + listaSecciones +
               '}'+"\n";
    }
}
