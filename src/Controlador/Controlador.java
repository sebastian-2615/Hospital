
package Controlador;

import Modelo.*;
import Vista.*;
import java.awt.Image;
//import com.itextpdf.text.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Esta clase es donde se instancias todos las anteriroes clases en objetos
 * y es aqui donde se realizan las operaciones de cada una de las clases
 * es decir que es la estructura el programa
 * @author Sebastian Molina y Joan Morales
 */
public class Controlador implements ActionListener, Runnable
{
    /**
     * 
     * Objetos de las clases del modelo que son necesarios para la creacion para los procesos que son
     * requeridos
     */
    Servicio objServicio;
    Afiliacion objAfiliacion;
    Examen ex_sangre;
    Examen ex_orina;
    Examen ex_coprologico;
    Examen ex_optometria;
    Examen ex_odontologia;
    Recaudo objRecaudo;
    Historia_Clinica objH_C;
    ArrayList<Paciente> lista_pacientes;
    Ventana_Principal objVP;//
    Ventana_Proceso objVPro;//
    Ventana_Registro objVReg;//
    Ventana_Laboratorio objVL;//
    Ventana_HistoriaClinica objHC;
    Ventana_Servicios objSer;
    Ventana_Hospitalizacion objVHos;
    Ventana_Pacientes objP;
    Ventana_Actualizacion objA;
    Laboratorio objLab;
    Hospitalizacion objHosp;
    Paciente objPac;
    Conexion con;
    Historia_Clinica hc;
    HospitalDAO objd;
    Hora hora;
    Thread hilo;
    Icon icono;
    ArchPdf PDF;
    int posicionCliente, cont;
    
    /**
     * Controplador basico que inicializa a las variables y activa o hace el escuchador de 
     * los botones de cada una de las ventanas 
     */
    public Controlador() throws IOException {
        this.objHosp = new Hospitalizacion();
        this.objPac = new Paciente();
        this.objLab = new Laboratorio();
        this.objH_C = new Historia_Clinica();
        this.objServicio = null;
        this.objAfiliacion = null;
        this.ex_sangre = new Examen("101","Sangre","",12000);
        this.ex_orina = new Examen("102","Orina","",10000);
        this.ex_coprologico = new Examen("103","Coprológico","",15000);
        this.ex_optometria = new Examen("104","Optometría","",35000);
        this.ex_odontologia = new Examen("105","Odontologia","",50000);
        this.objVP = new Ventana_Principal();
        this.objVPro = new Ventana_Proceso();
        this.objVHos = new Ventana_Hospitalizacion();
        this.objVReg = new Ventana_Registro();
        this.objVL = new Ventana_Laboratorio();
        this.objHC = new Ventana_HistoriaClinica();
        this.objRecaudo = new Recaudo();
        this.objSer = new Ventana_Servicios();
        this.objP = new Ventana_Pacientes();
        this.objA = new Ventana_Actualizacion();
        this.lista_pacientes = new ArrayList<>();
        this.con = new Conexion();
        objVP.getOpcmHistoriaClinica().addActionListener(this);
        objVP.getOpcmPaciente().addActionListener(this);
        objVP.getOpcmSalir().addActionListener(this);
        objVP.getOpcmRecaudo().addActionListener(this);
        objVP.getOpcmHospitalizacion().addActionListener(this);
        objVP.getOpclisPac().addActionListener(this);
        objVP.getOpclisHC().addActionListener(this);
        objVP.getOpclisLab().addActionListener(this);
        objVPro.getBtnConsultarPaciente().addActionListener(this);
        objVPro.getBtnEnviarProceso().addActionListener(this);
        objVReg.getBtnRegistrar().addActionListener(this);
        objVL.getBtnEnviarLaboratorio().addActionListener(this);
        objHC.getBtnEnviarDatosRecaudo().addActionListener(this);
        objSer.getBtnDescripcionServicios().addActionListener(this);
        objVHos.getBtnEnviarInformacion().addActionListener(this);
        objP.getBtnActualizar().addActionListener(this);
        objP.getBtnRefrescar().addActionListener(this);
        objP.getBtnEliminar().addActionListener(this);
        objA.getBtnRegistrar().addActionListener(this);
        this.hc = new Historia_Clinica();
        this.objd= new HospitalDAO();
        this.cont=1;
        this.hora = new Hora();
        this.hilo = new Thread(this);
        this.PDF= new ArchPdf();
        
    }
    
