package it.unirc.ing.alg_sdati.compito;

public class Dipendente {

	private String nome;
	private String sesso;
	private int eta;
	private int numAnniServizio;
	private String qualifica;
	private int numLingue;
	
	
	
	public Dipendente(String nome, String sesso, int eta, int numAnniServizio,
			String qualifica, int numLingue) {
		super();
		this.nome = nome;
		this.sesso = sesso;
		this.eta = eta;
		this.numAnniServizio = numAnniServizio;
		this.qualifica = qualifica;
		this.numLingue = numLingue;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSesso() {
		return sesso;
	}
	public void setSesso(String sesso) {
		this.sesso = sesso;
	}
	public int getEta() {
		return eta;
	}
	public void setEta(int eta) {
		this.eta = eta;
	}
	public int getNumAnniServizio() {
		return numAnniServizio;
	}
	public void setNumAnniServizio(int numAnniServizio) {
		this.numAnniServizio = numAnniServizio;
	}
	public String getQualifica() {
		return qualifica;
	}
	public void setQualifica(String qualifica) {
		this.qualifica = qualifica;
	}
	public int getNumLingue() {
		return numLingue;
	}
	public void setNumLingue(int numLingue) {
		this.numLingue = numLingue;
	}
	
	
}
