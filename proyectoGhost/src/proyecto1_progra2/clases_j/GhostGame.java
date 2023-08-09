/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_progra2.clases_j;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random; 

public class GhostGame {
    //atrubutos mover pieza
    private Pieza piezaDestino;
    private Pieza botonSeleccionado;//obtener datos
    private int turno;
    
    //atributos para inicializar tablero
    public Pieza[][] matrizBotones; //de JButton a Pieza por valores
    private String modo="ALEATORIO";//por default INICIALIZAR O SI NO ERROR
    int dificultad=1;//por default
    int cantPiezas;//dependiente de dificultad 
    
    //atributos sobre piezas de jugador
    private ArrayList<String> piezasJugadorUno;
    private ArrayList<String> piezasJugadorDos;

    public GhostGame() {
        turno=1;
        piezasJugadorUno = new ArrayList<>();
        piezasJugadorDos = new ArrayList<>();
    }
    
    public void GridLayout(JPanel tablero) {
        int filas = 6;
        int col = 6;
        GridLayout gridLayout = new GridLayout(filas, col);
        tablero.setLayout(gridLayout);
        matrizBotones = new Pieza[filas][col];
        modo();//SEGUN EL MODO LLAMA LAS FUNCIONES DE POSICIONAR
            for (int i = 0; i < filas; i++) {
            for (int j = 0; j < col; j++) {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(50, 100));
                // Verificar pieza
                Pieza pieza = matrizBotones[i][j];
                if (pieza != null && pieza.getFantasma().length() > 0 && pieza.getImagePath().length() > 0) {
                    ImageIcon icon = new ImageIcon(pieza.getImagePath());
                    button.setIcon(icon);
                }
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        mostrarInformacionPieza(pieza);

                    }
                });
                tablero.add(button);
                button.setBackground(Color.lightGray);
            }
        }
    }
    public void cambiarTurno() {
      turno = (turno == 1) ? 2 : 1;
    }
    public int getTurnoActual() {
        return turno;
    }
    public boolean datosIngresados(Pieza piezaSeleccionada) {//valida si puede continuar es decir, es respectivo con su turno **aplica al dar set
        if (piezaSeleccionada != null) {
            botonSeleccionado = piezaSeleccionada;
            if(botonSeleccionado.getJugador().equals("J1")&&turno==1){
                return true;
            }else if(botonSeleccionado.getJugador().equals("J1")&&turno==2){
                return false;
            }else if(botonSeleccionado.getJugador().equals("J2")&&turno==2){
                return true;
            }else if(botonSeleccionado.getJugador().equals("J2")&&turno==1){
                return false;
            }else{
                return false;
            }
        }
        return true;
    }
public boolean esMovimientoValidoJugador(int nuevaFila, int nuevaColumna, int filaActual, int columnaActual) {
        if (matrizBotones[nuevaFila][nuevaColumna] == null) {
        System.out.println("Movimiento válido a casilla vacía");
        return true;
    }
    if (nuevaFila == filaActual && ((nuevaColumna == columnaActual + 1) || (nuevaColumna == columnaActual - 1))) {
        System.out.println("Movimiento válido hacia la izquierda o derecha");
        return true;
    } else if (nuevaColumna == columnaActual && ((nuevaFila == filaActual + 1) || (nuevaFila == filaActual - 1))) {
        System.out.println("Movimiento válido hacia arriba o abajo");
        return true;
    } else {
        System.out.println("Movimiento no válido");
        return false;
    }
}


        //REVISAR OTRO TRUE
//    private boolean noEsCastillo(int filaDestino, int columnaDestino) {
//        if (piezaDestino != null) {
//            String destino = matrizBotones[filaDestino][columnaDestino].getFantasma();
//            if ("CASTILLO".equals(destino) ) {
//                return false;
//            }
//        }
//        return true; 
//    }
    //REVISAR
