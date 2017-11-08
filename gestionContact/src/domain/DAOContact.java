package domain;

import java.security.acl.Group;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import util.HibernateUtil;

public class DAOContact {

	Session session = HibernateUtil.getSessionFactory().getCurrentSession();  
	
	public void addContact(Contact c){
		
		session.beginTransaction();            
		session.persist(c);               
		session.getTransaction().commit();
		
	}
	
	public void addAdresse(Adresse adresse){
		
		session.beginTransaction();            
		session.save(adresse);               
		session.getTransaction().commit();
	
		
	}
	public void addGroupe(Groupe groupe){
		session.getTransaction().begin();
		session.save(groupe);               
		session.getTransaction().commit();
		
	}
	public void addTelephone(Telephone tel){
	
		session.beginTransaction();            
		session.save(tel);               
		session.getTransaction().commit();
		
	}
	
	/*****  CRUD GROUPE ******/
	
	public List listGroupe(){
		session.getTransaction().begin();
		Query q = session.createQuery("from Groupe");
        List groups = q.list();
        session.getTransaction().commit();
        return groups;
	}
	
	public void deleteGroupe (Long idGroupe){
		session.getTransaction().begin();
		Groupe groupe = new Groupe(); 
		groupe = (Groupe) session.get(Groupe.class, idGroupe);
		session.delete(groupe);
		session.getTransaction().commit();
	}
	
	public void updateGroupe (Long idGroupe, String nameGroupe){
		session.getTransaction().begin();
		Groupe groupe = (Groupe) session.get(Groupe.class, idGroupe);
		groupe.setNomGroupe(nameGroupe);
		session.saveOrUpdate(groupe);
		session.getTransaction().commit();
	}
	
	/*****  CRUD CONTACT ******/
	
	
	public List listContact(){
		session.getTransaction().begin();
		Query q = session.createQuery("from Contact");
        List contacts = q.list();
        session.getTransaction().commit();
        return contacts;
	}
	
	public List SearchByID(long idContact){
		session.getTransaction().begin();
		List contacts = session.createQuery("from Contact as c where c.num = :idContact")
				.setParameter("idContact", idContact)
				.list();
        session.getTransaction().commit();
        return contacts;
	}
	
	public List SearchByName(String name){
		session.getTransaction().begin();
		List contacts = session.createCriteria(Contact.class)
							.add(Restrictions.like("nom", name))
							.list();
        session.getTransaction().commit();
        return contacts;
	}
	
	public void deleteContact (Long idContact){
		session.getTransaction().begin();
		Contact contact = (Contact) session.get(Contact.class, idContact);
		session.delete(contact);
		session.getTransaction().commit();
	}
	
	public void updateContact (Long idContact, Contact contact, Telephone tel){
		session.getTransaction().begin();
		Contact c = (Contact) session.get(Contact.class, idContact);
		c.setPrenom(contact.getPrenom());
		c.setNom(contact.getNom());
		c.setMail(contact.getMail());
		
		Adresse a = (Adresse) session.get(Adresse.class, c.getAdresse().getIdAdresse());
		a.setCodepostal(contact.getAdresse().getCodepostal());
		a.setPays(contact.getAdresse().getPays());
		a.setRue(contact.getAdresse().getRue());
		a.setVille(contact.getAdresse().getVille());
		
		Telephone t = (Telephone) session.get(Telephone.class, idContact);
		
		t.setTypeTel(tel.getTypeTel());
		t.setNumTel(tel.getNumTel());
		
		session.update(t);
		session.update(a);
		session.update(c);
		
		session.getTransaction().commit();
	}

	
	
	public void updateAdresse (Long idAdresse, Adresse adresse){
		session.getTransaction().begin();
		Adresse a = (Adresse) session.get(Adresse.class, idAdresse);	
		a.setCodepostal(adresse.getCodepostal());
		a.setPays(adresse.getPays());
		a.setRue(adresse.getRue());
		a.setVille(adresse.getVille());
		session.update(a);
		session.getTransaction().commit();
	}
	public void updateTel (Long idTel, Telephone tel){
		session.getTransaction().begin();
		Telephone t = (Telephone) session.get(Telephone.class, idTel);	
		session.saveOrUpdate(t);
		session.getTransaction().commit();
	}
	
	
	public List listTel(long idContact){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();  
		session.getTransaction().begin();
		String query = "from Telephone as t where t.contact.num = :idContact";
        List tels =session.createQuery(query)
        		.setParameter("idContact",idContact)
        		.list();
       
        session.getTransaction().commit();
        return tels;
	}
	
	
}
