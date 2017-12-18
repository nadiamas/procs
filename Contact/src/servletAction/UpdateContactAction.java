package servletAction;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashSet;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Session;

import actionForm.UpdateContactValidationForm;
import domain.Adresse;
import domain.Contact;
import domain.DAOContact;
import domain.Telephone;
import services.ServiceContact;
import util.HibernateUtil;
import util.MyApplicationContext;

public class UpdateContactAction extends Action {
	
	public ActionForward execute(final ActionMapping dMapping,
			ActionForm dForm, final HttpServletRequest dRequest,
			final HttpServletResponse dResponse) throws NamingException, SQLException, ServletException, IOException {
				
			
			final UpdateContactValidationForm lForm=(UpdateContactValidationForm)dForm;
			final long idm = lForm.getIdm();
			final String nom = lForm.getNom();
			final String prenom = lForm.getPrenom();
			final String mail = lForm.getMail();
			final String rue = lForm.getRue();
			final String codepostal = lForm.getCodepostal(); 
			final String ville = lForm.getVille(); 
			final String pays = lForm.getPays(); 
			final String telPort = lForm.getTelPort();
			final String telFix=lForm.getTelFix();
			final String submit = lForm.getSubmit();
			
			ServiceContact sc = (ServiceContact) MyApplicationContext.getApplicationContext().getBean("ServiceContact");
			
			if(submit.equals("modifier")){
				sc.updateContact(idm, nom, prenom, mail, rue, ville, codepostal, pays, telPort, telFix);
				return dMapping.findForward("sucmodif");
			}
			if(submit.equals("supprimer")){
				sc.deleteContact(idm);
				return dMapping.findForward("sucsupp");
			}
			  
			return null;
}
}