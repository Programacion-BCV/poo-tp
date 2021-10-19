package com.programacion_bcd.taller.sistema;

import java.time.LocalDate;
import java.util.Objects;

public class Candidato extends Elector {
    private TipoCandidato tipoCandidato;
    private Lista lista;
    private CamaraElectoral camara;

    public Candidato(String nombre, String apellido, int dni, Domicilio domicilio, String lugarDeVotacion, LocalDate fechaNac, MesaElectoral mesa, CamaraElectoral camara, Voto voto, TipoCandidato tipoCandidato, Lista lista, CamaraElectoral camara1) {
        super(nombre, apellido, dni, domicilio, lugarDeVotacion, fechaNac, mesa, camara, voto);
        this.tipoCandidato = tipoCandidato;
        this.lista = lista;
        this.camara = camara1;
    }

    public TipoCandidato getTipoCandidato() {
        return tipoCandidato;
    }

    public void setTipoCandidato(TipoCandidato tipoCandidato) {
        this.tipoCandidato = tipoCandidato;
    }

    public Lista getLista() {
        return lista;
    }

    public void setLista(Lista lista) {
        this.lista = lista;
    }

    @Override
    public CamaraElectoral getCamara() {
        return camara;
    }

    @Override
    public void setCamara(CamaraElectoral camara) {
        this.camara = camara;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Candidato candidato = (Candidato) o;
        return tipoCandidato == candidato.tipoCandidato && Objects.equals(lista, candidato.lista) && Objects.equals(camara, candidato.camara);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tipoCandidato, lista, camara);
    }

    @Override
    public String toString() {
        return super.toString()+"Candidato{" +
                "tipoCandidato=" + tipoCandidato +
                ", lista=" + lista +
                ", camara=" + camara +
                '}';
    }
}
