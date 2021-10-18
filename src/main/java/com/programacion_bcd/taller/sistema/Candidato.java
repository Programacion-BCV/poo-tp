package com.programacion_bcd.taller.sistema;


public class Candidato extends Elector {
    private TipoCandidato tipoCandidato;
    private Lista lista;
    private CamaraElectoral camara;

    public Candidato(TipoCandidato tipoCandidato, Lista lista, CamaraElectoral camara) {
        this.tipoCandidato = tipoCandidato;
        this.lista = lista;
        this.camara = camara;
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

    public CamaraElectoral getCamara() {
        return camara;
    }

    public void setCamara(CamaraElectoral camara) {
        this.camara = camara;
    }

//  equals

    @Override
    public String toString() {
        return "Candidato{" +
                "tipoCandidato=" + tipoCandidato +
                ", lista=" + lista +
                ", camara=" + camara +
                '}';
    }
}
