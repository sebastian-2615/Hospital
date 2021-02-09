
package proymedico;

import Controlador.Controlador;
import java.io.IOException;

/**
 * Clase que isntancia un objeto de controlador para que se pueda hacer la ejecucion del  programa
 * dentro de esta clase que es la principal
 * @author Sebastian Molina y Joan Morales
 */
public class ProyMedico {

    /**
     * Metodo que instancia un objeto de controlador y llamada al
     * metodo iniciar de controlador para visualizar la ejecucion de 
     * la estructura del programa
     * @param args Se envia como parametro un arreglo de tipo String quien es el encargado de 
     * recoger y almacenar los valores que hacen posible la ejecucion 
     */
    public static void main(String[] args) throws IOException 
    {
        Controlador c = new Controlador();
        c.iniciar();
    }
    
}
