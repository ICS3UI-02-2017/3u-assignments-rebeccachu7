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
    String title = "My Game";

    // sets the framerate and delay for our game
    // this calculates the number of milliseconds per frame
    // you just need to select an approproate framerate
    int desiredFPS = 60;
    int desiredTime = Math.round((1000 / desiredFPS));
    
    // timer used to run the game loop
    // this is what keeps our time running smoothly :)
    Timer gameTimer;

    // YOUR GAME VARIABLES WOULD GO HERE
    
    // the amount of red, blue, and green in a colour created -> brown (Omar's skin tone)
    Color omar = new Color(175, 105, 40);
    
    Color eye = new Color(61, 31, 3);
    
    Color lips = new Color (209, 110, 130);
    
    int pacmanX = 100;
    int pacmanY = 400;
    
    int pacmanAngle = 45;
    int pacmanRotate = 270;
    boolean pacmanClose = true;
    
    int mouseX = 0;
    int mouseY = 0;
    
    boolean moveUp = false;
    boolean moveDown = false;

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
        
        // create the ears of the face
        g.setColor(omar);
        g.fillOval(65, 400, 100, 200);
        g.fillOval(440, 400, 100, 200);
        // outline the ears
        g.setColor(Color.BLACK);
        //x, y, width, length, starting degrees, added degrees to starting degrees
        g.drawArc(65, 400, 100, 200, 90, 180);
        g.drawArc(440, 400, 100, 200, 270, 180);
        
        // create the lines of where the ears end
        // set the colour as black
        g.setColor(Color.BLACK);
        //x, y, width, length, starting degrees, added degrees to starting degrees
        g.drawArc(85, 450, 50, 100, 90, 180);
        g.drawArc(465, 450, 50, 100, 270, 180);
        
        // set the colours of the eyes as black
        g.setColor(eye);
        // make the eyes of the face
        g.fillOval(200, 320, 50, 50);
        g.fillOval(340, 320, 50, 50);
        // set the shine in the eyes as white
        g.setColor(Color.WHITE);
        // create the circles
        g.fillOval(210, 330, 15, 15);
        g.fillOval(350, 330, 15, 15);
        
        // set the colour of the eyebrows as red
        g.setColor(Color.RED);
        // draw a filled in rectangle
        // x, y, width, height
        g.fillRect(160, 150, 100, 50);
        g.fillRect(330, 150, 100, 50);
        
        // outline the eyebrows
        // set the colour as black
        g.setColor(Color.BLACK);
        g.drawRect(160, 150, 100, 50);
        g.drawRect(330, 150, 100, 50);
        
        //make the nose of the face
        //x, y, width, length, starting degrees, added degrees to starting degrees
        g.drawArc(210, 465, 75, 75, 90, 180);
        g.drawArc(310, 465, 75, 75, 270, 180);
        // make the centre bottom of the nose
        g.drawArc(235, 440, 125, 125, 180, 180);
        
        // draw the mouth
        g.fillArc(145, 450, 300, 350, 180, 180);
        
        // draw the lips
        g.setColor(lips);
        g.fillArc(144, 610, 154, 35, 0, 180);
        g.fillArc(295, 610, 150, 35, 0, 180);
        // outline his lips
        g.setColor(Color.BLACK);
        g.drawArc(144, 610, 154, 35, 0, 180);
        g.drawArc(295, 610, 150, 35, 0, 180);
        
        
        // create the mustache of the face
        g.fillOval(260, 572, 40, 40);
        g.fillOval(290, 572, 40, 40);
        // create triangles for the end of the mustache
        int[] triangleA = {270, 270, 200};
        int[] triangleB = {579, 611, 590};
        // array of X points, array of Y points, number of points
        g.fillPolygon(triangleA, triangleB, 3);
        
        int[] triangleC = {310, 310, mouseX};
        int[] triangleD = {575, 611, mouseY};
        // array of X points, array of Y points, number of points
        g.fillPolygon(triangleC, triangleD, 3);
        
        
        // create the beard
        int[] triangleX = {325, 325, 312};
        int[] triangleY = {725, 725, 775};
        // array of X points, array of Y points, number of points
        g.fillPolygon(triangleX, triangleY, 3);
        
        g.setColor(Color.yellow);
        g.fillArc (pacmanX, pacmanY, 100, 100, pacmanAngle, pacmanRotate);
        
		
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
        // move pacman across the screen
        pacmanX = pacmanX + 7;
        
        // when pacman leaves the screen
        if (pacmanX > WIDTH){
            pacmanX = -100;
        }
        // set as false when pacman's mouth is closed
        if (pacmanAngle <= 0){
            pacmanClose = false;
        }
        // 
        if (pacmanAngle >= 45){
            pacmanClose = true;
        }
        
        // make pacman eat
        if (pacmanClose){
        pacmanRotate += 2;
        pacmanAngle -= 1;
        }
        else {
            pacmanRotate -= 2;
            pacmanAngle += 1;
        }
        // move the player
        if (moveUp){
            pacmanY = pacmanY - 3;
        }
        else if (moveDown){
            pacmanY = pacmanY + 3;
        }
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
            // if you left click:
            if (e.getButton() == MouseEvent.BUTTON1){
            // set the mouse coordinates
            mouseX = e.getX();
            mouseY = e.getY();
            }
        }
    }

    // Used to implements any of the Keyboard Actions
    private class Keyboard extends KeyAdapter {

        // if a key has been pressed down
        @Override
        public void keyPressed(KeyEvent e) {
            // get the key code
            int keyCode = e.getKeyCode();
            // which key is being pressed?
            if (keyCode == KeyEvent.VK_UP){
                moveUp = true;
            }
            else if (keyCode == KeyEvent.VK_DOWN);
                moveDown = true;
        }

        // if a key has been released
        @Override
        public void keyReleased(KeyEvent e) {
            // paste from keyPressed and change booleans of true to false
            
            // get the key code
            int keyCode = e.getKeyCode();
            // which key is being pressed?
            if (keyCode == KeyEvent.VK_UP){
                moveUp = false;
            }
            else if (keyCode == KeyEvent.VK_DOWN);
                moveDown = false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        preSetup();
        gameLoop();
        repaint();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creates an instance of my game
        face game = new face();
    }
}

