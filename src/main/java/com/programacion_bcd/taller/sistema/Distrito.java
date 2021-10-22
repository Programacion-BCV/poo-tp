package com.programacion_bcd.taller.sistema;

import java.util.List;
import java.util.Objects;

public class Distrito implements Estadistica {
    private String nombre;
    private List<Seccion> listaSecciones;

    public Distrito(String nombre,
                    List<Seccion> listaSecciones) {
        this.nombre = nombre;
        this.listaSecciones = listaSecciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Seccion> getListaSecciones() {
        return listaSecciones;
    }

    public void setListaSecciones(
            List<Seccion> listaSecciones) {
        this.listaSecciones = listaSecciones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Distrito distrito = (Distrito) o;
        return nombre.equals(distrito.nombre) &&
               listaSecciones.equals(distrito.listaSecciones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, listaSecciones);
    }

    @Override
    public String toString() {
        return "Distrito{" +
               "nombre='" + nombre + '\'' +
               ", listaSecciones=" + listaSecciones +
               '}';
    }
}
