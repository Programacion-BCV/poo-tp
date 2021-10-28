/**
 * Esta clase se encarga de obtener el voto de cada elector
 */

package com.programacion_bcd.taller.sistema;

import java.util.Arrays;
import java.util.Objects;

public class Voto {
    private Elector elector;
    private MesaElectoral mesa;
    private Lista votoDiputados;
    private Lista votoSenadores;

    /**
     * Constructor de la clase que permite la creación de los votos.
     *
     * @param elector       Elector.
     * @param mesa          Mesa electoral donde emite el voto.
     * @param votoDiputados Votos a diputados.
     * @param votoSenadores Votos a senadores.
     */

    public Voto(Elector elector,
                MesaElectoral mesa,
                Lista votoDiputados,
                Lista votoSenadores) {
        this.elector = elector;
        this.mesa = mesa;
        this.votoDiputados = votoDiputados;
        this.votoSenadores = votoSenadores;
    }

    /**
     * Devuelve el Elector del voto.
     *
     * @return Elector.
     */
    public Elector getElector() {
        return elector;
    }

    /**
     * Setea el Elector al voto.
     *
     * @param elector
     */
    public void setElector(Elector elector) {
        this.elector = elector;
    }

    /**
     * Retorna parametros de MesaElectoral
     *
     * @return mesa
     */
    public MesaElectoral getMesa() {
        return mesa;
    }

    /**
     * Asigna los parametros de MesaElectoral
     *
     * @param mesa
     */
    public void setMesa(MesaElectoral mesa) {
        this.mesa = mesa;
    }

    public Lista getVotoDiputados() {
        return votoDiputados;
    }

    public void setVotoDiputados(Lista votoDiputados) {
        this.votoDiputados = votoDiputados;
    }

    public Lista getVotoSenadores() {
        return votoSenadores;
    }

    public void setVotoSenadores(Lista votoSenadores) {
        this.votoSenadores = votoSenadores;
    }

    /**
     * Retorna los votos de candidatos
     *
     * @return votos
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voto voto = (Voto) o;
        return elector.equals(voto.elector);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elector);
    }

    /**
     * Concatena en una cadena de caracteres los atributos de Voto
     *
     * @return String Voto
     */
    @Override
    public String toString() {
        return "Voto{" +
               "elector=" + elector.getNombre() +
               ", mesa=" + mesa +
               ", votoDiputados=" + votoDiputados.getNumero() +
               ", votoSenadores=" + votoSenadores.getNumero() +
               '}';
    }
}
