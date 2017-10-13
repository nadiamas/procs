package servletAction;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import actionForm.AddContactValidationForm;
import domain.Adresse;
import domain.Contact;
import domain.DAOContact;
import domain.Telephone;




public class AddContactAction extends Action {
	

	public ActionForward execute(final ActionMapping pMapping,
	ActionForm pForm, final HttpServletRequest pRequest,
	final HttpServletResponse pResponse) throws NamingException, SQLException {
		
	
	final AddContactValidationForm lForm=(AddContactValidationForm)pForm;
	final String firstName = lForm.getFirstName();
	final String lastName = lForm.getLastName();
	final String email = lForm.getEmail();
	final String btn = lForm.getBtn();
	
	
	Contact c = new Contact( firstName, lastName, email);
	DAOContact dao = new DAOContact();
	dao.addContact(c);
	return pMapping.findForward("success");
	}
	}
