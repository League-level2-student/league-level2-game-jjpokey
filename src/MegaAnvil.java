import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class MegaAnvil extends GameObject{

	MegaAnvil(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	
void Update() {
	super.Update();
//MOVEMENT
	
	y+= 5;
	
	
	
	
	
}
void Draw(Graphics g) {
	
	g.drawImage(GamePanel.anvilImg, x, y, width, height, null);
}
}