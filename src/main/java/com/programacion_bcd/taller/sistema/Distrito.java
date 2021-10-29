/**
 * Clase Distrito
 * Esta clase se utiliza para inicializar todos los Distritos de las elecciones.
 */
package com.programacion_bcd.taller.sistema;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Distrito implements Estadistica {
    private String nombre;
    private List<Seccion> listaSecciones;

    /**
     * Constructor de la clase que permite la inicialización de un Objeto de tipo Distrito.
     *
     * @param nombre         Nombre del distrito
     * @param listaSecciones Secciones del distrito
     */
    public Distrito(String nombre,
                    List<Seccion> listaSecciones) {
        this.nombre = nombre;
        this.listaSecciones = listaSecciones;
    }

    /**
     * Devuelve el nombre del Distrito.
     *
     * @return Nombre del distrito
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setea el nombre del Distrito.
     *
     * @param nombre Nombre del Distrito.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve la lista de secciones.
     *
     * @return Lista de secciones.
     */
    public List<Seccion> getListaSecciones() {
        return listaSecciones;
    }

    /**
     * Setea la lista de secciones.
     *
     * @param listaSecciones Lista de secciones.
     */
    public void setListaSecciones(
            List<Seccion> listaSecciones) {
        this.listaSecciones = listaSecciones;
    }

    /**
     * Método equals con el valor clave: nombre de distrito.
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Distrito distrito = (Distrito) o;
        return nombre.equals(distrito.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    /**
     * Concatena en una cadena de caracteres los atributos de Distrito.
     *
     * @return
     */
    @Override
    public String toString() {
        return "Distrito{" +
               "nombre='" + nombre + '\'' +
               ", listaSecciones=" + listaSecciones +
               '}' + "\n";
    }

    /**
     * Conteo de votantes por distrito.
     *
     * @return Cantidad de votantes.
     */
    @Override
    public Integer cantVotantes() {

        return this.votosDistrito().size();
    }

    /**
     * Calcula la cantidad de votos en blanco del Distrito.
     *
     * @return Cantidad de votos en blanco.
     */
    @Override
    public Integer cantVotosBlancos() {
        Integer cantidadVotosEnBlanco = 0;
        List<Voto> votos = this.votosDistrito();
        for (int i = 0; i < votos.size(); i++) {
            if (votos.get(i).getVotoDiputados().getProvincia().equals("") &&
                votos.get(i).getVotoSenadores().getProvincia().equals("")) {
                cantidadVotosEnBlanco++;
            }
        }

        return cantidadVotosEnBlanco;
    }

    /**
     * Calcula la cantidad de votos por partido del Distrito.
     *
     * @return Cantidad de votos por partido del Distrito.
     */
    @Override
    public Integer[] votoPorPartido() {
        Integer[] cantidades = {0, 0, 0, 0};
        List<Voto> votos = this.votosDistrito();
        for (int i = 0; i < votos.size(); i++) {

            if (!(votos.get(i).getVotoDiputados().getProvincia().equals("") &&
                  votos.get(i).getVotoSenadores().getProvincia().equals(""))) {

                if (!votos.get(i).getVotoDiputados().getProvincia().equals(
                        "")) {
                    if (votos.get(
                            i).getVotoDiputados().getPartido().getNombre().equals(
                            "Derecha")) {
                        cantidades[0]++;
                    } else if (votos.get(
                            i).getVotoDiputados().getPartido().getNombre().equals(
                            "Izquierda")) {
                        cantidades[1]++;

                    }
                }
                if (!votos.get(i).getVotoSenadores().getProvincia().equals(
                        "")) {
                    if (votos.get(
                            i).getVotoSenadores().getPartido().getNombre().equals(
                            "Derecha")) {
                        cantidades[2]++;
                    } else if (votos.get(
                            i).getVotoSenadores().getPartido().getNombre().equals(
                            "Izquierda")) {
                        cantidades[3]++;
                    }
                }
            }

        }
        return cantidades;
    }

    /**
     * Calcula el porcentaje de votación por Distrito respecto al padrón del mismo.
     *
     * @return Porcentaje de votación por Distrito.
     */
    @Override
    public Double porcDistrito() {
        return (((double) this.votosDistrito().size()) /
                this.electoresDistrito().size()) * 100;
    }

    /**
     * Calcula el porcentaje general de votación por cada lista, incluyendo votos en blanco por cada distrito.
     *
     * @return Porcentaje general de votación por cada lista (incluye votos en blanco).
     */
    @Override
    public Double[] porcGralVotoLista() {
        Integer[] cantidades = this.votoPorPartido();
        Double[] porcentajes = new Double[6];

        porcentajes[0] = ((double) cantidades[0] /
                          ((cantidades[0] + cantidades[1] +
                            this.cantVotosBlancos()))) * 100;
        porcentajes[1] = ((double) cantidades[1] /
                          ((cantidades[0] + cantidades[1] +
                            this.cantVotosBlancos()))) * 100;
        porcentajes[2] = ((double) cantidades[2] /
                          ((cantidades[2] + cantidades[3] +
                            this.cantVotosBlancos()))) * 100;
        porcentajes[3] = ((double) cantidades[3] /
                          ((cantidades[2] + cantidades[3] +
                            this.cantVotosBlancos()))) * 100;
        porcentajes[4] = ((double) this.cantVotosBlancos() /
                          ((cantidades[0] + cantidades[1] +
                            this.cantVotosBlancos()))) * 100;

        porcentajes[5] = ((double) this.cantVotosBlancos() /
                          ((cantidades[2] + cantidades[3] +
                            this.cantVotosBlancos()))) * 100;

        return porcentajes;
    }

    /**
     * Otras estadisticas que surgan relevantes.
     */
    @Override
    public void otrasEstadisticas() {

    }

    private List<Voto> votosDistrito() {

        List<Voto> votos = new ArrayList<>();
        for (int i = 0; i < listaSecciones.size(); i++) {

            for (int j = 0;
                 j < listaSecciones.get(i).getCircuitos().size(); j++) {

                for (int k = 0; k < listaSecciones.get(i).getCircuitos().get(
                        j).getListaMesas().size(); k++) {

                    for (int m = 0;
                         m < listaSecciones.get(i).getCircuitos().get(
                                 j).getListaMesas().get(
                                 k).getElectores().length; m++) {

                        if (listaSecciones.get(i).getCircuitos().get(
                                j).getListaMesas().get(
                                k).getElectores()[m] != null) {

                            if (listaSecciones.get(i).getCircuitos().get(
                                    j).getListaMesas().get(
                                    k).getElectores()[m].getVoto() != null) {

                                votos.add(listaSecciones.get(
                                        i).getCircuitos().get(
                                        j).getListaMesas().get(
                                        k).getElectores()[m].getVoto());
                            }

                        }

                    }

                }
            }

        }

        return votos;
    }

    public List<Elector> electoresDistrito() {
        List<Elector> electores = new ArrayList<>();
        for (int i = 0; i < listaSecciones.size(); i++) {

            for (int j = 0;
                 j < listaSecciones.get(i).getCircuitos().size(); j++) {

                for (int k = 0; k < listaSecciones.get(i).getCircuitos().get(
                        j).getListaMesas().size(); k++) {

                    for (int m = 0;
                         m < listaSecciones.get(i).getCircuitos().get(
                                 j).getListaMesas().get(
                                 k).getElectores().length; m++) {

                        if (listaSecciones.get(i).getCircuitos().get(
                                j).getListaMesas().get(
                                k).getElectores()[m] != null) {

                            electores.add(
                                    listaSecciones.get(i).getCircuitos().get(
                                            j).getListaMesas().get(
                                            k).getElectores()[m]);
                        }

                    }

                }

            }
        }
        return electores;
    }

}
