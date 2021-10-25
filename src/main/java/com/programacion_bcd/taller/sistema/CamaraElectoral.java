package com.programacion_bcd.taller.sistema;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CamaraElectoral {
    private List<Elector> electores;
    private List<Lista> listas;
    private List<Candidato> listaCandidatos;
    private List<Distrito> listaDistritos;
    private RequerimientosProvincia[] listaRequerimientos;

    public CamaraElectoral() {
    }

    public CamaraElectoral(
            List<Elector> electores,
            List<Lista> listas,
            List<Candidato> listaCandidatos,
            List<Distrito> listaDistritos,
            RequerimientosProvincia[] listaRequerimientos) {
        this.electores = electores;
        this.listas = listas;
        this.listaCandidatos = listaCandidatos;
        this.listaDistritos = listaDistritos;
        this.listaRequerimientos = listaRequerimientos;
    }

    public List<Elector> getElectores() {
        return electores;
    }

    public void setElectores(
            List<Elector> electores) {
        this.electores = electores;
    }

    public List<Lista> getListas() {
        return listas;
    }

    public void setListas(
            List<Lista> listas) {
        this.listas = listas;
    }

    public List<Candidato> getListaCandidatos() {
        return listaCandidatos;
    }

    public void setListaCandidatos(
            List<Candidato> listaCandidatos) {
        this.listaCandidatos = listaCandidatos;
    }

    public List<Distrito> getListaDistritos() {
        return listaDistritos;
    }

    public void setListaDistritos(
            List<Distrito> listaDistritos) {
        this.listaDistritos = listaDistritos;
    }

    public RequerimientosProvincia[] getListaRequerimientos() {
        return listaRequerimientos;
    }

    public void setListaRequerimientos(
            RequerimientosProvincia[] listaRequerimientos) {
        this.listaRequerimientos = listaRequerimientos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CamaraElectoral that = (CamaraElectoral) o;
        return electores.equals(that.electores) && listas.equals(that.listas) &&
               listaCandidatos.equals(that.listaCandidatos) &&
               listaDistritos.equals(that.listaDistritos) &&
               Arrays.equals(listaRequerimientos,
                             that.listaRequerimientos);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(electores, listas, listaCandidatos,
                                  listaDistritos);
        result = 31 * result + Arrays.hashCode(listaRequerimientos);
        return result;
    }

    @Override
    public String toString() {
        return "CamaraElectoral{" +
               "electores=" + electores +
               ", listas=" + listas +
               ", listaCandidatos=" + listaCandidatos +
               ", listaDistritos=" + listaDistritos +
               ", listaRequerimientos=" +
               Arrays.toString(listaRequerimientos) +
               '}';
    }
}
