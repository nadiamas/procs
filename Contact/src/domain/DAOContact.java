package domain;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.security.acl.Group;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hamcrest.core.IsInstanceOf;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import util.HibernateUtil;

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
			DetachedCriteria filter = DetachedCriteria.forClass(Contact.class).createCriteria("groups");
			filter.add(Restrictions.like("idGroupe", id));
			@SuppressWarnings("unchecked")
			List<Contact> listContactInGroup = (List<Contact>) getHibernateTemplate().findByCriteria(filter);
			for (Contact contact : listContactInGroup) {
				contact.getGroups().remove(groupe);
				getHibernateTemplate().update(contact);
			}
			groupe.setContacts(null);
			getHibernateTemplate().update(groupe);
			getHibernateTemplate().delete(groupe);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	/********** CRUD Contact *********/
	
	@Override
	public boolean addContact(Contact c,Adresse adresse,Telephone port,Telephone fix, String groupe){	
		c.setAdresse(adresse);
		Set<Telephone> tels = new HashSet<Telephone>();		
		HashSet<Groupe> grps = new HashSet<Groupe>();
		try{
			if(! groupe.equals("Groupes") ){
			DetachedCriteria filter = DetachedCriteria.forClass(Groupe.class);
			filter.add(Restrictions.like("nomGroupe", groupe));
			Groupe g = (Groupe) getHibernateTemplate().findByCriteria(filter).get(0);
			grps.add(g); c.setGroups(grps);
			}
			port.setContact(c); c.getTels().add(port);
			fix.setContact(c); c.getTels().add(fix);
			
			getHibernateTemplate().persist(c);
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
	public Groupe getGroupe(long idGroupe){
		Groupe g = (Groupe) getHibernateTemplate().get(Groupe.class, idGroupe);
		return g;
	}
	
	
	public boolean deleteContactFromAllGroup(long idContact) {
		System.out.println("Début de deleteContactFromAllGroup() avec idContact = " + idContact);
		try {
			Contact contact = getHibernateTemplate().get(Contact.class, idContact);
			List<Groupe> Groups = listGroupe();
			for (Groupe contactGroup : Groups) {
				if (contactGroup.getContacts().contains(contact)) {
					contactGroup.getContacts().remove(contact);
					getHibernateTemplate().update(contactGroup);
				}
			}
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean deleteContact (Long idContact){
		boolean result = deleteContactFromAllGroup(idContact);
		try {
			Contact c = getContact(idContact);
			getHibernateTemplate().delete(c);
			result = result && true;
			return result;
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
	public void updateContact (Contact contactTmp, Contact contact,Telephone tp,Telephone tf, long numSiret){
		
		if (numSiret <= 0) {
				contactTmp.setType("Contact");
		} else {
			if (contactTmp instanceof Entreprise) {
				((Entreprise) contactTmp).setNumeroSiret(numSiret);
			}
		}
		contactTmp.setNom(contact.getNom());
		contactTmp.setPrenom(contact.getPrenom());
		contactTmp.setMail(contact.getMail());
		contactTmp.getAdresse().setCodepostal((contact.getAdresse().getCodepostal()));
		contactTmp.getAdresse().setVille((contact.getAdresse().getVille()));
		contactTmp.getAdresse().setRue((contact.getAdresse().getRue()));
		contactTmp.getAdresse().setPays((contact.getAdresse().getPays()));
		updateTelPort(contactTmp.getNum(),tp);
		updateTelFix(contactTmp.getNum(), tf);
		
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
	
	public void updateTelPort (Long idContact, Telephone tel){
		DetachedCriteria filter = DetachedCriteria.forClass(Telephone.class);
		filter.add(Restrictions.like("contact.num", idContact));
		filter.add(Restrictions.like("typeTel", "portable"));
		Telephone telp = (Telephone) getHibernateTemplate().findByCriteria(filter).get(0);
		telp.setNumTel(tel.getNumTel());
		getHibernateTemplate().update(telp);
	}

	public void updateTelFix (Long idContact, Telephone tel){
		DetachedCriteria filter = DetachedCriteria.forClass(Telephone.class);
		filter.add(Restrictions.like("contact.num", idContact));
		filter.add(Restrictions.like("typeTel", "fix"));
		Telephone telp = (Telephone) getHibernateTemplate().findByCriteria(filter).get(0);
		telp.setNumTel(tel.getNumTel());
		getHibernateTemplate().update(telp);
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
	public long getNumSiretEntreprise(long id) {

		try {
			Entreprise entreprise = getHibernateTemplate().get(Entreprise.class, id);
			if (entreprise != null) {
				return entreprise.getNumeroSiret();
			} else {
				return 0;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public String getType(long idContact) {
		// TODO Auto-generated method stub
		if (getNumSiretEntreprise(idContact) == 0 )
			return "Contact";
		else
			return "Entreprise";
	}
	@Override
	@SuppressWarnings("unchecked")
	public List<Contact> listContactInGroup(long idGroup) {
		try {
			DetachedCriteria filter = DetachedCriteria.forClass(Contact.class).createCriteria("groups");
			filter.add(Restrictions.like("idGroupe", idGroup));
			return (List<Contact>) getHibernateTemplate().findByCriteria(filter);
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Contact> listContactOutsideGroup(long idGroup) {
		
		DetachedCriteria filter = DetachedCriteria.forClass(Contact.class).createCriteria("groups");
		filter.add(Restrictions.like("idGroupe", idGroup));
		List<Contact> listContactInGroup = (List<Contact>) getHibernateTemplate().findByCriteria(filter);
		List<Contact> listAllContact = (List<Contact>) getHibernateTemplate()
				.findByCriteria(DetachedCriteria.forClass(Contact.class));
		for (Contact contact : listContactInGroup) {
			listAllContact.remove(contact);
		}
		return listAllContact;
	}
	
	@Override
	public boolean addContactToGroup(Long idGroupe, Long idContact) {

		try {
			Groupe g = getGroupe(idGroupe);
			Contact c = getHibernateTemplate().get(Contact.class, idContact);
			g.getContacts().add(c);
			c.getGroups().add(g);
			getHibernateTemplate().saveOrUpdate(g);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean deleteContactFromGroup(long idGroup, long idContact) {
		try {
			System.out.println("gr="+idGroup);
			System.out.println("ctc="+idContact);
			Contact contact = getHibernateTemplate().get(Contact.class, idContact);
			Groupe Groupe = getHibernateTemplate().get(Groupe.class, idGroup);
			boolean result = contact.getGroups().remove(Groupe);
			boolean result2 = Groupe.getContacts().remove(contact);
			System.out.println(contact.getGroups().size());
			System.out.println(Groupe.getContacts().size());
			getHibernateTemplate().update(contact);
			getHibernateTemplate().update(Groupe);
			return result & result2;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
	public void afficheMessage(){
		System.out.println("je suis le projet PROCS");
	}

	



	
	

	
	
	
	
	
	
	
}
