package domain;

import java.util.Set;

public class Entreprise extends Contact {
	
	private long numeroSiret ;

	
	public Entreprise() {
	}

	public Entreprise(long numeroSiret) {
		super();
		this.numeroSiret = numeroSiret;
	}

	public Entreprise( String nom, String prenom, String mail,long numeroSiret){
		super(nom,prenom,mail);
		this.numeroSiret=numeroSiret;
	}
	
	public Entreprise(String nom, String prenom, String mail, Set<Groupe> groups, Set<Telephone> tels,
			Adresse adresse) {
		super(nom, prenom, mail, groups, tels, adresse);
		// TODO Auto-generated constructor stub
	}

	public Entreprise(String nom, String prenom, String mail) {
		super(nom, prenom, mail);
		// TODO Auto-generated constructor stub
	}

	public long getNumeroSiret() {
		return numeroSiret;
	}

	public void setNumeroSiret(long numeroSiret) {
		this.numeroSiret = numeroSiret;
	}

}
