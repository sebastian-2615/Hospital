
package Modelo;

import java.util.Calendar;

/**
 * La clase Fecha permite crear instacias de tipo fecha 
 * @author Sebastian Molina y Joan Morales 
 */
public class Fecha {
    
    /**
     * Variables de tipo entero en donde se almacenaran los datos correspondientes de la clase Calendar
     */
   private int dd,mm,aa;

    /**
     * Constructor parametrico que inicializa las variables del metodo 
     * @param dd
     * @param mm
     * @param aa
     * Se envia como parametro las variables dd, mm y aa para ser inicializadas 
     */
    public Fecha(int dd, int mm, int aa) {
        this.dd = dd;
        this.mm = mm;
        this.aa = aa;
    }
   
    /**
     * Constructor basico que inicializa las variables con losd atos de la clase Calendar 
     */
    public Fecha(){
        Calendar fecha = Calendar.getInstance();
        this.dd = fecha.get(Calendar.DAY_OF_MONTH);
        this.mm = fecha.get(Calendar.MONTH)+1;
        this.aa = fecha.get(Calendar.YEAR);
    }

    /**
     * Retorna el valor de la variable con el dato corerespondiente de la clase Calendar 
     * @return int 
     */
    public int getDd() {
        return dd;
    }

    /**
     * Permite modificar el contenido de la variable que contiene el valor de la clase Calendar 
     * @param dd Se envia como parametro la variable para que sea posible la modificacion 
     */
    public void setDd(int dd) {
        this.dd = dd;
    }

    /**
     * Retorna el valor de la variable con el dato corerespondiente de la clase Calendar  
     * @return int 
     */
    public int getMm() {
        return mm;
    }

    /**
     * Permite modificar el contenido de la variable que contiene el valor de la clase Calendar 
     * @param mm Se envia como parametro la variable para que sea posible la modificacion
     */
    public void setMm(int mm) {
        this.mm = mm;
    }

    /**
     * Retorna el valor de la variable con el dato corerespondiente de la clase Calendar 
     * @return int 
     */
    public int getAa() {
        return aa;
    }

    /**
     * Permite modificar el contenido de la variable que contiene el valor de la clase Calendar 
     * @param aa Se envia como parametro la variable para que sea posible la modificacion
     */
    public void setAa(int aa) {
        this.aa = aa;
    }

    /**
     * Retorna los datos de las variables en un mensaje 00
     * @return String 
     */
    @Override
    public String toString() {
        return dd + "/" + mm + "/" + aa;
    }
}
