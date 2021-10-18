package com.programacion_bcd.taller.sistema;

import java.time.LocalDate;
import java.util.Objects;

public class Elector {
    private String nombre;
    private String apellido;
    private int dni;
    private Domicilio domicilio;
    private String lugarDeVotacion;
    private LocalDate fechaNac;
    private MesaElectoral mesa;
    private CamaraElectoral camara;
    private Voto voto;

    public Elector(String nombre, String apellido, int dni, Domicilio domicilio, String lugarDeVotacion, LocalDate fechaNac, MesaElectoral mesa, CamaraElectoral camara, Voto voto) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.domicilio = domicilio;
        this.lugarDeVotacion = lugarDeVotacion;
        this.fechaNac = fechaNac;
        this.mesa = mesa;
        this.camara = camara;
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

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public String getLugarDeVotacion() {
        return lugarDeVotacion;
    }

    public void setLugarDeVotacion(String lugarDeVotacion) {
        this.lugarDeVotacion = lugarDeVotacion;
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

    public CamaraElectoral getCamara() {
        return camara;
    }

    public void setCamara(CamaraElectoral camara) {
        this.camara = camara;
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
        return dni == elector.dni && Objects.equals(nombre, elector.nombre) && Objects.equals(apellido, elector.apellido) && Objects.equals(domicilio, elector.domicilio) && Objects.equals(lugarDeVotacion, elector.lugarDeVotacion) && Objects.equals(fechaNac, elector.fechaNac) && Objects.equals(mesa, elector.mesa) && Objects.equals(camara, elector.camara) && Objects.equals(voto, elector.voto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellido, dni, domicilio, lugarDeVotacion, fechaNac, mesa, camara, voto);
    }

    @Override
    public String toString() {
        return "Elector{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni=" + dni +
                ", domicilio=" + domicilio +
                ", lugarDeVotacion='" + lugarDeVotacion + '\'' +
                ", fechaNac=" + fechaNac +
                ", mesa=" + mesa +
                ", camara=" + camara +
                ", voto=" + voto +
                '}';
    }
}
