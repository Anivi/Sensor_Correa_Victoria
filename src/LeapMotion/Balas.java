package LeapMotion;

import processing.core.PApplet;

public class Balas {
	
	private PApplet app;
	private float x;
	private float y;
	
	public Balas(PApplet app, float x, float y) {
		this.app = app;
		this.x = x;
		this.y = y;
	}

	public void pintar() {
		app.fill(255,0,255,80);
		app.rect(x, y, 5, 20);
	}
	
	public void mover() {
		y-= 6;
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
	
	
}
