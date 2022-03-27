package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import model.Country;
import model.CountryData;
import model.Medalla;
import model.Pais;
import model.PaisData;
import model.medal;

public class Main {
	
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		start();
	}
	
	public static void start() {
		String[] split =null;
		String string = "";
		
		try {
			
			FileInputStream file = new FileInputStream(new File("src/data/in.txt"));
			BufferedReader reader = new BufferedReader(new InputStreamReader(file));
			 string = "";
			String line;
			while((line = reader.readLine()) !=null) {
				string += line;
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		split= string.split(" ");
		int paises = Integer.parseInt(split[0].replace(" ", ""));
		CountryData data = new CountryData();
		String []info = new String[paises];
		
		for(int i= 0;i<paises;i++) {
			
			info [i]= split[i+1];
			data = orden(data,"1",info[i].split(";"),paises);
			
		}
		
		System.out.print("\n Masculino \n");
		data.imprimir();
		
		System.out.print("\n____________\n");
		data.limpiarData();	
		
		for(int i= 0;i<paises;i++) {
			
			data = orden(data,"2",info[i].split(";"),paises);
		}
		
		data.orden();
		
		System.out.print("\n Femenino \n");
		data.imprimir();
		System.out.print("\n____________\n");
		data.limpiarData();	
		for(int i= 0;i<paises;i++) {
			data = orden(data,"3",info[i].split(";"),paises);
		}
		
		data.orden();
		System.out.print("\n Masculino Y femenino \n ");
		data.imprimir();
	}
	
	
	public static CountryData orden(CountryData data,String tipo, String[] split, int paises) {
		
		data.agregarPais(new Country(split[0],new medal(Integer.parseInt(split[1])),new medal(Integer.parseInt(split[2])),
					new medal(Integer.parseInt(split[3])),new medal(Integer.parseInt(split[4])),new medal(Integer.parseInt(split[5])),
					new medal(Integer.parseInt(split[6])),tipo));
		data.orden();
		return data;
		
	}

}

