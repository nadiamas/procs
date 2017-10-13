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
import actionForm.AddTelValidationForm;
import domain.Adresse;
import domain.Contact;
import domain.DAOContact;
import domain.Telephone;




public class AddTelAction extends Action {
	

	public ActionForward execute(final ActionMapping pMapping,
	ActionForm pForm, final HttpServletRequest pRequest,
	final HttpServletResponse pResponse) throws NamingException, SQLException {
		
	
	final AddTelValidationForm lForm=(AddTelValidationForm)pForm;
	final String typeTel = lForm.getTypeTel();
	final String numTel = lForm.getNumTel();
	final String btn = lForm.getBtn();
	
	
	Telephone t = new Telephone(typeTel,numTel);
	DAOContact dao = new DAOContact();
	dao.addTelephone(t);
	return pMapping.findForward("success");
	}
	}