    /**
     * Metodo que hace visible a la ventana principal que contiene a las demas ventanas
     */
    public void iniciar()
    {
        objVP.setVisible(true);
        hilo.start();
        ImageIcon imagen = new ImageIcon("src/Imagenes/Fondo.jpg");
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(objVP.getLblimg().getWidth()
                , objVP.getLblimg().getHeight(), Image.SCALE_DEFAULT));
        objVP.getLblimg().setIcon(icono);
        
        objVP.setLocationRelativeTo(null);
    }
    
    /**
     * Metodo donde se realiza todas las funciones de las ventas que estan contenidas en la ventana principal 
     * @param ae Se encia como parametro un objeto de la clase ActionEvent para que se pueda realizar las funciones
     * de los botones que realizan una serie de acciones
     */
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource().equals(objVP.getOpcmPaciente()))
        {
            abrirVentana(objVReg);
        }
        if(ae.getSource().equals(objVReg.getBtnRegistrar()))
        {
            switch(objVReg.getCmbAfiliacion().getSelectedIndex())
            {
                case 1:
                    try
                    {
                        objPac = new Paciente();
                        objAfiliacion = new Sisben();
                        Double.parseDouble(objVReg.getTxtIdentificacionPersona().getText());
                        Double.parseDouble(objVReg.getTxtTelefonoPersona().getText());
                        objPac.setId(objVReg.getTxtIdentificacionPersona().getText());
                        objPac.setNombre(objVReg.getTxtNombrePersona().getText());
                        objPac.setDireccion(objVReg.getTxtDireccionPersona().getText());
                        objPac.setTelefono(objVReg.getTxtTelefonoPersona().getText());
                        objPac.setTipo_afiliacion(objAfiliacion);
                        JOptionPane.showMessageDialog(objVReg,objPac.toString());
                    }catch(NumberFormatException nfe)
                    {
                        JOptionPane.showMessageDialog(objVReg, "Identificacion y/o Telefono deben ser de tipo numerico");
                    }

                    break;
                case 2:
                    switch(objVReg.getCmbCategoria().getSelectedIndex())
                    {
                        case 1:
                            try
                            {
                                objPac = new Paciente();
                                objAfiliacion = new Categoria_A();
                                Double.parseDouble(objVReg.getTxtIdentificacionPersona().getText());
                                Double.parseDouble(objVReg.getTxtTelefonoPersona().getText());
                                objPac.setId(objVReg.getTxtIdentificacionPersona().getText());
                                objPac.setNombre(objVReg.getTxtNombrePersona().getText());
                                objPac.setDireccion(objVReg.getTxtDireccionPersona().getText());
                                objPac.setTelefono(objVReg.getTxtTelefonoPersona().getText());
                                objPac.setTipo_afiliacion(objAfiliacion);
                                JOptionPane.showMessageDialog(objVReg,objPac.toString());
                            }catch(NumberFormatException nfe)
                            {
                                JOptionPane.showMessageDialog(objVReg, "Identificacion y/o Telefono deben ser de tipo numerico");
                            }
                            break;
                        case 2:
                            try
                            {
                                objPac = new Paciente();
                                objAfiliacion = new Categoria_B();
                                Double.parseDouble(objVReg.getTxtIdentificacionPersona().getText());
                                Double.parseDouble(objVReg.getTxtTelefonoPersona().getText());
                                objPac.setId(objVReg.getTxtIdentificacionPersona().getText());
                                objPac.setNombre(objVReg.getTxtNombrePersona().getText());
                                objPac.setDireccion(objVReg.getTxtDireccionPersona().getText());
                                objPac.setTelefono(objVReg.getTxtTelefonoPersona().getText());
                                objPac.setTipo_afiliacion(objAfiliacion);
                                
                                
                                JOptionPane.showMessageDialog(objVReg,objPac.toString());
                            }catch(NumberFormatException nfe)
                            {
                                JOptionPane.showMessageDialog(objVReg, "Identificacion y/o Telefono deben ser de tipo numerico");
                            }

                            break;
                        case 3:
                            try
                            {
                                objPac = new Paciente();
                                objAfiliacion = new Categoria_C();
                                Double.parseDouble(objVReg.getTxtIdentificacionPersona().getText());
                                Double.parseDouble(objVReg.getTxtTelefonoPersona().getText());
                                objPac.setId(objVReg.getTxtIdentificacionPersona().getText());
                                objPac.setNombre(objVReg.getTxtNombrePersona().getText());
                                objPac.setDireccion(objVReg.getTxtDireccionPersona().getText());
                                objPac.setTelefono(objVReg.getTxtTelefonoPersona().getText());
                                objPac.setTipo_afiliacion(objAfiliacion);
                                lista_pacientes.add(objPac);
                                
                                JOptionPane.showMessageDialog(objVReg,objPac.toString());
                            }catch(NumberFormatException nfe)
                            {
                                JOptionPane.showMessageDialog(objVReg, "Identificacion y/o Telefono deben ser de tipo numerico");
                            }
                            break;
                    }
                    break;
            }
            escribirDatosPac(objPac);
            lista_pacientes.add(objPac);
            objd.insertarPac(objPac);
            ActualizarReg();
            objVReg.dispose();
        }
        if(ae.getSource().equals(objVP.getOpcmHistoriaClinica()))
        {
            abrirVentana(objVPro);
        }
        if(ae.getSource().equals(objVPro.getBtnConsultarPaciente()))
        {
            try
            {
                for(int i = 0; i<lista_pacientes.size();i++){
                    if(lista_pacientes.get(i).getId().equals(objVPro.getTxtCIdPaciente().getText())){
                        objVPro.getTxtIdProceso().setText(lista_pacientes.get(i).getId());
                        objVPro.getTxtNombreProceso().setText(lista_pacientes.get(i).getNombre());
                        objVPro.getTxtDireccionPro().setText(lista_pacientes.get(i).getDireccion());
                        objVPro.getTxtTelefonoPro().setText(lista_pacientes.get(i).getTelefono());
                    }
                }
                posicionCliente = devuelvePosicion(objVPro.getTxtCIdPaciente().getText());
            }catch(NumberFormatException nfe)
            {
                JOptionPane.showMessageDialog(objVReg, "Identificacion debe ser de tipo numerico");
            }

        }
        if(ae.getSource().equals(objVPro.getBtnEnviarProceso()))
        {
            objH_C = new Historia_Clinica();
            switch(objVPro.getCmbServicioPro().getSelectedIndex())
            {
                case 1:
                    
                    objServicio = new Cita_Medicina_General();
                    objServicio.setNombre_Servicio("CITA MEDICA GENERAL");
                    objServicio.setDescripcion(objVPro.getTxtADescripcion().getText());
                    objServicio.setId_Servicio(generarId());
                    objH_C.setId_Historia(Integer.parseInt(generarId()));
                    objH_C.setPaciente(lista_pacientes.get(devuelvePosicion(objVPro.getTxtCIdPaciente().getText())));
                    objH_C.setServicio(objServicio);
                    objRecaudo.getLista_H().add(objH_C);
                    escribirDatosHC(objH_C);
                    break;
                case 2:
                    
                    objServicio = new Vacunacion();
                    objServicio.setNombre_Servicio("VACUNACION");
                    objServicio.setId_Servicio(generarId());
                    objH_C.setId_Historia(Integer.parseInt(generarId()));
                    objH_C.setPaciente(lista_pacientes.get(devuelvePosicion(objVPro.getTxtCIdPaciente().getText())));
                    objH_C.setServicio(objServicio);
                    objRecaudo.getLista_H().add(objH_C);
                    escribirDatosHC(objH_C);
                    break;
                case 3:
                    abrirVentana(objVL);
                    break;
                case 4:
                    abrirVentana(objVHos);
                    break;
            }
            
            try{
                objd.insertarHC(objH_C);
                PDF.crear_PDF(objH_C);
            }catch(NullPointerException x){
                
            }
        }
        
        if(ae.getSource().equals(objVL.getBtnEnviarLaboratorio()))
        {
            switch(objVL.getCmbTipoExamen().getSelectedIndex())
            {
                case 1:
                    objH_C = new Historia_Clinica();
                    objH_C.setId_Historia(Integer.parseInt(generarId()));
                    objH_C.setPaciente(lista_pacientes.get(posicionCliente));
                    objLab = new Laboratorio();
                    objLab.setNombre_Servicio("EXAMEN DE SANGRE");
                    objLab.setId_Servicio(generarId());
                    ex_sangre.setId_Examen(generarId());
                    ex_sangre.setDescripcion(objVL.getTxtDescripcionLaboratorio().getText());
                    objLab.setDescripcion(ex_sangre.getDescripcion());
                    objLab.getLista_examenes().add(ex_sangre);
                    objH_C.setServicio(objLab);
                    objRecaudo.getLista_H().add(objH_C);
                    escribirDatosExa(ex_sangre);
                    objd.insertarLab(cont, objLab, ex_sangre, objH_C);
                    break;
                case 2:
                    objH_C = new Historia_Clinica();
                    objH_C.setId_Historia(Integer.parseInt(generarId()));
                    objH_C.setPaciente(lista_pacientes.get(posicionCliente));
                    objLab = new Laboratorio();
                    objLab.setNombre_Servicio("EXAMEN DE ORINA");
                    objLab.setId_Servicio(generarId());
                    ex_orina.setId_Examen(generarId());
                    ex_orina.setDescripcion(objVL.getTxtDescripcionLaboratorio().getText());
                    objLab.setDescripcion(ex_orina.getDescripcion());
                    objLab.getLista_examenes().add(ex_orina);
                    objH_C.setServicio(objLab);
                    objRecaudo.getLista_H().add(objH_C);
                    escribirDatosExa(ex_orina);
                    objd.insertarLab(cont, objLab, ex_orina, objH_C);
                    break;
                case 3:
                    objH_C = new Historia_Clinica();
                    objH_C.setId_Historia(Integer.parseInt(generarId()));
                    objH_C.setPaciente(lista_pacientes.get(posicionCliente));
                    objLab = new Laboratorio();
                    objLab.setNombre_Servicio("EXAMEN CROPOLOGICO");
                    objLab.setId_Servicio(generarId());
                    ex_coprologico.setId_Examen(generarId());
                    ex_coprologico.setDescripcion(objVL.getTxtDescripcionLaboratorio().getText());
                    objLab.setDescripcion(ex_coprologico.getDescripcion());
                    objLab.getLista_examenes().add(ex_coprologico);
                    objH_C.setServicio(objLab);
                    objRecaudo.getLista_H().add(objH_C);
                    escribirDatosExa(ex_coprologico);
                    objd.insertarLab(cont, objLab, ex_coprologico, objH_C);
                    break;
                case 4:
                    objH_C = new Historia_Clinica();
                    objH_C.setId_Historia(Integer.parseInt(generarId()));
                    objH_C.setPaciente(lista_pacientes.get(posicionCliente));
                    objLab = new Laboratorio();
                    objLab.setNombre_Servicio("EXAMEN DE OPTOMETRIA");
                    objLab.setId_Servicio(generarId());
                    ex_optometria.setId_Examen(generarId());
                    ex_optometria.setDescripcion(objVL.getTxtDescripcionLaboratorio().getText());
                    objLab.setDescripcion(ex_optometria.getDescripcion());
                    objLab.getLista_examenes().add(ex_optometria);
                    objH_C.setServicio(objLab);
                    objRecaudo.getLista_H().add(objH_C);
                    escribirDatosExa(ex_optometria);
                    objd.insertarLab(cont, objLab, ex_optometria, objH_C);
                    break;
                case 5:
                    objH_C = new Historia_Clinica();
                    objH_C.setId_Historia(Integer.parseInt(generarId()));
                    objH_C.setPaciente(lista_pacientes.get(posicionCliente));
                    objLab = new Laboratorio();
                    objLab.setNombre_Servicio("EXAMEN DE ODONTOLOGIA");
                    objLab.setId_Servicio(generarId());
                    ex_odontologia.setId_Examen(generarId());
                    ex_odontologia.setDescripcion(objVL.getTxtDescripcionLaboratorio().getText());
                    objLab.setDescripcion(ex_odontologia.getDescripcion());
                    objLab.setLista_examenes(ex_odontologia);
                    objH_C.setServicio(objLab);
                    objRecaudo.getLista_H().add(objH_C);
                    escribirDatosExa(ex_odontologia);
                    objd.insertarLab(cont, objLab, ex_odontologia, objH_C);
                    break;
            }
            objd.insertarHC(objH_C);
            escribirDatosHC(objH_C);
            PDF.crear_PDF(objH_C);
            try{
                String datos = con.leerDatosLab();
                archivoTabla(datos, objVL.getTblExamenes());
            }catch(IOException ex){
                
            }
        }
        if(ae.getSource().equals(objVP.getOpcmHospitalizacion()))
        {
            abrirVentana(objVHos);
        }
        
        
        if(ae.getSource().equals(objVP.getOpcmRecaudo()))
        {
            abrirVentana(objHC);
        }
        if(ae.getSource().equals(objHC.getBtnEnviarDatosRecaudo()))
        {
            objHC.getTxtADatosRecaudo().append("El total de dinero recaudado es: " + objRecaudo.recaudodos());
        }
        if(ae.getSource().equals(objVP.getOpcmSalir()))//Este if nos permite la opcion de salir del programa
        {
            int resp = JOptionPane.showConfirmDialog(null,"¿Esta seguro de salir?", "Confirmar",0,JOptionPane.QUESTION_MESSAGE);
            if(resp==JOptionPane.YES_OPTION){
                objVP.dispose();
            }
        }
        if(ae.getSource().equals(objVP.getOpclisPac()))
        {
            
            abrirVentana(objP);
            objP.getTblPacientes().setModel(objd.consultar());
        }
        if(ae.getSource().equals(objP.getBtnActualizar()))
        {
            
            EnviarDatos(objP);
            abrirVentana(objA);
            //JOptionPane.showMessageDialog(objP, objd.Actualizar(objPac));
        }
        if(ae.getSource().equals(objP.getBtnEliminar()))
        {
            String delete = JOptionPane.showInputDialog("Documento del paciente a eliminar: ");
            JOptionPane.showMessageDialog(objP, objd.Eliminar(delete));
        }
        if(ae.getSource().equals(objVHos.getBtnEnviarInformacion()))
        {
            objHosp = new Hospitalizacion();
            objHosp.setNombre_Servicio("HOSPITALIZACION");
            objHosp.setId_Servicio(generarId());
            objHosp.setDescripcion(objVHos.getTxtDesc().getText());
            objH_C.setId_Historia(Integer.parseInt(generarId()));
            objH_C.setPaciente(lista_pacientes.get(posicionCliente));
            objHosp.getFecha_salida().setAa(objHosp.getFecha_salida().getAa()+Integer.valueOf(objVHos.getTxtIdPacienteHos().getText()));
            objH_C.setServicio(objHosp);
            objRecaudo.getLista_H().add(objH_C);
            objVHos.dispose();
            PDF.crear_PDF(objH_C);
        }
        if(ae.getSource().equals(objA.getBtnRegistrar()))
        {
            objd.setObjP(new Paciente(objA.getTxtNombrePersona().getText(),objA.getTxtIdentificacionPersona().getText(),objA.getTxtDireccionPersona().getText()
                    ,objA.getTxtTelefonoPersona().getText(),null));
            JOptionPane.showMessageDialog(objA, objd.ActualizarPac(objA.getTxtIdentificacionPersona().getText()));
            objA.dispose();
            //objP.getTblPacientes().setModel(objd.consultar());
        }
        if(ae.getSource().equals(objP.getBtnRefrescar()))
        {
            
            objP.getTblPacientes().setModel(objd.consultar());
        }
    }
    
    public void EnviarDatos(Ventana_Pacientes frmpac){
        objA.getTxtIdentificacionPersona().setText((String) frmpac.getTblPacientes().getValueAt(frmpac.getTblPacientes().getSelectedRow(), 0));
        objA.getTxtIdentificacionPersona().setEnabled(false);
        objA.getTxtNombrePersona().setText((String) frmpac.getTblPacientes().getValueAt(frmpac.getTblPacientes().getSelectedRow(), 1));
        objA.getTxtDireccionPersona().setText((String) frmpac.getTblPacientes().getValueAt(frmpac.getTblPacientes().getSelectedRow(), 2));
        objA.getTxtTelefonoPersona().setText((String) frmpac.getTblPacientes().getValueAt(frmpac.getTblPacientes().getSelectedRow(), 3));
    }
    /**
     * Metodo que realiza una busqueda para devolver la posicion del paciente que coicida con el documento 
     * @param id Se envia como parametro el id para que la busqueda de toda la lista sea posible
     * @return int
     */
    public int devuelveEstado(String id)
    {
        for(int i=0; i<objRecaudo.getLista_H().size(); i++)
        {
            if(objRecaudo.getLista_H().get(i).getPaciente().getId().equals(id))
            {
                if(objRecaudo.getLista_H().get(i).getServicio() instanceof Hospitalizacion)
                {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Metodo que retorna un String que vendria siendo un Id para el examen que sea de manera aleatoria
     * @return String
     */
    public String generarId()
    {
        Random r = new Random();
        String resultado="";

        for(int i=0; i<7; i++)
        {
            resultado += Integer.toString(r.nextInt(10));
        }
        return resultado;
    }

    /**
     * Metodo que realiza una busqueda para devolver la posicion del paciente que coicida con el documento 
     * @param id Se envia como parametro el id para que la busqueda de toda la lista sea posible
     * @return int
     */
    public int devuelvePosicion(String id)
    {
        for(int i=0; i<lista_pacientes.size(); i++)
        {
            if(lista_pacientes.get(i).getId().equals(id))
            {
                return i;
            }
        }
        return -1;
    }

    /**
     * Metodo que recibe una ventana para que se pueda abrir y visible 
     * @param jif Se encia un objeto JInternalFrame para pueda realizar
     * el proceso de visibilidad y apertura de la ventana al igual que su seleccion 
     */
    public void abrirVentana(JInternalFrame jif)
    {
        if(jif.isVisible())
        {
            jif.toFront();
            jif.getFocusOwner();
            try {
                jif.setSelected(true);
            } catch (PropertyVetoException ex) {
                JOptionPane.showMessageDialog(null, "Error al abrir la ventana" + ex.toString());
            }
        }
            else if(!objVP.getPndEscritorio().isAncestorOf(jif))
            {
                objVP.getPndEscritorio().add(jif);
                jif.setVisible(true);
            }
            else
            {
                objVP.getPndEscritorio().setSelectedFrame(jif);
                jif.setVisible(true);
            }
    }
    
    /**
     * Metodo que recibe un objeto paciente para escribir en un txt
     * lo datos basicos del paciente
     * @param objPac Se envia como parametro un objeto paciente
     * para que sea posible la lectura de la informacion del paciente
     */
    public void escribirDatosPac(Paciente objPac){
        try {
            con.EscribeDatosPaciente(objPac.Datos());
        }catch (IOException ex) {
            JOptionPane.showMessageDialog(null, " Error de apertura del archivo");
        }
    }
    
    /**
     * Metodo que recibe un objeto de historia clinica para escribir en un txt
     * lo datos basicos del paciente y sel servicio utilizado
     * @param objH_c Se envia como parametro un objeto de historia clinica
     * para que escriba los datos que la historia contiene 
     */
    public void escribirDatosHC(Historia_Clinica objH_c){
        try {
            con.EscribeDatosHC(objH_C.DatosHC());
        }catch (IOException ex) {
            JOptionPane.showMessageDialog(null, " Error de apertura del archivo");
        }
    }
    /**
     * Metodo que recibe un objeto de examen para escribir en un txt
     * lo datos del examen tomado por la persona
     * @param x Se envia como parametro un objeto de tipo examen 
     * para que traiga la informacion de los examenes tomados por el paciente
     */
    public void escribirDatosExa(Examen x){
        try {
            con.EscribeDatosLab(x.DatosExa());
        }catch (IOException ex) {
            JOptionPane.showMessageDialog(null, " Error de apertura del archivo");
        }
    }
    /**
     * Metodo en el cual trae la informacion del txt para posteriormente ser
     * almacenado en la tabla de laboratorio
     * @param datos Se envia como parametro para que llame de la clase conexion
     * al metodo que lee la informacion del txt
     * @param tabla  Se envia como parametro un JTable para que alli se almacene la 
     * informacion
     */
    public void archivoTabla(String datos, JTable tabla){
        DefaultTableModel planilla = (DefaultTableModel) tabla.getModel();
        String ListaLaboratorio [] = datos.split("\n");
        for (int i = 0; i < ListaLaboratorio.length; i++) {
            String  lab[] = ListaLaboratorio[i].split(";");
            Object fila[] = {cont, lab[0], lab[1]};
            planilla.addRow(fila);
            cont++;
        }
    }
    
    public void ActualizarReg(){
        objVReg.getTxtIdentificacionPersona().setText("");
        objVReg.getTxtNombrePersona().setText("");
        objVReg.getTxtDireccionPersona().setText("");
        objVReg.getTxtTelefonoPersona().setText("");
        
    }

    @Override
    public void run() {
        while(true){
            try {
                objVP.getLblHora().setText(hora.toString());
                hora.actualizarSeg();
                sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("Error"+ex.toString());
            }
        }
    }
}
