package com.programacion_bcd.taller.sistema;

import java.util.List;
import java.util.Objects;

public class Seccion {
    private String nombre;
    private Distrito distrito;
    private List<Circuito> circuitos;

    public Seccion(String nombre,
                   Distrito distrito,
                   List<Circuito> circuitos) {
        this.nombre = nombre;
        this.distrito = distrito;
        this.circuitos = circuitos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }

    public List<Circuito> getCircuitos() {
        return circuitos;
    }

    public void setCircuitos(
            List<Circuito> circuitos) {
        this.circuitos = circuitos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seccion seccion = (Seccion) o;
        return nombre.equals(seccion.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public String toString() {
        return "Seccion{" +
               "nombre='" + nombre + '\'' +
               ", distrito=" + distrito +
               ", circuitos=" + circuitos +
               '}';
    }
}
