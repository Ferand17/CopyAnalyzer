package Main;

import com.formdev.flatlaf.FlatDarkLaf;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author ferand20
 */
public class Frame extends javax.swing.JFrame {

    String archivousado,textoConsola;
    Grafica metodos;

    public Frame() {
        // errores.add(new Token("lexema", "TipoToken","tipo", "columna", "fila"));
        this.archivousado = "";
        this.metodos = new Grafica();
        this.textoConsola ="";
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public void agregarConsola(String texto){
        String auxtexto = this.textConsola.getText()+"\n"+texto;
        this.textConsola.setText(auxtexto);
    }
    
    public JTextArea getTextAreaSelected() {
        JScrollPane contenedorScroll = (JScrollPane) this.contenedorEditores.getComponent(this.contenedorEditores.getSelectedIndex());
        JTextArea auxtextarea = (JTextArea) contenedorScroll.getViewport().getView();
        return auxtextarea;
    }

    public void createarchivo(String nombre, String Dato) {
        FileWriter escribir;
        try {
            escribir = new FileWriter(nombre, false);
            escribir.write(Dato);
            escribir.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar, ponga nombre al archivo");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar, en la salida");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        contenedorEditores = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        textConsola = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btnArchivoAbrir = new javax.swing.JMenuItem();
        btnArchivoGuardar = new javax.swing.JMenuItem();
        btnArchivoGuardarComo = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        btnCrearPestania = new javax.swing.JMenuItem();
        btnEliminarPestania = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        btnEjecutar = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        btnReporteErrores = new javax.swing.JMenuItem();
        btnReporteEstadistico = new javax.swing.JMenuItem();
        btnReporteTokens = new javax.swing.JMenuItem();
        btnReporteJSON = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FIUSAC Copy Analyzer");
        setBackground(java.awt.SystemColor.controlDkShadow);
        setForeground(java.awt.Color.darkGray);
        setPreferredSize(new java.awt.Dimension(1200, 800));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setText("Consola");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel2.setText("Editor");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        contenedorEditores.addTab("Default", jScrollPane2);

        textConsola.setEditable(false);
        textConsola.setColumns(20);
        textConsola.setForeground(java.awt.Color.black);
        textConsola.setRows(5);
        jScrollPane1.setViewportView(textConsola);

        jMenu1.setText("Funciones");

        btnArchivoAbrir.setText("Abrir Archivo");
        btnArchivoAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArchivoAbrirActionPerformed(evt);
            }
        });
        jMenu1.add(btnArchivoAbrir);

        btnArchivoGuardar.setText("Guardar");
        btnArchivoGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArchivoGuardarActionPerformed(evt);
            }
        });
        jMenu1.add(btnArchivoGuardar);

        btnArchivoGuardarComo.setText("Guardar Como");
        btnArchivoGuardarComo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArchivoGuardarComoActionPerformed(evt);
            }
        });
        jMenu1.add(btnArchivoGuardarComo);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Carateristicas");

        btnCrearPestania.setText("Crear pestaña");
        btnCrearPestania.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearPestaniaActionPerformed(evt);
            }
        });
        jMenu2.add(btnCrearPestania);

        btnEliminarPestania.setText("Eliminar Pestaña");
        btnEliminarPestania.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPestaniaActionPerformed(evt);
            }
        });
        jMenu2.add(btnEliminarPestania);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Herramientas");

        btnEjecutar.setText("Ejecutar");
        btnEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEjecutarActionPerformed(evt);
            }
        });
        jMenu3.add(btnEjecutar);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Reportes");

        btnReporteErrores.setText("Reporte Errores");
        btnReporteErrores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteErroresActionPerformed(evt);
            }
        });
        jMenu4.add(btnReporteErrores);

        btnReporteEstadistico.setText("Reporte Estadistico");
        btnReporteEstadistico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteEstadisticoActionPerformed(evt);
            }
        });
        jMenu4.add(btnReporteEstadistico);

        btnReporteTokens.setText("Reporte Tokens");
        btnReporteTokens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteTokensActionPerformed(evt);
            }
        });
        jMenu4.add(btnReporteTokens);

        btnReporteJSON.setText("Reporte JSON");
        btnReporteJSON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteJSONActionPerformed(evt);
            }
        });
        jMenu4.add(btnReporteJSON);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(348, 348, 348))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contenedorEditores, javax.swing.GroupLayout.PREFERRED_SIZE, 753, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(jLabel2)
                    .addContainerGap(1103, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contenedorEditores, javax.swing.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel2)
                    .addContainerGap(742, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnArchivoAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArchivoAbrirActionPerformed
        String data = "";
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        fileChooser.addChoosableFileFilter(
                new FileNameExtensionFilter("Documents", "fca", "js"));
        fileChooser.removeChoosableFileFilter(fileChooser.getAcceptAllFileFilter());
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                Scanner myReader = new Scanner(selectedFile);
                while (myReader.hasNextLine()) {
                    data += myReader.nextLine() + "\n";

                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.getTextAreaSelected().setText(data);
            this.archivousado = selectedFile.getPath();
        }
        JOptionPane.showMessageDialog(null, "Archivo abierto");
    }//GEN-LAST:event_btnArchivoAbrirActionPerformed

    private void btnArchivoGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArchivoGuardarActionPerformed
        this.createarchivo(archivousado, this.getTextAreaSelected().getText());
        JOptionPane.showMessageDialog(null, "Archivo Guardado");
    }//GEN-LAST:event_btnArchivoGuardarActionPerformed

    private void btnArchivoGuardarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArchivoGuardarComoActionPerformed
        JFileChooser guardar = new JFileChooser();
        guardar.showSaveDialog(this);
        guardar.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        File archivo = guardar.getSelectedFile();
        FileWriter escribir;
        try {
            escribir = new FileWriter(archivo, true);
            escribir.write(this.getTextAreaSelected().getText());
            escribir.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar, ponga nombre al archivo");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar, en la salida");
        }
        JOptionPane.showMessageDialog(null, "Archivo Guardado");
    }//GEN-LAST:event_btnArchivoGuardarComoActionPerformed

    private void btnCrearPestaniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearPestaniaActionPerformed
        JTextArea auxtextarea = new javax.swing.JTextArea();
        auxtextarea.setColumns(20);
        auxtextarea.setRows(5);
        JScrollPane auxScrol = new javax.swing.JScrollPane();
        auxScrol.setViewportView(auxtextarea);
        contenedorEditores.add(
                JOptionPane.showInputDialog("Escriba el nombre de la nueva pestaña."),
                auxScrol);
        JOptionPane.showMessageDialog(null, "Pestaña Creada");
    }//GEN-LAST:event_btnCrearPestaniaActionPerformed

    private void btnEliminarPestaniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPestaniaActionPerformed
        contenedorEditores.remove(contenedorEditores.getSelectedIndex());
        JOptionPane.showMessageDialog(null, "Pestaña Eliminada");
    }//GEN-LAST:event_btnEliminarPestaniaActionPerformed

    private void btnEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjecutarActionPerformed
        this.agregarConsola("Ejecutar...");
        metodos.analisisFca(getTextAreaSelected().getText(), archivousado);
        this.agregarConsola("Terminar");
    }//GEN-LAST:event_btnEjecutarActionPerformed

    private void btnReporteErroresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteErroresActionPerformed
        this.createarchivo("ReporteErrores.html", this.metodos.ReporteErrores());
        JOptionPane.showMessageDialog(null, "Reporte Errores Creado");
        Runtime rt = Runtime.getRuntime();
        try {
            Process pr = rt.exec(" brave-browser ReporteErrores.html");
        } catch (IOException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        agregarConsola("Reporte Errores Creado");
    }//GEN-LAST:event_btnReporteErroresActionPerformed

    private void btnReporteEstadisticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteEstadisticoActionPerformed
        this.createarchivo("ReporteEstadistico.html", metodos.reporteEstadistico());
        JOptionPane.showMessageDialog(null, "Reporte Estadistico Creado");
        Runtime rt = Runtime.getRuntime();
        try {
            Process pr = rt.exec("brave-browser ReporteEstadistico.html");
        } catch (IOException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        agregarConsola("Reporte Estadistico Creado");
    }//GEN-LAST:event_btnReporteEstadisticoActionPerformed

    private void btnReporteTokensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteTokensActionPerformed
        this.createarchivo("ReporteTokens.html", this.metodos.ReporteTokens());
        JOptionPane.showMessageDialog(null, "Reporte Tokens Creado");
        Runtime rt = Runtime.getRuntime();
        try {
            Process pr = rt.exec("brave-browser ReporteTokens.html");
        } catch (IOException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        agregarConsola("Reporte Tokens Creado");
    }//GEN-LAST:event_btnReporteTokensActionPerformed

    private void btnReporteJSONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteJSONActionPerformed
        this.metodos.compararArchivos();
        this.createarchivo("ReporteJSON.json","{"+this.metodos.jason+"}");
        JOptionPane.showMessageDialog(null, "Reporte Json Creado");
        Runtime rt = Runtime.getRuntime();
        try {
            Process pr = rt.exec("brave-browser ReporteJSON.json");
        } catch (IOException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        agregarConsola("Reporte JSON Creado");
    }//GEN-LAST:event_btnReporteJSONActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException ex) {
        }
        java.awt.EventQueue.invokeLater(() -> {
            new Frame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnArchivoAbrir;
    private javax.swing.JMenuItem btnArchivoGuardar;
    private javax.swing.JMenuItem btnArchivoGuardarComo;
    private javax.swing.JMenuItem btnCrearPestania;
    private javax.swing.JMenuItem btnEjecutar;
    private javax.swing.JMenuItem btnEliminarPestania;
    private javax.swing.JMenuItem btnReporteErrores;
    private javax.swing.JMenuItem btnReporteEstadistico;
    private javax.swing.JMenuItem btnReporteJSON;
    private javax.swing.JMenuItem btnReporteTokens;
    private javax.swing.JTabbedPane contenedorEditores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea textConsola;
    // End of variables declaration//GEN-END:variables
}
