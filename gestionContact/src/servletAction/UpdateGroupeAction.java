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


public class UpdateGroupeAction extends Action {
	
	public ActionForward execute(final ActionMapping dMapping,
			ActionForm dForm, final HttpServletRequest dRequest,
			final HttpServletResponse dResponse) throws NamingException, SQLException {
				
			
			final UpdateGroupeValidationForm lForm=(UpdateGroupeValidationForm)dForm;
			final long idm = lForm.getIdm();
			final String nom = lForm.getNomGroupe();
			final String submit = lForm.getSubmit();
			final int num = lForm.getContact();
			
			DAOContact dao = new DAOContact();
			
			Groupe g = new Groupe(idm, nom);
			if(submit.equals("Modifier")){
			dao.updateGroupe(idm, nom);
			System.out.println("groupe "+ idm + " modifié par "+ nom +"");
			return dMapping.findForward("sucmodif");
			}
			if(submit.equals("Supprimer")){
				dao.deleteGroupe(idm);
				System.out.println("groupe "+ idm + " supprime");
				return dMapping.findForward("sucsupp");
			}
			
			return null;
}
}