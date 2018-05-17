package Assignment8;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import static java.awt.image.ImageObserver.ERROR;
import javax.swing.Timer;

/**
 *
 * @author chur7632
 */
public class face extends JComponent implements ActionListener {

    // Height and Width of our game
    static final int WIDTH = 650;
    static final int HEIGHT = 1000;

    //Title of the window
    String title = "Omar I";

    // sets the framerate and delay for our game
    // this calculates the number of milliseconds per frame
    // you just need to select an approproate framerate
    int desiredFPS = 7;
    int desiredTime = Math.round((1000 / desiredFPS));
    
    // timer used to run the game loop
    // this is what keeps our time running smoothly :)
    Timer gameTimer;

    // YOUR GAME VARIABLES WOULD GO HERE
    
    // create the colour of Omar's skin
    Color omar = new Color(175, 105, 40);
    // create the colour of his eyes
    Color eye = new Color(61, 31, 3);
    // create the colour of his lips
    Color lips = new Color (209, 110, 130);
    // create the yellow colour of the crown
    Color crown = new Color (247, 207, 29);
    
    
    // move whites of the eyes from side to side
    int whiteRight = 210;
    int whiteLeft = 350;
    
    // move the eyebrows up and down
    int eyebrowMove = 150;
    // move the mustache up and down
    int mustache = 590;
    // move the tongue up and down
    int tongue = 700;

    // GAME VARIABLES END HERE    

    
    // Constructor to create the Frame and place the panel in
    // You will learn more about this in Grade 12 :)
    public face(){
        // creates a windows to show my game
        JFrame frame = new JFrame(title);

        // sets the size of my game
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        // adds the game to the window
        frame.add(this);

        // sets some options and size of the window automatically
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        // shows the window to the user
        frame.setVisible(true);

        // add listeners for keyboard and mouse
        frame.addKeyListener(new Keyboard());
        Mouse m = new Mouse();
        this.addMouseMotionListener(m);
        this.addMouseWheelListener(m);
        this.addMouseListener(m);
        
        gameTimer = new Timer(desiredTime,this);
        gameTimer.setRepeats(true);
        gameTimer.start();
    }

    // drawing of the game happens in here
    // we use the Graphics object, g, to perform the drawing
    // NOTE: This is already double buffered!(helps with framerate/speed)
    @Override
    public void paintComponent(Graphics g) {
        // always clear the screen first!
        g.clearRect(0, 0, WIDTH, HEIGHT);

        // GAME DRAWING GOES HERE
        
        // use the custom colour variable
        g.setColor(Color.PINK);
        // create a "background"
        // x, y, width, height
        g.fillRect(0, 0, WIDTH, HEIGHT);
        
        // set the colour of the new oval as the colour of Omar
        g.setColor(omar);
        // draw anything that is an oval (circle included)
        // x, y, width, height
        g.fillOval(100, 75, 400, 800);
        // outline the oval
        g.setColor(Color.BLACK);
        g.drawOval(100, 75, 400, 800);
        
        // make a crown on the top of the head
        g.setColor(crown);
        
        // create triangles for the crown
        int[] crownA = {245, 265, 285};
        int[] crownB = {75, 25, 75};
        // array of X points, array of Y points, number of points
        g.fillPolygon(crownA, crownB, 3);
        
        int[] crownC = {280, 300, 320};
        int[] crownD = {75, 10, 75};
        g.fillPolygon(crownC, crownD, 3);
        
        int[] crownE = {315, 335, 355};
        int[] crownF = {75, 25, 75};
        g.fillPolygon(crownE, crownF, 3);
        
        // create the gems on the crown
        // Set colour as magenta
        g.setColor(Color.MAGENTA);
        int[] shimmerA = {258, 263, 268, 263};
        int[] shimmerB = {60, 50, 60, 70};
        g.fillPolygon(shimmerA, shimmerB, 4);
        
        int[] shimmerC = {295, 300, 305, 300};
        int[] shimmerD = {60, 50, 60, 70};
        g.fillPolygon(shimmerC, shimmerD, 4);
        
        int[] shimmerE = {330, 335, 340, 335};
        int[] shimmerF = {60, 50, 60, 70};
        g.fillPolygon(shimmerE, shimmerF, 4);
        
        // create the ears of the face
        // set colour back to Omar's skin tone
        g.setColor(omar);
        g.fillOval(65, 400, 100, 200);
        g.fillOval(440, 400, 100, 200);
        // outline the ears
        g.setColor(Color.BLACK);
        //x, y, width, length, starting degrees, added degrees to starting degrees
        g.drawArc(65, 400, 100, 200, 90, 180);
        g.drawArc(440, 400, 100, 200, 270, 180);
        // create the lines of where the ears end
        g.drawArc(85, 450, 50, 100, 90, 180);
        g.drawArc(465, 450, 50, 100, 270, 180);
        
        // set the colours of the eyes
        g.setColor(eye);
        // make the eyes of the face
        g.fillOval(200, 320, 50, 50);
        g.fillOval(340, 320, 50, 50);
        // set the shine in the eyes as white
        g.setColor(Color.WHITE);
        // create the circles
        g.fillOval(whiteRight, 330, 15, 15);
        g.fillOval(whiteLeft, 330, 15, 15);
        
        // set the colour of the eyebrows as red
        g.setColor(Color.RED);
        // draw a filled in rectangle
        // x, y, width, height
        g.fillRect(160, eyebrowMove, 100, 50);
        g.fillRect(330, eyebrowMove, 100, 50);
        // outline the eyebrows
        // set the colour as black
        g.setColor(Color.BLACK);
        g.drawRect(160, eyebrowMove, 100, 50);
        g.drawRect(330, eyebrowMove, 100, 50);
        
        //make the nose of the face
        //x, y, width, length, starting degrees, added degrees to starting degrees
        g.drawArc(210, 465, 75, 75, 90, 180);
        g.drawArc(310, 465, 75, 75, 270, 180);
        // make the centre bottom of the nose
        g.drawArc(235, 440, 125, 125, 180, 180);
        
        // draw the mouth
        g.fillArc(145, 450, 300, 350, 180, 180);
        // draw the upper lips
        g.setColor(lips);
        g.fillArc(144, 610, 154, 35, 0, 180);
        g.fillArc(295, 610, 150, 35, 0, 180);
        // outline his lips
        g.setColor(Color.BLACK);
        g.drawArc(144, 610, 154, 35, 0, 180);
        g.drawArc(295, 610, 150, 35, 0, 180);
        
        // draw the tongue
        // set the colour as red
        g.setColor(Color.RED);
        g.fillOval(200, tongue, 190, 100);
        g.setColor(Color.BLACK);
        g.drawOval(200, tongue, 190, 100);
        
        
        // create the mustache of the face
        g.setColor(Color.BLACK);
        g.fillOval(260, 572, 40, 40);
        g.fillOval(290, 572, 40, 40);
        // create triangles for the end of the mustache
        int[] triangleA = {270, 270, 200};
        int[] triangleB = {575, 610, mustache};
        // array of X points, array of Y points, number of points
        g.fillPolygon(triangleA, triangleB, 3);
        
        int[] triangleC = {310, 310, 390};
        int[] triangleD = {572, 612, mustache};
        // array of X points, array of Y points, number of points
        g.fillPolygon(triangleC, triangleD, 3);
		
        // GAME DRAWING ENDS HERE
    }

