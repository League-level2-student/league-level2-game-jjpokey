import java.awt.Dimension;

	import javax.swing.JFrame;
public class AnvilFall {
	
		//Variables
	JFrame frame;
	 int width = 500;
	 int height = 800;
	GamePanel gp;
	//constructor
	public AnvilFall() {
		JFrame frame = new JFrame();
		GamePanel gp = new GamePanel();
		this.frame = frame;
		this.gp = gp;
	}
	//MAIN
		public static void main(String[] args) {
			AnvilFall i = new AnvilFall();
			i.setup();
		}
		
		//Setup
		void setup() {
			frame.addKeyListener(gp);
			frame.add(gp);
			frame.setSize(width, height);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setPreferredSize(new Dimension(width, height));

	        frame.pack();
	        gp.startGame();
		}
		
	}

