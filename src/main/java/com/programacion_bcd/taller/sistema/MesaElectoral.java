package com.programacion_bcd.taller.sistema;

import java.util.Objects;

public class MesaElectoral {
    private Elector presidente;
    private Elector auxiliar;
    private Voto voto;

    public MesaElectoral(Elector presidente, Elector auxiliar, Voto voto) {
        this.presidente = presidente;
        this.auxiliar = auxiliar;
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
        return Objects.equals(presidente, that.presidente) && Objects.equals(auxiliar, that.auxiliar) && Objects.equals(voto, that.voto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(presidente, auxiliar, voto);
    }

    @Override
    public String toString() {
        return "MesaElectoral{" +
                "presidente=" + presidente +
                ", auxiliar=" + auxiliar +
                ", voto=" + voto +
                '}';
    }
}
