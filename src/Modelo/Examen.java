
package Modelo;

/**
 * La clase Examen permite instanciar un objeto examen 
 * @author Sebastian Molina y Joan Morales
 */
public class Examen 
{
    /**
     * Variables en las cuales contedran los datos pertinenetes para la clase examen 
     * en las que se utilizara de tipo String y double
     */
    private String Id_Examen, Nombre, Descripcion;
    private double valor;

    /**
     * Constructor parametrico quien inicializa a las variables de la clase
     * @param Id_Examen
     * @param Nombre
     * @param Descripcion
     * @param valor
     * Se envian como parametro las variables Id_Examen, Nombre, Descripcion y valor, para ser inicializadas 
     */
    public Examen(String Id_Examen, String Nombre, String Descripcion, double valor) {
        this.Id_Examen = Id_Examen;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.valor = valor;
    }
    
    /**
     * Constructor basico que inicializa las variables de la clase en nulo 
     */
    public Examen() {
        this.Id_Examen = "";
        this.Nombre = "";
        this.Descripcion = "";
        this.valor = 0;
    }
    
    /**
     * Retorna el contenido de la variable de tipo String
     * @return String
     */
    public String getId_Examen() {
        return Id_Examen;
    }

    /**
     * Permite modificar el contenido de la variable de tipo String
     * @param Id_Examen Se envia como parametro la variable para poder modificar el contenido 
     */
    public void setId_Examen(String Id_Examen) {
        this.Id_Examen = Id_Examen;
    }

    /**
     * Retorna el contenido de la variable de tipo String
     * @return String
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * Permite modificar el contenido de la variable de tipo String
     * @param Nombre Se envia como parametro la variable para poder modificar el contenido
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * Retorna el contenido de la variable de tipo String
     * @return String
     */
    public String getDescripcion() {
        return Descripcion;
    }

    /**
     * Permite modificar el contenido de la variable de tipo String
     * @param Descripcion Se envia como parametro la variable para poder modificar el contenido
     */
    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    /**
     * Retorna el contenido de la variable de tipo double
     * @return double 
     */
    public double getValor() {
        return valor;
    }

    /**
     * Permite modificar el contenido de la variable de tipo double
     * @param valor Se envia como parametro la variable para poder modificar el contenido
     */
    public void setValor(double valor) {
        this.valor = valor;
    }
    
    /**
     * Retorna un mensaje con los datos de las variables de la clase 
     * @return String
     */
    @Override
    public String toString() {
        return "Examen{" + "Id_Examen=" + Id_Examen + ", Nombre=" + Nombre + ", Descripcion=" + Descripcion + ", valor=" + valor + '}';
    }
    
    public String DatosExa(){
        
        String dato = " ";
        dato = this.Id_Examen+ " ; "+this.Nombre;
        return dato;
    }
    
}
