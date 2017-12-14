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
import domain.Adresse;
import domain.Contact;
import domain.Telephone;
import services.ServiceContact;
import util.HibernateUtil;
import util.MyApplicationContext;




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
	final String fix = lForm.getFix();
	final String telPort = lForm.getTelport();
	final String telFix = lForm.getTelfix();
	final String groupe = lForm.getGroupe();
	final String btn = lForm.getBtn();
	final String numSiret = lForm.getNumSiret();
	
	// create a new Contact
	Telephone t1,t2,t3;
	ServiceContact sc = (ServiceContact) MyApplicationContext.getApplicationContext().getBean("ServiceContact");
	
	if(btn.equals("save")){
		if(sc.addContact(numSiret, firstName, lastName, email, rue, ville, codepostal, pays, portable, telPort, fix, telFix, groupe))
			return pMapping.findForward("success");
		else
			return pMapping.findForward("error");
	}
	return pMapping.findForward("main");
	}}
