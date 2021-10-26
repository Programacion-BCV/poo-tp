/**
 * Clase Partido Político
 *
 * Permite la creación de los Partidos Políticos
 */
package com.programacion_bcd.taller.sistema;

import java.util.List;
import java.util.Objects;

public class PartidoPolitico {
    private String nombre;
    private List<Lista> lista;
    private List<PartidoPolitico> partido;

    /**
     * Constructor de objetos de tipo Lista
     * @param nombre Nombre de la Lista
     * @param lista
     * @param partido Partido a la que pertecene la Lista
     */
    public PartidoPolitico(String nombre, List<Lista> lista,
                           List<PartidoPolitico> partido) {
        this.nombre = nombre;
        this.lista = lista;
        this.partido = partido;
    }

    /**
     * Devuelve el nombre de la Lista
     * @return Nombre de la lista
     */
    public String getNombre() {return nombre;}

    /**
     * Setea el nombre de la Lista
     * @param nombre Nombre de la Lista
     */
    public void setNombre(String nombre) {this.nombre = nombre;}

    public List<Lista> getLista() {
        return lista;
    }

    public void setLista(List<Lista> lista) {
        this.lista = lista;
    }

    /**
     *
     * @return
     */
    public List<PartidoPolitico> getPartido() {
        return partido;
    }

    public void setPartido(List<PartidoPolitico> partido) {
        this.partido = partido;
    }

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
     * Concatena en una cadena de caracteres los atributos de Partido Politico
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
