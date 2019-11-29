package modelo;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Logica {

	private ArrayList<Personaje> personajes;
	private Personaje[] arreglo;
	private PImage imagenHomero;
	private PImage imagenBart;
	private int maximoArreglo;
	private PApplet app;

	public Logica(PApplet app) {
		this.personajes = new ArrayList<Personaje>();
		this.imagenHomero = app.loadImage("homero_simpson.png");
		this.imagenBart = app.loadImage("bart_simpson.png");
		this.app = app;
		this.arreglo = new Personaje[10];
		this.maximoArreglo = 0;

	}

	public void pintar() {
		app.rectMode(PConstants.CORNER);
		app.fill(0);
		app.rect(0, 0, 200, app.height);
		app.rectMode(PConstants.CENTER);
		app.fill(50, 50, 155);
		app.rect(app.width / 2 + 100, app.height - 100, 100, 50);
		app.fill(255);
		app.textAlign(PConstants.CENTER);
		app.text("Crear", app.width / 2 + 100, app.height - 100);
		for (int i = 0; i < this.personajes.size(); i++) {
			Personaje personaje = this.personajes.get(i);
			app.imageMode(PConstants.CENTER);
			app.image(personaje.getImagen(), personaje.getPosX(), personaje.getPosY(), 100, 150);

		}

	}

	public void crearPersonaje() {
		int randomSuerte = (int) app.random(0, 10);
		int randomEdad = (int) app.random(0, 30);
		float randomPosX = app.random(350, 850);
		float randomPosY = app.random(250, 650);
		if (app.mouseX >= (app.width / 2 + 100) - 50 && app.mouseX <= (app.width / 2 + 100) + 50
				&& app.mouseY >= (app.height - 100) - 25 && app.mouseY <= (app.height - 100) + 25) {
			this.personajes.add(new Personaje(randomSuerte, this.imagenBart, randomEdad, randomPosX, randomPosY, app));
		}

	}

	public void agregarArreglo() {
		for (int i = 0; i < personajes.size(); i++) {
			Personaje personaje = this.personajes.get(i);
			if (app.mouseX >= personaje.getPosX() - 50 && app.mouseX <= personaje.getPosX() + 50
					&& app.mouseY >= personaje.getPosY() - 150 / 2 && app.mouseY <= personaje.getPosY() + 150 / 2) {
				personaje.setAgregado(true);
				
				this.arreglo[this.maximoArreglo] = (personaje);
				this.maximoArreglo++;
				System.out.println(this.arreglo[this.maximoArreglo]);
			}

		}
	}
}
