package com.programacion_bcd.taller.sistema;

import java.util.List;

public class Lista {
    private String provincia;
    private String nombreLista;
    private int numero;
    private List<Candidato> candidato;
    public PartidoPolitico partido;
    private List<Voto> voto;
    private CamaraElectoral camara;

    public Lista(String provincia, String nombreLista, int numero, List<Candidato> candidato, PartidoPolitico partido, List<Voto> voto, CamaraElectoral camara) {
        this.provincia = provincia;
        this.nombreLista = nombreLista;
        this.numero = numero;
        this.candidato = candidato;
        this.partido = partido;
        this.voto = voto;
        this.camara = camara;
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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public List<Candidato> getCandidato() {
        return candidato;
    }

    public void setCandidato(List<Candidato> candidato) {
        this.candidato = candidato;
    }

    public PartidoPolitico getPartido() {
        return partido;
    }

    public void setPartido(PartidoPolitico partido) {
        this.partido = partido;
    }

    public List<Voto> getVoto() {
        return voto;
    }

    public void setVoto(List<Voto> voto) {
        this.voto = voto;
    }

    public CamaraElectoral getCamara() {
        return camara;
    }

    public void setCamara(CamaraElectoral camara) {
        this.camara = camara;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.numero;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Lista other = (Lista) obj;
        if (this.numero != other.numero) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Lista{" + "provincia=" + provincia + ", nombreLista=" + nombreLista + ", numero=" + numero + ", candidato=" + candidato + ", partido=" + partido + ", voto=" + voto + ", camara=" + camara + '}';
    }


}
