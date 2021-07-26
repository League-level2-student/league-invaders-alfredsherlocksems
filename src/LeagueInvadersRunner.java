import javax.swing.JFrame;

public class LeagueInvadersRunner {
	JFrame frame;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
	LeagueInvadersRunner() {
		frame = new JFrame();
	}
	public static void main (String[] args) {
		LeagueInvadersRunner leagueInvaders = new LeagueInvadersRunner();
		leagueInvaders.setup();
	}
	void setup() {
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
