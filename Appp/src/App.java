import java.io.IOException;
import java.util.Scanner;

public class App {    
    public static void main(String[] args) throws IOException, InterruptedException {
    Menu menu = new Menu();
    boolean running = true;
    
    while (running) {
        menu.ispisiMenu();
        int opcija = menu.dohvatiOpciju();
        switch(opcija) {
        case 1: menu.prvaOpcija(); break; 
        case 2: menu.drugaOpcija(); break; 
        case 3: menu.trecaOpcija(); break; 
        case 4: menu.cetvrtaOpcija(); break; 
        case 5: menu.petaOpcija(); break; 
        case 6:	System.exit(0); break;
        default: break;
        }
        System.out.println("[ Pritisnite enter ]");
        try {System.in.read();} 
        catch (Exception e) {e.printStackTrace();}
        menu.clear();
    }
}
}
