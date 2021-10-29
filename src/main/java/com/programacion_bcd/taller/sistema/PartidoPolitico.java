/**
 * Clase Partido Político
 *
 * Esta clase permite inicializar los partidos politicos que conforman las listas.
 */
package com.programacion_bcd.taller.sistema;

import java.util.List;
import java.util.Objects;

public class PartidoPolitico {
    private String nombre;
    private List<Lista> lista;
    private List<PartidoPolitico> partido;

    /**
     * Constructor que permite inicializar los objetos de tipo Lista.
     *
     * @param nombre  Nombre de la Lista
     * @param lista   Lista de listas que conforman los partidos políticos.
     * @param partido Partido a la que pertecene la Lista.
     */
    public PartidoPolitico(String nombre, List<Lista> lista,
                           List<PartidoPolitico> partido) {
        this.nombre = nombre;
        this.lista = lista;
        this.partido = partido;
    }

    /**
     * Devuelve el nombre de la Lista.
     *
     * @return Nombre de la lista.
     */
    public String getNombre() {return nombre;}

    /**
     * Setea el nombre de la Lista.
     *
     * @param nombre Nombre de la Lista.
     */
    public void setNombre(String nombre) {this.nombre = nombre;}

    /**
     * Devuelve la lista de listas de ese Partido Político.
     *
     * @return Lista de listas del Partido Político.
     */
    public List<Lista> getLista() {
        return lista;
    }

    /**
     * Setea la lista de listas de ese Partido Político.
     *
     * @param lista Lista de listas del Partido Político.
     */
    public void setLista(List<Lista> lista) {
        this.lista = lista;
    }

    /**
     * Devuelve una lista de los Partidos Políticos.
     *
     * @return Lista de Partidos Políticos.
     */
    public List<PartidoPolitico> getPartido() {
        return partido;
    }

    /**
     * Setea las listas de Partidos Políticos.
     *
     * @param partido Lista de Partidos Políticos.
     */
    public void setPartido(List<PartidoPolitico> partido) {
        this.partido = partido;
    }

    /**
     * Método equals con los campos claves: nombre del Partido, Lista del partido, Partido.
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        PartidoPolitico that = (PartidoPolitico) o;
        return Objects.equals(nombre, that.nombre) &&
               Objects.equals(lista, that.lista) &&
               Objects.equals(partido, that.partido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, lista, partido);
    }

    /**
     * Concatena en una cadena de caracteres los atributos de Partido Politico.
     *
     * @return
     */
    @Override
    public String toString() {
        return "PartidoPolitico{" +
               "nombre='" + nombre + '\'' +

               ", partido=" + partido +
               '}';
    }
}
