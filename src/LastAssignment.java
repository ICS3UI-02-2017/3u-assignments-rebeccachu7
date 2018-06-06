
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import javax.swing.Timer;

/**
 *
 * @author chur7632
 */
public class LastAssignment extends JComponent implements ActionListener {

    // Height and Width of our game
    static final int WIDTH = 800;
    static final int HEIGHT = 600;

    //Title of the window
    String title = "Shooting Thingy";

    // sets the framerate and delay for our game
    // this calculates the number of milliseconds per frame
    // you just need to select an approproate framerate
    int desiredFPS = 60;
    int desiredTime = Math.round((1000 / desiredFPS));
    
    // timer used to run the game loop
    // this is what keeps our time running smoothly :)
    Timer gameTimer;

    // YOUR GAME VARIABLES WOULD GO HERE
    
    // set variable for mouse click
    int mouseX = 0;
    int mouseY = 0;
    
    // set different colours of blue for the player
    Color blue = new Color (104, 159, 255);
    
    // set the player as a square
    Rectangle player = new Rectangle (390, 580, 20, 20);
    
    // create the rectangle that shoots out from the middle of the player
    Rectangle shoot = new Rectangle (398, 580, 4, 4);
    
    // create the rectangle that shoots out from the middle of the bad guys
    Rectangle green = new Rectangle (18, 36, 4, 4);
    
    // command variables for the player
    boolean playerLeft = false;
    boolean playerRight = false;
    int playerSpeed = 7;
    
    // create a boolean for the bullet to follow the player while it moves left and right
    boolean shoot1Left = false;
    boolean shoot1Right = false;
    int shoot1Speed = 7;
    
    // create a boolean to have the player shoot upward at the 'bad guys'
    boolean shootUp = false;
    int shootSpeed = 0; 
    
    // create an array for the random placement of the enemies
    int[][] xPoints = new int [19][3];
    int[][] yPoints = new int [19][3];
    int arrayY = -40;
    int arrayY1 = 0;
    int arrayY2 = -40;
    
    // generate a random enemy to move downwards
    int randNum = (int)(Math.random()*(19));
    int randNum1 = (int)(Math.random()*(19));
    int randNum2 = (int)(Math.random()*(19));
    int randNum3 = (int)(Math.random()*(19));
    int randNum4 = (int)(Math.random()*(19));
    int randNum5 = (int)(Math.random()*(19));
    int randNum6 = (int)(Math.random()*(19));
    
    // create a 1 second delay
    long timeFired = 0;
    // create the delay time in millseconds
    int delay = 1000;
    
    // make a custom font
    Font font = new Font ("arial", Font.BOLD, 24);
    int win = 0;
    
    
    // GAME VARIABLES END HERE    

    
    // Constructor to create the Frame and place the panel in
    // You will learn more about this in Grade 12 :)
    public LastAssignment(){
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
        preSetup();
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
        // set background colour as black
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        
        // create the bullet that will be shot by the player
        g.setColor(Color.WHITE);
        g.fillRect(shoot.x, shoot.y, shoot.width, shoot.height);
                
        // create the player
        g.setColor(blue);
        g.fillRect(player.x, player.y, player.width, player.height);
        
        // creating the "bad guys" along the top of the screen
        // set the colour as green
        g.setColor(Color.GREEN);
        // for loop for the placement of the bad guys
        for (int i = 0; i < 19; i++) {
                g.fillPolygon(xPoints[i], yPoints[i], 3);
        }
        
        // tell the user when they've won
        g.setFont(font);
        g.drawString("Congradulations! You win!", 500, 700);
		
		
        // GAME DRAWING ENDS HERE
    }

