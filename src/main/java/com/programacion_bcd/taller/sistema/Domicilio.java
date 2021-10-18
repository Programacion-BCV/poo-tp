package com.programacion_bcd.taller.sistema;

import java.util.List;
import java.util.Objects;

public class Domicilio {
    private String direccion;
    private String localidad;
    private String departamento;
    private String provincia;
    private List<Elector> electoresDomicilio; //revisar

    public Domicilio(String direccion, String localidad, String departamento, String provincia, List<Elector> electoresDomicilio) {
        this.direccion = direccion;
        this.localidad = localidad;
        this.departamento = departamento;
        this.provincia = provincia;
        this.electoresDomicilio = electoresDomicilio;
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

    public List<Elector> getElectoresDomicilio() {
        return electoresDomicilio;
    }

    public void setElectoresDomicilio(List<Elector> electoresDomicilio) {
        this.electoresDomicilio = electoresDomicilio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Domicilio domicilio = (Domicilio) o;
        return Objects.equals(direccion, domicilio.direccion) && Objects.equals(localidad, domicilio.localidad) && Objects.equals(departamento, domicilio.departamento) && Objects.equals(provincia, domicilio.provincia) && Objects.equals(electoresDomicilio, domicilio.electoresDomicilio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(direccion, localidad, departamento, provincia, electoresDomicilio);
    }

    @Override
    public String toString() {
        return "Domicilio{" +
                "direccion='" + direccion + '\'' +
                ", localidad='" + localidad + '\'' +
                ", departamento='" + departamento + '\'' +
                ", provincia='" + provincia + '\'' +
                ", electoresDomicilio=" + electoresDomicilio +
                '}';
    }
}
