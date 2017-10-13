package servletAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import actionForm.RetourValidationForm;


public class RetourAction extends Action{
	
	public ActionForward execute(final ActionMapping pMapping,
			ActionForm pForm, final HttpServletRequest pRequest,
			final HttpServletResponse pResponse) {
				
			
			final RetourValidationForm lForm=(RetourValidationForm)pForm;
			
			final String btn = lForm.getBtn();
			// create a new Contact
			if(btn.equals("retour")){
			return pMapping.findForward("main");
			}
return null ; 
}}
