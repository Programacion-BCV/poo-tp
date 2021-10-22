package com.programacion_bcd.taller.sistema;

import java.util.List;
import java.util.Objects;

public class Domicilio {
    private String direccion;
    private String localidad;
    private String departamento;
    private String provincia;

    public Domicilio(String direccion, String localidad,
                     String departamento, String provincia) {
        this.direccion = direccion;
        this.localidad = localidad;
        this.departamento = departamento;
        this.provincia = provincia;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Domicilio domicilio = (Domicilio) o;
        return direccion.equals(domicilio.direccion) &&
               localidad.equals(domicilio.localidad) &&
               departamento.equals(domicilio.departamento) &&
               provincia.equals(domicilio.provincia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(direccion, localidad, departamento, provincia);
    }

    @Override
    public String toString() {
        return "Domicilio{" +
               "direccion='" + direccion + '\'' +
               ", localidad='" + localidad + '\'' +
               ", departamento='" + departamento + '\'' +
               ", provincia='" + provincia + '\'' +
               '}';
    }
}
