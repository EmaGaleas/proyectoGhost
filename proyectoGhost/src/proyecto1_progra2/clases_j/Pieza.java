/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package proyecto1_progra2.clases_j;
import javax.swing.ImageIcon;
import javax.swing.JButton;
public class Pieza extends JButton {
    private String fantasma;
    private String imagePath;
    private String jugador;
    private int fila;
    private int columna;
    
    private static final String DEFAULT_IMAGE_PATH_J1 = "C:\\Users\\pcast\\OneDrive\\Documentos\\NetBeansProjects\\New Folder\\proyectoGame\\proyectoGhost\\proyectoGhost\\src\\imagenes\\juego\\fantasmaJ1.png";
    private static final String DEFAULT_IMAGE_PATH_J2 = "C:\\Users\\pcast\\OneDrive\\Documentos\\NetBeansProjects\\New Folder\\proyectoGame\\proyectoGhost\\proyectoGhost\\src\\imagenes\\juego\\fantasma.png";
    private static final String DEFAULT_IMAGE_PATH_CASTILLO = "C:\\Users\\pcast\\OneDrive\\Documentos\\NetBeansProjects\\New Folder\\proyectoGame\\proyectoGhost\\proyectoGhost\\src\\imagenes\\juego\\castillo.jpg";

    public Pieza(String fantasma, String jugador, int fila, int columna) {
        this.fantasma = fantasma;
        this.jugador = jugador;
        this.fila = fila;
        this.columna = columna;

        // Establecer imagePath según el jugador
        if (jugador.equals("J1")&& !fantasma.equals("CASTILLO")) {
            this.imagePath = DEFAULT_IMAGE_PATH_J1;
        } else if(jugador.equals("J2")&& !fantasma.equals("CASTILLO")){
            this.imagePath = DEFAULT_IMAGE_PATH_J2;
        
        }else if (jugador.equals("J1")||jugador.equals("J2")&& fantasma.equals("CASTILLO")){
            this.imagePath = DEFAULT_IMAGE_PATH_CASTILLO;
        }
    }
    public String getFantasma() {
        return fantasma;
    }
    public void setFantasma(String fantasma) {
        this.fantasma = fantasma;
    }
    public String getImagePath() {
        return imagePath;
    }
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    public String getJugador() {
        return jugador;
    }
    public void setJugador(String jugador) {
        this.jugador = jugador;
    }
    public int getFila() {
        return fila;
    }
    public void setFila(int fila) {
        this.fila = fila;
    }
    public int getColumna() {
        return columna;
    }
    public void setColumna(int columna) {
        this.columna = columna;
    }
}
