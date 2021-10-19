package com.programacion_bcd.taller.sistema;

import java.util.List;
import java.util.Objects;

public class Seccion {
    private String nombre;
    private Distrito distrito;
    private List<Circuito> circuitos;

    public Seccion(String nombre, Distrito distrito, List<Circuito> circuitos) {
        this.nombre = nombre;
        this.distrito = distrito;
        this.circuitos = circuitos;
    }

    public List<Circuito> getCircuitos() {
        return circuitos;
    }

    public void setCircuitos(List<Circuito> circuitos) {
        this.circuitos = circuitos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seccion seccion = (Seccion) o;
        return Objects.equals(nombre, seccion.nombre) && Objects.equals(distrito, seccion.distrito) && Objects.equals(circuitos, seccion.circuitos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, distrito, circuitos);
    }
}
