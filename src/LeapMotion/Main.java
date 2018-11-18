package LeapMotion;

import processing.core.PApplet;
import LeapMotion.LeapMotionS.Gestos;
import de.voidplus.leapmotion.CircleGesture;
import de.voidplus.leapmotion.Finger;
import de.voidplus.leapmotion.KeyTapGesture;
import de.voidplus.leapmotion.ScreenTapGesture;
import de.voidplus.leapmotion.SwipeGesture;

public class Main extends PApplet{


	public static void main(String[] args) {
		PApplet.main("LeapMotion.Main");
	}

	Logica log;

	@Override
	public void settings() {
		size(1200, 700);
	}

	@Override
	public void setup() {
		this.log = new Logica(this);
	}

	@Override
	public void draw() {
		background(255);
		log.pintar();
		log.validarChoque();
	}

	// ======================================================
	// Codigo de sensor LeapMotion

	public void leapOnSwipeGesture(SwipeGesture g, int state) {
		log.getLeap().leapOnSwipeGesture(g, state);
	}

	public void leapOnCircleGesture(CircleGesture g, int state) {
		log.getLeap().leapOnCircleGesture(g, state);
		
	}

	public void leapOnScreenTapGesture(ScreenTapGesture g) {
		log.getLeap().leapOnScreenTapGesture(g);
	}

	public void leapOnKeyTapGesture(KeyTapGesture g) {
		log.getLeap().leapOnKeyTapGesture(g);
	}



}
