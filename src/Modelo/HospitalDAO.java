/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sonia Pinzón
 */
public class HospitalDAO {
   
    

    public DefaultTableModel consultar(){
         DefaultTableModel plantilla= new DefaultTableModel();
         ConexionBD con= new ConexionBD();
        try {
           con.conectar();
           Statement consulta= con.getConexion().createStatement();
            ResultSet datos= consulta.executeQuery("select * from pacientes");
            ResultSetMetaData campos=datos.getMetaData();
            for (int i = 1; i <= campos.getColumnCount(); i++) {
                plantilla.addColumn(campos.getColumnName(i));
            }
            while(datos.next()){
             Object fila[]=new Object[campos.getColumnCount()];
                for (int i = 0; i < campos.getColumnCount(); i++) {
                   fila[i]=datos.getObject(i+1);
                }
                plantilla.addRow(fila);
            }
            datos.close();
            con.getConexion().close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        return plantilla;
    }
    
    /*public String insertar(Recibo objr)  {
      String mensaje="";  
        try {
            ConexionBD conexion=new ConexionBD();
            Statement consulta = null;
            conexion.conectar();
            String comando= "insert into recibo_entrada values('"+objr.getNumero()+
                        "','"+ objr+"','"+objr.getHe().toString()+"','"+objr.getHs().toString()+"','"+objr.pagototal()+"')";
            consulta=conexion.getConexion().createStatement();
            consulta.execute(comando);
            mensaje="Registro exitoso...";
            consulta.close();
            conexion.getConexion().close();
        } catch (SQLException ex) {
           mensaje="Error al intentar insertar...\n"+ex;
        }
       return mensaje; 
    }*/
    
    public String insertarPac(Paciente objp){
        String mensaje=""; 
        try {
            ConexionBD conexion=new ConexionBD();
            PreparedStatement consulta = null;
            conexion.conectar();
            String comando= "insert into pacientes values(?,?,?,?,?)";
            consulta=conexion.getConexion().prepareStatement(comando);
            consulta.setString(1,objp.getId());
            consulta.setString(2,objp.getNombre());
            consulta.setString(3,objp.getDireccion());
            consulta.setString(4,objp.getTelefono());
            consulta.setString(5,objp.getTipo_afiliacion().Tipo());
            consulta.execute();
            mensaje="Registro exitoso...";
            consulta.close();
            conexion.getConexion().close();
        } catch (SQLException ex) {
           mensaje="Error al intentar insertar...\n"+ex;
        }
      return mensaje;  
    }
    public String insertarHC(Historia_Clinica objHC){
        String mensaje=""; 
        try {
            ConexionBD conexion=new ConexionBD();
            PreparedStatement consulta = null;
            conexion.conectar();
            String comando= "insert into historia_clinica values(?,?,?,?,?)";
            consulta=conexion.getConexion().prepareStatement(comando);
            consulta.setString(1,String.valueOf(objHC.getId_Historia()));
            consulta.setString(2,objHC.getFecha().toString());
            consulta.setString(3,objHC.getPaciente().getId());
            consulta.setString(4,objHC.getPaciente().getNombre());
            consulta.setString(5,objHC.getServicio().getNombre_Servicio());
            consulta.execute();
            mensaje="Registro exitoso...";
            consulta.close();
            conexion.getConexion().close();
        } catch (SQLException ex) {
           mensaje="Error al intentar insertar...\n"+ex;
        }
      return mensaje;  
    }
    public String insertar2(int x,Servicio objs, Examen obje,Historia_Clinica objHC){
        String mensaje=""; 
        try {
            ConexionBD conexion=new ConexionBD();
            PreparedStatement consulta = null;
            conexion.conectar();
            String comando= "insert into laboratorio values(?,?,?,?)";
            consulta=conexion.getConexion().prepareStatement(comando);
            consulta.setString(1,String.valueOf(x));
            consulta.setString(2,obje.getId_Examen());
            consulta.setString(3,objHC.getPaciente().getId());
            consulta.setString(4,objs.getNombre_Servicio());
            consulta.execute();
            mensaje="Registro exitoso...";
            consulta.close();
            conexion.getConexion().close();
        } catch (SQLException ex) {
           mensaje="Error al intentar insertar...\n"+ex;
        }
      return mensaje;  
    }
     
    public String Actualizar(Paciente objp){
        String mensaje=""; 
        try {
            ConexionBD conexion=new ConexionBD();
            PreparedStatement consulta = null;
            conexion.conectar();
            JOptionPane.showMessageDialog(null, objp.toString());
            String instruccion= "update pacientes "
                    +"set id=?, nombre=?, direccion=?, telefono=?, tipo_afiliacion=? where id='"
                    +objp.getId()+"'";
            consulta=conexion.getConexion().prepareStatement(instruccion);
            consulta.setString(1,objp.getId());
            consulta.setString(2,objp.getNombre());
            consulta.setString(3,objp.getDireccion());
            consulta.setString(4,objp.getTelefono());
            consulta.setString(5,objp.getTipo_afiliacion().Tipo());
            consulta.execute();
            mensaje="Registro exitoso...";
            consulta.close();
            conexion.getConexion().close();
        } catch (SQLException ex) {
           mensaje="Error al intentar insertar...\n"+ex;
        }
      return mensaje;  
    }
    
    public String Eliminar(String com){
        String mensaje=""; 
        try {
            ConexionBD conexion=new ConexionBD();
            PreparedStatement consulta = null;
            conexion.conectar();
            JOptionPane.showMessageDialog(null, com);
            String instruccion= "delete from pacientes where id='"+com+"'";
            consulta=conexion.getConexion().prepareStatement(instruccion);
            consulta.execute();
            mensaje="Registro exitoso...";
            consulta.close();
            conexion.getConexion().close();
        } catch (SQLException ex) {
           mensaje="Error al intentar insertar...\n"+ex;
        }
      return mensaje;  
    }
}
