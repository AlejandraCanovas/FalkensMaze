/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedro.ieslaencanta.com.falkensmaze.model;

import com.google.gson.Gson;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Serializable;

import java.io.UnsupportedEncodingException;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import pedro.ieslaencanta.com.falkensmaze.Size;

/**
 * Representa un laberint bidimensional compuesto por bloques
 *
 * @author acb
 */
@XmlRootElement
public class Maze implements Serializable {

    private Size size;
    private Block[][] blocks;
    private double time;
    private String sound;

    /**
     * Constructor vacio que inicializa el laberinto con valores por defecto
     */
    public Maze() {
    }

    /**
     * Inicializa el labeinto creando una matriz de bloques vacía basada en el
     * tamaño del laberinto
     */
    public void init() {
        this.setBlocks(new Block[this.getSize().getHeight()][this.getSize().getWidth()]);
        for (int i = 0; i < this.getBlocks().length; i++) {
            for (int j = 0; j < this.getBlocks()[i].length; j++) {
                this.getBlocks()[i][j] = new Block();

            }
        }
    }

    /**
     * Metodo para reiniciar el laberinto borrando los valores de los bloques
     */
    public void reset() {
        for (int i = 0; i < this.getBlocks().length; i++) {
            for (int j = 0; j < this.getBlocks()[i].length; j++) {
                this.getBlocks()[i][j] = null;

            }
        }
        this.setBlocks(null);
    }

    /**
     * Reinicia el laberinto con un nuevo tamaño
     *
     * @param newsize
     */
    public void reset(Size newsize) {
        this.reset();;
        this.setSize(newsize);
        this.init();
    }

    /**
     * Establece el valor de un bloque específico en el laberinto
     *
     * @param value la fila del bloque
     * @param row la columna del bloque
     * @param col
     */
    public void setBlockValue(String value, int row, int col) {
        this.getBlocks()[col][row].setValue(value);
    }

    /**
     * Obtiene el valor del bloque en una posicion específica la fila del bloque
     *
     * @param row la columna del bloque
     * @param col el valor del bloque
     * @return
     */
    public String getBlockValue(int row, int col) {
        return this.getBlocks()[row][col].getValue();
    }

    /**
     * Devuelve el tamaño del laberinto
     *
     * @return
     */
    public Size getSize() {
        return size;
    }

    /**
     * Establece el tamaño del laberinto
     *
     * @param size
     */
    public void setSize(Size size) {
        this.size = size;
    }

    /**
     * Devuelve el tiempo del laberinto
     *
     * @return
     */
    public double getTime() {
        return time;
    }

    /**
     * Establece el tiempo del laberinto
     *
     * @param time
     */
    public void setTime(double time) {
        this.time = time;
    }

    /**
     * Devuelve el sonido del laberinto
     *
     * @return
     */
    public String getSound() {
        return sound;
    }

    /**
     * Establece el sonido del laberinto
     *
     * @param sound
     */
    public void setSound(String sound) {
        this.sound = sound;
    }

    /**
     * Obtiene los bloques del laberinto
     *
     * @return
     */
    public Block[][] getBlocks() {
        return blocks;
    }

    /**
     * Establece los bloques del laberinto
     *
     * @param blocks
     */
    public void setBlocks(Block[][] blocks) {
        this.blocks = blocks;
    }

    /**
     * Carga un laberinto desde un archivo basado en su extensión Este método
     * verifica la extensión del archivo para determinar el formato de
     * serialización utilizado y delega la carga a métodos auxiliares
     * específicos para cada formato.
     *
     * @param file El archico que contiene el laberinto
     * @return Devuelve un objeto 'Maze' que representa el laberinto cargado del
     * archivo
     * @throws JAXBException Si ocurre un error duante la carga del laberinto
     * @throws IOException Si hay un error al leer el archivo
     * @throws FileNotFoundException Si el archivo no se muestra
     * @throws ClassNotFoundException Si la clase Maze no se encuentra al cargar
     * desde binario
     * @throws Exception Si se produce una excepción general durante la carga
     * debido a una extensión no permitida.
     */
    public static Maze load(File file) throws JAXBException, IOException, FileNotFoundException, ClassNotFoundException, Exception {
        String extension = file.getName().substring(file.getName().lastIndexOf(".") + 1);
        Maze m = null;
        if (extension.equals("xml")) {
            m = Maze.loadXML(file);
        } else {
            if (extension.equals("json")) {
                m = Maze.loadJSON(file);

            } else {
                if (extension.equals("bin")) {
                    m = Maze.loadBin(file);
                } else {
                    throw new Exception("Exencsión " + extension + " no permitida");

                }
            }

        }
        return m;

    }

