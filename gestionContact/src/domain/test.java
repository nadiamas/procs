package domain;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import util.HibernateUtil;

public class test {

	public static void main(String[] args) {

	Session session = HibernateUtil.getSessionFactory().getCurrentSession(); 
	
/*
	
	Contact c1 = new Contact();
	c1.setNom("c1");
	c1.setPrenom("c1");
	c1.setMail("cfcfcfc");
	
	Groupe g1 = new Groupe("amis");
	Groupe g2 = new Groupe("famille");
	
	Set<Groupe> groups = new HashSet<Groupe>();
	groups.add(g1);
	
	
	c1.setGroups(groups);
	
	session.beginTransaction();
	session.persist(c1);

	groups.add(g2);
	c1.setGroups(groups);

	session.persist(c1);

	
	session.persist(g1);
	session.persist(g2);

	
	//gr1.getContacts().add(c1);
	//gr1.getContacts().add(c2);
	
	//session.persist(gr1);
	
	*/
	session.beginTransaction();
	Contact c1 = new Contact();
	c1.setNom("c1");
	c1.setPrenom("c1");
	c1.setMail("cfcfcfc");
	
	/*Telephone t1 = new Telephone();
	t1.setNumTel("lkjlk");
	t1.setTypeTel("cdcd");
	t1.setContact(c1);
	
	
	session.persist(c1);
	session.persist(t1);*/
	
	Adresse ad = new Adresse("23", "bezons", "95870", "france");
	session.persist(ad);
	
	c1.setAdresse(ad);
	session.persist(c1);
	
	
	session.getTransaction().commit();
	
	}

}
