package model;

import java.util.ArrayList;

import java.util.Collections;

public class CountryData {
	
private ArrayList<Country> pais;

	

	public CountryData() {
		pais = new ArrayList<>();
	}
	
	public void imprimir() {
		for(Country p : pais)
			System.out.print(p.toString()+"\n");
	}
	
	public void limpiarData() {
		
		pais.clear();
	}
	
	public void orden() {
		Collections.sort(pais);
	}
	
	public void agregarPais(Country p) {
		pais.add(p);
	}
	
	
	
}
