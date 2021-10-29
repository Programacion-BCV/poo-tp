/**
 * Clase Sección
 * Esta clase permite la creación de las distintas Secciones que tienen los Distritos.
 */
package com.programacion_bcd.taller.sistema;

import java.util.List;
import java.util.Objects;

public class Seccion {
    private String nombre;
    private Distrito distrito;
    private List<Circuito> circuitos;

    /**
     * Constructor que permite inicializar los objetos de tipo Sección.
     *
     * @param nombre    Nombre de la Sección.
     * @param distrito  Distrito a la que pertenece la Sección.
     * @param circuitos Lista de circuitos que conforman la Seccion.
     */
    public Seccion(String nombre,
                   Distrito distrito,
                   List<Circuito> circuitos) {
        this.nombre = nombre;
        this.distrito = distrito;
        this.circuitos = circuitos;
    }

    /**
     * Devuelve el nombre de la Sección.
     *
     * @return Nombre de la Sección.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setea el nombre de la Sección.
     *
     * @param nombre Nombre de la Sección.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el distrito a la que pertenece la Sección.
     *
     * @return Distrito de la Sección.
     */
    public Distrito getDistrito() {
        return distrito;
    }

    /**
     * Setea el distrito al que pertenece la Sección.
     *
     * @param distrito Distrito de la Sección.
     */
    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }

    /**
     * Devuelve una lista de los circuitos que conforman la Sección.
     *
     * @return Lista de circuitos de la Sección.
     */
    public List<Circuito> getCircuitos() {
        return circuitos;
    }

    /**
     * Setea los circuitos que conforman la Sección.
     *
     * @param circuitos Lista de circuitos de la Sección.
     */
    public void setCircuitos(
            List<Circuito> circuitos) {
        this.circuitos = circuitos;
    }

    /**
     * Método equals con el campo clave: nombre de la Sección.
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seccion seccion = (Seccion) o;
        return nombre.equals(seccion.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    /**
     * Concatena en una cadena de caracteres los atributos de Sección.
     *
     * @return
     */
    @Override
    public String toString() {
        return "Seccion{" +
               "nombre='" + nombre + '\'' +

               ", circuitos=" + circuitos +
               '}';
    }
}
