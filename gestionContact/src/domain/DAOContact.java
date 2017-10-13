package domain;

import org.hibernate.Session;

import util.HibernateUtil;

public class DAOContact {

	public void addContact(Contact c){
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();   
		session.beginTransaction();            
		session.save(c);               
		session.getTransaction().commit();
	}
	
	public void addAdresse(Adresse adresse){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();   
		session.beginTransaction();            
		session.save(adresse);               
		session.getTransaction().commit();
		
	}
	public void addGroupe(Groupe groupe){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();   
		session.beginTransaction();            
		session.save(groupe);               
		session.getTransaction().commit();
	}
	public void addTelephone(Telephone tel){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();   
		session.beginTransaction();            
		session.save(tel);               
		session.getTransaction().commit();
	}
	
}
