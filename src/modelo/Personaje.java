package modelo;

import processing.core.PApplet;
import processing.core.PImage;

public class Personaje implements Runnable {
	private int numeroSuerte;
	private PImage imagen;
	private int edad;
	private float posX;
	private float posY;
	private int velocidad;
	private int direccion;
	private boolean agregado;
	private PApplet app;

	public Personaje(int numeroSuerte, PImage imagen, int edad, float posX, float posY, PApplet app) {
		this.numeroSuerte = numeroSuerte;
		this.imagen = imagen;
		this.edad = edad;
		this.posX = posX;
		this.posY = posY;
		this.velocidad = 5;
		this.direccion = 1;
		this.agregado = false;
		this.app = app;
		
		new Thread(this).start();

	}

	public void run() {
		while(this.agregado == false) {
			mover();
			
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		

	}

	public void mover() {
		this.posX += this.velocidad * this.direccion;
		if(this.posX<=200 + 50 || posX>=app.width - 50) {
			this.direccion *= -1;
		}
	}

	public int getNumeroSuerte() {
		return numeroSuerte;
	}

	public void setNumeroSuerte(int numeroSuerte) {
		this.numeroSuerte = numeroSuerte;
	}

	public PImage getImagen() {
		return imagen;
	}

	public void setImagen(PImage imagen) {
		this.imagen = imagen;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public float getPosX() {
		return posX;
	}

	public void setPosX(float posX) {
		this.posX = posX;
	}

	public float getPosY() {
		return posY;
	}

	public void setPosY(float posY) {
		this.posY = posY;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public int getDireccion() {
		return direccion;
	}

	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}

	public boolean isAgregado() {
		return agregado;
	}

	public void setAgregado(boolean agregado) {
		this.agregado = agregado;
	}
	
}
