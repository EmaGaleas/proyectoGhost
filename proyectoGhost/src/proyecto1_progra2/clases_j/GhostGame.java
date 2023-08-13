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
    private int turno=1;
    private String turnoPoner="BUENAS";
    public String j1="";
    public String oponente;
    //atributos para inicializar tablero
    public Pieza[][] matrizBotones; //de JButton a Pieza por valores
    private String modo="MANUAL";//por default INICIALIZAR O SI NO ERROR
    int dificultad=1;//por default
    int cantPiezas;//dependiente de dificultad 
    int trampas=0;
    
    //atributos sobre piezas de jugador
    private ArrayList<String> piezasJugadorUno;
    private ArrayList<String> piezasJugadorDos;
    
    private ArrayList<Integer> contadorBuenosJugadorUnoList = new ArrayList<>();
    private ArrayList<Integer> contadorMalosJugadorUnoList = new ArrayList<>();
    private ArrayList<Integer> contadorBuenosJugadorDosList = new ArrayList<>();
    private ArrayList<Integer> contadorMalosJugadorDosList = new ArrayList<>();
    
    public JButton[][] matrizButtonsUI;//ACCEDE A LOS BOTONES
    
    public void setOponente(String oponente) {
        this.oponente = oponente;
    }

    public GhostGame() {
        matrizButtonsUI = new JButton[6][6]; 
        //turno=1;
        piezasJugadorUno = new ArrayList<>();
        piezasJugadorDos = new ArrayList<>();
    }
    
    public void GridLayout(JPanel tablero) {//LISTO
        int filas = 6;
        int col = 6;
        GridLayout gridLayout = new GridLayout(filas, col);
        tablero.setLayout(gridLayout);
        matrizBotones = new Pieza[filas][col];
        modo();
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < col; j++) {
                final Pieza pieza = matrizBotones[i][j]; 
                JButton button = new JButton(); //CREAR JBUTTON
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
        if (fila >= 0 && fila < 6 && columna >= 0 && columna < 6 ) {
            
            matrizButtonsUI[fila][columna].setBackground(Color.BLACK);
        }
    }
    public void cambiarFondoBlanco(int fila, int columna) {//LISTO
        if (fila >= 0 && fila < 6 && columna >= 0 && columna < 6) {
            matrizButtonsUI[fila][columna].setBackground(Color.lightGray);
        }
    }
    public void cambiarImagenJ1(int filaDest, int columnaDest) {//LISTO
        if (filaDest >= 0 && filaDest < 6 && columnaDest >= 0 && columnaDest < 6) {
            ImageIcon icono = new ImageIcon(getClass().getResource("/imagenes/juego/fantasmaJ1.png"));
            matrizButtonsUI[filaDest][columnaDest].setIcon(icono);        
        }
    }
    public void cambiarImagenJ2(int filaDest, int columnaDest) {//LISTO
        if (filaDest >= 0 && filaDest < 6 && columnaDest >= 0 && columnaDest < 6) {
            ImageIcon icono = new ImageIcon(getClass().getResource("/imagenes/juego/fantasma.png"));
            matrizButtonsUI[filaDest][columnaDest].setIcon(icono);
        }
    }
    public void quitarImagen(int fila, int columna) {//LISTO
        if (fila >= 0 && fila < 6 && columna >= 0 && columna < 6) {
            matrizButtonsUI[fila][columna].setIcon(null);
        }
    }
    public void cambiarTurno() {//LISTO
      turno=(turno==1)?2:1;
    }
    public int getTurnoActual() {//LISTO
        return turno;
    }
    public void modo(){//LISTO
        switch(modo.toUpperCase()){
            case "ALEATORIO":
                difi();
                posicionarPiezasAleatorio();
                break;
            case "MANUAL":
                difi();
                posicionarManual();
                break;
            default:
                modo="ALEATORIO";
                posicionarPiezasAleatorio();
                break;
        }
    }
    public String getModo() {//LISTO
        return modo;
    }
    public int difi(){//LISTO
        switch (dificultad){
            case 1:
                cantPiezas=2;
                trampas=4;
                break;
            case 2:
                cantPiezas=4;
                trampas=0;
                break;
            case 4:
                cantPiezas=8;
                trampas=0;
                break;
            default:
                cantPiezas=8;
                trampas=0;
                break;
        }
       return cantPiezas;
    }
    private int posicionRandom(int min, int max) {//LISTO
        Random random=new Random();
        return random.nextInt(max-min+1)+min;
    }
    public void posicionarPiezasAleatorio() {//PENDIENTE FANTASMA FALSO/TRAMPA
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
        int contTrampasJugador1 = 0;
        while (contTrampasJugador1 < trampas) {
            int randomRow = posicionRandom(4, 5);
            int randomCol = posicionRandom(0, 5);
            if (matrizBotones[randomRow][randomCol] == null) {
                matrizBotones[randomRow][randomCol] = new Pieza("TRAMPA", "J1", randomRow, randomCol);
                contTrampasJugador1++;
            }
        }

        int contTrampasJugador2 = 0;
        while (contTrampasJugador2 < trampas) {
            int randomRow = posicionRandom(0, 1);
            int randomCol = posicionRandom(0, 5);
            if (matrizBotones[randomRow][randomCol] == null) {
                matrizBotones[randomRow][randomCol] = new Pieza("TRAMPA", "J2", randomRow, randomCol);
                contTrampasJugador2++;
            }
        }
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (matrizBotones[i][j] == null) {
                    Pieza piezaVacia = new Pieza("A", "A", i, j);
                    matrizBotones[i][j] = piezaVacia;
                }
            }
        }
    }
    private void mostrarInformacionPieza(Pieza pieza) {//LISTO
        if (pieza!=null) {
            String info="Tipo "+pieza.getFantasma()+"\nJugador "+pieza.getJugador()+"\nF"+pieza.getFila()+"\nC"+pieza.getColumna();
                JOptionPane.showMessageDialog(null, info, "Info", JOptionPane.INFORMATION_MESSAGE);
//            if(pieza.getJugador().equals("J1") && turno==1){
//                String info="Tipo "+pieza.getFantasma()+"\nJugador "+pieza.getJugador()+"\nF"+pieza.getFila()+"\nC"+pieza.getColumna();
//                JOptionPane.showMessageDialog(null, info, "Info", JOptionPane.INFORMATION_MESSAGE);
//            }else if(pieza.getJugador().equals("J2") && turno==2){
//                String info="Tipo "+pieza.getFantasma()+"\nJugador "+pieza.getJugador()+"\nF"+pieza.getFila()+"\nC"+pieza.getColumna();
//                JOptionPane.showMessageDialog(null, info, "Info", JOptionPane.INFORMATION_MESSAGE);
//            }
        }
    }
    public void instrucciones(){//? LISTO
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
    public ArrayList<Integer> getContadorBuenosJugadorUnoList() {//LISTO
        return contadorBuenosJugadorUnoList;
    }
    public ArrayList<Integer> getContadorMalosJugadorUnoList() {//LISTO
        return contadorMalosJugadorUnoList;
    }
    public ArrayList<Integer> getContadorBuenosJugadorDosList() {//LISTO
        return contadorBuenosJugadorDosList;
    }
    public ArrayList<Integer> getContadorMalosJugadorDosList() {//LISTO
        return contadorMalosJugadorDosList;
    }
    public int estadoPartidaActual() {//pendiente si saca de castillo
        int bJ1 = contadorBuenosJugadorUnoList.size();
        int mJ1 = contadorMalosJugadorUnoList.size();
        int bJ2 = contadorBuenosJugadorDosList.size();
        int mJ2 = contadorMalosJugadorDosList.size();

        if (bJ1 == 0 && turno == 2) {
        JOptionPane.showMessageDialog(null, "¡Jugador 2 ha ganado porque Jugador 1 se quedó sin buenos!", "Fin de Partida", JOptionPane.INFORMATION_MESSAGE);
        return 2; 
    } else if (mJ2 == 0 && turno == 1) {
        JOptionPane.showMessageDialog(null, "¡Jugador 2 ha ganado porque Jugador 1 se comió todos los malos!", "Fin de Partida", JOptionPane.INFORMATION_MESSAGE);
        return 2; 
    } else if (bJ2 == 0 && turno == 1) {
        JOptionPane.showMessageDialog(null, "¡Jugador 1 ha ganado porque Jugador 2 se quedó sin buenos!", "Fin de Partida", JOptionPane.INFORMATION_MESSAGE);
        return 1;
    } else if (mJ1 == 0 && turno == 2) {
        JOptionPane.showMessageDialog(null, "¡Jugador 1 ha ganado porque Jugador 2 se comió todos los malos!", "Fin de Partida", JOptionPane.INFORMATION_MESSAGE);
        return 1; 
    } else {
        return 0; // No termina
    }
    }
    public boolean datosIngresados(Pieza piezaSeleccionada) {//valida si esa pieza es de su turno LISTO
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
    private String ghostCastillo() {
        Random random = new Random();
        int randomNumber = random.nextInt(2); 
        if (randomNumber == 0) {
            return "BUENOS";
        } else {
            return "MALOS";
        }
    }
    public boolean esMovimientoValidoJugador(int nuevaFila, int nuevaColumna, int filaActual, int columnaActual) {//LISTO AQ PENDIENTE TRAMPA
       Pieza piezaDestino = matrizBotones[nuevaFila][nuevaColumna];
        if(piezaDestino !=null  && piezaDestino.getFantasma().equals("CASTILLO")&& !piezaDestino.getJugador().equals(botonSeleccionado.getJugador()) && !botonSeleccionado.getFantasma().equals("TRAMPA")){
            String tipoFantasma = ghostCastillo();
            JOptionPane.showMessageDialog(null, "Te has encontrado con un fantasma " + tipoFantasma, "Fantasma Generado", JOptionPane.INFORMATION_MESSAGE);
            if (tipoFantasma.equals("BUENOS") && turno == 1) {
                JOptionPane.showMessageDialog(null, ""+turno+"triunfo sobre"+"\nSaco un fantasma bueno de castillo", "VITORIA", JOptionPane.INFORMATION_MESSAGE);
            } else if (tipoFantasma.equals("BUENOS") && turno == 2) {
                JOptionPane.showMessageDialog(null, ""+turno+"triunfo sobre"+"\nSaco un fantasma bueno de castillo", "VICTORIA", JOptionPane.INFORMATION_MESSAGE);
            } else {
            }
             cambiarTurno();
                return false; 
            }
        if (piezaDestino != null && piezaDestino.getJugador().equals(botonSeleccionado.getJugador()) ||(piezaDestino.getFantasma().equals("CASTILLO"))) {
            System.out.println("No puedes mover sobre una pieza propia");
            return false;
        }
 
        if (piezaDestino !=null  ) {
            if (!piezaDestino.getJugador().equals(botonSeleccionado.getJugador()) && !botonSeleccionado.getFantasma().equals("TRAMPA")) {
                if (piezaDestino.getJugador().equals("J1") ) {
                    if(piezaDestino.getFantasma().equals("BUENOS")){
                        contadorBuenosJugadorUnoList.remove(contadorBuenosJugadorUnoList.size()-1);
                    }else if(piezaDestino.getFantasma().equals("MALOS")){
                        contadorMalosJugadorUnoList.remove(contadorMalosJugadorUnoList.size()-1);
                    }
                    piezasJugadorUno.remove(piezaDestino.getFantasma());
                } else if (piezaDestino.getJugador().equals("J2")) {
                    if(piezaDestino.getFantasma().equals("BUENOS")){
                        contadorBuenosJugadorDosList.remove(contadorBuenosJugadorDosList.size()-1);
                    }else if (piezaDestino.getFantasma().equals("MALOS")){
                        contadorMalosJugadorDosList.remove(contadorMalosJugadorDosList.size()-1);
                    }
                    piezasJugadorDos.remove(piezaDestino.getFantasma());
                }
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
    
    
    /*
    JUGADOR 1 INGRESE BUENO, MALO, BUENO , MALO...INTERCALADO...CUANDO SE LLENE SEGUN CANTIDAD DE PIEZAS POR JUGADOR 
    ES TURNO DE PONER PIEZAS DE JUGADOR 2, CUANDO TERMINE JOPTION QUE DIGA EMPEIZA EL JUEGO Y TURNO ES DE 1...
    SE DESBLOQUEA GET
    */
    
public boolean esTurnoModoManual() {
    if(contadorBuenosJugadorUnoList.size()== cantPiezas && contadorMalosJugadorUnoList.size()==cantPiezas){
        return turno==2;
    }
    return turno==1;  
}

    public void posicionarManual() {
        matrizBotones[0][0] = new Pieza("CASTILLO", "J2", 0, 0);
        matrizBotones[0][5] = new Pieza("CASTILLO", "J2", 0, 5);
        matrizBotones[5][0] = new Pieza("CASTILLO", "J1", 5, 0);
        matrizBotones[5][5] = new Pieza("CASTILLO", "J1", 5, 5);
        int contTrampasJugador1 = 0;
        while (contTrampasJugador1 < trampas) {
            int randomRow = posicionRandom(4, 5);
            int randomCol = posicionRandom(0, 5);
            if (matrizBotones[randomRow][randomCol] == null) {
                matrizBotones[randomRow][randomCol] = new Pieza("TRAMPA", "J1", randomRow, randomCol);
                contTrampasJugador1++;
            }
        }

        int contTrampasJugador2 = 0;
        while (contTrampasJugador2 < trampas) {
            int randomRow = posicionRandom(0, 1);
            int randomCol = posicionRandom(0, 5);
            if (matrizBotones[randomRow][randomCol] == null) {
                matrizBotones[randomRow][randomCol] = new Pieza("TRAMPA", "J2", randomRow, randomCol);
                contTrampasJugador2++;
            }
        }
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (matrizBotones[i][j] == null) {
                    Pieza piezaVacia = new Pieza("A", "A", i, j);
                    matrizBotones[i][j] = piezaVacia;
                }
            }
        }
    }
    public void cambiarTurnoPiezas() {//LISTO
      turnoPoner=(turnoPoner.equals("BUENOS"))?"MALOS":"BUENOS";
    }
    public String  getTurnoActualPiezas() {//LISTO
        return turnoPoner;
    }
    public boolean posicionarManualJ1() {
        if (contadorBuenosJugadorUnoList.size()==(cantPiezas/2) && contadorMalosJugadorUnoList.size()==(cantPiezas/2)) {
            return true;
        }
        return false;
    }
    public boolean posicionarManualJ2(){
        if(contadorBuenosJugadorDosList.size()==(cantPiezas/2) && contadorMalosJugadorDosList.size()==(cantPiezas/2)){
            return true;
        }
        return false;
    }
    public void crearPiezaJ1(int row, int col) {
            String turnoActual = getTurnoActualPiezas();
            Pieza newPiece = new Pieza(turnoActual, turnoActual, row, col); // Assuming "A" is an empty piece type
            matrizBotones[row][col] = newPiece;
           System.out.println("siiiiiiiiiuu");
        }
            
        
    
    

}/*
    if (turno == 1) {
        int contJugador1 = 0;
        int cantidadBuenos = 0;
        
        while (cantidadBuenos < piezasJugadorUno.size() / 2) {
            // Aquí se debe solicitar al usuario que ingrese las coordenadas
            // Supongamos que el usuario ingresa las coordenadas en las variables filaIngresada y columnaIngresada
            if (matrizBotones[fila][columna] == null) {
                String tipoFantasma = piezasJugadorUno.get(contJugador1);
                if (tipoFantasma.equals("BUENOS")) {
                    contadorBuenosJugadorUnoList.add(contJugador1);
                    cantidadBuenos++;
                } else if (tipoFantasma.equals("MALOS")) {
                    contadorMalosJugadorUnoList.add(contJugador1);
                }
                matrizBotones[fila][columna] = new Pieza(tipoFantasma, "J1", fila, columna);
                contJugador1++;
            }
        }
    }

    esTurnoModoManual();
*/