/**
 *Esta clase se encarga de obtener el voto de cada elector
 */

package com.programacion_bcd.taller.sistema;

import java.util.Arrays;
import java.util.Objects;

public class Voto {
    private Elector elector;
    private MesaElectoral mesa;
    private Lista[] votos;

    /**
     * crea un voto pasandole los parametros del elector y asignando sus atributos
     * @param elector datos del elector
     * @param mesa en la que vota
     * @param votos voto de candidatos senador y disputado justo con su lista.
     */
    public Voto(Elector elector, MesaElectoral mesa, Lista[] votos) {
        this.elector = elector;
        this.mesa = mesa;
        this.votos = votos;
    }

    /**
     * Retorna los datos del elector
     * @return elector
     */
    public Elector getElector() {
        return elector;
    }

    /**
     * Asigna los datos de elector
     * @param elector
     */
    public void setElector(Elector elector) {
        this.elector = elector;
    }

    /**
     * Retorna parametros de MesaElectoral
     * @return mesa
     */
    public MesaElectoral getMesa() {
        return mesa;
    }

    /**
     *Asigna los parametros de MesaElectoral
     * @param mesa
     */
    public void setMesa(MesaElectoral mesa) {
        this.mesa = mesa;
    }

    /**
     * Retorna los votos de candidatos
     * @return votos
     */
    public Lista[] getVotos() {
        return votos;
    }

    /**
     * Asigna voto a los candidatos de lista
     * @param votos
     */
    public void setVotos(Lista[] votos) {
        this.votos = votos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voto voto = (Voto) o;
        return elector.equals(voto.elector) && mesa.equals(voto.mesa) &&
               Arrays.equals(votos, voto.votos);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(elector, mesa);
        result = 31 * result + Arrays.hashCode(votos);
        return result;
    }

    /**
     * Concatena en una cadena de caracteres los atributos de Voto
     * @return String Voto
     */
    @Override
    public String toString() {
        return "Voto{" +
               "elector=" + elector +
               ", mesa=" + mesa +
               ", votos=" + Arrays.toString(votos) +
               '}';
    }
}
