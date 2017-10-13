package actionForm;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class RetourValidationForm  extends ActionForm{
	
	private String btn ; 
	
	
	public String getBtn() {
		return btn;
	}


	public void setBtn(String btn) {
		this.btn = btn;
	}


	public ActionErrors validate(
			ActionMapping mapping, HttpServletRequest request ) {
			ActionErrors errors = new ActionErrors();
			if(getBtn()==null){
				errors.add("first name",new
						ActionMessage("creation.fn.error.required"));
						}
						return errors;
				
			}
	

}

