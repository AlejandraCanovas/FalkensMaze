/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pedro.ieslaencanta.com.falkensmaze.components;

/**
 *Es una interfaz que define los métodos que deben implementar
 * los objetos que quieren escuchar eventos de clic en un bloque.
 * @author acb
 */
public interface IBlockListener {

    /**
     *Metodo al que se llama cuando se hace clic en un bloque
     * @param b
     */
    public void onClicked(Block b);

    /**
     *Metodo que se llama cuando se hace dobleclic en un bloque
     * @param b
     */
    public void onDoubleClicked(Block b);
}
