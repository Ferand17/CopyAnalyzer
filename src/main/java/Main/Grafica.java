/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import AnalizadorFCA.FcaCup;
import AnalizadorFCA.Fcalex;
import AnalizadorFCA.FcalexCup;
import AnalizadorJS.JsCup;
import AnalizadorJS.Jslex;
import AnalizadorJS.JslexCup;
import JFlex.Out;
import Modelos.Dato;
import Modelos.Token;
import Modelos.TokenArchivo;
import Modelos.TokenClase;
import Modelos.TokenFuncion;
import Modelos.Variable;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author ferand20
 */
public class Grafica {

    public ArrayList<TokenArchivo> archivosJS1 = new ArrayList<>();
    public ArrayList<TokenArchivo> archivosJS2 = new ArrayList<>();
    public ArrayList<Token> archivotokens = new ArrayList<>();
    public ArrayList<Token> archivoerrores = new ArrayList<>();
    public ArrayList<Variable> variables = new ArrayList<>();
    public ArrayList<String> titulos = new ArrayList<>();
    String jason = "";

    public DefaultPieDataset datosPie(ArrayList<Dato> datos) {
        DefaultPieDataset aux = new DefaultPieDataset();
        datos.forEach((Dato dato) -> {
            aux.setValue(dato.getDatoAlfabetico(), dato.getDatoNumerico());
        });
        return aux;
    }

    public void mostrarGraficaPie(String titulo, ArrayList<Dato> datos) {
        JFreeChart grafica = ChartFactory.createPieChart(titulo, datosPie(datos), true, true, false);
        try {
            final File file1 = new File(titulo + ".png");
            ChartUtilities.saveChartAsPNG(file1, grafica, 1000, 800);
            System.out.println("Grafica Lineas Lista");
        } catch (IOException e) {
            System.out.println("Grafica Lineas ERROR");
        }
    }

    public DefaultCategoryDataset datosBarras(ArrayList<Dato> datos,String titulo) {
        DefaultCategoryDataset aux = new DefaultCategoryDataset();
        datos.forEach(dato -> {
            aux.setValue(dato.getDatoNumerico(), dato.getDatoAlfabetico(), dato.getDatoAlfabetico());
        });
        return aux;
    }
    
    public DefaultCategoryDataset datosBarras2(ArrayList<Dato> datos,String titulo) {
        DefaultCategoryDataset aux = new DefaultCategoryDataset();
        datos.forEach(dato -> {
            aux.setValue(dato.getDatoNumerico(), titulo, dato.getDatoAlfabetico());
        });
        return aux;
    }

    public void mostrarGraficabarras(String titulo, String tituloX, String tituloY, ArrayList<Dato> datos) {
        JFreeChart grafica = ChartFactory.createBarChart(titulo, tituloX, tituloY, datosBarras(datos,titulo), PlotOrientation.VERTICAL, true, true, false);
        try {
            final File file1 = new File(titulo + ".png");
            ChartUtilities.saveChartAsPNG(file1, grafica, 1000, 800);
            System.out.println("Grafica Lineas Lista");
        } catch (IOException e) {
            System.out.println("Grafica Lineas ERROR");
        }
    }

    public void mostrarGraficaLinea(String titulo, String tituloX, String tituloY, ArrayList<Dato> datos) {
        JFreeChart grafica = ChartFactory.createLineChart(titulo, tituloX, tituloY, datosBarras2(datos,titulo), PlotOrientation.VERTICAL, true, true, false);
        try {
            final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
            final File file1 = new File(titulo + ".png");
            ChartUtilities.saveChartAsPNG(file1, grafica, 1000, 800, info);
            System.out.println("Grafica Lineas Lista");
        } catch (IOException e) {
            System.out.println("Grafica Lineas ERROR");
        }
    }