    // This method is used to do any pre-setup you might need to do
    // This is run before the game loop begins!
    public void preSetup() {
        // create the points of the green triangles that will come into the screen
        xPoints[0][0] = 10;
        xPoints[0][1] = 30;
        xPoints[0][2] = 50;
        
        xPoints[1][0] = 55;
        xPoints[1][1] = 75;
        xPoints[1][2] = 95;
        
        xPoints[2][0] = 100;
        xPoints[2][1] = 120;
        xPoints[2][2] = 140;
        
        xPoints[3][0] = 145;
        xPoints[3][1] = 165;
        xPoints[3][2] = 185;
        
        xPoints[4][0] = 190;
        xPoints[4][1] = 210;
        xPoints[4][2] = 230;
        
        xPoints[5][0] = 235;
        xPoints[5][1] = 255;
        xPoints[5][2] = 275;
        
        xPoints[6][0] = 280;
        xPoints[6][1] = 300;
        xPoints[6][2] = 320;
        
        xPoints[7][0] = 325;
        xPoints[7][1] = 345;
        xPoints[7][2] = 365;
        
        xPoints[8][0] = 370;
        xPoints[8][1] = 390;
        xPoints[8][2] = 410;
        
        xPoints[9][0] = 415;
        xPoints[9][1] = 435;
        xPoints[9][2] = 455;
        
        xPoints[10][0] = 460;
        xPoints[10][1] = 480;
        xPoints[10][2] = 500;
        
        xPoints[11][0] = 505;
        xPoints[11][1] = 525;
        xPoints[11][2] = 545;
        
        xPoints[12][0] = 550;
        xPoints[12][1] = 570;
        xPoints[12][2] = 590;
        
        xPoints[15][0] = 595;
        xPoints[15][1] = 615;
        xPoints[15][2] = 635;
        
        xPoints[16][0] = 640;
        xPoints[16][1] = 660;
        xPoints[16][2] = 680;
        
        xPoints[17][0] = 685;
        xPoints[17][1] = 705;
        xPoints[17][2] = 725;
        
        xPoints[18][0] = 730;
        xPoints[18][1] = 750;
        xPoints[18][2] = 770;
        
        yPoints[0][0] = -40;
        yPoints[0][1] = 0;
        yPoints[0][2] = -40;
        
        yPoints[1][0] = -40;
        yPoints[1][1] = 0;
        yPoints[1][2] = -40;
        
        yPoints[2][0] = -40;
        yPoints[2][1] = 0;
        yPoints[2][2] = -40;
        
        yPoints[3][0] = -40;
        yPoints[3][1] = 0;
        yPoints[3][2] = -40;
        
        yPoints[4][0] = -40;
        yPoints[4][1] = 0;
        yPoints[4][2] = -40;
        
        yPoints[5][0] = -40;
        yPoints[5][1] = 0;
        yPoints[5][2] = -40;
        
        yPoints[6][0] = -40;
        yPoints[6][1] = 0;
        yPoints[6][2] = -40;
        
        yPoints[7][0] = -40;
        yPoints[7][1] = 0;
        yPoints[7][2] = -40;
        
        yPoints[8][0] = -40;
        yPoints[8][1] = 0;
        yPoints[8][2] = -40;
        
        yPoints[9][0] = -40;
        yPoints[9][1] = 0;
        yPoints[9][2] = -40;
        
        yPoints[10][0] = -40;
        yPoints[10][1] = 0;
        yPoints[10][2] = -40;
        
        yPoints[11][0] = -40;
        yPoints[11][1] = 0;
        yPoints[11][2] = -40;
        
        yPoints[12][0] = -40;
        yPoints[12][1] = 0;
        yPoints[12][2] = -40;
        
        yPoints[13][0] = -40;
        yPoints[13][1] = 0;
        yPoints[13][2] = -40;
        
        yPoints[14][0] = -40;
        yPoints[14][1] = 0;
        yPoints[14][2] = -40;
        
        yPoints[15][0] = -40;
        yPoints[15][1] = 0;
        yPoints[15][2] = -40;
        
        yPoints[16][0] = -40;
        yPoints[16][1] = 0;
        yPoints[16][2] = -40;
        
        yPoints[17][0] = -40;
        yPoints[17][1] = 0;
        yPoints[17][2] = -40;
        
        yPoints[18][0] = -40;
        yPoints[18][1] = 0;
        yPoints[18][2] = -40;
        
    }

