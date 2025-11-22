/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.proyectoparchis.model;

import java.awt.Component;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author jeanmarco
 */

public class Board {
    ;//esto controla si la ficha ya salió
    private Square[] squares;
    private Home homeYellow;
    private Home homeRed;
    private Home homeBlue;
    private Home homeGreen;
    private BancoDePreguntas banco;
    //private BancoDePreguntasEspeciales bancoEspeciales;
    private int posicionActualRoja=0;//es el indice que determina en que posicion se encuentra o se dibuja la pieza roja
    private int posicionActualAmarillo=0;//es el indice que determina en que posicion se encuentra o se dibuja la pieza amarilla
    private int posicionActualAzul=0;//es el indice que determina en que posicion se encuentra o se dibuja la pieza azul
    private int posicionActualVerde=0;//es el indice que determina en que posicion se encuentra o se dibuja la pieza verde
    private Position[] positions;//array de posiciones
    private boolean fichaRojaEnCasa = true;
    private boolean fichaAzulEnCasa = true;
    private boolean fichaAmarillaEnCasa = true;
    private boolean fichaVerdeEnCasa = true;
    private boolean fichaRojaSalio = false;
    private boolean fichaAmarillaSalio = false;
    private boolean fichaAzulSalio = false;
    private boolean fichaVerdeSalio = false;


    public Board(String colorUno, double puntaje)//color que selecciona el jugador
    {
        this.banco=new BancoDePreguntas();
        //this.bancoEspeciales=new BancoDePreguntasEspeciales();
        this.squares=new Square[68];
        this.positions=new Position[68];
        this.homeYellow=new Home("Amarillo");//se crea un objeto tipo Home que es la parte que administra la casa amarilla
        this.homeRed=new Home("Rojo");//se crea un objeto tipo Home que es la parte que administra la casa roja
        this.homeBlue=new Home("Azul");//se crea un objeto tipo Home que es la parte que administra la casa azul
        this.homeGreen=new Home("Verde");//se crea un objeto tipo Home que es la parte que administra la casa verde
        //setPositions();//crea casillas del tablero
        //initPositions();
        switch(colorUno)//segun lo que se elija inicializa la posiciones de el recorrido de cada casa
        {
            case "Rojo":
                initPositionsRed();
            break;
            case "Azul":
                initPositionsBlue();
            break;
            case "Amarillo":
                initPositionsYellow();
            break;
            case "Verde":
                initPositionsGreen();
            break;
        }
        
        
        quadrants(colorUno);//crea las piezas dentro de las casas, se le manda el color para que decida cuales se casas se crean
        //fichas(colorUno, puntaje);//aqui ocurre toda la logistica, lo de las preguntas, el movimiento de las fichas, es como un controlador dentro de esta clase/ color que elige la persona
    }
    
