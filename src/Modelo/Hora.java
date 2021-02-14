
package Modelo;

import java.util.Calendar;

/**
 * La clase Hora permite crear una instancia para traer la hora del sistema
 * @author Sebastian
 */
public class Hora {
    
    /**
     * Variables de tipo entero en donde se almacenara en formato de
     * la hora
     */
    int hora, min ,seg ;

    /**
     * Constructor parametrico cual recibe a la variables de tipo entero
     * @param hora
     * @param min
     */
    public Hora(int hora, int min, int seg) {    
         this.hora = hora;
         this.min = min  ;
         this.seg = seg;    
    }  

    /**
     * Constructor basico inicializa a las variables de tipo entero en nulo
     */
    public Hora() {
        Calendar horat = Calendar.getInstance();
        hora = horat.get(Calendar.HOUR_OF_DAY);
        min = horat.get(Calendar.MINUTE)  ;
        seg=horat.get(Calendar.SECOND);
    }  

    /**
     * Retorna a la variable de tipo entero 
     * @return int 
     */
    public int getHora() {
        return hora;
    }

    /**
     * Permite modificar a la variable de tipo entero su contenido
     * @param hora
     */
    public void setHora(int hora) {
        this.hora = hora;
    }

    /**
     * Retorna a la variable de tipo entero 
     * @return int 
     */
    public int getMin() {
        return min;
    }

    /**
     * Permite modificar a la variable de tipo entero su contenido
     * @param min
     */
    public void setMin(int min) {
        this.min = min;
    }

    public int getSeg() {
        return seg;
    }

    public void setSeg(int seg) {
        this.seg = seg;
    }
    

    /**
     * Genera un mensaje con los datos de la variables almacenadas en ellas
     * @return String
     */
    @Override
    public String toString() {
        return hora + ":" + min + ":"+seg;
    }
    
    public void actualizarSeg(){
        if(seg==59){
            seg=0;
            min++;
        }
        else if(min>59){
            min=0;
            hora++;
        }else if(hora>23){
            hora=0;
        }
        else{
            seg++;
        }
    }
    
}
