
package Modelo;

import java.util.ArrayList;

/**
 * La clase Vacunacion permite crear instancias de vacunacion que se encuentra dentro de servicio
 * @author Sebastian Molina y Joan Morales
 */
public class Laboratorio extends Servicio
{

    /**
     * ArrayList de tipo examen quien contendra los examenes de laboratorio 
     */
    
    private ArrayList<Examen> lista_examenes;

    /**
     * Constructor parametrico que inicilializa las variables de tipo String 
     * @param lista_examenes
     * @param Id_Servicio
     * @param Nombre_Servicio
     * @param Descripcion
     * Este constructor recibe como parametros el lista_examenes, Id_CitaMedica, Id_Servicio, Nombre_Servicio y la Descripcion
     */
    public Laboratorio(ArrayList<Examen> lista_examenes, String Id_Servicio, String Nombre_Servicio, String Descripcion) {
        super(Id_Servicio, Nombre_Servicio, Descripcion);
        this.lista_examenes = lista_examenes;
    }

    /**
     * Constructor basico que inicializa las variables de la clase padre y  del arreglo en nulo  
     */
    public Laboratorio() {
        super();
        this.lista_examenes = new ArrayList<>();
    }

    /**
     * Retorna la lista de los examenes con los examenes que esta lista posee
     * @return Examen 
     */
    public ArrayList<Examen> getLista_examenes() {
        return lista_examenes;
    }

    /**
     * Permite modificar los daros que estan dentro de la lista de los examenes 
     * @param lista_examenes Encia como parametro al metodo la lista para poder modificar los atributos 
     */
    public void setLista_examenes(Examen lista_examenes) {
        this.lista_examenes.add(lista_examenes);
    }
    
    /**
     * Retorna el valor del servicios dependiendo de del tipo de afiliacion del paciente 
     * @param paciente El parametro paciente es enviado al metodo para realizar la verificar de la afiliacion
     * @return double 
     */
    @Override
    public double tarifaServicio(Paciente paciente) 
    {
        for(int i=0; i<lista_examenes.size(); i++)
        {
            if(paciente.getTipo_afiliacion() instanceof Sisben)
            {
                return 0;
            }
            if(paciente.getTipo_afiliacion() instanceof Categoria_A)
            {
                return lista_examenes.get(i).getValor()*0.10;
            }
            if(paciente.getTipo_afiliacion() instanceof Categoria_B)
            {
                return lista_examenes.get(i).getValor()*0.50;
            }
            if(paciente.getTipo_afiliacion() instanceof Categoria_C)
            {
                return lista_examenes.get(i).getValor();
            }
        }
        
        return 0;
    }
    
    
}