    public void draw(Component c, Graphics g)
    {
        for(int element=0;element<squares.length;element++)
        {
            if(squares[element]!=null)
            {
                if(squares[element].getPiece()!=null)
                {
                    squares[element].getPiece().draw(c, g);
                }
            }
        }
        
        for(int index=0;index<homeYellow.getLength();index++)
        {
           if(homeYellow!=null)
           {
                if (homeYellow.getPiece(index) != null) homeYellow.getPiece(index).draw(c, g);//se llama al metodo getPiece(index) del objeto HomeYellow. Solo si la pieza no es null, entonces sigue. Dibuja la pieza
                if (homeRed.getPiece(index) != null) homeRed.getPiece(index).draw(c, g);//se llama al metodo getPiece(index) del objeto HomeYellow. Solo si la pieza no es null, entonces sigue. Dibuja la pieza
                if (homeBlue.getPiece(index) != null) homeBlue.getPiece(index).draw(c, g);//se llama al metodo getPiece(index) del objeto HomeYellow. Solo si la pieza no es null, entonces sigue. Dibuja la pieza
                if (homeGreen.getPiece(index) != null) homeGreen.getPiece(index).draw(c, g);//se llama al metodo getPiece(index) del objeto HomeYellow. Solo si la pieza no es null, entonces sigue. Dibuja la pieza
           }//Dibuja las piezas del cada home en el tablero, si es que existen.
        }
    }//draw
    public void initPositions()//aqui se encuentran las coordenadas con número del tablero, es el unico que si esta en orden. La posicion 0 en el array es como la posicion 1 del tablero
    {
        positions[0]=new Position(348,642);
        positions[1]=new Position(348,617);
        positions[2]=new Position(348,588);
        positions[3]=new Position(348,563);
        positions[4]=new Position(348,535);
        positions[5]=new Position(348,512);
        positions[6]=new Position(348,485);
        positions[7]=new Position(348,450);//que en realidad es la casilla 8, porque la posicion es 7 en el array, pero en realidad es 8 en el tablero
        positions[8]=new Position(376,423);
        positions[9]=new Position(402,423);
        positions[10]=new Position(451,423);
        positions[11]=new Position(454,423);
        positions[12]=new Position(481,423);
        positions[13]=new Position(507,423);
        positions[14]=new Position(533,423);
        positions[15]=new Position(561,423);//en realidad es la casilla 16
        positions[16]=new Position(557,362);//casilla de terminar, 17
        positions[17]=new Position(557,296);
        positions[18]=new Position(534,296);
        positions[19]=new Position(504,296);
        positions[20]=new Position(481,296);
        positions[21]=new Position(455,296);
        positions[22]=new Position(429,296);
        positions[23]=new Position(405,296);
        positions[24]=new Position(379,296);//en realidad es la casilla 25
        positions[25]=new Position(348,267);
        positions[26]=new Position(348,248);
        positions[27]=new Position(348,224);
        positions[28]=new Position(348,196);
        positions[29]=new Position(348,166);
        positions[30]=new Position(348,134);
        positions[31]=new Position(348,113);
        positions[32]=new Position(348,84);//en realidad casilla 33
        positions[33]=new Position(276,84);//casilla de terminar, 34
        positions[34]=new Position(209,84);
        positions[35]=new Position(209,110);
        positions[36]=new Position(209,138);
        positions[37]=new Position(209,163);
        positions[38]=new Position(209,141);
        positions[39]=new Position(209,218);
        positions[40]=new Position(209,242);
        positions[41]=new Position(209,268);//en realidad casilla 42
        positions[42]=new Position(186,296);
        positions[43]=new Position(161,296);
        positions[44]=new Position(135,296);
        positions[45]=new Position(109,296);
        positions[46]=new Position(84,296);
        positions[47]=new Position(58,296);
        positions[48]=new Position(31,296);
        positions[49]=new Position(5,296);//en realidad casilla 50
        positions[50]=new Position(5,296);//casilla de terminar, 51
        positions[51]=new Position(5,423);
        positions[52]=new Position(30,423);
        positions[53]=new Position(55,423);
        positions[54]=new Position(82,423);
        positions[55]=new Position(107,423);
        positions[56]=new Position(135,423);
        positions[57]=new Position(163,423);
        positions[58]=new Position(185,423);//en realidad casilla 59
        positions[59]=new Position(209,406);
        positions[60]=new Position(209,485);
        positions[61]=new Position(209,512);
        positions[62]=new Position(209,535);
        positions[63]=new Position(209,563);
        positions[64]=new Position(209,588);
        positions[65]=new Position(209,617);
        positions[66]=new Position(209,642);
        positions[67]=new Position(276,652);
        
    }
    
    public void initPositionsRed()//aqui se inicializa las coordenadas del camino de la ficha roja
    {//posicion rojas
        positions[0]=new Position(209,141);
        positions[1]=new Position(209,218);
        positions[2]=new Position(209,242);
        positions[3]=new Position(209,268);//en realidad casilla 42
        positions[4]=new Position(186,296);
        positions[5]=new Position(161,296);
        positions[6]=new Position(135,296);
        positions[7]=new Position(109,296);
        positions[8]=new Position(84,296);
        positions[9]=new Position(58,296);
        positions[10]=new Position(31,296);
        positions[11]=new Position(5,296);//en realidad casilla 50
        positions[12]=new Position(5,296);//casilla de terminar, 51
        positions[13]=new Position(5,423);
        positions[14]=new Position(30,423);
        positions[15]=new Position(55,423);
        positions[16]=new Position(82,423);
        positions[17]=new Position(107,423);
        positions[18]=new Position(135,423);
        positions[19]=new Position(163,423);
        positions[20]=new Position(185,423);//en realidad casilla 59
        positions[21]=new Position(209,406);
        positions[22]=new Position(209,485);
        positions[23]=new Position(209,512);
        positions[24]=new Position(209,535);
        positions[25]=new Position(209,563);
        positions[26]=new Position(209,588);
        positions[27]=new Position(209,617);
        positions[28]=new Position(209,642);
        positions[29]=new Position(276,652);
        positions[30]=new Position(348,642);
        positions[31]=new Position(348,617);
        positions[32]=new Position(348,588);
        positions[33]=new Position(348,563);
        positions[34]=new Position(348,535);
        positions[35]=new Position(348,512);
        positions[36]=new Position(348,485);
        positions[37]=new Position(348,450);//que en realidad es la casilla 8, porque la posicion es 7 en el array, pero en realidad es 8 en el tablero
        positions[38]=new Position(376,423);
        positions[39]=new Position(402,423);
        positions[40]=new Position(451,423);
        positions[41]=new Position(454,423);
        positions[42]=new Position(481,423);
        positions[43]=new Position(507,423);
        positions[44]=new Position(533,423);
        positions[45]=new Position(561,423);//en realidad es la casilla 16
        positions[46]=new Position(557,362);//casilla de terminar, 17
        positions[47]=new Position(557,296);
        positions[48]=new Position(534,296);
        positions[49]=new Position(504,296);
        positions[50]=new Position(481,296);
        positions[51]=new Position(455,296);
        positions[52]=new Position(429,296);
        positions[53]=new Position(405,296);
        positions[54]=new Position(379,296);//en realidad es la casilla 25
        positions[55]=new Position(348,267);
        positions[56]=new Position(348,248);
        positions[57]=new Position(348,224);
        positions[58]=new Position(348,196);
        positions[59]=new Position(348,166);
        positions[60]=new Position(348,134);
        positions[61]=new Position(348,113);
        positions[62]=new Position(348,84);//en realidad casilla 33
        positions[63]=new Position(276,84);//casilla de terminar, 34
    }
    
