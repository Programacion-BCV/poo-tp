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
     * crea un voto pasandole los parametros del elector y asignando sus atributos
     *
     * @param elector       datos del elector
     * @param mesa          en la que vota
     * @param votoDiputados voto de candidatos senador y disputado justo con su lista.
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
     * Retorna los datos del elector
     *
     * @return elector
     */
    public Elector getElector() {
        return elector;
    }

    /**
     * Asigna los datos de elector
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
