/**
 * Clase Lista
 *
 * En esta clase se crean las Listas de los distintos partidos políticos con sus respectivos candidatos
 */
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

    /**
     * Constructor para inicializar cada uno de los objetos de tipo Lista
     * @param provincia Provincia de la Lista
     * @param nombreLista Nombre de la Lista
     * @param numero Número de la Lista
     * @param partido Partido a la que pertenece la Lista
     * @param diputados Candidatos a diputados de la Lista
     * @param senadores Candidatos a senadores de la lista
     * @param voto
     */
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

    /**
     * Devuelve la provincia a la que pertenece la Lista
     * @return Provincia de la Lista
     */
    public String getProvincia() {
        return provincia;
    }

    /**
     * Setea la provincia a la que pertenece la Lista
     * @param provincia Provincia de la Lista
     */
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    /**
     * Devuelve el nombre de la Lista
     * @return Nombre de la Lista
     */
    public String getNombreLista() {
        return nombreLista;
    }

    /**
     * Setea el nombre de la Lista
     * @param nombreLista Nombre de la Lista
     */
    public void setNombreLista(String nombreLista) {
        this.nombreLista = nombreLista;
    }

    /**
     * Devuelve el número de la Lista
     * @return Número de la Lista
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Setea el número de la Lista
     * @param numero Número de la Lista
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Devuelve el Partido Político al que pertenece la Lista
     * @return Partido Político de la Lista
     */
    public PartidoPolitico getPartido() {
        return partido;
    }

    /**
     * Setea el Partido Político de la Lista
     * @param partido Partido Político de la Lista
     */
    public void setPartido(PartidoPolitico partido) {
        this.partido = partido;
    }

    /**
     * Devuelve una lista de candidatos a diputados de la Lista
     * @return Lista de candidatos a diputados
     */
    public List<Candidato> getDiputados() {
        return diputados;
    }

    /**
     * Setea los candidatos a diputados de la Lista
     * @param diputados Lista de candidatos a diputados
     */
    public void setDiputados(
            List<Candidato> diputados) {
        this.diputados = diputados;
    }

    /**
     * Devuelve una lista de candidatos a senadores de la Lista
     * @return Lista de candidatos a senadores
     */
    public List<Candidato> getSenadores() {
        return senadores;
    }

    /**
     * Setea los candidatos a senadores de la Lista
     * @param senadores Lista de candidatos a senadores
     */
    public void setSenadores(
            List<Candidato> senadores) {
        this.senadores = senadores;
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
               ", diputados=" + diputados +
               ", senadores=" + senadores +
               ", voto=" + voto +
               '}';
    }
}
