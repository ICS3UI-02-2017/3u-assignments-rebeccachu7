
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
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author chur7632
 */
public class LastAssignment extends JComponent implements ActionListener {

    // Height and Width of our game
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    
    // make the title of the window Shooting Game
    String title = "Shooting Game";
    
    // sets the framerate and delay for our game
    // this calculates the number of milliseconds per frame
    // you just need to select an approproate framerate
    int desiredFPS = 60;
    int desiredTime = Math.round((1000 / desiredFPS));
    
    // timer used to run the game loop
    // this is what keeps our time running smoothly :)
    Timer gameTimer;
    // generate the 2 pictures that will be put on the screen when the player wins and loses
    BufferedImage winImage = loadImage ("win.png");
    BufferedImage ohNo = loadImage ("ohNo.png");
    
    // YOUR GAME VARIABLES WOULD GO HERE
    
    // set a light shade of blue for the colour of the player
    Color blue = new Color(104, 159, 255);
    
    // set the player as a square at the bottom middle of the screen
    Rectangle player = new Rectangle(390, 580, 20, 20);
    
    // create the rectangle that shoots out from the middle of the player
    Rectangle shoot = new Rectangle(398, 580, 4, 4);
    
    // create an integer variable for the line which the enemy cannot pass
    Rectangle line = new Rectangle (0, 570, 800, 1);
    
    // create booleans to command the player to move left and right
    boolean playerLeft = false;
    boolean playerRight = false;
    // create an integer for the speed of the player
    int playerSpeed = 17;
    
    // create booleans for the bullet to follow the player while it moves left and right
    boolean shoot1Left = false;
    boolean shoot1Right = false;
    // create a boolean to have the player shoot upward at the enemies
    boolean shootUp = false;
    int shootSpeed = 0;
    
    // create an array for the random placement of the enemies
    int[][] xPoints = new int[19][3];
    int[][] yPoints = new int[19][3];
    
    // make the speed of the enemy equal 5
    int enemySpeed = 5;
    
    // create a random number for the computer to generate a random enemy to move downwards
    int randNum = 0;
    
    // create an integer named count, so that it can count how many times the person has shot an enemy
    int count = 0;
    
    // create an integer that stores the score
    int score = 0;
    
    // make a custom font that will be written on the screen when the person has lost
    Font bigFont = new Font("arial", Font.BOLD, 60);
    
    // make a custom font that will be written on the screen when the person has lost
    Font smallFont = new Font("arial", Font.BOLD, 20);
    
    // make a boolean for if the player loses
    boolean lose = false;
    
    // create a boolean for when the person wins
    boolean win = false;
    
    // create a boolean to reset the game
    boolean reset = false;
    
