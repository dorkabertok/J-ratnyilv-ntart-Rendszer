package hf;

import java.util.List;
import java.util.ArrayList;

public class NyilvantartoRendszer {
	private List<Utas> utasok;
	private List<Jarat> jaratok;
	private List<Foglalas> foglalasok;
	
public 	NyilvantartoRendszer() {
	this.utasok= new ArrayList<>();
	this.jaratok= new ArrayList<>();
	this.foglalasok= new ArrayList<>();
}
//hozzaadas
public void hozzaadUtas(Utas utas) {
	utasok.add(utas);
}

public void hozzaadJarat(Jarat jarat) {
	jaratok.add(jarat);
}

public void hozzaadFoglalas(Foglalas foglalas) {
	foglalasok.add(foglalas);
}

//foglalas torlese

public void torolFoglalas(Foglalas foglalas) {
	foglalasok.remove(foglalas);
}

//foglalasok listazasa

public List<Foglalas> listazFoglalasok(){
	return foglalasok;
}

//koltsegszamitas

public double szamolDijat(Foglalas foglalas) {
	double alapAr= 0.0;
	
switch (foglalas.getOsztaly().toLowerCase()) {

	case"turista":
		alapAr=30000.0;
		break;
	case"első osztály":
		alapAr=100000.0;	
		break;
	case"üzleti":
		alapAr=80000.0;
		break;
	default:
		alapAr=30000.0;
		break;
}
	double szolgaltatasokAr=foglalas.getSzolgaltatasok().size()*1200.0; //MINDEN SZOLG 1200, size: hany db
			return alapAr + szolgaltatasokAr;
}

public Utas getUtasByOkmanySzam(String okmanySzam) {
    for (Utas u : utasok) {
        if (u.getOkmanySzam().equals(okmanySzam)) return u;
    }
    return null;
}


public Jarat getJaratByJaratszam(String jsz) {
    for (Jarat j : jaratok) {
        if (j.getJaratszam().equals(jsz)) return j;
    }
    return null;
}

public List<Jarat> getJaratok() {
	return jaratok;
}

}
