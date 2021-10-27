package com.programacion_bcd.taller.carga_datos;

import com.programacion_bcd.taller.sistema.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CargaDatos {
    public static List<Elector> cargaElectores() {
        List<Elector> electores = new ArrayList<>();

        File fileNombres = new File(
                "src/main/java/com/programacion_bcd/taller/carga_datos/nombres.txt");
        File fileDirecciones = new File(
                "src/main/java/com/programacion_bcd/taller/carga_datos/direcciones.txt");
        File fileDomicilio = new File(
                "src/main/java/com/programacion_bcd/taller/carga_datos/provincia_departamento_ciudad.txt");

        FileReader fileReaderNombres;
        FileReader fileReaderDirecciones;
        FileReader fileReaderDomicilio;

        BufferedReader bufferedReaderNombres;
        BufferedReader bufferedReaderDirecciones;
        BufferedReader bufferedReaderDomicilio;

        String nombres;
        String direcciones;
        String domicilio;

        Pattern patronNombres = Pattern.compile(
                "^(.*~(.+)~#(.+)#%(.+)%!(.+)-(.+)-(.+)!.*)$");
        Pattern patronDomicilio = Pattern.compile("^(.*~(.+)~#(.+)#%(.+)%.*)$");

        Matcher matcherNombres;

        Matcher matcherDomicilio;

        try {
            fileReaderNombres = new FileReader(fileNombres);
            fileReaderDirecciones = new FileReader(fileDirecciones);
            fileReaderDomicilio = new FileReader(fileDomicilio);

            bufferedReaderNombres = new BufferedReader(fileReaderNombres);
            bufferedReaderDirecciones = new BufferedReader(
                    fileReaderDirecciones);
            bufferedReaderDomicilio = new BufferedReader(
                    fileReaderDomicilio);

            nombres = bufferedReaderNombres.readLine();
            direcciones = bufferedReaderDirecciones.readLine();
            domicilio = bufferedReaderDomicilio.readLine();

            do {

                matcherNombres = patronNombres.matcher(nombres);
                matcherDomicilio = patronDomicilio.matcher(domicilio);
                Domicilio domicilioAux = null;
                Elector electorAux = null;

                if (matcherDomicilio.matches()) {
                    domicilioAux = new Domicilio(direcciones,
                                                 matcherDomicilio.group(
                                                         2),
                                                 matcherDomicilio.group(
                                                         3),
                                                 matcherDomicilio.group(
                                                         4));
                }
                if (matcherNombres.matches()) {

                    electorAux = new Elector(matcherNombres.group(2),
                                             matcherNombres.group(3),
                                             Integer.parseInt(
                                                     matcherNombres.group(
                                                             4)),
                                             domicilioAux,
                                             domicilioAux.getProvincia() +
                                             " - " +
                                             domicilioAux.getDepartamento() +
                                             " - " +
                                             domicilioAux.getLocalidad(),
                                             LocalDate.of(
                                                     Integer.parseInt(
                                                             matcherNombres.group(
                                                                     5)),
                                                     Integer.parseInt(
                                                             matcherNombres.group(
                                                                     6)),
                                                     Integer.parseInt(
                                                             matcherNombres.group(
                                                                     7))), null,
                                             null, null,
                                             null);
                }
                if (matcherNombres.matches() && matcherDomicilio.matches()) {
                    electores.add(electorAux);
                } else {
                    System.out.println(domicilio);
                }
                nombres = bufferedReaderNombres.readLine();
                direcciones = bufferedReaderDirecciones.readLine();
                domicilio = bufferedReaderDomicilio.readLine();
            } while (nombres != null);

        } catch (IOException exc) {
            exc.printStackTrace();
        } finally {
            System.out.println(electores.size());
            System.out.println(electores.size() ==
                               30000
                               ? "Carga de Electores completada correctamente"
                               : "Ha pasado algo");
        }
        return electores;
    }

    public static RequerimientosProvincia[] requerimientosProvincias() {
        RequerimientosProvincia[] requerimientosProvincias = new RequerimientosProvincia[24];
        try {
            File req = new File(
                    "src/main/java/com/programacion_bcd/taller/carga_datos/requerimientos.txt");
            FileReader readerReq = new FileReader(req);
            BufferedReader bufferedReaderReq = new BufferedReader(readerReq);
            String linea = "";
            int i = 0;
            Pattern r = Pattern.compile("^(-(.+)-(.+)-(.+))$");
            Matcher m;
            while ((linea = bufferedReaderReq.readLine()) != null) {
                m = r.matcher(linea);
                if (m.matches()) {
                    requerimientosProvincias[i++] = new RequerimientosProvincia(
                            m.group(2),
                            Integer.parseInt(
                                    m.group(4)),
                            Integer.parseInt(
                                    m.group(3)));

                }
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return requerimientosProvincias;
    }

    public static List<Lista> cargaListas(List<Elector> electores,
                                          RequerimientosProvincia[] requerimientosProvincias) {
        int total = electores.size();

        int numeroAsignarLista = 100;

        List<Lista> listas = new ArrayList<>();

        PartidoPolitico derecha = new PartidoPolitico("Derecha",
                                                      new ArrayList<>(),
                                                      new ArrayList<>());
        PartidoPolitico izquierda = new PartidoPolitico("Izquierda",
                                                        new ArrayList<>(),
                                                        new ArrayList<>());

        //-----------------------Aux------
        String provincia;
        String nombreLista;
        String numeroLista;
        PartidoPolitico partidoPolitico;
        List<Elector> senadores;
        List<Elector> diputados;
        Lista listaAux;
        Elector candidato;
        int indice = 0;
        //-----------------------------

        for (int i = 0; i < total; i++) {

            provincia = electores.get(i).getDomicilio().getProvincia();

            nombreLista =
                    (electores.get(i).getFechaNac().getDayOfMonth() % 2 == 0)
                    ? "Derecha"
                    : "Izquierda";

            nombreLista += " " + listas.size();
            numeroLista = numeroAsignarLista++ +
                          (electores.get(i).getFechaNac().getDayOfMonth() % 2 ==
                           0 ? "A"
                             : "B");

            partidoPolitico =
                    (electores.get(i).getFechaNac().getDayOfMonth() % 2 ==
                     0) ? derecha
                        : izquierda;

            candidato = electores.get(i);

            boolean esta = false;

            for (int j = 0; j < listas.size(); j++) {
                if (listas.get(j).getProvincia().equals(provincia) &&
                    listas.get(j).getPartido().getNombre().equals(
                            partidoPolitico.getNombre())) {
                    esta = true;
                    indice = j;
                    break;
                }
            }

            if (listas.isEmpty() || !esta) {
                candidato.setCandidato(TipoCandidato.SENADOR);
                senadores = new ArrayList<>();
                senadores.add(candidato);

                listaAux = new Lista(provincia, nombreLista,
                                     numeroLista,
                                     partidoPolitico,
                                     new ArrayList<>(), senadores,
                                     (null));
                candidato.setLista(listaAux);
                listas.add(listaAux);
                partidoPolitico.getLista().add(listaAux);
            } else {

                RequerimientosProvincia req = null;
                for (int z = 0; z < requerimientosProvincias.length; z++) {
                    if (requerimientosProvincias[z].getNombre().equals(
                            provincia)) {
                        req = requerimientosProvincias[z];
                        break;
                    }
                }
                if (req != null) {
                    if (listas.get(indice).getSenadores().size() <
                        req.getCantidadSenadores()) {
                        candidato.setCandidato(TipoCandidato.SENADOR);
                        listas.get(indice).getSenadores().add(candidato);
                        candidato.setLista(listas.get(indice));

                    } else if (listas.get(indice).getDiputados().size() <
                               req.getCantidadDiputados()) {
                        candidato.setCandidato(TipoCandidato.DIPUTADO);
                        listas.get(indice).getDiputados().add(candidato);
                        candidato.setLista(listas.get(indice));

                    } else {
                        candidato.setCandidato(TipoCandidato.NO_CANDIDATO);
                    }
                }
            }

        }

        return listas;
    }

    public static List<Distrito> cargaDistrito(List<Elector> electors) {
        List<Distrito> distritosRetorno = new ArrayList<>();

        int total = electors.size();

        //---------------------------------
        Distrito distrito;
        Seccion seccion;
        Circuito circuito;
        String provincia;
        String departamento;
        String ciudad;
        MesaElectoral mesaElectoral;
        int indiceDistrito;
        int indiceSeccion;
        int indiceCircuito;

        //---------------------------------
        for (int i = 0; i < total; i++) {

            provincia = electors.get(i).getDomicilio().getProvincia();
            distrito = new Distrito(provincia, new ArrayList<>());

            indiceDistrito = distritosRetorno.indexOf(distrito);
            if (indiceDistrito == -1) {

                distritosRetorno.add(distrito);
                indiceDistrito = distritosRetorno.indexOf(distrito);
            }
            departamento = electors.get(i).getDomicilio().getDepartamento();
            seccion = new Seccion(departamento,
                                  distritosRetorno.get(indiceDistrito),
                                  new ArrayList<>());

            indiceSeccion = distritosRetorno.get(
                    indiceDistrito).getListaSecciones().indexOf(seccion);
            if (indiceSeccion == -1) {
                distritosRetorno.get(indiceDistrito).getListaSecciones().add(
                        seccion);
                indiceSeccion = distritosRetorno.get(
                        indiceDistrito).getListaSecciones().indexOf(seccion);
            }
            ciudad = electors.get(i).getDomicilio().getLocalidad();
            circuito = new Circuito(0, ciudad, distritosRetorno.get(
                    indiceDistrito).getListaSecciones().get(indiceSeccion),
                                    new ArrayList<>());

            indiceCircuito = distritosRetorno.get(
                    indiceDistrito).getListaSecciones().get(
                    indiceSeccion).getCircuitos().indexOf(circuito);

            if (indiceCircuito == -1) {
                distritosRetorno.get(indiceDistrito).getListaSecciones().get(
                        indiceSeccion).getCircuitos().add(circuito);

                indiceCircuito = distritosRetorno.get(
                        indiceDistrito).getListaSecciones().get(
                        indiceSeccion).getCircuitos().indexOf(circuito);

                circuito = distritosRetorno.get(
                        indiceDistrito).getListaSecciones().get(
                        indiceSeccion).getCircuitos().get(indiceCircuito);
                circuito.setNumero(indiceCircuito);

            } else {
                circuito = distritosRetorno.get(
                        indiceDistrito).getListaSecciones().get(
                        indiceSeccion).getCircuitos().get(indiceCircuito);

            }

            int z = circuito.getListaMesas().size();

            if (circuito.getListaMesas().isEmpty() ||
                circuito.getListaMesas().get(z - 1).getElectores()[349] !=
                null) {
                mesaElectoral = new MesaElectoral(z, null, null, circuito,
                                                  new Elector[350],
                                                  new Voto[350]);

                circuito.getListaMesas().add(mesaElectoral);
                z = circuito.getListaMesas().size();
            }

            for (int y = 0; y < 350; y++) {

                if (circuito.getListaMesas().get(z - 1).getElectores()[y] ==
                    null) {

                    if (y == 0) {
                        circuito.getListaMesas().get(
                                z - 1).setPresidente(electors.get(i));
                    }

                    if (y == 1) {
                        circuito.getListaMesas().get(
                                z - 1).setAuxiliar(electors.get(i));
                    }

                    circuito.getListaMesas().get(
                            z - 1).getElectores()[y] = electors.get(i);

                    electors.get(i).setMesa(
                            circuito.getListaMesas().get(z - 1));
                    electors.get(i).setLugarVotacion(
                            electors.get(i).getLugarVotacion() + " - Mesa: " +
                            circuito.getListaMesas().get(z - 1).getNumero());
                    break;
                }

            }
        }
        return distritosRetorno;
    }
    public static List<Elector> ordenarElectores(Elector[] electores){
        List<Elector> listaElectores = new ArrayList<>();
        for (int i = 0; i < electores.length; i++) {
            listaElectores.add(electores[i]);
        }
        Collections.sort(listaElectores);
        return listaElectores;
    }

}