    public void initPositionsBlue()//aqui se inicializa las coordenadas del camino de la ficha azul
    {
        //posicion azules
        positions[0]=new Position(455,296);
        positions[1]=new Position(429,296);
        positions[2]=new Position(405,296);
        positions[3]=new Position(379,296);//en realidad es la casilla 25
        positions[4]=new Position(348,267);
        positions[5]=new Position(348,248);
        positions[6]=new Position(348,224);
        positions[7]=new Position(348,196);
        positions[8]=new Position(348,166);
        positions[9]=new Position(348,134);
        positions[10]=new Position(348,113);
        positions[11]=new Position(348,84);//en realidad casilla 33
        positions[12]=new Position(276,84);//casilla de terminar, 34
        positions[13]=new Position(209,84);
        positions[14]=new Position(209,110);
        positions[15]=new Position(209,138);
        positions[16]=new Position(209,163);
        positions[17]=new Position(209,141);
        positions[18]=new Position(209,218);
        positions[19]=new Position(209,242);
        positions[20]=new Position(209,268);//en realidad casilla 42
        positions[21]=new Position(186,296);
        positions[22]=new Position(161,296);
        positions[23]=new Position(135,296);
        positions[24]=new Position(109,296);
        positions[25]=new Position(84,296);
        positions[26]=new Position(58,296);
        positions[27]=new Position(31,296);
        positions[28]=new Position(5,296);//en realidad casilla 50
        positions[29]=new Position(5,296);//casilla de terminar, 51
        positions[30]=new Position(5,423);
        positions[31]=new Position(30,423);
        positions[32]=new Position(55,423);
        positions[33]=new Position(82,423);
        positions[34]=new Position(107,423);
        positions[35]=new Position(135,423);
        positions[36]=new Position(163,423);
        positions[37]=new Position(185,423);//en realidad casilla 59
        positions[38]=new Position(209,406);
        positions[39]=new Position(209,485);
        positions[40]=new Position(209,512);
        positions[41]=new Position(209,535);
        positions[42]=new Position(209,563);
        positions[43]=new Position(209,588);
        positions[44]=new Position(209,617);
        positions[45]=new Position(209,642);
        positions[46]=new Position(276,652);
        positions[47]=new Position(348,642);
        positions[48]=new Position(348,617);
        positions[49]=new Position(348,588);
        positions[50]=new Position(348,563);
        positions[51]=new Position(348,535);
        positions[52]=new Position(348,512);
        positions[53]=new Position(348,485);
        positions[54]=new Position(348,450);//que en realidad es la casilla 8, porque la posicion es 7 en el array, pero en realidad es 8 en el tablero
        positions[55]=new Position(376,423);
        positions[56]=new Position(402,423);
        positions[57]=new Position(451,423);
        positions[58]=new Position(454,423);
        positions[59]=new Position(481,423);
        positions[60]=new Position(507,423);
        positions[61]=new Position(533,423);
        positions[62]=new Position(561,423);//en realidad es la casilla 16
        positions[63]=new Position(557,362);//casilla de terminar, 17
    }
    //AQUI ESTABA EL METODO SETpos
    
