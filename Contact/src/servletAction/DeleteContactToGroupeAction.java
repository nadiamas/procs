package servletAction;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


import actionForm.AddContactToGroupeValidationForm;
import actionForm.DeleteContactToGroupeValidationForm;
import domain.Contact;
import services.ServiceContact;
import util.MyApplicationContext;


public class DeleteContactToGroupeAction extends Action  {
	
	public ActionForward execute(final ActionMapping pMapping,
	ActionForm pForm, final HttpServletRequest pRequest,
	final HttpServletResponse pResponse) throws ServletException, IOException {
		
	
	final DeleteContactToGroupeValidationForm lForm=(DeleteContactToGroupeValidationForm)pForm;
	final long idGroupe = lForm.getIdGroupe();
	final long idContactS = lForm.getIdContactS();
	
	final String btn = lForm.getBtn();
	ServiceContact sc = (ServiceContact) MyApplicationContext.getApplicationContext().getBean("ServiceContact");

		System.out.println("supprimer de groupe="+idGroupe +" contact ="+ idContactS);
		sc.deleteContactFromGroup(idGroupe, idContactS);
	
		 RequestDispatcher rd = pRequest.getRequestDispatcher("/pages/gestionContact.jsp");
		  List<Contact> list = sc.listContactOutsideGroup(idGroupe);
		  pRequest.setAttribute("idm", idGroupe);
		  pRequest.setAttribute("list", list);
		  rd.forward(pRequest, pResponse);
		  return null;
	}
	
}
