/**
 * Interfaz Estadística
 * Es una interfaz para calculo de estadísticas en un distrito.
 */
package com.programacion_bcd.taller.sistema;



public interface Estadistica {
    /**
     * Conteo de votantes por distrito.
     */
    public Integer cantVotantes();

    /**
     * Conteo de los votos en blanco por distrito.
     */
    public Integer cantVotosBlancos();

    /**
     * Conteo de votos por partido en cada distrito.
     */
    public Integer[] votoPorPartido();

    /**
     * Calculara el porcentaje de votacion por distrito respecto al padron del mismo.
     */
    public Double porcDistrito();

    /**
     * Calculara el porcentaje general de votoacion por cada lista,
     * incluyendo votos en blanco por cada distrito.
     */
    public Double[] porcGralVotoLista();

}
