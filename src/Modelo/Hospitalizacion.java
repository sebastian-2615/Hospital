
package Modelo;

/**
 * La clase Hospitalizacion permite crear instancias de hospitalizacion que se encuentra dentro de servicio
 * @author Sebastian Molina y Joan Morales
 */
public class Hospitalizacion extends Servicio
{
    
    /**
     * Variables de tipo fecha para atraer la fecja del sistema 
     */
    private Fecha fecha_ingreso, fecha_salida;

    /**
     * Constructor parametrico que inicilializa las variables de tipo String 
     * @param fecha_ingreso
     * @param fecha_salida
     * @param Id_Servicio
     * @param Nombre_Servicio
     * @param Descripcion
     * Este constructor recibe como parametros el fecha_ingreso, fecha_salida, Id_CitaMedica, Id_Servicio, Nombre_Servicio y la Descripcion
     */
    public Hospitalizacion(Fecha fecha_ingreso, Fecha fecha_salida, String Id_Servicio, String Nombre_Servicio, String Descripcion) {
        super(Id_Servicio, Nombre_Servicio, Descripcion);
        this.fecha_ingreso = fecha_ingreso;
        this.fecha_salida = fecha_salida;
    }

    /**
     * Constructor basico que inicializa las variables de la clase padre y fecha en nulo  
     */
    public Hospitalizacion() {
        super();
        this.fecha_ingreso = new Fecha();
        this.fecha_salida = new Fecha();
    }

    /**
     * Retorna en la variable la fecha del sistema
     * @return Fecha
     */
    public Fecha getFecha_ingreso() {
        return fecha_ingreso;
    }

    /**
     * Permite modificar el contenido de la variable fecha_ingreso que contiene la fecha del sistema
     * @param fecha_ingreso Envia el parametro fecha_ingreso para poder modificar su contenido
     */
    public void setFecha_ingreso(Fecha fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    /**
     * Retorna en la variable la fecha del sistema
     * @return Fecha
     */
    public Fecha getFecha_salida() {
        return fecha_salida;
    }

    /**
     * Permite modificar el contenido de la variable fecha_salida que contiene la fecha del sistema
     * @param fecha_salida Envia el parametro fecha_salida para poder modificar su contenido
     */
    public void setFecha_salida(Fecha fecha_salida) {
        this.fecha_salida = fecha_salida;
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
            return 20000*retornaCantidadDeDias();
        }
        if(paciente.getTipo_afiliacion() instanceof Categoria_A)
        {
            return 30000*retornaCantidadDeDias();
        }
        if(paciente.getTipo_afiliacion() instanceof Categoria_B)
        {
            return 40000*retornaCantidadDeDias();
        }
        if(paciente.getTipo_afiliacion() instanceof Categoria_C)
        {
            return 70000*retornaCantidadDeDias();
        }
        return 0;
    }
    
    /**
     * Retorna la cantidad de dias de diferencia que hay entre la fecha de entrada y la de salida 
     * @return int 
     */
    public int retornaCantidadDeDias()
    {
        return fecha_salida.getDd()-fecha_ingreso.getDd();
    }
    
}