    // GAME VARIABLES END HERE    
    // Constructor to create the Frame and place the panel in
    // You will learn more about this in Grade 12 :)
    public LastAssignment() {
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
        gameTimer = new Timer(desiredTime, this);
        gameTimer.setRepeats(true);
        gameTimer.start();
    }
    // create a method for loading the images when the player wins and loses
    public BufferedImage loadImage(String name){
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(name));
        } catch (Exception e){
            System.out.println("Can't load image");
            e.printStackTrace();
        }
        return img;
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
        // set it's colour as white
        g.setColor(Color.WHITE);
        g.fillRect(shoot.x, shoot.y, shoot.width, shoot.height);

        // create the player
        // set the colour as the custom made colour, created in the game variables
        g.setColor(blue);
        g.fillRect(player.x, player.y, player.width, player.height);
        
        // create the line across the screen that the enemies cannot cross
        // make the colour of the line white
        g.setColor(Color.BLACK);
        g.fillRect(line.x, line.y, line.width, line.height);

        // creating the enemies along the top of the screen
        // set their colour as green
        g.setColor(Color.GREEN);
        // create a for loop for the placement of the bad guys along the top of the screen
        for (int i = 0; i < 17; i++) {
            g.fillPolygon(xPoints[i], yPoints[i], 3);
        }
        
        // write the score on the bottom right side of the screen
        g.setColor(Color.WHITE);
        g.drawString("" + score, WIDTH - 20, 590);
        
        // create an if statement for when the player loses
        if (lose){
        // create a white rectangle that goes across the entire screen
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 800, 600);
        // create the font of the text, created in the game variables
        g.setFont(bigFont);
        // set the colour of the text as black
        g.setColor(Color.BLACK);
        // tell the player that they have lost
        g.drawImage(ohNo, 0, 0, null);
        g.drawString("You Lose!", 410, 145);
        // tell the player to click the r button if they would like to restart the game
        // use the small font
        g.setFont(smallFont);
        g.drawString("Press r to restart", 415, 515);
        }
        
        // create an if statement for when the player wins
        if (win){
        // create a white rectangle that goes across the entire screen
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 800, 600);
        // create the font of the text, created in the game variables
        g.setFont(bigFont);
        // set the colour of the text as black
        g.setColor(Color.BLACK);
        // tell the player that they have lost
        g.drawImage(winImage, 0, 0, null);
        g.drawString("You Win!", 510, 525);
        }
        
        // create an if statement for the game to reset when the player clicks the 'r' button on the screen
        if (reset){
            lose = false;
            // make the bullet return to it's original place
            shoot.y = player.y + 2;
            // make the erandom enemy return to it's original place
            yPoints[randNum][0] = -40;
            yPoints[randNum][1] = 0;
            yPoints[randNum][2] = -40;
        }

        
        // GAME DRAWING ENDS HERE
    }

    // This method is used to do any pre-setup you might need to do
    // This is run before the game loop begins!
    public void preSetup() {
        // create the x points of the green triangles that will come into the screen
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

        xPoints[13][0] = 595;
        xPoints[13][1] = 615;
        xPoints[13][2] = 635;

        xPoints[14][0] = 640;
        xPoints[14][1] = 660;
        xPoints[14][2] = 680;

        xPoints[15][0] = 685;
        xPoints[15][1] = 705;
        xPoints[15][2] = 725;

        xPoints[16][0] = 730;
        xPoints[16][1] = 750;
        xPoints[16][2] = 770;

        // create the x points of the green triangles that will come into the screen
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

        // create a for statement to generate a randum number
        for (int i = 0; i < 10; i++) {
             randNum = (int) (Math.random() * (17));
        }
    }
    
    // The main game loop
    // In here is where all the logic for my game will go
    public void gameLoop() {
        movePlayer();
        moveEnemy();
    }

    private void movePlayer() {
        // player controls for moving left
        if (playerLeft) {
            player.x = player.x - playerSpeed;
        } // player controls for moving right
        else if (playerRight) {
            player.x = player.x + playerSpeed;
        }
        // bullet controls for moving left
        if (shoot1Left) {
            shoot.x = shoot.x - playerSpeed;
        } // bullet controls for moving left
        else if (shoot1Right) {
            shoot.x = shoot.x + playerSpeed;
        }
        
        // don't let the player or bullet move past the left corner
        if (player.x <= 0 && shoot.x <= 4) {
            player.x = 0;
            shoot.x = 2;
        }
        // don't let the player and bullet move past the right corner
        else if (player.x >= 780 && shoot.x >= 792) {
            player.x = 780;
            shoot.x = 792;
        }
        
        // make the bullet shoot up when the player presses the space button
        if (shootUp) {
            shootSpeed = 30;
            shoot.y = shoot.y - shootSpeed;
        }
        
        // return the bullet back to it's original place when it goes off the screen
        if (shoot.y < 0) {
            shootSpeed = 0;
            shoot.y = 590;
            shoot.x = player.x + 8;
        }
        if (shoot.y == 590) {
            shootUp = false;
        }
    }

    private void moveEnemy() {
        // command the randomly generated enemy to start moving down
            yPoints[randNum][0] += enemySpeed;
            yPoints[randNum][1] += enemySpeed;
            yPoints[randNum][2] += enemySpeed;
            
        // create a collision detection for the enemy and the bullet shot with the random enemy being sent down
        if (xPoints[randNum][0] <= shoot.x && shoot.x <= xPoints[randNum][2] && yPoints [randNum][0] <= shoot.y && shoot.y  <= yPoints[randNum][1]){
            // make the enemy go back up to where it isn't visible
            yPoints[randNum][0] = -40;
            yPoints[randNum][1] = 0;
            yPoints[randNum][2] = -40;
            
            // make the score at the bottom right of the screen go up every time an enemy is destroyed
            count = count + 1;
            score++;
            
            // make the game generate a new randum enemy to bring down
            randNum = (int) (Math.random() * (17));
        }
        // return the randomly chosen enemy back to it's original position if it touches the line in front of the player
        if (yPoints[randNum][1] >= line.y){
            yPoints[randNum][0] = -40;
            yPoints[randNum][1] = 0;
            yPoints[randNum][2] = -40;
            
            // make a white screen appear overtop of the game, telling the player that they have lose the game
            lose = true;
            score = 0;
    }
        // of the player has killed off 30 enemies, the screen will show that they have won
        if (count == 30){
            win = true;
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
        }
    }

    // Used to implements any of the Keyboard Actions
    private class Keyboard extends KeyAdapter {

        // if a key has been pressed down
        @Override
        public void keyPressed(KeyEvent e) {
            // player command
            int keyCode = e.getKeyCode();
            
            // move the player left and right
            if (keyCode == KeyEvent.VK_LEFT) {
                playerLeft = true;
            }
            else if (keyCode == KeyEvent.VK_RIGHT) {
                playerRight = true;
            }
            // make the unseen bullet follow the player while it moves left and right
            if (keyCode == KeyEvent.VK_LEFT) {
                shoot1Left = true;
            }
            else if (keyCode == KeyEvent.VK_RIGHT) {
                shoot1Right = true;
            }
            // make the bullet go up when the player presses the space button
            if (keyCode == KeyEvent.VK_SPACE) {
                shootUp = true;
            }
            // if the player presses the 'r' button, the game will reset
            if (keyCode == KeyEvent.VK_R) {
                reset = true;
            }
        }
        // if a key has been released

        @Override
        public void keyReleased(KeyEvent e) {
            // player command
            int keyCode = e.getKeyCode();
            
            // when the left and right keys are released, the player will stop moving
            if (keyCode == KeyEvent.VK_LEFT) {
                playerLeft = false;
            } else if (keyCode == KeyEvent.VK_RIGHT) {
                playerRight = false;
            }
            // the bullet will also stop moving with the player when the keys are released
            if (keyCode == KeyEvent.VK_LEFT) {
                shoot1Left = false;
            }
            if (keyCode == KeyEvent.VK_RIGHT) {
                shoot1Right = false;
            }
            // when the 'r' button is released, the game will reset
            if (keyCode == KeyEvent.VK_R) {
                reset = false;
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