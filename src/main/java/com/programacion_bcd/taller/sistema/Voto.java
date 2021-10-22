package com.programacion_bcd.taller.sistema;

import java.util.Arrays;
import java.util.Objects;

public class Voto {
    private Elector elector;
    private MesaElectoral mesa;
    private Lista[] votos;

    public Voto(Elector elector, MesaElectoral mesa, Lista[] votos) {
        this.elector = elector;
        this.mesa = mesa;
        this.votos = votos;
    }

    public Elector getElector() {
        return elector;
    }

    public void setElector(Elector elector) {
        this.elector = elector;
    }

    public MesaElectoral getMesa() {
        return mesa;
    }

    public void setMesa(MesaElectoral mesa) {
        this.mesa = mesa;
    }

    public Lista[] getVotos() {
        return votos;
    }

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

    @Override
    public String toString() {
        return "Voto{" +
               "elector=" + elector +
               ", mesa=" + mesa +
               ", votos=" + Arrays.toString(votos) +
               '}';
    }
}
