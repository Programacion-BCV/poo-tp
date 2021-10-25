package com.programacion_bcd.taller.sistema;

import java.util.List;
import java.util.Objects;

public class Lista {
    private String provincia;
    private String nombreLista;
    private String numero;
    private PartidoPolitico partido;
    private List<Candidato> diputados;
    private List<Candidato> senadores;
    private List<Voto> voto;

    public Lista(String provincia, String nombreLista, String numero,
                 PartidoPolitico partido,
                 List<Candidato> diputados,
                 List<Candidato> senadores,
                 List<Voto> voto) {
        this.provincia = provincia;
        this.nombreLista = nombreLista;
        this.numero = numero;
        this.partido = partido;
        this.diputados = diputados;
        this.senadores = senadores;
        this.voto = voto;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getNombreLista() {
        return nombreLista;
    }

    public String getNumero() {
        return numero;
    }

    public PartidoPolitico getPartido() {
        return partido;
    }

    public List<Candidato> getDiputados() {
        return diputados;
    }

    public List<Candidato> getSenadores() {
        return senadores;
    }

    public List<Voto> getVoto() {
        return voto;
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
               ", diputados=" + diputados +
               ", senadores=" + senadores +
               ", voto=" + voto +
               '}';
    }
}
