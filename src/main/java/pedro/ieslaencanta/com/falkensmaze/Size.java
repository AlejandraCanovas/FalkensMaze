/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedro.ieslaencanta.com.falkensmaze;

import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *Representa el tamaño de un objeto bidimensional.
 * @author acb
 */
@XmlRootElement
public class Size implements Cloneable, Comparable<Size>, Serializable {
    private int width;
    private int height;
   
    /**
     *Constructor vacio que inicializa el ancho y alto 
     */
    public Size(){
    }

    /**
     *Constructor que inicializa el ancho y alto 
     * @param width ancho del tamaño
     * @param height alto del tamaño
     */
    public Size(int width,int height){
        this.width=width;
        this.height=height;
    }

    /**
     * crea un con del objeto tamaño con las mismas dimensiones 
     * @return 
     * Manda una excepcion si no se puede clonar el objeto
     * @throws CloneNotSupportedException
     */
    public Object clone() throws CloneNotSupportedException{
        return new Size(this.getWidth(), this.getHeight());
    }

    /**
     *Compara si un tamaño es igual a otro objeto, o es el objeto a comparar
     * @param o
     * si el ancho y el alto osn iguales devuelve true y si no lo son devuelve false
     * @return
     */
    @Override
    public boolean equals(Object o){
        if(! (o instanceof Size)){
            return false;
        }
        if (this.getWidth()==((Size)(o)).getWidth() && this.getHeight()==((Size)(o)).getHeight()){
            return true;
        }else{
            return false;
        }
        
    }

    /**
     *Compara el tamaño actual con otro tamaño, o es el tamaño a comparar
     * @param o
     *Devuelve 0 si los tamaños son iguales y -1 si el tamaño actual es menos y 
     * 1 si es mayor
     * @return
     */
    @Override
    public int compareTo(Size o) {
        if(this.getWidth()==o.getWidth() && this.getHeight()==o.getHeight())
            return 0;
        if(this.getWidth()<o.getWidth())
            return -1;
        else
            return 1;
    }

    /**
     *Devuelve la cadena que representa el tamaño
     * @return
     */
    public String toString(){
        return "W:"+this.width+" H:"+this.height;
    }
    /**Obtiene el ancho del tamaño
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**Obtiene el alto del tamaño
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**Establece el ancho del tamaño
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**Establece el alto del tamaño
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }
 

}
