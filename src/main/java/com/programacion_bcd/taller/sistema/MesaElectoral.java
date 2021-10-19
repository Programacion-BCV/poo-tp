package com.programacion_bcd.taller.sistema;

import java.util.Arrays;
import java.util.Objects;

public class MesaElectoral {
    private Elector presidente;
    private Elector auxiliar;
    private Circuito circuito;
    private Elector[] electores=new Elector[350];
    private Voto voto;

    public MesaElectoral(Elector presidente, Elector auxiliar, Circuito circuito, Elector[] electores, Voto voto) {
        this.presidente = presidente;
        this.auxiliar = auxiliar;
        this.circuito = circuito;
        this.electores = electores;
        this.voto = voto;
    }

    public Elector getPresidente() {
        return presidente;
    }

    public void setPresidente(Elector presidente) {
        this.presidente = presidente;
    }

    public Elector getAuxiliar() {
        return auxiliar;
    }

    public void setAuxiliar(Elector auxiliar) {
        this.auxiliar = auxiliar;
    }

    public Circuito getCircuito() {
        return circuito;
    }

    public void setCircuito(Circuito circuito) {
        this.circuito = circuito;
    }

    public Elector[] getElectores() {
        return electores;
    }

    public void setElectores(Elector[] electores) {
        this.electores = electores;
    }

    public Voto getVoto() {
        return voto;
    }

    public void setVoto(Voto voto) {
        this.voto = voto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MesaElectoral that = (MesaElectoral) o;
        return Objects.equals(presidente, that.presidente) && Objects.equals(auxiliar, that.auxiliar) && Objects.equals(circuito, that.circuito) && Arrays.equals(electores, that.electores) && Objects.equals(voto, that.voto);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(presidente, auxiliar, circuito, voto);
        result = 31 * result + Arrays.hashCode(electores);
        return result;
    }
}
