/**
 * Clase Mesa Electoral
 * Permite la creación de las mesas donde votarán los Electores
 */
package com.programacion_bcd.taller.sistema;

import java.util.Objects;

public class MesaElectoral {
    private Integer numero;
    private Elector presidente;
    private Elector auxiliar;
    private Circuito circuito;
    private Elector[] electores = new Elector[350];
    private Voto[] voto = new Voto[350];

    /**
     * Constructor de la mesa electoral donde emitirán el voto los Electores
     *
     * @param numero     Número de la mesa
     * @param presidente Presidente de mesa
     * @param auxiliar   Auxiliar de mesa
     * @param circuito   Circuito a la que pertenece la mesa
     * @param electores  Electores de la mesa
     * @param voto       Voto de cada uno de los electores
     */
    public MesaElectoral(Integer numero,
                         Elector presidente,
                         Elector auxiliar,
                         Circuito circuito,
                         Elector[] electores,
                         Voto[] voto) {
        this.numero = numero;
        this.presidente = presidente;
        this.auxiliar = auxiliar;
        this.circuito = circuito;
        this.electores = electores;
        this.voto = voto;
    }

    /**
     * Devuelve el número de la mesa.
     *
     * @return Número de mesa.
     */
    public Integer getNumero() {
        return numero;
    }

    /**
     * Setea el número de la mesa.
     *
     * @param numero Número de mesa.
     */
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    /**
     * Devuelve el Presidente de mesa.
     *
     * @return Presidente de mesa.
     */
    public Elector getPresidente() {
        return presidente;
    }

    /**
     * Setea el Presidente de mesa.
     *
     * @param presidente Presidente de mesa.
     */
    public void setPresidente(Elector presidente) {
        this.presidente = presidente;
    }

    /**
     * Devuelve el Auxiliar de mesa.
     *
     * @return Auxiliar de mesa.
     */
    public Elector getAuxiliar() {
        return auxiliar;
    }

    /**
     * Setea el Auxiliar de mesa.
     *
     * @param auxiliar Auxiliar de mesa.
     */
    public void setAuxiliar(Elector auxiliar) {
        this.auxiliar = auxiliar;
    }

    /**
     * Devuelve el Circuito a la que pertenece la mesa.
     *
     * @return Circuito de mesa.
     */
    public Circuito getCircuito() {
        return circuito;
    }

    /**
     * Setea el Circuito a la que pertenece la mesa.
     *
     * @param circuito Circuito de Mesa.
     */
    public void setCircuito(Circuito circuito) {
        this.circuito = circuito;
    }

    /**
     * Devuelve los electores que votan es esa mesa.
     *
     * @return Arreglo de electores que votan en la mesa.
     */
    public Elector[] getElectores() {
        return electores;
    }

    /**
     * Setea los Electores que votan en esa mesa.
     *
     * @param electores Arreglo de electores que votan en la mesa.
     */
    public void setElectores(Elector[] electores) {
        this.electores = electores;
    }

    /**
     * Devuelve un arreglo de votos de los electores.
     *
     * @return Arreglo de votos de los electores.
     */
    public Voto[] getVoto() {
        return voto;
    }

    /**
     * Setea el voto de los electores.
     *
     * @param voto Arreglo de votos de los electores.
     */
    public void setVoto(Voto[] voto) {
        this.voto = voto;
    }

    /**
     * Método equals con el campo clave: número de mesa electoral.
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MesaElectoral that = (MesaElectoral) o;
        return numero.equals(that.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }

    /**
     * Concatena en una cadena de caracteres los atributos de Mesa Electoral.
     *
     * @return
     */
    @Override
    public String toString() {
        return "MesaElectoral{" +
               "numero=" + numero +

               '}';
    }
}
