package com.programacion_bcd.taller.sistema;

import java.time.LocalDate;
import java.util.Objects;

public class Candidato extends Elector {
    private TipoCandidato tipoCandidato;
    private Lista lista;

    public Candidato(String nombre, String apellido, Integer dni,
                     Domicilio domicilio, String lugarVotacion,
                     LocalDate fechaNac,
                     MesaElectoral mesa,
                     Voto voto,
                     TipoCandidato tipoCandidato,
                     Lista lista) {
        super(nombre, apellido, dni, domicilio, lugarVotacion, fechaNac, mesa,
              voto);
        this.tipoCandidato = tipoCandidato;
        this.lista = lista;
    }

    public TipoCandidato getTipoCandidato() {
        return tipoCandidato;
    }

    public void setTipoCandidato(
            TipoCandidato tipoCandidato) {
        this.tipoCandidato = tipoCandidato;
    }

    public Lista getLista() {
        return lista;
    }

    public void setLista(Lista lista) {
        this.lista = lista;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Candidato candidato = (Candidato) o;
        return tipoCandidato == candidato.tipoCandidato &&
               lista.equals(candidato.lista);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tipoCandidato, lista);
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Candidato{" +
               "tipoCandidato=" + tipoCandidato +
               ", lista=" + lista +
               '}';
    }
}
