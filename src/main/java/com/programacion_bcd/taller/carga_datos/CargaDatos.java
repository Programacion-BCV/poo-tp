package com.programacion_bcd.taller.carga_datos;

import com.programacion_bcd.taller.sistema.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
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
                                             domicilioAux, "",
                                             LocalDate.of(
                                                     Integer.parseInt(
                                                             matcherNombres.group(
                                                                     5)),
                                                     Integer.parseInt(
                                                             matcherNombres.group(
                                                                     6)),
                                                     Integer.parseInt(
                                                             matcherNombres.group(
                                                                     7))),
                                             null,
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
        List<Candidato> senadores;
        List<Candidato> diputados;
        Lista listaAux;
        Candidato candidato;
        int indice = 0;
        //-----------------------------

        for (int i = 0; i < total; i++) {

            provincia = electores.get(i).getDomicilio().getProvincia();

            nombreLista = (i % 2 == 0) ? "Derecha"
                                       : "Izquierda";

            nombreLista += " " + listas.size();
            numeroLista = numeroAsignarLista++ +
                          ((electores.get(i).getDni() % 2 == 0) ? "A"
                                                                : "B");

            partidoPolitico =
                    (electores.get(i).getFechaNac().getDayOfMonth() % 2 ==
                     0) ? derecha
                        : izquierda;

            candidato = new Candidato(electores.get(i).getNombre(),
                                      electores.get(i).getApellido(),
                                      electores.get(i).getDni(),
                                      electores.get(i).getDomicilio(),
                                      electores.get(i).getLugarVotacion(),
                                      electores.get(i).getFechaNac(),
                                      electores.get(i).getMesa(),
                                      electores.get(i).getVoto(),
                                      null, null);

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
                candidato.setTipoCandidato(TipoCandidato.SENADOR);

                senadores = new ArrayList<>();
                senadores.add(candidato);
                listaAux = new Lista(provincia, nombreLista,
                                     numeroLista,
                                     partidoPolitico,
                                     new ArrayList<>(), senadores,
                                     (null));

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
                        candidato.setTipoCandidato(TipoCandidato.SENADOR);
                        listas.get(indice).getSenadores().add(candidato);
                    } else if (listas.get(indice).getDiputados().size() <
                               req.getCantidadDiputados()) {
                        candidato.setTipoCandidato(TipoCandidato.DIPUTADO);
                        listas.get(indice).getDiputados().add(candidato);
                    }
                }
            }

        }

        return listas;
    }

    public static List<Distrito> cargaDistrito;

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
}
