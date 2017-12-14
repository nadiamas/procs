package servletAction;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import actionForm.AddGroupValidationForm;
import ch.qos.logback.core.Context;
import domain.DAOContact;
import domain.Groupe;
import services.ServiceContact;
import util.MyApplicationContext;


public class AddGroupAction extends Action  {
	
	public ActionForward execute(final ActionMapping pMapping,
	ActionForm pForm, final HttpServletRequest pRequest,
	final HttpServletResponse pResponse) {
		
	
	final AddGroupValidationForm lForm=(AddGroupValidationForm)pForm;
	final String nomgroupe = lForm.getNomgroupe();
	final String btn = lForm.getBtn();
	ServiceContact sc = (ServiceContact) MyApplicationContext.getApplicationContext().getBean("ServiceContact");
	if(btn.equals("save")){
		if(sc.addGroupe(nomgroupe))
			return pMapping.findForward("successgrp");
		else
			return pMapping.findForward("error");
	}else
	return pMapping.findForward("main");
	}
}
