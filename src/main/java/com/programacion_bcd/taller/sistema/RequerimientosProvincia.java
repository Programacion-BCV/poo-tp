package com.programacion_bcd.taller.sistema;

import java.util.Objects;

public class RequerimientosProvincia {
    private String nombre;
    private Integer cantidadDiputados;
    private Integer cantidadSenadores;

    public RequerimientosProvincia(String nombre,
                                   Integer cantidadDiputados,
                                   Integer cantidadSenadores) {
        this.nombre = nombre;
        this.cantidadDiputados = cantidadDiputados;
        this.cantidadSenadores = cantidadSenadores;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidadDiputados() {
        return cantidadDiputados;
    }

    public void setCantidadDiputados(Integer cantidadDiputados) {
        this.cantidadDiputados = cantidadDiputados;
    }

    public Integer getCantidadSenadores() {
        return cantidadSenadores;
    }

    public void setCantidadSenadores(Integer cantidadSenadores) {
        this.cantidadSenadores = cantidadSenadores;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequerimientosProvincia that = (RequerimientosProvincia) o;
        return nombre.equals(that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public String toString() {
        return "RequerimientosProvincia{" +
               "nombre='" + nombre + '\'' +
               ", cantidadDiputados=" + cantidadDiputados +
               ", cantidadSenadores=" + cantidadSenadores +
               '}';
    }
}
