import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Anvil extends GameObject{

	int movement = new Random().nextInt(4);
	Random rand = new Random();
	Anvil(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	
void Update() {
	super.Update();
//MOVEMENT
	y+= 5;
	
	if(movement == 0) {
		y+=5;
		}
	if(movement == 1) {
	y+=3;
	}
	if(movement == 2) {
		y+=10;
		}
	if(movement == 3) {
		y+=15;
		}
	
	
	
}
void Draw(Graphics g) {
	
	g.drawImage(GamePanel.anvilImg, x, y, width, height, null);
}
}
