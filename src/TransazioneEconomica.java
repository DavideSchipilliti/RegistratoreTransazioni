import java.time.LocalDateTime;

public class TransazioneEconomica {
	private LocalDateTime dataTransazione;
	private Valore valore;
	private double commissionePrelievo;
	private double commisionePagamento;
	private TipoTransazione tipoTransazione;
	
	public TransazioneEconomica(Valore valore, LocalDateTime dataTransazione, TipoTransazione tipoTransazione) {
		this.valore=valore;
		this.dataTransazione=dataTransazione;
		this.tipoTransazione=tipoTransazione;
	}

	public LocalDateTime getDataTransazione() {
		return dataTransazione;
	}

	public void setDataTransazione(LocalDateTime dataTransazione) {
		this.dataTransazione = dataTransazione;
	}

	public Valore getValore() {
		return valore;
	}

	public void setValore(Valore valore) {
		this.valore = valore;
	}

	public double getCommissionePrelievo() {
		return commissionePrelievo;
	}

	public void setCommissionePrelievo(double commissionePrelievo) {
		this.commissionePrelievo = commissionePrelievo;
	}

	public double getCommisionePagamento() {
		return commisionePagamento;
	}

	public void setCommisionePagamento(double commisionePagamento) {
		this.commisionePagamento = commisionePagamento;
	}

	public TipoTransazione getTipoTransazione() {
		return tipoTransazione;
	}

	public void setTipoTransazione(TipoTransazione tipoTransazione) {
		this.tipoTransazione = tipoTransazione;
	}

	@Override
	public String toString() {
		double commissione;
		if(tipoTransazione.equals(TipoTransazione.PRELIEVO)) {
			commissione=this.commissionePrelievo;
		} else if(tipoTransazione.equals(TipoTransazione.VERSAMENTO)) {
			commissione=this.commissionePrelievo;
		} else
			commissione=0;
		
		return "TransazioneEconomica [dataTransazione=" + dataTransazione + ", valore=" + valore
				+ ", tipoTransazione=" + tipoTransazione + ", commissione=" + commissione + "]";
	}
}
