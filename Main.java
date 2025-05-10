package hf;

import hf.FajlBeolvaso;
import java.util.*;


public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		NyilvantartoRendszer rendszer = new NyilvantartoRendszer();
		
		// 2. Járatok betöltése CSV-ből
		FajlBeolvaso.beolvasJaratokCSV("jaratok.csv", rendszer);
		System.out.println(">>> DEBUG: beolvasott járatok száma = " + rendszer.getJaratok().size());

		// 1. Utas adatainak bekérése
		System.out.print("Adja meg az utas nevét: ");
		String nev = scanner.nextLine();
		System.out.print("Adja meg az utas címét: ");
		String cim = scanner.nextLine();
		System.out.print("Adja meg az utas útlevélszámát: ");
		String utlevel = scanner.nextLine();

		Utas utas = new Utas(nev, cim, utlevel);
		rendszer.hozzaadUtas(utas);

		
		
	
		/*rendszer.hozzaadJarat(new Jarat(
			"LHVKIJ2",
			"Budapest",
			"Barcelona",
			"2025.05.22. 22:30",
			"2025.05.23.01:30",
			Arrays.asList("turista"),
			Arrays.asList("wifi", "étel")
		)); 

		rendszer.hozzaadJarat(new Jarat(
			"MHIJK2",
			"Barcelona",
			"Budapest",
			"2025.05.27. 10:00",
			"2025.05.27. 13:00",
			Arrays.asList("első osztály"),
			Arrays.asList("étel", "ital", "extra poggyász")
		));*/

		// 3. Útvonal bekérése
		System.out.print("Honnan szeretnél indulni? ");
		String honnan = scanner.nextLine();
		System.out.print("Hová szeretnél utazni? ");
		String hova = scanner.nextLine();

		// 4. Megfelelő járatok kilistázása (jarat.getJaratszam() + )
		List<Jarat> talalatok = new ArrayList<>();
		System.out.println("\nElérhető járatok " + honnan + " és " + hova + " között:");
		for (Jarat jarat : rendszer.getJaratok()) {
			if (jarat.getIndulasiRepter().equalsIgnoreCase(honnan)
				&& jarat.getErkezesiRepter().equalsIgnoreCase(hova)) {
				System.out.println("- " + ": " + jarat);
				talalatok.add(jarat);
			}
		}

		if (talalatok.isEmpty()) {
			System.out.println("Nincs elérhető járat ezen az útvonalon.");
			scanner.close();
			return;
		}
		
		// 5. Járatszám bekérése
		System.out.print("\nAdd meg a kiválasztott járat számát: ");
		String valasztottJaratszam = scanner.nextLine();

		Jarat kivalasztottJarat = null;
		for (Jarat j : talalatok) {
			if (j.getJaratszam().equalsIgnoreCase(valasztottJaratszam)) {
				kivalasztottJarat = j;
				break;
			}
		}

		if (kivalasztottJarat == null) {
			System.out.println("Érvénytelen járatszám.");
			scanner.close();
			return;
		}

		// 6. Osztály bekérése
		System.out.print("Milyen osztályon szeretne utazni (pl. turista / üzleti / első osztály)? ");
		String osztaly = scanner.nextLine();

		// 7. Szolgáltatások bekérése
		System.out.print("Kér extra szolgáltatásokat? (pl. wifi, étel, ital) Vesszővel elválasztva: ");
		String szolgStr = scanner.nextLine();
		List<String> szolgaltatasok = new ArrayList<>();
		if (!szolgStr.trim().isEmpty()) {
			szolgaltatasok = Arrays.asList(szolgStr.split("\\s*,\\s*"));
		}

		// 8. Foglalás létrehozása és ár kiírása
		Foglalas foglalas = new Foglalas(utas, kivalasztottJarat, osztaly, szolgaltatasok);
		rendszer.hozzaadFoglalas(foglalas);

		System.out.println("\nA foglalás létrejött:");
		System.out.println(foglalas);

		double dij = rendszer.szamolDijat(foglalas);
		System.out.println("Fizetendő: " + dij + " Ft");

		scanner.close();
		
		
		//csv teszt
		System.out.println("Beolvasott járatok száma: " + rendszer.getJaratok().size());
		for (Jarat j : rendszer.getJaratok()) {
		    System.out.println(j);
		}
	}
		}