    // This method is used to do any pre-setup you might need to do
    // This is run before the game loop begins!
    public void preSetup() {
        // Any of your pre setup before the loop starts should go here

    }

    // The main game loop
    // In here is where all the logic for my game will go
    public void gameLoop() {
        // make the whites of the eyes move from side to side
    if (whiteRight == 210){
        whiteRight += 20;
    }
    else if (whiteRight == 230){
        whiteRight -= 30;
    }
    else if (whiteRight == 200){
        whiteRight += 10;
    }
    if (whiteLeft == 350){
        whiteLeft += 20;
    }
    else if (whiteLeft == 370){
        whiteLeft -= 30;
    }
    else if (whiteLeft == 340){
        whiteLeft += 10;
    }
    // make the eyebrows move up and down
    if (eyebrowMove == 150){
        eyebrowMove -= 100;
    }
    else if (eyebrowMove == 50){
        eyebrowMove += 100;
    }
    // make the mustache move up and down
    if (mustache == 590){
        mustache +=20;
    }
    else if (mustache == 610){
        mustache -=40;
    }
    else if (mustache == 570){
        mustache +=20;
    }
    // make the tongue move up and down
    if (tongue == 700){
        tongue += 15;
    }
    else if (tongue == 715){
        tongue -= 15;
    }
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        preSetup();
        gameLoop();
        repaint();
    }

    // Used to implement any of the Mouse Actions
    private class Mouse extends MouseAdapter {

        // if a mouse button has been pressed down
        @Override
        public void mousePressed(MouseEvent e) {

        }

        // if a mouse button has been released
        @Override
        public void mouseReleased(MouseEvent e) {

        }

        // if the scroll wheel has been moved
        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {

        }

        // if the mouse has moved positions
        @Override
        public void mouseMoved(MouseEvent e) {

            }
        }

    // Used to implements any of the Keyboard Actions
    private class Keyboard extends KeyAdapter {

        // if a key has been pressed down
        @Override
        public void keyPressed(KeyEvent e) {

        }

        // if a key has been released
        @Override
        public void keyReleased(KeyEvent e) {
 
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creates an instance of my game
        face game = new face();
    }
}

