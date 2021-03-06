import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	long enemyTimer = 0;
	int enemySpawnTime = 1000;
	long enemyTimer2 = 0;
	int enemySpawnTime2 = 5000;
	int TIMER = 1000;
	long TIMER2 = 0;
	int DTIMER = 1000;
	long DTIMER2 = 0;
	int T3 = 5000;
	long T4 = 0;
	int ActualTIMER;
	int LEVEL = 1;
	int score = 0;
	int T = 1;
	long T2 = 0;
	int RSCORE = 1000;
	int HSCORE;
	int q = 0;
	Cube r;
	ArrayList<Anvil> anvils = new ArrayList<Anvil>();
	ArrayList<MegaAnvil> manvils = new ArrayList<MegaAnvil>();
	ArrayList<MoneyBag> money = new ArrayList<MoneyBag>();
	ArrayList<DeathAnvil> danvils = new ArrayList<DeathAnvil>();


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
		for (MoneyBag c : money) {
			c.Update();
		}
		
	}

	void Draw(Graphics g) {
		r.Draw(g);

		for (int i = 0; i < anvils.size(); i++) {
			anvils.get(i).Draw(g);
		}
			for (int b = 0; b < manvils.size(); b++) {
				manvils.get(b).Draw(g);
		}
			for (int c = 0; c < money.size(); c++) {
				money.get(c).Draw(g);
		}
			for (int d = 0; d < danvils.size(); d++) {
				danvils.get(d).Draw(g);
		
		}
		
		

		
	}

	

	public void addAlien(Anvil a) {
		anvils.add(a);
	}
	public void addAlien(MegaAnvil b) {
		manvils.add(b);
	}
	public void addAlien(MoneyBag c) {
		money.add(c);
	}
	public void addAlien(DeathAnvil d) {
		danvils.add(d);
	}
	
//Anvil
	public void manageEnemies() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addAlien(new Anvil(new Random().nextInt(500), 0, 50, 50));

			enemyTimer = System.currentTimeMillis();
		}
		//MegaAnvil
		if(LEVEL > 4) {
		if (System.currentTimeMillis() - enemyTimer2 >= enemySpawnTime2) {
			addAlien(new Anvil(new Random().nextInt(500), 0, 100, 100));

			enemyTimer2 = System.currentTimeMillis();
		}
		}
		//DeathAnvil
		if(RSCORE <= 0) {
			if (System.currentTimeMillis() - DTIMER2 >= DTIMER) {
				DTIMER2 = System.currentTimeMillis();
				addAlien(new Anvil(0, 0, 500, 500));					
		}
		}
		//money
			if (System.currentTimeMillis() - T4 >= T3) {
				addAlien(new MoneyBag(new Random().nextInt(500), 0, 50, 50));

				T4 = System.currentTimeMillis();
			}
		//Timer / Level
		if (System.currentTimeMillis() - TIMER2 >= TIMER) {
			TIMER2 = System.currentTimeMillis();
			if(ActualTIMER == 10) {
				LEVEL++;
				enemySpawnTime-= 25;
				ActualTIMER = 0;
			} else {
			ActualTIMER++;
			}
		}
		//SCORE
		if (System.currentTimeMillis() - T2 >= T) {
			T2 = System.currentTimeMillis();
			RSCORE--;
		}
		}
		
	

	public void purgeObjects() {
		for (int z = 0; z < anvils.size(); z++) {
			if (anvils.get(z).isAlive == false) {
				anvils.remove(z);
			}
		}
		for (int c = 0; c < money.size(); c++) {
			if (money.get(c).isAlive == false) {
				money.remove(c);
			}
		}
	}

	public void checkCollision() {
		for (Anvil a : anvils) {

			if (r.collisionBox.intersects(a.collisionBox)) {
				r.isAlive = false;
			}
		}
		for(MoneyBag c : money) {
			if (r.collisionBox.intersects(c.collisionBox)) {
				RSCORE += 350;
				c.isAlive = false;
			}
			}
		}

	
		
	} 