//    private boolean esMovimientoValido(int filaDestino, int columnaDestino) {
//        if (piezaDestino == null) {
//            return true;
//        }
//
//        String destino = matrizBotones[filaDestino][columnaDestino].getFantasma();
//        String jugadorDestino = matrizBotones[filaDestino][columnaDestino].getJugador();
//
//        if (!"CASTILLO".equals(destino) && (("J1".equals(piezaDestino.getJugador()) && !"J1".equals(jugadorDestino))
//                || ("J2".equals(piezaDestino.getJugador()) && !"J2".equals(jugadorDestino)))) {
//            return false;
//        }
//
//        return false;
//    }
    public void modo(){
        switch(modo){
            case "ALEATORIO":
                posicionarPiezasAleatorio();
                break;
            case "MANUAL":
                System.out.println("none");
                break;
            default:
                modo="ALEATORIO";
                posicionarPiezasAleatorio();
                break;
        }
    }
    public int difi(){
       switch (dificultad){
            case 1:
                cantPiezas=2;
                break;
            case 3:
                cantPiezas=6;
                break;
            case 4:
                cantPiezas=8;
                break;
            default:
                cantPiezas=8;
        }
       return cantPiezas;
    }
    
    private int posicionRandom(int min, int max) {
        Random random=new Random();
        return random.nextInt(max-min+1)+min;
    }
    //pendiente lo de fantasmas
    public void posicionarPiezasAleatorio() {
        for (int p = 0; p < dificultad; p++) {//cuantos en array, <2 es 4, <3 es 6 <4 es 8
            piezasJugadorUno.add("BUENOS");
            piezasJugadorUno.add("MALOS");
            piezasJugadorDos.add("BUENOS");
            piezasJugadorDos.add("MALOS");
        }
        //castillos FIJO
        matrizBotones[0][0] = new Pieza("CASTILLO", "J2", "C:\\Users\\pcast\\OneDrive\\Documentos\\NetBeansProjects\\New Folder\\proyecto1_progra2\\src\\imagenes\\juego\\castillo.jpg", 0, 0);
        matrizBotones[0][5] = new Pieza("CASTILLO", "J2", "C:\\Users\\pcast\\OneDrive\\Documentos\\NetBeansProjects\\New Folder\\proyecto1_progra2\\src\\imagenes\\juego\\castillo.jpg", 0, 5);
        matrizBotones[5][0] = new Pieza("CASTILLO", "J1", "C:\\Users\\pcast\\OneDrive\\Documentos\\NetBeansProjects\\New Folder\\proyecto1_progra2\\src\\imagenes\\juego\\castillo.jpg", 5, 0);
        matrizBotones[5][5] = new Pieza("CASTILLO", "J1", "C:\\Users\\pcast\\OneDrive\\Documentos\\NetBeansProjects\\New Folder\\proyecto1_progra2\\src\\imagenes\\juego\\castillo.jpg", 5, 5);
         //jugador 1 f 4 y 5
        int contJugador1 = 0;
        while (contJugador1<difi()){//p<3, entonces es 6, p<2 entonces es 4, p<4 entonces 8
            int randomRow=posicionRandom(4, 5);
            int randomCol=posicionRandom(0, 5);
            if (matrizBotones[randomRow][randomCol] == null) {
                int randomIndex = posicionRandom(0, piezasJugadorUno.size() - 1);
                matrizBotones[randomRow][randomCol] = new Pieza(piezasJugadorUno.get(randomIndex), "J1", "C:\\Users\\pcast\\OneDrive\\Documentos\\NetBeansProjects\\New Folder\\proyecto1_progra2\\src\\imagenes\\juego\\fantasmaJ1.png", randomRow, randomCol);
                piezasJugadorUno.remove(randomIndex);
                contJugador1++;
            }
        }
        //jugador 2 f 0 y 1
       int contJugador2 = 0;
            while (contJugador2<cantPiezas){
            int randomRow = posicionRandom(0, 1);
            int randomCol = posicionRandom(0, 5);
            if (matrizBotones[randomRow][randomCol] == null) {
                int randomIndex = posicionRandom(0, piezasJugadorDos.size() - 1);
                matrizBotones[randomRow][randomCol] = new Pieza(piezasJugadorDos.get(randomIndex), "J2", "C:\\Users\\pcast\\OneDrive\\Documentos\\NetBeansProjects\\New Folder\\proyecto1_progra2\\src\\imagenes\\juego\\fantasma.png", randomRow, randomCol);
                piezasJugadorDos.remove(randomIndex);
                contJugador2++;
            }
        }

    // Asignar la instancia de pieza vacía a todas las posiciones restantes
    for (int i = 0; i < 6; i++) {
        for (int j = 0; j < 6; j++) {
            if (matrizBotones[i][j] == null) {
                Pieza piezaVacia = new Pieza("A", "A", "A", i, j);
                matrizBotones[i][j] = piezaVacia;
            }
        }
    }
    }
    //informativo al dar click en piezas
    private void mostrarInformacionPieza(Pieza pieza) {
        if (pieza!=null) {
            String info="Tipo "+pieza.getFantasma()+"\nJugador "+pieza.getJugador()+"\nF"+pieza.getFila()+"\nC"+pieza.getColumna();
            JOptionPane.showMessageDialog(null, info, "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    //informativo
    public void instrucciones(){
        String reglas="COMO GANAR:\nF1-Capturar TODOS LOS BUENOS del oponente\nF2-Si te han capturado los MALOS\nF3-Si sacas un FANTASMA BUENO "
                + "del castillo del oponente\nF4-Si tu oponente se rinde";
        JOptionPane.showMessageDialog(null,reglas, "REGLAS", JOptionPane.INFORMATION_MESSAGE);
        String turno="TURNOS:\nEmpieza el jugador 1, es decir quien tiene las piezas con cinta roja y esta login seguido del jugador 2\nUn movimiento valido por jugador/turno";
        JOptionPane.showMessageDialog(null,turno, "REGLAS", JOptionPane.INFORMATION_MESSAGE);
        if(modo.equals("ALEATORIO")){
            JOptionPane.showMessageDialog(null,"MODO ALEATORIO\nNo sabras la identidad de tus piezas", "MODO", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,"MODO MANUAL\nTu decides el orden de tus piezas", "MODO", JOptionPane.NO_OPTION);
        }
    }

} 