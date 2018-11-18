package LeapMotion;

import processing.core.PApplet;

public class Enemigos {

	private PApplet app;
	private float x;
	private float y;
	
	public Enemigos(PApplet app) {
		this.app = app;
		this.x = app.random(100,app.width -100);
		this.y = app.random(-150, -200);
	}

	public void pintar() {
		app.fill(0,0,255);
		app.triangle(x, y, x+50, y, x+25, y+50);
	}
	
	public void mover() {
		y+= 2;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
	
	public boolean validar(Balas b) {
		if (app.dist(b.getX(), b.getY(), x, y)<30) {
			return true;
	} else { 
		return false;
	}
}
	
}
