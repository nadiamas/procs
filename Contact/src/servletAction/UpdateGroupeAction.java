package servletAction;

import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import actionForm.UpdateGroupeValidationForm;
import domain.Adresse;
import domain.Contact;
import domain.DAOContact;
import domain.Groupe;
import domain.Telephone;
import services.ServiceContact;
import util.MyApplicationContext;


public class UpdateGroupeAction extends Action {
	
	public ActionForward execute(final ActionMapping dMapping,
			ActionForm dForm, final HttpServletRequest dRequest,
			final HttpServletResponse dResponse) throws NamingException, SQLException {
				
			
			final UpdateGroupeValidationForm lForm=(UpdateGroupeValidationForm)dForm;
			final long idm = lForm.getIdm();
			final String nom = lForm.getNomGroupe();
			final String submit = lForm.getSubmit();
			final int num = lForm.getContact();
			
			ServiceContact sc = (ServiceContact) MyApplicationContext.getApplicationContext().getBean("ServiceContact");
			if(submit.equals("Modifier")){
				if(sc.updateGroupe(idm, nom))
					return dMapping.findForward("sucmodif");
				else
					return dMapping.findForward("error");
				}
			if(submit.equals("Supprimer")){
				if(sc.deleteGroupe(idm))
					return dMapping.findForward("sucsupp");
				else
					return dMapping.findForward("error");

			}
			
			return null;
}
}