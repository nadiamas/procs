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
import domain.Entreprise;
import domain.Groupe;
import actionForm.AddContactValidationForm;
import actionForm.ModifGroupeValidationForm;
import domain.Adresse;
import domain.Contact;
import domain.Telephone;
import services.ServiceContact;
import util.HibernateUtil;
import util.MyApplicationContext;




public class ModifGroupeAction extends Action {
	
 
	public ActionForward execute(final ActionMapping pMapping,
	ActionForm pForm, final HttpServletRequest pRequest,
	final HttpServletResponse pResponse) throws NamingException, SQLException {
		
	
	final ModifGroupeValidationForm lForm=(ModifGroupeValidationForm)pForm;
	
	final String[] groupe = lForm.getGroupe();
	final String btn = lForm.getBtn();
	final long idm = lForm.getIdm();
	
	ServiceContact sc = (ServiceContact) MyApplicationContext.getApplicationContext().getBean("ServiceContact");
	if(btn.equals("Enregistrer")){
		sc.updateGroupeContact(groupe, idm);
	/*Session session = HibernateUtil.getSessionFactory().getCurrentSession(); 
	session.beginTransaction();
	
	Contact contact = (Contact) session.get(Contact.class, Long.parseLong(idm));
	HashSet<Groupe> grps = new HashSet<Groupe>(); 
	
	for(String s : groupe){
		Groupe g = (Groupe) session.createCriteria(Groupe.class).add(Restrictions.like("nomGroupe", s)).uniqueResult();
		g.getContacts().add(contact);
		System.out.println("grp: "+ g.getNomGroupe());
		session.saveOrUpdate(g);
		grps.add(g);
	}
	contact.setGroups(grps);
	session.update(contact);
	session.getTransaction().commit();*/
		
	return pMapping.findForward("sucmodif");
	}
	return null;
	}}
