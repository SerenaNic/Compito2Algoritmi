package it.unirc.ing.alg_sdati.compito;

import java.util.ArrayList;

public class Sala {

	private String nomeSala;
	private ArrayList<Dipendente> dipList;
	private ArrayList<Opera> opList;
	private boolean audioGuida;

	public Sala(String nomeSala, ArrayList<Dipendente> dipList,
			ArrayList<Opera> opList, boolean audioGuida) {
		super();
		this.nomeSala = nomeSala;
		this.dipList = dipList;
		this.opList = opList;
		this.audioGuida = audioGuida;
	}

	public String getNomeSala() {
		return nomeSala;
	}
	public void setNomeSala(String nomeSala) {
		this.nomeSala = nomeSala;
	}
	public ArrayList<Dipendente> getDipList() {
		return dipList;
	}
	public void setDipList(ArrayList<Dipendente> dipList) {
		this.dipList = dipList;
	}
	public ArrayList<Opera> getOpList() {
		return opList;
	}
	public void setOpList(ArrayList<Opera> opList) {
		this.opList = opList;
	}
	public boolean isAudioGuida() {
		return audioGuida;
	}
	public void setAudioGuida(boolean audioGuida) {
		this.audioGuida = audioGuida;
	}


	public boolean equals(Sala sala) {

		if(sala.getNomeSala().equals(this.nomeSala))
			return true;
		return false;
	}

	public int numOperePrestito(int v)
	{
		int c=0;
		for (Opera o: opList)
			if(o.isPrestito()&&o.getValoreArtistico()>v)
				c++;
		return c;
	}

	public int numDonne()
	{
		int c=0;
		for(Dipendente d: dipList)
			if(d.getSesso().equals("F"))
				c++;
		return c;
	}
}
