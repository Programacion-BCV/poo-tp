/**
 *
 */
package com.programacion_bcd.taller.sistema;

import java.util.List;
import java.util.Objects;

public class Circuito {
    private int numero;
    private String nombre;
    private Seccion seccion;
    private List<MesaElectoral> listaMesas;

    public Circuito(int numero, String nombre, Seccion seccion,
                    List<MesaElectoral> listaMesas) {
        this.numero = numero;
        this.nombre = nombre;
        this.seccion = seccion;
        this.listaMesas = listaMesas;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public void setListaMesas(
            List<MesaElectoral> listaMesas) {
        this.listaMesas = listaMesas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circuito circuito = (Circuito) o;
        return nombre.equals(circuito.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    /**
     * Concatena en una cadena de caracteres los atributos de Circuito
     * @return String Distrito
     */
    @Override
    public String toString() {
        return "Circuito{" +
               "numero=" + numero +
               "nombre=" + nombre +
               ", listaMesas=" + listaMesas +
               '}';
    }
}