    public void analisisFca(String cadena, String archivoUsado) {
        ArrayList<Token> tokens = new ArrayList<>();
        ArrayList<Token> errores = new ArrayList<>();
        Fcalex fcaLexico = new Fcalex(new StringReader(cadena));
        FcaCup fcaSintax = new FcaCup(new FcalexCup(new StringReader(cadena)));
        try {
            fcaSintax.parse();
        } catch (Exception ex) {
            Logger.getLogger(Grafica.class.getName()).log(Level.SEVERE, null, ex);
        }
        fcaSintax.errores.stream().map(err -> {
            err.setArchivo(archivoUsado);
            return err;
        }).forEachOrdered(err -> {
            errores.add(err);
        });
        this.archivoerrores.addAll(fcaSintax.auxgrafica.archivoerrores);
        this.archivotokens.addAll(fcaSintax.auxgrafica.archivotokens);
        this.archivosJS1.addAll(fcaSintax.auxgrafica.archivosJS1);
        this.archivosJS2.addAll(fcaSintax.auxgrafica.archivosJS2);
        this.titulos.addAll(fcaSintax.titulos);
        this.archivoerrores.addAll(fcaSintax.errores);
        fcaSintax.auxgrafica.compararArchivos();
        this.jason=fcaSintax.auxgrafica.jason;
        boolean bandera = true;
        while (bandera) {
            Token aux = null;
            try {
                aux = fcaLexico.yylex();
            } catch (IOException ex) {
                System.out.println(ex);
            }
            if (aux == null) {
                bandera = false;
            } else {
                aux.setArchivo(archivoUsado);
                if (aux.getTipoToken().equalsIgnoreCase("Error")) {
                    errores.add(aux);
                } else {
                    tokens.add(aux);
                }
            }
        }

        tokens.forEach(err -> {
            this.archivotokens.add(err);
        });
        errores.forEach(err -> {
            this.archivoerrores.add(err);
        });
    }

    public void analisisJs(String cadena, String ArchivoUsado, String nombreArchivoUsado, ArrayList<TokenArchivo> archivoJsaux) {
        ArrayList<Token> tokens = new ArrayList<>();
        ArrayList<Token> errores = new ArrayList<>();
        Jslex fcaLexico = new Jslex(new StringReader(cadena));
        JsCup fcaSintax = new JsCup(new JslexCup(new StringReader(cadena)));
        try {
            fcaSintax.parse();
        } catch (Exception ex) {
            Logger.getLogger(Grafica.class.getName()).log(Level.SEVERE, null, ex);
        }
        fcaSintax.errores.stream().map(err -> {
            err.setArchivo(ArchivoUsado);
            return err;
        }).forEachOrdered(err -> {
            errores.add(err);
        });
        boolean bandera = true;
        while (bandera) {
            Token aux = null;
            try {
                aux = fcaLexico.yylex();
            } catch (IOException ex) {
                System.out.println(ex);
            }
            if (aux == null) {
                bandera = false;
            } else {
                aux.setArchivo(ArchivoUsado);
                if (aux.getTipoToken().equalsIgnoreCase("Error")) {
                    errores.add(aux);
                } else {
                    tokens.add(aux);
                }
            }
        }

        errores.forEach(err -> {
            this.archivoerrores.add(err);
        });
        tokens.forEach(err -> {
            this.archivotokens.add(err);
        });
        archivoJsaux.add(new TokenArchivo(nombreArchivoUsado, fcaSintax.clases, fcaSintax.funciones, fcaSintax.variables, fcaLexico.comentarios));
    }

    public String leerArchivo(String archivo) throws IOException {
        String cadena;
        String cadenaS = "";
        FileReader f = new FileReader(archivo);
        try (BufferedReader b = new BufferedReader(f)) {
            while ((cadena = b.readLine()) != null) {
                cadenaS += cadena + "\n";
            }
        }
        return cadenaS;
    }

    public void analisisArchivo(String ruta, ArrayList<TokenArchivo> archivoJsaux) throws IOException {
        File carpeta = new File(ruta);
        String[] listado = carpeta.list();
        
        if (listado != null || listado.length != 0) {
            for (String listado1 : listado) {
                analisisJs(leerArchivo(ruta + listado1), ruta + listado1, listado1, archivoJsaux);
            }
        }
    }

    public Double compararArchivos() {
        Double suma = 0.0;
        this.jason = "";
        for (TokenArchivo tk1 : archivosJS1) {
            for (TokenArchivo tk2 : archivosJS2) {
                if (tk1.getNombre().equalsIgnoreCase(tk2.getNombre())) {
                    this.jason += "\"\nPuntajesEspecificos\": [\n";
                    suma += compararVaraibles(tk1, tk2, "", false);
                    suma += compararComentarios(tk1, tk2, "", false);
                    suma += compararFunciones(tk1, tk2, "", false);
                    suma += compararClases(tk1, tk2, "",false);
                    this.jason += "],";
                }
            }
        }
        this.jason += "\n\"PuntajeGeneral\": " + suma;
        return suma;
    }
    
