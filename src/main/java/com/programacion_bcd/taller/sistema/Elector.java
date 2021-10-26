/**
 * Clase Elector
 * Se utiliza para crear los electores
 */

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

    /**
     * Construtor donde se crea cada uno de los electores
     *
     * @param nombre        Nombre de Elector
     * @param apellido      Apellido del ELector
     * @param dni           DNI del Elector
     * @param domicilio     Domicilio del Elector
     * @param lugarVotacion Lugar donde vota el Elector
     * @param fechaNac      Fecha de nacimiento del Elector
     * @param mesa          Mesa en la que vota un Elector
     * @param voto          Voto del Elector
     */
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

    /**
     * Devuelve el nombre del Elector
     *
     * @return Nombre del elector
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setea el nombre del Elector
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el apellido del Elector
     *
     * @return Apellido del Elector
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Setea el apellido del Elector
     *
     * @param apellido Apellido del Elector
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Devuelve el DNI del Elector
     *
     * @return DNI del Elector
     */
    public Integer getDni() {
        return dni;
    }

    /**
     * Setea el DNI del Elector
     *
     * @param dni DNI del Elector
     */
    public void setDni(Integer dni) {
        this.dni = dni;
    }

    /**
     * Devuelve el domicilio del Elector
     *
     * @return Domicilio del Elector
     */
    public Domicilio getDomicilio() {
        return domicilio;
    }

    /**
     * Setea el Domicilio del Elector
     *
     * @param domicilio Domicilio del Elector
     */
    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    /**
     * Devuelve el lugar donde vota el Elector
     *
     * @return Lugar de votación
     */
    public String getLugarVotacion() {
        return lugarVotacion;
    }

    /**
     * Setea el lugar donde vota un Elector
     *
     * @param lugarVotacion Lugar de votación
     */
    public void setLugarVotacion(String lugarVotacion) {
        this.lugarVotacion = lugarVotacion;
    }

    /**
     * Devuelve la fecha de nacimiento del Elector
     *
     * @return Fecha de nacimiento
     */
    public LocalDate getFechaNac() {
        return fechaNac;
    }

    /**
     * Setea la fecha de nacimiento del Elector
     *
     * @param fechaNac Fecha de nacimiento
     */
    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    /**
     * Devuelve la mesa donde vota el Elector
     *
     * @return Mesa de votación
     */
    public MesaElectoral getMesa() {
        return mesa;
    }

    /**
     * Setea la mesa donde vota el Elector
     *
     * @param mesa Mesa de votación
     */
    public void setMesa(MesaElectoral mesa) {
        this.mesa = mesa;
    }

    /**
     * Devuelve el voto del Elector
     *
     * @return Voto del Elector
     */
    public Voto getVoto() {
        return voto;
    }

    /**
     * Setea el voto del Elector
     *
     * @param voto Voto del Elector
     */
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

    /**
     * Concatena en una cadena de caracteres los atributos de Elector
     *
     * @return String Distrito
     */
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
