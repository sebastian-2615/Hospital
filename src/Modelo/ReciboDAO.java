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
public class ReciboDAO {
   
    

    public DefaultTableModel consultar(){
         DefaultTableModel plantilla= new DefaultTableModel();
         ConexionBD con= new ConexionBD();
        try {
           con.conectar();
           Statement consulta= con.getConexion().createStatement();
            ResultSet datos= consulta.executeQuery("select * from recibo_entrada");
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
    }
    public String insertar2(Recibo objr){
        String mensaje=""; 
        try {
            ConexionBD conexion=new ConexionBD();
            PreparedStatement consulta = null;
            conexion.conectar();
            String comando= "insert into recibo_entrada values(?,?,?,?,?)";
            consulta=conexion.getConexion().prepareStatement(comando);
            consulta.setString(1,objr.getNumero());
            //consulta.setString(2,objr);
            consulta.setString(3,objr.getHe().toString());
            consulta.setString(4,objr.getHs().toString());
            consulta.setString(5,String.valueOf(objr.pagototal()));
            consulta.execute();
            mensaje="Registro exitoso...";
            consulta.close();
            conexion.getConexion().close();
        } catch (SQLException ex) {
           mensaje="Error al intentar insertar...\n"+ex;
        }
      return mensaje;  
    }*/

    
     
}
