package com.programacion_bcd.taller.carga_datos;

import com.programacion_bcd.taller.sistema.Domicilio;
import com.programacion_bcd.taller.sistema.Elector;

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
                if(matcherNombres.matches()&&matcherDomicilio.matches()) {
                    electores.add(electorAux);
                }
                nombres = bufferedReaderNombres.readLine();
                direcciones = bufferedReaderDirecciones.readLine();
                domicilio = bufferedReaderDomicilio.readLine();
            } while (nombres != null);

        } catch (IOException exc) {
            exc.printStackTrace();
        } finally {
            System.out.println(electores.size() ==
                               10000
                               ? "Carga de Electores completada correctamente"
                               : "Ha pasado algo");
        }
        return electores;
    }

}
