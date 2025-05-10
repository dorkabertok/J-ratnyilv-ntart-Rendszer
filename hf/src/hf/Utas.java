package hf;

public class Utas {
	private String nev;
	private String lakcim;
	private String okmanySzam;
	
	public Utas(String nev, String lakcim, String okmanySzam) { //ez azert van ha többet hozunk letre konstri
		this.nev= nev;
		this.lakcim= lakcim;
		this.okmanySzam= okmanySzam;
	}
	public String getNev() { //mas osztalyok elerjek a nevet
		return nev;
	}
	public String getLakcim() { 
		return lakcim;
	}
	public String getOkmanySzam() { 
		return okmanySzam;
	}
	public String toString (){ 
		return  nev +", " + lakcim +", "+ okmanySzam ;
	}
}
