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
	public void updateContact (Contact contactTmp, Contact contact,Telephone tp,Telephone tf, long numSiret);
	public Contact getContact(long idContact);
	public String getNumTel(Long idContact, String type);
	public void updateGroupeContact(String[] groupeNames, Contact c);
	public String getType(long idContact);
	public long getNumSiretEntreprise(long id);
	public List<Contact> listContactInGroup(long idGroup);
	public List<Contact> listContactOutsideGroup(long idGroup);
	public Groupe getGroupe(long idGroupe);
	public boolean addContactToGroup(Long idGroupe, Long idContact);
	public boolean deleteContactFromGroup(long idGroup, long idContact);
	public void afficheMessage();
}
