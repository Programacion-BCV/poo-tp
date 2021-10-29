/**
 *Clase Circuito
 * La clase permite la creación de los distitntos Circuitos que conforman las Secciones.
 */
package com.programacion_bcd.taller.sistema;

import java.util.List;
import java.util.Objects;

public class Circuito {
    private int numero;
    private String nombre;
    private Seccion seccion;
    private List<MesaElectoral> listaMesas;

    /**
     *Constructor de la clase que permite la inicializacion de un Objeto de tipo Circuito.
     * @param numero Número de Circuito.
     * @param nombre Nombre de Circuito.
     * @param seccion Sección a la que pertenece el Circuito.
     * @param listaMesas Lista de mesas electorales que conforman el Circuito.
     */
    public Circuito(int numero, String nombre, Seccion seccion,
                    List<MesaElectoral> listaMesas) {
        this.numero = numero;
        this.nombre = nombre;
        this.seccion = seccion;
        this.listaMesas = listaMesas;
    }

    /**
     * Devuelve el número de Circuito.
     * @return Número de Circuito.
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Setea el número de Circuito.
     * @param numero Número de Circuito.
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Devuelve el nombre del Circuito.
     * @return Nombre del Circuito.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setea el nombre del Circuito.
     * @param nombre Nombre del Circuito.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve la Sección a la que pertenece el Circuito.
     * @return Sección a la que pertenece el Circuito.
     */
    public Seccion getSeccion() {
        return seccion;
    }

    /**
     *  Setea la Sección a la que pertencece el Circuito.
     * @param seccion Sección a la que pertenece el Circuito.
     */
    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    /**
     * Devuelve la lista de mesas electorales que conforman el Circuito.
     * @return Lista de mesas electorales.
     */
    public List<MesaElectoral> getListaMesas() {
        return listaMesas;
    }

    /**
     * Setea las mesas electorales que conforman el Circuito.
     * @param Lista de mesas electorales.
     */
    public void setListaMesas(
            List<MesaElectoral> listaMesas) {
        this.listaMesas = listaMesas;
    }

    /**
     * Método equals con el campo clave: nombre del Circuito.
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circuito circuito = (Circuito) o;
        return nombre.equals(circuito.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    /**
     * Concatena en una cadena de caracteres los atributos de Circuito.
     * @return String Distrito
     */
    @Override
    public String toString() {
        return "Circuito{" +
               "numero=" + numero +
               "nombre=" + nombre +
               ", listaMesas=" + listaMesas +
               '}';
    }
}
