package com.programacion_bcd.taller.sistema;

import java.util.List;
import java.util.Objects;

public class Lista {
    private String provincia;
    private String nombreLista;
    private String numero;
    private PartidoPolitico partido;
    private List<Candidato> candidato;
    private List<Voto> voto;

    public Lista(String provincia, String nombreLista, String numero,
                 PartidoPolitico partido,
                 List<Candidato> candidato,
                 List<Voto> voto) {
        this.provincia = provincia;
        this.nombreLista = nombreLista;
        this.numero = numero;
        this.partido = partido;
        this.candidato = candidato;
        this.voto = voto;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getNombreLista() {
        return nombreLista;
    }

    public void setNombreLista(String nombreLista) {
        this.nombreLista = nombreLista;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public PartidoPolitico getPartido() {
        return partido;
    }

    public void setPartido(PartidoPolitico partido) {
        this.partido = partido;
    }

    public List<Candidato> getCandidato() {
        return candidato;
    }

    public void setCandidato(
            List<Candidato> candidato) {
        this.candidato = candidato;
    }

    public List<Voto> getVoto() {
        return voto;
    }

    public void setVoto(List<Voto> voto) {
        this.voto = voto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lista lista = (Lista) o;
        return numero.equals(lista.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }

    @Override
    public String toString() {
        return "Lista{" +
               "provincia='" + provincia + '\'' +
               ", nombreLista='" + nombreLista + '\'' +
               ", numero='" + numero + '\'' +
               ", partido=" + partido +
               ", candidato=" + candidato +
               ", voto=" + voto +
               '}';
    }
}
