import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener{
	Rocketship rocket;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	Random ran = new Random();
	int score = 0;
	
	ObjectManager (Rocketship rocket) {
		this.rocket=rocket;
	}
	
	void addProjectile (Projectile projectile) {
		projectiles.add(projectile);
	}
	
	void addAlien () {
		aliens.add(new Alien(800, ran.nextInt(LeagueInvadersRunner.HEIGHT), 50, 50));
	}
	
	void update () {
		rocket.move();
		for (Alien a: aliens) {
			a.update();
			if (a.x < 0) {
				a.isActive = false;
			}
		}
		for (Projectile p: projectiles) {
			p.update();
			if (p.x > LeagueInvadersRunner.WIDTH) {
				p.isActive = false;
			}
		}
		checkCollision();
		purgeObjects();
	}
	
	void draw (Graphics g) {
		rocket.draw(g);
		for (Alien a: aliens) {
			a.draw(g);
		}
		for (Projectile p: projectiles) {
			p.draw(g);
		}
	}
	
	void purgeObjects () {
		for (int i = 0; i < aliens.size(); i++) {
			if (aliens.get(i).isActive == false) {
				aliens.remove(i);
			}
		}
		for (int i = 0; i < projectiles.size(); i++) {
			if (projectiles.get(i).isActive == false) {
				projectiles.remove(i);
			}
		}
	}
	void checkCollision() {
		for (Alien a: aliens) {
			for (Projectile p: projectiles) {
				if (a.collisionBox.intersects(p.collisionBox)) {
				a.isActive = false;
				p.isActive = false;
				score++;
				}
			}	
			if (a.collisionBox.intersects(rocket.collisionBox)) {
				a.isActive=false;
				rocket.isActive=false;
			}
		}
	}
	public int score() {
		return score;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		addAlien();
	}
}
