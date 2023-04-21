import java.time.LocalDateTime;

public class TransazioneEconomica {
	
	private LocalDateTime dataTransazione;
	private Valore valore;
	private double commissione;
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

	public double getCommissione() {
		return commissione;
	}

	public void setCommissione(double commissionePrelievo) {
		this.commissione = commissionePrelievo;
	}

	public TipoTransazione getTipoTransazione() {
		return tipoTransazione;
	}

	public void setTipoTransazione(TipoTransazione tipoTransazione) {
		this.tipoTransazione = tipoTransazione;
	}

	@Override
	public String toString() {		
		return "TransazioneEconomica [dataTransazione=" + dataTransazione + ", valore=" + valore
				+ ", tipoTransazione=" + tipoTransazione + ", commissione=" + commissione + "]";
	}
}
