
package Modelo;

/**
 * La clase Cita_Medica_General permite crear instancias de cita medica que se encuentra dentro de servicio
 * @author Sebastian Molina y Joan Morales
 */
public class Cita_Medicina_General extends Servicio
{

    /**
     * Variable de tipo String en el cual se almacenara el Id_CitaMedica
     */
    
    private String id_CitaMedica;

    /**
     * Constructor parametrico que inicilializa las variables de tipo String 
     * @param id_CitaMedica
     * @param Id_Servicio
     * @param Nombre_Servicio
     * @param Descripcion
     * Este constructor recibe como parametros el Id_CitaMedica, Id_Servicio, Nombre_Servicio y la Descripcion
     */
    public Cita_Medicina_General(String id_CitaMedica, String Id_Servicio, String Nombre_Servicio, String Descripcion) {
        super(Id_Servicio, Nombre_Servicio, Descripcion);
        this.id_CitaMedica = id_CitaMedica;
    }

    /**
     * Constructor basico que inicializa las variables de la clase padre y de la clase en nulo
     */
    public Cita_Medicina_General() {
        super();
        this.id_CitaMedica = "";
    }

    /**
     * Retorna la variable con el dato que es almacenado dentro de ella 
     * @return String
     */
    public String getId_CitaMedica() {
        return id_CitaMedica;
    }

    /**
     * Permite modificar el contenido de la variable de tipo String
     * @param id_CitaMedica Este metodo recibe el Id_CitaMedica que es de tipo String
     */
    public void setId_CitaMedica(String id_CitaMedica) {
        this.id_CitaMedica = id_CitaMedica;
    }
    
    /**
     * Retorna el valor del servicios dependiendo de del tipo de afiliacion del paciente 
     * @param paciente El parametro paciente es enviado al metodo para realizar la verificar de la afiliacion
     * @return double 
     */
    @Override
    public double tarifaServicio(Paciente paciente) {
        if(paciente.getTipo_afiliacion() instanceof Sisben)
        {
            return 0;
        }
        if(paciente.getTipo_afiliacion() instanceof Categoria_A)
        {
            return 5000;
        }
        if(paciente.getTipo_afiliacion() instanceof Categoria_B)
        {
            return 10000;
        }
        if(paciente.getTipo_afiliacion() instanceof Categoria_C)
        {
            return 15000;
        }
        return 0;
    }
    
}
