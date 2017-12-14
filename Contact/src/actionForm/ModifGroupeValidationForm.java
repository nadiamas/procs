package actionForm;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class ModifGroupeValidationForm extends ActionForm {
	
	private static final long serialVersionUID = 1L;
	
	private String[] groupe = null ; 
	private String btn = null; 
	private long idm ;
	
	
	

	public long getIdm() {
		return idm;
	}
	public void setIdm(long idm) {
		this.idm = idm;
	}
	public String getBtn() {
		return btn;
	}
	public void setBtn(String btn) {
		this.btn = btn;
	}

	public String[] getGroupe() {
		return groupe;
	}
	public void setGroupe(String[] groupe) {
		this.groupe = groupe;
	}
	

	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		
		this.btn= null ; 
		
		
		}
	
	
	
		public ActionErrors validate(
		ActionMapping mapping, HttpServletRequest request ) {
			
		ActionErrors errors = new ActionErrors();
		
		
		return errors;
}
}


		

