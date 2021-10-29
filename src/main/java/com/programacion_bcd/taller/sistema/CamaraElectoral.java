/**
 * Clase Camara Electoral
 * La clase lleva un registro de todas las listas, padrón electoral,
 * interrelaciones y también realiza verificaicones.
 */
package com.programacion_bcd.taller.sistema;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CamaraElectoral {
    private List<Elector> electores;
    private List<Lista> listas;
    private List<Distrito> listaDistritos;
    private RequerimientosProvincia[] listaRequerimientos;

    public CamaraElectoral() {
    }

    /**
     * Constructor de la clase que permite la inicialización de un Objeto de tipo Camara Electoral.
     *
     * @param electores           Lista de Electores.
     * @param listas              Lista de Listas.
     * @param listaDistritos      Lista de Distritos.
     * @param listaRequerimientos Arreglo de Requerimientos de la Provincia.
     */
    public CamaraElectoral(
            List<Elector> electores,
            List<Lista> listas,
            List<Distrito> listaDistritos,
            RequerimientosProvincia[] listaRequerimientos) {
        this.electores = electores;
        this.listas = listas;
        this.listaDistritos = listaDistritos;
        this.listaRequerimientos = listaRequerimientos;
    }

    /**
     * Devuelve la lista de Electores.
     *
     * @return Lista de Electores.
     */
    public List<Elector> getElectores() {
        return electores;
    }

    /**
     * Setea la lista de Electores.
     *
     * @param electores Lista de Electores.
     */
    public void setElectores(
            List<Elector> electores) {
        this.electores = electores;
    }

    /**
     * Devuelve las listas de Listas.
     *
     * @return Lista de listas.
     */
    public List<Lista> getListas() {
        return listas;
    }

    /**
     * Setea las listas de Listas.
     *
     * @param listas Lista de listas.
     */
    public void setListas(
            List<Lista> listas) {
        this.listas = listas;
    }

    /**
     * Devuelve la lista de Distritos.
     *
     * @return Listas de Distritos.
     */
    public List<Distrito> getListaDistritos() {
        return listaDistritos;
    }

    /**
     * Setea la listas de Distritos.
     *
     * @param listaDistritos Lista de Distritos.
     */
    public void setListaDistritos(
            List<Distrito> listaDistritos) {
        this.listaDistritos = listaDistritos;
    }

    /**
     * Devuelve el arreglo de Requerimientos de la Provincia.
     *
     * @return Arreglo de requerimientos de la provincia.
     */
    public RequerimientosProvincia[] getListaRequerimientos() {
        return listaRequerimientos;
    }

    /**
     * Setea el arreglo de Requerimientos de la Provincia.
     *
     * @param listaRequerimientos Arreglo de requerimientos de la provincia.
     */
    public void setListaRequerimientos(
            RequerimientosProvincia[] listaRequerimientos) {
        this.listaRequerimientos = listaRequerimientos;
    }

    /**
     * Método equals con los campos clave: electores, listas, lista de distritos, arreglo de requerimientos.
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CamaraElectoral that = (CamaraElectoral) o;
        return electores.equals(that.electores) && listas.equals(that.listas) &&
               listaDistritos.equals(that.listaDistritos) &&
               Arrays.equals(listaRequerimientos,
                             that.listaRequerimientos);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(electores, listas,
                                  listaDistritos);
        result = 31 * result + Arrays.hashCode(listaRequerimientos);
        return result;
    }

    /**
     * Concatena en una cadena de caracteres los atributos de Cámara Electoral.
     *
     * @return
     */
    @Override
    public String toString() {
        return "CamaraElectoral{" +
               "electores=" + electores +
               ", listas=" + listas +
               ", listaDistritos=" + listaDistritos +
               ", listaRequerimientos=" +
               Arrays.toString(listaRequerimientos) +
               '}';
    }
}
