package servletAction;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import actionForm.AddGroupValidationForm;
import domain.DAOContact;
import domain.Groupe;


public class AddGroupAction extends Action  {
	
	public ActionForward execute(final ActionMapping pMapping,
	ActionForm pForm, final HttpServletRequest pRequest,
	final HttpServletResponse pResponse) {
		
	
	final AddGroupValidationForm lForm=(AddGroupValidationForm)pForm;
	final String nomgroupe = lForm.getNomgroupe();
	final String btn = lForm.getBtn();
	
	
	// create a new Contact
	if(btn.equals("save")){
	Groupe g = new Groupe( nomgroupe);
	DAOContact dao = new DAOContact();
	dao.addGroupe(g);
	}
	return pMapping.findForward("successgrp");
	}
}
