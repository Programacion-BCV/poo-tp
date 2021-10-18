package com.programacion_bcd.taller.sistema;

public enum TipoCandidato {
    SENADOR("Senador"), DIPUTADO("Diputado");

    private final String tipoCandidato;

    TipoCandidato(String tipoCandidato) {
        this.tipoCandidato = tipoCandidato;
    }

    public String getTipoCandidato() {
        return tipoCandidato;
    }

    @Override
    public String toString() {
        return "TipoCandidato{" +
                "tipoCandidato='" + tipoCandidato + '\'' +
                '}';
    }
}
