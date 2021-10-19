package com.programacion_bcd.taller.sistema;

import java.util.List;
import java.util.Objects;

public class Circuito {
    private int numero;
    private Seccion seccion;
    private List<MesaElectoral> listaMesas;

    public Circuito(int numero, Seccion seccion, List<MesaElectoral> listaMesas) {
        this.numero = numero;
        this.seccion = seccion;
        this.listaMesas = listaMesas;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    public List<MesaElectoral> getListaMesas() {
        return listaMesas;
    }

    public void setListaMesas(List<MesaElectoral> listaMesas) {
        this.listaMesas = listaMesas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circuito circuito = (Circuito) o;
        return numero == circuito.numero && Objects.equals(seccion, circuito.seccion) && Objects.equals(listaMesas, circuito.listaMesas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, seccion, listaMesas);
    }
}
