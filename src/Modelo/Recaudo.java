
package Modelo;

import java.util.ArrayList;

/**
 * La clase Recaudo permite instanciar el recaudo general
 * @author Sebastian Molina y Joan Morales
 */
public class Recaudo 
{
    /**
     * ArrayList de tipo Historia_Clinica que contiene los datos del paciente y del servicio 
     */
    
    private ArrayList<Historia_Clinica> lista_H;

    /**
     * Constructor parametrico que inicializa el ArrayList del metodo
     * @param lista_H Se envia como parametro el ArrayList para poder ser inicializado
     */
    public Recaudo(ArrayList<Historia_Clinica> lista_H) {
        this.lista_H = lista_H;
    }
    
    /**
     * Constructor basico que inicializa en nulo el ArrayList
     */
    public Recaudo() {
        this.lista_H = new ArrayList<>();
    }

    /**
     * Retorna el contenido del ArrayList que contiene los datos del paciente y sel servicio
     * @return Historia_Clinica
     */
    public ArrayList<Historia_Clinica> getLista_H() {
        return lista_H;
    }

    /**
     * Permite modificar el contenido del ArrayList que contiene los datos del paciente del servicio 
     * @param lista_H Se envia como parametro el ArrayList para que sea posible modificar los datos que se encuentran dentro de ella  
     */
    public void setLista_H(ArrayList<Historia_Clinica> lista_H) {
        this.lista_H = lista_H;
    }

    /**
     * Retorna la listaH que es del historial clinico 
     * @return String 
     */
    @Override
    public String toString() {
        String acum = "";
        for(int i=0; i<lista_H.size(); i++)
        {
            acum += lista_H.get(i).toString() + "\n";
        }
        return acum;
    }

    /**
     * Retornar la sumatoria de las tarifas de los servicios de los pacientes 
     * @param objP Se envia como parametro para que se pueda recorrer la lista y realizar la sumatoria 
     * @return double 
     */

    
    public double recaudodos()
    {
        double acum = 0;
        for(int i=0; i<lista_H.size(); i++)
        {
            acum += lista_H.get(i).getServicio().tarifaServicio(lista_H.get(i).getPaciente());
        }
        return acum;
    }
    
    
   
}