    /**
     * Guarda un laberinto en un archivo basado en su extensión. Este método
     * verifica la extensión del archivo para determinar el formato de
     * serialización utilizado y delega el guardado a
     * métodos auxiliares específicos para cada formato. Antes de guardar,
     * valida que el laberinto tenga un sonido asociado
     *
     * @param maze El laberinto que se desea guardar.
     * @param file El archivo donde se guardará el laberinto.
     * @throws JAXBException Si ocurre un error durante el guardado del
     * laberinto en formato XML.
     * @throws Exception Exception Si se produce una excepción general durante
     * la carga debido a una extensión no permitida.
     */
    public static void save(Maze maze, File file) throws JAXBException, Exception {
        if (maze.sound == null || maze.sound.equals("")) {
            throw new Exception("Es necesario indicar el sonido del laberinto");
        }
        String extension = file.getName().substring(file.getName().lastIndexOf(".") + 1);
        if (extension.equals("xml")) {
            Maze.saveXML(maze, file);
        } else {
            if (extension.equals("json")) {
                Maze.saveJSON(maze, file);

            } else {
                if (extension.equals("bin")) {
                    Maze.saveBin(maze, file);
                } else {
                    throw new Exception("Exencsión " + extension + " no permitida");

                }
            }

        }
    }

    private static Maze loadJSON(File file) throws FileNotFoundException, IOException {
        Gson gson = new Gson();
        Reader reader;
        reader = Files.newBufferedReader(file.toPath());
        Maze m = gson.fromJson(reader, Maze.class);
        reader.close();
        return m;
    }

    private static Maze loadXML(File file) throws JAXBException, IOException {

        JAXBContext context = JAXBContext.newInstance(Maze.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Maze maze = (Maze) unmarshaller.unmarshal(
                file);
        return maze;

    }

    /**
     * Carga un laberinto desde un archivo binario. Este método abre el archivo
     * binario especificado y utiliza la clase `ObjectInputStream` para
     * deserializar el objeto `Maze` contenido en el archivo. Antes de retornar
     * el laberinto, cierra el flujo de entrada y el archivo para liberar los
     * recursos.
     *
     * @param file El archivo binario que contiene el laberinto serializado.
     * @return Un objeto `Maze` que representa el laberinto cargado del archivo.
     * @throws FileNotFoundException Si el archivo no se encuentra.
     * @throws IOException Si hay un error al leer el archivo binario.
     * @throws ClassNotFoundException Si la clase `Maze` no se encuentra durante
     * la deserialización.
     */
    public static Maze loadBin(File file) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream os = new FileInputStream(file);

        ObjectInputStream oos = new ObjectInputStream(os);
        Maze m = (Maze) oos.readObject();
        oos.close();;
        os.close();
        return m;
    }

    private static void saveJSON(Maze maze, File file) throws FileNotFoundException, UnsupportedEncodingException {
        Gson gson = new Gson();
        String json = gson.toJson(maze);
        java.io.PrintWriter pw = new PrintWriter(file, "UTF-8");
        pw.print(json);
        pw.close();
    }

    private static void saveXML(Maze maze, File file) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(maze.getClass());
        // create an instance of `Marshaller`
        Marshaller marshaller = context.createMarshaller();
        // enable pretty-print XML output
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        // write XML to `StringWriter`
        FileWriter fw = new FileWriter(file, StandardCharsets.UTF_8);//(file, "UTF-8");
        marshaller.marshal(maze, fw);
        fw.close();

    }

    /**
     * Guarda un laberinto en un archivo binario.
     * Este método serializa el objeto `maze` utilizando la clase
     * `ObjectOutputStream` y lo escribe en el archivo binario especificado.
     * Antes de retornar, cierra el flujo de salida y el archivo para liberar
     * los recursos.
     * @param maze El laberinto que se desea guardar.
     * @param file El archivo binario donde se guardará el laberinto
     * serializado.
     * @throws FileNotFoundException Si el archivo no se encuentra o no se puede
     * crear.
     * @throws IOException Si hay un error al escribir en el archivo binario.
     */
    public static void saveBin(Maze maze, File file) throws FileNotFoundException, IOException {
        OutputStream os = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(maze);
        oos.close();;
        os.close();
    }

}
