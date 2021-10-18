package com.programacion_bcd.taller.sistema;

import java.util.List;
import java.util.Objects;

public class Circuito {
    private int numero;
    private List<Seccion> listaSecciones;
    private List<MesaElectoral> listaMesas;

    public Circuito(int numero, List<Seccion> listaSecciones, List<MesaElectoral> listaMesas) {
        this.numero = numero;
        this.listaSecciones = listaSecciones;
        this.listaMesas = listaMesas;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public List<Seccion> getListaSecciones() {
        return listaSecciones;
    }

    public void setListaSecciones(List<Seccion> listaSecciones) {
        this.listaSecciones = listaSecciones;
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
        return numero == circuito.numero && Objects.equals(listaSecciones, circuito.listaSecciones) && Objects.equals(listaMesas, circuito.listaMesas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, listaSecciones, listaMesas);
    }
}
