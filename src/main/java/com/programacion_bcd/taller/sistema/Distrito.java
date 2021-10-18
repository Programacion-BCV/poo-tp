package com.programacion_bcd.taller.sistema;

import java.util.List;

public class Distrito implements Estadistica{
    private CamaraElectoral camara;
    private List<Seccion> listaSecciones;

    public Distrito(CamaraElectoral camara, List<Seccion> listaSecciones) {
        this.camara = camara;
        this.listaSecciones = listaSecciones;
    }

    public CamaraElectoral getCamara() {
        return camara;
    }

    public void setCamara(CamaraElectoral camara) {
        this.camara = camara;
    }

    public List<Seccion> getListaSecciones() {
        return listaSecciones;
    }

    public void setListaSecciones(List<Seccion> listaSecciones) {
        this.listaSecciones = listaSecciones;
    }

    @Override
    public String toString() {
        return "Distrito{" +
                "camara=" + camara +
                ", listaSecciones=" + listaSecciones +
                '}';
    }
}
