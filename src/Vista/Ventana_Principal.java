/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;
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
        lblHora = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        opcmSalir = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        opcmPaciente = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        opcmHistoriaClinica = new javax.swing.JMenuItem();
        opcmRecaudo = new javax.swing.JMenuItem();
        opcmHospitalizacion = new javax.swing.JMenuItem();
        menListados = new javax.swing.JMenu();
        OpclisPac = new javax.swing.JMenuItem();
        OpclisHC = new javax.swing.JMenuItem();
        OpclisLab = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblHora.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblHora.setText("   00:00:00");
        pndEscritorio.add(lblHora);
        lblHora.setBounds(740, 610, 70, 30);

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

        jMenuBar1.add(jMenu1);

        menListados.setText("Listados");

        OpclisPac.setText("Listado Pacientes");
        menListados.add(OpclisPac);

        OpclisHC.setText("Listado Historia Clinica");
        menListados.add(OpclisHC);

        OpclisLab.setText("Listado Laboratorio");
        OpclisLab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpclisLabActionPerformed(evt);
            }
        });
        menListados.add(OpclisLab);

        jMenuBar1.add(menListados);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pndEscritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 808, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pndEscritorio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 637, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void opcmRecaudoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcmRecaudoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opcmRecaudoActionPerformed

    private void opcmHospitalizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcmHospitalizacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opcmHospitalizacionActionPerformed

    private void OpclisLabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpclisLabActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OpclisLabActionPerformed

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

    
    
    

    /**
     * @param args the command line arguments
     */
    public void setOpcmPaciente(JMenuItem opcmPaciente) {
        this.opcmPaciente = opcmPaciente;
    }

    public JLabel getLblHora() {
        return lblHora;
    }

    public void setLblHora(JLabel lblHora) {
        this.lblHora = lblHora;
    }

    public JMenuItem getOpclisHC() {
        return OpclisHC;
    }

    public void setOpclisHC(JMenuItem OpclisHC) {
        this.OpclisHC = OpclisHC;
    }

    public JMenuItem getOpclisLab() {
        return OpclisLab;
    }

    public void setOpclisLab(JMenuItem OpclisLab) {
        this.OpclisLab = OpclisLab;
    }

    public JMenuItem getOpclisPac() {
        return OpclisPac;
    }

    public void setOpclisPac(JMenuItem OpclisPac) {
        this.OpclisPac = OpclisPac;
    }

    public JMenu getMenListados() {
        return menListados;
    }

    public void setMenListados(JMenu menListados) {
        this.menListados = menListados;
    }
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem OpclisHC;
    private javax.swing.JMenuItem OpclisLab;
    private javax.swing.JMenuItem OpclisPac;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JLabel lblHora;
    private javax.swing.JMenu menListados;
    private javax.swing.JMenuItem opcmHistoriaClinica;
    private javax.swing.JMenuItem opcmHospitalizacion;
    private javax.swing.JMenuItem opcmPaciente;
    private javax.swing.JMenuItem opcmRecaudo;
    private javax.swing.JMenuItem opcmSalir;
    private javax.swing.JDesktopPane pndEscritorio;
    // End of variables declaration//GEN-END:variables

}
