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
    
    
    public Board(String colorUno, String colorDos)//colores que selecciona el jugador
    {
        this.squares=new Square[69];
        this.positions=new Position[69];
//        if(colorUno.equalsIgnoreCase("Rojo"))//en caso de que se elija rojo, se le asigna al cPU el color amarillo
//        {
//            this.homeRed=new Home(colorUno);//rojo
//            this.homeYellow=new Home(colorDos);//amarillo
//        }//if 1
//        else
//        {
//            if(colorUno.equalsIgnoreCase("Amarillo"))//en caso de que se elija amarillo, se le asigna al cPU el color rojo
//            {
//                this.homeYellow=new Home(colorUno);//amarillo
//                this.homeRed=new Home(colorDos);//rojo
//            }//if 2
//            else
//            {
//                if(colorUno.equalsIgnoreCase("Azul"))//en caso de que se elija el color azul, se le asigna al cPU el color verde
//                {
//                    this.homeBlue=new Home(colorUno);//azul
//                    this.homeGreen=new Home(colorDos);//verde
//                }//if 3
//                else
//                {//en caso de que se elija el color verde, se le asigna al color azul al cPU
//                    this.homeGreen=new Home(colorUno);//color verde
//                    this.homeBlue=new Home(colorDos);//color azul
//                }
//            }//else 2
//        }//else 1
        
        this.homeYellow=new Home("Amarillo");//se crea un objeto tipo Home que es la parte que administra la casa amarilla
        this.homeRed=new Home("Rojo");//se crea un objeto tipo Home que es la parte que administra la casa roja
        this.homeBlue=new Home("Azul");//se crea un objeto tipo Home que es la parte que administra la casa azul
        this.homeGreen=new Home("verde");//se crea un objeto tipo Home que es la parte que administra la casa verde
        setPositions();//crea casillas del tablero
        quadrants(colorUno, colorDos);//crea las piezas dentro de las casas
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
    
    public void setPositions()
    {
               //coordenadas iniciales
        int coordenateX = 360;
        int coordenateY = 590;
        //de la posición 0 a 7
        for (int element = 0; element < 8; element++) {
            System.out.println(element);
            System.out.println(coordenateY);
            positions[element] = new Position(coordenateX, coordenateY);
            squares[element] = new Square(positions[element]);
            squares[element].setPiece(new Piece(positions[element], new ImageIcon("./src/main/resources/imagenes/pieceyellow.png")));//primera linea de arriba para abajo, este es el metodo que dibuja.
            coordenateY -= 30;
        }//Empieza desde la parte inferior del tablero (y=590) y sube hacia arriba, bajando y en pasos de 30 píxeles. Todas las piezas son amarillas ^
        
        //coordenadas establecidas
        coordenateX = 380;
        coordenateY = 360;
        //posición 8 a 15
        for (int element = 8; element < 16; element++) {
            positions[element] = new Position(coordenateX, coordenateY);// en la posición element, se crea el objeto new position(donde por parametros se le asigna las coordenadas X y Y)
            squares[element] = new Square(positions[element]);// en la misma posición de arriba(element), se le asigna un objeto square, donde por parametros de esa clase recibe una posición que sería la de element.
            squares[element].setPiece(new Piece(positions[element], new ImageIcon("./src/main/resources/imagenes/pieceyellow.png")));//esta creando la pieza amarilla en esa posición. Metodo que dibuja la segunda linea horizontal.-->
            coordenateX += 30;
        }
        
        //coordenadas establecidas
        coordenateX = 590;
        coordenateY = 300;
        //inicio posición especial
        positions[16] = new Position(coordenateX, coordenateY);
        squares[16] = new SpecialSquare("Avanza Azul", positions[16]);
        squares[16].setPiece(new Piece(positions[16], new ImageIcon("./src/main/resources/imagenes/piecered.png")));//metodo de dibuja hasta donde debe llegar el azul. Alli llega el azul para caminar hacia el centro
        //fin posición especial
        coordenateX = 590;
        coordenateY = 225;
        //posición 17 a 24
        for (int element = 17; element < 25; element++) {
            positions[element] = new Position(coordenateX, coordenateY);
            squares[element] = new Square(positions[element]);
            squares[element].setPiece(new Piece(positions[element], new ImageIcon("./src/main/resources/imagenes/pieceyellow.png")));//son la segunda linea horizontal<--
            coordenateX -= 30;
            System.out.println(coordenateX);
        }
        
        //coordenadas establecidas
        coordenateX = 360;
        coordenateY = 215;
        //TIENE DUPLICADO
        //posición 25 a 32
//        for (int element = 25; element < 33; element++) {
//            positions[element] = new Position(coordenateX, coordenateY);
//            squares[element] = new Square(positions[element]);
//            squares[element].setPiece(new Piece(positions[element], new ImageIcon("./src/main/resources/imagenes/pieceyellow.png")));//segunda linea vertical^
//            coordenateY -= 30;
//            System.out.println(coordenateY);
//        }
        //Coordenadas establecidas
        coordenateX = 290;
        coordenateY = 5;
        //Casilla especial
        positions[33] = new Position(coordenateX, coordenateY);
        squares[33] = new SpecialSquare("Avanza Rojo", positions[33]);
        squares[33].setPiece(new Piece(positions[33], new ImageIcon("./src/main/resources/imagenes/pieceblack.png")));//hasta donde debe llegar el color rojo
        //fin casilla especial
        
        //Coordenadas establecidas
        //TIENE DUPLICADO
        coordenateX = 225;
        coordenateY = 5;
        //posición del 34 a 41
//        for (int element = 34; element < 42; element++) {
//            positions[element] = new Position(coordenateX, coordenateY);
//            squares[element] = new Square(positions[element]);
//            squares[element].setPiece(new Piece(positions[element], new ImageIcon("./src/main/resources/imagenes/pieceyellow.png")));//tercera linea vertical(va para abajo)
//            coordenateY += 30;
//            System.out.println(coordenateY);
//        }
        //TIENE DUPLICADO
        //coordenadas establecidas
//        coordenateX = 215;
//        coordenateY = 225;
//        //posición 42 a 49
//        for (int element = 42; element < 50; element++) {
//            positions[element] = new Position(coordenateX, coordenateY);
//            squares[element] = new Square(positions[element]);
//            squares[element].setPiece(new Piece(positions[element], new ImageIcon("./src/main/resources/imagenes/pieceyellow.png")));//tercera linea horizontal<--
//            coordenateX -= 30;
//            System.out.println(coordenateX);
//        }
//        
        //coordenadas establecidas
        coordenateX = 5;
        coordenateY = 300;
        ////Casilla especial, "position 50 Solo tiene la coordenada"
        positions[50] = new Position(coordenateX, coordenateY);
        squares[50] = new SpecialSquare("Avanza Verde", positions[50]);
        squares[50].setPiece(new Piece(positions[50], new ImageIcon("./src/main/resources/imagenes/pieceblue.png"))); //hasta donde debe llegar el color verde
        
        //coordenadas establecidas
        //TIENE DUPLICADO
//        coordenateX = 5;
//        coordenateY = 360;
//        //posicion 51 a 58
//        for (int element = 51; element < 59; element++) {
//            positions[element] = new Position(coordenateX, coordenateY);
//            squares[element] = new Square(positions[element]);
//            squares[element].setPiece(new Piece(positions[element], new ImageIcon("./src/main/resources/imagenes/pieceyellow.png")));//cuarta linea horizontal--->
//            coordenateX += 30;
//            System.out.println(coordenateX);
//        }
        
        //coordenadas establecidas
        coordenateX = 230;
        coordenateY = 380;
        //posicion 59 a 67
        for (int element = 59; element < 67; element++) {
            positions[element] = new Position(coordenateX, coordenateY);
            squares[element] = new Square(positions[element]);
            squares[element].setPiece(new Piece(positions[element], new ImageIcon("./src/main/resources/imagenes/pieceyellow.png")));//cuarta y ultima linea vertical.
            coordenateY += 30;
            System.out.println(coordenateY);
        }

        //posición 68 (final)
        coordenateX = 290;
        coordenateY = 590;
        positions[67] = new Position(coordenateX, coordenateY);
        squares[67] = new SpecialSquare("Avanza Amarillo", positions[67]);
        squares[67].setPiece(new Piece(positions[67], new ImageIcon("./src/main/resources/imagenes/pieceblack.png")));//posicion final 
        
    }
    
    public void quadrants(String colorUno, String colorDos)
    {//este es el metodo que da el error
        if(colorUno.equalsIgnoreCase("Rojo"))
        {
            //rojo
            homeRed.setPiece(0, new Piece(new Position(122, 223), new ImageIcon("./src/main/resources/imagenes/piecered.png")));//abajo derecha
            homeRed.setPiece(1, new Piece(new Position(32, 223), new ImageIcon("./src/main/resources/imagenes/piecered.png")));//abajo izq DUPLICADO
            homeRed.setPiece(2, new Piece(new Position(32, 145), new ImageIcon("./src/main/resources/imagenes/piecered.png")));//arriba izq DUPLICADO
            homeRed.setPiece(3, new Piece(new Position(122, 145), new ImageIcon("./src/main/resources/imagenes/piecered.png")));//arriba derecha
            //amarillo
            homeYellow.setPiece(0, new Piece(new Position(518, 596), new ImageIcon("./src/main/resources/imagenes/pieceyellow.png")));//abajo derecha
            homeYellow.setPiece(1, new Piece(new Position(423, 596), new ImageIcon("./src/main/resources/imagenes/pieceyellow.png")));//abajo izq
            homeYellow.setPiece(2, new Piece(new Position(423, 522), new ImageIcon("./src/main/resources/imagenes/pieceyellow.png")));//arriba izq
            homeYellow.setPiece(3, new Piece(new Position(518, 522), new ImageIcon("./src/main/resources/imagenes/pieceyellow.png")));//arriba derecha
        }
        else
        {
            if(colorUno.equalsIgnoreCase("Amarillo"))
            {
               //rojo
                homeRed.setPiece(0, new Piece(new Position(122, 223), new ImageIcon("./src/main/resources/imagenes/piecered.png")));//abajo derecha
                homeRed.setPiece(1, new Piece(new Position(32, 223), new ImageIcon("./src/main/resources/imagenes/piecered.png")));//abajo izq DUPLICADO
                homeRed.setPiece(2, new Piece(new Position(32, 145), new ImageIcon("./src/main/resources/imagenes/piecered.png")));//arriba izq DUPLICADO
                homeRed.setPiece(3, new Piece(new Position(122, 145), new ImageIcon("./src/main/resources/imagenes/piecered.png")));//arriba derecha
                //amarillo
                homeYellow.setPiece(0, new Piece(new Position(518, 596), new ImageIcon("./src/main/resources/imagenes/pieceyellow.png")));//abajo derecha
                homeYellow.setPiece(1, new Piece(new Position(423, 596), new ImageIcon("./src/main/resources/imagenes/pieceyellow.png")));//abajo izq
                homeYellow.setPiece(2, new Piece(new Position(423, 522), new ImageIcon("./src/main/resources/imagenes/pieceyellow.png")));//arriba izq
                homeYellow.setPiece(3, new Piece(new Position(518, 522), new ImageIcon("./src/main/resources/imagenes/pieceyellow.png")));//arriba derecha

            }
            else
            {
                if(colorUno.equalsIgnoreCase("Azul"))
                {
                    //green
                    homeGreen.setPiece(0, new Piece(new Position(136, 521), new ImageIcon("./src/main/resources/imagenes/piecegreen.png")));//arriba izq DUPLICADO
                    homeGreen.setPiece(1, new Piece(new Position(13, 592), new ImageIcon("./src/main/resources/imagenes/piecegreen.png")));//abajo izq DUPLICADO
                    homeGreen.setPiece(2, new Piece(new Position(13, 521), new ImageIcon("./src/main/resources/imagenes/piecegreen.png")));//arriba derecha
                    homeGreen.setPiece(3, new Piece(new Position(134, 597), new ImageIcon("./src/main/resources/imagenes/piecegreen.png")));//abajo derecha
                    //Blue 
                    homeBlue.setPiece(0, new Piece(new Position(517, 220), new ImageIcon("./src/main/resources/imagenes/pieceblue.png")));//abajo derecha
                    homeBlue.setPiece(1, new Piece(new Position(432, 220), new ImageIcon("./src/main/resources/imagenes/pieceblue.png")));//abajo izq
                    homeBlue.setPiece(2, new Piece(new Position(432, 117), new ImageIcon("./src/main/resources/imagenes/pieceblue.png")));//arriba izq
                    homeBlue.setPiece(3, new Piece(new Position(517, 117), new ImageIcon("./src/main/resources/imagenes/pieceblue.png")));//arriba derecha
                }
                else
                {
                    //green
                    homeGreen.setPiece(0, new Piece(new Position(136, 521), new ImageIcon("./src/main/resources/imagenes/piecegreen.png")));//arriba izq DUPLICADO
                    homeGreen.setPiece(1, new Piece(new Position(13, 592), new ImageIcon("./src/main/resources/imagenes/piecegreen.png")));//abajo izq DUPLICADO
                    homeGreen.setPiece(2, new Piece(new Position(13, 521), new ImageIcon("./src/main/resources/imagenes/piecegreen.png")));//arriba derecha
                    homeGreen.setPiece(3, new Piece(new Position(134, 597), new ImageIcon("./src/main/resources/imagenes/piecegreen.png")));//abajo derecha
                    //Blue 
                    homeBlue.setPiece(0, new Piece(new Position(517, 220), new ImageIcon("./src/main/resources/imagenes/pieceblue.png")));//abajo derecha
                    homeBlue.setPiece(1, new Piece(new Position(432, 220), new ImageIcon("./src/main/resources/imagenes/pieceblue.png")));//abajo izq
                    homeBlue.setPiece(2, new Piece(new Position(432, 117), new ImageIcon("./src/main/resources/imagenes/pieceblue.png")));//arriba izq
                    homeBlue.setPiece(3, new Piece(new Position(517, 117), new ImageIcon("./src/main/resources/imagenes/pieceblue.png")));//arriba derecha
                }
            }
        }

        

    }
    
//    public void start()
//    {
//        quadrants();
//    }
}
