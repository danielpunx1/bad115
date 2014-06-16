/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package registrofia;

/**
 *
 * @author daniel
 */
public class combos_procedimientos {
   
    private String dato;
    private int codigo;

    public combos_procedimientos(int codigo, String dato)
    {
        this.codigo=codigo;
        this.dato=dato;
    }
    
    public String getdato() {
        return dato;
    }

    public void setdato(String dato) {
        this.dato = dato;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public String toString()
    {
        return dato;
    }
    
}
