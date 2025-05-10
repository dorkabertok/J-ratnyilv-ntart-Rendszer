package hf;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class FajlBeolvaso {

    public static void beolvasFoglalasokCSV(String fajlnev, NyilvantartoRendszer rendszer) {
        try (BufferedReader br = new BufferedReader(new FileReader(fajlnev))) {
            String sor = br.readLine(); // első sor: fejléc kihagyása
            while ((sor = br.readLine()) != null) {
                String[] mezok = sor.split(",");
                if (mezok.length == 4) {
                    String okmanySzam = mezok[0].trim();
                    String jaratszam = mezok[1].trim();
                    String osztaly = mezok[2].trim();
                    List<String> szolgaltatasok = Arrays.asList(mezok[3].split("\\|"));

                    Utas utas = rendszer.getUtasByOkmanySzam(okmanySzam);
                    Jarat jarat = rendszer.getJaratByJaratszam(jaratszam);

                    if (utas != null && jarat != null) {
                        Foglalas f = new Foglalas(utas, jarat, osztaly, szolgaltatasok);
                        rendszer.hozzaadFoglalas(f);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Hiba a foglalások CSV beolvasása közben: " + e.getMessage());
        }
    }

    public static void beolvasJaratokCSV(String fajlnev, NyilvantartoRendszer rendszer) {
        try (BufferedReader br = new BufferedReader(new FileReader(fajlnev))) {
            String sor = br.readLine(); // fejléc kihagyása
            while ((sor = br.readLine()) != null) {
                String[] mezok = sor.split(",");
                if (mezok.length == 7) {
                    String jaratszam = mezok[0].trim();
                    String indulasiRepter = mezok[1].trim();
                    String erkezesiRepter = mezok[2].trim();
                    String indulasiIdo = mezok[3].trim();
                    String erkezesiIdo = mezok[4].trim();
                    List<String> osztalyok = Arrays.asList(mezok[5].split("\\|"));
                    List<String> szolgaltatasok = Arrays.asList(mezok[6].split("\\|"));

                    Jarat jarat = new Jarat(
                        jaratszam,
                        indulasiRepter,
                        erkezesiRepter,
                        indulasiIdo,
                        erkezesiIdo,
                        osztalyok,
                        szolgaltatasok
                    );
                    rendszer.hozzaadJarat(jarat);
                }
            }
        } catch (IOException e) {
            System.err.println("Hiba a járatok CSV beolvasása közben: " + e.getMessage());
        }
    }
}
