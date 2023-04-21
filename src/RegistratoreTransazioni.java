import java.util.ArrayList;
import java.util.List;

public class RegistratoreTransazioni {

	//possibili modifiche: mettere tasso commisione in TipoTransazione e rendero di tipo Valore in modo da poterla avere di diverse Valute
	private static final double TASSO_COMMISSIONE_PRELIEVO=0.01;
	private static final double TASSO_COMMISSIONE_VERSAMENTO=0.02;

	private List<TransazioneEconomica> sequenzaTransazioni;
	private Valore saldo;
	
	public RegistratoreTransazioni(Valore saldoIniziale) {
		this.saldo=saldoIniziale;
		this.sequenzaTransazioni=new ArrayList<>();
	}
	
	public void addTransazione(TransazioneEconomica t) {
		this.sequenzaTransazioni.add(t);
		double saldo= this.saldo.getImporto();
		double valoreTransazione= t.getValore().converti(this.saldo.getValuta());
		
		double commissione=0;
		
		switch(t.getTipoTransazione()) {
		case VERSAMENTO:
			commissione=valoreTransazione*TASSO_COMMISSIONE_VERSAMENTO;
			saldo+= valoreTransazione-commissione;
			break;
		case PRELIEVO:
			commissione=valoreTransazione*TASSO_COMMISSIONE_PRELIEVO;
			saldo-= valoreTransazione-commissione;
			break;
		}

		t.setCommissione(commissione);
 		this.saldo.setImporto(saldo);
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
