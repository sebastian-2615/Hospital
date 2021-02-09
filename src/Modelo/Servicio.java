
package Modelo;

/**
 * La clase servicio permite crear instancias de servicios
 * @author Sebastian Molina y Joan Morales
 */
public abstract class Servicio 
{
    /**
     * Variables de tipo String donde se almacenaran los datos correspondientes 
     */
    private String Id_Servicio,Nombre_Servicio,Descripcion;

    /**
     * Constructor parametrico que inicilializa las variables de tipo String 
     * @param Id_Servicio 
     * @param Nombre_Servicio
     * @param Descripcion
     * Este constructor recibe como parametros el Id_Servicio, Nombre_Servicio y la Descripcion
     */
    public Servicio(String Id_Servicio, String Nombre_Servicio, String Descripcion) {
        this.Id_Servicio = Id_Servicio;
        this.Nombre_Servicio = Nombre_Servicio;
        this.Descripcion = Descripcion;
    }

    /**
     * Constructor basico cual inicializa las variables en nulo
     */
    public Servicio() {
        this.Id_Servicio = "";
        this.Nombre_Servicio = "";
        this.Descripcion = "";
    }
    
    /**
     * Retorna la variable con el dato que es almacenado dentro de ella 
     * @return String
     */
    public String getId_Servicio() {
        return Id_Servicio;
    }

    /**
     * Permite modificar el contenido de la variable de tipo String 
     * @param Id_Servicio Este metodo recibe la variable Id_Servicio que es de tipo String
     */
    public void setId_Servicio(String Id_Servicio) {
        this.Id_Servicio = Id_Servicio;
    }

    /**
     * Retorna la variable con el dato que es almacenado dentro de ella 
     * @return String 
     */
    public String getNombre_Servicio() {
        return Nombre_Servicio;
    }

    /**
     * Permite modificar el contenido de la variable de tipo String 
     * @param Nombre_Servicio Este metodo recibe la variable Nombre_Servicio que es de tipo String
     */
    public void setNombre_Servicio(String Nombre_Servicio) {
        this.Nombre_Servicio = Nombre_Servicio;
    }

    /**
     * Retorna la variable con el dato que es almacenado dentro de ella 
     * @return String
     */
    public String getDescripcion() {
        return Descripcion;
    }

    /**
     * Permite modificar el contenido de la variable de tipo String 
     * @param Descripcion Este metodo recibe la variable Descripcion que es de tipo String 
     */
    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
    /**
     * Retorna el valor del servicio del paciente 
     * @param paciente Este metodo recibe un objeto de tipo paciente 
     * @return double
     */
    public abstract double tarifaServicio(Paciente paciente);

    /**
     * Retornna un mensaje con los valores de  las variables del servicio 
     * @return String
     */
    @Override
    public String toString() {
        return "Id_Servicio = " + Id_Servicio 
                + "\nNombre_Servicio = " + Nombre_Servicio 
                + "\nDescripcion=" + Descripcion.toString();
    }
    
    
    
    
}
