package it.unirc.ing.alg_sdati.compito;

public class Opera {

	private String codice;
	private String descrizione;
	private int etaStimata;
	private int valoreArtistico;
	private boolean prestito;
	
	
	public Opera(String codice, String descrizione, int etaStimata,
			int valoreArtistico, boolean prestito) {
		super();
		this.codice = codice;
		this.descrizione = descrizione;
		this.etaStimata = etaStimata;
		this.valoreArtistico = valoreArtistico;
		this.prestito = prestito;
	}
	
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public int getEtaStimata() {
		return etaStimata;
	}
	public void setEtaStimata(int etaStimata) {
		this.etaStimata = etaStimata;
	}
	public int getValoreArtistico() {
		return valoreArtistico;
	}
	public void setValoreArtistico(int valoreArtistico) {
		this.valoreArtistico = valoreArtistico;
	}
	public boolean isPrestito() {
		return prestito;
	}
	public void setPrestito(boolean prestito) {
		this.prestito = prestito;
	}
	
	
	
	
}
