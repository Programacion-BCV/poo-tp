package com.programacion_bcd.taller.sistema;

import java.util.Arrays;
import java.util.Objects;

public class MesaElectoral {
    private Integer numero;
    private Elector presidente;
    private Elector auxiliar;
    private Circuito circuito;
    private Elector[] electores = new Elector[350];
    private Voto[] voto = new Voto[350];

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

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
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

    public Voto[] getVoto() {
        return voto;
    }

    public void setVoto(Voto[] voto) {
        this.voto = voto;
    }

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

    @Override
    public String toString() {
        return "MesaElectoral{" +
               "numero=" + numero +
               ", presidente=" + presidente +
               ", auxiliar=" + auxiliar +
               ", circuito=" + circuito +
               ", electores=" + Arrays.toString(electores) +
               ", voto=" + Arrays.toString(voto) +
               '}';
    }
}
