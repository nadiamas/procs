package actionForm;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class AfficheContactValidationForm extends ActionForm{
	private static final long serialVersionUID = 1L;
	
	private int idm;
	private String submit;
	
		public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
		/**
		* @return ID Returns ID
		*/
		public int getIdm() {
		return idm;
		}
		/**
		* @param l Sets the ID
		*/
		public void setIdm(int l) {
		idm = l;
		}
		
			public ActionErrors validate(
			ActionMapping mapping, HttpServletRequest request ) {
			ActionErrors errors = new ActionErrors();		
			return errors;
	}
}



