package com.programacion_bcd.taller.sistema;

import java.util.Objects;

public class Seccion {
    private String nombre;
    private Distrito distrito;
    private Circuito circuito;

    public Seccion(String nombre, Distrito distrito, Circuito circuito) {
        this.nombre = nombre;
        this.distrito = distrito;
        this.circuito = circuito;
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

    public Circuito getCircuito() {
        return circuito;
    }

    public void setCircuito(Circuito circuito) {
        this.circuito = circuito;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seccion seccion = (Seccion) o;
        return Objects.equals(nombre, seccion.nombre) && Objects.equals(distrito, seccion.distrito) && Objects.equals(circuito, seccion.circuito);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, distrito, circuito);
    }

    @Override
    public String toString() {
        return "Seccion{" +
                "nombre='" + nombre + '\'' +
                ", distrito=" + distrito +
                ", circuito=" + circuito +
                '}';
    }
}
