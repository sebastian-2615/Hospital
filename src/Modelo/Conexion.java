/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.*;

/**
 *
 * @author Estudiante
 */
public class Conexion {
  protected BufferedReader ent ;
 protected FileReader archLee;
 protected FileWriter archEscr;
 protected PrintWriter sal; 

    public Conexion(BufferedReader ent, FileReader archLee, FileWriter archEscr, PrintWriter sal) {
        this.ent = ent;
        this.archLee = archLee;
        this.archEscr = archEscr;
        this.sal = sal;
    }
  public Conexion() throws IOException {
       
       this.archLee = null;
       this.archEscr = null;
       
    }
  
  public String leerDatosHC() throws IOException{
  
   this.archLee = new FileReader("HistoriaClinica.txt");
   ent = new BufferedReader(archLee);
   String datos=" ";
   String linea = this.ent.readLine();
   while (linea != null) { 
        datos+=linea+"\n";
   
    linea = ent.readLine();
   }
    ent.close();
    return datos;
 }
  
  public String leerDatosPaciente() throws IOException{
  
   this.archLee = new FileReader("Paciente.txt");
   ent = new BufferedReader(archLee);
   String datos=" ";
   String linea = this.ent.readLine();
   while (linea != null) { 
        datos+=linea+"\n";
   
    linea = ent.readLine();
   }
    ent.close();
    return datos;
 }
 public void EscribeDatosHC(String datos) throws IOException
 { 
   archEscr= new FileWriter("HistoriaClinica.txt",true);
   sal = new PrintWriter(archEscr);
   sal.println(datos);
   System.out.println("Ejecuto accion");
   sal.close();
 } 
 public void EscribeDatosPaciente(String datos) throws IOException
 { 
   archEscr= new FileWriter("Paciente.txt",true);
   sal = new PrintWriter(archEscr);
   sal.println(datos);
   System.out.println("Ejecuto accion");
   sal.close();
 } 
 public void EscribeDatosLab(String datos) throws IOException
 { 
   archEscr= new FileWriter("Laboratorio.txt",true);
   sal = new PrintWriter(archEscr);
   sal.println(datos);
   System.out.println("Ejecuto accion");
   sal.close();
 } 
 
 public String leerDatosLab() throws IOException{
  
   this.archLee = new FileReader("Laboratorio.txt");
   ent = new BufferedReader(archLee);
   String datos=" ";
   String linea = this.ent.readLine();
   while (linea != null) { 
        datos+=linea+"\n";
   
    linea = ent.readLine();
   }
    ent.close();
    return datos;
 }

}
