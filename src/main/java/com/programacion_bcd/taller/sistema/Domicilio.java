/**
 * Clase Domicilio
 * Permite la construcción del domicilio de cada Elector
 */
package com.programacion_bcd.taller.sistema;

import java.util.Objects;

public class Domicilio {
    private String direccion;
    private String localidad;
    private String departamento;
    private String provincia;

    /**
     * Constructor del Domicilio del Elector
     * @param direccion Dirección de la calle donde vive el Elector
     * @param localidad Localidad en la que vive el Elector
     * @param departamento Departamento de la Localidad donde vive el Elector
     * @param provincia Provincia donde vive el Elector
     */
    public Domicilio(String direccion, String localidad,
                     String departamento, String provincia) {
        this.direccion = direccion;
        this.localidad = localidad;
        this.departamento = departamento;
        this.provincia = provincia;
    }

    /**
     * Devuelve la dirección de la calle donde reside el Elector
     * @return Dirección de la calle en la que reside
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Setea la dirección de la calle donde reside el Elector
     * @param direccion Dirección de la calle en la que reside
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Devuelve la localidad donde vive el Elector
     * @return Localidad donde vive
     */
    public String getLocalidad() {
        return localidad;
    }

    /**
     * Setea la localidad en la que vive el Elector
     * @param localidad Localidad donde vive
     */
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    /**
     * Setea el departamento de la localidad
     * @return Departamento de la localidad
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * Setea el departamento de la localidad
     * @param departamento Departamento de la localidad
     */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    /**
     * Devuelve la provincia donde vive el Elector
     * @return Provincia donde vive
     */
    public String getProvincia() {
        return provincia;
    }

    /**
     * Setea la provincia donde vive el Elector
     * @param provincia Provincia donde vive
     */
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

    /**
     * Concatena en una cadena de caracteres los atributos de Domicilio
     * @return
     */
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
