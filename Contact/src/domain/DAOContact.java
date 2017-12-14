package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import util.HibernateUtil;

@Transactional(readOnly = false)

public class DAOContact extends HibernateDaoSupport implements IDaoContact{	


	public DAOContact() {
		super();
	}
	
	/*****  CRUD GROUPE ******/
	
	@Override
	public boolean addGroupe(Groupe groupe) {
			try {
				getHibernateTemplate().save(groupe);
				return true;
			} catch (HibernateException e) {
				e.printStackTrace();
				return false;
			}
	}
	@Override
	public boolean updateGroupe(long id, String nomGroupe) {
		Groupe groupe;
		try {
			groupe =getHibernateTemplate().get(Groupe.class,id);
			groupe.setNomGroupe(nomGroupe);
			getHibernateTemplate().saveOrUpdate(groupe);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean deleteGroupe(long id) {
		Groupe groupe = new Groupe();
		try {
			groupe =getHibernateTemplate().get(Groupe.class,id);
			getHibernateTemplate().delete(groupe);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Groupe> listGroupe() {
		try {
			return (List<Groupe>) getHibernateTemplate().find(" from Groupe");
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}

	/********** CRUD Contact *********/
	
	@Override
	public boolean addContact(Contact c,Adresse adresse,Telephone port,Telephone fix, String groupe){
		
		c.setAdresse(adresse);
		Set<Telephone> tels = new HashSet<Telephone>();		
		HashSet<Groupe> grps = new HashSet<Groupe>();
		try{
			if(groupe != null){
			DetachedCriteria filter = DetachedCriteria.forClass(Groupe.class);
			filter.add(Restrictions.like("nomGroupe", groupe));
			Groupe g = (Groupe) getHibernateTemplate().findByCriteria(filter).get(0);
			grps.add(g); c.setGroups(grps);
			}
			port.setContact(c); tels.add(port);
			fix.setContact(c); tels.add(fix);
			c.setTels(tels);
			getHibernateTemplate().save(c);
			return true;
			
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public List SearchByID(long idContact) {
		List contacts = getHibernateTemplate().findByNamedParam("from Contact as c where c.num = :idContact", "idContact", idContact);
        return contacts;	
        }

	@Override
	@SuppressWarnings("unchecked")
	public List<Contact> SearchByName(String name){
		List<Contact> contacts = (List<Contact>) getHibernateTemplate().findByNamedParam("from Contact as c where c.nom = :nom", "nom", name);
        return contacts;
	}
	@Override
	@SuppressWarnings("unchecked")
	public List<Contact> listContact(){
		try {
			return (List<Contact>) getHibernateTemplate().find(" from Contact");
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	@SuppressWarnings("unchecked")
	public List<Telephone> listTel(long idContact){		
		String query = "from Telephone as t where t.contact.num = :idContact";
        List<Telephone> tels = (List<Telephone>) getHibernateTemplate().findByNamedParam(query, "idContact", idContact);
        return tels;
	}
	
	@Override
	public Contact getContact(long idContact){
		Contact c = (Contact) getHibernateTemplate().get(Contact.class, idContact);
		return c;
	}
	@Override
	public boolean deleteContact (Long idContact){
		Contact contact ;
		try {
			contact =getHibernateTemplate().get(Contact.class,idContact);
			getHibernateTemplate().delete(contact);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}	
	}
	
	@Override
	public String getNumTel(Long idContact, String type){
		DetachedCriteria filter = DetachedCriteria.forClass(Telephone.class);
		filter.add(Restrictions.like("contact.num", idContact));
		filter.add(Restrictions.like("typeTel",type));
		Telephone t = (Telephone) getHibernateTemplate().findByCriteria(filter).get(0);
		return t.getNumTel();
	}
	
	@Override
	public void updateContact (Contact contactTmp, Contact contact,Set<Telephone> tels){
		
		contactTmp.setNom(contact.getNom());
		contactTmp.setPrenom(contact.getPrenom());
		contactTmp.setMail(contact.getMail());
		contactTmp.getAdresse().setCodepostal((contact.getAdresse().getCodepostal()));
		contactTmp.getAdresse().setVille((contact.getAdresse().getVille()));
		contactTmp.getAdresse().setRue((contact.getAdresse().getRue()));
		contactTmp.getAdresse().setPays((contact.getAdresse().getPays()));

		if(tels != null ){
			for(Telephone t :tels){
				t.setContact(contactTmp);
				contactTmp.getTels().add(t);
			}
		}
		contactTmp.setTels(tels);
		getHibernateTemplate().merge(contactTmp);
	}
	
	@Override
	public void updateGroupeContact(String[] groupeNames, Contact c){
		for(String s : groupeNames){
			DetachedCriteria filter = DetachedCriteria.forClass(Groupe.class);
			filter.add(Restrictions.like("nomGroupe", s));
			Groupe g = (Groupe) getHibernateTemplate().findByCriteria(filter).get(0);
			c.getGroups().add(g);
		}
		getHibernateTemplate().merge(c);
	}
	
	public Set<Groupe> listGRP(long idContact){
		Contact c = (Contact) getHibernateTemplate().get(Contact.class, idContact);
        return  c.getGroups();
	}
	
	public void addTelephone(Telephone tel){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();  

		session.beginTransaction();            
		session.save(tel);               
		session.getTransaction().commit();
		
	}
	
	public void addAdresse(Adresse adresse){
		getHibernateTemplate().save(adresse);		
	}
	
	
	public void addTelToCtc(Telephone tel ,Long idContact){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();  

		session.getTransaction().begin();
		Contact c = (Contact) session.get(Contact.class, idContact);
		tel.setContact(c);
		c.getTels().add(tel);
		session.update(c);
		session.getTransaction().commit();
	}
	
	public void updateAdresse (Long idAdresse, Adresse adresse){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();  

		session.getTransaction().begin();
		Adresse a = (Adresse) session.get(Adresse.class, idAdresse);	
		a.setCodepostal(adresse.getCodepostal());
		a.setPays(adresse.getPays());
		a.setRue(adresse.getRue());
		a.setVille(adresse.getVille());
		session.update(a);
		session.getTransaction().commit();
	}
	public void updateTelPort (Long idContact, Telephone tel, String type){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();  

		Transaction tx = session.getTransaction();
		tx.begin();
		String hqlUpdate = "update Telephone t set t.numTel = :numTel where t.contact.num = :idContact and t.typeTel=:type";
		// or String hqlUpdate = "update Customer set name = :newName where name = :oldName";
		int updatedEntities = session.createQuery( hqlUpdate )
		        .setString( "numTel", tel.getNumTel() )
		        .setParameter("idContact", idContact )
		        .setParameter("type", type)
		        .executeUpdate();
		tx.commit();
	}



	
	

	
	
	
	
	
	
	
}
