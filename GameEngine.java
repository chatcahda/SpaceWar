package f2.spw;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Timer;


public class GameEngine implements KeyListener, GameReporter{
	GamePanel gp;
		
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	private ArrayList<Enemy2> enemies2 = new ArrayList<Enemy2>();	
	private SpaceShip v;
	private SpaceShip1 v2;
	
	private Timer timer;
	private int level = 1;
	private long score = 0;
	private double difficulty = 0.05;
	private int count =0;
	
	public GameEngine(GamePanel gp, SpaceShip v, SpaceShip1 v2) {
		this.gp = gp;
		this.v = v;		
		this.v2 = v2;	
		gp.sprites.add(v);
		gp.sprites.add(v2);
		
		timer = new Timer(70, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				process();
				count++;
				if(count >= 100){
					level+=1;
					difficulty += 0.05;
					count =0;
				}
				
			}
		});
		timer.setRepeats(true);
		
	}
	
	public void start(){
		timer.start();
	}
	
	private void generateEnemy(){
		//Enemy e = new Enemy((int)(Math.random()*390), 30);
		int x = (int)(Math.random()*390);
		int r = (int)(Math.random()*2);
		if(r==1){
			Enemy e1 = new Enemy(x, 30);
			gp.sprites.add(e1);
			enemies.add(e1);
		}else{
			Enemy2 e2 = new Enemy2(x, 30);
			gp.sprites.add(e2);
			enemies2.add(e2);
		}
	}
	
	private void process(){
		if(Math.random() < difficulty){
			generateEnemy();
		}
		
		Iterator<Enemy> e_iter = enemies.iterator();
		while(e_iter.hasNext()){
			Enemy e = e_iter.next();
			e.proceed();
			
			if(!e.isAlive()){
				e_iter.remove();
				gp.sprites.remove(e);
				score += 10;
				
			}
		}
	
		
		Iterator<Enemy2> e2_iter = enemies2.iterator();
		while(e2_iter.hasNext()){
			Enemy2 e2 = e2_iter.next();
			e2.proceed();
			
			if(!e2.isAlive()){
				e2_iter.remove();
				gp.sprites.remove(e2);
				score += 10;
				
			}
		}
	
		gp.updateGameUI(this);
		
		Rectangle2D.Double vr = v.getRectangle();
		Rectangle2D.Double vr2 = v2.getRectangle();
		Rectangle2D.Double er;
		for(Enemy e : enemies){
			er = e.getRectangle();
			if(er.intersects(vr) || er.intersects(vr2)){
				die();
				return;
			}
		}
	
	}
	
	
	public void die(){
		Gameover o = new Gameover();
		timer.stop();
	}
	
	void controlVehicle(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			v.move(-1);
			break;
		case KeyEvent.VK_RIGHT:
			v.move(1);
			break;
		case KeyEvent.VK_D:
			difficulty += 0.05;
			break;
		case KeyEvent.VK_A:
			v2.move(-1);
			break;
		case KeyEvent.VK_S:
			v2.move(1);
			break;
		}
	}
	

	public long getScore(){
		return score;
	}
	public int getLevel(){
		return level;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		controlVehicle(e);
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//do nothing
	}

	@Override
	public void keyTyped(KeyEvent e) {
		//do nothing		
	}
}

