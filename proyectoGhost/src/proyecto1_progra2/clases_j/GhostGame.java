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
    
    private ArrayList<Integer> contadorBuenosJugadorUnoList = new ArrayList<>();
    private ArrayList<Integer> contadorMalosJugadorUnoList = new ArrayList<>();
    private ArrayList<Integer> contadorBuenosJugadorDosList = new ArrayList<>();
    private ArrayList<Integer> contadorMalosJugadorDosList = new ArrayList<>();
    
    private JButton[][] matrizButtonsUI;//ACCEDE A LOS BOTONES

    public GhostGame() {
       matrizButtonsUI = new JButton[6][6]; 
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

        posicionarPiezasAleatorio();
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < col; j++) {
                final Pieza pieza = matrizBotones[i][j]; 
                JButton button = new JButton(); // Create a new JButton
                matrizButtonsUI[i][j] = button;
                if (pieza != null && pieza.getFantasma().length() > 0 && pieza.getImagePath() != null && pieza.getImagePath().length() > 0) {
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
    public void cambiarFondoNegro(int fila, int columna) {//LISTO
        if (fila >= 0 && fila < 6 && columna >= 0 && columna < 6) {
            matrizButtonsUI[fila][columna].setBackground(Color.BLACK);
        }
    }

    public void cambiarFondoBlanco(int fila, int columna) {//LISTO
        if (fila >= 0 && fila < 6 && columna >= 0 && columna < 6) {
            matrizButtonsUI[fila][columna].setBackground(Color.lightGray);
        }
    }
    public void cambiarFondoAmarillo(int fila, int columna) {//LISTO QUE PONGA L AIMAGEN RESPECTIVA SEGUN EL TURNO Y PIEZA
        if (fila >= 0 && fila < 6 && columna >= 0 && columna < 6) {
            matrizButtonsUI[fila][columna].setBackground(Color.yellow);
        }
    }
    public JButton getButtonAt(int row, int col) {
        return matrizButtonsUI[row][col];
    }
    public void cambiarImagenJ1(int fila, int columna) {
        if (fila >= 0 && fila < 6 && columna >= 0 && columna < 6) {
            ImageIcon icono = new ImageIcon(getClass().getResource("/imagenes/juego/fantasmaJ1.png"));
            matrizButtonsUI[fila][columna].setIcon(icono);
        }
    }    
    public void cambiarImagenJ2(int fila, int columna) {
        if (fila >= 0 && fila < 6 && columna >= 0 && columna < 6) {
            ImageIcon icono = new ImageIcon(getClass().getResource("/imagenes/juego/fantasma.png"));
            matrizButtonsUI[fila][columna].setIcon(icono);
        }
    }

    public void cambiarTurno() {//listo
      turno = (turno == 1) ? 2 : 1;
    }
    public int getTurnoActual() {//listo
        return turno;
    }
    public void modo(){//listo
        switch(modo.toUpperCase()){
            case "ALEATORIO":
                posicionarPiezasAleatorio();
                break;
            case "MANUAL":
                posicionarManual();
                break;
            default:
                modo="ALEATORIO";
                posicionarPiezasAleatorio();
                break;
        }
    }
    public String getModo() {//listo
        return modo;
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
        matrizBotones[0][0] = new Pieza("CASTILLO", "J2", 0, 0);
        matrizBotones[0][5] = new Pieza("CASTILLO", "J2", 0, 5);
        matrizBotones[5][0] = new Pieza("CASTILLO", "J1",  5, 0);
        matrizBotones[5][5] = new Pieza("CASTILLO", "J1", 5, 5);
         //jugador 1 f 4 y 5
        int contJugador1 = 0;
        while (contJugador1 < difi()) {
            int randomRow = posicionRandom(4, 5);
            int randomCol = posicionRandom(0, 5);
            if (matrizBotones[randomRow][randomCol] == null) {
                int randomIndex = posicionRandom(0, piezasJugadorUno.size() - 1);
                String tipoFantasma = piezasJugadorUno.get(randomIndex);
                // Agregar el conteo a la lista correspondiente
                if (tipoFantasma.equals("BUENOS")) {
                    contadorBuenosJugadorUnoList.add(contJugador1);
                } else if (tipoFantasma.equals("MALOS")) {
                    contadorMalosJugadorUnoList.add(contJugador1);
                }
                matrizBotones[randomRow][randomCol] = new Pieza(tipoFantasma, "J1", randomRow, randomCol);
                piezasJugadorUno.remove(randomIndex);
                contJugador1++;
            }
        }
        //jugador 2 f 0 y 1
        int contJugador2 = 0;
        while (contJugador2 < cantPiezas) {
            int randomRow = posicionRandom(0, 1);
            int randomCol = posicionRandom(0, 5);
            if (matrizBotones[randomRow][randomCol] == null) {
                int randomIndex = posicionRandom(0, piezasJugadorDos.size() - 1);
                String tipoFantasma = piezasJugadorDos.get(randomIndex);
                if (tipoFantasma.equals("BUENOS")) {
                    contadorBuenosJugadorDosList.add(contJugador2);
                } else if (tipoFantasma.equals("MALOS")) {
                    contadorMalosJugadorDosList.add(contJugador2);
                }
                matrizBotones[randomRow][randomCol] = new Pieza(tipoFantasma, "J2", randomRow, randomCol);
                piezasJugadorDos.remove(randomIndex);
                contJugador2++;
            }
        }
        // Asignar la instancia de pieza vacía a todas las posiciones restantes asi si funciona amover, revisar regreso, mejor que cada vez asigen esto
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (matrizBotones[i][j] == null) {
                    Pieza piezaVacia = new Pieza("A", "A", i, j);
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
    public ArrayList<Integer> getContadorBuenosJugadorUnoList() {
        return contadorBuenosJugadorUnoList;
    }

    public ArrayList<Integer> getContadorMalosJugadorUnoList() {
        return contadorMalosJugadorUnoList;
    }

    public ArrayList<Integer> getContadorBuenosJugadorDosList() {
        return contadorBuenosJugadorDosList;
    }

    public ArrayList<Integer> getContadorMalosJugadorDosList() {
        return contadorMalosJugadorDosList;
    }
    
    public boolean datosIngresados(Pieza piezaSeleccionada) {//valida si esa pieza es de su turno
        if (piezaSeleccionada != null && !piezaSeleccionada.getFantasma().equals("CASTILLO")) {
            botonSeleccionado = piezaSeleccionada;
            if(botonSeleccionado.getJugador().equals("J1")&&turno==1 ){
                return true;
            }else if(botonSeleccionado.getJugador().equals("J1")&&turno==2){
                return false;
            }else if(botonSeleccionado.getJugador().equals("J2")&&turno==2){
                return true;
            }else if(botonSeleccionado.getJugador().equals("J2")&&turno==1){
                return false;
            }else if(botonSeleccionado.getJugador().equals("CASTILLO")){
                return false;
            }else{
                return false;
            }
        }
        return false;
      
    }
    public boolean esMovimientoValidoJugador(int nuevaFila, int nuevaColumna, int filaActual, int columnaActual) {
       Pieza piezaDestino = matrizBotones[nuevaFila][nuevaColumna];
        if (piezaDestino != null && piezaDestino.getJugador().equals(botonSeleccionado.getJugador())) {
            System.out.println("No puedes mover sobre una pieza propia");
            return false;
        }
        if (piezaDestino != null) {
            // Verificar si la casilla de destino contiene una pieza del jugador contrario
            if (!piezaDestino.getJugador().equals(botonSeleccionado.getJugador())) {
                if (piezaDestino.getJugador().equals("J1")) {
                    piezasJugadorUno.remove(piezaDestino.getFantasma());
                     System.out.println("pieza elimidada 1");

                } else if (piezaDestino.getJugador().equals("J2")) {
                   System.out.println("pieza elimidada 2");
                    piezasJugadorDos.remove(piezaDestino.getFantasma());
                }
                // Actualizar la casilla para icon
                matrizBotones[nuevaFila][nuevaColumna] = null;
            }
        }
        if (matrizBotones[nuevaFila][nuevaColumna] == null && (nuevaFila == filaActual && ((nuevaColumna == columnaActual + 1) || (nuevaColumna == columnaActual - 1)))||
                (nuevaColumna == columnaActual && ((nuevaFila == filaActual + 1) || (nuevaFila == filaActual - 1)))) {
            System.out.println("Movimiento válido a casilla vacía");
            return true;
        }
        if (nuevaFila == filaActual && ((nuevaColumna == columnaActual + 1) || (nuevaColumna == columnaActual - 1))) {
            System.out.println("Movimiento hacia la izquierda o derecha");
            return true;
        } else if (nuevaColumna == columnaActual && ((nuevaFila == filaActual + 1) || (nuevaFila == filaActual - 1))) {
            System.out.println("Movimiento hacia arriba o abajo");
            return true;
        } else {
            System.out.println("Movimiento no vlido");
            return false;
        }
    }
    public boolean esTurnoModoManual() {
        return (turno==1 && contadorBuenosJugadorUnoList.size() < cantPiezas) ||
               (turno==2 && contadorBuenosJugadorDosList.size() < cantPiezas);
    }

 
    
private void posicionarManual() {
    matrizBotones[0][0] = new Pieza("CASTILLO", "J2", 0, 0);
    matrizBotones[0][5] = new Pieza("CASTILLO", "J2",  0, 5);
    matrizBotones[5][0] = new Pieza("CASTILLO", "J1", 5, 0);
    matrizBotones[5][5] = new Pieza("CASTILLO", "J1",5, 5);
    // J1 
    for (int i = 0; i < cantPiezas; i++) {
        String tipoFantasma = JOptionPane.showInputDialog(null, "Jugador 1: Ingrese CORDENADAS");
        if (tipoFantasma != null) {
            if (tipoFantasma.equals("BUENOS") || tipoFantasma.equals("MALOS")) {
                contadorBuenosJugadorUnoList.add(i); // Agregar al contador según corresponda
                piezasJugadorUno.add(tipoFantasma);
            } else {
                JOptionPane.showMessageDialog(null, "", "Error", JOptionPane.ERROR_MESSAGE);
                i--; 
            }
        } else {
            i--; 
        }
    }

    //J2
    for (int i = 0; i < cantPiezas; i++) {
        String tipoFantasma = JOptionPane.showInputDialog(null, "Jugador 2: Ingrese CORDENADAS");
        if (tipoFantasma != null) {
            if (tipoFantasma.equals("BUENOS") || tipoFantasma.equals("MALOS")) {
                contadorBuenosJugadorDosList.add(i); // Agregar al contador según corresponda
                piezasJugadorDos.add(tipoFantasma);
            } else {
                JOptionPane.showMessageDialog(null, "", "Error", JOptionPane.ERROR_MESSAGE);
                i--; // Decrementar para repetir el ingreso
            }
        } else {
            i--; // Decrementar para repetir el ingreso si se cancela
        }
    }

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