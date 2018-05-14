package f2.spw;

import java.awt.Color;
import java.awt.Graphics2D;

public class SpaceShip1 extends Sprite{

	int step = 8;
	
	public SpaceShip1(int x, int y, int width, int height) {
		super(x, y, width, height);
		
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.green);
		g.fillRect(x, y, width, height);
		g.setColor(Color.pink);
		g.fillOval(x, y-20, width, height);		//spaceship body
	}

	public void move(int direction){
		x += (step * direction);
		if(x < 0)
			x = 0;
		if(x > 390 - width)
			x = 390 - width;
	}

}
