import java.util.ArrayList;
import java.util.List;

public class RegistratoreTransazioni {
	private List<TransazioneEconomica> sequenzaTransazioni;
	private Valore saldo;
	
	public RegistratoreTransazioni(Valore saldoIniziale) {
		this.saldo=saldoIniziale;
		this.sequenzaTransazioni=new ArrayList<>();
	}
	
	public void addTransazione(TransazioneEconomica t) {
		this.sequenzaTransazioni.add(t);
		double totale= this.saldo.getImporto();
		double conversione= t.getValore().converti(this.saldo.getValuta());
		
		if(t.getTipoTransazione().equals(TipoTransazione.VERSAMENTO)) {
			totale+= conversione;
		} else if(t.getTipoTransazione().equals(TipoTransazione.PRELIEVO)) {
			totale-= conversione;
		}
		
 		this.saldo.setImporto(totale);
	}

	public List<TransazioneEconomica> getSequenzaTransazioni() {
		return sequenzaTransazioni;
	}

	public void setSequenzaTransazioni(List<TransazioneEconomica> sequenzaTransazioni) {
		this.sequenzaTransazioni = sequenzaTransazioni;
	}

	public Valore getSaldo() {
		return saldo;
	}

	public void setSaldo(Valore saldo) {
		this.saldo = saldo;
	}
	
	
	
}
