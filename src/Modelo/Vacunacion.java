
package Modelo;

/**
 * La clase Vacunacion permite crear instancias de vacunacion que se encuentra dentro de servicio
 * @author Sebastian Molina y Joan Morales
 */
public class Vacunacion extends Servicio 
{

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
            return 20000;
        }
        return 0;
    }
    
}
