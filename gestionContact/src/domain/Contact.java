package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Contact {
	
	private long num ; 
	private String nom ; 
	private String prenom ; 
	private String mail ;
	private Set<Groupe> groups = new HashSet<Groupe>(0);
	private Set<Telephone> tels = new HashSet<Telephone>(0);
	private Adresse adresse; 
	

	
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


	public Set<Telephone> getTels() {
		return tels;
	}


	public Adresse getAdresse() {
		return adresse;
	}


	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((groups == null) ? 0 : groups.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		if (groups == null) {
			if (other.groups != null)
				return false;
		} else if (!groups.equals(other.groups))
			return false;
		return true;
	} 
	
	
}
