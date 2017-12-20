package services;

import domain.Adresse;
import domain.Contact;
import domain.DAOContact;
import domain.Entreprise;
import domain.Groupe;
import domain.IDaoContact;
import domain.Telephone;
import util.MyApplicationContext;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;

import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


public class ServiceContact {
	
	IDaoContact dao ;
	
	public IDaoContact getDao() {
		return dao;
	}


	public void setDao(IDaoContact dao) {
		this.dao = dao;
	}
	
	/***** CRUD Groupe *******/
	
	public boolean addGroupe(String nomGroupe){
		Groupe g = new Groupe(nomGroupe);
		dao.afficheMessage();
		return dao.addGroupe(g);
	}
	public boolean updateGroupe(long idm,String nom){
		return dao.updateGroupe(idm, nom);
	}
	
	public boolean deleteGroupe(long idm){
		return dao.deleteGroupe(idm);
	}
	public List<Groupe> listGroupe(){
		return dao.listGroupe();
	}
	
	/****** CRUD Contact **********/
	
	public boolean addContact(String numSiret, String firstName,String lastName, 
							String email, String rue, String ville, String codepostal, String pays,
							String portable , String telPort,
							String fix, String telFix,
							String groupe){
		Contact c ;
		Telephone port,fixe;
		if (Long.valueOf(numSiret) <= 0 ){
			c = new Contact( firstName, lastName, email);
		}else{
			c = new Entreprise(firstName, lastName, email, Long.valueOf(numSiret));
		}
		Adresse adresse = new Adresse(rue, ville, codepostal, pays);
		port = new Telephone(portable, telPort);
		fixe = new Telephone(fix, telFix);
		
		 return dao.addContact(c, adresse,port, fixe, groupe);
		}
	
	public List<Contact> SearchByName(String name){
		return dao.SearchByName(name);
	}
	public List SearchByID(long idContact){
		return dao.SearchByID(idContact);
	}
	
	public List<Contact> listContact(){
		return dao.listContact();
	}
	public List<Telephone> listTel(long idContact){
		return dao.listTel(idContact);
	}
	public Set<Groupe> listGRP(long idContact){
		return dao.listGRP(idContact);
	}
	public Contact getContact(long idContact){
		return dao.getContact(idContact);
	}
	
	public void updateGroupeContact(String[] groupenames, long idm){
		Contact contact = getContact(idm);
		dao.updateGroupeContact(groupenames, contact);
		}

	
	public void updateContact(long idm,String nom,String prenom,String mail,
								String rue,String ville, String codepostal,
								String pays,String telPort,String telFix,
								long numSiret){
		Contact contacttmp = getContact(idm);
		Contact c = new Contact(nom, prenom, mail);
		Adresse a = new Adresse(rue, ville, codepostal, pays);
		Telephone tp = new Telephone("portable", telPort,null);
		Telephone tf = new Telephone("fix", telFix,null);
		Set<Telephone> tels = new HashSet<>();
		tels.add(tp); tels.add(tf);
		c.setAdresse(a);

			dao.updateContact(contacttmp, c,tp,tf, numSiret);
	}

	public void deleteContact(long idm){
		dao.deleteContact(idm);
	}
	
	public String getNumTel(Long idContact, String type){
		return dao.getNumTel(idContact, type);
	}

	public String getType(long idContact){
		return dao.getType(idContact);
	}
	public long getNumSiretEntreprise(long id){
		return dao.getNumSiretEntreprise(id);
	}

	public List<Contact> listContactInGroup(long idGroup){
		return dao.listContactInGroup(idGroup);
	}
	public List<Contact> listContactOutsideGroup(long idGroup){
		return dao.listContactOutsideGroup(idGroup);
	}
	public boolean addContactToGroup(Long idGroupe, Long idContact){
		return dao.addContactToGroup(idGroupe, idContact);
	}
	public boolean deleteContactFromGroup(long idGroup, long idContact){
		return dao.deleteContactFromGroup(idGroup, idContact);
	}
	


}