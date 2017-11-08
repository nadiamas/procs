package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class Groupe {
	
	private long  idGroupe ; 
	private String nomGroupe ;
	private Set<Contact> contacts = new HashSet<Contact>(0);
	
	
	public Groupe(long idGroupe, String nomGroupe) {
		super();
		this.idGroupe = idGroupe;
		this.nomGroupe = nomGroupe;
	}
	
	public Groupe(String nomGroupe) {
		super();
		this.nomGroupe = nomGroupe;
		 contacts = new HashSet<>();
	}
	
	
	public Groupe(){
		
	}

	public long getIdGroupe() {
		return idGroupe;
	}

	public void setIdGroupe(long idGroupe) {
		this.idGroupe = idGroupe;
	}

	public String getNomGroupe() {
		return nomGroupe;
	}

	public void setNomGroupe(String nomGroupe) {
		this.nomGroupe = nomGroupe;
	}

	public Set<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contacts == null) ? 0 : contacts.hashCode());
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
		Groupe other = (Groupe) obj;
		if (contacts == null) {
			if (other.contacts != null)
				return false;
		} else if (!contacts.equals(other.contacts))
			return false;
		return true;
	} 
	
	

}
