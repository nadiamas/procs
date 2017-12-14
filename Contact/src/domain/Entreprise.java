package domain;

import java.util.Set;

public class Entreprise extends Contact {
	
	private long numeroSiret;

	public Entreprise(long numeroSiret) {
		super();
		this.numeroSiret = numeroSiret;
	}

	public Entreprise( String nom, String prenom, String mail,long numeroSiret){
		super(nom,prenom,mail);
		this.numeroSiret=numeroSiret;
	}
	
	public long getNumeroSiret() {
		return numeroSiret;
	}

	public void setNumeroSiret(long numeroSiret) {
		this.numeroSiret = numeroSiret;
	}

}
