package actionForm;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class AddTelValidationForm extends ActionForm {
	
	private static final long serialVersionUID = 1L;
	
	private String typeTel=null;
	private String numTel=null;
	private String btn = null; 
	
	
	
	public String getBtn() {
		return btn;
	}
	public void setBtn(String btn) {
		this.btn = btn;
	}
	
	

	public String getTypeTel() {
		return typeTel;
	}
	public void setTypeTel(String typeTel) {
		this.typeTel = typeTel;
	}
	public String getNumTel() {
		return numTel;
	}
	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}
	public void reset(ActionMapping mapping, HttpServletRequest request) {

		this.btn= null ; 
		
		
		}
	
	
	
		public ActionErrors validate(
		ActionMapping mapping, HttpServletRequest request ) {
			
		ActionErrors errors = new ActionErrors();
		if(!getBtn().equals("retour")){
			
		if( getTypeTel()== null || getTypeTel().length() < 1 ) {
		errors.add("first name",new
		ActionMessage("creation.fn.error.required"));
		}
		if( getNumTel()== null || getNumTel().length() < 1 ) {
		errors.add("last name",new
		ActionMessage("creation.ln.error.required"));
		}
	
		}
		return errors;
}
}


		

