/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author messi
 */
public class FormatoEntradaException extends Exception {
    private int nroError;
    private String Msg;

    public FormatoEntradaException(int nroError, String Msg) {
        this.nroError = nroError;
        this.Msg = Msg;
    }
    public FormatoEntradaException(int nroError) {
        this.nroError = nroError;
        switch(nroError){
            case 101:
                Msg= "Se ha detectado valor nulo";
                break;
            case 102:
                Msg= "Solo se admiten letras";
                break;
        }
    }
    
    public FormatoEntradaException() {
        this.nroError = 0;
        this.Msg = " ";
    }

    public int getNroError() {
        return nroError;
    }

    public void setNroError(int nroError) {
        this.nroError = nroError;
    }

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String Msg) {
        this.Msg = Msg;
    }

    @Override
    public String toString() {
        return "Error" + nroError + ", Generado por: " + Msg + '}';
    }
    
    
    
    
}
