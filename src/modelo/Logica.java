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
	private String mensaje;
	private PApplet app;
	private CompararPersonaje compararLaEdad;

	public Logica(PApplet app) {
		this.personajes = new ArrayList<Personaje>();
		this.imagenHomero = app.loadImage("homero_simpson.png");
		this.imagenBart = app.loadImage("bart_simpson.png");
		this.app = app;
		this.arreglo = new Personaje[4];
		this.maximoArreglo = 0;
		this.mensaje = "";

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

		app.fill(255, 0, 0);
		app.text(mensaje, app.width / 2 + 100, app.height - 100);

	}

	public void crearPersonaje() {
		int randomSuerte = (int) app.random(0, 10);
		int randomEdad = (int) app.random(0, 30);
		float randomPosX = app.random(270, 850);
		float randomPosY = app.random(250, 650);
		if (app.mouseX >= (app.width / 2 + 100) - 50 && app.mouseX <= (app.width / 2 + 100) + 50
				&& app.mouseY >= (app.height - 100) - 25 && app.mouseY <= (app.height - 100) + 25) {
			this.personajes.add(new Personaje(randomSuerte, this.imagenBart, randomEdad, randomPosX, randomPosY, app));
		}

	}

	public void agregarArreglo() throws MaximoException {
		for (int i = 0; i < personajes.size(); i++) {
			Personaje personaje = this.personajes.get(i);
			if (app.mouseX >= personaje.getPosX() - 50 && app.mouseX <= personaje.getPosX() + 50
					&& app.mouseY >= personaje.getPosY() - 150 / 2 && app.mouseY <= personaje.getPosY() + 150 / 2
					&& personaje.isAgregado() == false) {

				personaje.setAgregado(true);

				personaje.setPosX(75);
				personaje.setPosY(100 + (150 * i));

				personaje.setImagen(imagenHomero);

				for (int j = 0; j < arreglo.length; j++) {
					arreglo[maximoArreglo] = personaje;
					// System.out.println(arreglo[j].getNumeroSuerte());
				}

				maximoArreglo++;

			}

		}

	}

	/*
	 * public void maximoArreglo() throws MaximoException { if (maximoArreglo >
	 * arreglo.length) { throw new MaximoException("No se permiten más personajes");
	 * } }
	 *

	public void ordenarNumero() {

		if (app.mouseX < 200) {
			for (int i = 0; i < arreglo.length - 1; i++) {
				compararLaEdad.compare(arreglo[i], arreglo[i + 1]);
				System.out.println(arreglo[i].getNumeroSuerte());
			}
		}
	}*/

	public Personaje[] getArreglo() {
		return arreglo;
	}

	public void setArreglo(Personaje[] arreglo) {
		this.arreglo = arreglo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
