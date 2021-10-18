package com.programacion_bcd.taller.sistema;

import java.util.List;

public class Lista {
    private String provincia;
    private String nombreLista;
    private int numero;
    private List<Candidato> candidato;
    public PartidoPolitico partido;
    private Voto voto;
    private CamaraElectoral camara;

    public Lista(String provincia, String nombreLista, int numero, List<Candidato> candidato, PartidoPolitico partido, Voto voto, CamaraElectoral camara) {
        this.provincia = provincia;
        this.nombreLista = nombreLista;
        this.numero = numero;
        this.candidato = candidato;
        this.partido = partido;
        this.voto = voto;
        this.camara = camara;
    }

}
