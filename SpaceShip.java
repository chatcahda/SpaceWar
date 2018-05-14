package f2.spw;

import java.awt.Color;
import java.awt.Graphics2D;

public class SpaceShip extends Sprite{

	int step = 8;
	
	public SpaceShip(int x, int y, int width, int height) {
		super(x, y, width, height);
		
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.GREEN);
		
		g.fillRect(x, y, width, height);
		
		
		g.setColor(Color.yellow);
		g.fillOval(x, y-20, width, height);		//spaceship body
		//g.setColor(Color.red);
		//g.fillOval(x + 35 , y + 10, 20, 8);		//red window on the spaceship


		
	}
	

	public void move(int direction){
		x += (step * direction);
		if(x < 0)
			x = 0;
		if(x > 390 - width)
			x = 390 - width;
	}

}
