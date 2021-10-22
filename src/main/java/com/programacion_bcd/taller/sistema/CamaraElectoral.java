package com.programacion_bcd.taller.sistema;

import java.util.List;
import java.util.Objects;

public class CamaraElectoral {
    private List<Elector> elector;
    private List<Lista> lista;
    private List<Candidato> listaCandidatos;
    private List<Distrito> listaDistritos;

    public CamaraElectoral(List<Elector> elector,
                           List<Candidato> listaCandidatos,
                           List<Distrito> listaDistritos, List<Lista> lista) {
        this.elector = elector;
        this.listaCandidatos = listaCandidatos;
        this.listaDistritos = listaDistritos;
        this.lista = lista;
    }

    public List<Elector> getElector() {
        return elector;
    }

    public void setElector(List<Elector> elector) {
        this.elector = elector;
    }

    public List<Candidato> getListaCandidatos() {
        return listaCandidatos;
    }

    public void setListaCandidatos(List<Candidato> listaCandidatos) {
        this.listaCandidatos = listaCandidatos;
    }

    public List<Distrito> getListaDistritos() {
        return listaDistritos;
    }

    public void setListaDistritos(List<Distrito> listaDistritos) {
        this.listaDistritos = listaDistritos;
    }

    public List<Lista> getLista() {
        return lista;
    }

    public void setLista(List<Lista> lista) {
        this.lista = lista;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CamaraElectoral that = (CamaraElectoral) o;
        return Objects.equals(elector, that.elector) &&
               Objects.equals(listaCandidatos, that.listaCandidatos) &&
               Objects.equals(listaDistritos, that.listaDistritos) &&
               Objects.equals(lista, that.lista);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elector, listaCandidatos, listaDistritos, lista);
    }

    @Override
    public String toString() {
        return "CamaraElectoral{" +
               "elector=" + elector +
               ", listaCandidatos=" + listaCandidatos +
               ", listaDistritos=" + listaDistritos +
               ", lista=" + lista +
               '}';
    }
}