    public void initPositionsGreen()//aqui se inicializa las coordenadas del camino de la ficha verde
    {
        //inicializar posiciones verdes
        positions[0]=new Position(107,423);//56
        positions[1]=new Position(135,423);
        positions[2]=new Position(163,423);
        positions[3]=new Position(185,423);//en realidad casilla 59
        positions[4]=new Position(209,406);
        positions[5]=new Position(209,485);
        positions[6]=new Position(209,512);
        positions[7]=new Position(209,535);
        positions[8]=new Position(209,563);
        positions[9]=new Position(209,588);
        positions[10]=new Position(209,617);
        positions[11]=new Position(209,642);
        positions[12]=new Position(276,652);
        positions[13]=new Position(348,642);
        positions[14]=new Position(348,617);
        positions[15]=new Position(348,588);
        positions[16]=new Position(348,563);
        positions[17]=new Position(348,535);
        positions[18]=new Position(348,512);
        positions[19]=new Position(348,485);
        positions[20]=new Position(348,450);//que en realidad es la casilla 8, porque la posicion es 7 en el array, pero en realidad es 8 en el tablero
        positions[21]=new Position(376,423);
        positions[22]=new Position(402,423);
        positions[23]=new Position(451,423);
        positions[24]=new Position(454,423);
        positions[25]=new Position(481,423);
        positions[26]=new Position(507,423);
        positions[27]=new Position(533,423);
        positions[28]=new Position(561,423);//en realidad es la casilla 16
        positions[29]=new Position(557,362);//casilla de terminar, 17
        positions[30]=new Position(557,296);
        positions[31]=new Position(534,296);
        positions[32]=new Position(504,296);
        positions[33]=new Position(481,296);
        positions[34]=new Position(455,296);
        positions[35]=new Position(429,296);
        positions[36]=new Position(405,296);
        positions[37]=new Position(379,296);//en realidad es la casilla 25
        positions[38]=new Position(348,267);
        positions[39]=new Position(348,248);
        positions[40]=new Position(348,224);
        positions[41]=new Position(348,196);
        positions[42]=new Position(348,166);
        positions[43]=new Position(348,134);
        positions[44]=new Position(348,113);
        positions[45]=new Position(348,84);//en realidad casilla 33
        positions[46]=new Position(276,84);//casilla de terminar, 34
        positions[47]=new Position(209,84);
        positions[48]=new Position(209,110);
        positions[49]=new Position(209,138);
        positions[50]=new Position(209,163);
        positions[51]=new Position(209,141);
        positions[52]=new Position(209,218);
        positions[53]=new Position(209,242);
        positions[54]=new Position(209,268);//en realidad casilla 42
        positions[55]=new Position(186,296);
        positions[56]=new Position(161,296);
        positions[57]=new Position(135,296);
        positions[58]=new Position(109,296);
        positions[59]=new Position(84,296);
        positions[60]=new Position(58,296);
        positions[61]=new Position(31,296);
        positions[62]=new Position(5,296);//en realidad casilla 50
        positions[63]=new Position(5,296);//casilla de terminar, 51
    }
    
    public void initPositionsYellow()//aqui se inicializa las coordenadas del camino de la ficha amarilla
    {
        //inicializar posicionesAmarillo
        positions[0]=new Position(348,535);
        positions[1]=new Position(348,512);
        positions[2]=new Position(348,485);
        positions[3]=new Position(348,450);//que en realidad es la casilla 8, porque la posicion es 7 en el array, pero en realidad es 8 en el tablero
        positions[4]=new Position(376,423);
        positions[5]=new Position(402,423);
        positions[6]=new Position(451,423);
        positions[7]=new Position(454,423);
        positions[8]=new Position(481,423);
        positions[9]=new Position(507,423);
        positions[10]=new Position(533,423);
        positions[11]=new Position(561,423);//en realidad es la casilla 16
        positions[12]=new Position(557,362);//casilla de terminar, 17
        positions[13]=new Position(557,296);
        positions[14]=new Position(534,296);
        positions[15]=new Position(504,296);
        positions[16]=new Position(481,296);
        positions[17]=new Position(455,296);
        positions[18]=new Position(429,296);
        positions[19]=new Position(405,296);
        positions[20]=new Position(379,296);//en realidad es la casilla 25
        positions[21]=new Position(348,267);
        positions[22]=new Position(348,248);
        positions[23]=new Position(348,224);
        positions[24]=new Position(348,196);
        positions[25]=new Position(348,166);
        positions[26]=new Position(348,134);
        positions[27]=new Position(348,113);
        positions[28]=new Position(348,84);//en realidad casilla 33
        positions[29]=new Position(276,84);//casilla de terminar, 34
        positions[30]=new Position(209,84);
        positions[31]=new Position(209,110);
        positions[32]=new Position(209,138);
        positions[33]=new Position(209,163);
        positions[34]=new Position(209,141);
        positions[35]=new Position(209,218);
        positions[36]=new Position(209,242);
        positions[37]=new Position(209,268);//en realidad casilla 42
        positions[38]=new Position(186,296);
        positions[39]=new Position(161,296);
        positions[40]=new Position(135,296);
        positions[41]=new Position(109,296);
        positions[42]=new Position(84,296);
        positions[43]=new Position(58,296);
        positions[44]=new Position(31,296);
        positions[45]=new Position(5,296);//en realidad casilla 50
        positions[46]=new Position(5,296);//casilla de terminar, 51
        positions[47]=new Position(5,423);
        positions[48]=new Position(30,423);
        positions[49]=new Position(55,423);
        positions[50]=new Position(82,423);
        positions[51]=new Position(107,423);
        positions[52]=new Position(135,423);
        positions[53]=new Position(163,423);
        positions[54]=new Position(185,423);//en realidad casilla 59
        positions[55]=new Position(209,406);
        positions[56]=new Position(209,485);
        positions[57]=new Position(209,512);
        positions[58]=new Position(209,535);
        positions[59]=new Position(209,563);
        positions[60]=new Position(209,588);
        positions[61]=new Position(209,617);
        positions[62]=new Position(209,642);
        positions[63]=new Position(276,652);
    }
    public void quadrants(String colorUno)//metodo que coloca las fichas en las casas según lo que se elija
    {//este es el metodo que coloca las fichas en sus casas
        switch(colorUno)
        {
            
            case "Rojo":
                
            //rojas
            colocarFichasRojas();
            //initPositionsRed();

            //amarillo
            colocarFichasAmarillas();
            //initPositionsYellow();
            break;
                
            case "Amarillo":
                //amarillo
                colocarFichasAmarillas();
                //initPositionsYellow();
                //rojas
                colocarFichasRojas();
                //initPositionsRed();
            break;
            case "Azul":
                //Blue 
                    colocarFichasAzules();
                    //initPositionsBlue();
                    //verdes
                    colocarFichasVerdes();
                    //initPositionsGreen();
                break;
                
            case "Verde":
                    //green
                    colocarFichasVerdes();
                    initPositionsGreen();
                    //Blue 
                    colocarFichasAzules();
                    //initPositionsBlue();
            break;
        }
    }
    