    public Double compararVariables(){
     for (TokenArchivo tk1 : archivosJS1) {
            for (TokenArchivo tk2 : archivosJS2) {
                if (tk1.getNombre().equalsIgnoreCase(tk2.getNombre())) {
                    return compararVaraibles(tk1, tk2, "", false);
                }
            }
        }  
        return 0.0;
    }
    public Double compararComentarios(){
     for (TokenArchivo tk1 : archivosJS1) {
            for (TokenArchivo tk2 : archivosJS2) {
                if (tk1.getNombre().equalsIgnoreCase(tk2.getNombre())) {
                    return compararComentarios(tk1, tk2, "", false);
                }
            }
        }  
        return 0.0;
    }
    public Double compararFunciones(){
     for (TokenArchivo tk1 : archivosJS1) {
            for (TokenArchivo tk2 : archivosJS2) {
                if (tk1.getNombre().equalsIgnoreCase(tk2.getNombre())) {
                    return compararFunciones(tk1, tk2, "", false);
                }
            }
        }  
        return 0.0;
    }
    public Double compararClases(){
     for (TokenArchivo tk1 : archivosJS1) {
            for (TokenArchivo tk2 : archivosJS2) {
                if (tk1.getNombre().equalsIgnoreCase(tk2.getNombre())) {
                    return compararClases(tk1, tk2, "",false);
                }
            }
        }  
        return 0.0;
    }

    public Double retornarPuntajeEspecifico(String archivo, String tipo, String buscar) {
        for (TokenArchivo tokenArchivo : archivosJS1) {
            for (TokenArchivo tokenArchivo2 : archivosJS2) {
                if (tokenArchivo.getNombre().equalsIgnoreCase(tokenArchivo2.getNombre())) {
                    if (tipo.equalsIgnoreCase("variable")) {
                        return compararVaraibles(tokenArchivo, tokenArchivo2, buscar, false);
                    } else if (tipo.equalsIgnoreCase("comentario")) {
                        return compararComentarios(tokenArchivo, tokenArchivo2, buscar, false);
                    } else if (tipo.equalsIgnoreCase("clase")) {
                        return compararClases(tokenArchivo, tokenArchivo2, buscar, false);
                    } else if (tipo.equalsIgnoreCase("metodo")) {
                        return compararFunciones(tokenArchivo, tokenArchivo2, buscar, false);
                    }
                }
            }
        }
        return 0.0;
    }

    public Double compararVaraibles(TokenArchivo archivo1, TokenArchivo archivo2, String variable, boolean especifica) {
        Double suma = 0.0;
        ArrayList<String> variables1 = archivo1.getVariables();
        ArrayList<String> variables2 = archivo2.getVariables();
        int cantidad = variables1.size() + variables2.size();
        if (cantidad <= 0) {
            cantidad = 1;
        }
        if (especifica) {
            for (String st1 : variables1) {
                for (String st2 : variables2) {
                    if (st1.equalsIgnoreCase(st2)) {
                        if (st1.equalsIgnoreCase(variable) || st2.equalsIgnoreCase(variable)) {
                            return (1.0 / cantidad) * 0.2;
                        }
                    }
                }

            }
        } else {
            for (String st1 : variables1) {
                for (String st2 : variables2) {
                    if (st1.equalsIgnoreCase(st2)) {
                        suma += 1;
                        this.jason += "{" + "\n\"archivo\": \"" + archivo1.getNombre() + "\",\n\"tipo\": " + "\"variable\"" + "\n\"nombre\": \"" + st1 + "\",\n\"puntaje\": " + (1.0 / cantidad) * 0.2 + "\n},\n";
                    }
                }

            }
        }
        return (suma / cantidad) * 0.2;
    }

