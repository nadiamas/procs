package domain;

import java.util.List;
import java.util.Set;

public interface IDaoContact {

	public boolean addGroupe(Groupe groupe);
	public boolean updateGroupe(long id, String nomGroupe);
	public boolean deleteGroupe(long id);
	public List<Groupe> listGroupe();
	public boolean addContact(Contact c,Adresse adresse,Telephone port,Telephone fix, String groupe);
	public List<Contact> SearchByName(String name);
	public List SearchByID(long idContact);
	public List<Contact> listContact();
	public List<Telephone> listTel(long idContact);
	public Set<Groupe> listGRP(long idContact);
	public boolean deleteContact (Long idContact);
	public void updateContact (Contact contactTmp, Contact contact, Set<Telephone> tels);
	public Contact getContact(long idContact);
	public String getNumTel(Long idContact, String type);
	public void updateGroupeContact(String[] groupeNames, Contact c);

}