    int ultimoValor;
    public void setValorFicha(int valor)//este metodo lo que hace es obtener el ultimo valor del dado, que al final se le suma a las variables posiciones para que las fichas avancen
    {
        this.ultimoValor=valor;
    }
    
    public void fichas(String colorUno, double puntaje)//este es el metodo importante, es el controlador dentro de board=movimiento de fichas según color y preguntas(hasta el momento = 16/11/25)
    {//mover fichas segun color
        switch (colorUno) {
        case "Rojo":
            if (!fichaRojaSalio) {
                if (ultimoValor >= 5) {
                    sacarFicha("Rojo"); // Reutiliza tu método
                    System.out.println("Ficha roja salió al tablero");
                } else {
                    System.out.println("Necesitas un 5 o más para sacar la ficha roja");
                }
            } else {
                moverFichaRoja(ultimoValor);
                String respuesta = JOptionPane.showInputDialog(this.banco.getPregunta());
                boolean valida = this.banco.validarRespuesta(respuesta);
                if (valida) sumarPuntaje(puntaje);
                else restarPuntaje(puntaje);
            }
            break;

        case "Amarillo":
            if (!fichaAmarillaSalio) {
                if (ultimoValor >= 5) {
                    sacarFicha("Amarillo");
                    System.out.println("Ficha amarilla salió al tablero");
                } else {
                    System.out.println("Necesitas un 5 o más para sacar la ficha amarilla");
                }
            } else {
                moverFichaAmarilla(ultimoValor);
                String respuesta = JOptionPane.showInputDialog(this.banco.getPregunta());
                boolean valida = this.banco.validarRespuesta(respuesta);
                if (valida) sumarPuntaje(puntaje);
                else restarPuntaje(puntaje);
            }
            break;

        case "Azul":
            if (!fichaAzulSalio) {
                if (ultimoValor >= 5) {
                    sacarFicha("Azul");
                    System.out.println("Ficha azul salió al tablero");
                } else {
                    System.out.println("Necesitas un 5 o más para sacar la ficha azul");
                }
            } else {
                moverFichaAzul(ultimoValor);
                String respuesta = JOptionPane.showInputDialog(this.banco.getPregunta());
                boolean valida = this.banco.validarRespuesta(respuesta);
                if (valida) sumarPuntaje(puntaje);
                else restarPuntaje(puntaje);
            }
            break;

        case "Verde":
            if (!fichaVerdeSalio) {
                if (ultimoValor >= 5) {
                    sacarFicha("Verde");
                    System.out.println("Ficha verde salió al tablero");
                } else {
                    System.out.println("Necesitas un 5 o más para sacar la ficha verde");
                }
            } else {
                moverFichaVerde(ultimoValor);
                String respuesta = JOptionPane.showInputDialog(this.banco.getPregunta());
                boolean valida = this.banco.validarRespuesta(respuesta);
                if (valida) sumarPuntaje(puntaje);
                else restarPuntaje(puntaje);
            }
            break;
    }
    }
//        switch (colorUno) {
//            case "Rojo":
//                if (!fichaRojaSalio) {//si la ficha roja salio es false.
//                    if (ultimoValor >= 5) {
//                        // Saca la ficha por primera vez
////                        fichaRojaSalio = true;
//                        sacarFicha("Rojo");
//                        System.out.println("Ficha roja salió al tablero");
//                        else
//                        {
//                            System.out.println("Necesitas un 5");
//                        }
//                        posicionActualRoja = 0; // o la posición de salida
//                        squares[posicionActualRoja] = new Square(positions[posicionActualRoja]);
//                        squares[posicionActualRoja].setPiece(
//                            new Piece(positions[posicionActualRoja], new ImageIcon("./src/main/resources/imagenes/piecered.png"))
//                        );
//                        
//                    } else {
//                        System.out.println("Necesitas un 5 o más para sacar la ficha roja");
//                    }
//                } else {
//                    // La ficha ya salió, se mueve y se hace la pregunta
//                    moverFichaRoja(ultimoValor);
//                    String respuesta = JOptionPane.showInputDialog(this.banco.getPregunta());
//                    boolean valida = this.banco.validarRespuesta(respuesta);
//                    if (valida) sumarPuntaje(puntaje);
//                    else restarPuntaje(puntaje);
//                }
//                break;
//
//            case "Amarillo":
//                if (!fichaAmarillaSalio) {
//                    if (ultimoValor >= 5) {
//                        fichaAmarillaSalio = true;
//                        posicionActualAmarillo = 0;
//                        squares[posicionActualAmarillo] = new Square(positions[posicionActualAmarillo]);
//                        squares[posicionActualAmarillo].setPiece(
//                            new Piece(positions[posicionActualAmarillo], new ImageIcon("./src/main/resources/imagenes/pieceyellow.png"))
//                        );
//                        System.out.println("Ficha amarilla salió al tablero");
//                    } else {
//                        System.out.println("Necesitas un 5 o más para sacar la ficha amarilla");
//                    }
//                } else {
//                    moverFichaAmarilla(ultimoValor);
//                    String respuesta = JOptionPane.showInputDialog(this.banco.getPregunta());
//                    boolean valida = this.banco.validarRespuesta(respuesta);
//                    if (valida) sumarPuntaje(puntaje);
//                    else restarPuntaje(puntaje);
//                }
//                break;
//
//            case "Azul":
//                if (!fichaAzulSalio) {
//                    if (ultimoValor >= 5) {
//                        fichaAzulSalio = true;
//                        posicionActualAzul = 0;
//                        squares[posicionActualAzul] = new Square(positions[posicionActualAzul]);
//                        squares[posicionActualAzul].setPiece(
//                            new Piece(positions[posicionActualAzul], new ImageIcon("./src/main/resources/imagenes/pieceblue.png"))
//                        );
//                        System.out.println("Ficha azul salió al tablero");
//                    } else {
//                        System.out.println("Necesitas un 5 o más para sacar la ficha azul");
//                    }
//                } else {
//                    moverFichaAzul(ultimoValor);
//                    String respuesta = JOptionPane.showInputDialog(this.banco.getPregunta());
//                    boolean valida = this.banco.validarRespuesta(respuesta);
//                    if (valida) sumarPuntaje(puntaje);
//                    else restarPuntaje(puntaje);
//                }
//                break;
//
//            case "Verde":
//                if (!fichaVerdeSalio) {
//                    if (ultimoValor >= 5) {
//                        fichaVerdeSalio = true;
//                        posicionActualVerde = 0;
//                        squares[posicionActualVerde] = new Square(positions[posicionActualVerde]);
//                        squares[posicionActualVerde].setPiece(
//                            new Piece(positions[posicionActualVerde], new ImageIcon("./src/main/resources/imagenes/piecegreen.png"))
//                        );
//                        System.out.println("Ficha verde salió al tablero");
//                    } else {
//                        System.out.println("Necesitas un 5 o más para sacar la ficha verde");
//                    }
//                } else {
//                    moverFichaVerde(ultimoValor);
//                    String respuesta = JOptionPane.showInputDialog(this.banco.getPregunta());
//                    boolean valida = this.banco.validarRespuesta(respuesta);
//                    if (valida) sumarPuntaje(puntaje);
//                    else restarPuntaje(puntaje);
//                }
//                break;
//        }
//    }
//        switch(colorUno)
//        { 
//            private boolean ficha
//            case "Rojo"://en caso de que elija rojo
//            
//                //moverFichaRoja(ultimoValor);
//                moverFichaRoja(ultimoValor);//metodo que mueve la ficha y recibe el ultimo valor del dado.
//                String respuesta=JOptionPane.showInputDialog(this.banco.getPregunta());//se le muestra la pregunta a la persona y se guarda la respuesta en la variable respuesta. 
//                this.banco.validarRespuesta(respuesta);//se le manda la respuesta al metodo que valida la respuesta
//                if(banco.getRandomNumber()%2==0)
//                {
//                    if(this.banco.validarRespuesta(respuesta))
//                    {
//                        sumarPuntaje(puntaje);
//                    }//fin if 3
//                    else
//                    {
//                        restarPuntaje(puntaje);
//                    }//fin else
//                }//fin if 2
//                
//                    if(this.banco.validarRespuesta(respuesta)==false)
//                    {
//                        sumarPuntaje(puntaje);
//                    }
//                    else
//                    {
//                        restarPuntaje(puntaje);
//                    }
//            //fin if1
//            break;
//                
//            case "Amarillo":
//                //amarillo
//                moverFichaAmarilla(ultimoValor);//metodo que mueve la ficha y recibe el ultimo valor del dado.
//                String respuestaAmarilla=JOptionPane.showInputDialog(this.banco.getPregunta());
//                this.banco.validarRespuesta(respuestaAmarilla);
//                
//                //rojas
//                
//            break;
//            case "Azul":
//                //Blue 
//                moverFichaAzul(ultimoValor);//metodo que mueve la ficha y recibe el ultimo valor del dado.
//                String respuestaAzul=JOptionPane.showInputDialog(this.banco.getPregunta());
//                this.banco.validarRespuesta(respuestaAzul);
//                    //verdes
//                    
//                break;
//                
//            case "Verde":
//                    //green
//                moverFichaVerde(ultimoValor);//metodo que mueve la ficha y recibe el ultimo valor del dado.
//                String respuestaVerde=JOptionPane.showInputDialog(this.banco.getPregunta());
//                this.banco.validarRespuesta(respuestaVerde);
//                    //Blue 
//                    
//            break;
//        }
    public void sacarFicha(String color) {
    switch(color) {
        case "Rojo":
            fichaRojaSalio = true;
            posicionActualRoja = 0;
            squares[posicionActualRoja] = new Square(positions[posicionActualRoja]);
            squares[posicionActualRoja].setPiece(new Piece(positions[posicionActualRoja], new ImageIcon("./src/main/resources/imagenes/piecered.png")));
            break;
        case "Amarillo":
            fichaAmarillaSalio = true;
            posicionActualAmarillo = 0;
            squares[posicionActualAmarillo] = new Square(positions[posicionActualAmarillo]);
            squares[posicionActualAmarillo].setPiece(new Piece(positions[posicionActualAmarillo], new ImageIcon("./src/main/resources/imagenes/pieceyellow.png")));
            break;
        case "Azul":
            fichaAzulSalio = true;
            posicionActualAzul = 0;
            squares[posicionActualAzul] = new Square(positions[posicionActualAzul]);
            squares[posicionActualAzul].setPiece(new Piece(positions[posicionActualAzul], new ImageIcon("./src/main/resources/imagenes/pieceblue.png")));
            break;
        case "Verde":
            fichaVerdeSalio = true;
            posicionActualVerde = 0;
            squares[posicionActualVerde] = new Square(positions[posicionActualVerde]);
            squares[posicionActualVerde].setPiece(new Piece(positions[posicionActualVerde], new ImageIcon("./src/main/resources/imagenes/piecegreen.png")));
            break;
    }
}
    
    
    public void colocarFichasAmarillas()//metodo que pone las fichas en las casas iniciales.
    {
            homeYellow.setPiece(0, new Piece(new Position(518, 596), new ImageIcon("./src/main/resources/imagenes/pieceyellow.png")));//abajo derecha
            homeYellow.setPiece(1, new Piece(new Position(423, 596), new ImageIcon("./src/main/resources/imagenes/pieceyellow.png")));//abajo izq
            homeYellow.setPiece(2, new Piece(new Position(423, 522), new ImageIcon("./src/main/resources/imagenes/pieceyellow.png")));//arriba izq
            homeYellow.setPiece(3, new Piece(new Position(518, 522), new ImageIcon("./src/main/resources/imagenes/pieceyellow.png")));//arriba derecha
    }
    
