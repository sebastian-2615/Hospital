
package Modelo;

/**
 * La clase paciente permite instanciar al paciente 
 * @author Sebastian Molina y Joan Morales
 */
public class Paciente
{
    /**
     * Variables de tipo String  en donde se almacenara los datos pertinentes
     * tambien se encuentra el objeto de tipo afiliacion que se relaciuon con el paciente 
     */
    private String id,nombre,direccion,telefono;
    private Afiliacion tipo_afiliacion;

    /**
     * Constructor parametrico que inicializa a las variables de tipo String y al objeto de afiliacion
     * @param nombre
     * @param id
     * @param direccion
     * @param telefono
     * @param tipo_afiliacion
     * Este constructor recibe como parametros el nombre, id, direccion, telefono y tipo_afiliacion
     */
    public Paciente(String nombre, String id, String direccion, String telefono, Afiliacion tipo_afiliacion) {

        this.nombre = nombre;
        this.id = id;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tipo_afiliacion = tipo_afiliacion;
    }

    /**
     * Constructor basico que inicializa las variables en nulo 
     */
    public Paciente() {
        this.nombre = "";
        this.id = "";
        this.direccion = "";
        this.telefono = "";
        this.tipo_afiliacion = null;
    }

    /**
     * Retorna el contenido de la variable de tipo String
     * @return String 
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Permite modificar el contenido de la variable de tipo String
     * @param nombre Se envia como parametro la variable para poder modificar el contenido 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Retorna el contenido de la variable de tipo String
     * @return String
     */
    public String getId() {
        return id;
    }

    /**
     * Permite modificar el contenido de la variable de tipo String
     * @param id Se envia como parametro la variable para poder modificar el contenido
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Retorna el contenido de la variable de tipo String
     * @return String 
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Permite modificar el contenido de la variable de tipo String
     * @param direccion Se envia como parametro la variable para poder modificar el contenido
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Retorna el contenido de la variable de tipo String
     * @return String
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Permite modificar el contenido de la variable de tipo String
     * @param telefono Se envia como parametro la variable para poder modificar el contenido
     */ 
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Retorna el contenido de la variable de tipo Afiliacion 
     * @return Afiliacion
     */
    public Afiliacion getTipo_afiliacion() {
        return tipo_afiliacion;
    }

    /**
     * Permite modificar el contenido de la variable afiliacion de la persona 
     * @param tipo_afiliacion Se envia como parametro el tipo_afiliacion para poder modificar el contenido de la variable
     */
    public void setTipo_afiliacion(Afiliacion tipo_afiliacion) {
        this.tipo_afiliacion = tipo_afiliacion;
    }

    /**
     * Retorna el contenido de las variables en mensaje 
     * @return String
     */
    @Override
    public String toString() {
        
        return "nombre = " + nombre 
                + "\nid = " + id 
                + "\ndireccion = " + direccion 
                + "\ntelefono = " + telefono 
                + "\ntipo_afiliacion = " + tipo_afiliacion.Tipo();
    }
    
    public String Datos(){
        
        String dato = " ";
        
        if(tipo_afiliacion instanceof Sisben){
            dato =  this.nombre+ " ; "+ this.id + " ; "+this.direccion+" ; "+this.telefono+" ; "+"Sisben"; 
        }
        if(tipo_afiliacion instanceof Categoria_A){
            dato =  this.nombre+ " ; "+ this.id + " ; "+this.direccion+" ; "+this.telefono+" ; "+"Categoria_A"; 
        }
        if(tipo_afiliacion instanceof Categoria_B){
            dato =  this.nombre+ " ; "+ this.id + " ; "+this.direccion+" ; "+this.telefono+" ; "+"Categoria_B"; 
        }
        if(tipo_afiliacion instanceof Categoria_C){
            dato =  this.nombre+ " ; "+ this.id + " ; "+this.direccion+" ; "+this.telefono+" ; "+"Categoria_C"; 
        }
        return dato;
    }
    

    
    
    
    
}
