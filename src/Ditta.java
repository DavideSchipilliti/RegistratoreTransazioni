import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;

public class Ditta {
	//classe di prova

	public static void main(String[] args){

		//acquisizione dati da stdin
		try ( BufferedReader tastiera=new BufferedReader(new InputStreamReader(System.in)) ){

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

				System.out.println("Inserisci 0 per uscire, 1 per inserire una nuova transazione: ");
				try {
					Integer scelta=Integer.parseInt(tastiera.readLine());
					if(scelta==0) {
						continua=false;
					}
				} catch (Exception e) {

				}
			}
			//stampo elenco transazioni
			System.out.println("Elenco delle Transizioni di registratore:");
			registratore.getSequenzaTransazioni().forEach( t -> {
				System.out.printf("%s\t%s\t%s\tcommisione:%f\n", t.getDataTransazione(), t.getTipoTransazione(), t.getValore(), t.getCommissione());
			} );

			System.out.println();

			//stampo il saldo
			System.out.println("Saldo di registratore: " + registratore.getSaldo());
		} catch (IOException e1) {
			e1.printStackTrace();
		}

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