    public void colocarFichasVerdes()//metodo que pone las fichas en las casas iniciales.
    {
            homeGreen.setPiece(0, new Piece(new Position(136, 521), new ImageIcon("./src/main/resources/imagenes/piecegreen.png")));//arriba izq DUPLICADO
            homeGreen.setPiece(1, new Piece(new Position(13, 592), new ImageIcon("./src/main/resources/imagenes/piecegreen.png")));//abajo izq DUPLICADO
            homeGreen.setPiece(2, new Piece(new Position(13, 521), new ImageIcon("./src/main/resources/imagenes/piecegreen.png")));//arriba derecha
            homeGreen.setPiece(3, new Piece(new Position(134, 597), new ImageIcon("./src/main/resources/imagenes/piecegreen.png")));//abajo derecha
    }
    
    public void colocarFichasRojas()//metodo que pone las fichas en las casas iniciales.
    {
            homeRed.setPiece(0, new Piece(new Position(122, 223), new ImageIcon("./src/main/resources/imagenes/piecered.png")));//abajo derecha
            homeRed.setPiece(1, new Piece(new Position(32, 223), new ImageIcon("./src/main/resources/imagenes/piecered.png")));//abajo izq DUPLICADO
            homeRed.setPiece(2, new Piece(new Position(32, 145), new ImageIcon("./src/main/resources/imagenes/piecered.png")));//arriba izq DUPLICADO
            homeRed.setPiece(3, new Piece(new Position(122, 145), new ImageIcon("./src/main/resources/imagenes/piecered.png")));//arriba derecha
    }
    
