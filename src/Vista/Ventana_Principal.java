/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author joanm
 */
public class Ventana_Principal extends javax.swing.JFrame {

    /**
     * Creates new form Ventana_Principal
     */
    public Ventana_Principal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        pndEscritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        opcmSalir = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        opcmPaciente = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        opcmHistoriaClinica = new javax.swing.JMenuItem();
        opcmRecaudo = new javax.swing.JMenuItem();
        opcmHospitalizacion = new javax.swing.JMenuItem();
        opcPacientes = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu2.setText("Archivo");

        opcmSalir.setText("Salir");
        jMenu2.add(opcmSalir);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Registrar");

        opcmPaciente.setText("Paciente");
        jMenu3.add(opcmPaciente);

        jMenuBar1.add(jMenu3);

        jMenu1.setText("Consultar");

        opcmHistoriaClinica.setText("Historia Clinica");
        jMenu1.add(opcmHistoriaClinica);

        opcmRecaudo.setText("Recaudo");
        opcmRecaudo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcmRecaudoActionPerformed(evt);
            }
        });
        jMenu1.add(opcmRecaudo);

        opcmHospitalizacion.setText("Hospitalización");
        opcmHospitalizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcmHospitalizacionActionPerformed(evt);
            }
        });
        jMenu1.add(opcmHospitalizacion);

        opcPacientes.setText("Listado Pacientes");
        opcPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcPacientesActionPerformed(evt);
            }
        });
        jMenu1.add(opcPacientes);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pndEscritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pndEscritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void opcmRecaudoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcmRecaudoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opcmRecaudoActionPerformed

    private void opcmHospitalizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcmHospitalizacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opcmHospitalizacionActionPerformed

    private void opcPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcPacientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opcPacientesActionPerformed

    /**
     * @param args the command line arguments
     */

    public JDesktopPane getDesktopPane() {
        return pndEscritorio;
    }

    public void setDesktopPane(JDesktopPane desktopPane) {
        this.pndEscritorio = desktopPane;
    }

    public JMenu getjMenu1() {
        return jMenu1;
    }

    public void setjMenu1(JMenu jMenu1) {
        this.jMenu1 = jMenu1;
    }

    public JMenu getjMenu3() {
        return jMenu3;
    }

    public void setjMenu3(JMenu jMenu3) {
        this.jMenu3 = jMenu3;
    }

    public JMenuBar getjMenuBar1() {
        return jMenuBar1;
    }

    public void setjMenuBar1(JMenuBar jMenuBar1) {
        this.jMenuBar1 = jMenuBar1;
    }

    public JMenuItem getOpcmHistoriaClinica() {
        return opcmHistoriaClinica;
    }

    public void setOpcmHistoriaClinica(JMenuItem opcmHistoriaClinica) {
        this.opcmHistoriaClinica = opcmHistoriaClinica;
    }

    public JMenu getjMenu2() {
        return jMenu2;
    }

    public void setjMenu2(JMenu jMenu2) {
        this.jMenu2 = jMenu2;
    }

    public JMenuItem getjMenuItem1() {
        return jMenuItem1;
    }

    public void setjMenuItem1(JMenuItem jMenuItem1) {
        this.jMenuItem1 = jMenuItem1;
    }

    public JMenuItem getOpcmRecaudo() {
        return opcmRecaudo;
    }

    public void setOpcmRecaudo(JMenuItem opcmRecaudo) {
        this.opcmRecaudo = opcmRecaudo;
    }

    public JMenuItem getOpcmSalir() {
        return opcmSalir;
    }

    public void setOpcmSalir(JMenuItem opcmSalir) {
        this.opcmSalir = opcmSalir;
    }

   

    public JMenuItem getOpcmPaciente() {
        return opcmPaciente;
    }

    public JDesktopPane getPndEscritorio() {
        return pndEscritorio;
    }

    public void setPndEscritorio(JDesktopPane pndEscritorio) {
        this.pndEscritorio = pndEscritorio;
    }

    public JMenuItem getOpcmHospitalizacion() {
        return opcmHospitalizacion;
    }

    public void setOpcmHospitalizacion(JMenuItem opcmHospitalizacion) {
        this.opcmHospitalizacion = opcmHospitalizacion;
    }

    public JMenuItem getOpcPacientes() {
        return opcPacientes;
    }

    public void setOpcPacientes(JMenuItem opcPacientes) {
        this.opcPacientes = opcPacientes;
    }
    
    

    /**
     * @param args the command line arguments
     */
    public void setOpcmPaciente(JMenuItem opcmPaciente) {
        this.opcmPaciente = opcmPaciente;
    }
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem opcPacientes;
    private javax.swing.JMenuItem opcmHistoriaClinica;
    private javax.swing.JMenuItem opcmHospitalizacion;
    private javax.swing.JMenuItem opcmPaciente;
    private javax.swing.JMenuItem opcmRecaudo;
    private javax.swing.JMenuItem opcmSalir;
    private javax.swing.JDesktopPane pndEscritorio;
    // End of variables declaration//GEN-END:variables

}
