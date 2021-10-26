/**
 * Clase Candidato
 * Se utiliza para crear los candidatos a senadores o diputados
 */

package com.programacion_bcd.taller.sistema;

import java.time.LocalDate;
import java.util.Objects;

public class Candidato extends Elector {
    private TipoCandidato tipoCandidato;
    private Lista lista;

    /**
     * Crea un candidato pasandole por parámetro los atributos de la clase Elector ya que un candidato es un elector también.
     * @param nombre Nombre del candidato
     * @param apellido Apellido del candidato
     * @param dni DNI del candidato
     * @param domicilio Domicilio del Candidato
     * @param lugarVotacion Lugar donde vota el candidato
     * @param fechaNac Fecha de nacimiento del candidato
     * @param mesa Mesa en la que vota el candidato
     * @param voto Voto del candidato
     * @param tipoCandidato Define si el candidato es senador o diputado
     * @param lista Lista a la que pertenece el candidato
     */
    public Candidato(String nombre, String apellido, Integer dni,
                     Domicilio domicilio, String lugarVotacion,
                     LocalDate fechaNac,
                     MesaElectoral mesa,
                     Voto voto,
                     TipoCandidato tipoCandidato,
                     Lista lista) {
        super(nombre, apellido, dni, domicilio, lugarVotacion, fechaNac, mesa,
              voto);
        this.tipoCandidato = tipoCandidato;
        this.lista = lista;
    }

    /**
     * Devuelve el tipo de candidato
     * @return Tipo de candidato
     */
    public TipoCandidato getTipoCandidato() {
        return tipoCandidato;
    }

    /**
     * Setea el tipo de candidato (Senador o Diputado)
     * @param tipoCandidato Senador o Diputado
     */
    public void setTipoCandidato(
            TipoCandidato tipoCandidato) {
        this.tipoCandidato = tipoCandidato;
    }

    /**
     * Devuelve la lista a la que pertenece ese candidato
     * @return Lista del candidato
     */
    public Lista getLista() {
        return lista;
    }

    /**
     * Setea la lista a la que pertenece el candiato
     * @param lista Lista pasada por parámetro
     */
    public void setLista(Lista lista) {
        this.lista = lista;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Candidato candidato = (Candidato) o;
        return tipoCandidato == candidato.tipoCandidato &&
               lista.equals(candidato.lista);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tipoCandidato, lista);
    }
    /**
     * Concatena en un unico String los valores que configuran el estado actual del objeto
     * @return String Distrito
     */
    @Override
    public String toString() {
        return super.toString() + "\n" + "Candidato{" +
               "tipoCandidato=" + tipoCandidato +
               ", lista=" + lista +
               '}';
    }
}