    public void colocarFichasAzules()//metodo que pone las fichas en las casas iniciales.
    {
            homeBlue.setPiece(0, new Piece(new Position(517, 220), new ImageIcon("./src/main/resources/imagenes/pieceblue.png")));//abajo derecha
            homeBlue.setPiece(1, new Piece(new Position(432, 220), new ImageIcon("./src/main/resources/imagenes/pieceblue.png")));//abajo izq
            homeBlue.setPiece(2, new Piece(new Position(432, 117), new ImageIcon("./src/main/resources/imagenes/pieceblue.png")));//arriba izq
            homeBlue.setPiece(3, new Piece(new Position(517, 117), new ImageIcon("./src/main/resources/imagenes/pieceblue.png")));//arriba derecha
    }
    
    public void moverFichaRoja(int valorDado)//metodo que mueve la ficha roja
    {
        posicionActualRoja=posicionActualRoja+valorDado;//sumar el avance
        
        if (posicionActualRoja>=positions.length)//para no pasarse del array
        {
//            posicionActualRoja= positions.length;
              posicionActualRoja= 63;
        }
        
        squares[posicionActualRoja]=new Square(positions[posicionActualRoja]);
        squares[posicionActualRoja].setPiece(new Piece(positions[posicionActualRoja], new ImageIcon("./src/main/resources/imagenes/piecered.png")));   
    }
    
