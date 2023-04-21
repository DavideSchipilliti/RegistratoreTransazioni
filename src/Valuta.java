
public enum Valuta {
	EURO(1.2),
	DOLLARO(1),
	STERLINA(1.1);
	
	private double valoreValuta;

	private Valuta(double tassoCambio) {
		this.setTassoCambio(tassoCambio);
	}

	public double getTassoCambio() {
		return valoreValuta;
	}

	public void setTassoCambio(double tassoCambio) {
		this.valoreValuta = tassoCambio;
	}

}
