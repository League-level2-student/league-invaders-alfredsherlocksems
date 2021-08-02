import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	 final int MENU = 0;
	 final int GAME = 1;
	 final int END = 2;
	 int currentState = MENU;
	 Font titleFont;
	 Font subtitleFont;
	 Timer frameDraw;
	 GamePanel() {
		 titleFont = new Font("Arial", Font.PLAIN, 48);
		 subtitleFont = new Font("Arial", Font.PLAIN, 24);
		 frameDraw = new Timer(1000/60, this);
		 frameDraw.start();
	 }
	@Override
	public void paintComponent(Graphics g) {
		if (currentState == MENU) {
			drawMenuState(g);
		}
		else if (currentState == GAME) {
			drawGameState(g);
		}
		else {
			drawEndState(g);
		}
	}
	
	void updateMenuState() {
		
	}
	
	void updateGameState() {
		
	}
	
	void updateEndState() {
		
	}
	
	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvadersRunner.WIDTH, LeagueInvadersRunner.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("Space Invaders", 60, 50);
		g.setFont(subtitleFont);
		g.drawString("Press 'Enter' to start!", 125, 150);
		g.drawString("Click 'Space' for Instructions!", 75, 250);
	}
	
	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvadersRunner.WIDTH, LeagueInvadersRunner.HEIGHT);
	}
	
	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvadersRunner.WIDTH, LeagueInvadersRunner.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.BLUE);
		g.drawString("Game Over", 45, 50);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (currentState == MENU) {
			updateMenuState();
		}
		else if (currentState == GAME) {
			updateGameState();
		}
		else {
			updateEndState();
		}
		System.out.println("Action");
		repaint();
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == END) {
				currentState = MENU;
			} 
			else {
				currentState++;
			}
		}
		if (currentState == GAME) {
			if (arg0.getKeyCode() == KeyEvent.VK_UP) {
				System.out.println("Up");
			}
			else if (arg0.getKeyCode() == KeyEvent.VK_DOWN) {
				System.out.println("Down");
			}
			else if (arg0.getKeyCode() == KeyEvent.VK_LEFT) {
				System.out.println("Left");
			}
			else if (arg0.getKeyCode() == KeyEvent.VK_RIGHT) {
				System.out.println("Right");
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
