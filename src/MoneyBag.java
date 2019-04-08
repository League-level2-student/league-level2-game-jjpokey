import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class MoneyBag extends GameObject{
int randomclock = new Random().nextInt(3);
	MoneyBag(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	
void Update() {
	super.Update();
//MOVEMENT
	if(randomclock == 0) {
	y+= 6;
	}	
	if(randomclock == 1) {
		y+= 8;
		}
	if(randomclock == 2) {
		y+= 12;
		}
	
	
	
	
}
void Draw(Graphics g) {
	
	g.drawImage(GamePanel.moneyImg, x, y, width, height, null);
}
}