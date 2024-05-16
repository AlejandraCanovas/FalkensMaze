/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedro.ieslaencanta.com.falkensmaze.model;

import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *Representa un bloque individual en un tablero
 * @author acb
 */
@XmlRootElement
public class Block implements  Serializable {
    /**
     * Valor asociado al bloque
     */
    private String value;
    
    /**
     *Constructor vacio que inicializa el valor del bloque a null
     * 
     */
    public Block(){
        this.value=null;
    }

    /**
     *OBtiene el valor actual del bloque
     * @return EL valor asociado al bloque puede ser null si no se ha establecido
     */
    public String getValue(){
        return this.value;
    }

    /**
     *Establece el valor del bloque
     * @param value El nuevo valor a asignar al bloque
     */
    public void setValue(String value){
        this.value=value;
    }

    /**
     *Comprueba si el bloque estáa vacio
     * Devuelve true si el valor del bloque es null y false en caso contrario
     * @return
     */
    public boolean isEmpty(){
        return this.value==null;
    }
}
