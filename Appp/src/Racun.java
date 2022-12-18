import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Racun {

    static int brojRacuna = 0;
    double stanjeRacuna = 0;
    ArrayList<String> prometRacuna = new ArrayList<>();

    String nazivTvrtke;
    String Adresa;
    String postanskiBroj;
    String gradSjedista;
    String oib = "";
    String odgovornaOsoba;
    String valuta = "";

    String formatRacuna;
    String redniBroj = "" + brojRacuna;

    Racun(){
        brojRacuna++;
        kreirajRacun();
        formatRacuna(); 
    }

    public void kreirajRacun() {
        Scanner skener = new Scanner(System.in);
        System.out.print("Naziv tvrtke: ");
        nazivTvrtke = skener.next();

        System.out.print("Adresa ( Ulica i broj ): ");
        Adresa = skener.next();

        System.out.print("Postanski broj: ");
        postanskiBroj = skener.next();

        System.out.print("Grad sjedista: ");
        gradSjedista = skener.next();

        while(true) {
            System.out.print("Oib: ");
            oib = skener.next();
            if(oib.length() == 11 )break;
            System.out.println("Oib mora imati 11 znamenki.");
        }

        System.out.print("Odgovorna osoba: ");
        odgovornaOsoba = skener.next();

        while(true) {
            System.out.print("Valuta (EUR ili HRK ): ");
            valuta = skener.next();
            if(valuta.toUpperCase().equals("HRK") || valuta.toUpperCase().equals("EUR")) break;
            System.out.println("Mozete odabrati za valutu samo EUR ili HRK.");
        }
    }

    public void formatRacuna() {
        Calendar calendar = Calendar. getInstance();
        int month = calendar. get(Calendar.MONTH) + 1;
        int year = calendar.get(Calendar.YEAR);

        while(redniBroj.length() < 5) {
            redniBroj = 0 + redniBroj;
        }
        formatRacuna = "BA-" + year + "-" + month + "-" + redniBroj;
    }

    public void prikaziStanjeRacuna(){
        System.out.println("Stanje racuna: " + stanjeRacuna + " " + valuta);
    }

    public void polog(double polog){
        stanjeRacuna += polog;
        prometRacuna.add("Polozili ste " + polog + " " + this.valuta + " na ovaj racun.");
    }

    public void podigni(double podigni){
        stanjeRacuna -= podigni;
        prometRacuna.add("Podignuli ste " + podigni + " " + this.valuta + " s ovog racuna.");
    }

    public void ispisiPromet(){
        if(prometRacuna.size() == 0){
            System.out.println("Jos nije bilo nikakvih transakcija.");
            return;
        }
        for(String current : prometRacuna){
            System.out.println(current);
        }
    }
}
