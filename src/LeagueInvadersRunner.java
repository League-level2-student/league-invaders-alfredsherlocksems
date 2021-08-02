import javax.swing.JFrame;

public class LeagueInvadersRunner {
	JFrame frame;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
	GamePanel panel;
	LeagueInvadersRunner() {
		frame = new JFrame();
		panel = new GamePanel();
	}
	public static void main (String[] args) {
		LeagueInvadersRunner leagueInvaders = new LeagueInvadersRunner();
		leagueInvaders.setup();
	}
	void setup() {
		frame.add(panel);
		frame.addKeyListener(panel);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
