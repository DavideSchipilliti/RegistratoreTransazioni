
public class Valore {
	private Valuta valuta;
	private double importo;
	
	public Valore(Valuta valuta, double importo) {	//potrei aggiungere un costruttore senza importo
		this.valuta=valuta;
		this.importo=importo;
	}
	
	public double converti(Valuta valutaInCuiConvertire) {
		double res=this.importo / valuta.getTassoCambio();
		res*= valutaInCuiConvertire.getTassoCambio();
		return res;
	}
	
	public Valuta getValuta() {
		return valuta;
	}

	public void setValuta(Valuta valuta) {
		this.valuta = valuta;
		
	}

	public double getImporto() {
		return importo;
	}

	public void setImporto(double importo) {
		this.importo = importo;
	}

	@Override
	public String toString() {
		return importo + " " + valuta;
	}
}