    public Double compararComentarios(TokenArchivo archivo1, TokenArchivo archivo2, String comentario, boolean especifica) {
        Double suma = 0.0;
        ArrayList<String> comentario1 = archivo1.getComentarios();
        ArrayList<String> comentario2 = archivo2.getComentarios();
        int cantidad = comentario1.size() + comentario2.size();
        if (cantidad <= 0) {
            cantidad = 1;
        }
        if (especifica) {
            for (String st1 : comentario1) {
                for (String st2 : comentario2) {
                    if (st1.equalsIgnoreCase(st2)) {
                        if (st1.equalsIgnoreCase(comentario) || st2.equalsIgnoreCase(comentario)) {
                            return (1.0 / cantidad) * 0.2;
                        }
                    }
                }

            }
        } else {
            for (String st1 : comentario1) {
                for (String st2 : comentario2) {
                    if (st1.equalsIgnoreCase(st2)) {
                        suma += 1;
                        this.jason += "{" + "\n\"archivo\": \"" + archivo1.getNombre() + "\",\n\"tipo\": " + "\"comentario\"" + "\n\"nombre\": \"" + st1 + "\",\n\"puntaje\": " + (1.0 / cantidad) * 0.2 + "\n},\n";
                    }
                }

            }
        }
        return (suma / cantidad) * 0.2;
    }

    public Double compararFunciones(TokenArchivo archivo1, TokenArchivo archivo2, String funcion, boolean especifica) {
        Double suma = 0.0;
        ArrayList<TokenFuncion> funciones1 = archivo1.getFunciones();
        ArrayList<TokenFuncion> funciones2 = archivo2.getFunciones();
        int cantidad = funciones1.size() + funciones2.size();
        if (cantidad <= 0) {
            cantidad = 1;
        }
        if (especifica) {
            for (TokenFuncion st1 : funciones1) {
                for (TokenFuncion st2 : funciones2) {
                    if (st1.getNombre().equalsIgnoreCase(st2.getNombre())) {
                        if (st1.getNombre().equalsIgnoreCase(funcion) || st2.getNombre().equalsIgnoreCase(funcion)) {
                            suma += 0.5;
                            if (st1.getCantidadLineas() == st2.getCantidadLineas()) {
                                suma += 0.5;
                            }
                        }
                        return (suma / cantidad) * 0.3;
                    }
                }

            }
        } else {
            for (TokenFuncion st1 : funciones1) {
                for (TokenFuncion st2 : funciones2) {
                    if (st1.getNombre().equalsIgnoreCase(st2.getNombre())) {
                        double auxsuma = 0.0;
                        suma += 0.5;
                        auxsuma += 0.5;
                        if (st1.getCantidadLineas() == st2.getCantidadLineas()) {
                            suma += 0.5;
                            auxsuma += 0.5;
                        }
                        this.jason += "{" + "\n\"archivo\": \"" + archivo1.getNombre() + "\",\n\"tipo\": " + "\"metodo\"" + "\n\"nombre\": \"" + st1.getNombre() + "\",\n\"puntaje\": " + (auxsuma / cantidad) * 0.3 + "\n},\n";
                    }
                }

            }
        }
        return (suma / cantidad) * 0.3;
    }

    public Double compararClases(TokenArchivo archivo1, TokenArchivo archivo2, String clase, boolean especifica) {
        Double suma = 0.0;
        ArrayList<TokenClase> clases1 = archivo1.getClases();
        ArrayList<TokenClase> clases2 = archivo2.getClases();
        int cantidad = clases1.size() + clases2.size();
        if (cantidad <= 0) {
            cantidad = 1;
        }
        if (especifica) {
            for (TokenClase st1 : clases1) {
                for (TokenClase st2 : clases2) {
                    if (st1.getNombre().equalsIgnoreCase(st2.getNombre())) {
                        if (st1.getNombre().equalsIgnoreCase(clase) || st2.getNombre().equalsIgnoreCase(clase)) {
                            suma += 0.5;
                            if (st1.getCantidadDeLineas() == st2.getCantidadDeLineas()) {
                                suma += 0.5;
                            }
                        }
                        return (suma / cantidad) * 0.3;
                    }
                }

            }
        } else {
            for (TokenClase st1 : clases1) {
                for (TokenClase st2 : clases2) {
                    if (st1.getNombre().equalsIgnoreCase(st2.getNombre())) {
                        double auxsuma = 0.0;
                        suma += 0.5;
                        auxsuma += 0.5;
                        if (st1.getCantidadDeLineas() == st2.getCantidadDeLineas()) {
                            suma += 0.5;
                            auxsuma += 0.5;
                        }
                        this.jason += "{" + "\n\"archivo\": \"" + archivo1.getNombre() + "\",\n\"tipo\": " + "\"clase\"" + "\n\"nombre\": \"" + st1.getNombre() + "\",\n\"puntaje\": " + (auxsuma / cantidad) * 0.3 + "\n},\n";
                    }
                }

            }
        }
        return (suma / cantidad) * 0.3;
    }

