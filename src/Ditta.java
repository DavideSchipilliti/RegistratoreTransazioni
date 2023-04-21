import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDateTime;

public class Ditta {
	//classe di prova
	
	public static void main(String[] args){
		/*
		 * Valore valoreIniziale=new Valore(Valuta.EURO, 100); RegistratoreTransazioni
		 * registratore=new RegistratoreTransazioni(valoreIniziale); Valore v1=new
		 * Valore(Valuta.EURO, 20.50); TransazioneEconomica t1=new
		 * TransazioneEconomica(v1, LocalDateTime.now() , TipoTransazione.VERSAMENTO);
		 * registratore.addTransazione(t1);
		 * 
		 * Valore v2=new Valore(Valuta.EURO, 12.50); TransazioneEconomica t2=new
		 * TransazioneEconomica(v2, LocalDateTime.now() , TipoTransazione.PRELIEVO);
		 * registratore.addTransazione(t2);
		 */
		
		//acquisizione dati da stdin
		InputStreamReader input=new InputStreamReader(System.in);
		BufferedReader tastiera=new BufferedReader(input);
		
		System.out.println("Creazione nuovo Registratore di Transizioni");
		Valore valoreIniziale = getValuta(tastiera);
		RegistratoreTransazioni registratore=new RegistratoreTransazioni(valoreIniziale);
		
		//ciclo che crea e aggiunge nuove transazioni inserite dall'utente
		boolean continua=true;
		
		while(continua) {
				System.out.println("Inserimento nuova transazione");
				Valore valore=getValuta(tastiera);
				TipoTransazione tipoTransazione=getTipoTransazione(tastiera);
				TransazioneEconomica transazione=new TransazioneEconomica(valore, LocalDateTime.now() , tipoTransazione);
				registratore.addTransazione(transazione);
				
				do {
					System.out.println("Si vuole inserire una nuova transazione? (si/no)");
					try {
						String in=tastiera.readLine().toLowerCase();
						if(in.equalsIgnoreCase("no")) {
							continua=false;
							break;
						} else if(in.equalsIgnoreCase("si"))
							break;
					} catch (Exception e) {
						System.out.println("Inserimento non valido");
					}
				} while(true);
		}
		
		//stampo elenco transazioni
		System.out.println("Elenco delle Transizioni di registratore:\n" + registratore.getSequenzaTransazioni());
		
		System.out.println();
		
		//stampo il saldo
		System.out.println("Saldo di registratore: " + registratore.getSaldo());
	}

	
	//metodo che legge un valore (valuta e importo) da tastiera
	private static Valore getValuta(BufferedReader tastiera) {
		Valuta valuta=Valuta.EURO;
		Double importo=0.0;
		boolean err=false;
		
		do {
			err=false;
			System.out.print("Scrivere la valuta: ");
			try {
				valuta=Valuta.valueOf(tastiera.readLine().toUpperCase().trim());
			} catch(Exception e) {
				System.out.println("Valuta non valida");
				err=true;
			}
		} while(err);
		
		do {
			err=false;
			System.out.print("Scrivere l'importo: ");
			try {
				importo=Double.parseDouble(tastiera.readLine());
			} catch(Exception e){
				System.out.println("Importo non valido.");
				err=true;
			}
		} while(err);
		
		Valore valore=new Valore(valuta, importo);
		return valore;
	}
	
	
	//metodo che legge il tipo della transazione da tastiera
	private static TipoTransazione getTipoTransazione(BufferedReader tastiera) {
		TipoTransazione tipoTransazione=TipoTransazione.VERSAMENTO;
		boolean err=false;
		do {
			err=false;
			System.out.print("Scrivere il tipo della transazione: ");
			try {
				tipoTransazione=TipoTransazione.valueOf(tastiera.readLine().toUpperCase().trim());
			} catch(Exception e) {
				System.out.println("Tipo transazione non valido.");
				err=true;
			}
		} while(err);
		return tipoTransazione;
	}

}
