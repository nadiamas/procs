package domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Version;

public class Contact {
	
	@Version
	private int version;
	private long num ; 
	private String nom ; 
	private String prenom ; 
	private String mail ;
	private Set<Groupe> groups = new HashSet<Groupe>();
	private Set<Telephone> tels = new HashSet<Telephone>();
	private Adresse adresse; 
	private String type;
	
	

	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Contact( String nom, String prenom, String mail) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		
	}

	public Contact(String nom, String prenom, String mail, Set<Groupe> groups, Set<Telephone> tels, Adresse adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.groups = groups;
		this.tels = tels;
		this.adresse = adresse;
	}


	public String getType(Contact c){
		if(c instanceof Contact)
			return "Contact";
		else
			return "Entreprise";
	}
	
	public int getVersion() {
		return version;
	}


	public void setVersion(int version) {
		this.version = version;
	}



	public Set<Telephone> getTels() {
		return tels;
	}


	public Adresse getAdresse() {
		return adresse;
	}


	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public void setTels(Set<Telephone> tels) {
		this.tels = tels;
	}


	public long getNum() {
		return num;
	}

	public void setNum(long num) {
		this.num = num;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Set<Groupe> getGroups() {
		return groups;
	}

	public void setGroups(Set<Groupe> groups) {
		this.groups = groups;
	}


	@Override
	public String toString() {
		return "Contact [num=" + num + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + ", groups=" + groups
				+ ", tels=" + tels + ", adresse=" + adresse + ", version=" + version + "]";
	}

	
}
