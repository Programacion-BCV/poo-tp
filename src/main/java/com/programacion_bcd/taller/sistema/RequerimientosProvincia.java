package com.programacion_bcd.taller.sistema;

import java.util.Objects;

public class RequerimientosProvincia {
    private String nombre;
    private Integer cantidadDiputados;
    private Integer cantidadSenadores;

    /**
     * Constructor para inicializar los requerimientos de cada Provincia.
     *
     * @param nombre            Nombre de la provincia.
     * @param cantidadDiputados Cantidad de diputados de la provincia.
     * @param cantidadSenadores Cantidad de senadores de la provincia.
     */
    public RequerimientosProvincia(String nombre,
                                   Integer cantidadDiputados,
                                   Integer cantidadSenadores) {
        this.nombre = nombre;
        this.cantidadDiputados = cantidadDiputados;
        this.cantidadSenadores = cantidadSenadores;
    }

    /**
     * Devuelve el nombre de la provincia.
     *
     * @return Nombre de la provincia.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setea el nombre de la provincia.
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve la cantidad de diputados de la provincia.
     *
     * @return Cantidad de diputados de la provincia.
     */
    public Integer getCantidadDiputados() {
        return cantidadDiputados;
    }

    /**
     * Setea la cantidad de diputados de la provincia.
     *
     * @param cantidadDiputados Cantidad de diputados de la provincia.
     */
    public void setCantidadDiputados(Integer cantidadDiputados) {
        this.cantidadDiputados = cantidadDiputados;
    }

    /**
     * Devuelve la cantidad de senadores de la provincia.
     *
     * @return Cantidad de senadores de la provincia.
     */
    public Integer getCantidadSenadores() {
        return cantidadSenadores;
    }

    /**
     * Setea la cantidad de senadores de la provincia.
     *
     * @param cantidadSenadores Cantidad de senadores de la provincia.
     */
    public void setCantidadSenadores(Integer cantidadSenadores) {
        this.cantidadSenadores = cantidadSenadores;
    }

    /**
     * Método equals con el campo clave: nombre de la provincia.
     *
     * @param o
     * @return
     */
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

    /**
     * Concatena en una cadena de caracteres los atributos de Requerimientos Provincia.
     *
     * @return
     */
    @Override
    public String toString() {
        return "RequerimientosProvincia{" +
               "nombre='" + nombre + '\'' +
               ", cantidadDiputados=" + cantidadDiputados +
               ", cantidadSenadores=" + cantidadSenadores +
               '}';
    }
}
