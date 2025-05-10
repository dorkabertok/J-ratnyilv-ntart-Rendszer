package hf;

import java.util.List;

public class Foglalas {
	private Utas utas;
	private Jarat jarat;
	private String osztaly;
	private List<String> szolgaltatasok;
	
public Foglalas(Utas utas, Jarat jarat, String osztaly,List<String> szolgaltatasok) {
	this.utas=utas;
	this.jarat=jarat;
	this.osztaly=osztaly;
	this.szolgaltatasok=szolgaltatasok;
}

public Utas getUtas() {
	 return utas;
 }

public Jarat getJarat() {
	 return jarat;
}
public String getOsztaly() {
	 return osztaly;
}

public List<String> getSzolgaltatasok(){
	return szolgaltatasok;
}

public String toString() {
	return "Foglalás: "+ "Utas:"+ utas+ " Járat:"+ jarat+", Osztály:"+osztaly+", Szolgáltatások:"+szolgaltatasok;
}
}
