/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.proyectoparchis.model;

import java.awt.Component;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author jeanmarco
 */
public class Board {
    private Square[] squares;
    private Home homeYellow;
    private Home homeRed;
    private Home homeBlue;
    private Home homeGreen;
    private Position[] positions;//array de posiciones
    
    public Board(String colorUno)//color que selecciona el jugador
    {
        
        this.squares=new Square[69];
        this.positions=new Position[69];
        this.homeYellow=new Home("Amarillo");//se crea un objeto tipo Home que es la parte que administra la casa amarilla
        this.homeRed=new Home("Rojo");//se crea un objeto tipo Home que es la parte que administra la casa roja
        this.homeBlue=new Home("Azul");//se crea un objeto tipo Home que es la parte que administra la casa azul
        this.homeGreen=new Home("Verde");//se crea un objeto tipo Home que es la parte que administra la casa verde
        //setPositions();//crea casillas del tablero
        
        quadrants(colorUno);//crea las piezas dentro de las casas
        fichas(colorUno);
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
    public void initPositions()
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
    
    
    //AQUI ESTABA EL METODO SETpos
    public void quadrants(String colorUno)
    {//este es el metodo que da el error
        switch(colorUno)
        {
            
            case "Rojo":
                
            //rojas
            colocarFichasRojas();

            //amarillo
            colocarFichasAmarillas();
            
            break;
                
            case "Amarillo":
                //amarillo
                colocarFichasAmarillas();
                //rojas
                colocarFichasRojas();
            break;
            case "Azul":
                //Blue 
                    colocarFichasAzules();
                    //verdes
                    colocarFichasVerdes();
                break;
                
            case "Verde":
                    //green
                    colocarFichasVerdes();
                    //Blue 
                    colocarFichasAzules();
            break;
        }
    }
    
    int ultimoValor;
    public void setValorFicha(int valor)
    {
        this.ultimoValor=valor;
    }
    
    public void fichas(String colorUno)
    {
        switch(colorUno)
        {
            
            case "Rojo":
            if(ultimoValor>=5)
            {
                    int coordenateX=219;
                    int coordenateY=195;
                    positions[0]=new Position(coordenateX, coordenateY);
                    squares[0]=new Square(positions[0]);
                    squares[0].setPiece(new Piece(positions[0], new ImageIcon("./src/main/resources/imagenes/piecered.png")));
            }
                
                //rojas
                //coordenadas de salida
               
                
                
           
            
            //amarillo
//            positions[1]=new Position(coordenateX, coordenateY);
//            squares[1]=new Square(positions[1]);
//            squares[1].setPiece(new Piece(positions[0], new ImageIcon("./src/main/resources/imagenes/pieceyellow.png")));
            break;
                
            case "Amarillo":
                //amarillo
                
                //rojas
                
            break;
            case "Azul":
                //Blue 
                    
                    //verdes
                    
                break;
                
            case "Verde":
                    //green
                    
                    //Blue 
                    
            break;
        }
    }
    
    
    public void colocarFichasAmarillas()
    {
            homeYellow.setPiece(0, new Piece(new Position(518, 596), new ImageIcon("./src/main/resources/imagenes/pieceyellow.png")));//abajo derecha
            homeYellow.setPiece(1, new Piece(new Position(423, 596), new ImageIcon("./src/main/resources/imagenes/pieceyellow.png")));//abajo izq
            homeYellow.setPiece(2, new Piece(new Position(423, 522), new ImageIcon("./src/main/resources/imagenes/pieceyellow.png")));//arriba izq
            homeYellow.setPiece(3, new Piece(new Position(518, 522), new ImageIcon("./src/main/resources/imagenes/pieceyellow.png")));//arriba derecha
    }
    
    public void colocarFichasVerdes()
    {
            homeGreen.setPiece(0, new Piece(new Position(136, 521), new ImageIcon("./src/main/resources/imagenes/piecegreen.png")));//arriba izq DUPLICADO
            homeGreen.setPiece(1, new Piece(new Position(13, 592), new ImageIcon("./src/main/resources/imagenes/piecegreen.png")));//abajo izq DUPLICADO
            homeGreen.setPiece(2, new Piece(new Position(13, 521), new ImageIcon("./src/main/resources/imagenes/piecegreen.png")));//arriba derecha
            homeGreen.setPiece(3, new Piece(new Position(134, 597), new ImageIcon("./src/main/resources/imagenes/piecegreen.png")));//abajo derecha
    }
    
    public void colocarFichasRojas()
    {
            homeRed.setPiece(0, new Piece(new Position(122, 223), new ImageIcon("./src/main/resources/imagenes/piecered.png")));//abajo derecha
            homeRed.setPiece(1, new Piece(new Position(32, 223), new ImageIcon("./src/main/resources/imagenes/piecered.png")));//abajo izq DUPLICADO
            homeRed.setPiece(2, new Piece(new Position(32, 145), new ImageIcon("./src/main/resources/imagenes/piecered.png")));//arriba izq DUPLICADO
            homeRed.setPiece(3, new Piece(new Position(122, 145), new ImageIcon("./src/main/resources/imagenes/piecered.png")));//arriba derecha
    }
    
    public void colocarFichasAzules()
    {
            homeBlue.setPiece(0, new Piece(new Position(517, 220), new ImageIcon("./src/main/resources/imagenes/pieceblue.png")));//abajo derecha
            homeBlue.setPiece(1, new Piece(new Position(432, 220), new ImageIcon("./src/main/resources/imagenes/pieceblue.png")));//abajo izq
            homeBlue.setPiece(2, new Piece(new Position(432, 117), new ImageIcon("./src/main/resources/imagenes/pieceblue.png")));//arriba izq
            homeBlue.setPiece(3, new Piece(new Position(517, 117), new ImageIcon("./src/main/resources/imagenes/pieceblue.png")));//arriba derecha
    }
    
            
//    public void start()
//    {
//        quadrants();
//    }
}
