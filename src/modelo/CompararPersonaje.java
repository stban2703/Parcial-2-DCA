package modelo;

import java.util.Comparator;

public class CompararPersonaje implements Comparator<Personaje>{

	public int compare(Personaje o1, Personaje o2) {
		return o1.getNumeroSuerte() - o2.getNumeroSuerte();
	}

}
