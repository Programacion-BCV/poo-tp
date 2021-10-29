/**
 * Enumeración Tipo Candidato
 * Es utilizada para definir si un elector es Senador, Diputado o No es un candidato.
 */
package com.programacion_bcd.taller.sistema;

public enum TipoCandidato {
    SENADOR("Senador"), DIPUTADO("Diputado"), NO_CANDIDATO("No es candidato");

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
