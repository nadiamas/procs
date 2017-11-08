package servletAction;
import java.security.acl.Group;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import domain.DAOContact;
import domain.Groupe;
import actionForm.AddContactValidationForm;
import domain.Adresse;
import domain.Contact;
import domain.Telephone;
import util.HibernateUtil;




public class AddContactAction extends Action {
	

	public ActionForward execute(final ActionMapping pMapping,
	ActionForm pForm, final HttpServletRequest pRequest,
	final HttpServletResponse pResponse) throws NamingException, SQLException {
		
	
	final AddContactValidationForm lForm=(AddContactValidationForm)pForm;
	final String firstName = lForm.getFirstName();
	final String lastName = lForm.getLastName();
	final String email = lForm.getEmail();
	final String rue = lForm.getRue();
	final String codepostal = lForm.getCodepostal(); 
	final String ville = lForm.getVille(); 
	final String pays = lForm.getPays(); 
	final String portable = lForm.getPortable();
	final String telport = lForm.getTelport();
	final String fix = lForm.getFix(); 
	final String telfix = lForm.getTelfix(); 
	final String[] groupe = lForm.getGroupe();
	final String btn = lForm.getBtn();
	
	// create a new Contact
	Telephone t1,t2;
	DAOContact dc = new DAOContact();
	if(btn.equals("save")){
	
	
	/*
	if(telport!=null){
		 t1 = new Telephone(portable, telport);
		 t1.setContact(c);
		 dc.addTelephone(t1);
		;}
	
	if(telfix!=null){
		 t2 = new Telephone(fix, telfix);
		 t2.setContact(c);
		 dc.addTelephone(t2);
		
	}
	dc.addContact(c);
	*/
	Session session = HibernateUtil.getSessionFactory().getCurrentSession(); 
	session.beginTransaction();
	Contact c = new Contact( firstName, lastName, email);
	Adresse adresse = new Adresse(rue, ville, codepostal, pays);
	Set<Telephone> tels = new HashSet<>();
	c.setAdresse(adresse);
	
	for(String s : groupe){
		Groupe g = (Groupe) session.createCriteria(Groupe.class).add(Restrictions.like("nomGroupe", s)).uniqueResult();
		System.out.println("grp: "+ g.getNomGroupe());
		g.getContacts().add(c);
		session.saveOrUpdate(g);
	}
	
	session.persist(c);
	
	
	if(telport!=null){
		 t1 = new Telephone(portable, telport);
		// tels.add(t1)
		 t1.setContact(c);
		 session.persist(t1);}
	
	/*if(telfix!=null){
		 t2 = new Telephone(fix, telfix);
		 //tels.add(t2);
		 t2.setContact(c);
		 session.persist(t2);
		
	}
	*/
	//c.setTels(tels);



	session.getTransaction().commit();
	
			return pMapping.findForward("main");
	}
	return null;
	}}
