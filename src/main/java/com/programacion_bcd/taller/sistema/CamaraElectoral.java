/**
 * Clase Camara Electoral
 * <p>
 * La clase lleva un registro de todas las listas,padron de personas,
 * interrelaciones y realiza verificaicones.
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
     * crea una camara electoral pasandole por parametro los atributos.
     *
     * @param electores           atributos de Elector
     * @param listas              atributos de Lista
     * @param listaDistritos      atributos de Distrito
     * @param listaRequerimientos atributos de Requerimientos Provincia
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
     * retorna lista de Elector
     *
     * @return elector
     */
    public List<Elector> getElectores() {
        return electores;
    }

    /**
     * Asigna lista de Elector
     *
     * @param electores
     */
    public void setElectores(
            List<Elector> electores) {
        this.electores = electores;
    }

    /**
     * retorna lista de Lista
     *
     * @return Lista
     */
    public List<Lista> getListas() {
        return listas;
    }

    /**
     * Asigna lista de Lista
     *
     * @param listas
     */
    public void setListas(
            List<Lista> listas) {
        this.listas = listas;
    }

    /**
     * retorna lista de Distritos
     *
     * @return ListaDistritos
     */
    public List<Distrito> getListaDistritos() {
        return listaDistritos;
    }

    /**
     * Asigna lista de Distrito
     *
     * @param listaDistritos
     */
    public void setListaDistritos(
            List<Distrito> listaDistritos) {
        this.listaDistritos = listaDistritos;
    }

    /**
     * retorna lista de RequerimientosProvincia
     *
     * @return listaRequerimientos
     */
    public RequerimientosProvincia[] getListaRequerimientos() {
        return listaRequerimientos;
    }

    /**
     * Asigna lista de RequerimientosProvincia
     *
     * @param listaRequerimientos
     */
    public void setListaRequerimientos(
            RequerimientosProvincia[] listaRequerimientos) {
        this.listaRequerimientos = listaRequerimientos;
    }

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
     * Concatena en una cadena de caracteres los atributos de Cámara Electoral
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
