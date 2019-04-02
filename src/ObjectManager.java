import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	long enemyTimer = 0;
	int enemySpawnTime = 1000;
	int TIMER = 1000;
	long TIMER2 = 0;
	int ActualTIMER;
	int LEVEL = 1;
	int score = 0;
	Cube r;
	ArrayList<Anvil> anvils = new ArrayList<Anvil>();

	public ObjectManager(Cube roc) {
		this.r = roc;
	}
	
int getScore() {
return score;
}

	void Update() {
		r.Update();
		

		for (Anvil a : anvils) {
			a.Update();
		}
		
	}

	void Draw(Graphics g) {
		r.Draw(g);

		for (int i = 0; i < anvils.size(); i++) {
			anvils.get(i).Draw(g);
		}
		
		

		
	}

	

	public void addAlien(Anvil a) {
		anvils.add(a);
	}

	public void manageEnemies() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addAlien(new Anvil(new Random().nextInt(500), 0, 50, 50));

			enemyTimer = System.currentTimeMillis();
		}
		//Timer / Level
		if (System.currentTimeMillis() - TIMER2 >= TIMER) {
			TIMER2 = System.currentTimeMillis();
			if(ActualTIMER == 10) {
				LEVEL++;
				enemySpawnTime-= 20;
				ActualTIMER = 0;
			} else {
			ActualTIMER++;
			}
		}
	}

	public void purgeObjects() {
		for (int z = 0; z < anvils.size(); z++) {
			if (anvils.get(z).isAlive == false) {
				anvils.remove(z);
			}
		}
	}

	public void checkCollision() {
		for (Anvil a : anvils) {

			if (r.collisionBox.intersects(a.collisionBox)) {

				r.isAlive = false;

			}

		}
		
	} 
}

