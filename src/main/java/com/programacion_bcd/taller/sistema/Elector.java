package com.programacion_bcd.taller.sistema;

import java.time.LocalDate;
import java.util.Objects;

public class Elector {
    private String nombre;
    private String apellido;
    private Integer dni;
    private Domicilio domicilio;
    private String lugarVotacion;
    private LocalDate fechaNac;
    private MesaElectoral mesa;
    private Voto voto;

    public Elector(String nombre, String apellido, Integer dni,
                   Domicilio domicilio, String lugarVotacion,
                   LocalDate fechaNac,
                   MesaElectoral mesa,
                   Voto voto) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.domicilio = domicilio;
        this.lugarVotacion = lugarVotacion;
        this.fechaNac = fechaNac;
        this.mesa = mesa;
        this.voto = voto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public String getLugarVotacion() {
        return lugarVotacion;
    }

    public void setLugarVotacion(String lugarVotacion) {
        this.lugarVotacion = lugarVotacion;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public MesaElectoral getMesa() {
        return mesa;
    }

    public void setMesa(MesaElectoral mesa) {
        this.mesa = mesa;
    }

    public Voto getVoto() {
        return voto;
    }

    public void setVoto(Voto voto) {
        this.voto = voto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Elector elector = (Elector) o;
        return dni.equals(elector.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }

    @Override
    public String toString() {
        return "Elector{" +
               "nombre='" + nombre + '\'' +
               ", apellido='" + apellido + '\'' +
               ", dni=" + dni +
               ", domicilio=" + domicilio +
               ", lugarVotacion='" + lugarVotacion + '\'' +
               ", fechaNac=" + fechaNac +
               ", mesa=" + mesa +
               ", voto=" + voto +
               '}';
    }
}
