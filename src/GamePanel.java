import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	
Timer t;
int frameRate = 1000 / 60;
final int MENU_STATE = 0;
final int GAME_STATE = 1;
final int END_STATE = 2;
int currentState = MENU_STATE;
Font titleFont;
Font EnterFont;
Font SpaceFont;
Font overFont;
Font enemiesFont;
Font enter2Font;
public static BufferedImage anvilImg;
public static BufferedImage squareImg;
public static BufferedImage backgroundImg;
public static BufferedImage moneyImg;
Cube cu = new Cube(250, 700, 50, 50);
ObjectManager obm = new ObjectManager(cu);


@Override

public void paintComponent(Graphics g){
	if(currentState == MENU_STATE){

        drawMenuState(g);

}else if(currentState == GAME_STATE){

        drawGameState(g);

}else if(currentState == END_STATE){

        drawEndState(g);

}

}
             
        

 GamePanel() {
		Timer t = new Timer(frameRate, this);
		this.t = t;
		titleFont = new Font("Arial",Font.PLAIN,48);
		EnterFont = new Font("Arial",Font.PLAIN,24);
		SpaceFont = new Font("Arial",Font.PLAIN,24);
		overFont = new Font("Arial",Font.PLAIN,48);
		enemiesFont = new Font("Arial",Font.PLAIN,24);
		enter2Font = new Font("Arial",Font.PLAIN,24);
		   try {

               anvilImg = ImageIO.read(this.getClass().getResourceAsStream("anvil.png"));
               squareImg = ImageIO.read(this.getClass().getResourceAsStream("square.png"));
               backgroundImg = ImageIO.read(this.getClass().getResourceAsStream("background.png"));
               moneyImg = ImageIO.read(this.getClass().getResourceAsStream("money.png"));
       } catch (IOException e) {

               

               e.printStackTrace();

       }
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(currentState == MENU_STATE){

            updateMenuState();

    }else if(currentState == GAME_STATE){

            updateGameState();

    }else if(currentState == END_STATE){

            updateEndState();

    }
		repaint();
	}
	
	void startGame() {
		t.start();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			for(int a = 0; a < cu.speed; a++) {
				cu.x++;
			}
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			for(int a = 0; a < cu.speed; a++) {
				cu.x--;
			}
			
		}
		//else if(e.getKeyCode() == KeyEvent.VK_UP) {
		//	for(int a = 0; a < cu.speed; a++) {
			//	cu.y--;
			//}
		//}
		//else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			//for(int a = 0; a < cu.speed; a++) {
				//cu.y++;
		//	}
		//}
	
		if(e.getKeyCode() == KeyEvent.VK_S) {
			cu.Update(1);
			System.out.println(cu.speed);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			if(currentState == MENU_STATE) {
				
				JOptionPane.showMessageDialog(null, "Use arrow keys to move sideways. Avoid anvils at all cost! Try not to die");
			}
		}
		
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			
			if(currentState == MENU_STATE) {
				currentState = GAME_STATE;
			}
		
			else if(currentState == GAME_STATE) {
				currentState = END_STATE;
			}
			
			else if(currentState == END_STATE){
                currentState = MENU_STATE;
                cu = new Cube(250, 700, 50, 50);
                obm = new ObjectManager(cu);
			
		}
		}
	}
		

	
	//menu
	void updateMenuState() {
		
	}
	void updateGameState() {

		obm.Update();
	obm.checkCollision();
	obm.manageEnemies();
	obm.purgeObjects();
	if(cu.isAlive == false) {
		currentState = END_STATE;
	}
	
	}
	void updateEndState() {
		
	}
	//draw
	void drawMenuState(Graphics g) {
		g.setColor(Color.BLACK);

		g.fillRect(0, 0, 500, 800); 
		
		g.setFont(titleFont);
		g.setColor(Color.GRAY);
		g.drawString("Anvil Fall", 140, 200);
		g.setFont(EnterFont);
		g.setColor(Color.GRAY);
		g.drawString("Press ENTER to start", 125, 350);
		g.setFont(SpaceFont);
		g.setColor(Color.GRAY);
		g.drawString("Press SPACE for instructions", 80, 500);
	}
	void drawGameState(Graphics g) {
		g.drawImage(GamePanel.backgroundImg, 0, 0, 500, 800, null);
		obm.Draw(g);
		//Timer
		g.setColor(Color.WHITE);
		g.setFont(EnterFont);
		g.drawString("Timer: " + obm.ActualTIMER , 400, 50);
		//Level
		g.setColor(Color.WHITE);
		g.setFont(EnterFont);
		g.drawString("Level " + obm.LEVEL, 50, 50);
		//Score
		g.setColor(Color.RED);
		g.setFont(EnterFont);
		g.drawString("Score: " + obm.RSCORE, 200, 50);
		//HighScore
		g.setColor(Color.RED);
		g.setFont(EnterFont);
		g.drawString("HighScore: " + obm.HSCORE, 180, 75);
	}
	void drawEndState(Graphics g) {
		g.setColor(Color.RED);

		g.fillRect(0, 0, 500, 800); 

		g.setFont(overFont);
		g.setColor(Color.BLACK);
		g.drawString("Game Over", 100, 200);
		
		g.setFont(enter2Font);
		g.setColor(Color.BLACK);
		g.drawString("Your Score Was " + obm.RSCORE, 115, 300);
		
		g.setFont(enter2Font);
		g.setColor(Color.BLACK);
		g.drawString("Press ENTER to restart", 115, 400);
	}



	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
