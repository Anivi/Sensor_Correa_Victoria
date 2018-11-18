package LeapMotion;

import java.util.LinkedList;

import LeapMotion.LeapMotionS.Gestos;
import processing.core.PApplet;

public class Logica implements Gestos {

	private PApplet app;
	private LeapMotionS leap;
	private LinkedList<Balas> balas;
	private LinkedList<Enemigos> enemigos;
	int pantalla;

	public Logica(PApplet app) {
		this.app = app;
		leap = new LeapMotionS(app);
		leap.setClassGestos(this);
		balas = new LinkedList<Balas>();
		enemigos = new LinkedList<Enemigos>();
	}

	public void pintar() {
		leap.procesosEnEjecucion(10);
switch (pantalla) {
case 0:
		for (int i = 0; i < balas.size(); i++) {
			balas.get(i).pintar();
			balas.get(i).mover();
		}
		
		if (leap.getAgarro()) {
			
			app.fill(255,0,0);
		}else {
			app.fill(0,255,0);
		}
			app.ellipse(leap.getHandX(),650 , 50, 50);	
		
			for (int i = 0; i < balas.size(); i++) {
			if (balas.get(i).getY() == -100) {
			balas.remove(i);
		}
	}
		generarEnemigos();
		disparar();
		pintarEnemigos();
break ;	
}
	}
	
	public void disparar() {
		if (leap.getAgarro()) {
		if(app.frameCount%30 == 0) {
			balas.add(new Balas(app, leap.getHandX(), 650));
		}
		}
	}

	
	public void generarEnemigos() {
		if (app.frameCount%60 == 0) {
			enemigos.add(new Enemigos(app));
		}
	}
	
	public void pintarEnemigos() {
		for (int i = 0; i < enemigos.size(); i++) {
			enemigos.get(i).pintar();
			enemigos.get(i).mover();
		}
		
		for (int i = 0; i < enemigos.size(); i++) {
		if (enemigos.get(i).getY() == 800) {
		enemigos.remove(i);
	}
}
	}
	
	public void validarChoque() {
		for (int l = 0; l < enemigos.size(); l++) {
		if (app.dist(leap.getHandX(),650, enemigos.get(l).getX(), enemigos.get(l).getY())<50) {
			pantalla = 1;
		}
		}
		for (int i = 0; i < enemigos.size(); i++) { 
			for (int j = 0; j < balas.size(); j++) {
				
			if ( enemigos.get(i).validar(balas.get(j)) == true ) {
				enemigos.remove(i);
				balas.remove(j);
				 return;
			}
		}
		}
	}

	@Override
	public void horizontal() {
		// TODO Auto-generated method stub


	}

	@Override
	public void enCirculo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void enCirculoDerecha() {
		// TODO Auto-generated method stub
	}

	@Override
	public void enCirculoIzquierda() {
		// TODO Auto-generated method stub
	}

	@Override
	public void abajo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void zigzag() {
		// TODO Auto-generated method stub
	}

	public LeapMotionS getLeap() {
		return leap;
	}

}
