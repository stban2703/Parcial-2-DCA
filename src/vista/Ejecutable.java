package vista;

import modelo.Logica;
import processing.core.PApplet;

public class Ejecutable extends PApplet {

	public static void main(String[] args) {
		PApplet.main(Ejecutable.class.getName());

	}

	private Logica logica;

	public void settings() {
		size(1000, 800);

	}

	public void setup() {
		logica = new Logica(this);

	}

	public void draw() {
		background(255);
		logica.pintar();

	}

	public void mousePressed() {
		logica.crearPersonaje();
		logica.agregarArreglo();

	}

}
