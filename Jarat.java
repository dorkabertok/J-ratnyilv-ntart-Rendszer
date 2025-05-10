package hf;

import java.util.List;

public class Jarat {
    private String jaratszam;
    private String indulasiRepter;
    private String erkezesiRepter;
    private String indulasiIdo;
    private String erkezesiIdo;
    private List<String> osztalyok;       // pl.: turista, üzleti
    private List<String> szolgaltatasok;  // pl.: étel, extra poggyász

    public Jarat(String jaratszam, String indulasiRepter, String erkezesiRepter,
                 String indulasiIdo, String erkezesiIdo, List<String> osztalyok,
                 List<String> szolgaltatasok) {
        this.jaratszam = jaratszam;
        this.indulasiRepter = indulasiRepter;
        this.erkezesiRepter = erkezesiRepter;
        this.indulasiIdo = indulasiIdo;
        this.erkezesiIdo = erkezesiIdo;
        this.osztalyok = osztalyok;
        this.szolgaltatasok = szolgaltatasok;
    }

    public String getJaratszam() { return jaratszam; }
    public String getIndulasiRepter() { return indulasiRepter; }
    public String getErkezesiRepter() { return erkezesiRepter; }
    public String getIndulasiIdo() { return indulasiIdo; }
    public String getErkezesiIdo() { return erkezesiIdo; }
    public List<String> getOsztalyok() { return osztalyok; }
    public List<String> getSzolgaltatasok() { return szolgaltatasok; }

    
    public String toString() {
        return 
                "járatszam: " + jaratszam  +
                ", indulási reptér: " + indulasiRepter + 
                ", érkezesi reptér: " + erkezesiRepter + 
                ", indulási idő: " + indulasiIdo + 
                ", érkezesi idő: " + erkezesiIdo + 
                ", osztályok:" + osztalyok +
                ", szolgáltatások:" + szolgaltatasok;
    }
}