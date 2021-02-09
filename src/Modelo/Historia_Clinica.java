
package Modelo;

/**
 * La clase Historia_Clinica permite crear instancias de la historia clinica de la persona 
 * @author Sebastian Molina y Joan Morales 
 */
public class Historia_Clinica 
{
    /**
     * Variable de tipo entero que contedra el id de la clase 
     * Objeto de tipo fecha contiene la fecha del sistema
     * objeto de tipo paciente contiene al paciente
     * Objeto de tipo servicio contiene el servicio del paciente 
     */
    private int Id_Historia;
    private Fecha fecha;
    private Paciente paciente;
    private Servicio servicio;

    /**
     * Constructor parametrico que inicializa a las variables y a los objetos 
     * @param Id_Historia
     * @param fecha
     * @param paciente
     * @param servicio
     * Se envia como parametros la variable el Id_Historia y a los objetos fecha, paciente y servicio
     */
    public Historia_Clinica(int Id_Historia, Fecha fecha, Paciente paciente, Servicio servicio) {
        this.Id_Historia = Id_Historia;
        this.fecha = fecha;
        this.paciente = paciente;
        this.servicio = servicio;
    }
    
    /**
     * Constructor basico que inicializa a las variables y a los objetos en nulos 
     */
    public Historia_Clinica() {
        this.Id_Historia = 0;
        this.fecha = new Fecha();
        this.paciente = new Paciente();
        this.servicio = null;
    }

    /**
     * Retorna el valor de la variable de tipo entero 
     * @return int
     */
    public int getId_Historia() {
        return Id_Historia;
    }

    /**
     * Permite modificar el contenido de la variable 
     * @param Id_Historia Se envia la variable como parametro para poder ser modificada  
     */
    public void setId_Historia(int Id_Historia) {
        this.Id_Historia = Id_Historia;
    }

    /**
     * Retorna la fecha del sistema que esta dentro del objeto
     * @return Fecha
     */
    public Fecha getFecha() {
        return fecha;
    }

    /**
     * permite modificar el contenido del objeto fecha
     * @param fecha Se envia como parametro para que esta pueda ser modificada 
     */
    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    /**
     * Retorna el paciente del sistema que esta dentro del objeto
     * @return Paciente 
     */
    public Paciente getPaciente() {
        return paciente;
    }

    /**
     * permite modificar el contenido del objeto paciente
     * @param paciente  Se envia como parametro para que esta pueda ser modificada 
     */
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    /**
     * Retorna el servicio del sistema que esta dentro del objeto
     * @return Servicio
     */
    public Servicio getServicio() {
        return servicio;
    }

    /**
     * permite modificar el contenido del objeto servicio
     * @param servicio Se envia como parametro para que esta pueda ser modificada 
     */
    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    /**
     * Retorna los datos de las variables y objetos en un mensaje 
     * @return String 
     */
    @Override
    public String toString() {
        return "Id_Historia = " + Id_Historia 
                + "\nfecha = " + fecha 
                + "\n*******************************************************************"
                + "\n Paciente \n" + paciente 
                + "\n*******************************************************************"
                + "\n Servicio \n" + servicio.toString();
    }
    /**
     * Metodo que retorna un String con los datos de la historia clinica del
     * paciente con la informacion basica del paciente y del servicio prestado
     * @return String 
     */
    public String DatosHC(){
        
        String dato = " ";
        
        if(this.servicio instanceof Cita_Medicina_General){
            dato =  this.Id_Historia+ " ; "+this.fecha+" ; "+this.paciente.Datos()+" ; "+"Cita_Medicina_General"+"\n"+" ; "+this.servicio.getDescripcion()
                    +" ; "+this.servicio.tarifaServicio(paciente); 
        }
        if(this.servicio instanceof Vacunacion){
            dato =  this.Id_Historia+ " ; "+this.fecha+" ; "+this.paciente.Datos()+" ; "+"Vacunacion"+"\n"+" ; "+this.servicio.getDescripcion()
                    +" ; "+this.servicio.tarifaServicio(paciente);
        }
        if(this.servicio instanceof Hospitalizacion){
            dato =  this.Id_Historia+ " ; "+this.fecha+" ; "+this.paciente.Datos()+" ; "+"Hospitalizacion"+"\n"+" ; "+this.servicio.getDescripcion()
                    +" ; "+this.servicio.tarifaServicio(paciente); 
        }
        return dato;
    }
    
    /*
    public double prueba()
    {
        return this.servicio.tarifaServicio(paciente);
    }
    */
    
}
