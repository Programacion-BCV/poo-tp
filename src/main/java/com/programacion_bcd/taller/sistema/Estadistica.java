package com.programacion_bcd.taller.sistema;

public interface Estadistica {
     /**
     * Conteo de votantes por distrito.
     */
    public void cantVotantes();
    /**
     * Conteo de los votos en blanco por distrito.
     */
    public void cantVotosBlancos();
    /**
     * Conteo de votos por partido en cada distrito.
     */
    public void votoPorPartido();
    /**
     * Calculara el porcentaje de votacion por distrito respecto al padron del mismo.
     */
    public void porcDistrito();
    /**
     * Calculara el porcentaje general de votoacion por cada lista, 
     * incluyendo votos en blanco por cada distrito.
     */
    public void porcGralVotoLista();
    /**
     * Otras estadisticas que surgan relevantes.
     */
    public void otrasEstadisticas();
}
