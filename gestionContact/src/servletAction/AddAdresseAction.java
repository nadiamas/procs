package servletAction;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import actionForm.AddAdresseValidationForm;
import actionForm.AddContactValidationForm;
import domain.Adresse;
import domain.Contact;
import domain.DAOContact;
import domain.Telephone;




public class AddAdresseAction extends Action {
	

	public ActionForward execute(final ActionMapping pMapping,
	ActionForm pForm, final HttpServletRequest pRequest,
	final HttpServletResponse pResponse) throws NamingException, SQLException {
		
	
	final AddAdresseValidationForm lForm=(AddAdresseValidationForm)pForm;
	final String rue = lForm.getRue();
	final String codePostal = lForm.getCodePostal();
	final String ville = lForm.getVille();
	final String pays = lForm.getPays();
	final String btn = lForm.getBtn();
	
	
	Adresse a = new Adresse(rue,codePostal,ville,pays);
	DAOContact dao = new DAOContact();
	dao.addAdresse(a);
	return pMapping.findForward("success");
	}
	}
