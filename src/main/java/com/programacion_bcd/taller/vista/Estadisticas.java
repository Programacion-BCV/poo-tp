/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.programacion_bcd.taller.vista;

import com.programacion_bcd.taller.sistema.Distrito;
import com.programacion_bcd.taller.sistema.Elector;
import com.programacion_bcd.taller.sistema.Lista;
import com.programacion_bcd.taller.sistema.Voto;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author confaa
 */
public class Estadisticas extends javax.swing.JFrame {

    public static Distrito distritoEstadistica;

    /**
     * Creates new form Votacion
     */
    public Estadisticas() {
        initComponents();
        this.setLocationRelativeTo(null);

        List<Lista> listasDistrito = this.traeListasDistrito(
                distritoEstadistica.getNombre());
        Integer[] cantidadesPorPartido = distritoEstadistica.votoPorPartido();
        Double[] porcentajesTotales = distritoEstadistica.porcGralVotoLista();
        jButtonAnt.setVisible(false);

        jLabelVotacionProvincia.setText(
                jLabelVotacionProvincia.getText() + " "
                + distritoEstadistica.getNombre());

        for (int i = 0; i < listasDistrito.size(); i++) {

            if (listasDistrito.get(i).getPartido().getNombre().equals(
                    "Derecha")) {
                jLabelBarDD.setText(
                        "Lista " + listasDistrito.get(i).getNombreLista() +
                        " - " +
                        listasDistrito.get(i).getNumero());
                jLabelBarSD.setText(
                        "Lista " + listasDistrito.get(i).getNombreLista() +
                        " - " +
                        listasDistrito.get(i).getNumero());
            } else {
                jLabelBarDI.setText(
                        "Lista " + listasDistrito.get(i).getNombreLista() +
                        " - " +
                        listasDistrito.get(i).getNumero());
                jLabelBarSI.setText(
                        "Lista " + listasDistrito.get(i).getNombreLista() +
                        " - " +
                        listasDistrito.get(i).getNumero());
            }

        }
        Double porcentaje = ((double) (cantidadesPorPartido[0]) /
                             (cantidadesPorPartido[0] +
                              cantidadesPorPartido[1])) * 100;
        if (cantidadesPorPartido[0] == 0) {
            jLabelPorcentajeDD.setText("0%");
            jProgressBarDD.setValue(0);
            jLabelCantidadVotosDD.setText(0 + " votos");
        } else {
            jLabelPorcentajeDD.setText(porcentaje + "%");
            int porcentajeBar = (int) Math.round(porcentaje);
            jProgressBarDD.setValue(porcentajeBar);
            jLabelCantidadVotosDD.setText(cantidadesPorPartido[0] + " votos");

        }

        porcentaje = ((double) (cantidadesPorPartido[1]) /
                      (cantidadesPorPartido[0] +
                       cantidadesPorPartido[1])) * 100;

        if (cantidadesPorPartido[1] == 0) {
            jLabelPorcentajeDI.setText("0%");
            jProgressBarDI.setValue(0);
            jLabelCantidadVotosDI.setText(0 + " votos");
        } else {
            jLabelPorcentajeDI.setText(porcentaje + "%");
            int porcentajeBar = (int) Math.round(porcentaje);
            jProgressBarDI.setValue(porcentajeBar);
            jLabelCantidadVotosDI.setText(cantidadesPorPartido[1] + " votos");
        }

        porcentaje = ((double) (cantidadesPorPartido[2]) /
                      (cantidadesPorPartido[2] +
                       cantidadesPorPartido[3])) * 100;
        if (cantidadesPorPartido[2] == 0) {
            jLabelPorcentajeSD.setText("0%");
            jProgressBarSD.setValue(0);
            jLabelCantidadVotosSD.setText(0 + " votos");
        } else {
            jLabelPorcentajeSD.setText(porcentaje + "%");
            int porcentajeBar = (int) Math.round(porcentaje);
            jProgressBarSD.setValue(porcentajeBar);
            jLabelCantidadVotosSD.setText(cantidadesPorPartido[2] + " votos");
        }
        porcentaje = ((double) (cantidadesPorPartido[3]) /
                      (cantidadesPorPartido[2] +
                       cantidadesPorPartido[3])) * 100;
        if (cantidadesPorPartido[3] == 0) {
            jLabelPorcentajeSI.setText("0%");
            jProgressBarSI.setValue(0);
            jLabelCantidadVotosSI.setText(0 + " votos");
        } else {
            jLabelPorcentajeSI.setText(porcentaje + "%");
            int porcentajeBar = (int) Math.round(porcentaje);
            jProgressBarSI.setValue(porcentajeBar);
            jLabelCantidadVotosSI.setText(cantidadesPorPartido[3] + " votos");
        }

        jLabelTotalPadron.setText(jLabelTotalPadron.getText() + " " +
                                  distritoEstadistica.electoresDistrito().size() +
                                  " personas");

        jLabelVotaron.setText(jLabelVotaron.getText() + " " +
                              distritoEstadistica.cantVotantes() +
                              " personas (" +
                              distritoEstadistica.porcDistrito() +
                              "% del padrón)");

        jLabelTotalVotosD.setText(jLabelTotalVotosD.getText() + " " +
                                  (cantidadesPorPartido[0] +
                                   cantidadesPorPartido[1] +
                                   distritoEstadistica.cantVotosBlancos()) +
                                  (distritoEstadistica.cantVotantes()== 0
                                   ? " (0%)" : " (100%)"));

        jLabelVotosDD.setText(
                jLabelVotosDD.getText() + " " + cantidadesPorPartido[0] +
                " personas (" + (Double.isNaN(porcentajesTotales[0]) ? 0
                                                                     : porcentajesTotales[0]) +
                "%)");
        jLabelVotosDI.setText(
                jLabelVotosDI.getText() + " " + cantidadesPorPartido[1] +
                " personas (" + (Double.isNaN(porcentajesTotales[1]) ? 0
                                                                     : porcentajesTotales[1]) +
                "%)");
        jLabelVotosBlancoD.setText(
                jLabelVotosBlancoD.getText() + " " +
                distritoEstadistica.cantVotosBlancos() +
                " personas (" + (Double.isNaN(porcentajesTotales[4]) ? 0
                                                                     : porcentajesTotales[4]) +
                "%)");

        jLabelTotalVotosS.setText(jLabelTotalVotosS.getText() + " " +
                                  (cantidadesPorPartido[2] +
                                   cantidadesPorPartido[3] +
                                   distritoEstadistica.cantVotosBlancos()) +
                                  (distritoEstadistica.cantVotantes() == 0
                                   ? " (0%)" : " (100%)"));

        jLabelVotosSD.setText(
                jLabelVotosSD.getText() + " " + cantidadesPorPartido[2] +
                " personas (" + (Double.isNaN(porcentajesTotales[2]) ? 0
                                                                     : porcentajesTotales[2]) +
                "%)");
        jLabelVotosSI.setText(
                jLabelVotosSI.getText() + " " + cantidadesPorPartido[3] +
                " personas (" + (Double.isNaN(porcentajesTotales[3]) ? 0
                                                                     : porcentajesTotales[3]) +
                "%)");

        jLabelVotosBlancoS.setText(
                jLabelVotosBlancoS.getText() + " " +
                distritoEstadistica.cantVotosBlancos() +
                " personas (" + (Double.isNaN(porcentajesTotales[5]) ? 0
                                                                     : porcentajesTotales[5]) +
                "%)");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPaneMenuVotacion = new javax.swing.JTabbedPane();
        jPanelDiputados = new javax.swing.JPanel();
        jLayeredPaneDiputados = new javax.swing.JLayeredPane();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jProgressBarDD = new javax.swing.JProgressBar();
        jLabelPorcentajeDD = new javax.swing.JLabel();
        jLabelBarDD = new javax.swing.JLabel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jLabelPorcentajeDI = new javax.swing.JLabel();
        jProgressBarDI = new javax.swing.JProgressBar();
        jLabelBarDI = new javax.swing.JLabel();
        jLabelCantidadVotosDD = new javax.swing.JLabel();
        jLabelCantidadVotosDI = new javax.swing.JLabel();
        jPanelSenadores = new javax.swing.JPanel();
        jLayeredPaneSenadores = new javax.swing.JLayeredPane();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        jLabelPorcentajeSD = new javax.swing.JLabel();
        jProgressBarSD = new javax.swing.JProgressBar();
        jLabelBarSD = new javax.swing.JLabel();
        jLayeredPane4 = new javax.swing.JLayeredPane();
        jLabelPorcentajeSI = new javax.swing.JLabel();
        jProgressBarSI = new javax.swing.JProgressBar();
        jLabelBarSI = new javax.swing.JLabel();
        jLabelCantidadVotosSD = new javax.swing.JLabel();
        jLabelCantidadVotosSI = new javax.swing.JLabel();
        jPanelDistrito = new javax.swing.JPanel();
        jLayeredPaneSeleccionados = new javax.swing.JLayeredPane();
        jLabelTotalPadron = new javax.swing.JLabel();
        jLabelVotaron = new javax.swing.JLabel();
        jLayeredPane7 = new javax.swing.JLayeredPane();
        jLabelVotosDD = new javax.swing.JLabel();
        jLabelVotosDI = new javax.swing.JLabel();
        jLabelVotosBlancoD = new javax.swing.JLabel();
        jLabelTotalVotosD = new javax.swing.JLabel();
        jLayeredPane8 = new javax.swing.JLayeredPane();
        jLabelVotosSI = new javax.swing.JLabel();
        jLabelVotosSD = new javax.swing.JLabel();
        jLabelVotosBlancoS = new javax.swing.JLabel();
        jLabelTotalVotosS = new javax.swing.JLabel();
        jLabelVotacionProvincia = new javax.swing.JLabel();
        jPanelBotones = new javax.swing.JPanel();
        jLayeredPane5 = new javax.swing.JLayeredPane();
        jButtonSig = new javax.swing.JButton();
        jButtonAnt = new javax.swing.JButton();
        jButtonSalirEstadistica = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPaneMenuVotacion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTabbedPaneMenuVotacion.setFocusable(false);
        jTabbedPaneMenuVotacion.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jTabbedPaneMenuVotacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPaneMenuVotacionMouseClicked(evt);
            }
        });

        jPanelDiputados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelDiputadosMouseClicked(evt);
            }
        });

        jProgressBarDD.setValue(50);

        jLabelPorcentajeDD.setText("Porcentaje");

        jLabelBarDD.setText("DatosPartidoLista");

        jLayeredPane1.setLayer(jProgressBarDD, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabelPorcentajeDD, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabelBarDD, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelBarDD)
                .addGap(18, 18, 18)
                .addComponent(jProgressBarDD, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelPorcentajeDD)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jProgressBarDD, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelPorcentajeDD)
                            .addComponent(jLabelBarDD)))))
        );

        jLabelPorcentajeDI.setText("Porcentaje");

        jProgressBarDI.setValue(50);

        jLabelBarDI.setText("DatosPartidoLista");

        jLayeredPane2.setLayer(jLabelPorcentajeDI, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jProgressBarDI, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabelBarDI, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabelBarDI)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jProgressBarDI, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelPorcentajeDI)
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jLayeredPane2Layout.createSequentialGroup()
                            .addComponent(jProgressBarDI, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                            .addComponent(jLabelPorcentajeDI)
                            .addGap(22, 22, 22)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                        .addComponent(jLabelBarDI)
                        .addGap(20, 20, 20))))
        );

        jLabelCantidadVotosDD.setText("jLabel3");

        jLabelCantidadVotosDI.setText("jLabel3");

        jLayeredPaneDiputados.setLayer(jLayeredPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneDiputados.setLayer(jLayeredPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneDiputados.setLayer(jLabelCantidadVotosDD, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneDiputados.setLayer(jLabelCantidadVotosDI, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPaneDiputadosLayout = new javax.swing.GroupLayout(jLayeredPaneDiputados);
        jLayeredPaneDiputados.setLayout(jLayeredPaneDiputadosLayout);
        jLayeredPaneDiputadosLayout.setHorizontalGroup(
            jLayeredPaneDiputadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPaneDiputadosLayout.createSequentialGroup()
                .addGroup(jLayeredPaneDiputadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPaneDiputadosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPaneDiputadosLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPaneDiputadosLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jLayeredPaneDiputadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCantidadVotosDI, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelCantidadVotosDD, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(178, 178, 178))
        );
        jLayeredPaneDiputadosLayout.setVerticalGroup(
            jLayeredPaneDiputadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPaneDiputadosLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelCantidadVotosDD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelCantidadVotosDI)
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout jPanelDiputadosLayout = new javax.swing.GroupLayout(jPanelDiputados);
        jPanelDiputados.setLayout(jPanelDiputadosLayout);
        jPanelDiputadosLayout.setHorizontalGroup(
            jPanelDiputadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDiputadosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLayeredPaneDiputados, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelDiputadosLayout.setVerticalGroup(
            jPanelDiputadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDiputadosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLayeredPaneDiputados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPaneMenuVotacion.addTab("Elección de Diputados", jPanelDiputados);

        jPanelSenadores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelSenadoresMouseClicked(evt);
            }
        });

        jLabelPorcentajeSD.setText("Porcentaje");

        jProgressBarSD.setValue(50);

        jLabelBarSD.setText("DatosPartidoLista");

        jLayeredPane3.setLayer(jLabelPorcentajeSD, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jProgressBarSD, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabelBarSD, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane3Layout = new javax.swing.GroupLayout(jLayeredPane3);
        jLayeredPane3.setLayout(jLayeredPane3Layout);
        jLayeredPane3Layout.setHorizontalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabelBarSD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jProgressBarSD, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelPorcentajeSD)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jLayeredPane3Layout.setVerticalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane3Layout.createSequentialGroup()
                        .addComponent(jProgressBarSD, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane3Layout.createSequentialGroup()
                        .addComponent(jLabelPorcentajeSD)
                        .addGap(21, 21, 21))))
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabelBarSD))
        );

        jLabelPorcentajeSI.setText("Porcentaje");

        jProgressBarSI.setValue(50);

        jLabelBarSI.setText("DatosPartidoLista");

        jLayeredPane4.setLayer(jLabelPorcentajeSI, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jProgressBarSI, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabelBarSI, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane4Layout = new javax.swing.GroupLayout(jLayeredPane4);
        jLayeredPane4.setLayout(jLayeredPane4Layout);
        jLayeredPane4Layout.setHorizontalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelBarSI)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jProgressBarSI, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelPorcentajeSI)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jLayeredPane4Layout.setVerticalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jProgressBarSI, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane4Layout.createSequentialGroup()
                                .addComponent(jLabelPorcentajeSI)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane4Layout.createSequentialGroup()
                                .addComponent(jLabelBarSI)
                                .addGap(13, 13, 13)))))
                .addContainerGap())
        );

        jLabelCantidadVotosSD.setText("jLabel3");

        jLabelCantidadVotosSI.setText("jLabel4");

        jLayeredPaneSenadores.setLayer(jLayeredPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneSenadores.setLayer(jLayeredPane4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneSenadores.setLayer(jLabelCantidadVotosSD, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneSenadores.setLayer(jLabelCantidadVotosSI, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPaneSenadoresLayout = new javax.swing.GroupLayout(jLayeredPaneSenadores);
        jLayeredPaneSenadores.setLayout(jLayeredPaneSenadoresLayout);
        jLayeredPaneSenadoresLayout.setHorizontalGroup(
            jLayeredPaneSenadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPaneSenadoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPaneSenadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPaneSenadoresLayout.createSequentialGroup()
                        .addGroup(jLayeredPaneSenadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLayeredPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPaneSenadoresLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jLayeredPaneSenadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPaneSenadoresLayout.createSequentialGroup()
                                .addComponent(jLabelCantidadVotosSD)
                                .addGap(117, 117, 117))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPaneSenadoresLayout.createSequentialGroup()
                                .addComponent(jLabelCantidadVotosSI)
                                .addGap(120, 120, 120))))))
        );
        jLayeredPaneSenadoresLayout.setVerticalGroup(
            jLayeredPaneSenadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPaneSenadoresLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelCantidadVotosSD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addComponent(jLayeredPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelCantidadVotosSI)
                .addGap(7, 7, 7))
        );

        javax.swing.GroupLayout jPanelSenadoresLayout = new javax.swing.GroupLayout(jPanelSenadores);
        jPanelSenadores.setLayout(jPanelSenadoresLayout);
        jPanelSenadoresLayout.setHorizontalGroup(
            jPanelSenadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSenadoresLayout.createSequentialGroup()
                .addContainerGap(286, Short.MAX_VALUE)
                .addComponent(jLayeredPaneSenadores, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(286, Short.MAX_VALUE))
        );
        jPanelSenadoresLayout.setVerticalGroup(
            jPanelSenadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSenadoresLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jLayeredPaneSenadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jTabbedPaneMenuVotacion.addTab("Elección de Senadores", jPanelSenadores);

        jLabelTotalPadron.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        jLabelTotalPadron.setText("Total padrón:");

        jLabelVotaron.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        jLabelVotaron.setText("Cantidad de votantes:");

        jLabelVotosDD.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabelVotosDD.setText("Votos Diputados Partido Derecha:");

        jLabelVotosDI.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabelVotosDI.setText("Votos Diputados Partido Izquierda:");

        jLabelVotosBlancoD.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabelVotosBlancoD.setText("Cantidad de votos en blanco:");

        jLabelTotalVotosD.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        jLabelTotalVotosD.setText("Total Votos Diputados:");

        jLayeredPane7.setLayer(jLabelVotosDD, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane7.setLayer(jLabelVotosDI, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane7.setLayer(jLabelVotosBlancoD, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane7.setLayer(jLabelTotalVotosD, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane7Layout = new javax.swing.GroupLayout(jLayeredPane7);
        jLayeredPane7.setLayout(jLayeredPane7Layout);
        jLayeredPane7Layout.setHorizontalGroup(
            jLayeredPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTotalVotosD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jLayeredPane7Layout.createSequentialGroup()
                        .addGroup(jLayeredPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelVotosDI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelVotosBlancoD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelVotosDD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jLayeredPane7Layout.setVerticalGroup(
            jLayeredPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTotalVotosD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelVotosDD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelVotosDI)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelVotosBlancoD)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jLabelVotosSI.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabelVotosSI.setText("Votos Senadores Partido Izquierda:");

        jLabelVotosSD.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabelVotosSD.setText("Votos Senadores Partido Derecha:");

        jLabelVotosBlancoS.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabelVotosBlancoS.setText("Cantidad de votos en blanco:");

        jLabelTotalVotosS.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        jLabelTotalVotosS.setText("Total Votos Senadores:");

        jLayeredPane8.setLayer(jLabelVotosSI, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane8.setLayer(jLabelVotosSD, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane8.setLayer(jLabelVotosBlancoS, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane8.setLayer(jLabelTotalVotosS, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane8Layout = new javax.swing.GroupLayout(jLayeredPane8);
        jLayeredPane8.setLayout(jLayeredPane8Layout);
        jLayeredPane8Layout.setHorizontalGroup(
            jLayeredPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelVotosSD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelTotalVotosS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jLayeredPane8Layout.createSequentialGroup()
                        .addGroup(jLayeredPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelVotosSI, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
                            .addComponent(jLabelVotosBlancoS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jLayeredPane8Layout.setVerticalGroup(
            jLayeredPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane8Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabelTotalVotosS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelVotosSD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelVotosSI)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelVotosBlancoS)
                .addContainerGap())
        );

        jLayeredPaneSeleccionados.setLayer(jLabelTotalPadron, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneSeleccionados.setLayer(jLabelVotaron, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneSeleccionados.setLayer(jLayeredPane7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPaneSeleccionados.setLayer(jLayeredPane8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPaneSeleccionadosLayout = new javax.swing.GroupLayout(jLayeredPaneSeleccionados);
        jLayeredPaneSeleccionados.setLayout(jLayeredPaneSeleccionadosLayout);
        jLayeredPaneSeleccionadosLayout.setHorizontalGroup(
            jLayeredPaneSeleccionadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPaneSeleccionadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPaneSeleccionadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPaneSeleccionadosLayout.createSequentialGroup()
                        .addGroup(jLayeredPaneSeleccionadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelTotalPadron, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelVotaron, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addComponent(jLayeredPane7)
                    .addComponent(jLayeredPane8)))
        );
        jLayeredPaneSeleccionadosLayout.setVerticalGroup(
            jLayeredPaneSeleccionadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPaneSeleccionadosLayout.createSequentialGroup()
                .addComponent(jLabelTotalPadron)
                .addGap(18, 18, 18)
                .addComponent(jLabelVotaron)
                .addGap(43, 43, 43)
                .addComponent(jLayeredPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane8)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelDistritoLayout = new javax.swing.GroupLayout(jPanelDistrito);
        jPanelDistrito.setLayout(jPanelDistritoLayout);
        jPanelDistritoLayout.setHorizontalGroup(
            jPanelDistritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDistritoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLayeredPaneSeleccionados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelDistritoLayout.setVerticalGroup(
            jPanelDistritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDistritoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLayeredPaneSeleccionados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPaneMenuVotacion.addTab("Estadisticas generales Distrito", jPanelDistrito);

        jLabelVotacionProvincia.setFont(new java.awt.Font("Roboto", 0, 36)); // NOI18N
        jLabelVotacionProvincia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelVotacionProvincia.setText(" Elecciones PASO 2021 - Distrito");

        jButtonSig.setBackground(new java.awt.Color(13, 110, 253));
        jButtonSig.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jButtonSig.setText("Siguiente");
        jButtonSig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSigActionPerformed(evt);
            }
        });

        jButtonAnt.setBackground(new java.awt.Color(13, 110, 253));
        jButtonAnt.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jButtonAnt.setText("Atras");
        jButtonAnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAntActionPerformed(evt);
            }
        });

        jButtonSalirEstadistica.setBackground(new java.awt.Color(220, 53, 69));
        jButtonSalirEstadistica.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jButtonSalirEstadistica.setText("Salir");
        jButtonSalirEstadistica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirEstadisticaActionPerformed(evt);
            }
        });

        jLayeredPane5.setLayer(jButtonSig, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(jButtonAnt, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(jButtonSalirEstadistica, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane5Layout = new javax.swing.GroupLayout(jLayeredPane5);
        jLayeredPane5.setLayout(jLayeredPane5Layout);
        jLayeredPane5Layout.setHorizontalGroup(
            jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonAnt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonSalirEstadistica)
                .addGap(345, 345, 345)
                .addComponent(jButtonSig)
                .addContainerGap())
        );
        jLayeredPane5Layout.setVerticalGroup(
            jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSig)
                    .addComponent(jButtonAnt)
                    .addComponent(jButtonSalirEstadistica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelBotonesLayout = new javax.swing.GroupLayout(jPanelBotones);
        jPanelBotones.setLayout(jPanelBotonesLayout);
        jPanelBotonesLayout.setHorizontalGroup(
            jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotonesLayout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(jLayeredPane5)
                .addGap(89, 89, 89))
        );
        jPanelBotonesLayout.setVerticalGroup(
            jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBotonesLayout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(jLayeredPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneMenuVotacion)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelVotacionProvincia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelVotacionProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPaneMenuVotacion, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSigActionPerformed(
            java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSigActionPerformed
        // TODO add your handling code here:

        if (jTabbedPaneMenuVotacion.getSelectedIndex() < 2) {
            int i = jTabbedPaneMenuVotacion.getSelectedIndex();
            jTabbedPaneMenuVotacion.setSelectedIndex(++i);
            this.jButtonSig.setVisible(true);
            this.jButtonAnt.setVisible(true);

        }
        if (jTabbedPaneMenuVotacion.getSelectedIndex() == 2) {
            this.jButtonSig.setVisible(false);
            this.jButtonAnt.setVisible(true);
        }

    }//GEN-LAST:event_jButtonSigActionPerformed

    private void jButtonAntActionPerformed(
            java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAntActionPerformed
        // TODO add your handling code here:

        if (jTabbedPaneMenuVotacion.getSelectedIndex() > 0) {
            int i = jTabbedPaneMenuVotacion.getSelectedIndex();
            jTabbedPaneMenuVotacion.setSelectedIndex(--i);
            this.jButtonAnt.setVisible(true);
        }
        if (jTabbedPaneMenuVotacion.getSelectedIndex() == 0) {
            this.jButtonAnt.setVisible(false);
        } else if (jTabbedPaneMenuVotacion.getSelectedIndex() == 1) {
            this.jButtonSig.setVisible(true);

        }

    }//GEN-LAST:event_jButtonAntActionPerformed

    private void jTabbedPaneMenuVotacionMouseClicked(
            java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPaneMenuVotacionMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jTabbedPaneMenuVotacionMouseClicked

    private void jPanelDiputadosMouseClicked(
            java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelDiputadosMouseClicked
        // TODO add your handling code here:

        ;
    }//GEN-LAST:event_jPanelDiputadosMouseClicked

    private void jPanelSenadoresMouseClicked(
            java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelSenadoresMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jPanelSenadoresMouseClicked

    private void jPanelSeleccionadosMouseClicked(
            java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelSeleccionadosMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jPanelSeleccionadosMouseClicked

    private void jButtonSalirEstadisticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirEstadisticaActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        Main main = new Main();
        main.setVisible(true);
    }//GEN-LAST:event_jButtonSalirEstadisticaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(
                    Estadisticas.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(
                    Estadisticas.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(
                    Estadisticas.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(
                    Estadisticas.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Estadisticas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnt;
    private javax.swing.JButton jButtonSalirEstadistica;
    private javax.swing.JButton jButtonSig;
    private javax.swing.JLabel jLabelBarDD;
    private javax.swing.JLabel jLabelBarDI;
    private javax.swing.JLabel jLabelBarSD;
    private javax.swing.JLabel jLabelBarSI;
    private javax.swing.JLabel jLabelCantidadVotosDD;
    private javax.swing.JLabel jLabelCantidadVotosDI;
    private javax.swing.JLabel jLabelCantidadVotosSD;
    private javax.swing.JLabel jLabelCantidadVotosSI;
    private javax.swing.JLabel jLabelPorcentajeDD;
    private javax.swing.JLabel jLabelPorcentajeDI;
    private javax.swing.JLabel jLabelPorcentajeSD;
    private javax.swing.JLabel jLabelPorcentajeSI;
    private javax.swing.JLabel jLabelTotalPadron;
    private javax.swing.JLabel jLabelTotalVotosD;
    private javax.swing.JLabel jLabelTotalVotosS;
    private javax.swing.JLabel jLabelVotacionProvincia;
    private javax.swing.JLabel jLabelVotaron;
    private javax.swing.JLabel jLabelVotosBlancoD;
    private javax.swing.JLabel jLabelVotosBlancoS;
    private javax.swing.JLabel jLabelVotosDD;
    private javax.swing.JLabel jLabelVotosDI;
    private javax.swing.JLabel jLabelVotosSD;
    private javax.swing.JLabel jLabelVotosSI;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JLayeredPane jLayeredPane4;
    private javax.swing.JLayeredPane jLayeredPane5;
    private javax.swing.JLayeredPane jLayeredPane7;
    private javax.swing.JLayeredPane jLayeredPane8;
    private javax.swing.JLayeredPane jLayeredPaneDiputados;
    private javax.swing.JLayeredPane jLayeredPaneSeleccionados;
    private javax.swing.JLayeredPane jLayeredPaneSenadores;
    private javax.swing.JPanel jPanelBotones;
    private javax.swing.JPanel jPanelDiputados;
    private javax.swing.JPanel jPanelDistrito;
    private javax.swing.JPanel jPanelSenadores;
    private javax.swing.JProgressBar jProgressBarDD;
    private javax.swing.JProgressBar jProgressBarDI;
    private javax.swing.JProgressBar jProgressBarSD;
    private javax.swing.JProgressBar jProgressBarSI;
    private javax.swing.JTabbedPane jTabbedPaneMenuVotacion;
    // End of variables declaration//GEN-END:variables

    /**
     * Devuelve las listas de un Distrito pasado por parámetro.
     *
     * @param distrito Distrito que se desea traer sus listas.
     * @return Lista de listas.
     */
    public List<Lista> traeListasDistrito(String distrito) {
        List<Lista> listasRetorno = new ArrayList<>();

        for (int i = 0;
             i < Main.camaraElectoralArgentina.getListas().size(); i++) {

            if (Main.camaraElectoralArgentina.getListas().get(
                    i).getProvincia().equals(distrito)) {
                listasRetorno.add(
                        Main.camaraElectoralArgentina.getListas().get(i));
            }

        }

        return listasRetorno;
    }

}
