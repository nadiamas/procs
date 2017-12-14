package servletAction;

import java.io.IOException;
import java.sql.SQLException;

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

import actionForm.AfficheContactValidationForm;
import actionForm.UpdateContactValidationForm;
import domain.Adresse;
import domain.Contact;
import domain.DAOContact;
import domain.Telephone;
import services.ServiceContact;
import util.HibernateUtil;
import util.MyApplicationContext;
 
public class AfficheContactAction extends Action {
	
	public ActionForward execute(final ActionMapping dMapping,
			ActionForm dForm, final HttpServletRequest dRequest,
			final HttpServletResponse dResponse) throws NamingException, SQLException, ServletException, IOException {
				
			
			final AfficheContactValidationForm lForm=(AfficheContactValidationForm)dForm;
			final long idm = lForm.getIdm();
			final String submit = lForm.getSubmit();

			ServiceContact sc = (ServiceContact) MyApplicationContext.getApplicationContext().getBean("ServiceContact");
			Contact contact = sc.getContact(idm);
			
			if (submit.equals("afficher")){
			  RequestDispatcher rd = dRequest.getRequestDispatcher("/pages/AfficheContact.jsp");
			  dRequest.setAttribute("contact", contact);
			  rd.forward(dRequest, dResponse);
			  
			}else{
				RequestDispatcher rd = dRequest.getRequestDispatcher("/pages/ModifGroupe.jsp");
				dRequest.setAttribute("contact",contact);
				rd.forward(dRequest, dResponse);
			}
			return null;
}
}