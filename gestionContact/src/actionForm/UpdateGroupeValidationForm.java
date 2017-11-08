package actionForm;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class UpdateGroupeValidationForm extends ActionForm{
	private static final long serialVersionUID = 1L;
	
	private int idm;
	private String nomGroupe;
	private String submit;
	private int contact; 
	

	
	
	
			public int getContact() {
		return contact;
	}




	public void setContact(int contact) {
		this.contact = contact;
	}




			public int getIdm() {
		return idm;
	}




	public void setIdm(int idm) {
		this.idm = idm;
	}




	public String getNomGroupe() {
		return nomGroupe;
	}




	public void setNomGroupe(String nomGroupe) {
		this.nomGroupe = nomGroupe;
	}




	public String getSubmit() {
		return submit;
	}




	public void setSubmit(String submit) {
		this.submit = submit;
	}




			public ActionErrors validate(
			ActionMapping mapping, HttpServletRequest request ) {
			ActionErrors errors = new ActionErrors();
			if(getIdm()==0) {
			errors.add("Id",new
			ActionMessage("creation.id.error.required"));
			}				
			if( getNomGroupe()== null || getNomGroupe().length() < 1 ) {
				errors.add("first name",new
				ActionMessage("creation.grp.error.required"));
				}
			return errors;
	}
}



