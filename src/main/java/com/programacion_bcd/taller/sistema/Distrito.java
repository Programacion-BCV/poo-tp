/**
 * Clase Distrito
 * Esta clase define el distrito de cada elector donde debe votar
 */
package com.programacion_bcd.taller.sistema;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Distrito implements Estadistica {
    private String nombre;
    private List<Seccion> listaSecciones;

    /**
     * @param nombre         nombre del distrito
     * @param listaSecciones secciones del distrito
     */
    public Distrito(String nombre,
                    List<Seccion> listaSecciones) {
        this.nombre = nombre;
        this.listaSecciones = listaSecciones;
    }

    /**
     * retorna nombre del Distrito
     *
     * @return String Nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Asigna nombre de Distrito
     *
     * @param nombre String
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * retorna lista de Seccion
     *
     * @return List listaSecciones
     */
    public List<Seccion> getListaSecciones() {
        return listaSecciones;
    }

    /**
     * Asigna Lista de Seccion
     *
     * @param listaSecciones
     */
    public void setListaSecciones(
            List<Seccion> listaSecciones) {
        this.listaSecciones = listaSecciones;
    }

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
     * Concatena en una cadena de caracteres los atributos de Distrito
     *
     * @return String Distrito
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
     */
    @Override
    public Integer cantVotantes() {

        return this.votosDistrito().size();
    }

    /**
     * Conteo de los votos en blanco por distrito.
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
     * Conteo de votos por partido en cada distrito.
     */
    @Override
    public Integer[] votoPorPartido() {
        Integer[] cantidades = {0, 0, 0, 0};
        List<Voto> votos = this.votosDistrito();
        for (int i = 0; i < votos.size(); i++) {

            if (!(votos.get(i).getVotoDiputados().getProvincia().equals("") &&
                  votos.get(i).getVotoSenadores().getProvincia().equals(""))) {

                if (votos.get(
                        i).getVotoDiputados().getPartido().getNombre().equals(
                        "Derecha")) {
                    cantidades[0]++;
                } else if (votos.get(
                        i).getVotoDiputados().getPartido().getNombre().equals(
                        "Izquierda")) {
                    cantidades[1]++;

                }
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
        return cantidades;
    }

    /**
     * Calculara el porcentaje de votacion por distrito respecto al padron del mismo.
     */
    @Override
    public Double porcDistrito() {
        return (((double) this.votosDistrito().size()) /
                this.electoresDistrito().size()) * 100;
    }

    /**
     * Calculara el porcentaje general de votacion por cada lista,
     * incluyendo votos en blanco por cada distrito.
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

    private List<Elector> electoresDistrito() {
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
