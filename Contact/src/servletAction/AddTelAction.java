package servletAction;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Session;

import actionForm.AddAdresseValidationForm;
import actionForm.AddContactValidationForm;
import actionForm.AddTelValidationForm;
import domain.Adresse;
import domain.Contact;
import domain.DAOContact;
import domain.Telephone;
import util.HibernateUtil;




public class AddTelAction extends Action {
	 

	public ActionForward execute(final ActionMapping pMapping,
	ActionForm pForm, final HttpServletRequest pRequest,
	final HttpServletResponse pResponse) throws NamingException, SQLException {
		
	
	final AddTelValidationForm lForm=(AddTelValidationForm)pForm;
	final Long idm = lForm.getIdm();
	final String typeTel = lForm.getTypeTel();
	final String numTel = lForm.getTel();
	final String btn = lForm.getBtn();
	
	
	Telephone t = new Telephone(typeTel,numTel);
	DAOContact dao = new DAOContact();
	dao.addTelToCtc(t, idm);
	
	return pMapping.findForward("success");
	}
	}
