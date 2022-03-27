package model;

public class Country implements Comparable<Country>{
	
	String nombre;
	private medal goldMen;
	private medal silverMen;
	private medal bronzeMen;
	
	private medal goldWoman;
	private medal silverWoman;
	private medal bronzeWoman;
	private String orden;
	
	public Country(String nombre,medal goldMen, medal silverMen,medal bronzeMen,medal goldWoman, medal silverWoman, medal bronzeWoman, String orden){
		
		this.nombre = nombre;
		this.setgoldMen(goldMen);
		this.setsilverMen(silverMen);
		this.setbronzeMen(bronzeMen);
		this.setgoldWoman(goldWoman);
		this.setsilverWoman(silverWoman);
		this.setbronzeWoman(bronzeWoman);
		this.setOrden(orden);
	}

	
	public int calcularOro() {
		
		int oros = goldMen.getCantidad()+goldWoman.getCantidad();
		return oros;
	}
	
	public int calcularPlata() {
		
		int platas = silverMen.getCantidad()+silverWoman.getCantidad();
		return platas;
	}
	
	public int calcularBronce() {
		
		int bronces = bronzeMen.getCantidad()+bronzeWoman.getCantidad();
		return bronces;
	}
	
	
	@Override
	public int compareTo(Country o) {
		Country A = this;
		Country B = o;
		int output = 0;
		if(orden.equals("1")) {
			
			 output = (int) (B.goldMen.getCantidad()-A.goldMen.getCantidad());
			if(output == 0) {
				
				output = (int) (B.silverMen.getCantidad()-A.silverMen.getCantidad());
				if(output == 0) {
					
					output = (int) (B.bronzeMen.getCantidad()-A.bronzeMen.getCantidad());
					if(output == 0) {
						
						output = B.nombre.compareTo(A.nombre);
					}
				}
			}
			
		}else if(orden.equals("2")) {
			
			output = (int) (A.goldWoman.getCantidad()-B.goldWoman.getCantidad());
			if(output == 0) {
				
				output = (int) (A.silverWoman.getCantidad()-B.silverWoman.getCantidad());
				if(output == 0) {
					
					output = (int) (A.bronzeWoman.getCantidad()-B.bronzeWoman.getCantidad());
					if(output == 0) {
						
						output = A.nombre.compareTo(B.nombre);
						output*=-1;
					}
				}
			}
			
		}else {

			output = (int) B.calcularOro()-A.calcularOro();
			if(output == 0) {
				
				output = (int) B.calcularPlata()-A.calcularPlata();
				if(output == 0) {
					
					output = (int) B.calcularBronce()-A.calcularBronce();;
					if(output == 0) {
						
						output = (B.nombre.compareTo(A.nombre));
					}
				}
			}
		}
		
		return output;
	}
	
	public String toString() {
		
		String out = "";
		if(orden.equals("1")) {
			
		 out += nombre+" "+goldMen.getCantidad()+" "+silverMen.getCantidad()+" "+ bronzeMen.getCantidad();
		 
		}else if(orden.equals("2")) {
			
		 out += nombre+" "+goldWoman.getCantidad()+" "+silverWoman.getCantidad()+" "+bronzeWoman.getCantidad();
		 
		}else {
			
			int oros = calcularOro();
			int platas = calcularPlata();
			int bronces = calcularBronce();
			out += nombre +" " + oros+" " + platas + " " + bronces;
		}
		
		return out;
	}
	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public medal getgoldMen() {
		return goldMen;
	}


	public void setgoldMen(medal goldMen) {
		this.goldMen = goldMen;
	}


	public medal getbronzeMen() {
		return bronzeMen;
	}


	public void setbronzeMen(medal bronzeMen) {
		this.bronzeMen = bronzeMen;
	}


	public medal getsilverMen() {
		return silverMen;
	}


	public void setsilverMen(medal silverMen) {
		this.silverMen = silverMen;
	}


	public medal getgoldWoman() {
		return goldWoman;
	}


	public void setgoldWoman(medal goldWoman) {
		this.goldWoman = goldWoman;
	}


	public medal getsilverWoman() {
		return silverWoman;
	}


	public void setsilverWoman(medal silverWoman) {
		this.silverWoman = silverWoman;
	}


	public medal getbronzeWoman() {
		return bronzeWoman;
	}


	public void setbronzeWoman(medal bronzeWoman) {
		this.bronzeWoman = bronzeWoman;
	}


	public String getOrden() {
		return orden;
	}


	public void setOrden(String orden) {
		this.orden = orden;
	}
}
