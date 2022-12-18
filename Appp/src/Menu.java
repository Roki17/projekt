import java.io.IOException;
import java.util.Scanner;

public class Menu{
	Scanner skener;
    Racun racun;

    Menu(){
    	skener = new Scanner(System.in);
    }
    
    public void clear() {
        try {
            if (System.getProperty("os.name").contains("Windows")) new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else System.out.println("\033[H\033[2J");
        }catch (IOException | InterruptedException exception) {}
    }
    
    public int dohvatiOpciju() {
    	String opcija="";
    	
    	while (true) {
    		opcija = skener.next();
    		if( Integer.parseInt(opcija)<7 && Integer.parseInt(opcija)>0 ) break;
    		System.out.println("Pogresan unos");
    	}
    	return Integer.parseInt(opcija);
    }
    
    public void ispisiMenu() {
        System.out.println("1. Kreiraj racun za tvrtku");
        System.out.println("2. Prikaz stanja racuna");
        System.out.println("3. Prikaz prometa na racunu");
        System.out.println("4. Polog novca na racun");
        System.out.println("5. Podizanje novca s racuna");
        System.out.println("6. Izlaz iz programa");
    }
    
    public void prvaOpcija() {
    	clear();
    	racun = new Racun();
    }
    public void drugaOpcija() {
    	clear();
        racun.prikaziStanjeRacuna();
    }
    public void trecaOpcija() {
    	clear();
        racun.ispisiPromet();
    }
    public void cetvrtaOpcija() {
    	clear();
        System.out.print("Unesite vrijednost koju zelite dodati na racun: ");
        double polog = skener.nextDouble();
        racun.polog(polog);
    }
    public void petaOpcija() {
    	clear();
        System.out.print("Unesite vrijednost koju zelite podici s racuna: ");
        double podigni = skener.nextDouble();
        racun.podigni(podigni);
    }
}