    // The main game loop
    // In here is where all the logic for my game will go
    public void gameLoop() {
        movePlayer();
        collisionCheck();
        moveEnemy();
    }

    private void movePlayer() {
        // player controls for moving left
        if (playerLeft){
            player.x = player.x - playerSpeed;
        }
        // player controls for moving right
        else if (playerRight){
            player.x = player.x + playerSpeed;
    }
        // don't let the player move past the left corner
        if (player.x < 0){
            player.x = 0;
        }
        // don't let the player move past the right corner
        else if (player.x > 600){
            player.x = 600;
    }
        if (shoot1Left){
            shoot.x = shoot.x - shoot1Speed;
    }
        else if (shoot1Right){
            shoot.x = shoot.x + shoot1Speed;
    }
        // make the bullet shoot up when the player presses the space button
        if (shootUp){
            shootSpeed = 20;
            shoot.y = shoot.y - shootSpeed;
        }
        // return the bullet back to it's original place when it goes off the screen
        if (shoot.y < 0){
            shootSpeed = 0;
            shoot.y = 590;
            shoot.x = player.x + 8;
        }
        if (shoot.y == 590){
            shootUp = false;
        }
        // return the bullet back to it's original place when it goes off the screen
        if (shoot.y < 0){
            shootSpeed = 0;
            shoot.y = 590;
            shoot.x = player.x + 8;
        }
        if (shoot.y == 590){
            shootUp = false;
        }
    }
    private void collisionCheck() {

    }
        // collision with bottom
        // when bad guys reaches 0, set it to a new random position

    private void moveEnemy() {

        yPoints[randNum][0] += 4;
        yPoints[randNum][1] += 4;
        yPoints[randNum][2] += 4;
        
        // create an if statement for a 1 second time delay
        if(timeFired && delay )
        
        yPoints[randNum1][0] += 4;
        yPoints[randNum1][1] += 4;
        yPoints[randNum1][2] += 4;
        
        yPoints[randNum2][0] += 4;
        yPoints[randNum2][1] += 4;
        yPoints[randNum2][2] += 4;
        
        yPoints[randNum3][0] += 4;
        yPoints[randNum3][1] += 4;
        yPoints[randNum3][2] += 4;
        
        yPoints[randNum4][0] += 4;
        yPoints[randNum4][1] += 4;
        yPoints[randNum4][2] += 4;
    }
    
    // Used to implement any of the Mouse Actions
    private class Mouse extends MouseAdapter {

        // if a mouse button has been pressed down
        @Override
        public void mousePressed(MouseEvent e) {
            // if you left click:
            if (e.getButton() == MouseEvent.BUTTON1) {
        }
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
        // player command
            int keyCode = e.getKeyCode();
            if (keyCode == KeyEvent.VK_LEFT){
                playerLeft = true;
            }
            else if (keyCode == KeyEvent.VK_RIGHT){
                playerRight = true;
        }
            // make the unseen bullet follow the player while it moves left and right
            if (keyCode == KeyEvent.VK_LEFT){
                shoot1Left = true;
            }
            if (keyCode == KeyEvent.VK_RIGHT){
                shoot1Right = true;
            }
            // make the bullet go up when the player presses the space button
            if (keyCode == KeyEvent.VK_SPACE){
                shootUp = true;
        }
        }
        // if a key has been released
        @Override
        public void keyReleased(KeyEvent e) {
        // player command
            int keyCode = e.getKeyCode();
            if (keyCode == KeyEvent.VK_LEFT){
                playerLeft = false;
            }
            else if (keyCode == KeyEvent.VK_RIGHT){
                playerRight = false;
            }
            if (keyCode == KeyEvent.VK_LEFT){
                shoot1Left = false;
            }
            if (keyCode == KeyEvent.VK_RIGHT){
                shoot1Right = false;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       
        gameLoop();
        repaint();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creates an instance of my game
        LastAssignment game = new LastAssignment();
    }
}

