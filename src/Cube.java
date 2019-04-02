import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Cube extends GameObject {
	int speed;

	Cube(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 35;
	}

	public void Update(int speed) {
		super.Update();
		this.speed = this.speed + speed;
	}

	public void Draw(Graphics g) {
		g.drawImage(GamePanel.squareImg, x, y, width, height, null);
	}

}