    public void moverFichaAzul(int valorDado)//metodo que mueve la ficha azul
    {
        posicionActualAzul=posicionActualAzul+valorDado;//se le asigna el valor del dado a la posicion para que esta avance.
        
        if(posicionActualAzul>=positions.length)//para que no se pase del array
        {
            //posicionActualAzul=positions.length;
            posicionActualAzul=63;
        }
        
        squares[posicionActualAzul]=new Square(positions[posicionActualAzul]);
        squares[posicionActualAzul].setPiece(new Piece(positions[posicionActualAzul],new ImageIcon("./src/main/resources/imagenes/pieceblue.png")));//se dibuja la ficha
    }
    public void moverFichaAmarilla(int valorDado)
    {
        posicionActualAmarillo=posicionActualAmarillo+valorDado;//se le asigna el valor del dado a la posicion para que esta avance.
        
        if(posicionActualAmarillo>=positions.length)//para que no se pase del array
        {
            //posicionActualAmarillo=positions.length;
            posicionActualAmarillo=63;
        }
        
        squares[posicionActualAmarillo]=new Square(positions[posicionActualAmarillo]);
        squares[posicionActualAmarillo].setPiece(new Piece(positions[posicionActualAmarillo], new ImageIcon("./src/main/resources/imagenes/pieceyellow.png")));//se dibuja la ficha
    }
    public void moverFichaVerde(int valorDado)
    {
        posicionActualVerde=posicionActualVerde+valorDado;//se le asigna el valor del dado a la posicion para que esta avance.
        if(posicionActualVerde>positions.length)//para que no se pase del array
        {
//            posicionActualAzul=positions.length;
            posicionActualVerde=63;
        }
        squares[posicionActualVerde]=new Square(positions[posicionActualVerde]);
        squares[posicionActualVerde].setPiece(new Piece(positions[posicionActualVerde],new ImageIcon("./src/main/resources/imagenes/piecegreen.png")));//se dibuja la ficha
    }
    
    public void sumarPuntaje(double puntaje)
    {
        puntaje++;
    }
    
    public void restarPuntaje(double puntaje)
    {
        puntaje--;
    }
    


// GETTERS Y SETTERS DE LAS BANDERAS
    public boolean isFichaRojaEnCasa() {
        return fichaRojaEnCasa;
    }

    public void setFichaRojaEnCasa(boolean fichaRojaEnCasa) {
        this.fichaRojaEnCasa = fichaRojaEnCasa;
    }   

    public boolean isFichaAmarillaEnCasa() {
        return fichaAmarillaEnCasa;
    }

    public void setFichaAmarillaEnCasa(boolean fichaAmarillaEnCasa) {
        this.fichaAmarillaEnCasa = fichaAmarillaEnCasa;
    }   

    public boolean isFichaAzulEnCasa() {
        return fichaAzulEnCasa;
    }

    public void setFichaAzulEnCasa(boolean fichaAzulEnCasa) {
        this.fichaAzulEnCasa = fichaAzulEnCasa;
    }

    public boolean isFichaVerdeEnCasa() {
        return fichaVerdeEnCasa;
    }

    public void setFichaVerdeEnCasa(boolean fichaVerdeEnCasa) {
        this.fichaVerdeEnCasa = fichaVerdeEnCasa;
    }

    //(para cuando la ficha sale de casa)
    public void setPosicionActualRoja(int posicion) {
        this.posicionActualRoja = posicion;
    }

    public void setPosicionActualAmarillo(int posicion) {
        this.posicionActualAmarillo = posicion;
    }

    public void setPosicionActualAzul(int posicion) {
        this.posicionActualAzul = posicion;
    }

    public void setPosicionActualVerde(int posicion) {
        this.posicionActualVerde = posicion;
    }
    public boolean isFichaRojaSalio() { 
        return fichaRojaSalio; 
    }
    public boolean isFichaAmarillaSalio() { 
        return fichaAmarillaSalio; 
    }
    public boolean isFichaAzulSalio() { 
        return fichaAzulSalio; 
    }
    public boolean isFichaVerdeSalio() { 
        return fichaVerdeSalio; 
    }
}