    public String ReporteTokens() {
        String reporte = "<h1 aling=center>Reporte Tokens</h1><p>Elder Andrade-201700858</p><table><tr><th>LEXEMA</th><th>TIPO</th><th>FILA</th><th>COLUMNA</th><th>ARCHIVO</th></tr>";
        reporte = this.archivotokens.stream().map(t -> "<tr><td>" + t.getLexema() + "</td><td>" + t.getTipoToken() + "</td><td>" + t.getFila() + "</td><td>" + t.getColumna() + "</td><td>" + t.getArchivo() + "</td></tr>").reduce(reporte, String::concat);
        return reporte + "</table>";
    }

    public String ReporteErrores() {
        String reporte = "<h1 aling=center>Reporte Errores</h1><p>Elder Andrade-201700858</p><table><tr><th>LEXEMA</th><th>TIPO</th><th>FILA</th><th>COLUMNA</th><th>ARCHIVO</th></tr>";
        reporte = this.archivoerrores.stream().map(t -> "<tr><td>" + t.getLexema() + "</td><td>" + t.getTipoToken() + "</td><td>" + t.getFila() + "</td><td>" + t.getColumna() + "</td><td>" + t.getArchivo() + "</td></tr>").reduce(reporte, String::concat);
        return reporte + "</table>";
    }

    public ArrayList<Dato> datosGrafica(ArrayList<Object> datosx, ArrayList<Object> datosy) {
        ArrayList<Dato> aux = new ArrayList<>();
        datosx.forEach(object -> {
            aux.add(new Dato(0.0, object.toString()));
        });
        int indice = 0;
        for (Object object : datosy) {
            aux.get(indice).setDatoNumerico(object.toString());
            indice++;
        }
        return aux;
    }

    public String retornarValor(String id) {
        String valor = "";
        for (Variable v : variables) {
            if (v.getNombre().equalsIgnoreCase(id)) {
                valor = v.getValor();
            }
        }
        return valor;

    }
    
    public String reporteEstadistico(){
        String auxreporte="";
        int funciones1 = 0,funciones2 = 0,variables1 = 0,variables2 = 0,comentarios1 = 0,comentarios2 = 0,clases1 = 0,clases2 = 0;
        for (TokenArchivo tokenArchivo : archivosJS1) {
            funciones1+=tokenArchivo.getFunciones().size();
            variables1+=tokenArchivo.getVariables().size();
            clases1+=tokenArchivo.getClases().size();
            comentarios1+=tokenArchivo.getComentarios().size();
        }
        for (TokenArchivo tokenArchivo : archivosJS2) {
            funciones2+=tokenArchivo.getFunciones().size();
            variables2+=tokenArchivo.getVariables().size();
            clases2 +=tokenArchivo.getClases().size();
            comentarios2+=tokenArchivo.getComentarios().size();
        }
        
        String aux1="<h1>Reporte Estadistico</h1><br><h3>Resumen</h3><br><table><tr><th>Tipo</th><th>ProyectoA</th><th>ProyectoB</th></tr><tr><th>Total Variables</th><td>"
                +variables1+"</td><td>"+variables2+"</td></tr><tr><th>Total Clases</th><td>"+clases1+"</td><td>"+clases2+"</td></tr><tr><th>Total Funciones</th><td>"
                +funciones1+"</td><td>"+funciones2+"</td></tr><tr><th>Total Comentarios</th><td>"+comentarios1+"</td><td>"+comentarios2+"</td></tr></table><br><h3>Graficas</h3><br>";
        auxreporte+=aux1;
        for (String t : titulos) {
            auxreporte+="<img src=\""+t+".png"+"\">";
        }
        auxreporte += "<h3>Datos Finales</h3><br><h4>Nombre: Elder Andrade</h4><br><h4>Carnet: 201700858</h4><br><h4>Fecha y Hora: "+LocalDateTime.now().toString()+"</h4>";
        return auxreporte;
    }

}
