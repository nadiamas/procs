package servletAction;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


import actionForm.AddContactToGroupeValidationForm;
import services.ServiceContact;
import util.MyApplicationContext;


public class AddContactToGroupeAction extends Action  {
	
	public ActionForward execute(final ActionMapping pMapping,
	ActionForm pForm, final HttpServletRequest pRequest,
	final HttpServletResponse pResponse) throws ServletException, IOException {
		
	
	final AddContactToGroupeValidationForm lForm=(AddContactToGroupeValidationForm)pForm;
	final long idGroupe = lForm.getIdGroupe();
	final long idContact = lForm.getIdContact();
	final String btn = lForm.getBtn();
	ServiceContact sc = (ServiceContact) MyApplicationContext.getApplicationContext().getBean("ServiceContact");

	if(btn.equals("Ajouter")){
	sc.addContactToGroup(idGroupe, idContact);
	}else
	sc.deleteContactFromGroup(idGroupe, idContact);
	
	 RequestDispatcher rd = pRequest.getRequestDispatcher("/pages/gestionContact.jsp");
	  pRequest.setAttribute("idm", idGroupe);
	  rd.forward(pRequest, pResponse);
	return null;
	}
	
}
