package servletAction;

import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import actionForm.UpdateContactValidationForm;
import domain.Adresse;
import domain.Contact;
import domain.DAOContact;
import domain.Telephone;

public class UpdateContactAction extends Action {
	
	public ActionForward execute(final ActionMapping dMapping,
			ActionForm dForm, final HttpServletRequest dRequest,
			final HttpServletResponse dResponse) throws NamingException, SQLException {
				
			
			final UpdateContactValidationForm lForm=(UpdateContactValidationForm)dForm;
			final long idm = lForm.getIdm();
			final String nom = lForm.getNom();
			final String prenom = lForm.getPrenom();
			final String mail = lForm.getMail();
			final String rue = lForm.getRue();
			final String codepostal = lForm.getCodepostal(); 
			final String ville = lForm.getVille(); 
			final String pays = lForm.getPays(); 
			final String tel = lForm.getTel();
			final String typetel=lForm.getTypetel();
			final String submit = lForm.getSubmit();
			DAOContact dao = new DAOContact();
			Contact c = new Contact(nom, prenom, mail);
			Adresse a = new Adresse(rue, ville, codepostal, pays);
			c.setAdresse(a);
			Telephone t = new Telephone(typetel, tel);
			if(submit.equals("modifier")){
			dao.updateContact(idm, c, t);
			return dMapping.findForward("sucmodif");
			}
			if(submit.equals("supprimer")){
				dao.deleteContact(idm);
				System.out.println("contact "+ idm + " supprime");
				return dMapping.findForward("sucsupp");
			}
			return null;
}
}